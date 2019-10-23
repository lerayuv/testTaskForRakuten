import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SettingsPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private SettingsPage settingsPage;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.slice.com/");
    }

    @Test
    public void openSettingsPage () {
        loginPage = new LoginPage(driver);
        settingsPage = new SettingsPage(driver);
        loginPage.openLoginPage();
        loginPage.enterEmail("valid.email@gmail.com");
        loginPage.enterPassword("12341234");
        loginPage.clickLoginButton();
        settingsPage.openSettingsPage();
        Assert.assertTrue(settingsPage.settingsPageIsOpened());
    }

    @Test
    public void deactivateAccount () {
        openSettingsPage();
        settingsPage = new SettingsPage(driver);
        settingsPage.clickDeactivateButtonOnPage();
        settingsPage.clickDeactivateButtonInModalWindow();
        Assert.assertTrue(driver.getCurrentUrl()=="https://www.slice.com/");
    }



    @After
    public void tearDown () {
        driver.quit();
    }
}
