package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
    }

    @Test
    void dragAndDropTest() {
        open("");
        SelenideElement column_a = $("div#column-a");
        SelenideElement column_b = $("div#column-b");
        sleep(4000);
        // вариант 1, через dragAndDrop - не переместил
        // actions().dragAndDrop(column_a, column_b).perform();

        // вариант 2, через dragAndDropBy - не переместил
        // actions().dragAndDropBy(column_a, 250, 10).perform();

        // вариант 3, через цепочку moveToElement - не переместил
        // actions().moveToElement(column_a).clickAndHold().moveToElement(column_b).release().perform();

        // вариант 4, через moveByOffset - не переместил
        // actions().moveToElement(column_a).clickAndHold().moveByOffset(250, 10).release().perform();

        // вариант 5, через clickAndHold и release с переданным SelenideElement и moveToElement с оффсетом - не переместил
        // actions().clickAndHold(column_a).moveToElement(column_b, 10, 10).release(column_a).perform();

        // вариант 6, через передачу SelenideElement везде, где можно - не переместил
        // actions().moveToElement(column_a).clickAndHold(column_a).moveToElement(column_b).release(column_a).perform();

        // вариант 7, похож на 3, но с использованием moveToElement с оффсетом - не переместил
        //actions().moveToElement(column_a).clickAndHold().moveToElement(column_b, 0, 0).release().perform();

        // проверить команду $(element).dragAndDropTo($(to-element))
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(exactTextCaseSensitive("B"));
        column_a.shouldHave(exactTextCaseSensitive("B"));
    }
}
