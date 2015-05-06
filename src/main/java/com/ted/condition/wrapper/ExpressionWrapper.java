package com.ted.condition.wrapper;

import com.ted.condition.context.Context;
import com.ted.condition.expression.Expression;

public class ExpressionWrapper implements IExpressionWrapper {

    private Expression expression;

    public ExpressionWrapper(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean check(Context context) {
        return expression.check(context);
    }

}
