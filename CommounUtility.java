package Generic.genericLib;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.chrome.ChromeDriver;

public class CommounUtility {
	
	 //WebDriver driver=new ChromeDriver();
	 
  //RandomNum---------->S
  public int getRandom(int value)
  {
	  Random r= new Random();
	  int num=r.nextInt(value);
	  return num;
  }
  
  //AlertMsg Fetch-------->
  public String getAlertMsgFetch(WebDriver driver)
  {
	 // WebDriver driver=new ChromeDriver();
	  Alert alt = driver.switchTo().alert();
	  String msg=alt.getText();
	  return msg;
  }
  
  //AlertMsg ok------>
  public void getAlertMsgOK(WebDriver driver)
  {
	  //WebDriver driver=new ChromeDriver();
	  Alert alt = driver.switchTo().alert();
	  alt.accept();
  }
  
  //Alertmsg Cancel-------->
  public void getAlertMsgCancel(WebDriver driver)
  {
	  //WebDriver driver=new ChromeDriver();
	  Alert alt = driver.switchTo().alert();
	  alt.dismiss(); 
  }
  
  public void getSelectByVisibleText(WebElement dropdown, String visibleText)
  {
	  Select s=new Select(dropdown);
	  s.selectByVisibleText(visibleText);
  }
}
