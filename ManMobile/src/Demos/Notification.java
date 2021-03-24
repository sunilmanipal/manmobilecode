package Demos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Notification {

	public static void main(String[] args) throws IOException {
		DesiredCapabilities capability= new DesiredCapabilities();
		capability.setCapability(MobileCapabilityType.DEVICE_NAME, "sunil");
		capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "D:\\chromedriver_win32\\chromedriver 89\\chromedriver_win32 (4)\\chromedriver.exe");
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capability);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File file= new File("C:\\Users\\Administrator\\Desktop\\NewData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rc= sheet.getLastRowNum();
		System.out.println("total number of rows having data= "+rc);
		for(int i=0;i<=rc;i++) {
			String username=sheet.getRow(i).getCell(0).getStringCellValue();
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			driver.get("http://demowebshop.tricentis.com/login");		
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
				
		}
		

	}

}