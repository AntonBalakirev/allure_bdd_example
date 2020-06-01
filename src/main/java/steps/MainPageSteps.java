package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainPageSteps {

    @Step("выбрано меню")
    public MainPageSteps selectMenuItem(){
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.menuLink);
        return this;
    }

    @Step("выбран вид страхования ДМС")
    public void selectMenuInsurance(){
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.dmsLink);
    }
}
