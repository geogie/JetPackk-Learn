package cn.george.mylearn.retrofit;

import com.alibaba.fastjson.JSON;

/**
 * Created By George
 * Description:
 */
public class JsonUtils {
    public static <T> T parseDataToObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = JSON.parseObject(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
