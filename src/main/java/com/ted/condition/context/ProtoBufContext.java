package com.ted.condition.context;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.GeneratedMessage;

public class ProtoBufContext implements Context {

    private GeneratedMessage generatedMessage;

    public ProtoBufContext(GeneratedMessage generatedMessage) {
        this.generatedMessage = generatedMessage;
    }

    @Override
    public Object getObject(String fieldName) {
        for (int i = 0; i < generatedMessage.toBuilder().getDescriptorForType().getFields().size(); i++) {
            FieldDescriptor pf = generatedMessage.toBuilder().getDescriptorForType().getFields().get(i);// 获取proto字段
            if (pf.getName().equals(fieldName)) {
                return generatedMessage.getField(pf);
            }
        }
        return null;
    }

}
