package steps;

import com.Appium2_0_Project.Base;
import com.Appium2_0_Project.Pages.androidGesturesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class androidGesturesSteps extends Base {
    @When("User drag and drop the element")
    public void user_drag_and_drop_the_element() {
       // androidGesturesPage.getInstance().performDragAndDrop();

    }

    @And("User click long click")
    public void User_click_long_click()  {
       // androidGesturesPage.getInstance().performLongClick();
}

    @And("User zoom In and zoom out")
    public void User_zoom_In_and_zoom_out() {

    }

    @And("User swipe")
    public void User_swipe() {
       // androidGesturesPage.getInstance().performSwipe();

    }

    @And("User scroll to the element")
    public void User_scroll_to_the_element(){
        androidGesturesPage.getInstance().scrollToTheElement();

    }


}
