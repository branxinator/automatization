package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() 
	{
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Resultado de la automatizacion");
		reporter.config().setDocumentTitle("Resultado de las pruebas");
		reporter.config().setTheme(Theme.DARK);
	
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Daniele Branchina Nunez");
		return extent;
	}
}