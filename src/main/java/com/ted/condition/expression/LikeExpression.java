package com.ted.condition.expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ted.condition.context.Context;

public class LikeExpression implements Expression {

    private String fieldName;
    private String fieldValue;

    public LikeExpression(String fieldName, String fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public boolean check(Context context) {
        Object obj = context.getObject(fieldName);
        if (obj != null) {
            String tmp = String.valueOf(obj);
            Pattern r = Pattern.compile(fieldValue);
            Matcher m = r.matcher(tmp);
            return m.find();
        }
        return false;
    }

}
