package assignments.week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Download and set the path 
		WebDriverManager.chromedriver().setup();
		//Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		//Maximize the window
		driver.manage().window().maximize();
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Geetha");
		//Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("Shanmugam");
		//Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		//Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("Password@123");
		
		//Handle all the three drop downs
		WebElement dropDownDay = driver.findElement(By.id("day"));
		Select dayDropDown = new Select(dropDownDay);
		dayDropDown.selectByValue("22");
		
		WebElement drpDownMonth = driver.findElement(By.id("month"));
		Select monthDropDown = new Select(drpDownMonth);
		monthDropDown.selectByValue("5");
		
		WebElement drpDownYear = driver.findElement(By.id("year"));
		Select yearDropDown = new Select(drpDownYear);
		yearDropDown.selectByValue("1985");
			
		//Select the radio button "Female" 
		List<WebElement> drpDownGender = driver.findElements(By.name("sex"));
		drpDownGender.get(0).click();
		
			
	}

}
