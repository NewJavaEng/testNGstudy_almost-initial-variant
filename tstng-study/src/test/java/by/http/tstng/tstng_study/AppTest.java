package by.http.tstng.tstng_study;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class AppTest {

	private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	private static final String DRIVER_PATH = "C:\\driver\\geckodriver.exe";

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		System.setProperty(DRIVER_FIREFOX, DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	// @Test
	// public void test1() {
	// System.out.println("test1");
	// driver.get("https://www.tut.by");
	// String title = driver.getTitle();
	// assertEquals(title, "Белорусский портал TUT.BY. Новости Беларуси и мира");
	//
	// }

	@Test(enabled=false)
	public void test2() throws InterruptedException {
		System.out.println("test2");
		driver.get("http://www.google.com");
		WebElement elementSearchForm = driver.findElement(By.id("lst-ib"));
		elementSearchForm.sendKeys("Java");
		WebElement elementButton = driver.findElement(By.name("btnK"));
		elementButton.click();
		
		Thread.sleep(10000);
		String title = driver.getTitle();
		assertEquals(title, "Java - Поиск в Google");

	}
	
	@Test
	public void test3() {
		driver.get("https://www.tut.by");
		WebElement newsTitle = driver.findElement(By.cssSelector(".header"));
		System.out.println("nTitle" + newsTitle);
		
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
		driver.close();
		driver = null;
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}

}
