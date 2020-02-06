package com.ats.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.DashBoardPage;
import com.ats.qa.pages.LoginPage;
import com.ats.qa.util.TestUtil;

public class DashBoardPageTest extends TestBase {
	
	
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TestUtil testUtil;

	public DashBoardPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		dashBoardPage = new DashBoardPage();
		testUtil = new TestUtil();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider(name="NewProjectData")
	String [][] getData() throws IOException
	   {
		String path=System.getProperty("user.dir")+"/src/main/java/com/ats/qa/testdata/NewProjectData.xlsx";
		
		int rownum=TestUtil.getRowCount(path, "Sheet1");
		int colcount=TestUtil.getCellCount(path,"Sheet1",1);
		
		String projectData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				projectData[i-1][j]=TestUtil.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return projectData;
	}
	

	@Test(priority=1)
	public void verifyCreateNewProjectTest() throws InterruptedException {
	
		String actualCurrentUrl = dashBoardPage.createNewProject( );
 String expectedCurrentUrl = "https://spec.atsspecsolutions.com/productCategory";
 
 
		Assert.assertTrue(actualCurrentUrl.contains(expectedCurrentUrl));
	}
/* 
 * for DataDrivenApproch, we will use dataProvider which will read the data from excel sheet
	@Test(priority=1,,dataProvider="NewProjectData")
	public void verifyCreateNewProjectTest(String strProjectName,String strCountry,String strProvince,String strCity,Integer intArea) throws InterruptedException {
	
		String actualCurrentUrl = dashBoardPage.createNewProject(strProjectName,strCountry,strProvince,strCity,intArea );
 String expectedCurrentUrl = "https://spec.atsspecsolutions.com/productCategory";
 
 
		Assert.assertTrue(actualCurrentUrl.contains(expectedCurrentUrl));
	}

*/

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	

}
