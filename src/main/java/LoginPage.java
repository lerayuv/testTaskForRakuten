import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }
    String Url = BaseUrl + "logmein";
    public WebDriver driver;

    private By emailInput = By.cssSelector("#logmein input[type=text]");
    private By passwordInput = By.cssSelector("#logmein input[type=password]");
    private By loginButton = By.cssSelector("div.login.buttonRow > button");


    public void openLoginPage () {
        driver.get(Url);
    }

    public void enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton () {
        driver.findElement(loginButton).click();
    }

}
