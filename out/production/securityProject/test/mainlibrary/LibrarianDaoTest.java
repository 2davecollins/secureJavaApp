package mainlibrary;

import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;

import static org.testng.Assert.*;

public class LibrarianDaoTest {
    LibrarianDao ldao = null;

    @BeforeTest
    public void beforeTest() {
        System.out.println("Run Before Test");
        ldao = new LibrarianDao();

    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("Run after Test");
        try {
            ldao.cleanup();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ldao = null;
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {

    }
    @Test(priority = 1)
    public void testValidateFalse() {
        System.out.println("Test Validate with incorrect librarian");
        Assert.assertEquals(false, ldao.validate("hack", "1234"));
    }


    @Test(priority = 2, enabled = true)
    public void testSave() {
        System.out.println("Test Save method");
        Assert.assertEquals(1, ldao.save("Hacker", "hack", "1234", "hack@h.com"));
    }

    @Test(priority = 3)
    public void testValidateTrue() {
        System.out.println("Test Validate with incorrect librarian");
        Assert.assertEquals(true, ldao.validate("hack", "1234"));
    }

    @Test(priority = 4, enabled = true)
    public void testDelete() {
        System.out.println("Test Detete method");
        int hack = ldao.findHacker();
        System.out.println("Deleting Hacker id "+hack);
        Assert.assertEquals(1, ldao.delete(hack));
    }

}
