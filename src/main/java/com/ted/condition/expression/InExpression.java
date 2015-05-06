package com.ted.condition.expression;

import java.util.Arrays;

import com.ted.condition.context.Context;

public class InExpression implements Expression {

    private String fieldName;
    private String[] fieldValues;

    public InExpression(String fieldName, String[] fieldValues) {
        this.fieldName = fieldName;
        this.fieldValues = fieldValues;
    }

    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            return Arrays.asList(fieldValues).contains(obj);
        }
        return false;
    }

}
