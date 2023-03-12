package Generic.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementataion implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		String tsname=result.getName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.ListenerDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./FailedTestCase/"+tsname+".png");
		try {
			 FileUtils.copyFile(src, trg);
		}
		catch(IOException e) {
			
		}
	}
}
