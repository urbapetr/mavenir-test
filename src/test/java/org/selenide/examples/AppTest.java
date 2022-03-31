package org.selenide.examples;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Test na požadovaný scénář
 */
public class AppTest
{
    /**
     * Scenar:
     *
     * Otvor stranku "http://google.com"
     * Zadaj do vyhladavania "Mojmir Kubistel" a vyhladaj
     * Over, ze ti naslo jeden link na "imdb.com"
     * Klikni na ten link
     */
    @Test
    public void shouldOpenIMDB()
    {
        open("http://google.com");
        $(By.name("q")).setValue("Mojmir Kubistel").pressEnter();
        $$(withText("imdb.com")).shouldHave(size(1));
        $(withText("imdb.com")).click();
    }
}
