package controllers;

import domain.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.CreditCardService;
import services.LessorService;


import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("creditcard")
public class CreditCardController extends AbstractController {


    //Services ----------------------------------------------------------------

    @Autowired
    private CreditCardService creditCardService;
    @Autowired
    private LessorService lessorService;


    //Constructors----------------------------------------------

    public CreditCardController() {
        super();
    }




    @RequestMapping( value="/list", method = RequestMethod.GET)
    public ModelAndView creditcardList() {

        ModelAndView result;
    Collection<CreditCard> creditCard;
        creditCard = creditCardService.findAll();
        result = new ModelAndView("credit-card/list");
        result.addObject("creditCard", creditCard);
        result.addObject("requestURI","creditcard/list.do");

        return result;
    }


    //Create Method -----------------------------------------------------------

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(){

        ModelAndView result;

        CreditCard creditCard = creditCardService.create();
        result = createEditModelAndView(creditCard);

        return result;

    }

    // Edition ---------------------------------------------------------

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int propertyId){
        ModelAndView result;
        CreditCard creditCard;

        creditCard= creditCardService.findOne(propertyId);
        Assert.notNull(creditCard);
        result= createEditModelAndView(creditCard);
        result.addObject("creditCard", creditCard);


        return result;
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid CreditCard creditCard, BindingResult binding){
        ModelAndView result;

        if(binding.hasErrors()){
            result= createEditModelAndView(creditCard);
        }else{
            try{

                creditCardService.save(creditCard);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(creditCard, "property.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam int propertyId) {
        ModelAndView result;
        CreditCard p = creditCardService.findOne(propertyId);

            try{
                creditCardService.delete(p);
                result=new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result = createEditModelAndView(p, "creditCard.commit.error");
            }



        return result;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam int propertyId) {
        ModelAndView res;
        CreditCard p = creditCardService.findOne(propertyId);
        res = new ModelAndView("credit-card/view");
        res.addObject("creditCard", p);

        return res;
    }

    // Ancillary methods ------------------------------------------------

    protected ModelAndView createEditModelAndView(CreditCard creditCard){
        ModelAndView result;

        result= createEditModelAndView(creditCard, null);

        return result;
    }

    protected ModelAndView createEditModelAndView(CreditCard creditCard, String message){
        ModelAndView result;

        result= new ModelAndView("credit-card/edit");
        result.addObject("creditCard", creditCard);
        result.addObject("message", message);

        return result;

    }


}










    // ---------------------- VIEJO

//
//    @RequestMapping(value = "/edit")
//    public ModelAndView edit() {
//        ModelAndView result;
//        CreditCard a = sponsorService.getMyCreditCard();
//        result = createEditModelAndView(a);
//        return result;
//    }
//
//
//    protected ModelAndView createEditModelAndView(CreditCard a) {
//        ModelAndView result;
//
//        result = createEditModelAndView(a, null);
//
//        return result;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST, params = "save")
//    public ModelAndView save(@Valid CreditCard creditCard, BindingResult binding) {
//        ModelAndView result;
//        creditCardService.save(creditCard);
//        result = this.edit();
//
//
//        return result;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    public ModelAndView delete(@RequestParam int creditcardID) {
//        ModelAndView result;
//        CreditCard creditCard = creditCardService.findOne(creditcardID);
//        creditCardService.delete(creditCard);
//        result = new ModelAndView("redirect:edit.do");
//
//        return result;
//    }
//
//    protected ModelAndView createEditModelAndView(CreditCard spo, String message) {
//        ModelAndView result;
//        String holderName = spo.getHolderName();
//        String brandName = spo.getBrandName();
//        Long number = spo.getNumber();
//        Integer expirationYear = spo.getExpirationYear();
//        Integer expirationMonth = spo.getExpirationMonth();
//        String CVV = spo.getCVV();
//
//        result = new ModelAndView("credit-card/edit");
//        result.addObject("creditCard", spo);
//        result.addObject("holderName", holderName);
//        result.addObject("brandName", brandName);
//        result.addObject("number", number);
//        result.addObject("expirationYear", expirationYear);
//        result.addObject("expirationMonth", expirationMonth);
//        result.addObject("CVV", CVV);
//        result.addObject("message", message);
//
//        return result;
//
//
//    }
//------------------------








