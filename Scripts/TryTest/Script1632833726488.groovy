import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.en.Given as Given
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'shahid.utils.Shahid.NavigateToShahid'()

WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)

List<WebElement> UserProfile = driver.findElements(By.xpath('//img[@style and not(@class)]'))

(UserProfile[0]).click()

WebUI.delay(6)

WebUI.navigateToUrl('https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171')

WebUI.waitForPageLoad(120)

WebUI.delay(6)

new Shahid().newBrowser()

WebDriver driver2 = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))

new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)

WebUI.delay(2)

new Shahid().popupNotification()

WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profile2'), 7)

List<WebElement> UserProfile2 = driver2.findElements(By.xpath('(//img[@style and not(@class)])[3]'))

(UserProfile2[0]).click()

WebUI.delay(6)

WebUI.navigateToUrl('https://shahid.mbc.net/ar/series/Salon-Zahra-season-1-episode-1/episode-901171')

WebUI.waitForPageLoad(120)

WebUI.delay(6)

CustomKeywords.'shahid.utils.Shahid.popupNotification'()

