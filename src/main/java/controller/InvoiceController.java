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

import services.InvoiceService;
import controllers.AbstractController;
import domain.Invoice;

@Controller
@RequestMapping("/invoice")
public class InvoiceController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private InvoiceService invoiceService;
	
	//Constructors----------------------------------------------
	
	public InvoiceController(){
		super();
	}
	

	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView invoiceList() {
		
		ModelAndView result;
		Collection<Invoice> invoices;
		
		invoices = invoiceService.findAllInvoicesGroupByCategory();
		result = new ModelAndView("invoice/list");
		result.addObject("invoices", invoices);
		result.addObject("requestURI","invoice/administrator/list.do");
		
		return result;
	}
	
	
	//Create Method -----------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView result;
		
		Invoice invoice = invoiceService.create();
		result = createEditModelAndView(invoice);
		
		return result;

		}
	
	 // Edition ---------------------------------------------------------
    
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int invoiceId){
        ModelAndView result;
        Invoice invoice;
         
        invoice= invoiceService.findOne(invoiceId);
        Assert.notNull(invoice);
        result= createEditModelAndView(invoice);
         
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Invoice invoice, BindingResult binding){
        ModelAndView result;
         
        if(binding.hasErrors()){
            result= createEditModelAndView(invoice);
        }else{
            try{
                invoiceService.save(invoice);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(invoice, "invoice.commit.error");
            }
        }
        return result;
    }
     
    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Invoice invoice){
        ModelAndView result;
        try{
            invoiceService.delete(invoice);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(invoice, "invoice.commit.error");
        }
         
        return result;   
    }
	
	// Ancillary methods ------------------------------------------------
    
    protected ModelAndView createEditModelAndView(Invoice invoice){
        ModelAndView result;
         
        result= createEditModelAndView(invoice, null);
         
        return result;
    }
     
    protected ModelAndView createEditModelAndView(Invoice invoice, String message){
    	ModelAndView result;
    	
        result= new ModelAndView("invoice/edit");
        result.addObject("invoice", invoice);
        result.addObject("message", message);
         
        return result;
 
    }


}
