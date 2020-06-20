package com.charbelboumaroun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class SeleniumWS {

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Intel\\Desktop\\JARLibrary\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-GB");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
	
	public static void ActivatedDriver(int frequency,int totaltime) throws Exception{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-GB");
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.google.com/maps/dir/Lebanese+American+University,+Byblos+Campus,+Blat/Unnamed+Road,+Lebanon/@34.0109297,35.5110871,11z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x151f5b485f22ba8b:0xb777d642de56b49a!2m2!1d35.6744347!2d34.1155614!1m5!1m1!1s0x151f3d8f30d84d03:0x756dd88b0aaba76a!2m2!1d35.5717656!2d33.8795959!3e0";
		driver.get(url);
		String strXPath = "//*[@id=\"section-directions-trip-0\"]/div[2]/div[1]/div[1]/div[1]/span[1]";
	
		for(int i=0;i<(totaltime/frequency);i++) {
			
		String minutes = driver.findElement(By.xpath(strXPath)).getText();
		if(minutes.length() == 0) {
			continue;
		}
		ExcelManager.AddToExcel(Time.getTimeInHours(), Time.getDate(), Time.HMtoMforGoogleMaps(minutes));
		System.out.println(i+"- :");
		System.out.println(Time.HMtoMforGoogleMaps(minutes));
		TimeUnit.SECONDS.sleep(Time.randomizer(frequency*60));
		driver.navigate().refresh();
			}
		driver.close();
	    }
	
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Intel\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-GB");
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.google.com/maps/dir/Lebanese+American+University,+Byblos+Campus,+Blat/Unnamed+Road,+Lebanon/@34.0109297,35.5110871,11z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x151f5b485f22ba8b:0xb777d642de56b49a!2m2!1d35.6744347!2d34.1155614!1m5!1m1!1s0x151f3d8f30d84d03:0x756dd88b0aaba76a!2m2!1d35.5717656!2d33.8795959!3e0";
		driver.get(url);
		String strXPath = "//*[@id=\"section-directions-trip-0\"]/div[2]/div[1]/div[1]/div[1]/span[1]";
		for(int i=0;i<10;i++) {
		String s = driver.findElement(By.xpath(strXPath)).getText();
		System.out.println(s);
		TimeUnit.SECONDS.sleep(60);
		driver.navigate().refresh();}
		driver.close();
	}

}