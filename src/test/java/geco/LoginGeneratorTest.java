package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prince on 03/12/16.
 */
public class LoginGeneratorTest {

    private LoginGenerator lg;
    private LoginService loginService;
    @Before
    public void setUp() throws Exception {
        loginService = new LoginService(new String[] {"JROL", "BPER",
                "CGUR", "JDUP", "JRAL", "JRAL1"});
        lg = new LoginGenerator(loginService);

    }

    @Test
    public void generateLoginForNomAndPrenom() throws Exception {
        String prenomPaul = "Paul";
        String nomPaul = "Durant";
        String log = lg.generateLoginForNomAndPrenom(nomPaul, prenomPaul);
        Assert.assertEquals(log, "PDUR");
        String prenomJohn = "John";
        String nomJohn = "Ralling";
        log = lg.generateLoginForNomAndPrenom(nomJohn, prenomJohn);
        Assert.assertEquals(log, "JRAL2");

    }

    @Test
    public void consolidantionPDUR2 () {
        String prenomPaul = "Paul";
        String nomPaul = "Durant";
        String log = lg.generateLoginForNomAndPrenom(nomPaul, prenomPaul);
        Assert.assertEquals(log, "PDUR");
    }

    @Test
    public void consolidantionPMAZ () {
        String prenomPaul = "Prince";
        String nomPaul = "Mazaba";
        String log = lg.generateLoginForNomAndPrenom(nomPaul, prenomPaul);
        Assert.assertEquals(log, "PMAZ");
    }

}