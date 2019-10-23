import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BaseClass {



    public SettingsPage(WebDriver driver) {
        this.driver=driver;
    }
     String Url = BaseUrl + "settings/account";
    public WebDriver driver;

    private By deactivateButtonOnPage = By.cssSelector("div.deactivate  button");
    private By deactivateButtonInModalWindow = By.cssSelector("div.modalDialog button:nth-child(1)");

    public void openSettingsPage () {
        driver.get(Url);
    }

    public boolean settingsPageIsOpened () {
        if (driver.findElement(deactivateButtonOnPage).isDisplayed());
        return true;
    }

    public void clickDeactivateButtonOnPage() {
        driver.findElement(deactivateButtonOnPage).click();
    }

    public void clickDeactivateButtonInModalWindow() {
        driver.findElement(deactivateButtonInModalWindow).click();
    }
}
