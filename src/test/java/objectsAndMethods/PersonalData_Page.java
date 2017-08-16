package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.junit.*;

public class PersonalData_Page extends DataFlirchi {

    public PersonalData_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserData(String inputName, String inputEmail, String inputGender, String inputAge){
        waitFor(PERSONAL_DATA_PAGE);
        setUserName(inputName);
        setUserEmail(inputEmail);
        genderSelection(inputGender);
        ageSelection(inputAge);
    }

    public void setUserName(String inputName) {
        driver.findElement(By.xpath(USER_NAME_FIELD)).sendKeys(inputName);
    }

    public void setUserEmail(String inputEmail) {
        driver.findElement(By.xpath(USER_EMAIL_FIELD)).sendKeys(inputEmail);
    }

    public void genderSelection(String gender) {
        selectionByText(GENDER_LIST, gender);
    }

    public void ageSelection(String age)  {
        selectionByValue(AGE_LIST, age);
    }

    public Profile_Page getRegistration() {

        driver.findElement(By.xpath(REGISTRATION_BUTTON)).click();
        try {
            waitFor(".//*[@id='main']");
        }catch (TimeoutException t){
            Assert.fail("В методе RegistrationFlirchiTests в переменной `setEmailOfUser` введите уникальный тестовый email");

        }
        driver.findElement(By.xpath(".//*[@class='interstial-main-box']/a")).click();

        return new Profile_Page(driver);
    }
}
