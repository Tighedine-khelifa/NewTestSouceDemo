package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
             WebElement userName;
    @FindBy(id= "password")
             WebElement passWord;
    @FindBy(xpath = "//input[@value='LOGIN']")
             WebElement loginButton;
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }


    public void fillInformation(){

        try {
            userName.click();
            userName.sendKeys("standard_user");
            passWord.click();
            passWord.sendKeys("secret_sauce");
        }catch (NoSuchElementException e){
            // Attrape l'exception si les éléments userName ou passWord ne sont pas trouvés
            System.out.println("les boutons non pas été trouvé" +e.getMessage());

    }


    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
