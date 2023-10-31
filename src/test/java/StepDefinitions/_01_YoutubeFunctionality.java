package StepDefinitions;

import Pages.DialogContentForYoutube;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class _01_YoutubeFunctionality {
    DialogContentForYoutube dialogContent = new DialogContentForYoutube();

    @Given("Navigate to the page")
    public void navigateToThePage() {
        ParameterDriver.getDriver().get("https://www.youtube.com/");
    }

    @And("Search for {string} keyword")
    public void searchForKeyword(String text) {
        dialogContent.sendKeysMethod(dialogContent.searchInbox, text);
    }

    @And("Click on Search Button")
    public void clickOnSearchButton() {
        dialogContent.clickMethod(dialogContent.searchButton);
    }

    @Then("Verify that at least {string} videos are displayed")
    public void verifyThatAtLeastVideosAreDisplayed(String text) {
        int number = Integer.parseInt(text);
        int count = 0;

        dialogContent.scrollToBottomOfThePage();
        MyMethods2.myWait(3);

        for (WebElement w : dialogContent.listOfVideoElements) {
            String title = w.getAttribute("aria-label");
            if (title != null) {
                count++;
            }
        }

        Assert.assertTrue(count > number);

        System.out.println("Completed Tunahan.");
    }
}
