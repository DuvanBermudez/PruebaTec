package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ShopPage {
    public static Target PRODUCT_OPTION(String text) {
        return Target.the("product option").locatedBy("//a[text()='" + text + "']");
    }
    public static Target CATEGORY_OPTION(String text) {
        return Target.the("category option").locatedBy("//a[text()='" + text + "']");
    }
    public static final Target ADD_TO_CART_BUTTON = Target.the("Add to cart button").locatedBy("a[class*='btn-success']");
}
