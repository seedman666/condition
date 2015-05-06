package com.ted.condition.expression;

import java.util.Arrays;
import java.util.Collection;

import com.ted.condition.context.Context;

public class ContainExpression implements Expression {

    private String fieldName;
    private Object containValue;

    public ContainExpression(String fieldName, Object containValue) {
        this.fieldName = fieldName;
        this.containValue = containValue;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            if (obj instanceof Object[]) {
                return Arrays.asList((Object) obj).contains(containValue);
            } else if (obj instanceof Collection) {
                Collection col = (Collection) obj;
                return col.contains(containValue);
            }
        }
        return false;
    }
}
