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

import services.StringService;
import controllers.AbstractController;

@Controller
@RequestMapping("/string")
public class StringController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private StringService stringService;
	
	//Constructors----------------------------------------------
	
	public StringController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView stringList() {
		
		ModelAndView result;
		Collection<String> strings;
		
		strings = stringService.findAllStringsGroupByCategory();
		result = new ModelAndView("string/list");
		result.addObject("strings", strings);
		result.addObject("requestURI","string/administrator/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		String string = stringService.create();
		result = createEditModelAndView(string);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int stringId){
        ModelAndView result;
        String string;
         
        string= stringService.findOne(stringId);
        Assert.notNull(string);
        result= createEditModelAndView(string);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid String string, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(string);
        }else{
            try{
                stringService.save(string);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(string, "string.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(String string){
        ModelAndView result;
        try{
            stringService.delete(string);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(string, "string.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(String string){
        ModelAndView result;
         
        result= createEditModelAndView(string, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(String string, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("string/edit");
        result.addObject("string", string);
        result.addObject("message", message);
         
        return result;
 
    }


}
