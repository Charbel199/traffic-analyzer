package com.charbelboumaroun;

import java.util.Scanner;



public class Driver {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many minutes between each measurement ?");
		int frequency = scan.nextInt();
		System.out.println("For how many minutes do you want the program to run ?");
		int totaltime = scan.nextInt();
		scan.close();
		
		//WebDriver web = SeleniumWS.getDriver();
		
		try {
			SeleniumWS.ActivatedDriver(frequency,totaltime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done");

	}

}

