package controllers;


import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.SocialIdentityService;
import controllers.AbstractController;
import domain.SocialIdentity;

@Controller
@RequestMapping("/socialIdentity")
public class SocialIdentityController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private SocialIdentityService socialIdentityService;
	
	//Constructors----------------------------------------------
	
	public SocialIdentityController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView socialIdentityList() {
		
		ModelAndView result;
		Collection<SocialIdentity> socialIdentitys;
		
		socialIdentitys = socialIdentityService.findAll();
		result = new ModelAndView("socialIdentity/list");
		result.addObject("socialIdentitys", socialIdentitys);
		result.addObject("requestURI","socialIdentity/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		SocialIdentity socialIdentity = socialIdentityService.create();
		result = createEditModelAndView(socialIdentity);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int socialIdentityId){
        ModelAndView result;
        SocialIdentity socialIdentity;
         
        socialIdentity= socialIdentityService.findOne(socialIdentityId);
        Assert.notNull(socialIdentity);
        result= createEditModelAndView(socialIdentity);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid SocialIdentity socialIdentity, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(socialIdentity);
        }else{
            try{
                socialIdentityService.save(socialIdentity);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(socialIdentity, "socialIdentity.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/delete", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(SocialIdentity socialIdentity){
        ModelAndView result;
        try{
            socialIdentityService.delete(socialIdentity);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(socialIdentity, "socialIdentity.commit.error");
        }
         
        return result;   
    }

	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(SocialIdentity socialIdentity){
        ModelAndView result;
         
        result= createEditModelAndView(socialIdentity, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(SocialIdentity socialIdentity, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("socialIdentity/edit");
        result.addObject("socialIdentity", socialIdentity);
        result.addObject("message", message);
         
        return result;
 
    }


}
