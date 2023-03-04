package advanceMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class tableClass {
    private WebDriver driver;


    @Test
    public void testTables() {
        WebDriverManager.edgedriver ().setup ();
        EdgeDriver driver = new EdgeDriver ();
        driver.manage ().window ().maximize ();

        driver.get ( "http://the-internet.herokuapp.com/challenging_dom" );
        WebElement button2 = driver.findElement ( By.xpath ( "//a[@class='button alert']" ) );
        button2.click ();

        List<WebElement> columnHeaders = driver.findElements ( By.xpath ( "//table/thead//th" ) );
        int tableColumnsCount = columnHeaders.size ();
        List<WebElement> cells = driver.findElements ( By.xpath ( "//table/tbody//td" ) );
        int cellsCount = cells.size ();
        int rowsCount = cellsCount / tableColumnsCount;
        String table[][] = new String[rowsCount][tableColumnsCount];
        WebElement tableElements[][] = new WebElement[rowsCount][tableColumnsCount];

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < tableColumnsCount; j++) {
                String currXPath = String.format ( "//table/tbody//tr[%s]//td[%s]", i + 1, j + 1 );
                table[i][j] = driver.findElement ( By.xpath ( currXPath ) ).getText ();
                tableElements[i][j] = driver.findElement ( By.xpath ( currXPath ) );


            }
        }
    }
}




