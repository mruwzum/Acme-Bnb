package services;

import domain.Comment;
import domain.Tenant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by mruwzum on 28/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml",
        "classpath:spring/config/packages.xml"})
@Transactional

public class TenantServiceTest extends AbstractTest {

    @Autowired
    private TenantService tenantService;
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
        Comment comment = commentService.create();
        comment.setObjectiveId(29);
        comment.setText("asdas");
        comment.setNumberOfStars(2);
        comment.setTitle("hghj");
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 10000));
        Comment comment2 = commentService.create();
        comment.setObjectiveId(29);
        comment.setText("asdas");
        comment.setNumberOfStars(2);
        comment.setTitle("hghj");
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 10000));


        Comment saved = commentService.save(comment);
        Tenant target = tenantService.findOne(saved.getObjectiveId());
        target.getComments().add(comment);
        target.getComments().add(comment2);

        System.out.println(tenantService.findOne(saved.getObjectiveId()).getComments().toString());

    }

    @Test
    public void commentTest() throws Exception {

        authenticate("tenant1");

        Comment comment = new Comment();

        comment.setText("PRUEBA");
        comment.setTitle("PRUEBA");
        comment.setNumberOfStars(2);
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 1000));
        comment.setObjectiveId(tenantService.findByPrincipal().getId());
        Comment save = commentService.save(comment);

        tenantService.findByPrincipal().getComments().add(save);

        System.out.println(tenantService.findByPrincipal().getComments());

        authenticate(null);

    }

    @Test
    public void commentTest2() throws Exception {

        authenticate("tenant1");

        Comment comment = new Comment();

        comment.setText("PRUEBA");
        comment.setTitle("PRUEBA");
        comment.setNumberOfStars(2);
        comment.setPostedMoment(new Date(System.currentTimeMillis() - 1000));
        Comment save = commentService.save(comment);

        tenantService.findByPrincipal().getComments().add(save);

        System.out.println(tenantService.findByPrincipal().getComments());

        authenticate(null);

    }


}