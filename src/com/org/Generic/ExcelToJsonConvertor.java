package com.org.Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExcelToJsonConvertor {
	public JSONObject getJson(String filePath) throws IOException, JSONException{
		FileInputStream inputStream = new FileInputStream(new File(filePath));
		String key = null;
		String assistKeyVariable = null;
        Workbook workbook = new XSSFWorkbook(inputStream);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        
        
        
        
        Sheet firstSheet = workbook.getSheetAt(0);
        // Start constructing JSON.
        JSONObject json = new JSONObject();
        
        // Iterate through the rows.
        JSONArray rows = new JSONArray();
        for ( Iterator<Row> rowsIT = firstSheet.rowIterator(); rowsIT.hasNext(); )
        {	
        	int flag = 1;
        	
            Row row = rowsIT.next();
            JSONObject jRow = new JSONObject();

            // Iterate through the cells.
            JSONArray cells = new JSONArray();
            for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
            {
                Cell cell = cellsIT.next();
                //cell.setCellType(Cell.CELL_TYPE_STRING); 
                //cells.put( cell.getStringCellValue() );
                
                switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                	int cellvalue = 0;
                	cells.put(cellvalue);
                	break;
                
                case Cell.CELL_TYPE_STRING:
                	if(flag == 1){
                	assistKeyVariable = (cell.getStringCellValue());
                	
                	 key = assistKeyVariable.replaceAll(" ","_");
                	cells.put(assistKeyVariable);
                	
                	
                	
                	flag = 0;
                	break;
                	}
                	else{
                	assistKeyVariable=	(cell.getStringCellValue());
                	cells.put(assistKeyVariable);
                    break;
                	}
                	
                case Cell.CELL_TYPE_BOOLEAN:
                	cells.put(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                		if(DateUtil.isCellDateFormatted(cell)){
                		//System.out.println("It is Date");
                		DateFormat df = new SimpleDateFormat("MMM-YY");
                		Date tempDate = cell.getDateCellValue();
                		System.out.println(cell.getDateCellValue());
                		String date= df.format(tempDate);
                		//System.out.println(date);
                		cells.put(date);
                		break;
                		}
                	
                		else{
                			int number = (int) cell.getNumericCellValue();
                			cells.put(number);
                			break;
                		}
                	
               
                
                 case Cell.CELL_TYPE_FORMULA:
//                   if(cell.get.isEmpty()){
//                	   
//                   }
            	   evaluator.evaluateAll();
            	   int num = (int) cell.getNumericCellValue();
            	   cells.put(num);
                   break;
                    
            }
         }
         jRow.put( key , cells );
         rows.put( jRow );
      }

    // Create the JSON.
    json.put( "rows", rows );
     System.out.println("Json is " + json);
    // Get the JSON object.
    return json;
	}
}
