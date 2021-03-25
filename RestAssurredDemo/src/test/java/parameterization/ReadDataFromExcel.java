package parameterization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static Object[][] testreadexcel() {

		File file = new File("C:\\Users\\p.a.madhusudan\\Desktop\\readData.xlsx");
		Object[][] data = null;

		try {
			InputStream io = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(io);
			XSSFSheet sheet1 = workbook.getSheetAt(0);
			System.out.println(sheet1.getFirstRowNum());
			int rowCount = sheet1.getLastRowNum();
			System.out.println("row count is  "+rowCount);
            int cellCount = sheet1.getRow(0).getLastCellNum();
            System.out.println("cell count is " +cellCount);
            
            
			//sheet1.getRow(0).createCell(2).setCellValue("Result");
			// System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
			// System.out.println(sheet1.getRow(0).getCell(1).getStringCellValue());
            
            Object[][] obj = new Object[rowCount][cellCount];
            
            
			for (int i = 1; i <= rowCount; i++) {
				

				DataFormatter format = new DataFormatter();
				Object firstName = format.formatCellValue(sheet1.getRow(i).getCell(0));
				System.out.println(firstName);
				Object lastName =  format.formatCellValue(sheet1.getRow(i).getCell(1));
				System.out.println(lastName);
				Object subjectId = format.formatCellValue(sheet1.getRow(i).getCell(2));
				System.out.println(subjectId);

				data = new Object[][] { { firstName, lastName, subjectId } };
			}
					

			OutputStream os = new FileOutputStream(file);
			workbook.write(os);
			workbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;

	}

}
