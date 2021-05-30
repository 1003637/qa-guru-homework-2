import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchTest {
    private String wiki = "Wiki",
                   softAssertionLink = "Soft assertions",
                   softAssertionText = "SoftAssertions";

    @BeforeEach
    void setUp(){
        Configuration.startMaximized = true;
        open("https://github.com/selenide/selenide");
    }
    @Test
    void softAssertionsTest(){
        $(byText(wiki)).click();
        $$("li a").find(text(softAssertionLink)).click();
        $$("h1").get(1).shouldHave(text(softAssertionText));
        $$("#wiki-body").find(text("Using JUnit5 extend test class:")).shouldBe(visible);
    }
}
