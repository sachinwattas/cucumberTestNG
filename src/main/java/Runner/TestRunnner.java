package Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(features="/Users/sachin/IdeaProjects/POMFramework/POMFramework/CucumberFramework/src/main/java/Features", glue="StepDefination",
        format= {"pretty","html:test-outout", "json:json-output/cucumber.json", "junit:junit_output/cucumber.xml"}, monochrome = true,
        strict = true, dryRun = false, tags = {"~@RegressionTest", "~@SmokeTest", "@PageFactory"})

public class TestRunnner {
    private TestNGCucumberRunner testNGCucumberRunner;


    private TestNGCucumberRunner testRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}