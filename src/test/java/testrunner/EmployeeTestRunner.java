package testrunner;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.DashBoardPage;
import page.LoginPage;
import page.PIMPage;
import page.UserModel;
import setup.SetUp;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

public class EmployeeTestRunner extends SetUp {
    @BeforeTest(groups = "smoke")
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
    }
    @Test(priority = 1, description = "Employee cannot be created without username")
    public void createEmployeeWithoutUsername() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(1).click();//PIM
        pimPage.button.get(2).click();//add employee button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        pimPage.textElm.get(1).sendKeys(firstName);//first name
        String lastName = faker.name().lastName();
        pimPage.textElm.get(3).sendKeys(lastName);//last name

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.className("oxd-switch-input")));
        //Thread.sleep(1000);
        driver.findElement(By.className("oxd-switch-input")).click();
        String password = "P@ssword123";//Utils.generateStrongPassword();
        pimPage.textElm.get(6).sendKeys(password);//password
        pimPage.textElm.get(7).sendKeys(password);//confirm password

        driver.findElements(By.className("oxd-button--medium")).get(1).click();
//        pimPage.buttonElem.get(1).click();//save

        String titleActual = driver.findElement(By.className("oxd-input-field-error-message")).getText();
        String titleExpected = "Required";
        Assert.assertEquals(titleActual, titleExpected);
    }

    @Test(priority = 2, description = "Employee cannot be created without password")
    public void createEmployeeWithoutPassword() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(1).click();//PIM
        pimPage.button.get(2).click();//add employee button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        pimPage.textElm.get(1).sendKeys(firstName);//first name
        String lastName = faker.name().lastName();
        pimPage.textElm.get(3).sendKeys(lastName);//last name

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait2.until(ExpectedConditions.elementToBeClickable(By.className("oxd-switch-input")));
        //Thread.sleep(1000);
        driver.findElement(By.className("oxd-switch-input")).click();
        String username = faker.name().username() + Utils.generateRandomId(100,999);
        pimPage.textElm.get(5).sendKeys(username);//username

        driver.findElements(By.className("oxd-button--medium")).get(1).click();
//        pimPage.buttonElm.get(1).click();//save

        String titleActual = driver.findElements(By.className("oxd-input-field-error-message")).get(0).getText();
        String titleExpected = "Required";
        Assert.assertEquals(titleActual, titleExpected);
    }
    @Test(priority = 3, description = "Employee can be created successfully", groups = "smoke")
    public void createEmployee() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        driver.findElements(By.className("oxd-main-menu-item--name")).get(1).click();

        PIMPage pimPage = new PIMPage(driver);
//        pimPage.pimMenu.get(1).click();
        driver.findElements(By.className("oxd-button--medium")).get(2).click();

        String titleActual = driver.findElements(By.className("orangehrm-main-title")).get(0).getText();
        String titleExpected = "Add Employee";
        Assert.assertEquals(titleActual,titleExpected);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-main-title")));

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        String employeeid = pimPage.textElm.get(4).getAttribute("value");

        driver.findElement(By.className("oxd-switch-input")).click();

        String username = faker.name().username()+ Utils.generateRandomId(100,999);
//        String password = Utils.generateStrongPassword();
        String password = "P@ssword123";
        pimPage.textElm.get(5).sendKeys(username);
        pimPage.textElm.get(6).sendKeys(password);//password
        pimPage.textElm.get(7).sendKeys(password);//confirm password

        driver.findElements(By.className("oxd-button--medium")).get(1).click();
//        pimPage.addEmployee.get(1).click();

        Thread.sleep(7000);
        String titleActuall = driver.findElements(By.className("orangehrm-main-title")).get(0).getText();
        String titleExpectedd = "Personal Details";

        UserModel model = new UserModel();
        model.setFirstname(firstName);
        model.setLastname(lastName);
        model.setEmployeeid(employeeid);
        model.setUsername(username);
        model.setPassword(password);
        Utils.saveInfo(model);

        Assert.assertTrue(titleActuall.contains(titleExpectedd));
    }
    @Test(priority = 4, description = "Search employee by invalid id")
    public void searchEmployeeByInvalidID() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(1).click();//PIM
        pimPage.textElm.get(1).sendKeys("18");
        Thread.sleep(2000);
        pimPage.button.get(1).click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-text--span")));

        String textActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        System.out.println(textActual);
        String textExpected = "No Records Found";
        Assert.assertTrue(textActual.contains(textExpected));
        Thread.sleep(7000);
    }
    @Test(priority = 5, description = "Search employee by invalid name")
    public void searchEmployeeByInvalidName() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(8).click();

        driver.findElements(By.tagName("input")).get(1).sendKeys("joy");
        pimPage.button.get(1).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-text--span")));

        String textActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        System.out.println(textActual);
        String textExpected = "Invalid";
        Assert.assertTrue(textActual.contains(textExpected));
        Thread.sleep(7000);
    }
    @Test(priority = 6, description = "Search employee by valid id",groups = "smoke")
    public void searchEmployeeByID() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(1).click();//PIM
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/Employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size()-1);
        String employeeId = empObj.get("employeeid").toString();
        pimPage.textElm.get(1).sendKeys(employeeId);
        Thread.sleep(2000);
        pimPage.button.get(1).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-text--span")));

        String textActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        System.out.println(textActual);
        String textExpected = "Record Found";
        Assert.assertTrue(textActual.contains(textExpected));
        Thread.sleep(7000);
    }

    @Test(priority = 7, description = "Search employee by valid name", groups = "smoke")
    public void searchEmployeeByName() throws IOException, ParseException, InterruptedException, org.json.simple.parser.ParseException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.pimMenu.get(8).click();//PIM
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/Employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size()-1);
        String employeeName = empObj.get("firstName").toString();

        driver.findElements(By.tagName("input")).get(1).sendKeys(employeeName);
        Thread.sleep(3000);
        driver.findElement(By.className("oxd-autocomplete-option")).click();
        Thread.sleep(2000);
        pimPage.button.get(1).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-text--span")));

        String textActual = driver.findElements(By.className("oxd-text")).get(14).getText();
        System.out.println(textActual);
        String textExpected = "Record Found";
        Assert.assertTrue(textActual.contains(textExpected));
        Thread.sleep(7000);
    }

    @Test(priority = 8, description = "Successfully logout",groups = "smoke")
    public void doLogout() {
        DashBoardPage dashboardPage = new DashBoardPage(driver);
        dashboardPage.doLogout();
        String textActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        String testExpected = "Login";
        Assert.assertTrue(textActual.equals(testExpected));
    }
    @Test(priority = 9, description = "The logout option should not be visible till the user is logged in")
    public void doLogoutBeforeLogin() {
        boolean isLogoutVisible;
        try {
            WebElement btnLogout = driver.findElement(By.linkText("Logout"));
            if(btnLogout.isDisplayed()) {
                isLogoutVisible = true;
            } else {
                isLogoutVisible = false;
            }
        } catch (NoSuchElementException e) {
            isLogoutVisible = false;
        }
        Assert.assertFalse(isLogoutVisible);
    }

}
