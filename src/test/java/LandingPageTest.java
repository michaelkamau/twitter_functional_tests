import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LandingPageTest extends BaseTest {
    private LandingPage landingPage;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        landingPage = new LandingPage(driver);
    }

    @Test
    public void viewPromoLabelsTest() {
        List<WebElement> promoLabels = landingPage.getPromoLabels();
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
