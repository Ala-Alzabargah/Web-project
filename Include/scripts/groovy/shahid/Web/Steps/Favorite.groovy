package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import internal.GlobalVariable
import shahid.utils.Shahid

class Favorite {

	@Given("I want to Verify Empty Favorite Page (.*)")
	def verifyEmptyFavoritePage(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(5)

		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListTitleText'),4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
		//		new Shahid().verifyFooterElements()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.closeBrowser()
	}

	@Given("I want to Add Asset To Favorite from Home Page (.*)")
	def AddAssetToFavoriteFromHomePage(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(4)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		new Shahid().popupNotification()
		String ThumbnailMetaData= WebUI.getAttribute((findTestObject('Object Repository/MovieScreen/assetTitle')), 'alt')
		println "name--> "+ThumbnailMetaData

		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MoviesSection/HomePage/addToFavButton'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))

		TestObject MetaDataOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "//img[contains(@alt,'"+ThumbnailMetaData+"')]", true)
		List<String> name= ThumbnailMetaData.split("،")
		String part1=name.get(0)
		println "part1--> "+ part1

		TestObject MetaDataOBJ2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "//img[contains(@alt,\""+part1+"\")]", true)
		WebUI.delay(3)
		WebUI.focus(MetaDataOBJ2)
		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
		WebUI.refresh()

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListTitleText'),4)

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)){
			WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
		}
		if(WebUI.waitForElementPresent(MetaDataOBJ2, 4)) {
			WebUI.focus(MetaDataOBJ2)
			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)
			WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
		}
		WebUI.closeBrowser()
	}

	@Given("I want to Add (.*) To Favorite from Movie and Show Pages for (.*)")
	def verifyAddMovieToFavoriteFromMoviePage(String assetType, String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType!="Anonymous") {
			if(userType=="Subscribed") {
				new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
			}else if(userType=="Registered") {
				new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
			}
			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[0].click()
			WebUI.delay(5)}
		if (assetType== "movies") {
			WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'))
		}else {
			new Shahid().popupNotification()
			WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'))
		}
		WebUI.delay(2)
		//Verify Movie/Shows Details
		List<String> Itemslist =new Shahid().ScrollUntilElementPresent('Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail')
		String ThumbnailXpath= Itemslist[0]
		println ThumbnailXpath

		//Movie Thumbnail
		TestObject ThumbnailOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail'), 'xpath', 'equals', ThumbnailXpath, true)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.delay(3)

		WebUI.focus(ThumbnailOBJ)
		WebUI.click(ThumbnailOBJ)
		WebUI.delay(3)

		String ThumbnailMetaData= WebUI.getAttribute((findTestObject('Object Repository/MovieScreen/assetTitle')), 'alt')
		println "name--> "+ThumbnailMetaData

		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MoviesSection/HomePage/addToFavButton'))

		if(userType=="Anonymous") {
			
			WebUI.waitForElementPresent(findTestObject('LoginScreen/usernameField'), 4)
			WebUI.setText(findTestObject('LoginScreen/usernameField'), GlobalVariable.TeamUser)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 3)
			WebUI.waitForElementNotPresent(findTestObject('LoginScreen/passwordField'),8)
			WebUI.setEncryptedText(findTestObject('LoginScreen/passwordField'),GlobalVariable.TeamUserPassword)
		    WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[0].click()
			WebUI.delay(3)
			new Shahid().popupNotification()
			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))
			WebUI.closeBrowser()
		}
		else {
			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))

			TestObject MetaDataOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "//img[contains(@alt,'"+ThumbnailMetaData+"')]", true)
			List<String> name= ThumbnailMetaData.split("،")
			String part1=name.get(0)
			println "part1--> "+ part1
			TestObject MetaDataOBJ2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "(//img[contains(@alt,'"+part1+"')])[2]", true)
			WebUI.delay(3)
			WebUI.verifyElementPresent(MetaDataOBJ2, 5)
			WebUI.focus(MetaDataOBJ2)
			WebUI.click(MetaDataOBJ2)

			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
			//Take Screenshot
			//new Shahid().takeScreenshot(featureName,methodName)

			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListTitleText'),4)

			if(WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)){
				WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
			}
			if(WebUI.waitForElementPresent(MetaDataOBJ2, 4)) {
				WebUI.focus(MetaDataOBJ2)
				WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
				WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)
				WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
			}
		}
		WebUI.closeBrowser()
	}

	@Given("Verify Empty Favorite Page in Kids Profile (.*)")
	def verifyAddMovieToFavoriteFromMoviePage(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType!="Anonymous") {
			if(userType=="Subscribed") {
				new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
			}else if(userType=="Registered") {
				new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
			}
			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[1].click()
			WebUI.delay(5)}
		new Shahid().popupNotification()
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)
		new Shahid().popupNotification()
		String ThumbnailMetaData= WebUI.getAttribute((findTestObject('Object Repository/MovieScreen/assetTitle')), 'alt')
		println "name--> "+ThumbnailMetaData

		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MoviesSection/HomePage/addToFavButton'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'))

		TestObject MetaDataOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "//img[contains(@alt,'"+ThumbnailMetaData+"')]", true)
		List<String> name= ThumbnailMetaData.split("،")
		String part1=name.get(0)
		println "part1--> "+ part1

		TestObject MetaDataOBJ2 = WebUI.modifyObjectProperty(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/ShowTitle'), 'xpath', 'equals', "//img[contains(@alt,'"+part1+"')]", true)
		WebUI.delay(3)
		WebUI.focus(MetaDataOBJ2)
		WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
		WebUI.refresh()

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListTitleText'),4)

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)){
			WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
		}
		if(WebUI.waitForElementPresent(MetaDataOBJ2, 4)) {
			WebUI.focus(MetaDataOBJ2)
			WebUI.click(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/favoriteButton'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/nothingInTheListText'), 4)
			WebUI.waitForElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/addtoMyListButton'), 4)
		}
		WebUI.closeBrowser()
	}
}