package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid

class Movie {

	@Given("I want to verify clickable elements in movie player for (.*)")
	def verifyClickableElemntsInMoviePlayer(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		Boolean	VIPContent=false
		if(userType!="Anonymous"){

			if(userType=="Subscribed") {
				new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
			}
			else if(userType=="Registered") {
				new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
			}
			else if(userType=="sportsubscribed") {
				new Shahid().shahidLogin(GlobalVariable.sportSubscribedd, GlobalVariable.sportSubPassword)
			}
			else if(userType=="MobileOnly") {
				new Shahid().shahidLogin(GlobalVariable.mobileOnlyAccount, GlobalVariable.mobileOnlyPassword)
			}

			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[0].click()
			WebUI.delay(5)
		}
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'))
		WebUI.delay(2)

		//Verify Movie Details
		List<String> Itemslist =new Shahid().ScrollUntilElementPresent('Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail')
		String ThumbnailXpath= Itemslist[0]
		println ThumbnailXpath
		String ThumbnailMetaData= Itemslist[1]
		println ThumbnailMetaData
		String ThumbnailMetaDataXpath= Itemslist[2]

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		//Movie Thumbnail
		TestObject ThumbnailOBJ = WebUI.modifyObjectProperty(findTestObject("Object Repository/HomeScreen/Movie Thumbnail/MovieThumbnail"), 'xpath', 'equals', ThumbnailXpath, true)
		WebUI.scrollToElement(ThumbnailOBJ, 4)
		WebUI.delay(2)
		WebUI.focus(ThumbnailOBJ)
		WebUI.click(ThumbnailOBJ)

		VIPContent=WebUI.waitForElementPresent(findTestObject('Object Repository/MovieScreen/VIPContent'), 3)
		WebUI.delay(2)
		WebUI.doubleClick(findTestObject('Object Repository/MovieScreen/viewNowButton'))

		//verify MainBar Components
		new Shahid().VerifyShahidMainBarComponents(userType)

		if(userType=='Subscribed') {

			//MoviePageMetaData to Get Movie Title From Movie Pages
			String MoviePageMovieTitle = WebUI.getAttribute(findTestObject('MovieScreen/movieMetaData'), 'alt')
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/MovieScreen/moviePlus18'), 2)
			WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/genreDetails'), 2)
			//WebUI.verifyEqual(ThumbnailMetaData, MoviePageMovieTitle)

			// Verify Shahid Player
			new Shahid().VerifyShahidPlayer(userType,VIPContent)
		}

		if(userType=="MobileOnly") {
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/mobileOnly/mobileOnlyPlayerText'), 3)
		}


		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		//Verify Related Section
		try {
			WebUI.waitForElementPresent(findTestObject('MovieScreen/RelatedSection/relatedMoviesText'), 2)
			//		int numberOfRelatedMovies= new Shahid().numberOfRelatedItems('Object Repository/MovieScreen/RelatedSection/sliderElement')

			//		println "numberOfRelatedMovies:::"+numberOfRelatedMovies
		}catch(Exception e) {

			println "Exception:: "+e
			println"This show"
		}
		WebUI.closeBrowser()
	}
}