package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.PaginaDeProdutos;
import pageObjects.PaginaInicial;

public class PageObjectManager {
	private WebDriver driver;

	private PaginaInicial paginaInicial;
	private PaginaDeProdutos paginaDeProdutos;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public PaginaInicial getPaginaInicial() {
		return (paginaInicial == null) ? paginaInicial = new PaginaInicial(driver) : paginaInicial;
	}
	
	public PaginaDeProdutos getPaginaDeProdutos() {
		return (paginaDeProdutos == null) ? paginaDeProdutos = new PaginaDeProdutos(driver) : paginaDeProdutos;
	}
}
