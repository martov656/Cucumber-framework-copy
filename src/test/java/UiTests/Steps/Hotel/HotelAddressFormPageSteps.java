package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAddressFormPageSteps {

    private final TestContext context;

    public HotelAddressFormPageSteps(TestContext context) {
        this.context = context;
    }



   @And("The user fills in the new address details into the form")
   public void theUserFillsInTheNewAddressForm() {
        context.pm.getHotelAddressFormPage().fillAddressForm("Olga", "Magdebura", "Mikołaja Sępa-Szarzyńskiego 59", " Wrocław", "50-334", "+420607987789", "Test Address");
    }


    @And("The user saves the new address form")
    public void theUserSavesTheNewAddressForm() {
        context.pm.getHotelAddressFormPage().saveAddress();

    }

    @Then("The user should see the new address with list")
    public void the_user_should_see_the_new_address_with_list() {
        // Tady vlož validaci
        context.pm.getHotelAddressFormPage().validateNewAddressVisible("Test Address");
    }

    }



