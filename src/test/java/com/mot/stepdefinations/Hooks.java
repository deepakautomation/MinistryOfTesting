package com.mot.stepdefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.mot.enums.Browsers;
import com.mot.helper.LoggerHelper;
import com.mot.testbase.TestBase;
import com.mot.utils.GlobalProperties;
import com.mot.utils.PropertiesFileReader;

import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {

	TestBase testBase;

	Logger log = LoggerHelper.getLogger(Hooks.class);
	public GlobalProperties globalProperties = null;
	public PropertiesFileReader propertiesReader = null;
	
	public Hooks(){
		globalProperties = new GlobalProperties();
		setAllPropertiesInGlobalHashMap();
	}

	
	private void setAllPropertiesInGlobalHashMap() {
		 if (propertiesReader == null) {
	            propertiesReader = new PropertiesFileReader();
	        }
		propertiesReader.loadHashMapWithConfigFile(GlobalProperties.getPropertyMap());
		 propertiesReader.reloadMapWithSystemProperties(GlobalProperties.getPropertyMap());
	  
	}

	@Before
	public void initializeTest() throws IOException {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());
		
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				//scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				//scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		TestBase.driver.quit();
	}
}
