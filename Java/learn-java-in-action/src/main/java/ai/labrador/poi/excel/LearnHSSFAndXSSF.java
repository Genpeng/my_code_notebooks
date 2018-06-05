package ai.labrador.poi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
        // 新建 Workbook（相当于一个 Excel 文件）
        // ============================================================================== //
        Workbook wb = new HSSFWorkbook(); // or Workbook wb = new XSSFWorkbook();

        // 中间省略...

        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) { // or workbook.xlsx
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist or the path is not correct!!!");
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 新建 Sheet
        // ============================================================================== //
        Sheet sheet = wb.createSheet("The Name of the Sheet");

        // 创建 Cells
        // ============================================================================== //
        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue("Let me have a try!");

        // Or do it on one line.
        CreationHelper createHelper = wb.getCreationHelper();
        row.createCell(1).setCellValue(
                createHelper.createRichTextString("Let me have a try!"));

        // Files vs InputStreams
        // ============================================================================== //
        // 使用 File 对象比使用 InputStream 对象所需的内存资源更少，因为使用 InputStream 对象
        // 需要将整个文件缓存到内存中。

        //
        // ============================================================================== //
    }
}
