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

import shahid.utils.Shahid


class Show {



	@Given("I want to verify clickable elements in show player for (.*)")
	def verifyClickableElemntsInShowPlayer(String userType) {
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

		WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'))
		WebUI.delay(2)

		//Verify Show Details
		List<String> Itemslist = new Shahid().ScrollUntilElementPresent('Object Repository/HomeScreen/Show Thumbnail/showThumbnail')
		String ThumbnailXpathList= Itemslist[0]
		println ThumbnailXpathList
		String ThumbnailMetaData= Itemslist[1]
		println ThumbnailMetaData
		String ThumbnailMetaDataXpath= Itemslist[2]

		//Show Thumbnail
		TestObject ThumbnailOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/Show Thumbnail/showThumbnail'), 'xpath', 'equals', ThumbnailXpathList, true)
		WebUI.delay(10)
		WebUI.scrollToElement(ThumbnailOBJ, 4)
		WebUI.focus(ThumbnailOBJ)
		WebUI.click(ThumbnailOBJ)


		//		//Take Screenshot
		//		String featureName = getClass().getName()
		//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		//		String methodName = stacktrace[5].getMethodName()
		//		//new Shahid().takeScreenshot(featureName,methodName)

		//ShowPageMetaData to Get Show Title
		WebUI.delay(3)
		String ShowPageShowText = WebUI.getAttribute(findTestObject('Object Repository/ShowScreen/assetTitle'), 'alt')
		WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/showPlus18'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/genreDetails'), 2)
		//WebUI.verifyEqual(ThumbnailMetaData, ShowPageShowText)

		// Verify free episodes only is working
		if (userType !="Subscribed") {
			if(userType == "MobileOnly") {
				WebUI.click(findTestObject('Object Repository/watchNowButton'))
				WebUI.delay(3)
				//WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/freeEpisodes'), 2)
//				WebUI.click(findTestObject('Object Repository/ShowScreen/freeEpisodes'))
//				WebUI.delay(3)
//				WebUI.click(findTestObject('Object Repository/playIconButton'))
//				WebUI.delay(2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/mobileOnlyPlayerTextShow'), 3)
			}
			else
			if(WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/freeEpisodes'), 2)) {
				WebUI.click(findTestObject('Object Repository/ShowScreen/freeEpisodes'))
				WebUI.delay(3)
				if(WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/RelatedSection/episodeSliderElement'),2))
				{ println "this show has free episodes"
					VIPContent=false
				}
				else if(WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/noFreeEpisodesMsg'),2)) {
					println "this show has no free episodes"
					VIPContent=true
				}
			}
			else {VIPContent=true}
		}
		if (userType !="MobileOnly") {
			WebUI.delay(3)
			WebUI.doubleClick(findTestObject('Object Repository/ShowScreen/viewNowButton'))
		
		// Verify Shahid Player
		new Shahid().VerifyShahidPlayer(userType,VIPContent)
		}
		try {
			//Verify switching between seasons
			if(WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/Seasons/showSeasons'), 2)) {

				WebUI.click(findTestObject('Object Repository/ShowScreen/Seasons/showSeasons'))

				List<WebElement> seasonsList = driver.findElements(By.xpath('//div[contains(@class, "ShowView_button-container")]'))
				String ThumbnailXpath= '(//div[contains(@class, "ShowView_button-container")])'

				for(int i=1;i<= seasonsList.size();i++) {

					ThumbnailXpath=ThumbnailXpath+'['+i+']'

					TestObject season = WebUI.modifyObjectProperty(findTestObject('Object Repository/ShowScreen/Seasons/seasonsThumbnail'), 'xpath', 'equals', ThumbnailXpath, true)
					WebUI.click(season)
					WebUI.scrollToElement(findTestObject('Object Repository/ShowScreen/RelatedSection/episodeSection'), 3)

					int numberOfEpisodes= new Shahid().numberOfRelatedItems('Object Repository/ShowScreen/RelatedSection/episodeSliderElement')
					println "Number of Episodes::{{"+numberOfEpisodes+"}}"
					ThumbnailXpath= '(//div[contains(@class, "ShowView_button-container")])'
					WebUI.click(findTestObject('Object Repository/ShowScreen/Seasons/seasonsButton'))

				}
			}

			if (WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/showMore'), 2)) {
				WebUI.click(findTestObject('Object Repository/ShowScreen/showMore'))
				WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/episodeDescription'), 2)
				WebUI.click(findTestObject('Object Repository/ShowScreen/cancelMorePopup'))
			}

			//			Boolean clipsSection=new Shahid().findElement('Object Repository/ShowScreen/RelatedSection/clipsSection')
			//			if(clipsSection){
			//				WebUI.click(findTestObject('Object Repository/ShowScreen/RelatedSection/clipsSection'))
			//							int numberOfClips= new Shahid().numberOfRelatedItems('Object Repository/ShowScreen/RelatedSection/clipsSliderElement')
			//							println "Number of Clips::{{"+numberOfClips+"}}"
			//			}
			//			WebUI.click(findTestObject('Object Repository/ShowScreen/RelatedSection/relatedShowsSection'))
			//					int numberOfRelated= new Shahid().numberOfRelatedItems('Object Repository/ShowScreen/RelatedSection/relatedSliderElement')
			//					println "Number of Related::{{"+numberOfRelated+"}}"
		}catch(Exception e) {
			println"This show"
		}

		WebUI.closeBrowser()


	}
}