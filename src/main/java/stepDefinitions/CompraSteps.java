package stepDefinitions;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pageObjects.PaginaDeProdutos;
import pageObjects.PaginaInicial;
import utils.TestContext;

public class CompraSteps {
	private PaginaInicial paginaInicial;
	private PaginaDeProdutos paginaDeProdutos;
	private TestContext testContext;

	public CompraSteps(TestContext context) {
		testContext = context;
		paginaInicial = testContext.getPageObjectFactory().getPaginaInicial();
		paginaDeProdutos = testContext.getPageObjectFactory().getPaginaDeProdutos();
	}

	@Dado("^que estou na pagina inicial$")
	public void que_estou_na_pagina_inicial() throws Throwable {
		System.out.println("Driver");
	}

	@Dado("^usuario faz login$")
	public void usuario_faz_login() throws Throwable {
		paginaInicial.clicaBtnUser();
		paginaInicial.escreveNomeDeUsuario("GabrielTeste1");
		paginaInicial.escreveSenha("Aa123");
		paginaInicial.clicaLogar();
	}

	@Dado("^clico no menu SPEAKERS$")
	public void clico_no_menu_SPEAKERS() throws Throwable {
		paginaInicial.clicaMenuSpeakers();
	}

	@Dado("^seleciono o produto$")
	public void seleciono_o_produto() throws Throwable {
		paginaDeProdutos.clicaProduto();
	}

	@Dado("^adiciono ao carrinho$")
	public void adiciono_ao_carrinho() throws Throwable {
		paginaDeProdutos.clicaAdicionarAoCarrinho();
	}

	@Dado("^vou para a pagina de chekout$")
	public void vou_para_a_pagina_de_chekout() throws Throwable {
		paginaDeProdutos.clicaBtnCarrinho();
		paginaDeProdutos.clicaBtnCheckout();
	}

	@Dado("^confirmo o endereco de entrega$")
	public void confirmo_o_endereco_de_entrega() throws Throwable {
		paginaDeProdutos.clicaBtnNext();
	}

	@Quando("^confirmo o pagamento$")
	public void confirmo_o_pagamento() throws Throwable {
		paginaDeProdutos.clicaBtnPayNow();
	}

	@Entao("^eu valido a compra feita$")
	public void eu_valido_a_compra_feita() throws Throwable {
		paginaDeProdutos.verificaNumeroDeRastreio();
	}

	@Dado("^seleciono (\\d+) unidades$")
	public void seleciono_unidades(int arg1) throws Throwable {
		paginaDeProdutos.selecionaQuantidade();
	}

	@Entao("^sao adicionados (\\d+) unidades$")
	public void sao_adicionados_unidades(int arg1) throws Throwable {
		paginaDeProdutos.esperaUserCart();
	}
}
