package tookit;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dom4jr {

    public  static <E> List<E> get(Document document, Class<E> clazz) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<E> list = new ArrayList<>();

        Element root = document.getRootElement();
        Iterator<Element> it = root.elementIterator();
        while (it.hasNext()){
            Element element = it.next();
            E obj=clazz.newInstance();
            //获取标签名
            String name=element.getName();
            //获取标签属性
            String value = element.attribute("userName").getValue();
            //从bean中取与标签相同的成员变量
            Field newname = clazz.getDeclaredField(name);
            newname.setAccessible(true);
            if(value!=null){
                newname.set(obj,value);
            }

            list.add(obj);
        }

        return list;
    }

}
