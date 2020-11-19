package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetalisPage {


    private WebDriver driver;
    private By shoeItem=By.id("H3____218");

    public ProductDetalisPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void selectShoe()
    {
        driver.findElement(shoeItem).click();
    }

}
