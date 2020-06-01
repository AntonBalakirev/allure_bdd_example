package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.ApplicationPageSteps;
import steps.InsurancePageSteps;
import steps.MainPageSteps;

public class StepDefinitions {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    private ApplicationPageSteps applicationPageSteps = new ApplicationPageSteps();

    @When("выбрано меню")
    public void selectMenuItem(){
        mainPageSteps.selectMenuItem();
    }

    @When("выбран вид страхования ДМС")
    public void selectMenuInsurance(){
        mainPageSteps.selectMenuInsurance();
    }

    @Then("выполнена проверка, что заголовок страницы - ДМС равен {string}")
    public void checkPageTitleInsurancePage(String title){
        insurancePageSteps.checkPageTitle(title);
    }

    @When("выполнено нажатие на кнопку 'Отправить заявку'")
    public void clickSendApplicationButton(){
        insurancePageSteps.clickSendApplicationButton();
    }

    @Then("выполнена проверка, что заголовок страницы - Отправить заявку равен {string}")
    public void checkPageTitleApplicationPage(String title){
        applicationPageSteps.checkPageTitle(title);
    }

    @When("заполняются поля:")
    public void fillApplicationForm(DataTable fields){
        applicationPageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @Then("значения полей равны:")
    public void checkApplicationFormFilled(DataTable fields){
        applicationPageSteps.checkFillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @Then("проверка сообщения об ошибке {string}")
    public void checkErrorMessage(String errorMessage){
        applicationPageSteps.checkErrorMessage(errorMessage);
    }
}
