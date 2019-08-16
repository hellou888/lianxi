package tookit;

import com.alibaba.fastjson.JSON;

/**
 *用于json转对象及对象转json
 */
public class JsonConvert {
    /**
     *用于json转对象及对象转json
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     */
    public  static  <T> T JsonToObject(String jsonStr,Class<T> t){
        return JSON.parseObject(jsonStr,t);
    }

    /**
     * 将o转换成字符串对象
     * @param o
     * @return
     */
    public  static  String ObjectToJsonString(Object o){

        return JSON.toJSONString(o);
    }


}
