package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi.sha256WithSM2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Nanda
 * @date 10-09-2022
 *@description Used to maintain all the reusable code
 */
public class BaseClass {

	public static WebDriver driver;
	/**
	 * @param browserType
	 * @description Used to get the which type of url need to pass
	 * 
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}
	/**
	 * description Used to wait the driver for some seconds
	 */
	public void impliciteWait() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	/**
	 * description Used for taking screenshot 
	 * @return byte[]
	 */
	public byte[] screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
	   byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
	return b;
	}
			/**
			 * @description Used to get property folder
			 * @param key
			 * @return value
			 * @throws IOException
			 */
	public String getPropertyFileValue(String key) throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties"));
	    String value = (String)properties.get(key);
		return value;
	} 
		
	/**
	 * description Used to get the Url
	 * @param url
	 */
	public void enterUrl(String url) {
		driver.get(url);
	}
	/**
	 * description Used to maximize the window
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	/**
	 * description Used to close the cuurrent window
	 */
	public void toCloseCurrentWindow() {
		driver.close();
	}
	/**
	 * description Used to quit all the browser
	 */
	public void toQuitTheBrowser() {
		driver.quit();
	}
	/**
	 * @description Used to navigate backward
	 */
	public void backWard() {
		driver.navigate().back();
	}
	/**
	 * @description Used to navigate backward
	 */
	public void forward() {
		driver.navigate().forward();
	}
	/**
	 * @description Used to refresh via navigate
	 */
	public void refresh() {
		driver.navigate().refresh();
	}
    /**
     * @description Used to enter details in the text box
     * @param element
     * @param data
     */

	public void elementsendKeys(WebElement element, String data) {
		element.sendKeys(data);
	}
	/**
	 * @description Used to enter details in the text box by using  JS
	 * @param element
	 * @param data
	 */
	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0],setAttribute('value',' "+data+" ')", element);
	}
	/**
	 * @description Used to get the title in browser
	 * @return title
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	/**
	 * @description Used to findElement by Id
	 * @param attributeValue
	 * @return findElement
	 */
	public WebElement getElementById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}
	/**
	 * @description Used to findElement by name
	 * @param attributeValue
	 * @return
	 */
	public WebElement getElementByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}
	/**
	 * @description Used to click the button
	 * @param e
	 */
	public void btnClick(WebElement e) {
		e.click();
	}
	/**
	 * @description Used to select the dropDown by visible text
	 */
	
	public void dropDown(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByVisibleText(data);
	}
	/**
	 * @description Used to select the dropDown by index
	 */
	public void dropDownIndex(WebElement element, int a) {
		Select s = new Select(element);
		s.selectByIndex(a);
    /**
     * @description Used to get text in webPage
     * @return text
     */
	}
	public String getText(WebElement element) {//////////
		String text = element.getText();
		return text;
	}
	/**
	 * @description Used to select drop down by value in the inspect page
	 * @param element
	 * @param text
	 */
	public void dropDownValue(WebElement element, String text) {
		Select s  = new Select(element);
		s.selectByValue(text);
		/**
		 * @description Used to switch control to parent frame
		 */
	}
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	/**
	 * @description Used to switch frame by frameId
	 * @param id
	 */
	public void switchToFrameById(int id) {
		driver.switchTo().frame(id);
	}
	/**
	 * @description Used to switch frame by frameName
	 * @param name
	 */
	public void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrameWeb(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * @description Used to get parent window id (getwindowHandle)
	 * @return windowHandle
	 */
	public String getParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	/**
	 * @description Used to get both parent and child window id for switching purpose (getWindowHandles) 
	 * @return
	 */
	public Set getChildWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	public void switchToParentWindow(String parentWindow) {
		driver.switchTo().window(parentWindow);
	}
	/**
	 * @description Used to move the control or switch to alert 
	 * 
	 */
	public void alertBox() {
		Alert al = driver.switchTo().alert(); 
		al.accept();

	}

	public String getValue(WebElement element ) {
		String value = element.getAttribute("value");
		return value;

	}
	public String getDataFromExcel(String sheet, int rowNum, int cellNum) throws IOException {
		String res ="";
		File file = new File("C:\\Users\\lenovo\\eclipse-workspace\\FrameWork\\Excel\\AdactinSheet.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);

		org.apache.poi.ss.usermodel.Sheet sheet2 = workbook.getSheet(sheet);

		Row row = sheet2.getRow(rowNum);
		Cell cell = row.getCell(cellNum);

		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
				res = format.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long Check = Math.round(numericCellValue);

				if (Check == numericCellValue) {
					res = String.valueOf(Check);
				}

			}
			break;

		default:
			break;
		}
		return res;




	}



}



