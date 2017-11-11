package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

		tools.getElement(fieldName, browser).click();

	}
	
	
	@Then("^user enters \"(.*?)\" from \"(.*?)\" in \"(.*?)\"\\.$")
	public void user_enters_from_in(String key, String dataType,String browserInstance) throws Throwable {
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;

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
		try {
			browser.findElement(By.linkText(key)).click();
		} catch (Exception e) {
			tools.getElement(key, browser).click();
		}
	}
}
