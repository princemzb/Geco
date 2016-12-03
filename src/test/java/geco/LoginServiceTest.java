package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by prince on 03/12/16.
 */
public class LoginServiceTest {

    private LoginService logSer;
    private static final String pmaz = "PMAZ";
    private static final String boa = "BOA";
    @Before
    public void setUp() throws Exception {
        String deb[] = new String[1];
        deb[0] = pmaz;
        logSer = new LoginService(deb);

    }

    @Test
    public void loginExists() throws Exception {
        boolean res = logSer.loginExists(pmaz);
        Assert.assertTrue(res);
        res = logSer.loginExists(boa);
        Assert.assertFalse(res);
    }

    @Test
    public void addLogin() throws Exception {
        logSer.addLogin("MOM");
        logSer.addLogin("POP");
        int size = (logSer.findAllLogins()).size();
        org.junit.Assert.assertEquals(3, size);
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        logSer.addLogin("MOM");
        logSer.addLogin("POP");
        List<String> res = logSer.findAllLoginsStartingWith("P");
        int size = res.size();
        Assert.assertEquals(size, 2);
        logSer.addLogin("POP");
        res = logSer.findAllLoginsStartingWith("P");
        size = res.size();
        Assert.assertEquals(size, 3);
    }

    @Test
    public void findAllLogins() throws Exception {
        logSer.addLogin("MOM");
        logSer.addLogin("POP");
        List<String> res = logSer.findAllLogins();
        int size = res.size();
        Assert.assertEquals(3, size);
    }

}