import org.sonar.java.checks.verifier.JavaCheckVerifier;

import java.util.*;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String src;
        int ruleId;
        while(true){
            System.out.println("input src path :");
            src = sc.next();
            System.out.println("[1. OSCommandExecutionCheck]");
            System.out.println("[2. ArrayCopyLoopCheck]");
            System.out.println("input rule name : ");
            ruleId = sc.nextInt();
            switch (ruleId){
                case 1:
                    JavaCheckVerifier.verify(src, new OSCommandExecutionCheck());
                    break;
                case 2:
                    JavaCheckVerifier.verify(src, new ArrayCopyLoopCheck());
                    break;
                default:
                    System.out.println("Worng!");
                    break;
            }
        }
    }
}
