package objectsAndMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;

public class DataFlirchi {
    public static WebDriver driver;
    protected String DOMAIN_URL = "https://hitwe.com/landing/inter2?fr=1&p=1232";
    protected String GIRLS_BUTTON = ".//*[@id='slide-01']/div/div[1]/div[1]";
    protected String BOYS_BUTTON = ".//*[@id='slide-01']/div/div[2]/div[1]";
    protected String BRUNET_BUTTON = ".//*[@id='slide-02-f']/div/div[1]/div";
    protected String BLONDE_BUTTON = ".//*[@id='slide-02-f']/div/div[2]/div";
    protected String DARK_EYES_BUTTON = ".//*[@id='slide-03-f']/div/div[1]/div";
    protected String BRIGHT_EYES_BUTTON = ".//*[@id='slide-03-f']/div/div[2]/div";
    protected String CURVY_BODY_BUTTON = ".//*[@id='slide-04-f']/div/div[1]/div";
    protected String SLIM_BODY_BUTTON = ".//*[@id='slide-04-f']/div/div[2]/div";
    protected String USER_NAME_FIELD = ".//*[@placeholder='Ваше имя']";
    protected String USER_EMAIL_FIELD = ".//*[@placeholder='Email']";
    protected String GENDER_LIST = ".//*[@id='slide-06']/form/div[3]/div[1]/select"; //".//*[@name='gender']";
    protected String AGE_LIST = ".//*[@id='slide-06']/form/div[3]/div[2]/select"; //".//*[@name='age']";
    protected String MAIN_PAGE = ".//*[@id='slide-01']";
    protected String PERSONAL_DATA_PAGE = ".//*[@id='slide-06']//*[contains(text(),'Для просмотра результатов зарегистрируйтесь на сайте')]";
    protected String REGISTRATION_BUTTON = ".//*[@class='land-btn-submit land-btn']";
    protected String NICK_NAME_OF_ACT_PANEL =".//*[@class='act-panel-user-name']";
    protected String NICK_NAME_OF_PROCARD=".//*[@class='prof-name']";
    protected String PROF_INDICATOR_PLACE=".//*[@class='prof-online prof-card-button']";

    protected static void selectionByText(String inputXpath, String inputSelector) {
        new Select(driver.findElement(By.xpath(inputXpath))).selectByVisibleText(inputSelector);
    }

    protected static void selectionByValue(String inputXpath, String inputSelector) {
        new Select(driver.findElement(By.xpath(inputXpath))).selectByValue(inputSelector);
    }

    public String listOfParameters(String inputData) {
        HashMap<String, String> parametersList = new HashMap<String, String>();
        parametersList.put("Девушки", GIRLS_BUTTON);
        parametersList.put("Парни", BOYS_BUTTON);
        parametersList.put("Темные волосы", BRUNET_BUTTON);
        parametersList.put("Светлые волосы", BLONDE_BUTTON);
        parametersList.put("Темные глаза", DARK_EYES_BUTTON);
        parametersList.put("Светлые глаза", BRIGHT_EYES_BUTTON);
        parametersList.put("С формами", CURVY_BODY_BUTTON);
        parametersList.put("Стройная", SLIM_BODY_BUTTON);
        return parametersList.get(inputData);
    }

    public void waitFor(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public String emailWithTimeStamp(String inputEmail){
        String[] tmpEmail = inputEmail.split("@");
        return tmpEmail[0]+System.currentTimeMillis()/1000+"@"+tmpEmail[1];
    }
}
