package controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.SocialIdentityService;
import controllers.AbstractController;
import domain.SocialIdentity;

@Controller
@RequestMapping("/socialIdentity")
public class SocialIdentityController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private SocialIdentityService socialIdentityService;
	@Autowired
    private ActorService actorService;
	
	//Constructors----------------------------------------------
	
	public SocialIdentityController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView socialIdentityList() {
		
		ModelAndView result;
		Collection<SocialIdentity> socialIdentitys;
		Actor a = actorService.findByPrincipal();
		socialIdentitys = actorService.findByPrincipal().getSocialIdentitys();
		a.setSocialIdentitys(socialIdentitys);
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
                List<SocialIdentity> socialIdentities = new ArrayList<>(actorService.findByPrincipal().getSocialIdentitys());
                socialIdentities.add(socialIdentity);
                actorService.findByPrincipal().setSocialIdentitys(socialIdentities);
                socialIdentityService.save(socialIdentity);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(socialIdentity, "socialIdentity.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(int socialIdentityId) {
        ModelAndView result;
        SocialIdentity socialIdentity = socialIdentityService.findOne(socialIdentityId);
        try{
            List<SocialIdentity> socialIdentities = new ArrayList<>(actorService.findByPrincipal().getSocialIdentitys());
            socialIdentities.remove(socialIdentity);
            actorService.findByPrincipal().setSocialIdentitys(socialIdentities);
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
