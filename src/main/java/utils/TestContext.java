package utils;

public class TestContext {

	private DriverFactory driverManager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		driverManager = new DriverFactory();
		pageObjectManager = new PageObjectManager(DriverFactory.iniciaBrowser());

	}

	public DriverFactory getDriverFactory() {
		return driverManager;

	}

	public PageObjectManager getPageObjectFactory() {
		return pageObjectManager;

	}

}