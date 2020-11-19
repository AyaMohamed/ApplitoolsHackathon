package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilteredProductPage {

    private  WebDriver driver;
    private By colorCheckBox=By.id("SPAN__checkmark__107");
    private By filterButton=By.id("filterBtn");
    private By listOfShoes =By.xpath("//img[@class='img-fluid ']");


    public FilteredProductPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickFilterButton()
    {
        driver.findElement(colorCheckBox).click();
        driver.findElement(filterButton).click();
    }
    public int getNumberOfVisibleShoes()
    {
        return fintListOfShoes().size();
    }

    private List<WebElement> fintListOfShoes()
    {
        return driver.findElements(listOfShoes);
    }




}