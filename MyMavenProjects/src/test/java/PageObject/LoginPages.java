package PageObject;



import PageFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class LoginPages {

        public static final String PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
        private final WebDriver driver;

        @FindBy(id = "sign-in-button")
        private WebElement signInButton;

        @FindBy(id = "defaultLoginFormPassword")
        private WebElement passwordField;

        @FindBy(id = "defaultLoginFormUsername")
        private WebElement usernameField;

        @FindBy(className = "h4")
        private WebElement signInFormTitle;



    public LoginPages( WebDriver driver ) {
        this.driver = driver;
    }

    public void clickSignIn() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signInButton));
            signInButton.click();
        }

        public void populatePassword(String password) {
            passwordField.sendKeys(password);
        }

        public void populateUsername(String username) {
            usernameField.sendKeys(username);
        }

        public void signIn(String username, String password){
            populateUsername(username);
            populatePassword(password);
            clickSignIn();
        }

        public String getSignInElementText() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
            return signInFormTitle.getText();
        }

        public boolean isUrlLoaded() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.urlToBe( LoginPage.PAGE_URL));
        }
    }


