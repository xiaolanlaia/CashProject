# 学习
## 1. Retrofit使用
## 2. drawable的使用
## 3. 自定义View
## 4. Android自带注解
## 5. EditText内容状态监听
` app:addTextChangedListener="@{vm.bindBankNumTextListener}" `
## 6. 动态权限申请
## 7. JSONObject和JSONArray
## 8. String字符串的处理
``` 
val str :String = String.format("%.2f",(it.data?.interest))

str.substring(0, str.length -1) 
```
## 9. 将毫秒转化成日期
```
val strb = vm.planPayBack.value!!.toLong()
val newDate = Date(strb)
val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
bindView.planPaybackText.text = simpleDateFormat.format(newDate)
```
## 10. BigDecimal
## 11. TitleWithContentActivity带多个参数跳转
## 12. fragment的使用
## 13. MVVM框架
## 14. 重写super和不重写super的区别
## 15. Mine模块的栏目点击事件
## 16. RxBinding
## 17. 强制更新版本的字符串对比
## 18. 设置控件在屏幕居中（获取屏幕参数）
```Kotlin
val mLayoutParams1 = RelativeLayout.LayoutParams(
    RelativeLayout.LayoutParams.WRAP_CONTENT,
    RelativeLayout.LayoutParams.WRAP_CONTENT
)
mLayoutParams1.setMargins(0, AbScreenUtils.dp2px(context, 420f), 0, 0)
mLayoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL)
otherTV.layoutParams = mLayoutParams1

```
## 19. 快捷键
## 20. 多渠道打包
1. Gradle配置
2. 签名配置
3. 输出包配置
4. 不同渠道不同资源配置
## 21. 打包输出配置
## 22. 全局配置
## 23. 混淆
1. 混淆规则
2. 混淆黑名单
   1. 枚举
   2. 被反射的元素
   3. 实体类
   4. 四大组件
   5. JNI调用的Java方法
   6. 自定义控件
   7. JavaScript调用的Java方法
   8. Java的Native方法
   9. 项目中的第三方库
## 24. 不需要上传的文件
## 25. 像素密度
## 26. 颜色色号
## 27. 注解
## 28. 反射
## 29. 热修复
## 30. 插件化
## 31. 组件化
## 32. 内存泄漏

