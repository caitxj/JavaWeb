#### EL
 Express Language,简化jsp 处理相关操作

EL  支持的范围
1. 基本的四则运算操作(+-*/)
2. 基本属性操作(obj.prop| variable)
3. jsp 对象获取相关支持(pageContext,requestScope,sessionScope,applicationScope)
4. 集合相关操作(list,map,array)
   array----> array[index]
   list-----> list[index] |list.get(index)
   map---->map.key | map[key] :注意key 最好不要为数字
5. 方法的调用操作
   正常调用方法进行操作:xxx.methodName();


注意事项:
   1.调用对象属性时,el是通过getter 方法来进行获取操作的
   2.当获取元素时,未指定作用域时,此时查找元素的顺序(request>session>application)
   3.适用范围
    3.1.可以在jsp页面的js代码中进行定义使用.
    3.2不能在单独的js页面中进行定义使用(可以通过在jsp页面中定义变量,供页面操作使用.
