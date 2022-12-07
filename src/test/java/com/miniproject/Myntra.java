package com.miniproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		WebElement kids = driver.findElement(By.xpath("//div[@data-reactid='333']"));
		Actions a = new Actions(driver);
		a.moveToElement(kids).build().perform();
		WebElement tshirt = driver.findElement(By.xpath("//a[@data-reactid='345']"));
		tshirt.click();
		ArrayList<Integer> al = new ArrayList<>();
		List<WebElement> total = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']"));
		
		int length = total.size();
		System.out.println("Total prducts present are :" +length);
		WebElement price = driver.findElement(By.xpath("//span[@class='product-strike']"));
		for (int i = 0; i < args.length; i++) {
			WebElement price1 = driver.findElement(By.xpath("//span[@class='product-strike']"));
			String discount = price1.getText();
			String replace = discount.replace("Rs.","");
			String leastprice = replace.replaceAll(",","");
			int parseInt = Integer.parseInt(leastprice);
			al.add(parseInt);
		int min = Collections.min(al);
		if (parseInt==min) {
			price1.click();
			break;
		}
		System.out.println("least price : "+Collections.min(al));
		}
	}
	
}
