package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.InsurancePage;

public class InsurancePageSteps {

    @Step("выполнена проверка, что заголовок страницы - ДМС равен {expectedTitle}")
    public InsurancePageSteps checkPageTitle(String expectedTitle){
        InsurancePage insurancePage = new InsurancePage();
        insurancePage.waitVisibilityOf(insurancePage.headerText);
        String actualTitle = new InsurancePage().headerText.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        return this;
    }

    @Step("выполнено нажатие на кнопку 'Отправить заявку'")
    public void clickSendApplicationButton(){
        InsurancePage insurancePage = new InsurancePage();
        insurancePage.clickElement(insurancePage.sendApplicationButton);
    }
}
