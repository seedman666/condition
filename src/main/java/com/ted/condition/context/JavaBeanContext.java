package com.ted.condition.context;

import java.lang.reflect.Field;
import java.util.Map;

public class JavaBeanContext implements Context {

    private Object sourceObj;

    public JavaBeanContext(Object sourceObj) {
        this.sourceObj = sourceObj;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getObject(String fieldName) {
        String[] fieldNames = fieldName.split(FIELD_SPLIT);
        Object tmpObject = sourceObj;
        for (int i = 0, length = fieldNames.length; i < length; i++) {
            try {
                if (tmpObject instanceof Map) {
                    tmpObject = ((Map) tmpObject).get(fieldNames[i]);
                } else {
                    Field field = tmpObject.getClass().getDeclaredField(fieldNames[i]);
                    field.setAccessible(true);
                    tmpObject = field.get(tmpObject);
                }
                if (length == 1) {
                    return tmpObject;
                }
                if (tmpObject == null) {
                    return null;
                }
            } catch (Exception e) {
                tmpObject = null;
                e.printStackTrace();
            }
        }
        return tmpObject;
    }
}
