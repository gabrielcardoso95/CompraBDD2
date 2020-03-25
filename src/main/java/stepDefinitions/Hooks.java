package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.TestContext;

public class Hooks {
	private TestContext testContext;
	public Hooks(TestContext context) {
		testContext = context;
	}
	@Before
	public void abreBrowser() {
		testContext.getDriverFactory().iniciaNavegador();
	}
	@After
	public void fechaBrowser(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			File sourcePath = ((TakesScreenshot) testContext.getDriverFactory().iniciaNavegador())
					.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File(
					"C:\\Users\\User\\eclipse-workspace\\CompraBDD2-master\\Report\\"
							+ screenshotName + ".png");

			Files.copy(sourcePath, destinationPath);

			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
			System.out.println("Erro" + e.getMessage());
		}
		testContext.getDriverFactory().fechaDriver();
	}

}