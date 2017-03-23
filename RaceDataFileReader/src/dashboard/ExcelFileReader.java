package dashboard;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String jsonOpenBrack 		="[";
	private final String jsonClosedBrack 	="]";
	private final String jsonOpenCurly	 	="{";
	private final String jsonClosedCurly 	="}";
	private final String jsonComma 			=",";
    private ArrayList<String> headers= new ArrayList<String>();	
	private int maxcells;
    public ExcelFileReader() {
       
    }

    //Overriding HTTPServlet DoGet method. HTTP Get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("Entering doGet");
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Rjt\\workspace\\RaceDataFileReader\\demorace.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			 maxcells=sheet.getRow(0).getLastCellNum();
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			//function to get Column headers/titles
			writeColumnHeaders(rowIterator);
			writeColumnData(rowIterator,response);
			
			

			
			file.close();
		} //end of try
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
	}//end of doGet
	
	//Method for reading the column data and sending response
	private void writeColumnData(Iterator<Row> rowIterator, HttpServletResponse response)
	{	String cellData="";
	String jsonstring = ""; 
	String jsonfinal = "";
	
	jsonfinal +=jsonOpenBrack;
	
	while(rowIterator.hasNext())
	{
		Row row= rowIterator.next();
		if(row.getRowNum()==0){
			continue;
		}
		jsonfinal+=jsonOpenCurly;
		for(int i=0;i<maxcells;i++){
			
		Cell cell=row.getCell(i, Row.CREATE_NULL_AS_BLANK);	
		
		if(cell==null)
		{
			cellData="No values";
				
		}//end of if
		else
		{
			switch(cell.getCellType()){
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
                  cellData=(new SimpleDateFormat("MM-dd-yyyy").format(cell.getDateCellValue()));
                } else {
                	String str = NumberToTextConverter.toText(cell.getNumericCellValue());
                	 cellData=str;
                }
				break;
			case Cell.CELL_TYPE_STRING:
				
				 cellData=(cell.getStringCellValue()) ;
				break;							
			case Cell.CELL_TYPE_FORMULA:
				cellData=(cell.getCellFormula());
			    
			    
			case Cell.CELL_TYPE_BLANK:
				cellData="No Value";
				break;
			
			}
		}//end of else
		//System.out.println(headers.get(cell.getColumnIndex()));	
		jsonstring += "\"" +headers.get(i) +"\" : " +"\"" +cellData + "\"" ;	
		
		if(i<maxcells-1)
		{
			jsonstring += jsonComma;	
		}
		
		
		}//end of for
		
		
		
		
		jsonstring+= jsonClosedCurly;
		
		if(rowIterator.hasNext())
		{
			jsonstring+= jsonComma;
		}
		jsonfinal+=jsonstring;
		jsonstring ="";
	}//End of row Iterator
	jsonfinal+=jsonClosedBrack;
	System.out.println(jsonfinal);
		try {
			response.setContentType("application/json");
			response.getWriter().write(jsonfinal);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println("WriteColumnHeader error: " + ex.getMessage());
		}
	} //end of writeColumndata
    //Method for reading the Headers
    private void writeColumnHeaders(Iterator<Row> rowIterator)
	{

		String cellData="";
		
		
		
		//Get Header Row
		Row row = rowIterator.next();
		if (row != null)
		{
			//Got Header, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) 
			{
				Cell cell = cellIterator.next();
				
				 
				switch (cell.getCellType()) 
				{
					case Cell.CELL_TYPE_NUMERIC:
	                    cellData = (Double.toString (cell.getNumericCellValue()));
						break;
					case Cell.CELL_TYPE_STRING:
						cellData = (cell.getStringCellValue());	
						break;
				}
				
				
				headers.add(cellData);
				
				
			}
			
			for(String obj:headers){
				System.out.println(obj);
			}
		}//end of if	
    	
	}//end of writeColumnHeaders

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
