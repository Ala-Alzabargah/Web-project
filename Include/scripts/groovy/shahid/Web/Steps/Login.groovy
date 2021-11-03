package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import internal.GlobalVariable
import shahid.utils.Shahid


class Login {

	//Verify Login page
	@Given("I want to Verify Login page")
	def I_want_to_Verify_Login_page () {

		new Shahid().NavigateToShahid()
		new Shahid().VerifyStaticPagesMainBarComponents()
		new Shahid().popupNotification()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/shahidAccountTitle'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListText') , 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/enterUsernameTitleText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/usernameField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/loginButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/facebookLoginButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/googleLoginButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/reCAPTCHAText'), 3)
		//new Shahid().verifyFooterElements()


				WebUI.closeBrowser()
	}


	//Verify login password page
	@Given("I want to Verify login password page")
	def I_want_to_Verify_login_password_page() {

		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		WebUI.delay(1)
		
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		}

		WebUI.delay(1)
		if(WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'),4)){
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}
			else if((WebUI.getUrl()).contains('login-password')){
			WebUI.refresh()
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}
			else{
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}
		//new Shahid().VerifyStaticPagesMainBarComponents()
		WebUI.delay(2)
		if(!(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/loginText'), 8))){
			WebUI.refresh()
			WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/loginText'), 8)
		}
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListText') , 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/enterPasswordTitleText'), 3)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/LoginScreen/usernameField'), 'value', GlobalVariable.SubscribedUser, 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/passwordField'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/loginButton'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPasswordLink'), 3)
		WebUI.click(findTestObject('Object Repository/LoginScreen/forgetPasswordLink'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPasswordTitleText'), 3)
		WebUI.back()
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/backButton'), 6)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/reCAPTCHAText'), 3)
		//new Shahid().verifyFooterElements()
