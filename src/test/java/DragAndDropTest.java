import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    private String textA = "A",
                   textB = "B",
                   headerText = "Drag and Drop";

    private SelenideElement boxA = $("#column-a"),
                            boxB = $("#column-b"),
                            header = $("h3");

    @BeforeEach
    void setUp(){
        Configuration.startMaximized = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @Test
    void dragAndDropTestFirst(){
            header.shouldHave(text(headerText));
            boxA.shouldHave(text(textA));
            boxB.shouldHave(text(textB));

            boxA.dragAndDropTo(boxB);

            boxA.shouldHave(text(textB));
            boxB.shouldHave(text(textA));
    }

    @Test
    void dragAndDropTestSecond(){
        header.shouldHave(text(headerText));
        boxA.shouldHave(text(textA));
        boxB.shouldHave(text(textB));

        actions().dragAndDropBy(boxA, 10,10).perform();

        boxA.shouldHave(text(textB));
        boxB.shouldHave(text(textA));
    }
}
