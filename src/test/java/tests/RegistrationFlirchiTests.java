package tests;

import objectsAndMethods.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class RegistrationFlirchiTests extends DataFlirchi {
    String selectGenderDoYouLike = "Девушки";//Доступные параметры: "Девушки" , "Парни"
    String selectHairDoYouLike = "Темные волосы";//Доступные параметры: "Темные волосы" , "Светлые волосы"
    String selectEyeDoYouLike = "Темные глаза";//Доступные параметры: "Темные глаза" , "Светлые глаза"
    String selectBodyDoYouLike = "С формами";//Доступные параметры: "С формами" , "Стройная"

    String setNameOfUser = "Jimmy";//Внести имя латиницей одним словом без фамилии
    String setEmailOfUser = "antonanton@gmail.com";//Перед символом "@" будет добавлено уникальное число
    String setYourGender = "Парень";//Внести свой пол. Доступные параметры: "Парень" , "Девушка". Сделать возможность регистрироваться как девушкой, так и парнем.
    String setYourAge = "68"; //Внести свой возраст. Доступные параметры: от 18 до 70

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DOMAIN_URL);
        driver.manage().window().maximize();
    }
    @Test
    public void selectPreferTest() {
        WhoDoYouLike_Page whoDoYouLike_page = new WhoDoYouLike_Page(driver);
        HairColor_Page hairColor_page = whoDoYouLike_page.getGenderDoYouLike(selectGenderDoYouLike);
        EyeColor_Page eyeColor_page = hairColor_page.getHairColor(selectHairDoYouLike);
        BodyType_Page body_page = eyeColor_page.getEyeColor(selectEyeDoYouLike);
        PersonalData_Page personalData_page = body_page.getBodyType(selectBodyDoYouLike);
        personalData_page.setUserData(setNameOfUser, setEmailOfUser, setYourGender, setYourAge);
        Profile_Page profile_page=personalData_page.getRegistration();
        assertEquals("Nickname на активной панели пользователя не совпадает с установленым при регистрации",profile_page.getNickNameOfActAPanel(),setNameOfUser);
        assertEquals("Nickname на карте пользователя не совпадает с установленым при регистрации",profile_page.getNickNameOfProfCard(),setNameOfUser);
        assertEquals("Статус юзера не онлайн",profile_page.getStatusOfUser(),"Онлайн");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}