package com.qa.automationpractice.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	/**
	 * This method is used to initialize the WebDriver
	 * 
	 * @param prop
	 * @return driver
	 */
	public WebDriver initialise_driver(Properties prop) {

		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(); //Null Pointer exception if object is missing.
			
		}
		else if(browserName.equals("mozilla")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();//Null Pointer exception if object is missing.
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		return driver;

	}
	
	/**
	 * This method is used to initialize the properties and it will return
	 * properties reference
	 * 
	 * @return prop
	 */
	public Properties initialize_Properties() {
		
		prop=new Properties(); 	//Null Pointer exception if object is missing.
		
		try {
			FileInputStream fp=new FileInputStream("F:\\Selenium_Workspace\\May2019_PracticePOMSeries\\src\\main\\java\\"
					+ "com\\qa\\automationpractice\\configuration\\config.properties");
			
			try {
				prop.load(fp);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Cannot load properties file, please check the path in Base Page");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in given path");
			e.printStackTrace();
		
		}
		
		return prop;
	}
	
	/**
	 * 
	 * This method is used to connect Database
	 * 
	 * @param host
	 * @param port
	 */
	
	public void JDBC_Connection(String host,String port) {
		
		// Will be implemented soon.
		// host and port of MySQL server will be defined in config.properties to avoid hard code.
		// and finally this method will be mentioned in Before Method where ever data required from MySQL Database.
	}
	
	
	
}
