package com.ted.condition.wrapper;

import com.ted.condition.context.Context;

public class AndExpressionWrapper implements IExpressionWrapper {

    private IExpressionWrapper[] wrappers;

    public AndExpressionWrapper(IExpressionWrapper... wrappers) {
        this.wrappers = wrappers;
    }

    @Override
    public boolean check(Context context) {
        for (IExpressionWrapper wrapper : wrappers) {
            if (!wrapper.check(context)) {
                return false;
            }
        }
        return true;
    }

}
