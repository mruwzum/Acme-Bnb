package controllers;

import domain.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.AttributeService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("attribute")
public class AttributeController extends AbstractController {


    //Services ----------------------------------------------------------------

    @Autowired
    private AttributeService attributeService;


    //Constructors----------------------------------------------

    public AttributeController() {
        super();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView AttributeList() {

        ModelAndView result;
        Collection<Attribute> attributes;
        attributes = attributeService.findAll();
        result = new ModelAndView("attribute/list");
        result.addObject("attributes", attributes);
        result.addObject("requestURI", "attribute/list.do");

        return result;
    }


    //Create Method -----------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {

        ModelAndView result;

        Attribute attribute = attributeService.create();
        result = createEditModelAndView(attribute);

        return result;

    }

    // Edition ---------------------------------------------------------

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam int attributeId) {
        ModelAndView result;
        Attribute attribute;

        attribute = attributeService.findOne(attributeId);
        Assert.notNull(attribute);
        result = createEditModelAndView(attribute);
        result.addObject("attribute", attribute);


        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
    public ModelAndView save(@Valid Attribute attribute, BindingResult binding) {
        ModelAndView result;

        if (!binding.hasErrors()) {
            result = createEditModelAndView(attribute);
        } else {
            try {
                attributeService.save(attribute);
                result = new ModelAndView("redirect:list.do");
            } catch (Throwable oops) {
                result = createEditModelAndView(attribute, "property.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int attributeId) {
        ModelAndView result;
        Attribute p = attributeService.findOne(attributeId);

        try {
            attributeService.delete(p);
            result = new ModelAndView("redirect:list.do");
        } catch (Throwable oops) {
            result = createEditModelAndView(p, "attribute.commit.error");
        }


        return result;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int attributeId) {
        ModelAndView res;
        Attribute p = attributeService.findOne(attributeId);
        res = new ModelAndView("attribute/view");
        res.addObject("attribute", p);

        return res;
    }

    // Ancillary methods ------------------------------------------------

    protected ModelAndView createEditModelAndView(Attribute attribute) {
        ModelAndView result;

        result = createEditModelAndView(attribute, null);

        return result;
    }

    protected ModelAndView createEditModelAndView(Attribute attribute, String message) {
        ModelAndView result;

        result = new ModelAndView("attribute/edit");
        result.addObject("attribute", attribute);
        result.addObject("message", message);

        return result;

    }


}
