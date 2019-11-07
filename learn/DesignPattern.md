# <center>一、六大原则</center>
```
1、单一职责原则
对于一个类而言，应该只有一个引起它变化的原因。一个类，应该是一组相关性很高的函
数、数据的封装。

2、开闭原则
对象对于扩展应该是开放的，对于修改应该是封闭的。

3、里氏替换原则
所有引用其基类的地方必须能够透明地使用其子类对象。

4、依赖倒置原则
高层次的模块不依赖于低层次的模块的实现细节。模块间的依赖通过抽象发生，实现类之
间不发生直接的依赖关系。

4.1、关键点：
    1)高层模块不应该依赖底层模块，两者都应该依赖其抽象。
    2)抽象不应该依赖细节。
    3)细节应该依赖抽象。
    
5、接口隔离原则
类间的依赖关系应该建立在最小的接口上。接口隔离原则将非常庞大、臃肿的接口拆分成
更小和更具体的接口。

6、迪米特原则(最少知识原则)
一个对象应该对其他对象有最少的了解。一个类应该对自己需要耦合或调用的类知道得最
少，类的内部实现与调用者或者依赖者没关系。
```

# <center>二、单例模式</center>
```
1、特点：
    1)构造方法私有化
    2)通过静态方法或者枚举类返回单例类对象
    3)确保单例类对象只有一个，尤其是在多线程环境下
    4)确保单例类对象在反序列化时不会重新构建对象
    
2、饿汉模式
在申明静态对象时初始化

class Singleton{

private static final Singleton singleton = new Singleton();

private Singleton(){}

public static Singleton getInstance(){
    return singleton;
    }

}

3、懒汉模式
在第一次调用时初始化单例类对象
    2.1、优点：只有在使用时才会被初始化，在一定程度上节约了资源
    2.2、缺点：第一次加载时需要进行实例化，反应稍慢；每次调用调用都进行同步，
         造成不必要的同步开销。
         
class Singleton{

private static final Singleton singleton;

private Singleton(){}

public static synchronized Singleton getInstance(){
    if(singleton == null){
        singleton =  new Singleton;
        }
        return singleton;
    }

}         
         

4、Double CheckLock(DCL)实现单例
既能在需要时才初始化单例，又能保证线程安全，且单例对象初始化调用getInstance不
进行同步锁。

特点：
    4.1、对类对象进行两次判空。第一层为了避免不必要的同步，第二层为了在null的
         情况下创建实例。

class Singleton{

private static final Singleton singleton = null;

private Singleton(){}

public static Singleton getInstance(){
    if(singleton == null){
        synchronized(Singleton.class){
            if(singleton == null){
                singleton =  new Singleton;
            } 
        }
        
    }
        return singleton;
    }
} 


5、静态内部类单例模式

既保证线程安全，又保证单例对象的唯一性，推荐使用。

class Singleton{

private Singleton(){}

public static Singleton getInstance(){

        return SingletonHolder.singleton;
    }
    /**
    *静态内部类
    */
    private static class SingletonHolder{
    
    private static final Singleton singleton = new Singleton();
    
    }
} 

6、枚举单例

public enum Singleton{

    INSTANCE;
    public void doSomething(){
    
    }
}


```

# <center>三、Builder模式</center>

```
3.1、定义
将复杂的构造与它的表示分离，使得同样的构建过程可以创建不同的表示。

3.2、使用场景
    1、相同的方法，不同的执行顺序，产生不同的执行结果。
    2、多个部件或零件，都可以装配到一个对象中，但是产生的运行结果不相同。
    3、产品类非常复杂，或者产品类中的调用顺序不同产生不同的作用。
    4、初始化一个对象非常复杂，如参数多，并且很多参数都具有默认值时。
    
3.3、优点
    1、良好的封装性
    2、建造者独立，容易扩展
    
3.4、缺点
    会产生多余的Builder和Director，消耗内存

```

# <center>四、原型模式</center>

```
4.1、定义
用原型实例指定创建对象的类型，并通过拷贝这些原型创建爱你新的对象

4.2、使用场景
    1、 类初始化需要消耗非常多的资源，这个资源包括数据、硬件资源等，通过原型拷
        贝避免这些消耗
    2、 通过new产生一个对象需要非常繁琐的数据准备或访问权限，这时可以使用原型
        模式。
    3、 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，
        可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝

4.3、注意
    1、通过clone拷贝对象时并不会执行构造函数。

4.4、深拷贝和浅拷贝
    原型模式只是一个浅拷贝，这份拷贝并不是将原始的所有字段重新构造一份，而是
    副本文档的字段引用原始文档的字段。A引用B指的是两个对象指向同一个地址。
    
    深拷贝，在拷贝对象时，对于引用型的字段也要采用拷贝的形式，而不是单纯的引
    用的形式。
```

#  <center>五、工厂模式</center>

```
5.1、定义
定义一个用于创建对象的接口，让子类决定实例化哪个类

5.2、使用场景
在任何需要生成复杂对象的地方，都可以使用工厂模式。复杂模式适合使用工厂模式，
用new就可以完成创建的对象无需使用工厂模式。
```

# <center>六、抽象工厂模式</center>

```
6.1、定义
为创建一组相关或者是相互依赖的对象提供一个接口，而不需要制定他们的具体类。

6.2、使用场景
 
```

# <center>七、策略模式</center>

```
7.1、定义
策略模式让算法独立于使用它的客户而独立变化

7.2、使用场景
    1、针对同一类型问题的多种处理方式，仅仅是具体行为有差别时
    2、需要安全地封装同一类型的操作时
    3、出现同一个抽象类有对个子类，二有需要使用if—else或者switch-case来选择
       具体子类时。

```

# <center>八、状态模式</center>

8.1、定义
当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类

8.2、使用场景
    1、 一个对象的行为取决于他的状态，并且它必须在运行时根据状态改变他的行为
    2、 代码中包含大量与对象有关的条件语句，例如，一个操作中含有庞大的多分支语
        句(if-else、switch-case)，且这些分支依赖于该对象的状态。
        
