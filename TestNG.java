
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestNG {

	private WebDriver driver;

	@BeforeMethod
    public void gotoPage(){


		//Setting driver properties and Initiating driver object

	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\chromedriver.exe");
      driver = new ChromeDriver();

		//going to the base URL(gmail.com in this question)
      driver.navigate().to("http://www.gmail.com");

      driver.manage().window().maximize();
		//wait for 4 seconds until the gmail page.This is to ensure that entire page is loaded inorder to perform any test
      driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
}

	@Test
public void login() throws Exception{


	//Entering email address and clicking the next button
	driver.findElement(By.id("Email")).sendKeys("amalkaru93@gmail.com");
	driver.findElement(By.id("next")).click();

	//wait 3 seconds until password entering page completely loads
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	//Entering email password and clicking the Sign in button
	driver.findElement(By.id("Passwd")).sendKeys("amal12345");
	driver.findElement(By.id("signIn")).click();

	//wait 3 seconds until email account is loaded
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	//clicking the compose button
	driver.findElement(By.cssSelector(".aic .z0 div")).click();

	//wait 1 second until compose message screen appears
	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

	//entering recipients address
	driver.findElement(By.cssSelector(".oj div textarea")).sendKeys("amalkaru93@gmail.com");


	//entering the subject of the email
	driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium IDE exercise-01");
	driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

	//Clicking send button
	driver.findElement(By.cssSelector("tr.n1tfz td:nth-of-type(1) div div:nth-of-type(2)")).click();
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	//verification process
    driver.findElement(By.xpath("//a[@title='Sent Mail']")).click();
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	driver.findElement(By.xpath("//div[@class='span']//span[text()='Selenium IDE exercise-01']"));
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);


  }

      @AfterMethod
 public void Exit(){
	 driver.close();
	 driver.quit();
	 }

}

