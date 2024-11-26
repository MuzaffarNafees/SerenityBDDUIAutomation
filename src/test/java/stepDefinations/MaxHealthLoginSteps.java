package stepDefinations;

import actions.MaxHealthLoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class MaxHealthLoginSteps {
	
	@Steps
	MaxHealthLoginActions action;
	
	@Given("user launches the HIS URL")
	public void user_launches_the_his_url() throws InterruptedException {
		action.openLoginPage();

	}

	@When("user enters the {string} , {string} and enters the {string} and {string}")
	public void user_enters_the_and_enters_the_and(String username, String password, String location, String station) throws InterruptedException {
		action.login(username, password, location, station);

	}
	
	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		action.clickOnLogin();
		
	}

	@When("user launches the nursing URL")
	public void user_launches_the_nursing_url() {

	}

	@Then("user gets redirected to the nursing dashboard where entered username appears on the top")
	public void user_gets_redirected_to_the_nursing_dashboard_where_entered_username_appears_on_the_top() {

	}

	@Then("user clicks on select station section and search for the location")
	public void user_clicks_on_select_station_section_and_search_for_the_location() {

	}

	@Then("user select one patient from that station")
	public void user_select_one_patient_from_that_station() {

	}

	@Then("user redirects on patient overeview page with the details of the patient")
	public void user_redirects_on_patient_overeview_page_with_the_details_of_the_patient() {

	}

	@Then("user clicks on orders section")
	public void user_clicks_on_orders_section() {

	}

	@Then("user clicks on investigations tab")
	public void user_clicks_on_investigations_tab() {

	}

	@Then("user clicks on New button")
	public void user_clicks_on_new_button() {

	}

	@Then("user clicks on All dropdown and selects pathalogy")
	public void user_clicks_on_all_dropdown_and_selects_pathalogy() {

	}

	@Then("user search for CBC and clicks on it")
	public void user_search_for_cbc_and_clicks_on_it() {

	}

	@Then("user clicks on performance doctor list and select a doctor")
	public void user_clicks_on_performance_doctor_list_and_select_a_doctor() {

	}

	@Then("user clicks on save button and user enters an electronic sign and clicks on save button")
	public void user_clicks_on_save_button_and_user_enters_an_electronic_sign_and_clicks_on_save_button() {

	}

	@Then("added investigation should appears with status tag {string}")
	public void added_investigation_should_appears_with_status_tag(String string) {

	}
}
