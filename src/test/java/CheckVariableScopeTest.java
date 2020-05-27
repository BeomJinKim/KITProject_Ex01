import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class CheckVariableScopeTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/CheckVariableScope.java", new CheckVariableScope());
    }

}
