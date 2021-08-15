package assignments.week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadInLeafTaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.Download and set the path
		WebDriverManager.chromedriver().setup();
		//2.Launch the browser
		ChromeDriver driver = new ChromeDriver();
		//3.Load the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		//4.maximize the window
		//driver.manage().window().maximize();
		//Waits for 10 second if the element is not in DOM
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//5.Locate username and enter user name as demosalesmanager
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		//6.Locate the password and enter password as crmsfa
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//7.Locate the login button and click it
		driver.findElement(By.className("decorativeSubmit")).click();
		//8.Click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter all Text fields
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LTTS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Geetha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Shanmugam");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Geetha");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Shanmugam");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Welcome");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("05/22/85");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Mrs");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("10000");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("1010");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("GS");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is sample test form");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Use it carefully");
		
		//Enter all text fields in Contact Information
		WebElement elementCountryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		elementCountryCode.clear();
		elementCountryCode.click();
		elementCountryCode.sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("65432102");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("3567");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Geetha");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testlead@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("Testleaf.com");
		
		//Enter all the text fields in primary address
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Geetha");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Geetha");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No:2");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("First street");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600001");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("100");
		
		//Drop downs
		WebElement drpDownSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourceDropDown = new Select(drpDownSource);
		sourceDropDown.selectByIndex(1);

		WebElement drpDownCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select campaignDropDown = new Select(drpDownCampaign);
		campaignDropDown.selectByValue("CATRQ_AUTOMOBILE");

		WebElement drpDownIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industryDropDown = new Select(drpDownIndustry);
		industryDropDown.selectByVisibleText("Distribution");
		
		WebElement drpDownCurrency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select currencyDropDown = new Select(drpDownCurrency);
		currencyDropDown.selectByValue("INR");
		
		WebElement drpDownOwnerShip = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownershipDropDown = new Select(drpDownOwnerShip);
		ownershipDropDown.selectByIndex(2);
		
		WebElement drpDownCountry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countryDropDown = new Select(drpDownCountry);
		countryDropDown.selectByValue("IND");
		
		WebElement drpDownProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select provinceDropDown = new Select(drpDownProvince);
		provinceDropDown.selectByVisibleText("TAMILNADU");
		
		// Get the First name and print it
		String firstNameText = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		System.out.println("First Name is : "+firstNameText);
		
		//Click on create Lead Button 
		driver.findElement(By.className("smallSubmit")).click();
		
		// Get and Verify the Title of the resulting Page(View Lead)
		if (driver.getTitle().equals("View Lead | opentaps CRM")) {
			System.out.println("View Lead page is displayed properly");
		}
		else 
			System.out.println("View Lead page is not displayed");

	} 

}
