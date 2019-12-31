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

public class validateTitle extends Base{
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage l;
	
	@BeforeTest
	
	public void intialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}

	@Test
	
	public void validateAppTitle() throws IOException
	{	
		
		l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES1");
		log.info("Title successfully validated");
		
	}
	
	@Test
	public void validateHeader() throws IOException
	{
		
		l=new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Header successfully validated");
		
	}
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
