package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.BaseTest;

public class ExtentManager extends BaseTest {

	public static ExtentReports getreports() {

		// to create a reports folder
		String ReportFolderPath = System.getProperty("user.dir") + "\\reports";

		if (reports == null) {

			reports = new ExtentReports();
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat dateformate = new SimpleDateFormat(pattern);
			String date = dateformate.format(new Date());
			// System.out.println(date); // ans 2025-11-26 19:15:43
			date = date.replace(":", "-");
			System.out.println(date); // ans 2025-11-26 19-17-04

			// to save the reports in the report folder with date name

			File reportsfile = new File(ReportFolderPath +"\\"+ date+".html");

			// spark reporter will give the CSS for creating the reports in html
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportsfile);
			sparkreporter.config().setDocumentTitle("NOVO Automation Report");
			sparkreporter.config().setReportName("NOVO Reports");
			// to attach the spark report to extent report object
			reports.attachReporter(sparkreporter);
		}

		return reports;

	}

}
