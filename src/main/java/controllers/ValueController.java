package controllers;

import domain.Attribute;
import domain.Property;
import domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.AttributeService;
import services.PropertyService;
import services.ValueService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("value")
public class ValueController extends AbstractController {


    //Services ----------------------------------------------------------------

    @Autowired
    private ValueService valueService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private PropertyService propertyService;

    //Constructors----------------------------------------------

    public ValueController() {
        super();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView AttributeList() {

        ModelAndView result;
        Collection<Value> values;
        values = valueService.findAll();
        result = new ModelAndView("value/list");
        result.addObject("values", values);
        result.addObject("requestURI", "value/list.do");

        return result;
    }


    //Create Method -----------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@RequestParam int propertyId) {

        ModelAndView result;
        Collection<Attribute> attributes = attributeService.findAll();
        Value value = valueService.create();
        propertyService.findOne(propertyId).getValues().add(value);


        valueService.save(value);
        result = createEditModelAndView(value);
        result.addObject("attributes", attributes);
        result.addObject("propertyId",propertyId);

        return result;

    }

    // Edition ---------------------------------------------------------

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int valueId) {
        ModelAndView result;
        Value value;

        value = valueService.findOne(valueId);
        Assert.notNull(value);
        result = createEditModelAndView(value);
        result.addObject("value", value);


        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
    public ModelAndView save(@Valid Value value,  BindingResult binding) {
        ModelAndView result;

        if (binding.hasErrors()) {
            result = createEditModelAndView(value);
        } else {
            try {
//                value.setProperty(propertyService.findOne(39));
              valueService.save(value);
                result = new ModelAndView("redirect:list.do");
            } catch (Throwable oops) {
                result = createEditModelAndView(value, "property.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int valueId) {
        ModelAndView result;
        Value p = valueService.findOne(valueId);

        try {
            valueService.delete(p);
            result = new ModelAndView("redirect:list.do");
        } catch (Throwable oops) {
            result = createEditModelAndView(p, "attribute.commit.error");
        }


        return result;
    }

    // Ancillary methods ------------------------------------------------

    protected ModelAndView createEditModelAndView(Value value) {
        ModelAndView result;

        result = createEditModelAndView(value, null);

        return result;
    }

    protected ModelAndView createEditModelAndView(Value value, String message) {
        ModelAndView result;

        result = new ModelAndView("value/edit");
        result.addObject("value", value);
        result.addObject("message", message);

        return result;

    }


}
