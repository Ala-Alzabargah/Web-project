package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid


class AccountSettings {

	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to Verify AccountSettings For Users (.*)")
	def verifyAccountSettingsElements(String userType) {

		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}else if(userType=="MobileOnly") {
			new Shahid().shahidLogin(GlobalVariable.mobileOnlyAccount, GlobalVariable.mobileOnlyPassword)
		}else if(userType=="sportsubscribed") {
			new Shahid().shahidLogin(GlobalVariable.sportSubscribedd, GlobalVariable.sportSubPassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		WebUI.delay(2)
		UserProfile[0].click()
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink'))
		WebUI.delay(2)


		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)



		//		WebUI.verifyElementPresent(findTestObject, 0, FailureHandling.STOP_ON_FAILURE)


		WebUI.waitForElementPresent(findTestObject('Settings Screen/Account Settings Screen/accountSettingsDescriptionText'), 2)



		if (userType=="Subscribed") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscriptionsManagement'), 2)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/vipLogo'), 0)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/package'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/shahidVipPackage'), 2)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/shahidVipTextForRegisteredUser'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/plan'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/typeOfSubsicribtion'), 0)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/sportOnShahidVipText'), 0)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/unlimitedEntertainmentAndSportText'), 0)
			//WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewPlansButton'))
			//WebUI.back()
		}
		if(userType!="Subscribed") {
			if (userType=="MobileOnly") {

				WebUI.waitForElementPresent(findTestObject('Object Repository/shhidMobileTextPackage'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/plan'), 2)
			}else if (userType=="sportsubscribed") {
				WebUI.delay(5)
				WebUI.waitForElementPresent(findTestObject('Object Repository/accountSettings/sportOnShahidVipGbox'), 2)
				WebUI.delay(5)
				WebUI.verifyElementPresent(findTestObject('Object Repository/accountSettings/sportOnShahidVipGbox'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/plan'), 2)
				
				
			}
			else {
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscribeToShahidVipButton'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/joinNowText'),2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/noCommitmentMessage'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/unlimitedEntertainmentFullHd'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewPackagesButton'),2)
			}
		}
		WebUI.waitForElementPresent(findTestObject('Settings Screen/Account Settings Screen/changePassword'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePersonalInfo'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/devicesManagement'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/parentalControlInterface'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewPreviousTransaction'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/specialFeatures'), 2)

		if(userType=="Suspended" || userType=="Registered") {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/haveCouponLink'), 2)
		}
		WebUI.delay(5)
		WebUI.closeBrowser()
	}

	///////////////////////////////////////////////////////////////subscribtion management
	//Active Subscribed User
	@Given("I want to Verify Subscriptions Management Screen For Active Subscribed User")
	def verifySubscriptionsManagement(){
		new Shahid().NavigateToShahid()
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		new Shahid().popupNotification()

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink'))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscriptionsManagement'))
		WebUI.delay(2)

		//Take Screenshot
		//		String featureName = getClass().getName()
		//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		//		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/subscriptionInfoMainTitle'), 4)

		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/subscriptionStatus'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/deductionDateText'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Subscriptions Management/paymentMethodText'), 2)


		//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/sportOnShahidVipText'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/planDetailsText'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/planDetailsPackageText'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/planText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/otherUtilities'), 2)

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/offerNameText'), 30)){
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/plan'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/package'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/offerName'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/voucherCodeButton'),3)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/redeemYourVoucherText'), 2)
			//WebUI.back()
			//WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/switchPackageButton'))
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/sportOnText'), 2)
			//WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/sportOnText'), 2)
			////doublecheck
			//println "text::"+WebUI.getText(findTestObject('Object Repository/Settings Screen/Account Settings Screen/shahidVipGobxText'),2)
			//WebUI.back()
			//WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/switchPackageIconButton'))
			//			WebUI.back()

		}else if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cardNumber'), 0)){
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/planCardNumber'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/packageCardNumber'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/planCardNumber'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cardNumberText'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/expiryDateText'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/expiryDate'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/visaLogo'), 2)
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/updateButton'))
			WebUI.back()
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewTransactionHistoryButton'))
			//			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewTransactionHistory'), 2)
			WebUI.back()
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/couponCodebutton'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/couponText'), 2)
			WebUI.back()
			//			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/switchPackageButton'))
			//			WebUI.delay(3)
			//			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/switchToShahidVipButton'), 2)
			//			WebUI.back()
			//			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/switchPackageIconButton'), 2)
			//			WebUI.back()
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelYourSubscribtionButton'),2)
			WebUI.delay(3)
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelYourSubscribtionButton'))
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/wereSorryToSeeYouLeaveLogo'),2)
			WebUI.delay(3)
			WebUI.back()

		}else if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/serviceProvider'), 0)) {

			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/serviceProvider'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/serviceProviderLogo'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/plan'), 2)
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewTransactionHistoryButton'))
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/viewTransactionHistory'), 2)
			WebUI.back()
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelYourSubscribtionButton'))
			WebUI.delay(3)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/wereSorryToSeeYouLeaveLogo'), 2)
			WebUI.delay(3)
			WebUI.back()

		}
		//common
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/doYouNeedHelpWithYourSubscribtionButton'))
		new Shahid().scrollElementIntoView()
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/callTheFollowingNumbers'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/saudiArabia'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/aeu'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/hkj'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/internationalNumber'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/saudiArabiaNumber'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/uaeNumber'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/hkjNumber'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/internationalNumberDigits'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/returnToThePreviosStep'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/returnToPreviousStepicon'), 2)
		//new Shahid().verifyFooterElements()
		WebUI.closeBrowser()
	}


	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to verify Change Password Screen For Users (.*)")
	def verifyChangePassword(String userType){
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.subsicribedUserOnlyForChangePassword, GlobalVariable.subscribedUserPasswordOnlyForChangePassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.registeredUserOnlyForChangePassword, GlobalVariable.registeredUserPasswordOnlyForChangePassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}
		println userType
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()

		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePassword'))
		WebUI.delay(2)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 2)
		if (userType=="Subscribed") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.subscribedUserPasswordOnlyForChangePassword)}

		if (userType=="Registered") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.registeredUserPasswordOnlyForChangePassword)}

		if (userType=="Suspended") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.SuspendedUserPassword)}

		if (userType=="Cancelled") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.CancelledUserpassword)}

		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), 'Tscr9DIxB28=')
		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), 'Tscr9DIxB28=')
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Change Password Section/saveButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/passwordChangedSuccessfully'), 5)
		//		def b=1
		//		for (def i = 0; i <b; i++) {
		//			String homePage=WebUI.getUrl()
		WebUI.mouseOver(findTestObject('Object Repository/LoginScreen/After Reset Password/settingsLink'))
		WebUI.waitForElementPresent(findTestObject('HomeScreen/Menu Bar/User Profile/logout'), 7)
		WebUI.mouseOver(findTestObject('HomeScreen/Menu Bar/User Profile/logout'))
		WebUI.click(findTestObject('HomeScreen/Menu Bar/User Profile/logout'))
		//			WebUI.click(findTestObject("HomeScreen/Menu Bar/User Profile/logout"), FailureHandling.CONTINUE_ON_FAILURE)

		//			String currentPage=WebUI.getUrl()
		//			if (homePage == currentPage ) {
		//				b++
		//			}
		//		}
		WebUI.delay(5)

		//Reset Password
		new Shahid().NavigateToShahid()
		WebUI.delay(2)

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.subsicribedUserOnlyForChangePassword, 'aeHFOx8jV/A=')
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.registeredUserOnlyForChangePassword, 'aeHFOx8jV/A=')
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser,'Tscr9DIxB28=')
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser,'Tscr9DIxB28=')
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 9)
		List<WebElement> UserProfile2 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile2[0].click()
		WebUI.delay(4)

		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePassword'))
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 2)
		//to ask
		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), 'Tscr9DIxB28=')

		if(userType=="Subscribed") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), GlobalVariable.subsicribedUserOnlyForChangePassword)
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), GlobalVariable.subscribedUserPasswordOnlyForChangePassword)				}
		else if(userType=="Registered") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), GlobalVariable.registeredUserOnlyForChangePassword)
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), GlobalVariable.registeredUserPasswordOnlyForChangePassword)				}
		else if(userType=="Suspended") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), GlobalVariable.SuspendedUserPassword)
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), GlobalVariable.SuspendedUserPassword)				}
		else if(userType=="Cancelled") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), GlobalVariable.CancelledUserpassword)
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), GlobalVariable.CancelledUserpassword)				}

		WebUI.click(findTestObject('Object Repository/Settings Screen/Change Password Section/saveButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/passwordChangedSuccessfully'), 5)
		WebUI.delay(5)
		WebUI.closeBrowser()
	}


	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to verify entering not matched password at NewPassword confirmNewPassword fields (.*)")
	def verifyNotMatchedPassword(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'), 7)
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))


		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePassword'), 7)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePassword'))
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 2)

		if(userType=="Subscribed") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), GlobalVariable.CancelledUserpassword)
		}

		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), 'Tscr9DIxB28=')
		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), 'VQGwajr34dU=')
		WebUI.delay(1)

		WebUI.waitForElementPresent(findTestObject('Settings Screen/Change Password Section/passwordNotMatchedErrorMessage'), 7)
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.delay(1)

		WebUI.closeBrowser()
	}


	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to verify enter wrong Password at current password field (.*)")
	def verifyWrongCurrentPassword(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePassword'))
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Change Password Section/changePasswordDescriptionText'), 2)

		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/currentPassword'), 'VQGwajr34dU=')

		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/newPassword'), 'Tscr9DIxB28=')

		WebUI.setEncryptedText(findTestObject('Settings Screen/Change Password Section/confirmNewPassword'), 'Tscr9DIxB28=')
		WebUI.click(findTestObject('Object Repository/Settings Screen/Change Password Section/saveButton'))
		WebUI.delay(2)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.waitForElementPresent(findTestObject('Settings Screen/Change Password Section/wrongPasswordErrorMessage'), 2)
		WebUI.delay(2)
		WebUI.click(findTestObject('Settings Screen/infoElements/backButton'))
		WebUI.delay(2)

		WebUI.closeBrowser()
	}

	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to Verify Personal Info Screen For Users (.*)")
	def verifyPersonalInfo(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))

		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePersonalInfo'),3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePersonalInfo'))
		WebUI.delay(4)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/infoManagementText'), 2)
		WebUI.setText(findTestObject('Object Repository/Settings Screen/infoElements/firstName'), new Shahid().randomName())
		WebUI.setText(findTestObject('Object Repository/Settings Screen/infoElements/lastName'), new Shahid().randomName())
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/genderDropDownButton'))
		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/male'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropdownButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropDownList'), 2)
		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/monthsDropdownButton'))
		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownList'), 0)
		// Verify Years
		int c = 2002
		for (def i = 5 ; i <= 105; i++) {
			String Xpath  ='(//button[contains(@class,"userInformation")])'
			Xpath= Xpath+'['+i+']'
			TestObject YearElement = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/infoElements/yearElement'), 'xpath', 'equals', Xpath, true)
			println YearElement
			def b = WebUI.getText(YearElement)
			println b
			boolean result= c == b
			c--
		}

		WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/yearsDropdownButton'))

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/phoneNumberFieldAccountSittings'), 2)) {
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/phoneNumberFieldAccountSittings'), 2)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 2)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)
			WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))
			WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/backButton'))
			WebUI.delay(2)


		}else {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/connectMobileNumber'), 2)
			WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/connectMobileNumber'))
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/sub-connectMobileNumber'), 2)
			WebUI.back()
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)
			WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/backButton'))
			WebUI.delay(2)



			WebUI.closeBrowser()
		}
	}
	//Active Subscribed User
	@Given("I want to Verify Add communication Email (.*)")
	def verifyAddCommunicationEmail(String emailType) {
		new Shahid().NavigateToShahid()
		new Shahid().shahidLogin(GlobalVariable.MobileNumber, GlobalVariable.MobileNumberPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))

		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePersonalInfo'),3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/changePersonalInfo'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/mobileNumber'), 4)
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/addEmail'), 3)) {
			WebUI.click(findTestObject('Object Repository/Settings Screen/infoElements/addEmail'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/addEmailDescription'), 3)
			if(emailType=='Invalid') {
				println "Invalid emailType:: "+emailType
				WebUI.setText(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 'alaa@alaa')
				WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyUsername'), 3)
			}else if(emailType=='Used') {
				println "Used emailType:: "+emailType
				WebUI.setText(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), GlobalVariable.SubscribedUser)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)

				WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))

				WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/updateDoneMessage'), 3)


			}


		}else if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/emailField'), 3)) {
			WebUI.clearText(findTestObject('Object Repository/Settings Screen/infoElements/emailField'))
			WebUI.setText(findTestObject('Object Repository/Settings Screen/infoElements/emailField'),new Shahid().generateNewUser())
			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/submitButton'), 2)

			WebUI.click(findTestObject('Settings Screen/infoElements/submitButton'))

			WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/infoElements/updateDoneMessage'), 3)

		}


		WebUI.delay(2)

		WebUI.closeBrowser()
	}

	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to Verify Devices Management Screen For Users (.*)")
	def verifyDevicesManagementElements(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/devicesManagement'))
		WebUI.delay(2)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.waitForElementPresent(findTestObject('Settings Screen/Devices Management/devicesManagementText'), 2)

		WebUI.setText(findTestObject('Settings Screen/Devices Management/paringCodeFiled'), "123456")

		WebUI.click(findTestObject('Settings Screen/Devices Management/submitParingCodeButton'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/wrongParingCodeErrorMessage'), 3)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/numberOfDevicesAllowedText'), 2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/devicesCurrentlyLinkedText'), 2)

		WebUI.waitForElementPresent(findTestObject("Object Repository/Settings Screen/Devices Management/linkedDeviceItem"), 2)

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deviceInfoContainer'), 3)){

			WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/editButton'))

			WebUI.clearText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'))

			WebUI.setText(findTestObject('Object Repository/Settings Screen/Devices Management/updatedevicenameField'), 'update for test')

			WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/saveButton'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/updateDeviceNameMessage'), 5)

			WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/deleteLinkedDeviceButton'))

			WebUI.click(findTestObject('Object Repository/Settings Screen/Devices Management/deletePopUp-YesButton'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Devices Management/deleteDoneText'), 5)
		}

		WebUI.click(findTestObject('Settings Screen/infoElements/backButton'))
		WebUI.delay(2)
		WebUI.back()
		WebUI.closeBrowser()
	}


	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to Verify Parental control interface For Users (.*)")
	def verifyParentalControl(String userType){
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		def a=1
		def x =0
		def y =0
		def codeDigits=[]
		String newCode=""
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/parentalControlInterface'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Parental control interface/parentalControlInterfaceText'), 2)

		for (def i = 1 ; i <= 4; i++) {
			codeDigits[x] = Math.abs(new Random().nextInt() % [9]) + 0
			def Xpath  ='(//input[@type="tel"])'+ [i]
			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/Parental control interface/codeDigitField'), 'xpath', 'equals', Xpath, true)
			WebUI.setText(digit, codeDigits[x].toString())
			newCode+=codeDigits[x].toString()
			x++
		}

		WebUI.click(findTestObject("Object Repository/Settings Screen/Parental control interface/SaveButton"))

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		//		WebUI.verifyElementText(findTestObject("Object Repository/Settings Screen/Parental control interface/updateDoneMessage"), 'تم تعديل الرمز بنجاح.')

		WebUI.click(findTestObject('Settings Screen/infoElements/backButton'))
		WebUI.delay(2)
		//		WebUI.verifyElementText(findTestObject('Settings Screen/Account Settings Screen/accountSettingsDescriptionText'), 'اعدادات الحساب\nاشتراكك مفعل\nاشتراكك فعال حتى ١٩ مارس ٢٠٢٢')
		WebUI.back()
		WebUI.delay(2)

		for (def i = 1 ; i <= 4; i++) {
			def Xpath  ='(//input[@type="tel"])'+ [i]
			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/Parental control interface/codeDigitField'), 'xpath', 'equals', Xpath, true)
			String digitNumber= WebUI.getAttribute(digit, 'value')
			WebUI.verifyEqual(digitNumber,codeDigits[y].toString())
			println "digitNumber"+digitNumber + "==" + "codeDigits{"+ y +"}"+codeDigits[y]
			y++
		}

		println "newCode:: "+newCode
		if(userType=="Subscribed") {
			new Shahid().updateParentalControlCode(newCode, "VIP")}
		if(userType=="Registered") {
			new Shahid().updateParentalControlCode(newCode, "Registered")}

		WebUI.closeBrowser()
	}


	//Active Subscribed/Registered/Suspended/Cancelled Users
	@Given("I want to verify Special Features Section For Users (.*)")
	def verifySpecialFeatures(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		WebUI.delay(4)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/specialFeatures'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Special Feature Section/specialFeatureText'), 4)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Special Feature Section/noFeatureAvaiableText'), 4)
		WebUI.closeBrowser()
	}

	//Registered/Suspended/Cancelled Users
	@Given("I want to Verify View previous operations Screen (.*)")
	def verifyViewPreviousOperations(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/previousOperations'),4)) {
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/previousOperations'))
			WebUI.delay(2)}
		String noPreviousOperationsText
		Boolean FEcondition = false
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/previousOperationsSection/previousOperationsText'), 7)
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText'), 7)) {
			//		noPreviousOperationsText=WebUI.getText(findTestObject('Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText'))
			//				FEcondition = new Shahid().findElement(noPreviousOperationsText)
			FEcondition= WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText'), 7)
		}

		//		boolean condition = WebUI.verifyElementNotPresent(findTestObject(noPreviousOperationsText), 0,FailureHandling.CONTINUE_ON_FAILURE)
		println "FEcondition::::::"+FEcondition
		if(FEcondition){

			WebUI.waitForElementPresent(findTestObject("Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText"), 2)

		}else{

			WebElement PreviousOperationsList= driver.findElement(By.tagName("ul"));
			List<WebElement> PreviousOperationsItem = PreviousOperationsList.findElements(By.tagName("li"))
			int Listsize=PreviousOperationsItem.size()
			println  '{{{{{{'+Listsize+'}}}}}}'

			for (def i = 1 ; i <=Listsize ; i++) {
				def Xpath  ="(//li[contains(@class,'transactionHistory_transaction-item')])"+ [i]
				TestObject listItem = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/previousOperationsSection/previousOperationItem'), 'xpath', 'equals', Xpath, true)
				WebUI.waitForElementPresent(listItem, 0)
				String itemText= WebUI.getText(listItem)
				print itemText
			}
		}
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.closeBrowser()
	}

	@Given("I want to Check if user is VIP (.*)")
	def verifyVIPtag(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()

		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}else if(userType=="Suspended") {
			new Shahid().shahidLogin(GlobalVariable.SuspendedUser, GlobalVariable.SuspendedUserPassword)
		}else if(userType=="Cancelled") {
			new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)

		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink'))
		WebUI.delay(2)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.waitForElementPresent(findTestObject('Settings Screen/Account Settings Screen/accountSettingsDescriptionText'), 2)

		String VIPCondition='true'
		Boolean sMCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscriptionsManagement'), 2)
		Boolean VIPTagCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/VIPTag'), 2)
		Boolean SubTestCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/yourSubscriptionisActiveText'), 2)

		if(!sMCondition){
			VIPCondition= "subscriptions Management"
		}else if(!VIPTagCondition){
			VIPCondition= "VIPTag"
		}else if(!SubTestCondition){
			VIPCondition= "yourSubscriptionisActiveText"
		}
		switch(VIPCondition)
		{
			case 'subscriptions Management':
				println "subscriptions Management dosen't appear"
				break
			case 'VIPTag':
				println "VIPTag dosen't appear"
				break
			case 'yourSubscriptionisActiveText':
				println "VIPTag dosen't appear"
				break
			default:
				println 'This user is VIP'
				break
		}
		WebUI.closeBrowser()
	}
}



