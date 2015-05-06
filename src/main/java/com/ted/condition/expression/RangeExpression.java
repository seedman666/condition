package com.ted.condition.expression;

import com.ted.condition.context.Context;

public class RangeExpression implements Expression {

    private String fieldName;
    private double fieldValue1;
    private double fieldValue2;

    public RangeExpression(String fieldName, double fieldValue1, double fieldValue2) {
        this.fieldName = fieldName;
        this.fieldValue1 = fieldValue1;
        this.fieldValue2 = fieldValue2;
    }

    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            String tmp = String.valueOf(obj);
            Double douVal = Double.parseDouble(tmp);
            return douVal >= fieldValue1 && douVal <= fieldValue2;
        }
        return false;
    }

}
