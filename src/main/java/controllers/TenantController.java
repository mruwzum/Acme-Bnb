package controllers;


import domain.Actor;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.ActorService;
import services.TenantService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/tenant")
public class TenantController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private TenantService tenantService;
    @Autowired
    private ActorService actorService;

    //Constructors----------------------------------------------

    public TenantController() {
        super();
    }


	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView tenantList() {
		
		ModelAndView result;
		Collection<Tenant> tenants;
		
		tenants = tenantService.findAll();
		result = new ModelAndView("tenant/list");
		result.addObject("tenants", tenants);
		result.addObject("requestURI","tenant/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Tenant tenant = tenantService.create();
		result = createEditModelAndView(tenant);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int tenantId){
        ModelAndView result;
        Tenant tenant;
         
        tenant= tenantService.findOne(tenantId);
        Assert.notNull(tenant);
        result= createEditModelAndView(tenant);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Tenant tenant, BindingResult binding){
        ModelAndView result;
//
//        if(binding.hasErrors()){
//            result= createEditModelAndView(tenant);
//        }else{
//            try{
                actorService.registerAsTenant(tenant);
                result= new ModelAndView("redirect:list.do");
//            }catch(Throwable oops){
//                result= createEditModelAndView(tenant, "tenant.commit.error");
//            }
//        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Tenant tenant){
        ModelAndView result;
        try{
            tenantService.delete(tenant);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(tenant, "tenant.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Tenant tenant){
        ModelAndView result;
         
        result= createEditModelAndView(tenant, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Tenant tenant, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("tenant/edit");
        result.addObject("tenant", tenant);
        result.addObject("message", message);
         
        return result;
 
    }


}
