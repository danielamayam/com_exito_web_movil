package com.exito.certification.stepsdefinitions;

import com.exito.certification.exceptions.SeleccionarProductoException;
import com.exito.certification.models.MenuModel;
import com.exito.certification.questions.VerificarCantidadPorProducto;
import com.exito.certification.questions.VerificarCantidadProducto;
import com.exito.certification.questions.VerificarProducto;
import com.exito.certification.tasks.AbrirElNavegador;
import com.exito.certification.tasks.SeleccionarProductos;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionSeleccionarArticulos {

    @Given("^que el (.*) quiere abrir la pagina del Exito$")
    public void queElUsuarioQuiereAbrirLaPaginaDelExito(String actor) {
        theActorCalled(actor).wasAbleTo(
                AbrirElNavegador.enLikeMe()
        );
    }

    @When("^Selecciono los cinco productos$")
    public void seleccionoLosCincoProductos(List<MenuModel> menuModels) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarProductos.asSeleccionar(menuModels.get(0))
        );
    }

    @Then("^Válido los productos agregados$")
    public void válidoLosProductosAgregados() {
        theActorInTheSpotlight().should(seeThat(VerificarProducto.enElCarrito())
                .orComplainWith(SeleccionarProductoException.class,
                        SeleccionarProductoException.PRODUCTOS_AGREGADOS)
        );

    }

    @Then("^Válido el número de productos en el carro$")
    public void válidoElNúmeroDeProductosEnElCarro() {
        theActorInTheSpotlight().should(seeThat(VerificarCantidadProducto.enElCarrito())
                .orComplainWith(SeleccionarProductoException.class,
                        SeleccionarProductoException.CANTIDAD_DE_PRODUCTOS));
    }

    @Then("^Válido la cantidad de cada producto$")
    public void válidoLaCantidadDeCadaProducto() {
        theActorInTheSpotlight().should(seeThat(VerificarCantidadPorProducto.enElCarrito())
                .orComplainWith(SeleccionarProductoException.class,
                        SeleccionarProductoException.CANTIDAD_POR_PRODUCTO)
        );
    }


}
