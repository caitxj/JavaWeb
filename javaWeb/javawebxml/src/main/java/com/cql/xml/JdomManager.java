package com.cql.xml;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by caitxj on 4/10/2017.
 */
public class JdomManager {


    /**
     *
     * 1.创建builder
     * 2.进行文件解析操作
     *
     */
    public static  void readXML() throws JDOMException, IOException {

        SAXBuilder saxBuilder=new SAXBuilder();
        Document doc=saxBuilder.build(new File(JdomManager.class.getResource("/").getPath()+"student.xml"));

        Element root=doc.getRootElement();
        List<Element> chids= root.getChildren();  //子元素
        List<Element> chids1= root.getChildren("student"); //获取后代元素
        for (Element element:chids){
          List<Element> els=element.getChildren();
          System.out.println(element.getAttribute("idcard").getValue());
          for(Element e:els){
            System.out.println(e.getText());
          }
        }
    }

    public static  void addContent(String op) throws JDOMException, IOException {

        SAXBuilder saxBuilder=new SAXBuilder();
        Document doc= saxBuilder.build(new File(JdomManager.class.getResource("/").getPath()+"student.xml"));
        if("add".equals(op)) {

            //创建元素(并给元素绑定关系)
            Element stu1 = new Element("student");
            stu1.setAttribute("idcard", "50010719");
            Element id = new Element("id");
            id.setText("1002");
            Element name = new Element("name");
            name.setText("mjtest");

            stu1.addContent(id);
            stu1.addContent(name);
            Element root = doc.getRootElement();
            root.addContent(stu1);
        }else  if("remove".equals(op)){
            doc.getRootElement().removeChild("student");
        }else if("update".equals(op)){
            Element stu1 = new Element("student");
            stu1.setAttribute("idcard", "50010719");
            Element id = new Element("id");
            id.setText("1002");
            Element name = new Element("name");
            name.setText("mjtest");

           Element root= doc.getRootElement();
            root.setAttribute("rid","wwe");
            root.addContent(stu1);
        }
        //输出添加后的xml

        XMLOutputter outputter=new XMLOutputter();
        //通过xmloutput  将数据输出进行查看
        String xml=outputter.outputString(doc);
        System.out.println(xml);
        outputter.output(doc,new FileOutputStream("student-add.xml"));
    }
}
