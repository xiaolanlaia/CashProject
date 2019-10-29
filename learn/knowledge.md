一、Parcelable 和Serializable

```
Serializable是Java中的序列化接口，使用简单但开销大。
序列化和反序列化需要大量的I/O操作
Parcelable是Android中的序列化方式，使用麻烦但效率高。
Parcelable主要用在内存序列化上。
将对象序列化到存储设备和将对象序列化后进行网络传输使用Parcelable会比较麻烦，
因此推荐使用Serializable。
```
