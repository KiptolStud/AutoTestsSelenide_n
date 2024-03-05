package homeWork2;

import com.codeborne.selenide.SelenideElement;
import org.homeWork2.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationTest extends HomeWork2AbstractTest {

    @Test
    void testEmptyLoginAndPasswordAuthorization() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("", "");

        SelenideElement textErrorAuthorization = $x("//p[contains(text(), 'Invalid')]")
                .shouldBe(visible);
        Assertions.assertEquals("Invalid credentials.", textErrorAuthorization.text());
        SelenideElement numErrorAuthorization = $x("//h2[@class='svelte-uwkxn9']").shouldBe(visible);
        Assertions.assertEquals("401", numErrorAuthorization.text());
    }
}
