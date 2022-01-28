package io.github.qaguru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideListenerTest {

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").as("поисковая строка").click();
        $(".header-search-input").as("поисковая строка").setValue("eroshenkoam/allure-example").pressEnter();
        $(linkText("eroshenkoam/allure-example")).as("ссылка репозитория").click();

        $(partialLinkText("Issues")).as("таб Issues").click();
        $(byText("69")).as("Issues с номером 68").should(Condition.visible);

    }

}
