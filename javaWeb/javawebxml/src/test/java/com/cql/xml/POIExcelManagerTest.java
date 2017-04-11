package com.cql.xml;

import com.cql.excel.POIExcelManager;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by caitxj on 4/11/2017.
 */
public class POIExcelManagerTest {

    private File file=new File(POIExcelManagerTest.class.getResource("/").getPath()+"/student.xlsx");


    @Test
    public void readExcelTest() throws IOException {
        POIExcelManager.readExcel(file);
    }

    @Test
    public void createExcelTest() throws IOException {
        POIExcelManager.createExcel("userTest.xlsx");
    }
}
