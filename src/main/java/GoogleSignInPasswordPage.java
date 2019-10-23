import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSignInPasswordPage extends BaseClass {

     public GoogleSignInPasswordPage(WebDriver driver) {

         this.driver=driver;
    }

    public WebDriver driver;

    private By passwordField = By.cssSelector("#password  input");
    private By buttonPasswordNext = By.cssSelector("#passwordNext > span");


       public void typePassword (String password) {

        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickButtonPasswordNext() {
        driver.findElement(buttonPasswordNext).click();
    }



}
