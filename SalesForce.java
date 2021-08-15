package assignments.week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Download and set the path 
		WebDriverManager.chromedriver().setup();
		//Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		//Maximize the window
		driver.manage().window().maximize();
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Fill in all the text boxes
		driver.findElement(By.name("UserFirstName")).sendKeys("geetha");
		driver.findElement(By.name("UserLastName")).sendKeys("SHanmugam");
		driver.findElement(By.name("UserEmail")).sendKeys("geetha_TestLeaf@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("LTTS");
		driver.findElement(By.name("UserPhone")).sendKeys("9876543201");
		//Handle all the dropdowns
		
		WebElement drpDownTitle = driver.findElement(By.name("UserTitle"));
		Select titleDropDown = new Select(drpDownTitle);
		titleDropDown.selectByValue("IT_Manager_AP");
		WebElement drpDownEmployee = driver.findElement(By.name("CompanyEmployees"));
		Select employeeDropDown = new Select(drpDownEmployee);
		employeeDropDown.selectByValue("250");
		WebElement drpDownCountry = driver.findElement(By.name("CompanyCountry"));
		Select countryDropDown = new Select(drpDownCountry);
		countryDropDown.selectByValue("IN");
		
		//Click the check box
		driver.findElement(By.className("checkbox-ui")).click();
		
		//Close the browser
		driver.close();

	}

}
