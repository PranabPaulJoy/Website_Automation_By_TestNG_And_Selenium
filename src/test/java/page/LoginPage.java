package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "username")
    WebElement textUsername;
    @FindBy(name = "password")
    WebElement textPassword;

    @FindBy(css = "[type = submit")
    WebElement btnLogin;

    @FindBy(className = "oxd-text")
    List<WebElement> wrongcredsmessage;
    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }
    public String doLoginWithWrongCreds(String usernam, String password){
        textUsername.sendKeys(usernam);
        textPassword.sendKeys(password);
        btnLogin.click();
        String wrongsmessg = wrongcredsmessage.get(1).getText();
        return wrongsmessg;
    }
    public void doLogin(String username, String password){
        textUsername.sendKeys(username);
        textPassword.sendKeys(password);
        btnLogin.click();
    }
}
