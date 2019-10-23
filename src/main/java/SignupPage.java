import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BaseClass {

   /* public SignupPage(WebDriver driver) {
        this.driver = driver;
    }*/


    public SignupPage(WebDriver driver) {
        this.driver=driver;
    }
     String Url = BaseUrl + "signup";
    public WebDriver driver;

    private By emailInput = By.xpath("//input[@type=\"email\"]");
    private By checkboxAgreeToTerms = By.id("agreeInput");
    private By signUpButton = By.cssSelector("#signup button");
    private By signUpHeaderButton = By.cssSelector("span > a.signup");

    public void openSignUpPage () {
        driver.findElement(signUpHeaderButton).click();
    }

    public boolean signupPageIsOpened () {
        if (driver.findElement(checkboxAgreeToTerms).isDisplayed()
                && driver.findElement(signUpButton).isDisplayed()
                && driver.findElement(signUpHeaderButton).isDisplayed());
        return true;
    }

    public void typeEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickTermsCheckbox () {
        driver.findElement(checkboxAgreeToTerms).click();
    }

    public boolean checkTermsCheckboxIsEnabled () {
        if (driver.findElement(checkboxAgreeToTerms).isEnabled());
        return true;
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clicksignUpButtonAndCheckbox () {
        if (!this.checkTermsCheckboxIsEnabled()) {
            this.clickSignUpButton();
    }
        else {
            this.clickTermsCheckbox();
            this.clickSignUpButton();
    }
    }
}
