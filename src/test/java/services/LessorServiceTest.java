package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by daviddelatorre on 28/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/datasource.xml",
        "classpath:spring/config/packages.xml"})
@Transactional

public class LessorServiceTest extends AbstractTest {
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

    }

    @Test
    public void totalFee() throws Exception {

    }

}