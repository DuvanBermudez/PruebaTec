package com.demoblaze.stepdefinitions;

import com.demoblaze.models.Product;
import com.demoblaze.models.User;
import com.demoblaze.question.TextsAreSame;
import com.demoblaze.task.GoCartAndPay;
import com.demoblaze.task.SelectProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.ensure.Ensure.that;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyProductsStepDefinitions {
    @Given("i want to buy product in {string}")
    public void iWantToBuyProductIn(String strUrl) {
        theActorCalled("Duvan").wasAbleTo(Open.url(strUrl));
    }
    @When("select category and product")
    public void selectCategoryAndProduct(io.cucumber.datatable.DataTable productDataTable) {
        Map<String, String> productData = productDataTable.asMap(String.class, String.class);

        Product newProduct = new Product(productData.get("category"),productData.get("product"));
        theActorInTheSpotlight().attemptsTo(SelectProduct.withdata(newProduct));
    }
    @When("go to cart and pay")
    public void goToCartAndPay() {
        User user = new User();
        theActorInTheSpotlight().attemptsTo(GoCartAndPay.withUser(user));
    }
    @Then("verify that shop are successfully with message {string}")
    public void verifyThatShopAreSuccessfullyWithMessage(String strConfirmation) {
        String confirmationPage = theActorInTheSpotlight().recall("confirmation");
        theActorInTheSpotlight().should(
                seeThat("Los datos son iguales", TextsAreSame.with(strConfirmation,confirmationPage)));
    }
}
