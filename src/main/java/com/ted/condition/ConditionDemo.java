package com.ted.condition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ted.condition.context.JavaBeanContext;
import com.ted.condition.expression.ContainAllExpression;
import com.ted.condition.expression.ContainExpression;
import com.ted.condition.expression.EqualExpression;
import com.ted.condition.expression.GtExpression;
import com.ted.condition.expression.InExpression;
import com.ted.condition.expression.LikeExpression;
import com.ted.condition.expression.LtExpression;
import com.ted.condition.expression.NotContainExpression;
import com.ted.condition.expression.NotInExpression;
import com.ted.condition.expression.RangeExpression;
import com.ted.condition.vo.User;
import com.ted.condition.wrapper.AndExpressionWrapper;
import com.ted.condition.wrapper.ExpressionWrapper;
import com.ted.condition.wrapper.IExpressionWrapper;
import com.ted.condition.wrapper.NotExpressionWrapper;
import com.ted.condition.wrapper.OrExpressionWrapper;

public class ConditionDemo {

    public static void main(String[] args) {

        IExpressionWrapper wrapper1 = new OrExpressionWrapper(new ExpressionWrapper(new GtExpression("age", 50)),
                new ExpressionWrapper(new GtExpression("age", 50)));
        IExpressionWrapper wrapper2 = new NotExpressionWrapper(new ExpressionWrapper(new EqualExpression("name",
                "test123")));
        IExpressionWrapper wrapper3 = new AndExpressionWrapper(new ExpressionWrapper(new ContainExpression("list",
                "111")), new ExpressionWrapper(new ContainAllExpression("list", new String[] { "111", "222" })));
        IExpressionWrapper wrapper4 = new AndExpressionWrapper(new ExpressionWrapper(new InExpression("map.name",
                new String[] { "map111", "map222" })), new ExpressionWrapper(new LikeExpression("map.name", "map*")));
        IExpressionWrapper wrapper5 = new AndExpressionWrapper(new ExpressionWrapper(new LtExpression("age", 100)),
                new ExpressionWrapper(new NotContainExpression("set", "set111")));
        IExpressionWrapper wrapper6 = new AndExpressionWrapper(new ExpressionWrapper(new NotInExpression("map.name",
                new String[] { "map333", "map444" })), new ExpressionWrapper(new RangeExpression("age", 10, 100)));
        IExpressionWrapper wrapper7 = new ExpressionWrapper(new EqualExpression("user.name", "test3331"));

        IExpressionWrapper wrapper = new AndExpressionWrapper(wrapper1, wrapper2, wrapper3, wrapper4, wrapper5,
                wrapper6, wrapper7);

        ConditionBuilder builder = new ConditionBuilder(wrapper);

        String jsonStr = builder.toJson();

        User user = new User();
        user.setName("test3331");
        user.setAge(60);

        user.setStrs(new String[] { "111", "222", "333" });

        List list = new ArrayList();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        user.setList(list);

        Set set = new HashSet();
        set.add("111");
        set.add("222");
        set.add("333");
        user.setSet(set);

        Map map = new HashMap();
        map.put("name", "map111");
        user.setMap(map);

        user.setUser(user);

        System.out.println(builder.check(new JavaBeanContext(user)));
        System.out.println(jsonStr);
        System.out.println(ConditionBuilder.fromJson(jsonStr).check(new JavaBeanContext(user)));

    }
}
