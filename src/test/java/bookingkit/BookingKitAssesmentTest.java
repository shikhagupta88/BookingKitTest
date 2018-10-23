package bookingkit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BookingKitAssesmentTest {

    private static final String BASE_URL = "https://releasetest.bookingkit.de";
    private static final String TEST_USER_NAME = "dantis+test@bookingkit.de";
    private static final String TEST_PASSWORD = "welcome@2018";

    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(BASE_URL);
    }

    @Test
    public void test_Login_Page_Appear_Correctly() {

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.switchToDefaultLanguage();
    }


    @Test
    public void test_Perform_Login() {

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginIntoBookingKit(TEST_USER_NAME, TEST_PASSWORD);
        wait.until(titleIs("Dashboard - bookingkit"));
    }

    @Test
    public void test_select_profile_change_from_dropdown() {

        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.switchToDefaultLanguage();

        loginPage.loginIntoBookingKit(TEST_USER_NAME, TEST_PASSWORD);
        wait.until(titleIs("Dashboard - bookingkit"));
        HomePage homepage = new HomePage(webDriver);
        homepage.selectChangeProfile();

        UserAccountPage userAccountPage = new UserAccountPage(webDriver);
        Assert.assertEquals(TEST_USER_NAME, userAccountPage.getUserEmail());

        Assert.assertNotNull(userAccountPage.getLanguageElement("en"));
        userAccountPage.getLanguageElement("en").click();
        userAccountPage.saveNewLanguageSelection();

        wait.until(textToBePresentInElement(userAccountPage.infoText, "Hello QA, we'll help you set up your account"));

        homepage.selectDashBoard();
        wait.until(visibilityOf(homepage.menuTabs)).isDisplayed();

        homepage.logoutUser();
        wait.until(urlToBe("https://releasetest.bookingkit.de/site/login"));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }
}




