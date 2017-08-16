package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhoDoYouLike_Page extends DataFlirchi {

    public WhoDoYouLike_Page(WebDriver driver) {
        this.driver = driver;
    }

    public HairColor_Page getGenderDoYouLike(String inputGender) {
        waitFor(MAIN_PAGE);
        driver.findElement(By.xpath(listOfParameters(inputGender))).click();
        return new HairColor_Page(driver);
    }
}
