import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class OSCommandExecutionCheckTest {

    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/OSCommandExecutionCheck.java", new OSCommandExecutionCheck());
    }
}
