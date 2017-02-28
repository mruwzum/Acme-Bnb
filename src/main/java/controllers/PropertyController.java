package controllers;


import java.util.Collection;

import javax.validation.Valid;

import domain.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.BookRequestService;
import services.PropertyService;
import controllers.AbstractController;
import domain.Property;

@Controller
@RequestMapping("/property")
public class PropertyController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private PropertyService propertyService;

	
	//Constructors----------------------------------------------
	
	public PropertyController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView propertyList() {
		
		ModelAndView result;
		Collection<Property> propertys;
		
		propertys = propertyService.findAll();
		result = new ModelAndView("property/list");
		result.addObject("propertys", propertys);
		result.addObject("requestURI","property/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Property property = propertyService.create();
		result = createEditModelAndView(property);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int propertyId){
        ModelAndView result;
        Property property;
         
        property= propertyService.findOne(propertyId);
        Assert.notNull(property);
        result= createEditModelAndView(property);
        result.addObject("audits", property.getAudits());
        result.addObject("bookRequests", property.getBookRequests());
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Property property, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(property);
        }else{
            try{
                propertyService.save(property);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(property, "property.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Property property){
        ModelAndView result;
        try{
            propertyService.delete(property);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(property, "property.commit.error");
        }
         
        return result;   
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int propertyId) {
        ModelAndView res;
        Property p = propertyService.findOne(propertyId);
        res = new ModelAndView("property/view");
        res.addObject("name", p.getName());
        res.addObject("address", p.getAddress());
        res.addObject("audits", p.getAudits());

        return res;
    }

    // Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Property property){
        ModelAndView result;
         
        result= createEditModelAndView(property, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Property property, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("property/edit");
        result.addObject("property", property);
        result.addObject("message", message);
         
        return result;
 
    }


}
