package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.PageObject;

public class punchInOutMethod extends PageObject {
	
    public void openLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/");
        getDriver().manage().window().maximize();

    }

	
    public void enterUsername() {
        WebElement usernameField = getDriver().findElement(By.name("username"));
        usernameField.sendKeys("Admin");
    }

    public void enterPassword() {
        WebElement passwordField = getDriver().findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        WebElement loginButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }
    
    public void clickOnTimeSection() throws InterruptedException {
    	WebElement time= getDriver().findElement(By.xpath("//a[span[text()='Time']]"));
    	time.click();
    	
    	Thread.sleep(3000);
    	System.out.print("clicked on Time?");
    	
    }
        
    public void attendenceDropDown() {
    	WebElement Attendance= getDriver().findElement(By.xpath("//span[normalize-space()='Attendance']//i[@class='oxd-icon bi-chevron-down']"));
    	Attendance.click();
    	
    }
    
    public void punInOutSection() {
    	WebElement pInOut= getDriver().findElement(By.xpath("//a[normalize-space()='Punch In/Out']"));
    	pInOut.click();
    	
    }
    
    public void clickOnIn() throws InterruptedException {
    	WebElement in= getDriver().findElement(By.xpath("//button[normalize-space()='In']"));
    	in.click();
    	Thread.sleep(10000);
    	
    }
    
    public void clickOnOut() {
    	WebElement out= getDriver().findElement(By.cssSelector("button[type='submit']"));
    	out.click();
    	
    }
       
    public void clickOnProfilePic() {
    	WebElement pPic= getDriver().findElement(By.cssSelector(".oxd-userdropdown-tab"));
    	pPic.click();
    	
    }
    
    public void logOut() {
    	WebElement logOut= getDriver().findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > header:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)"));
    	logOut.click();
    	
    }


}
