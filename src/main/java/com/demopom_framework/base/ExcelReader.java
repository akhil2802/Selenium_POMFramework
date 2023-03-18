package com.demopom_framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static ArrayList getTestData(String filePath) {
		
		ArrayList arrayList = new ArrayList();

		//	Excel Reading Using POI API:

		try {
			//		Open the Excel file:
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);

			// Create a workbook object using XSSFWorkbook class
			Workbook workbook = new XSSFWorkbook(inputStream);

			// Get the first sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);

			// Iterate over rows and columns
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
						case STRING:
							arrayList.add(cell.getStringCellValue());
							break;
						case NUMERIC:
							arrayList.add(cell.getNumericCellValue() + "\t");
							break;
						case BOOLEAN:
							arrayList.add(cell.getBooleanCellValue() + "\t");
							break;
						default:
							System.out.println("\t");
					}
					// Get the cell value and print it
					String cellValue = cell.getStringCellValue();
					System.out.print(cellValue + "\t");
				}
				System.out.println();
			}

			// Close the workbook and input stream
			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrayList;
	}
}
