package com.cql.xml;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by caitxj on 4/10/2017.
 */
public class Dom4jManagerTest {


    @Test
    public void readTest() throws DocumentException {

        Dom4jManager.readXml();
    }

    @Test
    public void cudTest() throws IOException, DocumentException {
        //Dom4jManager.cud("add");
//        Dom4jManager.cud("delete");
//        Dom4jManager.cud("update");
    }
    @Test
    public  void urlTest(){
        System.out.println(Dom4jManagerTest.class.getResource("../").getPath());
        System.out.println(Dom4jManagerTest.class.getResource("/").getPath());
    }
}
