package bookingkit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

    @FindBy(how = How.CLASS_NAME, using="userHolder")
    WebElement user_account;

    @FindBy(how = How.XPATH, using= "/html/body/div[2]/div/div/div[3]/div/ul/li[1]/a")
    WebElement change_profile;

    @FindBy(how = How.XPATH,using = "/html/body/div[2]/div/div/div[3]/div/ul/li[2]/a")
    WebElement logout;

    @FindBy(how = How.XPATH,using = "/html/body/div[5]/div/nav/a[1]")
    WebElement dashboard;

    @FindBy(how = How.ID,using = "menuTabs")
    public WebElement menuTabs;


    WebDriver webDriver;


    public HomePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public  void selectChangeProfile()
    {

        Actions action = new Actions(webDriver);
        action.moveToElement(user_account).build().perform();
        change_profile.click();

    }

    public void selectDashBoard(){

        dashboard.click();
    }

    public  void logoutUser()
    {

        Actions action = new Actions(webDriver);
        action.moveToElement(user_account).build().perform();
        logout.click();
    }

}

