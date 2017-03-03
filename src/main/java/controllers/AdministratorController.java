package controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import domain.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.AdministratorService;
import controllers.AbstractController;
import domain.Administrator;
import services.FeeService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {
	
	//Services ----------------------------------------------------------------


    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private FeeService feeService;
	
	//Constructors----------------------------------------------
	
	public AdministratorController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView administratorList() {
		
		ModelAndView result;
		Collection<Administrator> administrators;
		
		administrators = administratorService.findAll();
		result = new ModelAndView("administrator/list");
		result.addObject("administrators", administrators);
		result.addObject("requestURI","administrator/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Administrator administrator = administratorService.create();
		result = createEditModelAndView(administrator);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int administratorId){
        ModelAndView result;
        Administrator administrator;
         
        administrator= administratorService.findOne(administratorId);
        Assert.notNull(administrator);
        result= createEditModelAndView(administrator);
         
        return result;
    }

    @RequestMapping(value="/changeFee")
    public ModelAndView editFeeAmount(){
        ModelAndView result;

        List<Fee> fees = new ArrayList<>(feeService.findAll());
        Fee original = feeService.findOne(fees.get(0).getId());
        Administrator u = administratorService.findByPrincipal();
        Assert.notNull(u);

        result= new ModelAndView("property/feeEd");
         result.addObject("fee",original);

        return result;
    }

   @RequestMapping(value= "/saveFee", method = RequestMethod.POST, params = "save")
   public ModelAndView saveFee(@Valid Fee fee){
        ModelAndView res;
        administratorService.changeFee(fee.getValue());
        res = new ModelAndView("property/fee");
        res.addObject("text",fee.getValue());
        return res;
   }

     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Administrator administrator, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(administrator);
        }else{
            try{
                administratorService.save(administrator);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(administrator, "administrator.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Administrator administrator){
        ModelAndView result;
        try{
            administratorService.delete(administrator);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(administrator, "administrator.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Administrator administrator){
        ModelAndView result;
         
        result= createEditModelAndView(administrator, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Administrator administrator, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("administrator/edit");
        result.addObject("administrator", administrator);
        result.addObject("message", message);
         
        return result;
 
    }


}
