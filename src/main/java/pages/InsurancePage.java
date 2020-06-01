package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//h1[@class='content-document-header']")
    public WebElement headerText;

    @FindBy(xpath = "//a[contains(text(), 'Отправить заявку')]")
    public WebElement sendApplicationButton;

    public InsurancePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
