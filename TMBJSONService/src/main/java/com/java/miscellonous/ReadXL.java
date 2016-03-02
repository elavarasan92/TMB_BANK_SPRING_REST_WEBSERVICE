package com.java.miscellonous;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;





import com.tmb.model.BankDetails;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
	

	public class ReadXL {
		


		    private static final String FILE_PATH = "C:\\Users\\elavarasan.natarajan\\Desktop\\BankDetails.xlsx";

		    static List<BankDetails> bankDetailsList = new ArrayList<BankDetails>();
		    static BankDetails bankDetails;
		    static Session  session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
		    static Transaction t = session.beginTransaction();
		    
			 
		    public static void main(String args[]) {

		       // bankDetailsList = getbankDetailsListFromExcel();

		    	getbankDetailsListFromExcel();
		       // System.out.println(bankDetailsList);
		    }

		    private static List getbankDetailsListFromExcel() {
		        
		        FileInputStream fis = null;
		        
		        try {
		            fis = new FileInputStream(FILE_PATH);

		            // Using XSSF for xlsx format, for xls use HSSF
		            Workbook workbook = new XSSFWorkbook(fis);

		            int numberOfSheets = workbook.getNumberOfSheets();

		            //looping over each workbook sheet
		           
		                Sheet sheet = workbook.getSheetAt(0);
		                Iterator<Row> rowIterator = sheet.iterator();
		                
		                while (rowIterator.hasNext())
		                {
		                	
		                	bankDetails = new BankDetails();
		                   
		                	Row row = rowIterator.next();
		                	if(row.getRowNum()==0){
		                	       continue; //just skip the rows if row number is 0 
		                	      }
		                    //For each row, iterate through all the columns
		                    Iterator<Cell> cellIterator = row.cellIterator();
		                     
		                    while (cellIterator.hasNext())
		                    {
		                        Cell cell = cellIterator.next();
		                     
		                        //Check the cell type and format accordingly
		                        if(!(cell.getCellType()==Cell.CELL_TYPE_BLANK)&&(cell.getCellType()==Cell.CELL_TYPE_STRING)||cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		                        {
		                       
		                        	if(cell.getColumnIndex()==0)
		                        	{
		                        		//System.out.println(Integer.toString((int)cell.getNumericCellValue())+"##########################################");
		                        		//checkedNew = checked.split('.').join("");
		                        		bankDetails.setId(Integer.toString((int)cell.getNumericCellValue()));
		                        	}
		                        	else if(cell.getColumnIndex()==1)
		                        	{
		                        		bankDetails.setBankName(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==2)
		                        	{
		                        		bankDetails.setiFSCCode(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==3)
		                        	{
		                        		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		                        		{
		                        			bankDetails.setmICRCode(cell.getStringCellValue());
		                        			
		                        		}
		                        		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		                        		{
		                        			bankDetails.setmICRCode(Integer.toString((int)cell.getNumericCellValue()));
		                        		}
		                        		
		                        	}
		                        	else if(cell.getColumnIndex()==4)
		                        	{
		                        		bankDetails.setBranchName(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==5)
		                        	{
		                        		bankDetails.setBranchAddress(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==6)
		                        	{
		                        		
		                        		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		                        		{
		                        			bankDetails.setContactNumber(cell.getStringCellValue());
		                        			
		                        		}
		                        		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		                        		{
		                        			bankDetails.setContactNumber(Integer.toString((int)cell.getNumericCellValue()));
		                        		}
		                        		
		                        
		                        	}
		                        	else if(cell.getColumnIndex()==7)
		                        	{
		                        		bankDetails.setCity(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==8)
		                        	{
		                        		bankDetails.setDistrict(cell.getStringCellValue());
		                        	}
		                        	else if(cell.getColumnIndex()==9)
		                        	{
		                        		bankDetails.setState(cell.getStringCellValue());
		                        	}
		                        	
		                        	 	
		                    }
		                        }
		 
		            	
		            		session.save(bankDetails);
		            		
		            		
		            		System.out.println("Successfully saved");
		                    
		                   // bankDetailsList.add(bankDetails);
		                    
		          

		            fis.close();
		                }
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        finally
		        {
		        	t.commit();
		        	session.flush();
	        		session.close();
		        }
		        return bankDetailsList;
		       
		    }


		}




