import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LandingPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LandingPageTest extends BaseTest {
    @Test
    public void viewPromoLabelsTest() {
        List<WebElement> promoLabels = LandingPage.getPromoLabels(driver);
        List<String> promoLabelsStrings = promoLabels
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        String[] expectedLabels = {
                "Follow your interests.",
                "Hear what people are talking about.",
                "Join the conversation."
        };

        Assert.assertEquals(promoLabelsStrings, Arrays.asList(expectedLabels));

    }
}
