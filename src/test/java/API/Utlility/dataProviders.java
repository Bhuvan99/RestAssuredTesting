package API.Utlility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class dataProviders {

    @DataProvider(name="Data")
    public String[][] getAllData() throws IOException{
        String path = System.getProperty("user.dir")+"//testData//API_DDT_TestData.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Sheet1");
        int colNum = xl.getCellCount("Sheet1",1);

        String apiData[][] = new String[rowNum][colNum];

        for (int i=1;i<=rowNum;i++){
           for(int j=0;j<colNum;j++){
               apiData[i-1][j] = xl.getCellData("Sheet1",i,j);
           }
        }

        return apiData;
    }

    @DataProvider(name="UserNames")
    public String[] getUserNames() throws IOException{
        String path = System.getProperty("user.dir")+"//testData//API_DDT_TestData.xlsx";
        XLUtility xl = new XLUtility(path);
        int rowNumber = xl.getRowCount("Sheet1");

        String[] apiData = new String[rowNumber];
        for(int i=1;i<=rowNumber;i++){
            apiData[i-1] = xl.getCellData("sheet1",i,1);
        }
        return apiData;
    }

}
