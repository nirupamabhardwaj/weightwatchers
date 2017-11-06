package com.weightwatchers.test;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String basePath = new File("").getAbsolutePath();
		driver.get("file://"+basePath+"//FoodItem.html");
		String thirdElement = driver.findElements(By.className("title")).get(2).getText();
		String fifthElement = driver.findElements(By.className("title")).get(4).getText();
		System.out.println("Third Element from the list:"+thirdElement);
		System.out.println("Fifth Element from the list:"+fifthElement);
		
		List<WebElement> title = driver.findElements(By.className("title"));
		List<WebElement> description = driver.findElements(By.className("description"));
        Map <String,String> food = new LinkedHashMap<String,String>();
		for(int i= 0; i< title.size(); i++)
			food.put(title.get(i).getText(), description.get(i).getText());
		Iterator<String> it = food.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key);
			System.out.println(food.get(key));
			
		}

	}

}