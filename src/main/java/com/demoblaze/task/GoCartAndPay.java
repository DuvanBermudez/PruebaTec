package com.demoblaze.task;

import com.demoblaze.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.*;
import static com.demoblaze.ui.CartPage.*;

public class GoCartAndPay implements Task {
    User user;

    public GoCartAndPay(User user) {
        super();
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_LINK),
                Click.on(BTN_PLACE_ORDER),
                Enter.theValue(user.getName()).into(NAME_INPUT),
                Enter.theValue(user.getCreditCard()).into(CARD_INPUT),
                Click.on(BTN_PURCHASE));
        String confirmationText = Text.of(TEXT_VALIDATE).answeredBy(actor).toString();
        actor.remember("confirmation",confirmationText);
        actor.attemptsTo(Click.on(BTN_OK));
    }

    public static GoCartAndPay withUser(User user){
        return Tasks.instrumented(GoCartAndPay.class,user);
    }
}
