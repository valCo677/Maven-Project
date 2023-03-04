package PageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Head {
        private final WebDriver driver;

        @FindBy(id = "nav-link-profile")
        private WebElement profileButton;

        @FindBy(id = "nav-link-login")
        private WebElement loginButton;

        @FindBy(xpath = "//ul[@class='navbar-nav my-ml d-none d-md-block']//li[@class='nav-item ng-star-inserted']//a[@class='nav-link']")
        private WebElement logoutButton;

        public Head( WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void clickProfile() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(profileButton));
            profileButton.click();
        }

        public void clickLogin() {
            loginButton.click();
        }
        public Boolean isLoginButtonDisplayed(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return loginButton.isDisplayed();
        }

        public void clickLogout(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            logoutButton.click();
        }

        public Boolean isLogoutIconDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return logoutButton.isDisplayed();
        }
    }

