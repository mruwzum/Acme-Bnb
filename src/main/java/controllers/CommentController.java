package controllers;


import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import domain.BookRequest;
import domain.DomainEntity;
import domain.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import security.Authority;
import services.*;
import controllers.AbstractController;
import domain.Comment;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {
	
	//Services ----------------------------------------------------------------
	
	@Autowired
	private CommentService commentService;
    @Autowired
    private ActorService actorService;
    @Autowired
    private LessorService lessorService;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private BookRequestService bookRequestService;


	
	//Constructors----------------------------------------------
	
	public CommentController(){
		super();
	}
	
    protected static ModelAndView createEditModelAndView(Comment comment) {
        ModelAndView result;

        result= createEditModelAndView(comment, null);

        return result;
    }
	
	
	//Create Method -----------------------------------------------------------
	
    protected static ModelAndView createEditModelAndView(Comment comment, String message) {
        ModelAndView result;

        result= new ModelAndView("comment/edit");
        result.addObject("comment", comment);
        result.addObject("message", message);

        return result;

    }

    protected static ModelAndView createEditModelAndView2(Comment comment) {
        ModelAndView result;

        result= createEditModelAndView2(comment, null);

        return result;
    }
	 // Edition ---------------------------------------------------------
    
    protected static ModelAndView createEditModelAndView2(Comment comment, String message) {
        ModelAndView result;

        result= new ModelAndView("comment/editLess");
        result.addObject("comment", comment);
        result.addObject("message", message);

        return result;

    }
     
	@RequestMapping( value="/list", method = RequestMethod.GET)
	public ModelAndView commentList() {

		ModelAndView result;
		Collection<Comment> comments;

		comments = commentService.findAll();
		result = new ModelAndView("comment/list");
		result.addObject("comments", comments);
		result.addObject("requestURI","comment/list.do");

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@RequestParam int id) {

        ModelAndView result;

		Comment comment = commentService.create();
        comment.setObjectiveId(id);
        result = createEditModelAndView(comment);

		return result;

		}
	
	// Ancillary methods ------------------------------------------------

    @RequestMapping(value = "/createLess", method = RequestMethod.GET)
    public ModelAndView createLess(@RequestParam int id) {

        ModelAndView result;

        Comment comment = commentService.create();
        comment.setObjectiveId(id);
        result = createEditModelAndView2(comment);

        return result;

    }

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public ModelAndView edit(@RequestParam int commentId){
        ModelAndView result;
        Comment comment;

        comment= commentService.findOne(commentId);
        Assert.notNull(comment);
        result= createEditModelAndView(comment);

        return result;
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST, params="save")
    public ModelAndView save(@Valid Comment comment, BindingResult binding){
        ModelAndView result;
        if (!binding.hasErrors()) {
            result= createEditModelAndView(comment);
        }else{
            try{
                comment.setPostedMoment(new Date(System.currentTimeMillis() - 1000));
                commentService.save(comment);
                result= new ModelAndView("redirect:list.do");
            }catch(Throwable oops){
                result= createEditModelAndView(comment, "comment.commit.error");
            }
        }
        return result;
    }

    @RequestMapping(value="/edit", method=RequestMethod.POST, params="delete")
    public ModelAndView delete(Comment comment){
        ModelAndView result;
        try{
            commentService.delete(comment);
            result=new ModelAndView("redirect:list.do");
        }catch(Throwable oops){
            result= createEditModelAndView(comment, "comment.commit.error");
        }

        return result;
    }

}
