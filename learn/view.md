
一、View事件体系
```
1、什么是View

View是所有控件的基类，View和ViewGroup相互嵌套组成View树结构
    
2、View的位置参数

    2.1、View位置的四个参数mLeft、mRight、mTop、mBottom。
        通过getLeft()、getRight()、getTop()、getBottom()获取
        
    2.2、translationX和translationY
        View左上角相对于父容器的偏移量。
        
3、ViewConfiguration

    3.1、常用对象方法：
    
        //  获取touchSlop （系统 滑动距离的最小值，大于该值可以认为滑动）
        int touchSlop = viewConfiguration.getScaledTouchSlop();
        //  获得允许执行fling （抛）的最小速度值
        int minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        //  获得允许执行fling （抛）的最大速度值
        int maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        
    3.2、常用静态方法：
    
        //  获得敲击超时时间，如果在此时间内没有移动，则认为是一次点击
        int tapTimeout =  ViewConfiguration.getTapTimeout();
        //  双击间隔时间，在该时间内被认为是双击
        int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout();
        //  长按时间，超过此时间就认为是长按
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        //  重复按键间隔时间
        int repeatTimeout = ViewConfiguration.getKeyRepeatTimeout();

4、VelocityTracker

    4.1、使用
    追踪手指滑动过程中的速度
        1、在onTouchEvent中获取事件
        2、计算速度
    4.2、注意
        1、获取速度之前必须先计算速度
        2、速度指的是一段时间内手指划过的像素数
        3、不需要时，需要调用clear()来重置并回收

5、GestureDetector

    手势检测，用于检测单击、双击、滑动、长按等操作
    5.1、使用
        1、创建实例并实现对应的事件监听接口
        2、在onTouchEvent中获取事件
        
6、Scroll
    和View的computeScroll配合来让View弹性滑动
    
7、View的滑动
    7.1、使用ScrollTo/ScrollBy
    7.2、使用动画
        主要通过操作translationX和translationY
    7.3、改变布局参数
    7.4、各种滑动对比
        1、scrollTo/ScrollBy操作简单，适用于View内容滑动
        2、动画适用于没有View交互和复杂的动画效果
        3、改变布局参数操作略复杂，适用于有交互的View
8、弹性滑动
    8.1、Scroll
    8.2、通过动画
    8.3、使用延时策略
        

```

二、View的事件分发机制

```
1、三个方法
    1.1、dispatchTouchEvent
        用来进行事件分发，如果事件能够传递给当前View，那么会调用此方法，
        返回结果受当前View的onTouchEvent和下级的disPatchTouchEvent方
        法的影响表示是否消耗当前事件
    1.2、onInterceptTouchEvent
        在上述方法内部调用，用来判断是否拦截某个事件，如果View拦截了某个
        事件，那么在同一个时间序列当中，此方法不会被再次调用，返回结果便
        是是否拦截当前事件。
    1.3、onTouchEvent
        在dispatchTouchEvent方法中调用，用来处理事件，返回结果表示是否消
        耗当前事件，如果不消耗，则在同一事件序列中，当前View无法再次接受事件
```

三、View的工作原理

```
1、ViewRoot

    ViewRoot对应于ViewRootImpl类，是连接WindowManager和DecorView的纽带，
    View的三大流程均是通过ViewRoot来完成。在ActivityThread中，当Activity
    被创建完毕后，会将DecorView添加到Window中，同时创建ViewRootImpl对象，
    并将ViewRootImpl对象和DecorView建立关联。
    
```

