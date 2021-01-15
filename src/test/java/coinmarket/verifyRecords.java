package coinmarket;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.List;

public class verifyRecords extends TestBase {
    public static WebDriver driver;
    public static int records;
    HomePage homeObject;

    @Given("^The user navigates to https://coinmarketcap\\.com/$")
    public void the_user_navigates_to_https_coinmarketcap_com() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject = new HomePage(driver);
        homeObject.clickShowRecords();
    }

    @When("^I select show (\\d+) records$")
    public void i_select_show_records(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homeObject.clickRecordNumber();
    }

    @Then("^The page displays (\\d+) records successfully$")
    public void the_page_displays_records_successfully(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> element = driver.findElements(By.xpath("//td//span[contains(@class,'icon-Star')]"));
        int records = element.size();
        if (records == 100) {
            System.out.println("Test Pass");
        }

    }
}