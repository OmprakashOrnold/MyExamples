package com.selenium.scripts;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException  {

		WebDriver companyPage=null;
		WebDriver chromeDriver = null;

		String keywords="Business Process Management";
		chromeDriver=setChromeDriver();
		if(chromeDriver!=null)
		{
			List<String> url=new ArrayList<String>();	
			url.add("https://www.google.com/search?q="+keywords);

			for (String string : url) 
			{
				companyPage=getCompanyPage(chromeDriver,string);
				for (int i =1; i <=10; i++) {
					By inputArea = By.cssSelector("div[class=rc]");
					List<WebElement> element = companyPage.findElements(inputArea);
					for (WebElement webElement : element) {

						//url
						By inputArea1 = By.cssSelector("div[class='yuRUbf']>a");
						List<WebElement> element1 = webElement.findElements(inputArea1);
						for (WebElement webElement1 : element1) {
							System.out.println(webElement1.getAttribute("href"));


							//title
							By inputArea2 = By.cssSelector("h3[class='LC20lb DKV0Md']");
							List<WebElement> element2 = webElement1.findElements(inputArea2);
							for (WebElement titleElement : element2) {
								System.out.println(titleElement.getText());
							}
						}

						//display_linlk
						By inputArea3 = By.cssSelector("div[class='TbwUpd NJjxre']>cite");
						List<WebElement> element3 = webElement.findElements(inputArea3);
						for (WebElement displayLinkElement : element3) {
							if(displayLinkElement.getText().contains("›"))
							{
								String ele[]=displayLinkElement.getText().split("›");
								System.out.println(ele[0]);
							}else{
								System.out.println(displayLinkElement.getText());
							}

						}
						//snippet
						By inputArea4 = By.cssSelector("span[class='aCOpRe']");
						List<WebElement> element4 = webElement.findElements(inputArea4);
						for (WebElement snippetElement : element4) {
							System.out.println(snippetElement.getText());
						}
						System.out.println();

					}

					clickNextPage(companyPage);
				}
			}
		}
	}


	public static void clickNextPage(WebDriver companyPage) {
		By inputArea1 = By.cssSelector("span[style='display:block;margin-left:53px']");
		WebElement element = companyPage.findElement(inputArea1);
		element.click();
	}


	public static WebDriver getCompanyPage(WebDriver driver,String url)
	{	
		try
		{
			Thread.sleep(2000);
			driver.navigate().to(url);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}


	public static WebDriver loginLinkedinWebsite(WebDriver driver) 
	{
		String loginUrl = "https://www.linkedin.com/login";				
		try
		{
			driver.get(loginUrl);
			driver.findElement(By.cssSelector("input[name='session_key']")).sendKeys("pakersam32@gmail.com");	
			driver.findElement(By.cssSelector("input[name='session_password']")).sendKeys("aldrich4u@");			
			driver.findElement(By.cssSelector("button[aria-label='Sign in']")).click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriver setChromeDriver() 
	{	
		WebDriver driver = null;
		ChromeOptions options=null;
		try
		{
			options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-notifications");
			//options.addArguments("--start-maximized");
			options.addArguments("--window-size=2000,6000");
			options.setCapability("acceptSslCerts", true);
			options.setCapability("acceptInsecureCerts", true);	
			System.setProperty("webdriver.chrome.driver","C:\\Users\\OmPrakashPeddamadtha\\Downloads\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver(options);
			driver.manage().window();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

	public static boolean isElementPresent(WebDriver driver ,By selector)
	{
		return driver.findElements(selector).size()>0;
	}

	public static void scrollBottom(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Below code will scroll the web page till end
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollByVisibility(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement el = driver.findElement(By.linkText("About Us"));	
		jse.executeScript("arguments[0].scrollIntoView();", el);
	}

	public static void scrollByPixels(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// Below code will scroll up the page by  900 pixel vertical	
		jse.executeScript("window.scrollBy(0,250)");
	}


}
