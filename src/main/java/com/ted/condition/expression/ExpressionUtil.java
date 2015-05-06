package com.ted.condition.expression;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ted.condition.vo.User;

public class ExpressionUtil {

    private static final String SPLIT = ".";

    public static Map<Object, Object> getFieldMap(Object t) {
        try {
            Map<Object, Object> map = new HashMap<Object, Object>();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object obj = field.get(t);
                putObject(map, field.getName(), obj);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    private static void putObject(Map<Object, Object> map, String fieldName, Object obj) {
        if (obj instanceof Properties) {
            putPropertiesValues(map, fieldName, (Properties) obj);
        } else if (obj instanceof Map) {
            putMapValues(map, fieldName, (Map) obj);
        } else if (obj instanceof List) {
            map.put(fieldName, obj);
            putListValues(map, fieldName, (List) obj);
        } else {
            map.put(fieldName, obj);
        }
    }

    @SuppressWarnings("rawtypes")
    private static void putListValues(Map<Object, Object> map, String name, List obj) {
        for (int i = 0, size = obj.size(); i < size; i++) {
            putObject(map, name + "[" + i + "]", obj.get(i));
        }
    }

    @SuppressWarnings("rawtypes")
    private static void putMapValues(Map<Object, Object> map, String name, Map obj) {
        for (Object key : obj.keySet()) {
            putObject(map, name + SPLIT + key, obj.get(key));
        }
    }

    private static void putPropertiesValues(Map<Object, Object> map, String name, Properties obj) {
        for (Object key : obj.keySet()) {
            putObject(map, name + SPLIT + key, obj.get(key));
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setName("asdass");

        Properties prop = new Properties();
        prop.setProperty("key1", "dasss");
        prop.setProperty("key2", "d1asss");
        user.setProp(prop);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "dasss");
        map.put("key2", prop);
        user.setMap(map);

        List list = new ArrayList();
        list.add(map);
        list.add(prop);
        user.setList(list);

        String[] strs = new String[] { "1", "2" };
        user.setStrs(strs);

        System.out.println(prop);
        System.out.println(getFieldMap(user));
    }
}
