package TestCases;

import Pages.LoginPage;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void testCase001() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        String title = loginPage.getTitleOfPage();
        Assert.assertEquals(title,"Cogmento CRM");
    }

    @Test
    public void testCase002() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.loginApplication(email, pass);

    }

}
