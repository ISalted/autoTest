package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BodyType_Page extends DataFlirchi {

    public BodyType_Page(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalData_Page getBodyType(String inputBodyType) {
        driver.findElement(By.xpath(listOfParameters(inputBodyType))).click();
        return new PersonalData_Page(driver);
    }
}
