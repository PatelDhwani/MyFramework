package code;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*import com.aqm.framework.constant.WaitType;
import com.aqm.framework.core.FrameworkServices;
import com.aqm.framework.core.WebPage;
import com.aqm.framework.exceptions.ScriptExecutionException;
import com.aqm.framework.helper.PageElement;*/

public class BasePage extends WebPage {

	private PageElement cwissCoreInsuranceTitle;
	private PageElement myPreferencePage;
	private PageElement productPage;
	private PageElement securityPage;
	private PageElement partyPage;
	private PageElement policyPage;
	private PageElement claimPage;
	private PageElement accountingPage;
	private PageElement auditPage;
	private PageElement reInsurancePage;
	private PageElement batchPage;
	private PageElement documentPage;
	private PageElement reportsPage;
	private PageElement logoutPage;
	private PageElement accountingPagetitle;
	private PageElement accountingPageProceedButton;
	private PageElement HomePage;
	// Reinsurance 
	private PageElement ReinsuranceSystemAdministrator;
	
	public BasePage(WebDriver driver, String pageName) {
		super(driver, pageName);

		cwissCoreInsuranceTitle = new PageElement(By.xpath("//td//font/b[contains(text(),'CWISS - CORE INSURANCE')]"), " CWISS - CORE INSURANCE Page Title", false, WaitType.WAITFORELEMENTTOBEDISPLAYED, 10);
		myPreferencePage = new PageElement(By.linkText("My Preference"), "My Preference Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		productPage = new PageElement(By.linkText("Product"), "Product Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		securityPage = new PageElement(By.linkText("Security"), "Security Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		partyPage = new PageElement(By.linkText("Party"), "Party Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		policyPage = new PageElement(By.linkText("Policy"), "Policy Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		claimPage=new PageElement(By.linkText("Claim"), "Claim Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		accountingPage=new PageElement(By.linkText("Accounting"), "Account Page", false, WaitType.WAITFORELEMENTTOBECLICKABLE, 10);
		auditPage=new PageElement(By.linkText("Audit"), "Audit Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		reInsurancePage=new PageElement(By.linkText("Reinsurance"), "Reinsurance Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		batchPage=new PageElement(By.linkText("Batch"), "Batch Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		documentPage=new PageElement(By.linkText("Document"), "Document Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		reportsPage=new PageElement(By.linkText("Reports"), "Reports Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10); 
		logoutPage=new PageElement(By.xpath("//a//b[contains(text(),'Logout')]"), "Logout Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
		accountingPagetitle=new PageElement(By.xpath("//div//b[contains(text(),'Company Selection')]"), "Accounting Page Title", false, WaitType.WAITFORELEMENTTOBEDISPLAYED, 10);
		accountingPageProceedButton=new PageElement(By.name("Proceed"), "Proceed button in Accounting page", false, WaitType.WAITFORELEMENTTOBECLICKABLE, 10);
		HomePage=new PageElement(By.xpath("//*[@id=\"page_main_header\"]/nav/ul/li[3]/a"), "Logout Page", false, WaitType.WAITFORELEMENTTOBEEENABLED, 10);
	//reinsurance 
		
		
		ReinsuranceSystemAdministrator = new PageElement(By.xpath("//td[@id='pSysAdmin']"), "System Administration", false, WaitType.WAITFORELEMENTTOBECLICKABLE, 10);

	}
	public BasePage(){
		super();
	}
	public void navigateToMyPreferencePage()
	{
		click(myPreferencePage);
	}

	public void navigateToProductPage()
	{
		click(productPage);
	}

	public void navigateToSecurityPage()
	{
		click(securityPage);
	}

	public void navigateToPartyPage(){
		switchToFrame("head");
		click(partyPage);
	}

	public void navigateToPolicyPage() 
	{
		switchToFrame("head");
		click(policyPage);
	}

	public void navigateToClaimPage()
	{
		switchToFrame("head");
		click(claimPage);
	}

	public void navigateToAccountingPage()
	{
		switchToFrame("head");
		click(accountingPage);
	}
	public void navigateToAuditPage()
	{
		click(auditPage);
	}

	public void navigateToReinsurancePage()
	{
		click(reInsurancePage);
	}

	public void navigateToBatchPage()
	{
		click(batchPage);
	}

	public void navigateToDocumentPage()
	{
		click(documentPage);
	}

	public void navigateToReportsPage()
	{
		click(reportsPage);
	}

	public void logout(WebDriver driver){
		switchToFrame("head");
		click(logoutPage);
	}
	//reinsuranceSystemAdministrator
	
	public void navigateToSystemAdministrator() {
		switchToFrame("head");
		click(ReinsuranceSystemAdministrator);
	}
	
	public void navigateToHomePage() {
		switchToFrame("head");
		click(HomePage);
	}
	
	protected String fetchValueFromTextFields(PageElement pageElement) {
		String atributeValue = new String();
		try {
			WebElement webElement;
			if (pageElement.getWebElement() == null)
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			highlightTheElement(webElement);
			atributeValue = webElement.getAttribute("value").trim();

			//FrameworkServices.logMessage("Fetched text: " + atributeValue + " of " + pageElement.getName());
			//Uploader.logMessage("Fetched " + attributeName + ":" + atributeValue + " of " + pageElement.getName(), logger);
		} catch (Exception exception) {
			//throw new ScriptExecutionException("Failed to fetch text: '" + "' of " + pageElement.getName(), exception);
		} finally {
			pageElement = null;
		}
		return atributeValue;
	}
	
	protected String fetchValueFromFields(PageElement pageElement) {
		String text = new String();
		try {
			WebElement webElement;
			if (pageElement.getWebElement() == null)
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			highlightTheElement(webElement);
			text = webElement.getText().trim();

			//FrameworkServices.logMessage("Fetched text: "+ text + " of " + pageElement.getName());
			//Uploader.logMessage("Fetched " + attributeName + ":" + atributeValue + " of " + pageElement.getName(), logger);
		} catch (Exception exception) {
			//throw new ScriptExecutionException("Failed to fetch text: '" + "' of " + pageElement.getName(), exception);
		} finally {
			pageElement = null;
		}
		return text;
	}
	
	protected String fetchValueFromList(PageElement pageElement) {
		String text = new String();
		try {
			WebElement webElement;
			if (pageElement.getWebElement() == null)
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			
			Select selectType = new Select(webElement);
			text = selectType.getFirstSelectedOption().getText();
			highlightTheElement(webElement);

			//FrameworkServices.logMessage("Fetched text: " + text + " of " + pageElement.getName());
			//Uploader.logMessage("Fetched " + attributeName + ":" + atributeValue + " of " + pageElement.getName(), logger);
		} catch (Exception exception) {
			//throw new ScriptExecutionException("Failed to fetch text: '" + "' of " + pageElement.getName(), exception);
		} finally {
			pageElement = null;
		}
		return text;
	}
}

