import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SignupPageTest {

    private WebDriver driver;
    private SignupPage signupPage;
    private GoogleSignInStartPage googleSignInStartPage;
    private GoogleSignInPasswordPage googleSignInPasswordPage;

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        signupPage = new SignupPage(driver);
        driver.get("https://www.slice.com/");
    }

    @Test
    public void openSignUpPage () {
        signupPage.openSignUpPage();
        Assert.assertTrue(signupPage.signupPageIsOpened());
    }

    @Test
    public void signupWithValidData () {
        long timestamp = signupPage.generateTimestamp();
        signupPage.openSignUpPage();
        signupPage.typeEmail("valid.email+"+timestamp+"@gmail.com");

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles(); // запоминаем, какие окна были открыты
        signupPage.clicksignUpButtonAndCheckbox();

        // находим новое окно и переключаемся на него

        String newWindowHandle = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindowHandle);

        googleSignInStartPage = new GoogleSignInStartPage(driver);
        googleSignInStartPage.typeEmail("valid.emal@gmail.com");
        googleSignInStartPage.clickButtonEmailNext();

        googleSignInPasswordPage = new GoogleSignInPasswordPage(driver);
        googleSignInPasswordPage.typePassword("validpass");
        googleSignInPasswordPage.clickButtonPasswordNext();

        Assert.assertTrue(driver.getCurrentUrl()=="https://www.slice.com/home");
    }



//    @After
//    public void tearDown () {
//        driver.quit();
//    }
}
