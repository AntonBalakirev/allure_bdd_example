import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import steps.ApplicationPageSteps;
import steps.BaseSteps;
import steps.InsurancePageSteps;
import steps.MainPageSteps;

import java.util.HashMap;

public class AllureTest {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    private ApplicationPageSteps applicationPageSteps = new ApplicationPageSteps();

    @Before
    public void setUp(){
        BaseSteps.setUp();
    }

    @Test
    public void checkEmailErrorMessageTest() {
        mainPageSteps
                .selectMenuItem()
                .selectMenuInsurance();

        insurancePageSteps
                .checkPageTitle("ДМС — добровольное медицинское страхование")
                .clickSendApplicationButton();

        applicationPageSteps
                .checkPageTitle("Заявка на добровольное медицинское страхование")
                .fillFields(
                        new HashMap<String, String>() {{
                            put("Имя", "Автотест");
                            put("Отчество", "Автотестович");
                            put("Фамилия", "Автотестеров");
                            put("Регион", "Москва");
                            put("Телефон", "9997072233");
                            put("Эл. почта", "test_email");
                            put("Дата контакта", "02062020");
                            put("Комментарии", "Тут был Автотест");
                        }}
                )
                .checkboxApprove()
                .sendApplication()
                .checkFillFields(
                        new HashMap<String, String>() {{
                            put("Имя", "Автотест");
                            put("Отчество", "Автотестович");
                            put("Фамилия", "Автотестеров");
                            put("Регион", "Москва");
                            put("Телефон", "+7 (999) 707-22-33");
                            put("Эл. почта", "test_email");
                            put("Дата контакта", "02.06.2020");
                            put("Комментарии", "Тут был Автотест");
                        }}
                )
                .checkErrorMessage("Введите адрес электронной почты");
    }

    @After
    public void tearDown(){
        BaseSteps.tearDown();
    }
}
