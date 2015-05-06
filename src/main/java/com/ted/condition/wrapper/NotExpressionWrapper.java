package com.ted.condition.wrapper;

import com.ted.condition.context.Context;

public class NotExpressionWrapper implements IExpressionWrapper {

    private IExpressionWrapper wrapper;

    public NotExpressionWrapper(IExpressionWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public boolean check(Context context) {
        return !wrapper.check(context);
    }
}
