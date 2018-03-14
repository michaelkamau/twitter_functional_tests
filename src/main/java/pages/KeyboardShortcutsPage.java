package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class KeyboardShortcutsPage extends BasePage {
    private final WebDriver driver;

    @FindBy(how = How.ID, using = "keyboard-shortcut-dialog-dialog")
    private WebElement keyboardShortcutsDialog;

    public KeyboardShortcutsPage(WebDriver driver) {
        this.driver = driver;
    }

    public final boolean isKeyboardShortcutsDialogDisplayed() {
        return keyboardShortcutsDialog.isDisplayed();
    }
}
