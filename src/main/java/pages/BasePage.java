package pages;

public class BasePage {
    private final static String BASE_URL = "https://twitter.com/";
    private final static String notificationsUrl = BASE_URL + "i/notifications";

    public final static String getBaseUrl() {
        return BASE_URL;
    }

    public final static String getNotificationsUrl() {
        return notificationsUrl;
    }
}
