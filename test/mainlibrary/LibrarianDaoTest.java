package mainlibrary;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LibrarianDaoTest {
    LibrarianDao ldao = null;

    @BeforeTest
    public void beforeTest(){
        System.out.println("Run Before Test");
        ldao = new LibrarianDao();

    }
    @AfterTest
    public void afterTest(){
        System.out.println("Run after Test");
        ldao = null;
    }

    @BeforeMethod
    public void setUp() {
       // System.out.println("LibrarianDao setup");

    }

    @AfterMethod
    public void tearDown() {

    }

    @Test(enabled = false)
    public void testSave() {
        System.out.println("Test Save method");
        Assert.assertEquals(0,ldao.save("Hacker","1234","hacker@g.com","hidden address","Dublin","Batman"));
    }

    @Test(enabled=false)
    public void testInvalidDelete() {
        System.out.println("Test Detete method");
        Assert.assertEquals(0,ldao.delete(5));
    }

    @Test(enabled=false)
    public void testDelete() {
        System.out.println("Test Detete method");
        Assert.assertEquals(1,ldao.delete(3));
    }


    @Test(priority = 3)
    public void testValidate() {
        System.out.println("Test Validate method");
        Assert.assertEquals(true,ldao.validate("Encosier","1234"));
    }

    @Test(priority = 4)
    public void testFailValidate() {
        System.out.println("Test Validate method");
        Assert.assertEquals(false,ldao.validate("Hacker","1234"));
    }
}
