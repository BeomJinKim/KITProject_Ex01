import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Arrays;
import java.util.List;

public class CheckTreeAPIInfo extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        //return Collections.emptyList();
        return Arrays.asList(Tree.Kind.values());
    }

    @Override
    public void visitNode(Tree tree) {
        try {
            if(hasSemantic()) {
                System.out.println("========== Tree Kind : " + tree.kind().name() + " ==========");
                System.out.println("Tree first token : " + tree.firstToken().text());
                System.out.println("Tree last token : " + tree.lastToken().text());
                System.out.println("Tree parent kind associated interface : " + tree.parent().kind().getAssociatedInterface().getName());
                System.out.println("Tree parent kind : " + tree.parent().kind().name());
                System.out.println("Tree parent parent kind : " + tree.parent().parent().kind().name());
            }
            else {
                System.out.println("no semantic");
            }
        } catch (NullPointerException e) {
        }
    }
}
