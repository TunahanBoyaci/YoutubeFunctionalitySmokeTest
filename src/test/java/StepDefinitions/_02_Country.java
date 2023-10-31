package StepDefinitions;

import Pages.DialogContent;
import Pages.DialogContentForYoutube;
import Pages.LeftNavBar;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _02_Country {
    DialogContent dialogContent = new DialogContent();
    LeftNavBar leftNavBar = new LeftNavBar();

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        ParameterDriver.getDriver().get("https://test.mersys.io/");
    }

    @Given("Enter username and password")
    public void enter_username_and_password() {
        dialogContent.sendKeysMethod(dialogContent.usernameInbox,"turkeyts");
        dialogContent.sendKeysMethod(dialogContent.passwordInbox,"TechnoStudy123");
    }

    @When("Click on login Button")
    public void click_on_login_button() {
        dialogContent.loginButton.click();
    }

    @And("Navigate to Country page")
    public void navigateToCountryPage() {
        leftNavBar.clickMethod(leftNavBar.setupButton);
        leftNavBar.clickMethod(leftNavBar.parametersButton);
        leftNavBar.clickMethod(leftNavBar.countriesButton);
    }

    @When("Create a new country")
    public void createANewCountry() {
        dialogContent.clickMethod(dialogContent.addButton);
        dialogContent.sendKeysMethod(dialogContent.nameInbox,"7ryf");
        dialogContent.sendKeysMethod(dialogContent.codeInbox,"9yr7");
        dialogContent.clickMethod(dialogContent.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContent.assertText(dialogContent.successMessage,"successfully");
    }

}
