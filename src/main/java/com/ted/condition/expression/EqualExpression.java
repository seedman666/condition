package com.ted.condition.expression;

import com.ted.condition.context.Context;

public class EqualExpression implements Expression {

    private String fieldName;
    private Object fieldValue;

    public EqualExpression(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            return obj.equals(fieldValue);
        }
        return false;
    }
}
