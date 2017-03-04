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

import services.ActorService;
import services.AuditorService;
import controllers.AbstractController;
import domain.Auditor;

@Controller
@RequestMapping("/auditor")
public class AuditorController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private AuditorService auditorService;
	@Autowired
    private ActorService actorService;
	
	//Constructors----------------------------------------------
	
	public AuditorController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView auditorList() {
		
		ModelAndView result;
		Collection<Auditor> auditors;
		
		auditors = auditorService.findAll();
		result = new ModelAndView("auditor/list");
		result.addObject("auditors", auditors);
		result.addObject("requestURI","auditor/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Auditor auditor = auditorService.create();
		result = createEditModelAndView(auditor);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
     @RequestMapping(value = "/edit1", method = RequestMethod.GET)
     public ModelAndView edit() {
         ModelAndView result;
         Auditor auditor;

         auditor = auditorService.findByPrincipal();
         Assert.notNull(auditor);
         result = createEditModelAndView(auditor);

         return result;
     }

    @RequestMapping(value = "/change", method = RequestMethod.POST, params = "save")
    public ModelAndView change(@Valid Auditor auditor, BindingResult binding) {

        ModelAndView result;

        if (!binding.hasErrors()) {
            result = createEditModelAndView(auditor);
        } else {
            try {
                auditor.setUserAccount(auditorService.findByPrincipal().getUserAccount());
                auditorService.save(auditor);
                result = new ModelAndView("actor/success");
            } catch (Throwable oops) {
                result = createEditModelAndView(auditor, "auditor.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Auditor auditor, BindingResult binding){
        ModelAndView result;
         
//        if(binding.hasErrors()){
//            result= createEditModelAndView(auditor);
//        }else{
//            try{
                actorService.registerAsAuditor(auditor);
                result= new ModelAndView("redirect:list.do");
//            }catch(Throwable oops){
//                result= createEditModelAndView(auditor, "auditor.commit.error");
//            }
//        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Auditor auditor){
        ModelAndView result;
        try{
            auditorService.delete(auditor);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(auditor, "auditor.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Auditor auditor){
        ModelAndView result;
         
        result= createEditModelAndView(auditor, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Auditor auditor, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("auditor/edit");
        result.addObject("auditor", auditor);
        result.addObject("message", message);
         
        return result;
 
    }


}
