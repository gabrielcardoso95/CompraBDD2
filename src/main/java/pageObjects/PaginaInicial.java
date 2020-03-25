package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaginaInicial {
	private WebDriver driver;

	public PaginaInicial(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "menuUser")
	private WebElement btnUser;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input")
	private WebElement usernameLogin;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input")
	private WebElement passwordLogin;

	@FindBy(how = How.ID, using = "speakersImg")
	private WebElement menuSpeakers;

	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement btnLogar;

	@FindBy(how = How.ID, using = "menuCart")
	private WebElement btncarrinho;

	@FindBy(how = How.NAME, using = "follow_linkedin")
	private WebElement follow_linkedin;

	public void clicaBtnUser() {
		btnUser.click();
	}

	public void escreveNomeDeUsuario(String username) {
		usernameLogin.sendKeys(username);
	}

	public void escreveSenha(String senha) {
		passwordLogin.sendKeys(senha);
	}

	public void clicaMenuSpeakers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(follow_linkedin));
		menuSpeakers.click();
	}

	public void clicaLogar() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(btnLogar)).click();
	}

	public void waitElementcart() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(btncarrinho));
	}
}
