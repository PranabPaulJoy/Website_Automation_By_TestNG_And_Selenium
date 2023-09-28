package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.DashBoardPage;
import page.LoginPage;
import setup.SetUp;

public class LoginTestRunner extends SetUp {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;


    @Test(priority = 1, description = "User can't login with wrong creds")
    public void doLoginWithWrongCreds(){
        loginPage = new LoginPage(driver);
        String actualmessage = loginPage.doLoginWithWrongCreds("wrongusernam", "wrongpassword");
        String expectedmessage = "Invalid credentials";
        Assert.assertTrue(expectedmessage.contains(actualmessage));


    }
    @Test(priority = 2, description = "User can login with valid creds",groups = "smoke")
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        dashBoardPage = new DashBoardPage(driver);
        Assert.assertTrue(dashBoardPage.imgProfile.isDisplayed());
    }
    @Test(priority = 3, description = "Successfully logout",groups = "smoke")
    public void doLogout() {
        DashBoardPage dashboardPage = new DashBoardPage(driver);
        dashboardPage.doLogout();
        String textActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        String testExpected = "Login";
        Assert.assertTrue(textActual.equals(testExpected));
    }
}
