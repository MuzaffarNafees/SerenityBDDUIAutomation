package actions;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

public class RahulShettyActions extends PageObject {

	//I will define locators here
    private By radioButton = By.name("radioButton"); 
    //private By suggestionBox = By.id("autocomplete"); 
    //private By suggestionOption=By.xpath("//li[contains(text(),'India')]");
    private By dropdown = By.id("dropdown-class-example");
    private By checkBox1 = By.id("checkBoxOption1"); 
    private By checkBox2 = By.id("checkBoxOption2"); 
    private By checkBox3 = By.id("checkBoxOption3"); 

    private By suggestionInput = By.id("autocomplete"); 
    private By suggestionsList = By.cssSelector(".ui-menu-item"); 
    
    @Step("Open the Rahul Shetty Academy page")
    public void openPage() {
        openUrl("https://rahulshettyacademy.com/AutomationPractice/"); 
    }

    @Step("Click on the Radio Button")
    public void clickRadioButton() throws InterruptedException {
        getDriver().findElement(radioButton).click();
        Thread.sleep(3000);    
        }

    @Step("Click on the Suggestion box")
    public void clickSuggestion() throws InterruptedException {
    	
    	  WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

          wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionInput));
          WebElement inputBox = getDriver().findElement(suggestionInput);
          inputBox.clear();
          inputBox.sendKeys("India");
          Thread.sleep(3000);    


          wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(suggestionsList));         
          List<WebElement> suggestions = getDriver().findElements(suggestionsList);
          boolean foundIndia = false;
          for (WebElement suggestion : suggestions) {
              if (suggestion.getText().equalsIgnoreCase("India")) {
                  suggestion.click();
                  foundIndia = true;
                  break;
              }
          }
          Thread.sleep(3000);    
          Assertions.assertThat(foundIndia).as("Suggestion 'India' should be available and selected").isTrue();
      }  	
    @Step("Select an option from the dropdown")
    public void selectDropdown() throws InterruptedException {
        
        WebElement dropdownElement = getDriver().findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(dropdownElement);
        Thread.sleep(3000);    


        dropdown.selectByValue("option1");  
        
        assertThat(dropdown.getFirstSelectedOption().getText())
            .as("Option 1 should be selected")
            .isEqualTo("Option1");

        dropdown.selectByValue("option2");       
        assertThat(dropdown.getFirstSelectedOption().getText())
            .as("Option 2 should be selected")
            .isEqualTo("Option2");

        dropdown.selectByValue("option3");        
        assertThat(dropdown.getFirstSelectedOption().getText())
            .as("Option 3 should be selected")
            .isEqualTo("Option3");        
    }

    @Step("Click on the Checkbox")
    public void clickCheckBox() throws InterruptedException {
        getDriver().findElement(checkBox1).click();
        Thread.sleep(3000);    

        getDriver().findElement(checkBox2).click();
        Thread.sleep(3000);    

        getDriver().findElement(checkBox3).click();
        Thread.sleep(3000);    

        
        assertThat(getDriver().findElement(checkBox1).isSelected())
        .as("Checkbox 1 should be selected")
        .isTrue();
    
        assertThat(getDriver().findElement(checkBox2).isSelected())
        .as("Checkbox 2 should be selected")
        .isTrue();
    
        assertThat(getDriver().findElement(checkBox3).isSelected())
        .as("Checkbox 3 should be selected")
        .isTrue();

    }
    
    @Step("Switch Window")
    public void SwitchWindow() throws InterruptedException {
        WebElement switchButton = getDriver().findElement(By.id("openwindow"));
        switchButton.click();
        Thread.sleep(3000);    

        String originalWindow = getDriver().getWindowHandle();
        
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                getDriver().switchTo().window(windowHandle);
                break; 
            }
        }
        Thread.sleep(3000);    

        String newWindowTitle = getDriver().getTitle();
        assertThat(newWindowTitle)
            .as("New window title should match")
            .isNotEmpty(); 
        getDriver().close();
        
        getDriver().switchTo().window(originalWindow);
        
        String originalWindowTitle = getDriver().getTitle();
        assertThat(originalWindowTitle)
            .as("Original window title should match")
            .isNotEmpty(); 
    }
    
    
    
    @Step("Switch Tab")
    public void switchTab() throws InterruptedException {
    	
        WebElement openTabLink = getDriver().findElement(By.id("opentab"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red';", openTabLink);
        openTabLink.click();
        Thread.sleep(3000);    


        String mainTabHandle = getDriver().getWindowHandle(); 
        for (String handle : getDriver().getWindowHandles()) {
        	getDriver().switchTo().window(handle);
        }
      
        String newTabURL=getDriver().getCurrentUrl();
        Assertions.assertThat(newTabURL).isNotEqualTo("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);    

        getDriver().close(); 
        
        getDriver().switchTo().window(mainTabHandle);
        System.out.println("Returned to the main page.");
        Thread.sleep(3000);    

        
        String currURL= getDriver().getCurrentUrl();
        Assertions.assertThat(currURL).isEqualTo("https://rahulshettyacademy.com/AutomationPractice/");
   	
    }
    
    @Step("Switch to Alert")
    public void switchToAlert() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement alertSection = getDriver().findElement(By.id("name"));
        js.executeScript("window.scrollBy(0, 200);");
        alertSection.sendKeys("Muzaffar");
        Thread.sleep(3000);    


        WebElement alertButton = getDriver().findElement(By.id("alertbtn"));
        alertButton.click();
        Thread.sleep(3000);    

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            
            Assertions.assertThat(alertText).contains("Muzaffar");
            
            alert.accept();
        } catch (TimeoutException e) {
            throw new RuntimeException("Alert was not present after clicking the alert button.");
        }
        Thread.sleep(3000);    


        alertSection.clear();
        alertSection.sendKeys("Nafees");
        WebElement confirmButton = getDriver().findElement(By.id("confirmbtn"));
        confirmButton.click();
        try {
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());  // Wait for confirm alert
            String confirmAlertText = confirmAlert.getText();           
            Assertions.assertThat(confirmAlertText).contains("Nafees");
            
            confirmAlert.accept();
        } catch (TimeoutException e) {
            throw new RuntimeException("Confirmation alert was not present after clicking the confirm button.");
        }
    }

    
    @Step("Table 4th row Validation")
    public void tableRowValidation() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();   	

    	 js.executeScript("window.scrollBy(0, 250);");
         Thread.sleep(3000);    


        WebElement fourthRow = getDriver().findElement(By.xpath("//table[@id='product']/tbody/tr[5]"));
        String fourthRowText = fourthRow.getText();
      
        Assertions.assertThat(fourthRowText)
            .contains("WebSecurity Testing for Beginners-QA knowledge to next level")
            .contains("20");

        Thread.sleep(3000);    

        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", fourthRow);
  	
    }
    
    
    @Step("Hover Button")
    public void hoverButtonTasks() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();   	
        js.executeScript("window.scrollBy(0, 400);");

         WebElement hoverButton = getDriver().findElement(By.id("mousehover"));
         Actions actions = new Actions(getDriver());
         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red';", hoverButton);

         actions.moveToElement(hoverButton).perform();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
         WebElement topLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Top")));

         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red';", topLink);
         
         Assertions.assertThat(topLink.isDisplayed()).isTrue();
         Assertions.assertThat(topLink.isEnabled()).isTrue();
         WebElement topOption = getDriver().findElement(By.xpath("//a[contains(text(),'Top')]"));
        
         topOption.click();
         System.out.println("Clicked on 'Top' option.");
         js.executeScript("window.scrollBy(0, 1000);");

         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red';", hoverButton);
         actions.moveToElement(hoverButton).perform();
   
         WebElement reloadOption = getDriver().findElement(By.xpath("//a[contains(text(),'Reload')]"));
         WebElement reloadLink = getDriver().findElement(By.linkText("Reload"));

         ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red';", reloadLink);
         
         Assertions.assertThat(reloadLink.isDisplayed()).isTrue();
         Assertions.assertThat(reloadLink.isEnabled()).isTrue();
         reloadOption.click();
  	
    }
    
    
    @Step("Validate the total amount from the fixed table")
    public void totalAmountValidationFromTheTable() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();   	
	
    	  WebElement tableFixHeadDiv = getDriver().findElement(By.cssSelector("div.tableFixHead"));
          js.executeScript("arguments[0].style.border = '3px solid blue'", tableFixHeadDiv); 
         
          List<WebElement> rows = tableFixHeadDiv.findElements(By.tagName("tr"));
          int totalAmount = 0;

          for (int i = 1; i < rows.size(); i++) {
              List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
              int amount = Integer.parseInt(cols.get(3).getText()); 
              totalAmount += amount;

          }
          
          Assertions.assertThat(totalAmount).isEqualTo(296);    	
    	
    }
        
    @Step("Hide and Show button Validation")
    public void hideAndSHowButton() {
    	 WebElement hideButton = getDriver().findElement(By.id("hide-textbox"));
         hideButton.click();
         
         WebElement textBox=getDriver().findElement(By.id("displayed-text"));
         Assertions.assertThat(textBox.isDisplayed()).isFalse();
         
         WebElement showButton = getDriver().findElement(By.id("show-textbox"));
         showButton.click();         
         Assertions.assertThat(textBox.isDisplayed()).isTrue();  	
    }
       
    @Step("IFrame Operations")
    public void insideIframeOperations() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();   	
   	
    	while (true) {
            js.executeScript("window.scrollBy(0, 700);");
            try {
                WebElement iframe = getDriver().findElement(By.id("courses-iframe"));
                if (iframe.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
            }
        }

        js.executeScript("window.scrollBy(0, 700);"); 

        WebElement iframe = getDriver().findElement(By.id("courses-iframe"));
        getDriver().switchTo().frame(iframe);
        js.executeScript("window.scrollBy(0, 200);"); 

        WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement moreButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'dropdown')]//a[contains(text(), 'More')]")));
        
        Assertions.assertThat(moreButton.isDisplayed()).isTrue();
        Assertions.assertThat(moreButton.isEnabled()).isTrue();
        moreButton.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]")));
        WebElement aboutUsLink = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'dropdown')]//a[contains(text(), 'About us')]")));
        
        Assertions.assertThat(aboutUsLink.isDisplayed()).isTrue();
        Assertions.assertThat(aboutUsLink.isEnabled()).isTrue();
        aboutUsLink.click();

    } 

        	
    }

	
