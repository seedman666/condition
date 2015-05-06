package com.ted.condition.expression;

import com.ted.condition.context.Context;

public class GtExpression implements Expression {

    private String fieldName;

    private double fieldValue;

    public GtExpression(String fieldName, double fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            String tmp = String.valueOf(obj);
            Double douVal = Double.parseDouble(tmp);
            return douVal >= fieldValue;
        }
        return false;
    }

}
