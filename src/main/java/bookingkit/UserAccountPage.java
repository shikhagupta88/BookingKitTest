package bookingkit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserAccountPage {


    @FindBy(how = How.TAG_NAME, using= "input")
    List<WebElement> languageInputListElements;

    @FindBy(how = How.XPATH,using = "//*[@id=\"setting-form\"]/div/div[3]/div/div/input")
    WebElement saveButton;

    @FindBy(how = How.ID,using ="User_email")
    WebElement userEmail;


    @FindBy(how = How.CLASS_NAME, using ="left")
    public WebElement infoText;



    WebDriver webDriver;

    public UserAccountPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public String getUserEmail(){
        return userEmail.getAttribute("value");
    }

    public WebElement getLanguageElement(String langCode){

        for (WebElement languageInputListElement : languageInputListElements) {

            if (languageInputListElement.equals(languageInputListElement)){
                return languageInputListElement;
            }
        }
        return null;
    }

    public void saveNewLanguageSelection(){
        saveButton.click();
    }

}
