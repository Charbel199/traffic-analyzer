package com.charbelboumaroun;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Time {

	public static int HMtoS (String s) {
		int i=0;
		int indexOfColumn = s.indexOf(':');
		i+= Integer.parseInt(s.substring(0,indexOfColumn))* 3600;
		i+= Integer.parseInt(s.substring(indexOfColumn+1))* 60;
		return i;
	}
	
	public static int HMtoMforGoogleMaps (String s) {
		
		if(s.indexOf('h')!=-1) {
			int i=0;
			i+= Integer.parseInt(s.substring(0,s.indexOf('h')).replaceAll("\\s", "")) * 60;
			if(s.indexOf('m')!=-1) {
			i+= Integer.parseInt(s.substring(s.indexOf('h')+1, s.indexOf('m')).replaceAll("\\s", ""));
			}
			
			return i;
		}
		if(s.length() == 0) {
			
			return -1;
		}
		return Integer.parseInt(s.substring(0,s.indexOf('m')).replaceAll("\\s", ""));
	}
	
	public static String StoHM (int i) {
		String s="";
		int hour = i/3600;
		int minute = (i-hour*3600)/60;
		s = hour + ":" + minute;
		return s;
	}
	
	
	public static String getTime() {
		 LocalDateTime current = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	     String formatted = current.format(formatter);
	     return formatted;
	}
	public static double getTimeInHours() {
		String s = getTime();
	
		double i=0;
		i+=Integer.parseInt(s.substring(0,s.indexOf(':')));
		i+=(Double.parseDouble(s.substring(s.indexOf(':')+1).replaceAll("\\s", "")) /60);
		return i/24;
	}
	public static String getDate() {
		 LocalDateTime current = LocalDateTime.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
	     String formatted = current.format(formatter);
	     return formatted;
	}
	
	public static int randomizer(int time) {
		Random rnd = new Random();
		double percentage = ((rnd.nextDouble())/2)+1;
		//System.out.println("Random percentage: " + percentage);
		return (int)(time*percentage);
		
	}
		  public static void main (String[] args) {  
			 System.out.println( randomizer(60));
		  }
		
	}


