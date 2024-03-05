package org.homeWork2;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CredentialsModalWindowPage {

    private final SelenideElement headerModalWindow = $x("//h2[@id='simple-title']");

    private final SelenideElement contentModalWindow = $x("//div[@id='simple-content']");echo "# AutoTestsSelenide_n" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/KiptolStud/AutoTestsSelenide_n.git
    git push -u origin main

    private final SelenideElement closeModalWindowButton =
            $x("//button[@data-mdc-dialog-action='closeShowCredentials']");


    public String getTextHeaderModalWindow() {
        return headerModalWindow.shouldBe(visible).text();
    }

    public String getTextCloseModalWindowButton() {
        return closeModalWindowButton.shouldBe(visible).text();
    }

    public Boolean checkTextInContentModalWindow(String text) {
        String textContent = contentModalWindow.shouldBe(visible).text();
        return textContent.contains(text);
    }
}
