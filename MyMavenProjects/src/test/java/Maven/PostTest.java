package Maven;

import PageFactory.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostTest extends TestObject{
    @DataProvider(name = "getUsers")
        public Object[][] getUsers() {
            return new Object[][]{ { "Dimitar Tarkalanov", "Dimitar1.Tarkalanov1" },
            };
        }
    @Test(dataProvider = "getUsers")

    public void testCreatePost(String user, String password) {
        WebDriver driver = super.getDriver ();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo ();
        loginPage.login ( user, password );


    }
}
