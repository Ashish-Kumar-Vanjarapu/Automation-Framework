package MultipleClasses_Excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtility(String genericPath, String sheetName) {
		try {
			File src = new File(genericPath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		}

	}

	public int getRowCount() {
		int rowCount=0;
		try {
			rowCount = sheet.getLastRowNum();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		}
		return rowCount;

	}

	public int getColCount() {
		int colCount=0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		}
		return colCount;

	}

	public String getCellDataString(int rowNum, int colNum) {
		String CellData = null;
		try {
			CellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		}
		return CellData;

	}

	public void getCellDataNumber(int rowNum, int colNum) {
		try {
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		} catch (Exception exp) {
			System.out.println(exp.getMessage());

		}
	}

}
