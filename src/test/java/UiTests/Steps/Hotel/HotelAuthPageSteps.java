package UiTests.Steps.Hotel;

import UiTests.Steps.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HotelAuthPageSteps {

    private final TestContext context;

    public HotelAuthPageSteps(TestContext context) {
        this.context = context;
    }

    // ******************** Given section ***********



    // ******************** When section ***********

    @When("The user fills in email and selects Create an account")
    public void theUserFillsInEmailAndSelectsCreateAnAccount(){
        context.pm.getHotelAuthenticationPage().createEmailAndClickButton();
    }


    // ******************** Then section ***********


    }

