package PageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    protected WebDriver driver;

    public FormPage(WebDriver driver){
        this.driver = driver;
    } 

    // Preencher o campo "Username"
    public FormPage login(String username){
        driver.findElement(By.id("username")).sendKeys(username);
        return this;
    }
    // Preencher o campo "Password"
    public FormPage password(String password){
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }
    // Clicar no botão "Login"
    public CreatedAccount page(){
        driver.findElement(By.xpath("//*[@id=\'login\']/button")).click();
        return new CreatedAccount(driver);
    }

    // Verificação de sucesso ou falha no login
    public class CreatedAccount extends FormPage {
        public CreatedAccount(WebDriver driver) {
            super(driver);
            assertTrue (driver.getPageSource().contains("You logged into a secure area!"));      
        }
    }
}
