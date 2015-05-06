package com.ted.condition.expression;

import com.ted.condition.context.Context;

public class NotEqualExpression implements Expression {

    private String fieldName;
    private Object fieldValue;

    public NotEqualExpression(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            return !obj.equals(fieldValue);
        }
        return true;
    }

}
