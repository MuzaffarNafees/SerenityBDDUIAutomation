package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MaxHealthLoginActions extends PageObject{
	
		@FindBy(xpath = "//input[@id='username']")
		public WebElementFacade usernameInput;
	
		@FindBy(xpath = "//input[@id='password']")
		public WebElementFacade passwordInput;

	    @FindBy(xpath = "//input[@id='location']") 
	    WebElementFacade locationInput;
	    
		@FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
		public WebElementFacade selectfromdropdown;

	    @FindBy(id = "stationField") 
	    WebElementFacade stationInput;

		@FindBy(xpath = "//button[@type='submit']")
		public WebElementFacade loginButton;
		
	@Step("Open the URL")
	  public void openLoginPage() throws InterruptedException {
	        openUrl("https://opensource-demo.orangehrmlive.com/");
	        Thread.sleep(5000);
	    }
		
	@Step("Enter login credentials")
	public void login(String username, String password, String location, String station) throws InterruptedException {
		usernameInput.click();
		usernameInput.type(username + Keys.TAB);
		Thread.sleep(1000);
		passwordInput.click();
		passwordInput.type(password + Keys.TAB);
		
        //locationInput.sendKeys(location);
        //stationInput.sendKeys(station);
        
        Thread.sleep(8000);
		locationInput.click();
		locationInput.type(location);
		selectfromdropdown.click();
		
		stationInput.waitUntilVisible().type(station);
		selectfromdropdown.click();
    }
	
	@Step("Click on login Button")
	public void clickOnLogin() {
		loginButton.click();
	}

}
