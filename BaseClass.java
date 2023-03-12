package Generic.genericLib;

import java.io.IOException;
import java.time.Duration;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import POMelement.Repository.LoginPage;

@Listeners(Generic.genericLib.ListenersImplementataion.class)
public class BaseClass {
  public WebDriver driver;
  public CommounUtility cu=new CommounUtility();
  public DataUtility du=new DataUtility();
  public static WebDriver ListenerDriver;
  
  
  @BeforeClass(alwaysRun=true)
  public void launchBrowser()
  {
	    System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		ListenerDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @BeforeMethod(alwaysRun=true)
  public void login() throws IOException
  {
	    driver.get(du.getDataFforPropertiesFile("url"));
	    LoginPage lp=new LoginPage(driver);
	    lp.loginApp(du.getDataFforPropertiesFile("username"),du.getDataFforPropertiesFile("password"));
  }
  
  @AfterMethod(alwaysRun=true)
  public void logout()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.logoutApp();
	  		
  }
  
  @AfterClass(alwaysRun=true)
  public void closeBrowser()
  {
	  driver.close();
  }
}






















