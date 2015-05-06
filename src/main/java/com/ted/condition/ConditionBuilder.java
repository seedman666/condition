package com.ted.condition;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ted.condition.adapt.ExpressionAdapt;
import com.ted.condition.adapt.ExpressionWrapperAdapt;
import com.ted.condition.context.Context;
import com.ted.condition.expression.Expression;
import com.ted.condition.wrapper.IExpressionWrapper;

public class ConditionBuilder {

    private static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Expression.class, new ExpressionAdapt());
        gsonBuilder.registerTypeAdapter(IExpressionWrapper.class, new ExpressionWrapperAdapt());
        gson = gsonBuilder.create();
    }

    private IExpressionWrapper wrapper;

    public ConditionBuilder(IExpressionWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public String toJson() {
        return gson.toJson(this);
    }

    public static ConditionBuilder fromJson(String json) {
        return gson.fromJson(json, ConditionBuilder.class);
    }

    public boolean check(Context context) {
        return wrapper.check(context);
    }

}
