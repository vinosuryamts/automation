package openexcelandgetsheet;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import objectholder.storebrowservalue;

public class Test1operation {
		
	@SuppressWarnings({ "deprecation" })
	public static ArrayList<storebrowservalue> storevalues(Sheet sheetdetails){
		
		
		
		int rowcount = sheetdetails.getLastRowNum()-sheetdetails.getFirstRowNum();
		
		ArrayList<String> browsername = new ArrayList<String>(rowcount);
		ArrayList<String> url = new ArrayList<String>(rowcount);
		ArrayList<storebrowservalue> arraylist = new ArrayList<storebrowservalue>(rowcount) ;

		
		for(int i=1; i<=rowcount;i++) {
			
			Row row = sheetdetails.getRow(i);
			
				for(int j=0;j<row.getLastCellNum();j++) {
					
					Cell cellvalue = row.getCell(j); 
					
					if(cellvalue == null || cellvalue.getCellTypeEnum() == CellType.BLANK) {
						
					}else {
						if(j==0) {
							System.out.println("Executing : "+row.getCell(j).getStringCellValue());
						}else {
							if(j==1) {
								browsername.add(row.getCell(j).getStringCellValue());
							}else if(j==2) {
								url.add(row.getCell(j).getStringCellValue());
							}
						}
					}

					
				}
				

				
		}
		
		
		for(int k=0;k<browsername.size();k++) {
			storebrowservalue bw = new storebrowservalue(browsername.get(k),url.get(k));
			arraylist.add(bw);
		}
	
		
		
		return arraylist;
	}

}
