# condition
条件判断

使用方法
1.将上述的任意Expression的具体子类封装为ExpressionWrapper，如
new ExpressionWrapper(new EqualExpression("from", "from1"))

2.对不同的ExpressionWrapper进行任意的And/Or/Not组合，如
IExpressionWrapper wrapperP1 = new AndExpressionWrapper(new ExpressionWrapper(new ContainExpression("props",
builder1.build())), new ExpressionWrapper(new EqualExpression("from", "from1")));

3.将wrapper封装到ConditionBuilder中，如
ConditionBuilder conditionBuilder=new ConditionBuilder(wrapperP1);

4.根据对象的不同，封装不同的Context进行判断，目前支持普通的JavaBean和ProtobufBean，如
conditionBuilder.check(new ProtoBufContext(builderP.build()))
builder.check(new JavaBeanContext(user))

5.如果要序列化和反序列化，可以使用ConditionBuilder类中的如下方法
