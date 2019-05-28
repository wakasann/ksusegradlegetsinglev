# 学习

1. `com.kuaishou.gifshow.e.a` 找到   

```
public static String c() {
   return a.getString("ShareUrlCopy", "http://www.gifshow.com/fw/photo");
}
```

通过 [Android简易数据存储之SharedPreferences](https://www.cnblogs.com/rwxwsblog/p/4802708.html) 了解到，这是一个简易的存储器，应该是保存App中的一些操作的链接列表

`com.yxcorp.gifshow.util.config.ConfigHelper` 中唯一使用了这个方法

```
private static f c = ......

```

`com.yxcorp.retrofit.consumer.f` 涉及到 `io.reactivex.subjects.PublishSubject` 这个包的`subscribe`,需要了解一下
