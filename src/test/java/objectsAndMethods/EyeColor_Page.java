package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyeColor_Page extends DataFlirchi {
    public EyeColor_Page(WebDriver driver) {
        this.driver = driver;
    }

    public BodyType_Page getEyeColor(String inputColor) {
        driver.findElement(By.xpath(listOfParameters(inputColor))).click();
        return new BodyType_Page(driver);
    }
}
