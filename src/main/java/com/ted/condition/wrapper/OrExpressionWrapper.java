package com.ted.condition.wrapper;

import com.ted.condition.context.Context;

public class OrExpressionWrapper implements IExpressionWrapper {
    private IExpressionWrapper[] wrappers;

    public OrExpressionWrapper(IExpressionWrapper... wrappers) {
        this.wrappers = wrappers;
    }

    @Override
    public boolean check(Context context) {
        for (IExpressionWrapper wrapper : wrappers) {
            if (wrapper.check(context)) {
                return true;
            }
        }
        return false;
    }
}
