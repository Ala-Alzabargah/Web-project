package shahid.Web.Steps
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import shahid.utils.Shahid



class concurrencyManagement {

	@Given("i want to watch from more than three users in parallel (.*)")
	def i_want_to_watch_from_more_than_three_users_in_parallel (String userType) {
		//
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.click(findTestObject("Object Repository/HomeScreen/loginButton"))
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(6)
		WebUI.navigateToUrl("https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171")
		WebUI.waitForPageLoad(120)
		WebUI.delay(6)


	}


	@Given("i want to watch from more than three users profile2 (.*)")
	def i_want_to_watch_from_more_than_three_users_in_parallel_profile2 (String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver2 = DriverFactory.getWebDriver()
		WebUI.click(findTestObject("Object Repository/HomeScreen/loginButton"))
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profile2'), 7)
		List<WebElement> UserProfile2 = driver2.findElements(By.xpath("(//img[@style and not(@class)])[3]"))
		UserProfile2[0].click()
		WebUI.delay(6)



		WebUI.navigateToUrl("https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171")
		WebUI.waitForPageLoad(120)
		WebUI.delay(6)
	}


	@Given("i want to watch from more than three users profile3 (.*)")
	def i_want_to_watch_from_more_than_three_users_in_parallel_profile3 (String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver3 = DriverFactory.getWebDriver()
		WebUI.click(findTestObject("Object Repository/HomeScreen/loginButton"))
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profile2'), 7)
		List<WebElement> UserProfile3 = driver3.findElements(By.xpath("(//img[@style and not(@class)])[3]"))
		UserProfile3[0].click()
		WebUI.delay(6)
		WebUI.navigateToUrl("https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171")
		WebUI.waitForPageLoad(120)
		WebUI.delay(6)
	}

	@Given("i want to watch from more than three users profile4 (.*)")
	def i_want_to_watch_from_more_than_three_users_in_parallel_profile4 (String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver4 = DriverFactory.getWebDriver()
		WebUI.click(findTestObject("Object Repository/HomeScreen/loginButton"))
		WebUI.delay(4)
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		WebUI.delay(3)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profile4'), 7)
		List<WebElement> UserProfile4 = driver4.findElements(By.xpath("(//img[@style and not(@class)])[5]"))
		UserProfile4[0].click()
		WebUI.delay(6)
		WebUI.waitForPageLoad(120)
		WebUI.navigateToUrl("https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171")
		WebUI.delay(4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/streamLimitMessage'), 4)
		WebUI.delay(6)
	}
}
