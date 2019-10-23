import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GoogleSignInStartPage extends BaseClass {

     public GoogleSignInStartPage(WebDriver driver) {

         this.driver=driver;
    }

    public WebDriver driver;

    private By emailOrPhoneInput = By.cssSelector("#identifierId");
    private By buttonEmailNext = By.cssSelector("#identifierNext > span");


    public void typeEmail (String email) {

        driver.findElement(emailOrPhoneInput).sendKeys(email);
    }

    public void clickButtonEmailNext() {
        driver.findElement(buttonEmailNext).click();
    }
}
