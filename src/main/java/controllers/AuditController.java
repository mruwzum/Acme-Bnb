package controllers;


import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import domain.Auditor;
import domain.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.AuditService;
import controllers.AbstractController;
import domain.Audit;
import services.AuditorService;
import services.PropertyService;

@Controller
@RequestMapping("/audit")
public class AuditController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private AuditService auditService;
	@Autowired
    private PropertyService propertyService;
	@Autowired
    private AuditorService auditorService;
	
	//Constructors----------------------------------------------
	
	public AuditController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView auditList() {
		
		ModelAndView result;
		Collection<Audit> audits;
		
		audits = auditService.findAll();
		result = new ModelAndView("audit/list");
		result.addObject("audits", audits);
		result.addObject("requestURI","audit/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Audit audit = auditService.create();
		result = createEditModelAndView(audit);
		
		return result;

		}

    @RequestMapping(value = "/createFromProp", method = RequestMethod.GET)
    public ModelAndView createFromProperty(@RequestParam int propertyId){

        ModelAndView result;
        Property property = propertyService.findOne(propertyId);
        Audit audit = auditService.create();
        audit.setProperty(property);
        audit.setWrittenMoment(new Date(System.currentTimeMillis()-100));
        Auditor auditor = auditorService.findByPrincipal();
        audit.setAuditor(auditor);
        result = createEditModelAndView(audit);

        return result;

    }
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int auditId){
        ModelAndView result;
        Audit audit;
         
        audit= auditService.findOne(auditId);
        Assert.notNull(audit);
        result= createEditModelAndView(audit);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Audit audit, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(audit);
        }else{
            try{
                auditService.save(audit);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(audit, "audit.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Audit audit){
        ModelAndView result;
        try{
            auditService.delete(audit);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(audit, "audit.commit.error");
        }
         
        return result;   
    }


    @RequestMapping(value="/draft.do", method=RequestMethod.GET, params="cancel")
    public ModelAndView cancelAndSaveDraft(Audit audit){
        ModelAndView result;
                auditService.save(audit);
                result= new ModelAndView("redirect:list.do");

        return result;

    }
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Audit audit){
        ModelAndView result;
         
        result= createEditModelAndView(audit, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Audit audit, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("audit/edit");
        result.addObject("audit", audit);
        result.addObject("message", message);
         
        return result;
 
    }


}