//
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	//Verify login Valid Scenarios//


	//login using valid data
	@Given('I want to login using valid data (.*)')
	def I_want_to_login_using_valid_data(String userType) {
		new Shahid().NavigateToShahid()
		if(userType=="Email") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Mobile") {
			new Shahid().shahidLogin(GlobalVariable.MobileNumber, GlobalVariable.MobileNumberPassword)
		}

		new Shahid().popupNotification()
		WebUI.delay(2)

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()

		//		WebUI.click(findTestObject('Object Repository/LoginScreen/profileIcon'))
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	//login Via Facebook using valid data
	@Given('I want to login Via Facebook using valid data')
	def I_want_to_login_Via_Facebook_using_valid_data() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/facebookLoginButton'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'), GlobalVariable.validFacebookUser)
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Facebook/enterPasswordField'), GlobalVariable.validFacebookPassword)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.delay(1)

		//				Boolean continueButtonCondition =WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Facebook/continueButton'), 3)
		//				if(continueButtonCondition) {
		//					println "insideif True"
		//					new Shahid().popupNotification()
		//					WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/continueButton'))
		//				}

		WebUI.switchToWindowIndex(0)
		WebUI.delay(2)
		//		new Shahid().popupNotification()
		//		Boolean linkingAccountCondition= WebUI.verifyEqual(WebUI.getUrl(), 'https://shahid.mbc.net/ar/widgets/linking-account',FailureHandling.CONTINUE_ON_FAILURE)
		Boolean linkingAccountCondition= false

		if(linkingAccountCondition) {
			WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/passwordField'), GlobalVariable.validFacebookPassword)
			WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
			Boolean passwordValidationCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/invalidUsername'), 3)
			if(passwordValidationCondition) {
				println "This email is registered with us"
			}else {
				new Shahid().popupNotification()
				WebDriver driver = DriverFactory.getWebDriver()
				WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 5)
				List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
				UserProfile[0].click()
			}
		}else {
			new Shahid().popupNotification()
			WebDriver driver = DriverFactory.getWebDriver()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 5)
			List<WebElement> UserProfile = driver.findElements(By.xpath("(//img[@style and @src and @alt and not(@class)])[1]"))
			WebUI.delay(1)
			UserProfile[0].click()
		}
		WebUI.delay(1)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	//login Via Google using valid data
	@Given('I want to login Via Google using valid data')
	def I_want_to_login_Via_Google_using_valid_data() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/googleLoginButton'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		String xpath="//div[@data-identifier='"+GlobalVariable.validGoogleUser+"']"
		TestObject googleAcoount= WebUI.modifyObjectProperty(findTestObject('Object Repository/LoginScreen/Google/alreadyExistingAccount'), 'xpath', 'equals', xpath, true)
		Boolean existingCondition=WebUI.waitForElementPresent(googleAcoount, 3, FailureHandling.CONTINUE_ON_FAILURE)
		Boolean useAnotherAccountCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'), 3, FailureHandling.CONTINUE_ON_FAILURE)

		if(useAnotherAccountCondition) {
			if(existingCondition) {
				WebUI.click(googleAcoount)
			}else {
				WebUI.click(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'))
				WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'))
				WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.validGoogleUser)
				WebUI.click(findTestObject('Object Repository/LoginScreen/Google/usernameNextButton'))
				WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'))
				WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'), GlobalVariable.validGooglePassword)
				WebUI.click(findTestObject('Object Repository/LoginScreen/Google/passwordNextButton'))
			}
		}else{
			WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'))
			WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.validGoogleUser)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/usernameNextButton'))
			WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'))
			WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'), GlobalVariable.validGooglePassword)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/passwordNextButton'))
		}
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 3)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(1)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.closeBrowser()

	}

	//login using Invalid Data//


	//login using Invalid Username
	@Given('I want to login using Invalid Username')
	def I_want_to_login_using_Invalid_Username() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), 'alaa@alaa')
		Boolean emailvalidation=new Shahid().isEmailValid('alaa@alaa')
		if(emailvalidation) {
			WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
			WebUI.delay(2)
			String PageUrl=WebUI.getUrl()
			PageUrl.contains('shahid.net/ar/widgets/registration')
			WebUI.verifyElementText(findTestObject('Object Repository/Registration Page/createShahidAccountTitleText'), 'إنشاء حساب SHAHID')

		}else {
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyUsername'), 3)
		}
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()


	}


	//I want to login using Invalid Password
	@Given('I want to login using Invalid Password')
	def I_want_to_login_using_Invalid_Password() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		WebUI.delay(1)
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		}

		WebUI.delay(1)
		if(WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'),4)){
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}else if((WebUI.getUrl()).contains('login-password')){
			WebUI.refresh()
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}else{
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			WebUI.waitForElementPresent(findTestObject('LoginScreen/passwordField'), 6)

		}
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/passwordField'), GlobalVariable.invalidUserPassword)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/invalidUsername'), 3)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.delay(1)
		WebUI.closeBrowser()
	}

	//login Via Facebook using Invalid Username
	@Then("I want to login Via Facebook using Invalid Username")
	def Then_I_want_to_login_Via_Facebook_using_Invalid_Username() {

		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/facebookLoginButton'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'), 'Incorrect email or phone number\nThe email or phone number you’ve entered doesn’t match any account. Sign up for an account.')
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'),GlobalVariable.invalidFacebookUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'), 'Incorrect Email\nThe email you’ve entered doesn’t match any account. Sign up for an account.')
		WebUI.delay(1)
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Facebook/enterPasswordField'), GlobalVariable.invalidFacebookPassword)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'), 'Incorrect email or phone number\nThe email or phone number you’ve entered doesn’t match any account. Sign up for an account.')
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	//login Via Facebook using Invalid Password
	@Then("I want to login Via Facebook using Invalid Password")
	def Then_I_want_to_login_Via_Facebook_using_Invalid_Password() {

		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/facebookLoginButton'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'), GlobalVariable.validFacebookUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'), 'Please re-enter your password\nThe password you’ve entered is incorrect. Forgot Password?')
		WebUI.clearText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'))
		WebUI.delay(1)
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Facebook/enterPasswordField'), GlobalVariable.invalidFacebookPassword)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'), 'Incorrect email or phone number\nThe email or phone number you’ve entered doesn’t match any account. Sign up for an account.')
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Facebook/enterUsernameField'), GlobalVariable.validFacebookUser)
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/Facebook/enterPasswordField'), GlobalVariable.invalidFacebookPassword)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Facebook/loginButton'))
		WebUI.delay(1)
		println  WebUI.getText(findTestObject('Object Repository/LoginScreen/Facebook/Error Messages/invalidData'))
		WebUI.delay(2)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	//login Via Google using Invalid Username
	@Then('I want to login Via Google using Invalid Username')
	def I_want_to_login_Via_Google_using_Invalid_Username() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/googleLoginButton'))
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.switchToWindowIndex(1)
		Boolean useAnotherAccountCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'), 2, FailureHandling.CONTINUE_ON_FAILURE)

		if(useAnotherAccountCondition) {
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'))
		}
		WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'))
		if(GlobalVariable.invalidGoogleUser=='') {
			WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.invalidGoogleUser)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/usernameNextButton'))
			WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Google/Error Message/enterUsername'), "يجب إدخال بريد إلكتروني أو رقم هاتف")
		}else {
			WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.invalidGoogleUser)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/usernameNextButton'))
			WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Google/Error Message/CouldntfindAccount'), "تعذَّر العثور على حساب Google مرتبط بما أدخلته")
		}
		WebUI.delay(1)
		WebUI.switchToWindowIndex(0)
		WebUI.delay(2)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	//login Via Google using Invalid Password
	@Then('I want to login Via Google using Invalid Password')
	def I_want_to_login_Via_Google_using_Invalid_Password(){
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/googleLoginButton'))
		WebUI.delay(1)
		WebUI.switchToWindowIndex(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		Boolean useAnotherAccountCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'), 4, FailureHandling.CONTINUE_ON_FAILURE)
		if(useAnotherAccountCondition) {
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/useAnotherAccountLink'))
		}
		WebUI.clearText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googleUsernameField'), GlobalVariable.validGoogleUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/Google/usernameNextButton'))
		if(GlobalVariable.invalidGooglePassword=='') {
			WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'), GlobalVariable.invalidGooglePassword)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/passwordNextButton'))
			WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Google/Error Message/enterPassword'), "أدخِل كلمة مرور")
		}else {
			WebUI.setText(findTestObject('Object Repository/LoginScreen/Google/googlePasswordField'), GlobalVariable.invalidGooglePassword)
			WebUI.click(findTestObject('Object Repository/LoginScreen/Google/passwordNextButton'))
			WebUI.verifyElementText(findTestObject('Object Repository/LoginScreen/Google/Error Message/wrongPassword'), 'كلمة مرور خاطئة. أعد المحاولة، أو انقر على "نسيت كلمة المرور" لإعادة تعيينها.')
		}
		WebUI.switchToWindowIndex(0)
		WebUI.delay(1)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	@Given('Forget password')
	def Forget_password(){

		new Shahid().NavigateToShahid()

		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		WebUI.delay(1)
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		}
		WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		WebUI.click(findTestObject('Object Repository/LoginScreen/forgetPassword/forgetPasswordButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/PasswordRecovery'), 6)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/Description'), 3)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/forgetPassword/Email'), GlobalVariable.SubscribedUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/forgetPassword/ResetPasswordButton'))

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/EmailSentSuccessfully'), 6)) {
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/EmailSentSuccessfully'), 6)

			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/ContinueLogin'), 6)
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/SendLinkAgain'), 6)
		}else {
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/forgetPassword/SpinnerIcon'), 6)

		}



		WebUI.closeBrowser()
	}


	//Verify Login page
	@Given("I want to Verify Login from SVOD Player (.*)")
	def loginFromSvodPlayer (String userType) {
		String username = GlobalVariable.SubscribedUser
		String password = GlobalVariable.SubscribedUserPassword
		if(userType=='Registered') {
			username = GlobalVariable.TeamUser
			password = GlobalVariable.TeamUserPassword
		}

		new Shahid().NavigateTo(GlobalVariable.SVODAsset)
		WebUI.click(findTestObject("Object Repository/LoginScreen/SvodLogin"))
		
		new Shahid().shahidLogin(username, password, 4)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)
		if(userType=='Registered') {
			WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/startFreeTrial'), 4)
		}else if(userType=='Subscribed') {
			WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/theoplayer'), 4)
		}

		WebUI.closeBrowser()
	}

	//Login using Invalid Username
	@Given('I want to Login using Invalid (.*)')
	def I_want_to_Login_using_Invalid_Username(String userType) {
		String user
		new Shahid().NavigateToShahid()
		if(userType=="Email") {
			user ='alaa@alaa'
		}else if(userType=="Mobile") {
			user=GlobalVariable.invalidMsisdn
		}


		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), user)
		Boolean emailvalidation=new Shahid().isEmailValid('alaa@alaa')
		if(emailvalidation) {
			WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
			WebUI.delay(2)
			String PageUrl=WebUI.getUrl()
			PageUrl.contains('shahid.net/ar/widgets/registration')
			WebUI.verifyElementText(findTestObject('Object Repository/Registration Page/createShahidAccountTitleText'), 'إنشاء حساب SHAHID')

		}else {
			if(userType=="Email") {
				WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyUsername'), 3)
			}else if(userType=="Mobile") {
				WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyMsisdn'), 3)
			}

		}
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()


	}


}

