package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class UtilKitSetUP extends BaseTest {

	public static List<HashMap<String, String>> getTestDataFromExcel(String sheetname) {

		List<HashMap<String, String>> alltestdata = new ArrayList<>();

		try (FileInputStream fis1 = new FileInputStream
				("C:\\Users\\dlakkamraju\\eclipse-workspace\\Novo_Hybrid_FrameWork\\src\\test\\resources\\Excels\\NOVO_testcases_masterexcel.xlsx"); 
				XSSFWorkbook wb = new XSSFWorkbook(fis1)) {

			XSSFSheet ws = wb.getSheet(sheetname);

			Row headerrow = null;
			headerrow = ws.getRow(0);

			for (int i = 1; i <= ws.getLastRowNum(); i++) {
				Row currentrow = ws.getRow(i);
				if (currentrow == null) {
					continue;
				}
				DataFormatter format = new DataFormatter();
				HashMap<String, String> data = new HashMap<String, String>();

				for (int j = 0; j <= headerrow.getLastCellNum(); j++) {
					String key = format.formatCellValue(headerrow.getCell(j));
					String value = format.formatCellValue(currentrow.getCell(j));

					if (key != null && !key.isEmpty()) {

						data.put(key, value);
					}
				}
				alltestdata.add(data);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return alltestdata;
				
	}
	
	public static String getScreenShot() {
		
		
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sfd=new SimpleDateFormat(pattern);
		String d=sfd.format(new Date());
		String date=d.replace(":", "-");
		
		String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshots\\"+date+".png";
		
		File screenshitfile=new File(screenshotfilepath);
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, screenshitfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotfilepath;
		
	}
}
