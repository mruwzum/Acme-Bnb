package controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import domain.Property;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.BookRequestService;
import controllers.AbstractController;
import domain.BookRequest;
import services.PropertyService;
import services.TenantService;

@Controller
@RequestMapping("/bookRequest")
public class BookRequestController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private BookRequestService bookRequestService;
	@Autowired
    private PropertyService propertyService;
	@Autowired
    private TenantService tenantService;
	
	//Constructors----------------------------------------------
	
	public BookRequestController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView bookRequestList() {
		
		ModelAndView result;
		Collection<BookRequest> bookRequests;

		bookRequests = bookRequestService.findAll();
		result = new ModelAndView("bookRequest/list");
		result.addObject("bookRequests", bookRequests);
		result.addObject("requestURI","bookRequest/list.do");
		
		return result;
	}
    @RequestMapping( value="/listMy", method = RequestMethod.GET)
    public ModelAndView myBookRequestList() {

        ModelAndView result;
        Collection<BookRequest> bookRequests;
        Tenant t = tenantService.findByPrincipal();
        List<BookRequest> bookRequests1 = new ArrayList<>(t.getBookRequests());
        bookRequests = bookRequestService.findAll();
        result = new ModelAndView("bookRequest/list");
        result.addObject("bookRequests", bookRequests1);
        result.addObject("requestURI","bookRequest/list.do");

        return result;
    }

    @RequestMapping(value = "/createRequest", method = RequestMethod.GET)
    public ModelAndView create(@RequestParam int propertyId){

        ModelAndView result;
        Tenant t = tenantService.findByPrincipal();
        BookRequest bookRequest = bookRequestService.create();
        Property p = propertyService.findOne(propertyId);
        bookRequest.setProperty(p);
        bookRequest.setTenant(t);
        result = createEditModelAndView(bookRequest);

        return result;

    }
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		BookRequest bookRequest = bookRequestService.create();
		result = createEditModelAndView(bookRequest);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int bookRequestId){
        ModelAndView result;
        BookRequest bookRequest;
         
        bookRequest= bookRequestService.findOne(bookRequestId);
        Assert.notNull(bookRequest);
        result= createEditModelAndView(bookRequest);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid BookRequest bookRequest, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(bookRequest);
        }else{
            try{
                bookRequestService.save(bookRequest);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(bookRequest, "bookRequest.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(BookRequest bookRequest){
        ModelAndView result;
        try{
            bookRequestService.delete(bookRequest);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(bookRequest, "bookRequest.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(BookRequest bookRequest){
        ModelAndView result;
         
        result= createEditModelAndView(bookRequest, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(BookRequest bookRequest, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("bookRequest/edit");
        result.addObject("bookRequest", bookRequest);
        result.addObject("message", message);
         
        return result;
 
    }


}
