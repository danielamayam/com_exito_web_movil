package com.exito.certification.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/SeleccionarArticulos.feature"},
        tags = {"@AgregaProduto"},
        glue = {"com.exito.certification.stepsdefinitions"},
        snippets = SnippetType.CAMELCASE
)
public class RunnerSeleccionarArticulos {
}
