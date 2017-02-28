package controllers;


import java.util.Collection;

import javax.validation.Valid;

import domain.BookRequest;
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
import services.LessorService;
import controllers.AbstractController;
import domain.Lessor;

@Controller
@RequestMapping("/lessor")
public class LessorController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private LessorService lessorService;
	@Autowired
    private ActorService actorService;
	
	//Constructors----------------------------------------------
	
	public LessorController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView lessorList() {
		
		ModelAndView result;
		Collection<Lessor> lessors;
		
		lessors = lessorService.findAll();
		result = new ModelAndView("lessor/list");
		result.addObject("lessors", lessors);
		result.addObject("requestURI","lessor/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Lessor lessor = lessorService.create();
		result = createEditModelAndView(lessor);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int lessorId){
        ModelAndView result;
        Lessor lessor;
         
        lessor= lessorService.findOne(lessorId);
        Assert.notNull(lessor);
        result= createEditModelAndView(lessor);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Lessor lessor, BindingResult binding){
        ModelAndView result;
         //TODO esto no funciona con el bindign, sin el va flama :S
//        if(binding.hasErrors()){
//            result= createEditModelAndView(lessor);
//        }else{
//            try{
                actorService.registerAsLessor(lessor);
                result= new ModelAndView("redirect:list.do");
//            }catch(Throwable oops){
//                result= createEditModelAndView(lessor, "lessor.commit.error");
//            }
//        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Lessor lessor){
        ModelAndView result;
        try{
            lessorService.delete(lessor);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(lessor, "lessor.commit.error");
        }
         
        return result;   
    }


    //All request ---------------------------------


    @RequestMapping(value = "/request/list", method = RequestMethod.GET)
    public ModelAndView getAllRequest() {
        ModelAndView res;

        Collection<BookRequest> requests = lessorService.getAllRequest();
        res = new ModelAndView("bookRequest/list");
        res.addObject("bookRequests", requests);

        return res;
    }

    // Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Lessor lessor){
        ModelAndView result;
         
        result= createEditModelAndView(lessor, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Lessor lessor, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("lessor/edit");
        result.addObject("lessor", lessor);
        result.addObject("message", message);
         
        return result;
 
    }

    // Properties -------------------------------------------------------

    @RequestMapping(value = "/property/list", method = RequestMethod.GET)
    public ModelAndView listProperties() {
        ModelAndView result;

        result = new ModelAndView("property/list");
        Collection<Property> properties = lessorService.getAllProperties();
        result.addObject("propertys", properties);
        result.addObject("requestURI", "property/list.do");
        return result;

    }

    //Other methods ------------------------------------

    @RequestMapping(value = "/fee", method = RequestMethod.GET)
    public ModelAndView totalFee() {
        ModelAndView res;
        Double fee = lessorService.totalFee();
        res = new ModelAndView("property/fee");
        res.addObject("text", fee);
        return res;
    }

}
