package Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import junit.framework.Assert;


public class orangHRM {
	
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver; 
	
	@BeforeTest
	public void setup() {
		
		System.out.println("Before Test executed");
		// TODO Auto-generated method stub
		driver=new ChromeDriver();

		//maximise windows
		driver.manage().window().maximize();

		//open url
		driver.get(baseUrl);

		//timer i kept as 60 you can keep 40
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); //60 seconds
	

}
	@Test
	public void loginTest() {
		
		//find username and enter username "Admin"
				driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

				//find password and enter password admin123
				driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

				//login button click
				driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		// Verify if the login was successful by checking the page title
				String pageTitle = driver.getTitle();

			/*	if (pageTitle.equals("OrangeHRM")) {
					System.out.println("Login successful!");
				} else {
					System.out.println("Login failed!");
				}*/


				Assert.assertEquals("OrangeHRMavs", pageTitle);
	}		
	public void logOut() 
			{
	driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	
   @AfterTest
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(10000);  // wait for 10 second
		logOut();
		driver.close();
		driver.quit();
	}
}