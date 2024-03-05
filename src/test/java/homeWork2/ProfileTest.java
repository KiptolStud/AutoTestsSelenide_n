package homeWork2;

import com.codeborne.selenide.Selenide;
import org.homeWork2.LoginPage;
import org.homeWork2.ProfilePage;
import org.homeWork2.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class ProfileTest extends HomeWork2AbstractTest {
    @Test
    void testFullNameInProfile() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("GB2023057c4387", "cd6c4aac6c");

        StudentPage studentPage = page(StudentPage.class);
        studentPage.openProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        Assertions.assertEquals("GB202305 7c4387", profilePage.getTextFullNameRow());
        Assertions.assertEquals("GB202305 7c4387", profilePage.getTextFullNameUnderCard());
    }

    @Test
    void testAddPictureInProfile() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("GB2023057c4387", "cd6c4aac6c");
        StudentPage studentPage = page(StudentPage.class);
        studentPage.openProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickEditProfile();
        profilePage.uploadNewAvatarImage("src/test/resources/111.png");
        Assertions.assertTrue(profilePage.getFileName().contains("111.png"));

    }

    @Test
    void testChangeBirthdateInProfile() {
        LoginPage loginPage = page(LoginPage.class);
        loginPage.authorize("GB2023057c4387", "cd6c4aac6c");

        StudentPage studentPage = page(StudentPage.class);
        studentPage.openProfilePage();

        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickEditProfile();
        profilePage.changeBirthdate("01.01.1992");
        Assertions.assertEquals("01.01.1992", profilePage.getBirthdate());

    }
}
