package com.ted.condition.context;


public interface Context {

    String FIELD_SPLIT = "\\.";

    Object getObject(String fieldName);

}
