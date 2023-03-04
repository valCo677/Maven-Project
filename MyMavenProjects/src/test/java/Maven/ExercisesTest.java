package Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExercisesTest {

    @Test (invocationCount = 2)
    public void testLoginWaits() {
        WebDriverManager.edgedriver ().setup ();
        EdgeDriver driver = new EdgeDriver ();
        driver.manage ().window ().maximize ();

        driver.manage ().timeouts ().pageLoadTimeout ( Duration.ofSeconds ( 20 ) );
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );


        driver.get ( "http://training.skillo-bg.com:4300/posts/all" );
        WebElement loginLink = driver.findElement ( By.id ( "nav-link-login" ) );
        loginLink.click ();

        WebDriverWait wait = new WebDriverWait ( driver,Duration.ofSeconds ( 5 ) );
        wait.until ( ExpectedConditions.urlToBe ( "http://training.skillo-bg.com:4300/users/login" ));


        String expectedLogInUrl  = "http://training.skillo-bg.com:4300/users/login";
        String actualLogInUrl = driver.getCurrentUrl ();
        Assert.assertEquals ( actualLogInUrl,expectedLogInUrl, "Login page URL is incorrect" );


        WebElement signInTitle = driver.findElement (By.id ( "defaultLoginFormUsername" ));
        Assert.assertTrue ( signInTitle.isDisplayed (),"The Sign in element is  not displayed !" );

        WebElement userNameField = driver.findElement (By.id("defaultLoginFormUsername"));
        userNameField.sendKeys ( "abv@yahoo.com" );

        WebElement password = driver.findElement (By.id ( "defaultLoginFormPassword" ));
        password.sendKeys ( "123456" );

        WebElement signButton = driver.findElement (By.id ( "sign-in-button" ));
        wait.until ( ExpectedConditions.elementToBeClickable ( signButton ) );
        signButton.click ();

        WebElement profileLink = driver.findElement (By.id ( "nav-link-profile" ));
        wait.until ( ExpectedConditions.elementToBeClickable ( profileLink ) );
        profileLink.click ();


        wait.until ( ExpectedConditions.urlContains ( "http://training.skillo-bg.com:4300/users/login" ) );

        WebElement userNameElement = driver.findElement (By.tagName ( "h2" ));
        String actualUserName = userNameElement.getText ();
        String expectedUserName = "valentin_40";
        Assert.assertEquals ( expectedUserName,actualUserName,"The user name is incorrect");

        Boolean isTextDisplayed = wait.until ( ExpectedConditions.textToBe ( By.tagName ( "h2" ), "valentin_40") );
        Assert.assertTrue ( isTextDisplayed,"The username is not displayed" );
        driver.close ();



    }
}


