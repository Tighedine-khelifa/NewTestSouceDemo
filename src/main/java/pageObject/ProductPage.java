package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductPage {
    @FindBy(xpath = "//select[@class='product_sort_container']")
            private WebElement filterButton;
    @FindBy(xpath = " //option[@value='hilo']")
            private WebElement hiloFilter;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
            private List<WebElement> listPrice;
    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
            private WebElement adButtonShirt;
    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrlProdectPage(){
        return driver.getCurrentUrl();
    }
    public void clickFilterButton(){
        filterButton.click();
        if (hiloFilter.isSelected()){
            System.out.println("le bouton est déjà selectionner");
        }else{
            hiloFilter.click();
        }

    }
    public Boolean isListInorder() {
        List<String> list = new ArrayList<>();
        for (WebElement lists : listPrice) {
             list.add(lists.getText().replaceAll("[^\\d]",""));

          }

        // Créer un itérateur pour parcourir la liste
        Iterator<String> iterator = list.iterator();
        // Convertir le premier élément de l'itérateur en entier
        int current, previous = Integer.parseInt(iterator.next());
        while (iterator.hasNext()){
            // Convertir l'élément actuel en entier
            current = Integer.parseInt(iterator.next());
            if(previous >current){
                return false;

            }
            // Mettre à jour l'élément précédent pour la prochaine itération
            previous = current;
        }
           return true;
    }

    public void clickAdArticle(){
        adButtonShirt.click();
    }
}
