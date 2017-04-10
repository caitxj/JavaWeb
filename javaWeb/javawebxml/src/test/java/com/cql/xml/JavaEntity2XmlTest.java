package com.cql.xml;

import com.cql.entity.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import org.junit.Test;

/**
 * Created by caitxj on 4/10/2017.
 */
public class JavaEntity2XmlTest {


    @Test
    public void javaObject2Xml() {
        XStream stream = new XStream();
        stream.processAnnotations(User.class);
        User user = new User(1001, "mj", 22);
        String xml = stream.toXML(user);
        System.out.println(xml);
    }

    @Test
    public void xml2Object(){

        XStream  stream=new XStream();
        String xml="<user>\n" +
                "  <id>1001</id>\n" +
                "  <userName>mj</userName>\n" +
                "  <age>22</age>\n" +
                "</user>";
        stream.processAnnotations(User.class);
        User user=(User) stream.fromXML(xml);
        System.out.println(user.getName());
    }

    @Test
    public void object2Json(){

        XStream xStream=new XStream(new JsonHierarchicalStreamDriver());
        User user = new User(1001, "mj", 22);
        xStream.processAnnotations(User.class                                                                                                                                                                                                                                                                                                                                                                                                                     );
        String json=xStream.toXML(user);
        System.out.println(json);
    }

    @Test
    public void json2Object(){
        String jsonStr="{\"user\": {\n" +
                "  \"id\": 1001,\n" +
                "  \"userName\": \"mj\",\n" +
                "  \"age\": 22\n" +
                "}}";
        XStream stream=new XStream(new JettisonMappedXmlDriver());
        stream.alias("user",User.class);
        stream.aliasField("userName",User.class,"name");
        User u=(User) stream.fromXML(jsonStr);
        System.out.println("u:"+u.getName());
    }
}
