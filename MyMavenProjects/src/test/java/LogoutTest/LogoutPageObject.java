package LogoutTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LogoutPageObject {
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

    @DataProvider(name = "getUsers")
    public Object[][] getUsers() {
        return new Object[][]{ { "DimitarTarkalanov", "Dimitar1.Tarkalanov1" }, };
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

    @Test()
    public void testLogoutButton() {
        driver.get ( "http://training.skillo-bg.com:4300/posts/all" );
        WebElement logoutButton = driver.findElement ( By.className ( "nav-link" ) );
        logoutButton.click ();

        WebDriverWait wait = new WebDriverWait ( driver, Duration.ofSeconds ( 10 ) );
        wait.until ( ExpectedConditions.urlToBe ( "http://training.skillo-bg.com:4300/posts/all" ) );
        Assert.assertTrue ( logoutButton.isEnabled (), "The logout is not displayed!" );

    }

    @Test()
    public void testHomeButton() {
        driver.get ( "http://training.skillo-bg.com:4300/posts/all" );
        WebElement homeIcon = driver.findElement ( By.xpath ( "//*[@id='nav-link-home']" ) );
        homeIcon.click ();
        Assert.assertTrue ( homeIcon.isEnabled () );
    }

    @Test
    public void signOut() {
        driver.get (" http://training.skillo-bg.com:4300/posts/all" );
        driver.findElement ( By.id ( "nav-link-login" ) ).click ();
        driver.findElement ( By.xpath ( "//*[@placeholder = 'Username or email']" ) ).sendKeys ( "DimitarTarkalanov" );
        driver.findElement ( By.id ( "defaultLoginFormPassword" ) ).sendKeys ( "Dimitar1.Tarkalanov1" );
        driver.findElement ( By.id ( "sign-in-button" ) ).click ();
        driver.findElement ( By.className ( "nav-link" ) ) .click ();
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
    }
}
















