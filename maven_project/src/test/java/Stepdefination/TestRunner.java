package Stepdefination;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Admin\\Desktop\\JavaFull\\maven_project\\src\\test\\resources\\Feature.File\\View360RegressionTesting .feature",
glue="Stepdefination",
plugin= {"pretty","html:target/cucumber-reports/Login.html"},
tags ="@smoke",
monochrome = true)

public class TestRunner {

}
 