package com.ds.hackerearth;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
	public static void main(String[] args) {
		//check2();
		//check3();
		String s = "abcdef";
		System.out.println(s.substring(0,s.length()-2));
	}

	public static void check1() {
		Pattern p = Pattern.compile(
				"[[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][[0-9a-f]{1,4}[:]][0-9a-f]");
		Matcher m = p.matcher("1050:1000:1000:a000:5:600:300c:326b");
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
		}
	}

	public static void check2() {

		String link = "<div class=\"more-info\"><a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>";
		String link2= "<a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a>";
		Pattern p = Pattern.compile("[<]");
		Matcher m = p.matcher(link);
		Matcher m2 = p.matcher(link2);
		m = m2;
		
		
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
			System.out.println();
		}

	}

	public static void check3() {
		String link = "familireze familerise";
		Pattern p1 = Pattern.compile("se\\b");
		Pattern p2 = Pattern.compile("ze\\b");
		
		
		Matcher m1 = p1.matcher(link);
		Matcher m2 = p2.matcher(link);
			while (m1.find() && m2.find()) {
				
				System.out.println(m1.start()+" "+m1.end()+" "+m1.group());
				System.out.println(m2.start()+" "+m2.end()+" "+m2.group());
				
		}
//			while (m2.find()) {
//				System.out.println(m2.start()+" "+m2.end()+" "+m2.group());
//		}
			
	}
	public static void check4() {
		
		String link = "<li id=\"n-sitesupport\"><a href=\"//donate.wikimedia.org/wiki/Special:FundraiserRedirector?utm_source=donate&utm_medium=sidebar&utm_campaign=C13_en.wikipedia.org&uselang=en\" title=\"Support us\">Donate to Wikipedia</a></li>";
		Pattern p = Pattern.compile("href");
		Matcher m = p.matcher(link);
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
			System.out.println();
		}
		
	}
	
	public static void check5()	{
		
		String link = "<div class=\"more-info\"><a href=\"http://www.quackit.com/html/examples/html_links_examples.cfm\">More Link Examples...</a></div>";
		Pattern p = Pattern.compile("<[\\s^/]*[\\w.]*[[\\s]*");//<[\\s]*[\\w=//.:]*[\\s]*");
		
		Matcher m = p.matcher(link);
		while (m.find()) {
			System.out.println(m.start() + " " + m.end() + " " + m.group());
			System.out.println();
		}
		
	}
	
}
