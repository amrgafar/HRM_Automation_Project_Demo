import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Loginpagetests extends BaseTest{


    @Test
    public void testSuccessLogin(){
        //Add username
        loginpage.addusername("Admin");
        //Add password
        loginpage.addpassword("admin123");
        //Click login
        DashboardPage dashboardPage = loginpage.clickLogin();
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(dashboardPage.isDashbordIconVisible());

    }

    @Test
    public void testInvalidlogin(){
        loginpage.addusername("Admin");
        loginpage.addpassword("Amr123");
        loginpage.clickLogin();
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(loginpage.isInvalidErrorMessageVisible());
    }

    @Test
    public void testEmptyPassword(){
        loginpage.addusername("Admin");
        loginpage.addpassword("");
        loginpage.clickLogin();
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(loginpage.isRequiredErrormessagevisible());
    }

    @Test
    public void testEmptyUsername(){
        loginpage.addusername("");
        loginpage.addpassword("Admin123");
        loginpage.clickLogin();
        //assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        assertTrue(loginpage.isRequiredErrormessagevisible());
    }

    @Test
    public void testEmptyUsernameAndPassword(){
        loginpage.addusername("");
        loginpage.addpassword("");
        loginpage.clickLogin();
        assertTrue(loginpage.isDuplicateRequiredMessageVisible());
    }


}
