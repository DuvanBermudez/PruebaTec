package com.demoblaze.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/register.feature",
        glue = "com.demoblaze.stepdefinitions",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/add_products/serenity-html-report.html",
                "rerun:target/serenity-reports/add_products/rerun.txt"
        }
)
public class Register {
}
