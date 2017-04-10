package com.cql.xml;

import org.jdom.JDOMException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by caitxj on 4/10/2017.
 */
public class JdomManagerTest {

    @Test
    public void readTest(){

        try {
            JdomManager.readXML();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addTest(){
        try {
//            JdomManager.addContent("add");
//            JdomManager.addContent("remove");
            JdomManager.addContent("update");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
