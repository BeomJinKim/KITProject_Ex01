/*
    for testing unit(method) of custom rule
 */

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class MyFirstCustomCheckTest {
    @Test
    public void test() {
        /*
         JavaCheckVerifier: provided by the Java Plugin rule testing API

         while verifying a rule, the verifier will collect lines marked as being Noncompliant,
         and verify that the rule raises the expected issues and only those issues.
        */
        JavaCheckVerifier.verify("src/test/files/MyFirstCustomCheck.java", new MyFirstCustomCheck());
    }

}
