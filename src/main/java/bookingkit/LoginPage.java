package bookingkit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private static final String DEFAULT_LANG = "Deutsch";

    @FindBy(how = How.CLASS_NAME, using = "lang_name")
    WebElement currentLanguage;

    @FindBy(how = How.ID, using = "bk_deSwitch")
    List<WebElement> languageLists;

    @FindBy(how = How.ID, using = "LoginForm_username")
    WebElement userName;

    @FindBy(how = How.ID, using = "LoginForm_password")
    WebElement password;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-form\"]/div[5]/button")
    WebElement login_button;

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void switchToDefaultLanguage() {


        if (DEFAULT_LANG.equals(currentLanguage.getText())) {
            return;
        } else {
            currentLanguage.click();
            for (WebElement languageList : languageLists) {

                if(languageList.getAttribute("data-lang").equals("de")){
                    languageList.click();
                    break;
                }
            }
        }
    }

    public void loginIntoBookingKit(String userName, String password) {

        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login_button.click();
    }

}
