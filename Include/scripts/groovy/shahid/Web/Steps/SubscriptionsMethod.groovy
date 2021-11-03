package shahid.Web.Steps
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid
class SubscriptionsMethod {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Auto-Fill Voucher on landing page")
	def I_want_to_AutoFill_Voucher_on_landing_page() {
		//		String voucherCode = new ReadSpreadsheet().getSpreadSheetRecords("vouchers!A2")
		String voucherCode = "KCaSHxKB8zV"
		String actualValue
		GlobalVariable.voucherlandingpageUrl = GlobalVariable.voucherlandingpageUrl + voucherCode

		new Shahid().NavigateTo(GlobalVariable.voucherlandingpageUrl)

		WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPage/proceedButton'), 4)
		WebUI.click(findTestObject('Object Repository/LandingPage/proceedButton'))


		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LandingPage/enterVoucherField'), 4)) {
			actualValue = WebUI.getAttribute(findTestObject('Object Repository/LandingPage/enterVoucherField'), 'value')
		}else if(WebUI.getUrl().contains("login")) {
			String Email= new Shahid().mohmalEmail()
			WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), Email)
			WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))

			if(WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/Error Messages/invalidEmailErrorMessage'), 4)){
				Email= new Shahid().mohmalEmail()
				WebUI.clearText(findTestObject('Object Repository/LoginScreen/usernameField'))
				WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), Email)
				WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
			}

			WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/passwordField'), 5)
			WebUI.setText(findTestObject('Object Repository/LoginScreen/passwordField'), "mbc@123")
			WebUI.click(findTestObject('Object Repository/SignUpScreen/termsAndConditionsCheckbox'))
			WebUI.click(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'))
			WebUI.click(findTestObject('Object Repository/SignUpScreen/createButton'))


		}
		if(actualValue==voucherCode) {
			KeywordUtil.markPassed("voucher code match")
		}else {
			KeywordUtil.markFailed("Response status code not match. Expected: " +
					voucherCode + " - Actual: " + actualValue )
		}

	}


	@Given("Cancel and Reactivate Subscription")
	def cancelSubscription () {
		new Shahid().NavigateToShahid()
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)


		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscriptionsManagement'), 3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/subscriptionsManagement'))
		WebUI.delay(2)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/cancelSubscription'), 3)
		WebUI.scrollToElement(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/cancelSubscription'), 3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/cancelSubscription'))

		//Before you Go page
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SadLogo'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/Title'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/Description'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/FirstCarouselHeader'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/FirstCarousel'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SecondCarouselHeader'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SecondCarousel'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/EmailDetailsText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/WhatsappContactUSText'),  2)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ContinueCancellation'))

		////Before you Go tell more page
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SadLogo'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/Title'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/Description'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/CancelReasonFormHeader'), 3)
		println("label number:: "+driver.findElements(By.xpath('//label[contains(@class,"radioButton")]')).size())
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/EmailDetailsText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/WhatsappContactUSText'),  2)
		WebUI.scrollToElement(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ContinueCancellation'), 3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ContinueCancellation'))

		//Goodbye page
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ThankYou'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SadLogo'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/SubscriptionCancelledSubMessage'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/Description'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/HomeButton'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ChangeYourMind'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/EmailDetailsText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/WhatsappContactUSText'),  2)
		WebUI.scrollToElement(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ContinueCancellation'), 3)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ReactivateSubscription'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ReactivateSubscriptionButton'), 7)
		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/cancelSubscription/beforeYouGo/ReactivateSubscriptionButton'))

		WebUI.closeBrowser()

	}
}