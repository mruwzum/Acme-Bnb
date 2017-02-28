package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by mruwzum on 28/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml",
        "classpath:spring/config/packages.xml"})
@Transactional

public class FinderServiceTest extends AbstractTest {
    @Autowired
    private FinderService finderService;

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
    public void find() throws Exception {
    String city = "city1";
    System.out.println(finderService.finder(city,10.0,100.0,"city1"));


    }

}