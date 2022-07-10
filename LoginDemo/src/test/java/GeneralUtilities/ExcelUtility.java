package GeneralUtilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelUtility
{
	public static ArrayList<String> getData(String sectionName,String sheetName) throws Exception
	{
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis = null;
		XSSFWorkbook workbook= null;
		try
		{
			fis = new FileInputStream("./src//test//java//TestData//TestInputs.xlsx");
			workbook=new XSSFWorkbook(fis);
			
			int sheets=workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
				{
					XSSFSheet sheet=workbook.getSheetAt(i);
					//Identify Testcases coloum by scanning the entire 1st row
					
					Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
					Row firstrow= rows.next();
					Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
					int k=0;
					int coloumn = 0;
					while(ce.hasNext())
					{
						Cell value=ce.next();
						
						if(value.getStringCellValue().equalsIgnoreCase("Section"))
						{
							coloumn=k;
							
						}
						
						k++;
					}
					System.out.println(coloumn);
			
					////once coloumn is identified then scan entire testcase column to identify testcase row
					while(rows.hasNext())
					{
						Row r=rows.next();
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(sectionName))
						{
							
							////after you grab purchase testcase row = pull all the data of that row and feed into test
							Iterator<Cell>  cv=r.cellIterator();
							while(cv.hasNext())
							{
								Cell c=	cv.next();
								if(c.getCellType()==CellType.STRING)
								{
								a.add(c.getStringCellValue());
								}
								else
								{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
						}
					}		
				}
			}
			return a;
		}
		catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		finally
		{
			workbook.close();
			fis.close();
		}
	}
}
