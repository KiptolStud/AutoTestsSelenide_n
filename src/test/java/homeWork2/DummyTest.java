package homeWork2;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.homeWork2.CredentialsModalWindowPage;
import org.homeWork2.EditingDummyPage;
import org.homeWork2.LoginPage;
import org.homeWork2.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class DummyTest extends HomeWork2AbstractTest {
    @Test
    void testEditingDummyById() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("GB2023057c4387", "cd6c4aac6c");

        StudentPage studentPage = page(StudentPage.class);
        studentPage.openEditingDummyById("18621");
        EditingDummyPage editingDummyPage = page(EditingDummyPage.class);
        final String testName = String.valueOf(System.currentTimeMillis());//для получения уникальных имен Dummy
        editingDummyPage.editDummyName(testName, "Тест");
        Selenide.sleep(3000L);
        $x("//table[@aria-label='Dummies list']").shouldHave(Condition.text(testName));
        Assertions.assertEquals("Тест " + testName, studentPage.getNameDummyById("18621"));
    }

    @Test
    void testCredentialsModalWindow() {

        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("GB2023057c4387", "cd6c4aac6c");

        StudentPage studentPage = page(StudentPage.class);
        studentPage.openCredentialsModalById("18621");
        CredentialsModalWindowPage cmwp = page(CredentialsModalWindowPage.class);
        Assertions.assertEquals("Dummy credentials", cmwp.getTextHeaderModalWindow());
        Assertions.assertEquals("CLOSE", cmwp.getTextCloseModalWindowButton());
        Assertions.assertTrue(cmwp.checkTextInContentModalWindow("Login"));
        Assertions.assertTrue(cmwp.checkTextInContentModalWindow("PW"));
    }

}
