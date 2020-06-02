package testRunner;

import com.google.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class LocalTestRunner {

    public WebDriver driver;
    protected SearchPage searchPage;
    private final String CHROME_DRIVER_INIT = "webdriver.chrome.driver";
    private final String GECKO_DRIVER_INIT = "webdriver.gecko.driver";
    private final String CHROME_DRIVER_FILE_PATH = "C:src\\main\\resources\\chromedriver.exe";
    private final String GECKO_DRIVER_FILE_PATH = "C:src\\main\\resources\\geckodriver.exe";
    private String URL = "https://www.google.com/";

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty(CHROME_DRIVER_INIT, CHROME_DRIVER_FILE_PATH);
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty(GECKO_DRIVER_INIT, GECKO_DRIVER_FILE_PATH);
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}