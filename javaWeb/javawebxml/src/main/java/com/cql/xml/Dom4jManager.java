package com.cql.xml;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caitxj on 4/10/2017.
 */
public class Dom4jManager {


    public static void readXml() throws DocumentException {

        SAXReader saxReader=new SAXReader();
        Document doc= saxReader.read(new File(JdomManager.class.getResource("/").getPath()+"student.xml"));

        String xml=doc.asXML();
        System.out.println("xml:"+xml);

        Element element=doc.getRootElement();

        List<Element> elements= element.elements("student");

        for (Element e:elements){
            List<Element> el=e.elements();
            for(Element es:el){
                System.out.println(es.getText());
            }
        }

    }


    public static  void cud(String op) throws IOException, DocumentException {
         SAXReader reader=new SAXReader();
         Document doc= reader.read(new File(JdomManager.class.getResource("/").getPath()+"student.xml"));
       DocumentFactory documentFactory= DocumentFactory.getInstance();
        Document document=documentFactory.createDocument();
        if ("add".equals(op)){
            Element root= document.addElement("students");
            Element stu=root.addElement("student");
            stu.addAttribute("idcard","1002");
            Element id=stu.addElement("id");
            id.setText("1000001");
            XMLWriter  writer=new XMLWriter(new FileOutputStream("student-dom4j.xml"));
            writer.write(document);
            writer.close();

        }else  if("delete".equals(op)){
            Element root=doc.getRootElement();
            root.remove(root.attribute("id"));
        }else if("update".equals(op)){
            Element root=doc.getRootElement();

            Element stu1=root.addElement("student");
            stu1.addAttribute("ids","1000001");
        }
        System.out.println("xml:"+document.asXML());
        System.out.println("dle:"+doc.asXML());
        XMLWriter  writer=new XMLWriter(new FileOutputStream("student-dom4j.xml"));
        writer.write(doc);
        writer.close();
    }

}
