package StepDefinitions;

import Pages.DialogContent;
import Utilities.MyMethods2;
import Utilities.ParameterDriver;
import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.asynchttpclient.Param;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class YoutubeFunctionality {
    DialogContent dialogContent = new DialogContent();

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
    }
}
