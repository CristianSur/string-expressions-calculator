package tests;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.RepeatedTest;
import utils.BasicActions;


public class BracketsRemovingTest extends BasicActions {

    @RepeatedTest(20)
    public void bracketsCheckingInExpression() {
        String expression = randomExpression();
        System.out.println(expression + " -> " +  StringUtils.left(bracketsFromExpressionRemoving(expression), 8));
    }
}