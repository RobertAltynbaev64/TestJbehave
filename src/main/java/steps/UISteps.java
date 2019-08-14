package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UISteps extends Steps {

    private static WebDriver driver = null;

    @Given("I open the browser")
    public void openingBrowser() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "//");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        driver.manage().deleteAllCookies();
    }

    @When("I enter $url and hit the enter key")
    public void enteringUrl(String url) {
        driver.get(url);
    }

    @Then("$title is displayed")
    public void lookingForTheTitle(String title) {
        org.junit.Assert.assertEquals(title, driver.getTitle());
    }
}
