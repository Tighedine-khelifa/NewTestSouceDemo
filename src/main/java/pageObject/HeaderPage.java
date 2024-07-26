package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(id=  "shopping_cart_container")
    private WebElement shoppingCart;
    @FindBy(xpath ="//button[text()='REMOVE']")
    private WebElement removeButton;
    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isArticleAdedInCart() {
        if (shoppingCart.getText().equals("1")) {
         System.out.println("Un article est ajouter au panier");
        }else {
            System.out.println("Aucun article n'été ajouter au panier");
        }
        return true;
    }
    public Boolean removeArticle(){
        if(removeButton.getText().equals("REMOVE")){
            removeButton.click();
            return true;
        }else {
          System.out.println("pas d'article a supprimer");
          return false;
        }
    }
    public String getUrlpage(){
        String url = driver.getWindowHandle();
        System.out.println("L'URL"+url);
        return url;
    }
}

