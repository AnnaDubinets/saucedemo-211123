import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Acer\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeout().implicitlyWait(Duration.ofSeconds(10)); - ne yavnoe ogidanie
        driver.get("https://www.saucedemo.com/");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
