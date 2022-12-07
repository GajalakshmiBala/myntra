package com.miniproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTask {

	public static WebDriver driver;

	private static void browserLaunch() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");

		driver.manage().window().maximize();

	}

	private static void getSize() {

		List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='product-base']"));

		System.out.println("Count of all Products : " + allProducts.size());

	}

	private static void getMinPrice() {

		List<WebElement> allPrice = driver.findElements(
				By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']"));

		ArrayList<Integer> l = new ArrayList<>();

		for (int i = 0; i < allPrice.size(); i++) {

			String priceValue = allPrice.get(i).getText().replaceAll("Rs. ", "");

			int priceNumber = Integer.parseInt(priceValue);

			l.add(priceNumber);

		}
		
		Integer minValue = Collections.min(l);
		
		System.out.println("Minimum price out f all products : " +minValue);

	}

	public static void main(String[] args) {

		browserLaunch();

		getSize();
		
		getMinPrice();

	}

}
