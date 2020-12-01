import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractAllCompanyDetailsFromGovtTechDummy 
{

	public static void main(String[] args) 
	{
		try
		{
			int rowNumber = 1;
	        String fileName = "";
	        File file;
	        FileOutputStream fileOutputStream = null;
	        ClassLoader classLoader =null;
	        XSSFSheet sheet ;
	        XSSFWorkbook workBook ; 
			List<Govt> govtList=new ArrayList<Govt>();
			Document doc = Jsoup.connect("https://www.govtech.com/100/2019/").followRedirects(true).timeout(0).get();
			if(doc!=null)
			{
				Elements table = doc.select("tbody");
				if(!table.isEmpty())
				{
					for(Element tr : table.select("tr"))
					{
						try {
							Elements tds=tr.select("td");
							if(!tds.isEmpty())
							{
								Govt govt=new Govt();
								String name=tds.get(0).text();
								String founded=tds.get(1).text();
								govt.setName(name);
								govt.setFounded(founded);
								govtList.add(govt);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					//System.out.println(govtList.size());
					if(!govtList.isEmpty())
					{

		                workBook = new XSSFWorkbook();
		                sheet = workBook.createSheet("EfaxLog");
		                org.apache.poi.ss.usermodel.Row row = null;
		                Cell cell = null;
		                row = sheet.createRow(0);                        

		 

		                cell = row.createCell(0);
		                cell.setCellValue("Name");

		 

		                cell = row.createCell(1);
		                cell.setCellValue("Founded");

		 

						/*
						 * cell = row.createCell(2); cell.setCellValue("PCP Name");
						 * 
						 * 
						 * 
						 * cell = row.createCell(3); cell.setCellValue("Visit ID");
						 * 
						 * 
						 * 
						 * cell = row.createCell(4); cell.setCellValue("Service Date");
						 * 
						 * 
						 * 
						 * cell = row.createCell(5); cell.setCellValue("Fax Number");
						 * 
						 * 
						 * 
						 * cell = row.createCell(6); cell.setCellValue("Patient Record URL");
						 * 
						 * 
						 * 
						 * cell = row.createCell(7); cell.setCellValue("Document URL");
						 * 
						 * 
						 * 
						 * cell = row.createCell(8); cell.setCellValue("Scenario Type");
						 */

		 

		                for(Govt faxBo:govtList)
		                {
		                    try
		                    {
		                        row = sheet.createRow(rowNumber);
		                        cell = row.createCell(0);
		                        cell.setCellValue(faxBo.getName());
		                        cell = row.createCell(1);
		                        cell.setCellValue(faxBo.getFounded());
								/*
								 * cell = row.createCell(2); cell.setCellValue(faxBo.getPhysician()); cell =
								 * row.createCell(3); cell.setCellValue(faxBo.getVisitId()); cell =
								 * row.createCell(4); cell.setCellValue(faxBo.getServiceDate()); cell =
								 * row.createCell(5); cell.setCellValue(faxBo.getFaxNumber()); cell =
								 * row.createCell(6); cell.setCellValue(faxBo.getPatientRecordsUrl()); cell =
								 * row.createCell(7); cell.setCellValue(faxBo.getDocumentUrl()); cell =
								 * row.createCell(8); cell.setCellValue(faxBo.getScenarioType());
								 */
		                    }
		                    catch(Exception e)
		                    {
		                       e.printStackTrace();
		                    }
		                    rowNumber = rowNumber+1;
		                }
		                FileOutputStream out = new FileOutputStream(new File("opp.xlsx")); 
		                workBook.write(out); 
						out.close(); 
						System.out.println("opp written successfully on disk.");               
		            
					}
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	
	
	
	
	
	
}
