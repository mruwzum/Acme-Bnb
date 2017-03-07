package controllers;


import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.ActorService;
import services.BookRequestService;
import services.CommentService;
import services.TenantService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tenant")
public class TenantController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private TenantService tenantService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private BookRequestService bookRequestService;
    @Autowired
    private CommentService commentService;

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
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(){

        ModelAndView result;

        Tenant tenant = tenantService.create();
        result = createEditModelAndView2(tenant);

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

    @RequestMapping(value = "/edit1", method = RequestMethod.GET)
    public ModelAndView edit() {
        ModelAndView result;
        Tenant tenant;

        tenant = tenantService.findByPrincipal();
        Assert.notNull(tenant);
        result= createEditModelAndView(tenant);

        return result;
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST, params = "save")
    public ModelAndView change2(@Valid Tenant tenant, BindingResult binding) {

        ModelAndView result;

        if (!binding.hasErrors()) {
            result = createEditModelAndView(tenant);
        } else {
            try {
                int mesActu2 = new Date(System.currentTimeMillis()).getMonth();
                if (tenant.getCreditCard().getExpirationYear().equals(2017)
                        && tenant.getCreditCard().getExpirationMonth()<=mesActu2+1){
                    result = new ModelAndView("actor/error");
                }else {
                    tenant.setUserAccount(tenantService.findByPrincipal().getUserAccount());
                    tenantService.save(tenant);
                    result = new ModelAndView("actor/success");
                }
            } catch (Throwable oops) {
                result = createEditModelAndView(tenant, "tenant.commit.error");
            }
        }
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


    //Other methods ----------------------------------------------------

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    public ModelAndView invoice(@RequestParam int bookRequestId) {
        ModelAndView res;

        BookRequest bookRequest = bookRequestService.findOne(bookRequestId);
        Invoice invoice = tenantService.getInvoiceAmmount(bookRequest);
        res = new ModelAndView("bookRequest/invoice");
        String cc = invoice.getCreditCard().getNumber();
        String ccfinal;
       if(cc.equals("")){
           ccfinal = "------------------";
       }else{
           String fin = cc.substring(13,17);
           String ast = "************";
            ccfinal = ast + fin;
       }

        res.addObject("issued", invoice.getIssuedMoment());
        res.addObject("tenant", invoice.getTenantInfo());
        res.addObject("details", invoice.getDetails());
        res.addObject("card", ccfinal);
        res.addObject("VAT", invoice.getVATNumber());
        res.addObject("total", invoice.getTotalAmount());



        return res;

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
    protected ModelAndView createEditModelAndView2(Tenant tenant){
        ModelAndView result;

        result= createEditModelAndView2(tenant, null);

        return result;
    }

    protected ModelAndView createEditModelAndView2(Tenant tenant, String message){
        ModelAndView result;

        result= new ModelAndView("tenant/register");
        result.addObject("tenant", tenant);
        result.addObject("message", message);

        return result;

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView lessorView(@RequestParam int bookRequestId) {

        ModelAndView result;
        BookRequest bookRequest = bookRequestService.findOne(bookRequestId);
        Tenant tenant = bookRequest.getTenant();
        Collection<SocialIdentity> socialIdentities = new ArrayList<>(tenant.getSocialIdentitys());
        result = new ModelAndView("tenant/view");
        result.addObject("name", tenant.getName());
        result.addObject("surname", tenant.getSurname());
        result.addObject("email", tenant.getEmail());
        result.addObject("phone", tenant.getPhone());
        result.addObject("picture", tenant.getPicture());
        result.addObject("id", tenant.getId());
        result.addObject("comments", tenant.getComments());
        result.addObject("socialIdentitys", socialIdentities);
        result.addObject("requestURI", "tenant/view.do");

        return result;
    }


    @RequestMapping(value = "/saveComment", method = RequestMethod.POST, params = "save")
    public ModelAndView savec(Comment comment) {
        ModelAndView result;

    /*   if (!binding.hasErrors()) {
            result= CommentController.createEditModelAndView(comment);
        }else{
            try{*/
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 10000));
        Comment saved = commentService.save(comment);
        Tenant target = tenantService.findOne(saved.getObjectiveId());
        target.getComments().add(comment);
        result = new ModelAndView("actor/success");
          /*  }catch(Throwable oops){
                result= CommentController.createEditModelAndView(comment, "comment.commit.error");
            }
        }*/
        return result;
    }

}
