package com.cql.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by caitxj on 4/11/2017.
 */
public class POIExcelManager {


    public static  void readExcel(File file) throws IOException {

        Workbook workbook;

        String fileName=file.getName();

        String extention=fileName.substring(fileName.lastIndexOf(".")+1);

        FileInputStream fileInputStream=new FileInputStream(file);

        //进行文件类型判断生成不同
        if("xlsx".equals(extention)){
            workbook=new XSSFWorkbook(fileInputStream);
        }else{
            workbook=new HSSFWorkbook(fileInputStream);
        }
        DataFormatter formatter = new DataFormatter(); //定义数据格式化

        Sheet sheet=workbook.getSheetAt(0);

        int rows=sheet.getPhysicalNumberOfRows();

        System.out.println("rows:"+rows);

        for(int i=0;i<rows;i++){
            if(i==0){
                continue;
            }
            int cols=sheet.getRow(i).getPhysicalNumberOfCells();
//            System.out.println("size:"+cols);
            for(int j=0;j<cols;j++){
                Cell cell=sheet.getRow(i).getCell(j);
                System.out.println(formatter.formatCellValue(cell));
            }
        }
        //删除标题
        sheet.removeRow(sheet.getRow(0));
        workbook.write(new FileOutputStream("test.xlsx"));
        //获取sheet 操作
//        for (Sheet sheet:workbook){
//            System.out.println(sheet.getSheetName());
//            for (Row row:sheet){
//                for(Cell cell:row){
//                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
//                    String text = formatter.formatCellValue(cell);
//                    System.out.println(text);
//                    }
//                }
//            }
    }

    public static void createExcel(String excelName) throws IOException {
        Workbook workbook=new XSSFWorkbook();
        //创建sheet
        Sheet userSheet=workbook.createSheet("userSheet");
        Row row1=userSheet.createRow(0);
        //cell 相关参数设置
        Cell c1=row1.createCell(0);
        c1.setCellValue("test");
        workbook.write(new FileOutputStream(excelName));
        workbook.close();
        System.out.println("create excel successfully......");
    }
}
