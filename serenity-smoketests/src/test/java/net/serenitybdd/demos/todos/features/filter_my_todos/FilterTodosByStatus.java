package net.serenitybdd.demos.todos.features.filter_my_todos;

import static net.serenitybdd.demos.todos.model.TodoStatusFilter.Active;
import static net.serenitybdd.demos.todos.model.TodoStatusFilter.Completed;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.demos.todos.tasks.AddItems;
import net.serenitybdd.demos.todos.tasks.CompleteItem;
import net.serenitybdd.demos.todos.tasks.DisplayedItems;
import net.serenitybdd.demos.todos.tasks.FilterItems;
import net.serenitybdd.demos.todos.tasks.OpenTheApplication;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
@WithTag("smoketest")
public class FilterTodosByStatus {

    @Managed
    WebDriver hisBrowser;

    @Steps AddItems addedSomeItems;
    @Steps DisplayedItems theDisplayedItems;
    @Steps OpenTheApplication openedTheTodoApplication;

    Actor joe = Actor.named("Joe");

    @Before
    public void joe_can_use_a_browser() {
        joe.can(BrowseTheWeb.with(hisBrowser));
        joe.has(openedTheTodoApplication);
    }

    //static int tries = 1;
    @Test
    public void filter_by_active_tasks() {
        givenThat(joe).has(addedSomeItems.called("Buy the milk", "Buy Petrol"));
        andThat(joe).attemptsTo(CompleteItem.called("Buy the milk"));

        when(joe).attemptsTo(FilterItems.byStatus(Active));

        then(joe).should(seeThat(theDisplayedItems, contains("Buy Petrol")));
        //todo move to external build test
        //assertThat(tries++).isGreaterThanOrEqualTo(3);
    }

    @Test
    public void filter_by_completed_tasks() {
        givenThat(joe).has(addedSomeItems.called("Buy the milk", "Buy Petrol"));
        andThat(joe).attemptsTo(CompleteItem.called("Buy the milk"));

        when(joe).attemptsTo(FilterItems.byStatus(Completed));

        then(joe).should(seeThat(theDisplayedItems, contains("Buy the milk")));
    }

}
