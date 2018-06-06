package ai.labrador.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

/**
 * 学习使用 HSSF 或者 XSSF 读写 Excel 文件
 * Reference:
 * [Busy Developers' Guide to HSSF and XSSF Features](http://poi.apache.org/spreadsheet/quick-guide.html#NewWorkbook)
 *
 * @author  Genpeng Xu
 * @date    2018/06/05
 */
public class LearnHSSFAndXSSF {
    public static void main(String[] args) {

        // 写入 Excel 文件
        // ============================================================================== //
        Workbook wb = new HSSFWorkbook(); // or Workbook wb = new XSSFWorkbook();

        // Create a sheet.
        Sheet sheet = wb.createSheet("The Name of the Sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue("Let me have a try!");

        // Or do it on one line.
        row.createCell(1).setCellValue("Let me have a try!");

        /*
        备注：
        try (...) {
            ...
        }
        上述的表达能够在所有语句执行完之后自动释放括号中的资源。
         */
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) { // or workbook.xlsx
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            System.out.println("The path is not correct!!!");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读取 Excel 文件到 Workbook 对象中
        // ============================================================================== //

        /*
        使用 File 对象比使用 InputStream 对象所需的内存资源更少，因为使用 InputStream 对象
        需要将整个文件缓存到内存中。
         */

        // Use a file
        try {
            Workbook wb = WorkbookFactory.create(new File("MyExcel.xls")); // or MyExcel.xlsx
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        // Use an InputStream, needs more memory
        try (InputStream in = new FileInputStream("MyExcel.xls")) { // or MyExcel.xlsx
            Workbook wb = WorkbookFactory.create(in);
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or the path is not correct!!!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        // 遍历 Excel
        // ============================================================================== //
        try {
            Workbook wb = WorkbookFactory.create(new File("MyExcel.xls")); // or MyExcel.xlsx

            for (Sheet sheet : wb) {
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        // pass
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
