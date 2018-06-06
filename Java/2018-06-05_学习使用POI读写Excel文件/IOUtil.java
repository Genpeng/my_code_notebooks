package ai.labrador.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Genpeng Xu
 */
public class IOUtil {
    /**
     * The Unix line separator string.
     */
    private static final String LINE_SEPARATOR_UNIX = "\n";
    /**
     * The Windows line separator string.
     */
    private static final String LINE_SEPARATOR_WINDOWS = "\r\n";

    private static final String EXCEL_EXTENSION_NAME_03 = ".xls";

    private static final String EXCEL_EXTENSION_NAME_07 = ".xlsx";

    // readLines
    // ---------------------------------------------------------------------------- //

    /**
     *
     * @param input
     * @return
     * @throws IOException
     */
    public static List<String> readLines(InputStream input) throws IOException {
        InputStreamReader reader = new InputStreamReader(input);
        return readLines(reader);
    }

    /**
     *
     * @param input
     * @param encoding
     * @return
     * @throws IOException
     */
    public static List<String> readLines(InputStream input, String encoding) throws IOException {
        if (encoding == null) {
            return readLines(input);
        } else {
            InputStreamReader reader = new InputStreamReader(input, encoding);
            return readLines(reader);
        }
    }

    /**
     *
     * @param input
     * @return
     * @throws IOException
     */
    public static List<String> readLines(Reader input) throws IOException {
        BufferedReader reader = new BufferedReader(input);
        List<String> list = new LinkedList<>();
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }

    // writeLines
    // ---------------------------------------------------------------------------- //

    /**
     *
     * @param output
     * @param list
     */
    public static void writeLines(OutputStream output, List<String> list) {
        OutputStreamWriter writer = new OutputStreamWriter(output);
        writeLines(writer, list);
    }

    /**
     *
     * @param output
     * @param encoding
     * @param list
     * @throws UnsupportedEncodingException
     */
    public static void writeLines(OutputStream output,
                                  String encoding,
                                  List<String> list) throws UnsupportedEncodingException {
        if (encoding == null) {
            writeLines(output, list);
        } else {
            OutputStreamWriter writer = new OutputStreamWriter(output, encoding);
            writeLines(writer, list);
        }
    }

    /**
     *
     * @param output
     * @param list
     */
    public static void writeLines(Writer output, List<String> list) {
        PrintWriter writer = new PrintWriter(output);
        for (String line : list) {
            writer.println(line);
        }

        writer.flush();
        writer.close();
    }

    // readExcel
    // ---------------------------------------------------------------------------- //


    public static List<String[]> readExcel(File file, int sheetIndex) throws InvalidFormatException, IOException {
        Workbook wb = WorkbookFactory.create(file);
        Sheet sheet = wb.getSheetAt(sheetIndex);

        List<String[]> lines = new LinkedList<>();
        for (Row row : sheet) {
            int lastCellNum = row.getLastCellNum();
            String[] arr = new String[lastCellNum];
            for (int i=0; i<lastCellNum; i++) {
                Cell c = row.getCell(i);
                if (c == null) {
                    arr[i] = "";
                } else {
                    arr[i] = c.toString();
                }
            }
            lines.add(arr);
        }

        return lines;
    }

    // writeExcel
    // ---------------------------------------------------------------------------- //

    /**
     * Generate a Workbook object according to the path.
     *
     * @param path String object, the path of the file
     * @return Workbook object
     * @throws InvalidFormatException if occurs
     */
    public static Workbook createWorkbook(String path) throws InvalidFormatException {
        Workbook wb = null;
        if (path.endsWith(EXCEL_EXTENSION_NAME_03)) {
            wb = new HSSFWorkbook();
        } else if (path.endsWith(EXCEL_EXTENSION_NAME_07)) {
            wb = new XSSFWorkbook();
        } else {
            throw new InvalidFormatException("This is not a EXCEL file!!!");
        }
        return wb;
    }

    /**
     * Write a Workbook object into a Excel file.
     *
     * @param wb Workbook object
     * @param outPath the path of the Excel file
     */
    public static void writeExcel(Workbook wb, String outPath) throws IOException {
        try (OutputStream fileOut = new FileOutputStream(outPath)) {
            wb.write(fileOut);
        }
    }
}
