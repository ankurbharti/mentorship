package mentors;



import static org.testng.Assert.assertEquals;

	import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.openqa.selenium.JavascriptExecutor;


	import io.github.bonigarcia.wdm.WebDriverManager;
	import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;


	public class demosite {
		
		public WebDriver driver;
		
		
		
		@BeforeTest
		public void BT()
		{
			// setting up chrome driver from WDM.
					WebDriverManager.chromedriver().setup();
					// this line to open a chrome browser.
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					// i want to open URL
					//driver.get("https://opensource-demo.orangehrmlive.com/");
					driver.get("https://phptravels.org/demo/");
					
		}
		@Test(priority = 0 ,enabled =  false)
		public void signup() throws InterruptedException
		{ 
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
			driver.findElement(By.linkText("Sign up")).click();		
			Thread.sleep(3000);
			Set<String> allWindows = driver.getWindowHandles();
			System.out.println(allWindows);
			String lastWindow = "";
			for (String handle : allWindows)
			{
				driver.switchTo().window(handle);
				lastWindow = handle;
			}
			driver.findElement(By.name("firstname")).sendKeys("ankurw");
			driver.findElement(By.name("lastname")).sendKeys("bhartiw");
			driver.findElement(By.name("email")).sendKeys("ankurrwe@gmail.com");
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.findElement(By.xpath("//*[contains(text(),'+92')]")).click();
			WebElement country = driver.findElement(By.xpath("//span[contains(text(),'India (भारत)')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", country);
			country.click();
			
			//driver.findElement(By.xpath("//*[@class='selected-dial-code']")).sendKeys("+91");
			driver.findElement(By.name("phonenumber")).sendKeys("9844571822");
			js.executeScript("window.scrollBy(0,250)");
			
			driver.findElement(By.name("address1")).sendKeys("patna");
			
			driver.findElement(By.name("address2")).sendKeys("patna1");
			
			driver.findElement(By.name("city")).sendKeys("patna12");
					
			
			WebElement bc = driver.findElement(By.id("inputCountry"));
			Select sel1= new Select(bc);
			sel1.selectByVisibleText("India");
			bc.click();
			
			js.executeScript("window.scrollBy(250,350)");
			
			driver.findElement(By.name("customfield[2]")).sendKeys("9844571820");
			
			driver.findElement(By.name("password")).sendKeys("Pass!123");
			
			driver.findElement(By.name("password2")).sendKeys("Pass!123");
			
			js.executeScript("window.scrollBy(350,450)");
			
			//WebElement captcha = driver.findElement(By.xpath("//body[@class='recaptcha-checkbox-checkmark']"));
			//WebDriverWait wt = new WebDriverWait(driver,10);
		//	wt.until(ExpectedConditions.elementToBeClickable (By.xpath("//body[@class='recaptcha-checkbox-checkmark']")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/iframe[1]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block  btn-recaptcha']")).click();
			
			
			
			//captcha.click();
			
			
			//driver.findElement(By.name("country")).sendKeys("India");
			}
		@Test(priority = 1 ,enabled = true )
		public void login() throws InterruptedException
		{
			String expectedresults = "Welcome Back, ankur" ;
			String actualresults;
			
			//System.out.println(driver.getTitle());
			//System.out.println(driver.findElement(By.xpath("//h1[@class='login-title']")).getText());
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@href='https://phptravels.org/login.php']")).click();
			
			driver.findElement(By.name("username")).sendKeys("ankurr@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass!123");
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			
			driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/iframe[1]")).click();
			Thread.sleep(10000);
			// Capcha opening here
			/*WebElement abc = driver.findElement(By.xpath("//*[@class='rc-button-default goog-inline-block']"));
			while(abc.isDisplayed()==false)
			{
				driver.findElement(By.xpath("//*[@id='login']")).click();
			}*/
			
			driver.findElement(By.xpath("//*[@id='login']")).click();
			Thread.sleep(3000);
			actualresults = driver.getTitle();
			Assert.assertEquals(expectedresults, actualresults);
			

		}
		
		@Test(priority = 2 ,enabled = true)
		public void dashboard() throws InterruptedException
		{
			//System.out.println(driver.getTitle());
			String expectedresults = "My Dashboard";
			String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
			Assert.assertEquals(expectedresults, actualresults);
			driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			//js.executeScript("window.scrollBy(0,200)");
			driver.findElement(By.xpath("//a[contains(text(),'Order New Services')]")).click();
			driver.findElement(By.id("Secondary_Sidebar-Categories-Installation")).click();
			driver.findElement(By.id("Secondary_Sidebar-Categories-License")).click();
			driver.findElement(By.id("Secondary_Sidebar-Categories-Mobile")).click();
			driver.findElement(By.id("Secondary_Sidebar-Categories-Services")).click();
			driver.findElement(By.id("Secondary_Sidebar-Categories-API")).click();
			
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			
			driver.findElement(By.id("Secondary_Sidebar-Categories-Addons")).click();
			
			Thread.sleep(2000);	
			
		}
		
		@Test(priority = 3,enabled = true)
		public void services()
		{
			
			driver.findElement(By.id("Primary_Navbar-Services")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Order New Services')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Domains')]")).click();
			driver.findElement(By.id("Secondary_Sidebar-My_Domains_Actions-Renew_Domain")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Domains')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Register a New Domain')]")).click();
			

			String expectedresults = "PHPTRAVELS Products";
			String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
			Assert.assertEquals(expectedresults, actualresults);
			
		}
			
		@Test(priority = 4,enabled = true)
		public void billing() throws InterruptedException
		{
		driver.findElement(By.xpath("//span[contains(text(),'Billing')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@href='/clientarea.php?action=invoices']")).click();
		String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
		String expectedresults = "My Invoices";
		Assert.assertEquals(expectedresults, actualresults);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='Secondary_Sidebar-Billing-Quotes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='Secondary_Sidebar-Billing-Mass_Payment']")).click();
		
		}
		
			@Test(priority = 5,enabled = true)
			public void support() throws InterruptedException
			{
				driver.findElement(By.xpath("//span[contains(text(),'Support')]")).click();
				driver.findElement(By.id("Primary_Navbar-Support-Tickets")).click();
				String expectedresults = "My Support Tickets";
				String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
				Assert.assertEquals(expectedresults, actualresults);
				
				driver.findElement(By.xpath("//td[@class='dtr-control']")).click();
				driver.findElement(By.xpath("//h4[@class='panel-title']")).click();
				driver.findElement(By.name("replymessage")).sendKeys("problem");
				
				JavascriptExecutor js1 = (JavascriptExecutor)driver;
				js1.executeScript("window.scrollBy(0, document.body.scrollHeight)");
				
				driver.findElement(By.name("save")).sendKeys("Submit");
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//input[@name='save']")).click();
				
				JavascriptExecutor js2 = (JavascriptExecutor)driver;
				js2.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	
				driver.findElement(By.id("Secondary_Sidebar-Support-Announcements")).click();
				driver.findElement(By.id("Secondary_Sidebar-Support-Knowledgebase")).click();
				driver.findElement(By.id("Secondary_Sidebar-Support-Downloads")).click();
				
				driver.findElement(By.xpath("//div[@class='list-group-item-heading']")).click();
				
				
				driver.findElement(By.id("Secondary_Sidebar-Support-Network_Status")).click();
				driver.findElement(By.id("Secondary_Sidebar-Support-Open_Ticket")).click();
				
				//driver.findElement(By.name("message")).sendKeys("problem");
				

			}
			
			@Test(priority = 6 ,enabled = true)
			public void Affiliates()
			{
				driver.findElement(By.xpath("//span[contains(text(),'Affiliates')]")).click();
				
				String expectedresults = "Affiliates";
				String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
				Assert.assertEquals(expectedresults, actualresults);
				
			}
			
			@Test(priority = 7 ,enabled = true)
			public void OpenTickets()
			{
				driver.findElement(By.xpath("//span[contains(text(),'Open Ticket')]")).click();
				String expectedresults = "Open Ticket";
				String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
				Assert.assertEquals(expectedresults, actualresults);
				
				driver.findElement(By.xpath("//div[contains(text(),'General Support')]")).click();
				
				JavascriptExecutor js2 = (JavascriptExecutor)driver;
				js2.executeScript("window.scrollBy(0, 100)");
				driver.findElement(By.name("subject")).sendKeys("problem");
				
				js2.executeScript("window.scrollBy(100, 250)");
				driver.findElement(By.name("message")).sendKeys("problem");
				driver.findElement(By.id("openTicketSubmit")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
				
				
				
			}
			
			@Test(priority =8 ,enabled = true)
			public void Viewcart()
			{
				driver.findElement(By.xpath("//span[contains(text(),'View Cart')]")).click();
				
				String expectedresults = "Review & Checkout";
				String actualresults = driver.findElement(By.xpath("//*[@class='main-header-title']")).getText();
				Assert.assertEquals(expectedresults, actualresults);
				
				driver.findElement(By.xpath("//a[contains(text(),'Start Shopping')]")).click();
				
				
				


			}
			
			
		
		
		@Test(priority = 9 ,enabled = true)
		public void logout() throws InterruptedException
		{ 
			String expectedresults = "Secure Client Login" ;
			String actualresults;
			
			System.out.println(driver.getTitle());
			
			//JavascriptExecutor js2 = (JavascriptExecutor)driver;
			//js2.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			
			driver.findElement(By.xpath("//span[@class='item-text'][contains(text(),'ankur bharti')]")).click();
			
			driver.findElement(By.xpath("//*[@href='/logout.php']")).click();
					
			//By.xpath("//*[contains(text(),'Logout')]"))
			Thread.sleep(3000);
			
			//System.out.println(driver.findElement(By.xpath("//h1[@class='login-title']")).getText());
			actualresults = driver.findElement(By.xpath("//h1[@class='login-title']")).getText();
			Assert.assertEquals(expectedresults, actualresults);
		}
		
		
		
		
		@AfterTest
		public void AT() throws InterruptedException
		{   
			Thread.sleep(2000);
			driver.quit();
			
			
	    }
		
		

	}
	

