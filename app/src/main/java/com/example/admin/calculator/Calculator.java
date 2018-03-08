package com.example.admin.calculator;


import org.mariuszgromada.math.mxparser.*;

public class Calculator {
    private static String currentStatement = "";

    public static String getCurrentStatement() {
        return currentStatement;
    }

    public static void setCurrentStatement(String currentStatement) {
        Calculator.currentStatement = currentStatement;
    }

    public static String Calculate(){
        Expression expression = new Expression(currentStatement);
        mXparser.enableUlpRounding();
        setCurrentStatement(String.valueOf(expression.calculate()));
        return currentStatement;
    }
}
