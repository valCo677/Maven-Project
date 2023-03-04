package Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestObject {
    private WebDriver driver;
    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver ().setup ();
        WebDriverManager.edgedriver ().setup ();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver ();
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
    public WebDriver getDriver(){
        return driver;
    }
    @Test(dataProvider = "getUsers")
    public void testLoginWithWaits( String user, String password ) {
        driver.get ( "http://training.skillo-bg.com:4300/posts/all" );
        WebElement loginLink = driver.findElement ( By.id ( "nav-link-login" ) );
        loginLink.click ();

        WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 10 ) );
        wait.until ( ExpectedConditions.urlToBe ( "http://training.skillo-bg.com:4300/users/login" ) );


        WebElement signInElement = driver.findElement ( By.xpath ( "//*[text()='Sign in']" ) );
        wait.until ( ExpectedConditions.visibilityOf ( signInElement ) );
        WebElement userNameField = driver.findElement ( By.id ( "defaultLoginFormUsername" ) );
        userNameField.sendKeys ( user );
        WebElement passwordField = driver.findElement ( By.id ( "defaultLoginFormPassword" ) );
        passwordField.sendKeys ( password );

        WebElement signInButton = wait.until ( ExpectedConditions.elementToBeClickable ( By.id ( "sign-in-button" ) ) );
        signInButton.click ();

    }
}
