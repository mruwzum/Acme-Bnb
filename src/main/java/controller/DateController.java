package controllers.administrator;


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

import services.DateService;
import controllers.AbstractController;

@Controller
@RequestMapping("/date")
public class DateController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private DateService dateService;
	
	//Constructors----------------------------------------------
	
	public DateController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView dateList() {
		
		ModelAndView result;
		Collection<Date> dates;
		
		dates = dateService.findAllDatesGroupByCategory();
		result = new ModelAndView("date/list");
		result.addObject("dates", dates);
		result.addObject("requestURI","date/administrator/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Date date = dateService.create();
		result = createEditModelAndView(date);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int dateId){
        ModelAndView result;
        Date date;
         
        date= dateService.findOne(dateId);
        Assert.notNull(date);
        result= createEditModelAndView(date);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Date date, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(date);
        }else{
            try{
                dateService.save(date);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(date, "date.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Date date){
        ModelAndView result;
        try{
            dateService.delete(date);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(date, "date.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Date date){
        ModelAndView result;
         
        result= createEditModelAndView(date, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Date date, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("date/edit");
        result.addObject("date", date);
        result.addObject("message", message);
         
        return result;
 
    }


}
