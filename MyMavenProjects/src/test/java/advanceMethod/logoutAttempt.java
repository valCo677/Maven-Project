package advanceMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class logoutAttempt {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver ().setup ();
        WebDriverManager.edgedriver ().setup ();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new EdgeDriver ();
        this.driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().pageLoadTimeout ( Duration.ofSeconds ( 20 ) );
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
    }

    @AfterMethod
    protected final void tearDownTest() {
        if (this.driver != null) {
            this.driver.quit ();
        }
    }

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{ { "DimitarTarkalanov", "Dimitar1.Tarkalanov1", "DimitarTarkalanov" },
        };
    }

    @Test
    public void testCheckBox() {
        driver.get ( "https://mail.bg/auth/lgn" );
        WebElement imapulser = driver.findElement ( By.name ("user") );
        imapulser.click ();



    }
}


