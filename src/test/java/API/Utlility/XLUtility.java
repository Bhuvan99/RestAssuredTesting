package API.Utlility;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workBook;
    public XSSFSheet workSheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle styles;
    String path;

    public XLUtility(String path){
        this.path=path;
    }

    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workBook = new XSSFWorkbook(fi);
        workSheet = workBook.getSheet(sheetName);
        int rowCount = workSheet.getLastRowNum();
        workBook.close();
        fi.close();
        return rowCount;
    }

    public int getCellCount(String sheetName,int rowNumber) throws IOException{
        fi = new FileInputStream(path);
        workBook = new XSSFWorkbook(fi);
        workSheet = workBook.getSheet(sheetName);
//        int rowCount1 = workSheet.getLastRowNum();
        row = workSheet.getRow(rowNumber);
        int cellCount = row.getLastCellNum();
        workBook.close();
        fi.close();
        return cellCount;
    }

    public String getCellData(String sheetName,int rowNumber, int colNumber) throws IOException{
        fi = new FileInputStream(path);
        workBook = new XSSFWorkbook(fi);
        workSheet = workBook.getSheet(sheetName);
        row = workSheet.getRow(rowNumber);
        cell = row.getCell(colNumber);

        DataFormatter formatter = new DataFormatter();
        String data;
        try {
            data = formatter.formatCellValue(cell);
        } catch (Exception e) {
           data="";
        }
        workBook.close();
        fi.close();
        return data;
    }
}
