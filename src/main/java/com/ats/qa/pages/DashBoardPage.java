package com.ats.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ats.qa.base.TestBase;

public class DashBoardPage extends TestBase {
	
	@FindBy(xpath="//span[text()='New Project']")
	WebElement createNewProject;

	@FindBy(xpath="//label[text()='Project Name *']/ancestor::div[1]/div/input")
	WebElement projectName;

	@FindBy(xpath="//label[text()='Country *']/ancestor::div[1]/div/div/input")
	WebElement country;
	
	@FindBy(xpath="//label[text()='State/Province *']/ancestor::div[1]/div/div/input")
	WebElement province;

	@FindBy(xpath="//label[text()='City *']/ancestor::div[1]/div/div/input")
	WebElement city;

	@FindBy(xpath="//label[text()='Bid Date *']/ancestor::div[1]/div/input")
	WebElement birthDate;
	
	@FindBy(xpath="//label[text()='Area (in sq. ft.) *']/ancestor::div[1]/div/input")
	WebElement area;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;

	@FindBy(xpath="//p[text()='Education']")
	WebElement educationAsBuildingClass;

	@FindBy(xpath="//span[text()='College / University']")
	WebElement collegeAsBuildingType;
	
	@FindBy(xpath="//span[text()='Finish']")
	WebElement finish;
	
	
	//Initializing the Page Objects:
		public DashBoardPage(){
			PageFactory.initElements(driver, this);
		}
		/** this method creates new project and eventually it will take parameters from the excel sheet as 
		 * test data when we will implement data driven approach
		 * 
		 * @return currentUrl = currentUrl of the page 
		 */
		public String createNewProject() {
			createNewProject.click();
			projectName.sendKeys("ATSAutomation");
			country.sendKeys("Canada");
			province.sendKeys("Ontario");
			staticTimeWait(2000);
			city.sendKeys("Toronto");
			birthDate.sendKeys("1990-05-05");
			area.sendKeys("12345");
			next.click();
			educationAsBuildingClass.click();
			collegeAsBuildingType.click();
			next.click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Finish']")));
			finish.click();
			staticTimeWait(2000);
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}

}
