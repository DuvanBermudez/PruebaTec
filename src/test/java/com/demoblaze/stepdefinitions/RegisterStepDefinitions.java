package com.demoblaze.stepdefinitions;

import com.demoblaze.models.User;
import com.demoblaze.task.RegisterUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class RegisterStepDefinitions {

    @Before()
    public void setup() {
        setTheStage(new OnlineCast());
    }

    @Given("i want to register in {string}")
    public void iWantToRegisterIn(String strUrl) {
        theActorCalled("Duvan").wasAbleTo(Open.url(strUrl));
    }
    @When("assing my user data")
    public void assingMyUserData(io.cucumber.datatable.DataTable userDataTable) {
        Map<String, String> userData = userDataTable.asMap(String.class, String.class);

        User newUser = new User(userData.get("username"), userData.get("password"));
        theActorInTheSpotlight().attemptsTo(RegisterUser.withdata(newUser));
    }

    @Then("I verify that the register is successful see {string}")
    public void iVerifyThatTheRegisterIsSuccessfulSee(String strResult) {
        String textAlert = theActorInTheSpotlight().recall("alertJS");
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat("text must be equal",
                        actor -> strResult.equals(textAlert)));
    }
}
