package java_final;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {

    public String[][] readXl(String xlPath, String sheetName) throws IOException{

        String path = xlPath;

        FileInputStream fis = new FileInputStream(path);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheet(sheetName);

        int rows = ws.getLastRowNum()+1;
        int cols = ws.getRow(0).getLastCellNum();

        String[][] data = new String[rows][cols];

        for (int r = 0; r < rows; r++){

            XSSFRow myRow = ws.getRow(r);

            for (int c = 0; c<cols; c++){

                XSSFCell cell = myRow.getCell(c);
                String value = getCellValue(cell);
                data[r][c] = value;

            }

        }

        return data;
    }

    public static String getCellValue(Cell cellValue){
        Object value = null;

        switch (cellValue.getCellType())
        {
            case STRING:
                value = cellValue.getStringCellValue();
                break;
            case NUMERIC:
                value = cellValue.getNumericCellValue();
                break;
            case BOOLEAN:
                value = cellValue.getBooleanCellValue();
                break;
        }
        return value.toString();

    }

}
