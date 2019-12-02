# <center>学习</center>
## 1. Retrofit
[Retrofit](https://mp.weixin.qq.com/s/7SXmxjeT_Cj_VRgu3fhKIQ)
## 2. RxJava（跳过，直接学习协程）
[RxJava](http://gank.io/post/560e15be2dca930e00da1083)
## 3. Handler
[Handler](https://blog.csdn.net/qq_37321098/article/details/81535449)
## 4. 线程
## 5. 协程
## 6. RxBinding
[RxBinding](https://github.com/JakeWharton/RxBinding)
## 7. RxBus
## 8. MVVM框架
## 9. drawable
## 10. 自定义View
## 11. Android自带注解
1. @SuppressLint("NewApi"）屏蔽一切新api中才能使用的方法报的android lint错误
2. @TargetApi() 只屏蔽某一新api中才能使用的方法报的android lint错误
## 12. EditText内容状态监听
` app:addTextChangedListener="@{vm.bindBankNumTextListener}" `
## 13. 动态权限申请
## 14. JSONObject和JSONArray
一个
## 15. String字符串的处理

``` kotlin
//保留小数
val str :String = String.format("%.2f",(2.2212))
//截取字符串
str.substring(0, str.length -1)
```
## 16. 将毫秒转化成日期
```kotlin
val str = "12345678"
val newDate = Date(str)
val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
simpleDateFormat.format(newDate)
```
## 17. BigDecimal
## 18. Activity 与 Context的关系
```
1、Context和Activity关系
Context是个抽象类，通过类的结构可以看到：Activity、Service、Application都是Context的子类；

从Android系统的角度来理解：Context是一个场景，描述的是一个应用程序环境的信息，即上下文，代表与操作系统的交互的一种过程。

从程序的角度上来理解：Context是个抽象类，而Activity、Service、Application等都是该类的一个实现。

2.如何转换

A、context转换为activity，这里采用强制转换： 

Activity activity = (Activity) context;

B、从activity得到context，调用了方法：

在activity的方法中用context = getBaseContext();
而在activity中用context = this即可.

```
## 19. TitleWithContentActivity带多个参数跳转
## 20. fragment的使用
## 21. super和this
```
this:
1，使用this调用本类中的属性。
2，使用this调用构造方法。
3，表示当前对象

super:
1，在子类中调用父类的属性和方法
2，在子类中调用父类的构造方法。

```
## 22. Mine模块的栏目点击事件

```
1 RxBinding
```
## 23. 强制更新版本的字符串对比
## 24. 设置控件在屏幕居中（获取屏幕参数）
```kotlin

val mLayoutParams1 = RelativeLayout.LayoutParams(
    RelativeLayout.LayoutParams.WRAP_CONTENT,
    RelativeLayout.LayoutParams.WRAP_CONTENT
)
mLayoutParams1.setMargins(0, AbScreenUtils.dp2px(context, 420f), 0, 0)
mLayoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL)
otherTV.layoutParams = mLayoutParams1

```
## 25. 快捷键
## 26. Gradle配置
```
一、 productFlavors

1、创建不同的产品
    1.1、创建不同产品并分配专有属性
        //程序包名
        applicationId 
        //不同渠道号
        manifestPlaceholders
        versionName
        versionCode
    
2、设置不同代码引用专有资源

    在src文件夹下创建同名资源文件夹  
    
3、不同产品引入不同包

    //不同产品引入不同的包
    ACompile "com.android.support:appcompat-v7:26.+"
    BCompile "com.android.support.constraint:constraint-layout:1.0.2"
4、

二、签名配置

1、signingConfigs

三、输出包配置
1、
四、不同渠道不同资源配置
```
## 27. 打包输出配置

## 28. 全局配置
## 29. 混淆
```
1. 混淆规则
2. 混淆黑名单
    1.枚举
    2.被反射的元素
    3.实体类
    4.四大组件
    5.JNI调用的Java方法
    6.自定义控件
    7.JavaScript调用的Java方法
    8.Java的Native方法
    9.项目中的第三方库
    
```
## 30. 不需要上传的文件 .gitignore
## 31. 像素密度
<font size = "6"> [像素密度](https://www.jianshu.com/p/cd66b7e01d4a)</font>
### 1. 定义
```
1. Px （Pixel像素）
也称为图像元素，是作为图像构成的基本单元，单个像素的大小并不固定，
跟随屏幕大小和像素数量的关系变化（屏幕越大，像素越低，单个像素越
大，反之亦然）。所以在使用像素作为设计单位时，在不同的设备上可能
会有缩放或拉伸的情况。

2. Resolution（分辨率）
是指屏幕的垂直和水平方向的像素数量，如果分辨率是 1920*1080 ，那
就是垂直方向有 1920 个像素，水平方向有 1080 个像素。

3. Dpi(dot per inch像素密度)
是指屏幕上每英寸（1英寸 = 2.54 厘米）距离中有多少个像素点。如果屏幕为
320*240，屏幕长 2 英寸宽 1.5 英寸，Dpi = 320 / 2 = 240 / 1.5 = 160。

4. Density（密度）
这个是指屏幕上每平方英寸（2.54 ^ 2 平方厘米）中含有的像素点数量

5. Dip / dp (Density-independent pixel设备独立像素)
也可以叫做dp，长度单位，同一个单位在不同的设备上有不同的显示效果，
具体效果根据设备的密度有关，详细的公式请看下面。

```
### 2. 计算规则
```
以4.95 英寸 1920 * 1080 的手机为例：

1. Dpi :

计算直角边像素数量： 1920^2+1080^2=2202^2（勾股定理）。
计算 DPI：2202 / 4.95 = 445。
得到这个设备的 DPI 为 445 （每英寸的距离中有 445 个像素）。

2. Density
上面得到每英寸中有 440 像素，那么 density 为每平方英寸中的像素数量，应该为： 445^2=198025。
3. Dip / dp

先明白一个概念，所有显示到屏幕上的图像都是以 px 为单位。
Dip 是我们开发中使用的长度单位，最后他也需要转换成 px。
计算这个设备上 1dip 等于多少 px:
px = dip  x  dpi /160
px = 1 x  445 / 160  = 2.78
通过上面的计算可以看出在此设备上 1dip = 2.78px，
那么这是一个真实的故事吗？ nonono，其中的关键值 dpi 并不是我们算出来的 445 ，请往下看。
```

## 32. 注解
## 33. 反射
```java
try {
	Field field = ValueAnimator.class.getDeclaredField("sDurationScale");
	field.setAccessible(true);
	Log.d("__startAnimator",""+field.getFloat(null));

} catch (NoSuchFieldException e) {
	e.printStackTrace();
} catch (IllegalAccessException e) {
	e.printStackTrace();
}
```
## 34. 热修复
## 35. 插件化
## 36. 组件化
## 37. 内存泄漏
## 38. 设计模式
## 39. EditText属性
```
android:inputType="number"

```

## 40 缩小spk和应用安装后占用的内存
## 41 修改环信界面
## 42 自定义封装成库

