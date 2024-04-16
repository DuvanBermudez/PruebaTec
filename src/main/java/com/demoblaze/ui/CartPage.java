package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target CART_LINK = Target.the("Cart link").locatedBy("//a[@id='cartur']");
    public static final Target BTN_PLACE_ORDER = Target.the("Place Order button").locatedBy("//button[text()='Place Order']");
    public static final Target NAME_INPUT = Target.the("Name input field").locatedBy("//input[@id='name']");
    public static final Target COUNTRY_INPUT = Target.the("Country input field").locatedBy("//input[@id='country']");
    public static final Target CITY_INPUT = Target.the("City input field").locatedBy("//input[@id='city']");
    public static final Target CARD_INPUT = Target.the("Card input field").locatedBy("//input[@id='card']");
    public static final Target MONTH_INPUT = Target.the("Month input field").locatedBy("//input[@id='month']");
    public static final Target YEAR_INPUT = Target.the("Year input field").locatedBy("//input[@id='year']");
    public static final Target BTN_PURCHASE = Target.the("Purchase button").locatedBy("//button[@class='btn btn-primary' and text()='Purchase']");
    public static final Target TEXT_VALIDATE = Target.the("Thank you header").locatedBy("/html/body/div[10]/h2");
    public static final Target BTN_OK = Target.the("OK button").locatedBy("//button[contains(@class,'confirm') and contains(@class,'btn-primary') and contains(@class,'btn-lg')]");
}
