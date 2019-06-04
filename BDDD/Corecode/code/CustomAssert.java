package code;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

public class CustomAssert {
	
	boolean allChecks;
	boolean allStepsSkip;
	 String errorMessage;
	 WebDriver driver;
	 boolean warning;
	int counter=0;
	public  HashMap<Integer,String> scenarioAssertpool=new HashMap<Integer,String>();
	 
	
	public CustomAssert(WebDriver driver) {
		allChecks = true;
		allStepsSkip=true;
		warning = false;
		this.errorMessage = "";
		this.driver=driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public boolean allStepsSkip() {
		return allStepsSkip;
	}

	public void setallStepsSkip(boolean allStepsSkip) {
		this.allStepsSkip = allStepsSkip;
	}
	public boolean isAllChecks() {
		return allChecks;
	}

	public void setAllChecks(boolean allChecks) {
		this.allChecks = allChecks;
	}
	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	public void assertEquals (String expected, String actual, AssertionType assertType) {
		allStepsSkip=allStepsSkip && false;
		setallStepsSkip(allStepsSkip);
		try { 
			counter++;
			if (actual == null) actual = "DEFAULTED TO NULL OBJECT";
			if (expected == null) expected = "DEFAULTED TO NULL OBJECT";
			assertEquals(actual, expected, assertType);
			//FrameworkServices.logMessage("<B>"+counter+".  Actual= "+actual+";  Expected= "+expected+" ; PASSED </B>");
			String PassertString="<B>"+counter+"::{ "+actual+" ; "+expected+" }-->> PASSED </B>";
			scenarioAssertpool.put(counter,PassertString);

		}
		catch(AssertionError error) {
			allChecks = allChecks && false;
			setallStepsSkip(allStepsSkip);
			this.errorMessage="Excel value - "+ error.getMessage()+" - "+"at Application";
			switch (assertType) {
			case ERROR:
				//captureScreenShotOnAssertionException(AutomationDriverScript.scenarioExecutionFolderReference, errorMessage);
				break;
			case WARNING:
				warning = true;
				// Added by PKP on 13-10-2015 : Yellow indicates Warning
				//FrameworkServices.logMessage("<B><Font Color = \"yellow\">"+counter+".  Actual= "+actual+";  Expected= "+expected+" ; FAILED </Font></B>");
				String FassertString="<B><Font Color = \"yellow\">"+counter+"::{ "+actual+" ; "+expected+" }-->> FAILED </B>";
				//captureScreenShotOnAssertionException(AutomationDriverScript.scenarioExecutionFolderReference, errorMessage);
				scenarioAssertpool.put(counter,FassertString);

				break;
			}
		}

	}

}
