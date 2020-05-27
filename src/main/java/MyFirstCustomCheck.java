/*
    this file implements custom rule
 */

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.util.Collections;
import java.util.List;

@Rule(key = "MyFirstCustomRule")

// IssuableSubscriptionVisitor: implementation basis of our rule
//      This visitor offers an easy approach to writing quick and simple rules
public class MyFirstCustomCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Kind> nodesToVisit() {
        //return Collections.emptyList();
        return Collections.singletonList(Kind.METHOD);      // nodes to visit are specified : method
    }

    @Override
    public void visitNode(Tree tree) {
        MethodTree method = (MethodTree)tree;

        // checking that the method has a single parameter
        if(method.parameters().size() == 1) {
            MethodSymbol symbol = method.symbol();          // getting the symbol of the method
            Type firstParameterType = symbol.parameterTypes().get(0);
            Type returnType = symbol.returnType().type();

            // the rule should only raise an issue when these two types are the same
            //      fully qualified name is an unambiguous name that specifies
            //      which object, function, or variable a call
            //      refers to without regard to the context of the call
            if(returnType.is(firstParameterType.fullyQualifiedName())) {
                reportIssue(method.simpleName(), "Never do that!");
            }
        }
    }
}
