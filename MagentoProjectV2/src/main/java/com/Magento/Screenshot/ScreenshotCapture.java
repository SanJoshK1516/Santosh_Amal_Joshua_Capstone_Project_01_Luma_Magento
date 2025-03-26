package com.Magento.Screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Magento.Browser.ProjectBrowser;

public class ScreenshotCapture extends ProjectBrowser {
	
//	Method to capture a Screenshot
	public static String takeScreenShot(String name) throws Exception {
		String path = null;
		try {
			TakesScreenshot shot = ((TakesScreenshot) driver);
			File source = shot.getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + "\\target\\Screenshot\\" + name + ".png";
			File destination = new File(path);
//			FileUtils.copyFile(source, destination);
			source.renameTo(destination);

			System.out.println("Screenshot taken");

		} catch (Exception e) {
			System.out.println("Screenshot Exception: " + e);
		}
		return path;
	}

}
