package net.serenitybdd.demos.todos.pages;

import java.time.temporal.ChronoUnit;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://todomvc.com/examples/angularjs/#/")
public class ApplicationHomePage extends PageObject {
    public void waitForTheApplicationToLoad() {
        withTimeoutOf(60, ChronoUnit.SECONDS).waitFor("#new-todo");
    }

    public void openApplication() {
        open();
        waitForTheApplicationToLoad();
    }

}
