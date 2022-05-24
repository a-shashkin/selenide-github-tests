package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Hometask4Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideGithubRepoTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).click();
        $("div.js-wiki-sidebar-toggle-display").$$("ul li").findBy(text("SoftAssertions")).shouldBe(visible);
        $("div.js-wiki-sidebar-toggle-display").$$("ul li").findBy(text("SoftAssertions")).click();
        $$("h4").findBy(text("JUnit5")).sibling(0).shouldBe(visible);
    }
}
