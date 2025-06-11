package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelAddressFormPage extends BasePage {
    public HotelAddressFormPage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "address1")
    WebElement addressInput;

    @FindBy(id = "postcode")
    WebElement postcodeInput;

    @FindBy(id = "city")
    WebElement cityInput;

    @FindBy(id = "id_country")
    WebElement countryInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "alias")
    WebElement aliasInput;

    @FindBy(id = "submitAddress")
    WebElement saveButton;

    @FindBy(xpath = "//h3[@class='page-subheading']")
    List<WebElement> addressHeadings;

    public void fillAddressForm(String first, String last, String address, String city, String zip, String phone, String testAddress) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).clear();
        firstNameInput.sendKeys(first);
        lastNameInput.clear();
        lastNameInput.sendKeys(last);
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.clear();
        cityInput.sendKeys(city);
        postcodeInput.clear();
        postcodeInput.sendKeys(zip);
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        aliasInput.clear();
        aliasInput.sendKeys(testAddress);

    }

    public void saveAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();

    }

    public void validateNewAddressVisible(String alias) {
        try {
            WebElement aliasElement = driver.findElement(By.xpath("//h3[@class='page-subheading' and text()='" + alias + "']"));
            wait.until(ExpectedConditions.visibilityOf(aliasElement));
        } catch (Exception e) {
            Assertions.fail("Alias '" + alias + "' was not found on the address page.");
        }
    }
}