package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HairColor_Page extends DataFlirchi {
    public HairColor_Page(WebDriver driver) {
        this.driver = driver;
    }

    public EyeColor_Page getHairColor(String inputColor) {
        driver.findElement(By.xpath(listOfParameters(inputColor))).click();
        return new EyeColor_Page(driver);
    }
}
