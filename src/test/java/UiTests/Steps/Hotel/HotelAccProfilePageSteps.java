package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelAccProfilePageSteps {

    private final TestContext context;

    public HotelAccProfilePageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********


    // ******************** When section ***********

    @And("The user clicked on my addresses option in the profile")
    public void theUserClickedOnMyAddressesOptionInTheProfile() {
        context.pm.getHotelAccProfilePage().clickOnMyAddresses();

    }

    @When("The user press add a new address")
    public void theUserPressAddANewAddress() {
        context.pm.getHotelAccProfilePage().clickAddNewAddress();
    }

    // ******************** Then section ***********

    @Then("The user should see the account created")
    public void theUserShouldSeeTheAccountCreated() {
        context.pm.getHotelAccProfilePage().validateAccountCraated();
    }
}


