package openexcelandgetsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OpenExcel2 {
	
	public static Sheet readexcelvalues(String path,String sheetname) {
		
		File file = new File(path);
		
		try {
			
			FileInputStream inputstream = new FileInputStream(file);
			
			Workbook book = null; 
			Sheet sheet;
			
			String extension = FilenameUtils.getExtension(path);
			
			if(extension.equals("xlsx")) {
				
				try {
					book = new XSSFWorkbook(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(extension.equals("xls")) {
				
				try {
					book = new HSSFWorkbook(inputstream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			sheet = book.getSheet(sheetname);
			
			return sheet;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return null;
		
	}
	

}
