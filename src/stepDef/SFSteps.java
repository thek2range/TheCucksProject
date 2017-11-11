package stepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.sharedData;
import util.general.tools;
import cucumber.api.java.en.Then;

public class SFSteps
{
	@Then("^the user extracts \"(.*?)\" from \"(.*?)\"\\.$")
	public void the_user_extracts_from(String fieldName, String browserInstance) throws Throwable 
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		String emailField = tools.getElement(fieldName, browser).getText();
		sharedData.tempVariable = emailField;
		//System.out.println("emailField : " + emailField);
	}

	@Then("^the user clicks on \"(.*?)\" from \"(.*?)\" checkbox\\.$")
	public void the_user_clicks_on_from_checkbox(String fieldName, String browserInstance) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		tools.getElement(fieldName, browser).click();

	}
	
	
	@Then("^user enters \"(.*?)\" from \"(.*?)\" in \"(.*?)\"\\.$")
	public void user_enters_from_in(String key, String dataType,String browserInstance) throws Throwable {
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		System.out.println("sharedData.tempVariable : " + sharedData.tempVariable);
		if (dataType.length()>0) 
			tools.getElement( key, browser ).sendKeys(sharedData.tempVariable);	
	}
	
	@Then("^the user enters \"(.*?)\" in \"(.*?)\"\\.$")
	public void the_user_enters_in(String key, String browserInstance) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		util.general.tools.getElement(key,browser).clear();	
		util.general.tools.getElement(key,browser).sendKeys(util.general.ExcelUtility.getValue(sharedData.envConfigurationSheetInstance, key ,sharedData.autPosition));
	}
	
	@Then("^the user clicks on \"(.*?)\" Button in \"(.*?)\"\\.$")
	public void the_user_clicks_on_Button_in(String key, String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		util.general.tools.getElement(key,browser).click();	
	}

	
	@Then("^the user clicks on \"(.*?)\" link in \"(.*?)\"\\.$")
	public void the_user_clicks_on_link_in(String key, String browserInstance) throws Throwable 
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try {
			browser.findElement(By.linkText(key)).click();
		} catch (Exception e) {
			tools.getElement(key, browser).click();
		}
	}
	
	
	@Then("^the user clicks on \"(.*?)\" link by searching for \"(.*?)\"\\.$")
	public void the_user_clicks_on_link_by_searching_for(String linkName, String browserInstance) throws Throwable {
		List<WebElement> element = new ArrayList<WebElement>();
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		element = browser.findElements(By.className("td2"));
		for (int i = 0; i < element.size();i++)
		{
			System.out.println(i + " : " + element.get(i).getText());
			//			if (element.get(i).getText().toLowerCase().contains("Verify your account"))

			if (element.get(i).getText().toLowerCase().contains("developer@salesforce.com"))
			{
				element.get(i).click();
			}
		}
	}
	@Then("^the user switches from \"(.*?)\" to \"(.*?)\"\\.$")
	public void the_user_switches_from_to(String firstBrowser, String secondBrowser) throws Throwable
	{
		WebDriver browser = null;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;
		
		Set handles = browser.getWindowHandles();		 
        System.out.println(handles);
         for (String handle1 : browser.getWindowHandles()) 
         {
        	System.out.println(handle1);
        	browser.switchTo().window(handle1);
        	if (browser.getTitle().contains("Change Your Password")) {
        		sharedData.appInstance3 = browser;
				break;
			}

         }
	
	}

}
