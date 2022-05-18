package com.example.example;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		
		driver.get("https://jdvelasq.github.io/courses/redes_neuronales_y_algoritmos_bioinspirados/index.html#sesion-01-2022-mar-08");
		
		List<WebElement> elements = driver.findElements(By.cssSelector("[href*=\"notebooks\"]"));
		
		List<String> urls = new LinkedList<String>();
		
		for( WebElement element: elements) {
			urls.add(element.getAttribute("href"));
		}
		
		for(String url: urls) {
			
			driver.get(url);
			
			String[] words = {"make_column_selector","make_column_transformer","SelectKBest","f_regression",
					"LinearRegression","GridSearchCV", "Pipeline", "OneHotEncoder"};
					
			List<String> foundWords = new LinkedList<String>();
			
			for(String word: words) {
				String locator = "//*[contains(text(),'"+word+"')]";
				
				List<WebElement> found = driver.findElements(By.xpath(locator));
				
				if(found.size()>0) {
					foundWords.add(word);
				}
			}
			
			if(foundWords.size()>0) {
				System.out.print(url);
				for(String word: foundWords) {
					System.out.print(" "+word);
				}
				System.out.println("");
				System.out.println("");
				
			}
			
		}
		
	}

}
