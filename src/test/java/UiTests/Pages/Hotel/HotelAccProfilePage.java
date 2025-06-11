package UiTests.Pages.Hotel;

import UiTests.Pages.BasePage;
import UiTests.Steps.TestContext;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelAccProfilePage extends BasePage {
    public HotelAccProfilePage(TestContext context) {
        super(context);
        PageFactory.initElements(context.driver, this);
    }

    @FindBy(xpath = "//p[contains(.,'Your account has been created.')]")
    WebElement validateLabel;

    @FindBy(xpath = "//a[./span[contains(text(),'My addresses')]]")
    private WebElement myAddressesLink;

    @FindBy(xpath = "//a[span[contains(text(),'Add a new address')]]")
    private WebElement addAddressButton;


    public void validateAccountCraated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(this.validateLabel));
        } catch (Exception e) {
            Assertions.fail("Account has not been created.");
        }

    }

    public void clickOnMyAddresses() {
        WebElement myAddressesLink = driver.findElement(By.xpath("//a[span[contains(text(),'My addresses')]]"));
        wait.until(ExpectedConditions.elementToBeClickable(myAddressesLink));
        myAddressesLink.click();

    }

    public void clickAddNewAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(addAddressButton)).click();
    }


}
