package shahid.Web.Steps;

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

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
import com.kms.katalon.core.webui.driver.WebUIDriverType

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Categories {

	@Given("I want to Verify Main Movies Page")
	def I_want_to_Verify_Main_Movies_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Movies/Main Movies Page/moviesButton'))

		WebUI.refresh()
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementPresent(findTestObject('Categories/Movies/Main Movies Page/mainMoviePoster'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Movies/Main Movies Page/subMoviePoster1'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Movies/Main Movies Page/subMoviePoster2'), 0)
		WebUI.scrollToElement(findTestObject('Categories/Movies/Main Movies Page/recentlyAddedSliderText'), 0)

		WebUI.verifyElementText(findTestObject('Categories/Movies/Main Movies Page/recentlyAddedSliderText'), 'أفلام أضيفت حديثاً')
		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Categories/Movies/Main Movies Page/firstMovieBundle')
		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}

	@Then("I want to Verify Comic Movies Page")
	def I_want_to_Verify_Comic_Movies_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.mouseOver(findTestObject('Categories/Movies/Main Movies Page/moviesButton'))
		WebUI.click(findTestObject('HomeScreen/Menu Bar/Movies/comedy'))
		WebUI.refresh()
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/mainSliderText'), 'كوميديا')

		CustomKeywords.'Shahid.VerifyRankingSection'()

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisMonth'))
		def APIResponse = WS.sendRequest(findTestObject('Categories/Movies/Comic Movies Page/mostPopulerThisMonth'))

		CustomKeywords.'Shahid.VerifyFirstThumbnial'(APIResponse)

		WebUI.delay(5)

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/rankingButton'))

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'))

		WebUI.mouseOver(findTestObject('Categories/Movies/Comic Movies Page/mainSliderText'))
		WebUI.delay (3)

		String Image2 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\screenshot5.png')
		String RandomKey = CustomKeywords.'Shahid.RandomKey'()

		String Image3 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\'+'screenshot6'+RandomKey+'.png')

		CustomKeywords.'Shahid.compare'(Image3, Image2)

		//CustomKeywords.'Shahid.ClickMoreButton'()
		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}





	@Given("I want to Verify Main Series Page")
	def I_want_to_Verify_Main_Series_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Series/Main Series Page/seriesButton'))
		WebUI.refresh()

		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementPresent(findTestObject('Categories/Series/Main Series Page/mainSeriesPoster'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Series/Main Series Page/subSeriesPoster1'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Series/Main Series Page/subSeriesPoster2'), 0)

		WebUI.scrollToElement(findTestObject('Categories/Series/Main Series Page/recentlyAddedSliderText'), 0)

		WebUI.verifyElementText(findTestObject('Categories/Series/Main Series Page/recentlyAddedSliderText'), 'أضيف حديثا')

		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Categories/Series/Main Series Page/firstSeriesBundle')

		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}

	@Then("I want to Verify English Series Page")
	def I_want_to_Verify_English_Series_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.mouseOver(findTestObject('Categories/Series/Main Series Page/seriesButton'))
		WebUI.click(findTestObject('HomeScreen/Menu Bar/Series/english'))
		WebUI.refresh()
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/mainSliderText'), 'الإنجليزية')

		CustomKeywords.'Shahid.VerifyRankingSection'()

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisMonth'))
		def APIResponse = WS.sendRequest(findTestObject('Categories/Series/English Series Page/mostPopularThisMonth'))
		CustomKeywords.'Shahid.VerifyFirstThumbnial'(APIResponse)
		WebUI.delay(5)

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/rankingButton'))

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'))

		WebUI.mouseOver(findTestObject('Categories/Series/English Series Page/mainSliderText'))
		WebUI.delay (3)

		String Image2 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\screenshot5.png')
		String RandomKey = CustomKeywords.'Shahid.RandomKey'()

		String Image3 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\'+'screenshot6'+RandomKey+'.png')

		CustomKeywords.'Shahid.compare'(Image3, Image2)

		//CustomKeywords.'Shahid.ClickMoreButton'()
		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}



	@Given("I want to Verify Main Shows Page")
	def I_want_to_Verify_Main_Shows_Page () {

		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Shows/Main Shows Page/ShowsButton'))
		WebUI.refresh()

		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementPresent(findTestObject('Categories/Shows/Main Shows Page/mainShowPoster'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Shows/Main Shows Page/subShowPoster1'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Shows/Main Shows Page/subShowPoster2'), 0)

		WebUI.scrollToElement(findTestObject('Categories/Shows/Main Shows Page/recentlyAddedSliderText'), 0)

		WebUI.verifyElementText(findTestObject('Categories/Shows/Main Shows Page/recentlyAddedSliderText'), 'أضيف حديثاً - البرامج')

		//CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/Categories/Shows/Main Shows Page/firstShowsBundle')
		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}

	@Then("I want to Verify Entertainment Shows Page")
	def I_want_to_Verify_Entertainment_Shows_Page () {


		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.mouseOver(findTestObject('Categories/Shows/Main Shows Page/ShowsButton'))
		WebUI.click(findTestObject('HomeScreen/Menu Bar/Shows/entertainment'))
		WebUI.refresh()
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/mainSliderText'), 'ترفيهي')

		CustomKeywords.'Shahid.VerifyRankingSection'()

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/Z-A'))
		def APIResponse = WS.sendRequest(findTestObject('Categories/Shows/Entertainment Shows Page/Z-A'))

		CustomKeywords.'Shahid.VerifyFirstThumbnial'(APIResponse)

		WebUI.delay(5)

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/rankingButton'))

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'))

		WebUI.mouseOver(findTestObject('Categories/Shows/Entertainment Shows Page/mainSliderText'))
		WebUI.delay (3)

		String Image2 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\screenshot5.png')
		String RandomKey = CustomKeywords.'Shahid.RandomKey'()

		String Image3 = WebUI.takeScreenshot('C:\\Users\\Mujahed\\Desktop\\New folder\\'+'screenshot6'+RandomKey+'.png')

		CustomKeywords.'Shahid.compare'(Image3, Image2)

		//	CustomKeywords.'Shahid.ClickMoreButton'()
		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}



	@Given("I want to Verify Main FOX Page")
	def I_want_to_Verify_Main_FOX_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Channels/channelsButton'))
		WebUI.delay (2)
		WebUI.click(findTestObject('Categories/Channels/foxThumbnail'))
		WebUI.delay (2)
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')

		WebUI.verifyElementPresent(findTestObject('Categories/FOX/Main FOX Page/mainPoster'), 0)

		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Categories/FOX/Main FOX Page/recentlyAddedSliderText')

		WebUI.verifyElementText(findTestObject('Categories/FOX/Main FOX Page/recentlyAddedSliderText'), 'أضيف حديثاً')

		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Categories/FOX/Main FOX Page/nationalGeographicSliderText')

		WebUI.verifyElementText(findTestObject('Categories/FOX/Main FOX Page/nationalGeographicSliderText'), 'National Geographic')

		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Categories/FOX/Main FOX Page/firstSeriesBundle')


		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}



	@Then("I want to Verify FOX Cinema Page")
	def I_want_to_Verify_FOX_Cinema_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()

		WebUI.click(findTestObject('Categories/Channels/channelsButton'))
		WebUI.delay (2)
		WebUI.click(findTestObject('Categories/Channels/foxThumbnail'))
		WebUI.delay (2)
		WebUI.scrollToElement(findTestObject('Categories/FOX/Main FOX Page/foxChannelsSlider'), 0)
		WebUI.click(findTestObject('Categories/FOX/Main FOX Page/foxCinemaThumbnail'))
		WebUI.delay (2)
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementText(findTestObject('Categories/FOX/FOX Cinema Page/mainSliderText'), 'Fox Cinema')

		CustomKeywords.'Shahid.VerifyRankingSection'()

		WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'))

		def APIResponse = WS.sendRequest(findTestObject('Categories/FOX/FOX Cinema Page/oldToNew'))

		CustomKeywords.'Shahid.VerifyFirstThumbnial'(APIResponse)

		//	CustomKeywords.'Shahid.ClickMoreButton'()
		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}


	@Given("I want to Verify Redirecting To GOBOZ")
	def I_want_to_Verify_Redirecting_To_GOBOZ () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/GOBOZ/gobozButton'))
		WebUI.switchToWindowIndex(1)
		WebUI.verifyElementPresent(findTestObject('Categories/GOBOZ/shahidLogo'), 0)
		WebUI.closeBrowser()
	}


	@Given("I want to Verify Channels Page")
	def I_want_to_Verify_Channels_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()


		WebUI.click(findTestObject('Categories/Channels/channelsButton'))
		WebUI.delay (2)
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.verifyElementText(findTestObject('Categories/Channels/mainSliderText'), 'جميع القنوات')

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/foxThumbnail'), 0)
		WebUI.verifyElementPresent(findTestObject('Categories/Channels/shahidKidsThumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC-ActionThumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC-MASER2Thumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC-MASERThumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC1Thumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC2Thumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC3Thumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBC4Thumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBCBollywoodThumbnail'), 0)

		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBCDramaThumbnail'), 0)
		WebUI.verifyElementPresent(findTestObject('Categories/Channels/MBCIraqThumbnail'), 0)
		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}


	@Given("I want to Verify Main Kids Page")
	def I_want_to_Verify_Main_Kids_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Kids/kidsButton'))
		CustomKeywords.'Shahid.VerifyShahidMainBarComponents'('Anonymous')
		WebUI.delay(3)
		WebUI.click(findTestObject('HomeScreen/mainSliderRightButton'))
		WebUI.click(findTestObject('HomeScreen/mainSliderLeftButton'))
		WebUI.scrollToElement(findTestObject('HomeScreen/mainSliderPointer'), 0)

		for (def i = 3; i <7; i++) {

			def Xpath  ="(//div[@class='slick-slide slick-active'])"+ [i]
			TestObject SliderElement = WebUI.modifyObjectProperty(findTestObject('Object Repository/Categories/Kids/sliderElement'), 'xpath', 'equals', Xpath, true)
			WebUI.verifyElementPresent(SliderElement, 0)
		}

		CustomKeywords.'Shahid.ScrollToText'('مشاهدة مع العائلة')
		CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/Categories/Kids/spokenAnimalsCarousel')

		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}

	@Then("I want to Verify Dora Charachter Page")
	def I_want_to_Verify_Dora_Charachter_Page () {
		CustomKeywords.'Shahid.NavigateToShahid'()
		WebUI.click(findTestObject('Categories/Kids/kidsButton'))
		WebUI.scrollToElement(findTestObject('HomeScreen/mainSliderPointer'), 0)

		WebUI.click(findTestObject('Categories/Kids/doraCharachterButton'))

		WebUI.delay(3)

		WebUI.verifyElementText(findTestObject('Categories/Kids/doraPageMainText'), 'دورا')

		WebUI.verifyElementText(findTestObject('Categories/Kids/doraTitleName'), 'مغامرات دورا')

		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}
}