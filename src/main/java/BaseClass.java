import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;
    public String BaseUrl = "https://www.slice.com/";


    public long generateTimestamp () {

        long ts = System.currentTimeMillis();
        return ts;
    }

}