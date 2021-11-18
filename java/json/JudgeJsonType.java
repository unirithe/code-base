import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

public void boolean isJson(String data){
  try {
    JSON.parse(data);
    return true;
  } catch(JSONException e){
    return false;
  }
}
