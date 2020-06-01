package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ApplicationPage extends BasePage {

    @FindBy(xpath = "//b[contains(text(), 'Заявка на добровольное медицинское страхование')]")
    public WebElement headerText;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='MiddleName']")
    public WebElement middleNameInput;

    @FindBy(xpath = "//input[contains(@data-bind, 'value: Phone')]")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name = 'Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name = 'ContactDate']")
    public WebElement contactDateInput;

    @FindBy(xpath = "//textarea[@name = 'Comment']")
    public WebElement commentInput;

    @FindBy(xpath = "//select[@name = 'Region']")
    public WebElement regionSelect;

    @FindBy(xpath = "//input[@class='checkbox']")
    public WebElement confirmationCheckbox;

    @FindBy(xpath = "//button[@id='button-m']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[contains(text(), 'Введите адрес электронной почты')]")
    public WebElement errorMessageField;

    public ApplicationPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                fillField(lastNameInput, value);
                break;
            case "Имя":
                fillField(firstNameInput, value);
                break;
            case "Отчество":
                fillField(middleNameInput, value);
                break;
            case "Телефон":
                fillField(phoneNumberInput, value);
                break;
            case "Регион":
                regionSelect.findElement(By.xpath("//option[text()='" + value + "']")).click();
                break;
            case "Эл. почта":
                fillField(emailInput, value);
                break;
            case "Дата контакта":
                fillField(contactDateInput, value);
                break;
            case "Комментарии":
                fillField(commentInput, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    private void fillField(WebElement field, String value) {
        clickElement(field);
        field.sendKeys(value);
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Фамилия":
                return lastNameInput.getAttribute("value");
            case  "Имя":
                return firstNameInput.getAttribute("value");
            case  "Отчество":
                return middleNameInput.getAttribute("value");
            case  "Телефон":
                return phoneNumberInput.getAttribute("value");
            case  "Регион":
                String value = regionSelect.getAttribute("value");
                return regionSelect.findElement(By.xpath(".//*[@value='"+value+"']")).getText();
            case  "Эл. почта":
                return emailInput.getAttribute("value");
            case  "Комментарии":
                return commentInput.getAttribute("value");
            case  "Дата контакта":
                return contactDateInput.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String errorMessage){
        waitVisibilityOf(errorMessageField);
        String actualValue = errorMessageField.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
}
