package V2Tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTestsV2 extends BaseTestsV2{

    @Test
    //testHomePage
    public void firstTest()
    {
        validateWindow();
    }

    @Test
    //testFilterButton
    public void secondTest()
    {
        FilteredPage.clickFilterButton();
        validateFilterByColor();
        Assert.assertEquals("Number of shoes appear",
                2, FilteredPage.getNumberOfVisibleShoes());
    }

    @Test
    //testProductDetails
    public void thirdTest()
    {
        ProductPage.selectShoe();
        validateProductDetailsPage();
    }

}
