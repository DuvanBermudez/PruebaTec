package com.demoblaze.task;

import com.demoblaze.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static com.demoblaze.ui.HomePage.*;

public class RegisterUser implements Task {
    User newUser;

    public RegisterUser(User newUser) {
        super();
        this.newUser = newUser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_REGISTER),
                Enter.theValue(newUser.getStrUserName()).into(TXT_USERNAME),
                Enter.theValue(newUser.getStrPassword()).into(TXT_PASSWORD),
                Click.on(BTN_SUBMIT_REGISTER));
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        actor.remember("alertJS", alertText);
    }

    public static RegisterUser withdata(User newUser){
        return Tasks.instrumented(RegisterUser.class,newUser);

    }
}
