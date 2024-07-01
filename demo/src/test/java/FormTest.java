import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.FormPage;

public class FormTest {
    private WebDriver driver;


    public static WebDriver createFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        return driver;
    }

    @BeforeTest
    public void setUp() {
        driver = createFirefox();
    }

    @Test
    public void PageObject(){
        new FormPage(driver)
        .login("tomsmith")
        .password("SuperSecretPassword!")
        .page();
    }  
   
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
