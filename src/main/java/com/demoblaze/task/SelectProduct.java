package com.demoblaze.task;

import com.demoblaze.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.demoblaze.ui.CartPage.*;
import static com.demoblaze.ui.ShopPage.*;

public class SelectProduct implements Task {
    Product product;

    public SelectProduct(Product product) {
        super();
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CATEGORY_OPTION(product.getCategory())),
                Click.on(PRODUCT_OPTION(product.getProduct())),
                Click.on(ADD_TO_CART_BUTTON));
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static SelectProduct withdata(Product product){
        return Tasks.instrumented(SelectProduct.class,product);
    }
}
