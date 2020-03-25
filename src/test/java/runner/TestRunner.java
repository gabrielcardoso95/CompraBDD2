package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature",
		glue = "stepDefinitions",
		tags = {"@CompraSucesso, @CompraFalha"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
     	monochrome = true
		)


public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
	Reporter.loadXMLConfig(new File("C:\\Users\\User\\eclipse-workspace\\CompraBDD2-master\\extension-config.xml"));
	Reporter.setSystemInfo("Gabriel", System.getProperty("user.name"));
	Reporter.setSystemInfo("SO", "Windows 10" + "64 Bit");
	Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}

	