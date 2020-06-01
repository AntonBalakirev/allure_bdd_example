package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.BaseSteps;

abstract class BasePage {

    public void clickElement(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitVisibilityOf(WebElement element){
        BaseSteps.wait.until(ExpectedConditions.visibilityOf(element));
    }
}
