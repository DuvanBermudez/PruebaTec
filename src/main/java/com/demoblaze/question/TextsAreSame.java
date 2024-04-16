package com.demoblaze.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TextsAreSame implements Question<Boolean> {
    private String text1;
    private String text2;

    public TextsAreSame(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return text1.equals(text2);
    }

    public static TextsAreSame with(String text1, String text2) {
        return new TextsAreSame(text1, text2);
    }
}
