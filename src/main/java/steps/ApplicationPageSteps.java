package steps;

import io.qameta.allure.Step;
import pages.ApplicationPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utils.AllureUtils.addScreenshot;

public class ApplicationPageSteps {

    @Step("выполнена проверка, что заголовок страницы - Отправить заявку равен {expectedTitle}")
    public ApplicationPageSteps checkPageTitle(String expectedTitle){
        ApplicationPage applicationPage = new ApplicationPage();
        applicationPage.waitVisibilityOf(applicationPage.headerText);
        String actualTitle = applicationPage.headerText.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        return this;
    }

    @Step("заполняются поля:")
    public ApplicationPageSteps fillFields(Map<String, String> fields){
        fields.forEach(this::fillField);
        return this;
    }

    @Step("поле {field} заполняется значением {value}")
    public void fillField(String field, String value){
        new ApplicationPage().fillField(field, value);
    }

    @Step("проставлено согласие")
    public ApplicationPageSteps checkboxApprove(){
        new ApplicationPage().confirmationCheckbox.click();
        return this;
    }

    @Step("выполнено нажатие на кнопку 'Отправить заявку'")
    public ApplicationPageSteps sendApplication(){
        new ApplicationPage().sendButton.click();
        return this;
    }

    @Step("выполнена проверка заполнения полей:")
    public ApplicationPageSteps checkFillFields(Map<String, String> fields){
        fields.forEach(this::checkFillField);
        return this;
    }

    @Step("поле {field} заполнено значением {value}")
    private void checkFillField(String field, String value){
        String actual = new ApplicationPage().getFillField(field);
        assertTrue(
                String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value)
        );
    }

    @Step("проверка сообщения об ошибке {errorMessage}")
    public void checkErrorMessage(String errorMessage){
        new ApplicationPage().checkFieldErrorMessage(errorMessage);
        addScreenshot();
    }
}
