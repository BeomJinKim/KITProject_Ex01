import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class CheckTreeAPIInfoTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify("src/test/files/CheckTreeAPIInfo.java", new CheckTreeAPIInfo());
    }

}
