package com.ted.condition.expression;

import java.util.Arrays;
import java.util.Collection;

import com.ted.condition.context.Context;

public class ContainAllExpression implements Expression {

    private String fieldName;
    private Object[] containValues;

    public ContainAllExpression(String fieldName, Object[] containValues) {
        this.fieldName = fieldName;
        this.containValues = containValues;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            if (obj instanceof Object[]) {
                return Arrays.asList((Object[]) obj).containsAll(Arrays.asList(containValues));
            } else if (obj instanceof Collection) {
                Collection col = (Collection) obj;
                return col.containsAll(Arrays.asList(containValues));
            }
        }
        return false;
    }

}
