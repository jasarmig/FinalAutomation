package org.webAutomation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Espn.feature"}, glue = {"org.definitions"},
        plugin = {})


public class TestNGRunner extends AbstractTestNGCucumberTests {
}
