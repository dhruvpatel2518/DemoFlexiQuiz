package com.flexiquiz.qa.extentreportlistener;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	
	private static ExtentSparkReporter sparkReporter;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	
	public ExtentReportListener() {
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\testReport.html");
	}
	
	public static void testOutputReport() throws IOException {
		extent.attachReporter(sparkReporter);
		
		/*sparkReporter.config(
				ExtentSparkReporterConfig.builder()
				.theme(Theme.DARK)
				.documentTitle("MyReport")
				.offlineMode(true)
				.build()
				);*/
		
		/*final File conf = new File("config/spark-config.xml or .json");
		ExtentSparkReporter spark = new ExtentSparkReporter("target/spark/spark.html");
		spark.loadXMLConfig(conf);
		spark.loadJSONConfig(conf);*/
		
		sparkReporter.config().setOfflineMode(true);
		sparkReporter.config().setDocumentTitle("Simple Automation Report");
		sparkReporter.config().setReportName("Test Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		sparkReporter.config().setEncoding("UTF-8");
		
		
	}
}
