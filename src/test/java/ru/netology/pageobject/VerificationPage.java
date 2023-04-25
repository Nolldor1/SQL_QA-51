package ru.netology.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    @FindBy(css = "[data-test-id = code] input")
    private SelenideElement codeField;
    @FindBy(css = "[data-test-id =action-verify]")
    private SelenideElement verifyButton;
    @FindBy(css = "[data-test-id ='error-notification']")
    private SelenideElement errorNotification;

    public void verifyVerificationPageVisiblity() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisiblity() {
        errorNotification.shouldBe(visible);

    }
    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page (DashboardPage.class);
    }
    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
