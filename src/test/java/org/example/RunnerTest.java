package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
    glue = "org.example",
    features = "src/test/java"
)

@RunWith(Cucumber.class)

public class RunnerTest {
}