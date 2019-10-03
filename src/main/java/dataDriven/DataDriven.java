package dataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {
    public static void main(String[] args) throws IOException {


}
public ArrayList<String> getData(String testCaseName) throws IOException {
    ArrayList<String> arrayList = new ArrayList<String>();
    FileInputStream fis = new FileInputStream("C://Users//nurea//TestProject1//New Project//SignUp.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    int numberOfSheet = workbook.getNumberOfSheets();
    for(int i =0; i<numberOfSheet; i++){
        if(workbook.getSheetName(i).equalsIgnoreCase("Data"))
        {
            XSSFSheet sheet = workbook.getSheetAt(i);
            Iterator<Row> rows = sheet.iterator();
            Row firstRow = rows.next();
            Iterator<Cell> ce = firstRow.cellIterator();
            ce.next();
            int j = 0;
            int coloum = 0;
            while(ce.hasNext()){
                Cell value = ce.next();
                if(value.getStringCellValue().equalsIgnoreCase("TestCase")){
                    coloum =j;
                }
                j++;
            }
            System.out.println(coloum);
            while(rows.hasNext()){
                Row r = rows.next();
                if(r.getCell(coloum).getStringCellValue().equalsIgnoreCase(testCaseName)){
                    Iterator<Cell> cv = r.cellIterator();
                    while(cv.hasNext()){
                        Cell c =cv.next();
                        if (c.getCellTypeEnum() == CellType.STRING) {
                            arrayList.add(cv.next().getStringCellValue());
                        }else {
                            arrayList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                        }


                    }
                }
            }

        }
    }
    return arrayList;
}

}