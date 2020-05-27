import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Arrays;
import java.util.List;

public class CheckVariableScope extends IssuableSubscriptionVisitor {
    private int varNumbers = 0;

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Arrays.asList(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
        if(tree.is(Tree.Kind.VARIABLE)) {
            VariableTree vars = (VariableTree) tree;

            System.out.println("-------------------------------------------------");
            System.out.println("Variable name : " + vars.symbol().name());
            System.out.println("Variable type : " + vars.symbol().type().fullyQualifiedName());
            System.out.println("Variable owner(scope) : " + vars.symbol().owner().name());

            varNumbers++;       // prints 5; increases number by line to line
        }
    }
}
