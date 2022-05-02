package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BasicActions;


public class SimpleCalculator extends BasicActions {

    @Test(dataProvider = "expressionFromDataProvider")
    public void check(String expression, double result) {
        checkValidityOfCharacters(expression);
        Assert.assertEquals(calculator(bracketsFromExpressionRemoving(expression)), result);
    }

    @DataProvider(name = "expressionFromDataProvider")
    public Object[][] getExpressionsFromDataProvider() {
        return new Object[][]{
                {"1+(2-6)/4+1", 1},
                {"7*2/4*(2+4)/4", 5.25},
                {"3/2+4*(5/5)", 5.5},
                {"2344/234*5*(234/2421-555)", -27792.59},
                {"(80+(2-6))/4+1/24", 19.04},
                {"2+2*2", 6},
                {"3213*0", 0},
                {"3213#*0", 0},
                {"hot-dog", 0},
                {"5++++5", 0}
        };
    }

    static  void checkValidityOfCharacters(String data) {
        for (int i = 0; i < data.length(); i++) {
            Assert.assertTrue(getValidData().contains(String.valueOf(data.charAt(i))), "invalid data was introduced");
        }
    }
}
