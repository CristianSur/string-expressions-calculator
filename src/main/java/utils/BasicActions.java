package utils;

import org.apache.commons.lang3.RandomStringUtils;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class BasicActions {
    public static String validData = PropertyReader.getProperty("validData");

    //Returns a double value with 2 decimals
    protected static Double calculator(String data) {
        try {
            return BigDecimal.valueOf(Double.parseDouble(new ScriptEngineManager()
                    .getEngineByName("nashorn").eval(data).toString()))
                    .setScale(2, RoundingMode.HALF_UP).doubleValue();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }

//    protected static int calculator(String insideBrackets) {
//        int value  = 0;
//        int secondNumber;
//        int firstNumber;
//
//        if (insideBrackets.contains("*")) {
//            firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("*")));
//            secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("*")+1));
//            value = firstNumber * secondNumber;
//            System.out.println(insideBrackets + " = " + value);
//
//        } else
//        if (insideBrackets.contains("/")) {
//            firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("/")));
//            secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("/")+1));
//            value = firstNumber * secondNumber;
//            System.out.println(insideBrackets + " = " + value);
//
//        } else
//        if (insideBrackets.contains("+")) {
//            firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("+")));
//            secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("+")+1));
//            value = firstNumber * secondNumber;
//            System.out.println(insideBrackets + " = " + value);
//
//        } else
//        if (insideBrackets.contains("-")) {
//            firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("-")));
//            secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("-")+1));
//            value = firstNumber * secondNumber;
//            System.out.println(insideBrackets + " = " + value);
//
//        }
//        return value;
//    }

    //Remove round brackets from expression
    static public String bracketsFromExpressionRemoving(String expression) {
        System.err.println(expression);
        while (expression.contains("(")) {
            int first = expression.lastIndexOf("(");
            int last = expression.indexOf(")");
            String insideBrackets = expression.substring(first, last).substring(1);

            String value = null;
            int secondNumber;
            int firstNumber;

            if (insideBrackets.contains("*")) {
                firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("*")));
                secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("*")+1));
                value = String.valueOf(firstNumber * secondNumber);
                System.out.println(insideBrackets + " = " + value);

            } else
            if (insideBrackets.contains("/")) {
                firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("/")));
                secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("/")+1));
                value = String.valueOf(firstNumber / secondNumber);
                System.out.println(insideBrackets + " = " + value);

            } else
            if (insideBrackets.contains("+")) {
                firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("+")));
                secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("+")+1));
                value = String.valueOf(firstNumber + secondNumber);
                System.out.println(insideBrackets + " = " + value);

            } else
            if (insideBrackets.contains("-")) {
                firstNumber = Integer.parseInt(insideBrackets.substring(0, insideBrackets.indexOf("-")));
                secondNumber = Integer.parseInt(insideBrackets.substring(insideBrackets.indexOf("-")+1));
                value = String.valueOf(firstNumber - secondNumber);
                System.out.println(insideBrackets + " = " + value);

            }

            expression = expression.replace("(" + insideBrackets + ")", value);

            if (expression.contains("--")) {
                expression = expression.replace("--", "+");
            }

            if (expression.contains("+-")) {
                expression = expression.replace("+-", "-");
            }

            if (expression.contains("-+")) {
                expression = expression.replace("-+", "-");
            }
        }

        return expression;
    }

    public String randomTwoDigitNumber() {
        return RandomStringUtils.randomNumeric(2);
    }

    public String randomOperator() {
        return RandomStringUtils.random(1, "*/+-");
    }

    public String randomExpression() {
        return randomTwoDigitNumber() + randomOperator() + "("
                + randomTwoDigitNumber() + randomOperator() + "("
                + randomTwoDigitNumber() + randomOperator() + randomTwoDigitNumber() + "))";
    }
        
    public static String getValidData() {
        return validData;
    }
}
