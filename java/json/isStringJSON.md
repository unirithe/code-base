# 判断字符串是否为标准的JSON格式
---
使用到的包:
```java
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
```
实现的代码:
```java
public boolean isJSON(String data){
  try{
    JSON.parse(data);
    return true;
  } catch(JSONException e){
    return false;
  }
}
```
