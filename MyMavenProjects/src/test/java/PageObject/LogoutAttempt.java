package PageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutAttempt {
        private final WebDriver driver;

        public LogoutAttempt(WebDriver driver) {
            this.driver = driver;
        }

        public String getMessageModalText() {
            WebElement message = driver.findElement(By.xpath("//*[@id=toast-container]/div"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(message));
            return message.getText();
        }

        public void clickBackButton() {
            driver.navigate().back();
        }
    }

