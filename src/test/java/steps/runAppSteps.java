package steps;

import com.Appium2_0_Project.Base;
import com.Appium2_0_Project.Pages.runAppPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class runAppSteps extends Base {
    @Given("User run application")
    public void user_run_application() throws Exception {
        InitializeDriver("Android");

    }

    @When("User swipe to the view button and click on")
    public void user_swipe_to_the_view_button_and_click_on() throws InterruptedException {
        runAppPage.getInstance().ScrollToTheViewButton();

    }

}
