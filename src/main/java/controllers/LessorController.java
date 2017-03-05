package controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

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
import services.LessorService;
import services.PropertyService;

@Controller
@RequestMapping("/lessor")
public class LessorController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private LessorService lessorService;
	@Autowired
    private ActorService actorService;
	@Autowired
    private PropertyService propertyService;
    @Autowired
    private BookRequestService bookRequestService;

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

    @RequestMapping( value="/view", method = RequestMethod.GET)
    public ModelAndView lessorView(@RequestParam int propertyId) {

        ModelAndView result;
        Property property =propertyService.findOne(propertyId);
        Lessor lessor = property.getLessor();
        Collection<SocialIdentity> socialIdentities = new ArrayList<>(lessor.getSocialIdentitys());
        result = new ModelAndView("lessor/view");
        result.addObject("name", lessor.getName());
        result.addObject("surname",lessor.getSurname());
        result.addObject("email",lessor.getEmail());
        result.addObject("phone",lessor.getPhone());
        result.addObject("picture",lessor.getPicture());
        result.addObject("socialIdentitys",socialIdentities);
        result.addObject("requestURI","lessor/view.do");

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

    @RequestMapping(value = "/edit1", method = RequestMethod.GET)
    public ModelAndView edit() {
        ModelAndView result;
        Lessor lessor;

        lessor = lessorService.findByPrincipal();
        Assert.notNull(lessor);
        result= createEditModelAndView(lessor);
         
        return result;
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST, params = "save")
    public ModelAndView change(@Valid Lessor lessor, BindingResult binding) {

        ModelAndView result;

        if (!binding.hasErrors()) {
            result = createEditModelAndView(lessor);
        } else {
            try {
                int mesActu = new Date(System.currentTimeMillis()).getMonth();
                if (lessor.getCreditCard().getExpirationYear().equals(2017)
                        && lessor.getCreditCard().getExpirationMonth()<=mesActu+1){
                    result = new ModelAndView("actor/error");
                }else{
                    lessor.setUserAccount(lessorService.findByPrincipal().getUserAccount());
                    lessorService.save(lessor);
                    result = new ModelAndView("actor/success");
                }

            } catch (Throwable oops) {
                result = createEditModelAndView(lessor, "lessor.commit.error");
            }
        }
        return result;
    }


    // Registering --------------------------------------------------------
     
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

    // Delete --------------------------------------------------------

    @RequestMapping(value = "/delete", method = RequestMethod.POST, params = "delete")
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
        Collection<BookRequest> peding = lessorService.getPendingRequest();
        res = new ModelAndView("bookRequest/list");
        res.addObject("bookRequests", requests);
        res.addObject("bookRequestsP", peding);

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
        Boolean mia = Boolean.TRUE;
        result.addObject("propertys", properties);
        result.addObject("requestURI", "property/list.do");
        result.addObject("mia", mia);
        return result;

    }

    //Total ammount of fee------------------------------------

    @RequestMapping(value = "/fee", method = RequestMethod.GET)
    public ModelAndView totalFee() {
        ModelAndView res;
        Double fee = lessorService.totalFee();
        res = new ModelAndView("property/fee");
        res.addObject("text", fee);
        return res;
    }

    // Status of request -------------------------------------------------------

    @RequestMapping(value = "/accept", method = RequestMethod.GET)
    public ModelAndView acceptRequest(@RequestParam int bookRequestId) {

        ModelAndView res;
        BookRequest bookRequest = bookRequestService.findOne(bookRequestId);
        bookRequest.setStatus(RequestStatus.ACCEPTED);
        bookRequestService.save(bookRequest);
        res = new ModelAndView("actor/success");

        return res;
    }

    @RequestMapping(value = "/deny", method = RequestMethod.GET)
    public ModelAndView denyeRequest(@RequestParam int bookRequestId) {

        ModelAndView res;
        BookRequest bookRequest = bookRequestService.findOne(bookRequestId);
        bookRequest.setStatus(RequestStatus.DENIED);
        bookRequestService.save(bookRequest);
        res = new ModelAndView("actor/success");

        return res;
    }
}
