package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MainPage extends BasePage {

    @FindBy(xpath = "//li[@class='dropdown adv-analytics-navigation-line1-link current']//a[contains(text(), 'Меню')]")
    public WebElement menuLink;

    @FindBy(xpath = "//a[contains(text(), 'ДМС')]")
    public WebElement dmsLink;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
