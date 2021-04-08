package org.xinyu.base.ioc;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzqno on 2016-12-26.
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> beans = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext() throws Exception {
        SAXBuilder sb = new SAXBuilder();
        String path = Class.class.getClass().getResource("/").getPath();
        System.out.println("path:" + path);
        Document doc = sb.build("d:/bean.xml"); // 构造文档对象
        Element root = doc.getRootElement(); // 获取根元素HD
        List list = root.getChildren("bean"); // 取名字为bean的所有元素
        for (int i = 0; i < list.size(); i++) {
            Element element = (Element) list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");
            Object beanObj = Class.forName(clazz).newInstance(); // 反射获取对象
            beans.put(id, beanObj); // 将对象存入Bean工厂

            for (Element propertyElement : element.getChildren("property")) {
                String name = propertyElement.getAttributeValue("name"); // name="userDao"
                String bean = propertyElement.getAttributeValue("bean"); // bean="userDao"
                Object injectObject = beans.get(bean); // 从Bean工厂中获取UserDao
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1); // setUserDao
                Method method = beanObj.getClass().getMethod(methodName, injectObject.getClass());
                method.invoke(beanObj, injectObject); // set注入UserDao对象
            }
        }
    }

    public Object getBean(String id) {
        return beans.get(id);
    }

}
