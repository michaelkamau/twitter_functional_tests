import org.testng.annotations.BeforeClass;
import pages.LandingPage;

public class LandingPageTest extends BaseTest {
    private LandingPage landingPage;

    @BeforeClass
    @Override
    public void setUp() throws Exception {
        super.setUp();
        landingPage = new LandingPage(driver);
    }

//    @Test
//    public void viewPromoLabelsTest() {
//        List<WebElement> promoLabels = landingPage.getPromoLabels();
//        List<String> promoLabelsStrings = promoLabels
//                .stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//
//        String[] expectedLabels = {
//                "Follow your interests.",
//                "Hear what people are talking about.",
//                "Join the conversation."
//        };

//        Assert.assertEquals(promoLabelsStrings, Arrays.asList(expectedLabels));

//    }
}
