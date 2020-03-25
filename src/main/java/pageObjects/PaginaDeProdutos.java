package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaDeProdutos {
	private WebDriver driver;

	public PaginaDeProdutos(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "20")
	private WebElement produto;

	@FindBy(how = How.ID, using = "shoppingCartLink")
	private WebElement btnCarrinho;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement adicionarAoCarrinho;

	@FindBy(how = How.ID, using = "checkOutButton")
	private WebElement btnCheckout;

	@FindBy(how = How.ID, using = "next_btn")
	private WebElement btnNext;

	@FindBy(how = How.ID, using = "pay_now_btn_SAFEPAY")
	private WebElement btnPayNow;

	@FindBy(how = How.ID, using = "trackingNumberLabel")
	private WebElement trackingNumber;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement quantidade;

	@FindBy(how = How.ID, using = "userCart")
	private WebElement userCart;

	public void clicaProduto() {
		produto.click();
	}

	public void clicaAdicionarAoCarrinho() {
		adicionarAoCarrinho.click();
	}

	public void clicaBtnCarrinho() {
		btnCarrinho.click();
	}

	public void clicaBtnCheckout() {
		btnCheckout.click();
	}

	public void clicaBtnNext() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(btnNext));
		btnNext.click();
	}

	public void clicaBtnPayNow() {
		btnPayNow.click();
	}

	public void verificaNumeroDeRastreio() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(trackingNumber));
	}

	public void selecionaQuantidade() {
		quantidade.sendKeys("1");
	}

	public void esperaUserCart() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(userCart));
		assertTrue(driver.getPageSource().contains("10 ITEMS"));
	}
}
