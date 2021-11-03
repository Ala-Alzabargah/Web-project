package shahid.Web.Steps;


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



class CheckRefresh {

	@Given("I want to check pages after refresh")
	def I_want_to_check_pages_after_refresh() {

		//Check ShahidMainPage
		CustomKeywords.'Shahid.NavigateToShahid'()

		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidLogo'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidLogo'), 2)
		}


		//Check LoginScreen
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileIcon'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileIcon'), 2)
		}


		//Check LoginPasswordScreen
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), GlobalVariable.SubscribedUser)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/enterPasswordTitleText'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/enterPasswordTitleText'), 2)
		}


		//Check UserProfilePage
		WebUI.setEncryptedText(findTestObject('Object Repository/LoginScreen/passwordField'), GlobalVariable.SubscribedUserPassword)
		WebUI.click(findTestObject('LoginScreen/loginButton'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/profileIcon'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/profileIcon'), 2)
		}


		//Check MainPage
		WebUI.click(findTestObject('Object Repository/LoginScreen/profileIcon'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'), 2)
		}

		//Check FavoritePage
		WebUI.click(findTestObject("Object Repository/MyFavoriteScreen/MyListMainPage/myListTitleText"))
		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 2)
		}

		WebUI.closeBrowser()


		WebUI.openBrowser('')
		WebUI.maximizeWindow()


		//Check ArabbankPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.ArabbankPromoPageUrl)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/tryShahidVIPButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/tryShahidVIPButton'), 2)
		}


		//Check AramediaPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.AramediaPromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/activeShahidVIPButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/activeShahidVIPButton'), 2)
		}


		//Check HisensePromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.HisensePromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/hisenseTVImage'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/hisenseTVImage'), 2)
		}


		//Check SamsungPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.SamsungPromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/samsungMemberText'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/samsungMemberText'), 2)
		}


		//Check SpotifyPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.SpotifyPromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/spotifyPromoImage'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/spotifyPromoImage'), 2)
		}


		//Check ToshibaPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.ToshibaPromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaTVImage'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaTVImage'), 2)
		}


		//Check MenaPromoPage
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.MenaPromoPageUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)
		}





		//Check ShahidMovies
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.ShahidMoviesUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		}

		//Check ShahidMovies Thumbnail
		List<String> Itemslist = CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail','122')
		String ThumbnailXpath= Itemslist[0]
		String ThumbnailName = Itemslist[1]
		TestObject ThumbnailOBJ = WebUI.modifyObjectProperty(findTestObject("Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail"), 'xpath', 'equals', ThumbnailXpath, true)
		WebUI.verifyElementPresent(ThumbnailOBJ, 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail','122')
			WebUI.verifyElementPresent(ThumbnailOBJ, 2)
		}

		//Check ShahidMoviePage
		WebUI.click(ThumbnailOBJ)
		WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		}


		//Check ShahidSeries Thumbnail
		CustomKeywords.'Shahid.NavigateTo'(GlobalVariable.ShahidSeriesUrl)
		WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/MovieScreen/viewNowButton'), 2)
		}

		List<String> ShowItemslist = CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/HomeScreen/Show Thumbnail/showThumbnail','سلسلة')
		String ShowThumbnailXpath= ShowItemslist[0]
		TestObject ShowThumbnailOBJ = WebUI.modifyObjectProperty(findTestObject("Object Repository/HomeScreen/Show Thumbnail/showThumbnail"), 'xpath', 'equals', ShowThumbnailXpath, true)
		WebUI.verifyElementPresent(ShowThumbnailOBJ, 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			CustomKeywords.'Shahid.ScrollUntilElementPresent'('Object Repository/HomeScreen/Show Thumbnail/showThumbnail','سلسلة')
			WebUI.verifyElementPresent(ShowThumbnailOBJ, 2)
		}


		//Check ShahidSeries
		WebUI.click(ShowThumbnailOBJ)
		WebUI.verifyElementPresent(findTestObject('Object Repository/ShowScreen/viewNowButton'), 2)
		for(def i=1;i<=2;i++){
			WebUI.refresh()
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/ShowScreen/viewNowButton'), 2)
		}

		WebUI.closeBrowser()
	}



}