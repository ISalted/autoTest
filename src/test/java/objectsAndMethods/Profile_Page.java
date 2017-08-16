package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profile_Page extends DataFlirchi{
    public Profile_Page(WebDriver driver) {
        this.driver=driver;
    }
    public String getNickNameOfActAPanel() {
        return driver.findElement(By.xpath(NICK_NAME_OF_ACT_PANEL)).getText();
    }

    public String getNickNameOfProfCard() {
        return driver.findElement(By.xpath(NICK_NAME_OF_PROCARD)).getText();
    }

    public String getStatusOfUser() {
        return driver.findElement(By.xpath(PROF_INDICATOR_PLACE)).getText();
    }

}
