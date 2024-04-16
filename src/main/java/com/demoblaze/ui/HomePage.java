package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target BTN_REGISTER = Target.the("Register button").locatedBy("//a[@id='signin2']");
    public static final Target TXT_USERNAME = Target.the("User field").locatedBy("//input[@id='sign-username']");
    public static final Target TXT_PASSWORD = Target.the("Password field").locatedBy("//input[@id='sign-password']");
    public static final Target BTN_SUBMIT_REGISTER = Target.the("Register button").locatedBy("//button[@onclick='register()']");
}
