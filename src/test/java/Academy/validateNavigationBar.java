	package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class validateNavigationBar extends Base{
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	
	public void intialize() throws IOException
	{
		driver=initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	
	public void validateAppNavBar() throws IOException
	{
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigated bar is displayed");
		
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
