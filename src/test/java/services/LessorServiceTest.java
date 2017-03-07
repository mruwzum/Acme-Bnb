package services;

import domain.Comment;
import domain.Lessor;
import domain.Property;
import domain.Tenant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by daviddelatorre on 28/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml",
        "classpath:spring/config/packages.xml"})
@Transactional

public class LessorServiceTest extends AbstractTest {

    @Autowired
    private LessorService lessorService;
    @Autowired
    private CommentService commentService;

    @Test
    public void create() throws Exception {

    }

    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void findByPrincipal() throws Exception {

    }

    @Test
    public void getAllProperties() throws Exception {

    }

    @Test
    public void deleteProperty() throws Exception {

    }

    @Test
    public void registerProperty() throws Exception {

    }

    @Test
    public void modifyProperty() throws Exception {

    }

    @Test
    public void approveRequest() throws Exception {

    }

    @Test
    public void denyRequest() throws Exception {



    }

    @Test
    public void getAllRequest() throws Exception {

        authenticate("lessor1");
        Lessor u = lessorService.findByPrincipal();
        List<Property> properties = new ArrayList<>(lessorService.getAllProperties());
        System.out.println(properties.get(0).getBookRequests());
        System.out.println(lessorService.getAllProperties());

        System.out.println(lessorService.getAllRequest());

        authenticate(null);
    }

    @Test
    public void totalFee() throws Exception {
        authenticate("lessor1");

        System.out.println(lessorService.findByPrincipal().getSocialIdentitys());
        authenticate(null);


    }

    @Test
    public void commentTest2() throws Exception {

        Comment comment = commentService.create();
        comment.setObjectiveId(26);
        comment.setText("asd22as");
        comment.setNumberOfStars(1);
        comment.setTitle("22hghj");
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 10000));
        Comment comment2 = commentService.create();
        comment2.setObjectiveId(26);
        comment2.setText("asda2222s");
        comment2.setNumberOfStars(2);
        comment2.setTitle("111111hghj");
        comment2.setPostedMoment(new Date(System.currentTimeMillis() - 10000));


        Lessor target = lessorService.findOne(comment.getObjectiveId());
        target.getComments().add(comment);
        target.getComments().add(comment2);

       Comment s1 = commentService.save(comment);

        Comment s2 = commentService.save(comment2);

        System.out.println(lessorService.findOne(comment.getObjectiveId()).getComments().toString());

    }
    }