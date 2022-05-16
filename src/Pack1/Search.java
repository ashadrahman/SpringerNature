package Pack1;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



//this is testing.

public class Search {

	WebDriver driver;
	@Test
	public void ValidateSearch()
	{
		try {
			
			String product = "Computer";
			
			//Browser setup and navigate
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://link.springer.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			//checkpoint1
			String expected_title = "Home - Springer";
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Title is correct");
			
			//Search for item
			WebElement txtbx_search = driver.findElement(By.xpath("//*[@id='query']"));
			txtbx_search.sendKeys(product);
			
			driver.findElement(By.xpath("//*[@id='search']")).click();
			
			//Check point2
			expected_title = "Search Results - Springer";
			actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Product search Title is correct");
			
			//Check point3
			String searched_product = driver.findElement(By.xpath("//*[@id='number-of-search-results-and-search-terms']/strong[2]")).getText();
			searched_product = "'"+searched_product+"'";
			Assert.assertEquals(product, searched_product, "Searched product is correct");
			
			String result_number = driver.findElement(By.xpath("//*[@id='number-of-search-results-and-search-terms']/strong[1]")).getText();
			System.out.println(result_number + " Result(s) for "+ searched_product);
						
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
