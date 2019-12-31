package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header=By.cssSelector("div[class*='video-banner'] h3");
	
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}
