//package runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/features",
//    glue = "testcase",
//    plugin = { "pretty", "html:target/cucumber-reports" },
//    monochrome = true
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//	
//}

package runner;

import io.cucumber.core.cli.Main;

public class TestRunner {
    public static void main(String[] args) {
        String[] cucumberOptions = new String[]{
            "--glue", "testcase",
            "--plugin", "pretty",
            "--plugin", "html:target/cucumber-reports",
            "--monochrome",
            "src/test/resources/features"
        };
        Main.main(cucumberOptions);
    }
}
