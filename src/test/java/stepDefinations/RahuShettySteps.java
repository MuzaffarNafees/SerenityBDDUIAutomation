package stepDefinations;

import actions.RahulShettyActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class RahuShettySteps {
    
    @Steps
    RahulShettyActions actions;
    
    @When("I open the Page")
    public void i_open_the_page() {
        actions.openPage();
    }
    
    @Then("click on RadioButton")
    public void click_on_radio_button() throws InterruptedException {
        actions.clickRadioButton();
    }
    
    @Then("Click on Suggestion")
    public void click_on_suggestion() throws InterruptedException {
        actions.clickSuggestion();
    }
    
    @Then("Click on dropdown and click on all the elements and validate")
    public void click_on_dropdown_and_click_on_all_the_elements_and_validate() throws InterruptedException {
        actions.selectDropdown();
    }
    
    @Then("Click on CheckBox")
    public void click_on_check_box() throws InterruptedException {
    	actions.clickCheckBox();
    }
      
    @Then("I click on New Window and Validate")
    public void i_click_on_new_window_and_validate() throws InterruptedException {
    	actions.SwitchWindow();

    }
    
    @Then("User click on Switch Tab and Verify")
    public void user_click_on_switch_tab_and_verify() throws InterruptedException {
    	actions.switchTab();
  
    }
    
    @Then("User Click on Alert and Handle the error with Assertions")
    public void user_click_on_alert_and_handle_the_error_with_assertions() throws InterruptedException {
    	actions.switchToAlert();

    }
  
    @Then("User handle the table and Validate it")
    public void user_handle_the_table_and_validate_it() throws InterruptedException {
    	actions.tableRowValidation();
    }
    
    @Then("User validate the total amount from the another table")
    public void user_validate_the_total_amount_from_the_another_table() {
    	actions.totalAmountValidationFromTheTable();

    }
  
    @Then("user Check the Hide and Show button")
    public void user_check_the_hide_and_show_button() {
    	actions.hideAndSHowButton();
    }

    @Then("User hovers on Hover button and validation")
    public void user_hovers_on_hover_button_and_validation() {
    	actions.hoverButtonTasks();  	
    }
  
    @Then("User Perform actions inside the Iframe")
    public void user_perform_actions_inside_the_iframe() {
    	actions.insideIframeOperations();

    }
}
