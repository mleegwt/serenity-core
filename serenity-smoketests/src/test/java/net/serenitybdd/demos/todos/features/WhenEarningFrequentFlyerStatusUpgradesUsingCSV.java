package net.serenitybdd.demos.todos.features;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="status-levels.csv")
@WithTag("requirement:Test tag")
public class WhenEarningFrequentFlyerStatusUpgradesUsingCSV {
    private int kilometersTravelled;
    private String expectedStatus;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    public void setExpectedStatus(String expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    @Qualifier
    public String qualifier() {
        return kilometersTravelled + "=>" + expectedStatus;
    }

    @Test
    public void reallyhouldEarnNextStatusWithEnoughPoints() {
    	// Don't care for now
    }
}