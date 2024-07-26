package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HeaderPage;
import pageObject.LoginPage;
import pageObject.ProductPage;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class BaseTests {

    @BeforeEach
    public void setUp(){
        System.out.println("Début de test");

    }
    static ChromeDriver driver;
    @BeforeAll
    public static void seTUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

    }
    @Test
    public void t001_logInUser(){
        LoginPage loginPage = new LoginPage(driver);
       Assertions.assertTrue(loginPage.getUrlWebPage().contains("/v1/"),"Erreur de page"); ;
        loginPage.fillInformation();
        loginPage.clickLoginButton();
    }
    @Test
    public void t002_filterByprice(){
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertTrue(productPage.getUrlProdectPage().contains("inventory.html"),"Erreur de page");
        productPage.clickFilterButton();
        productPage.isListInorder();
    }
    @Test
    public void t003_adArticle(){
     ProductPage productPage =  new ProductPage(driver);
     productPage.clickAdArticle();
     productPage.getUrlProdectPage();
     HeaderPage headerPage = new HeaderPage(driver);
     Assertions.assertTrue(headerPage.isArticleAdedInCart(),"carte vide");
      Assertions.assertTrue(headerPage.removeArticle(),"^pas d'article a supprimer");
      headerPage.getUrlpage();

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
