package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


import java.text.SimpleDateFormat

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid

class Home {

	@Given("I want to verify Shahid Home Page Elements for (.*)")
	def verifyHomePageElements(String userType) {
		new Shahid().NavigateToShahid()
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType!='Anonymous') {
			if(userType=="Subscribed") {
				new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
			}else if(userType=="Registered") {
				new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
			}else if(userType=="sportsubscribed") {
				new Shahid().shahidLogin(GlobalVariable.sportSubscribedd, GlobalVariable.sportSubPassword)
			}
			WebUI.delay(2)
			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[0].click()
		}


		new Shahid().popupNotification()
		new Shahid().VerifyShahidMainBarComponents(userType)
		WebUI.delay(5)

		if(userType=="Anonymous") {
			WebUI.waitForPageLoad(120)
			WebUI.delay(5)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogoanonymous'), 3)
		}else if(userType=="Subscribed") {
			WebUI.waitForPageLoad(120)
			WebUI.delay(5)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogovip'), 3)
		}else if(userType=="Registered") {
			WebUI.waitForPageLoad(120)
			WebUI.delay(5)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidLogoRegistered'), 3)
		}else if(userType=="sportsubscribed") {
			WebUI.waitForPageLoad(120)
			WebUI.delay(5)
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/shahidlogos/shahidlogovip'), 3)
		}
		//
		//WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/viewNowButton'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/AddToMyListButton'), 2)
		//	WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/showDescriptionText'), 2)
		//				WebUI.verifyElementPresent(findTestObject("Object Repository/HomeScreen/Main Thumbnail/showNoteText"), 0)

		//
		//		if(userType=="Anonymous") {
		//
		//			new Shahid().scrollElementIntoView()
		//			WebUI.delay(5)
		//			WebUI.waitForPageLoad(120)
		//			WebUI.delay(5)
		//			WebUI.mouseOverOffset(findTestObject('HomeScreen/shahidOriginalFirstAsset'), 100, 100)
		//			WebUI.delay(5)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleCompnentMyListButton'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/titleOfTheAsset'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleComponentMyListText'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/timingOfTheShow'), 3)
		//
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/timingOfTheShow'), 3) //here is the type
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleComponentMyListText'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/watchNowButton'), 3)
		//			WebUI.delay(3)
		//			WebUI.click(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleCompnentMyListButton'))
		//			WebUI.delay(3)
		//			WebUI.waitForPageLoad(120)
		//			WebUI.back()
		//			WebUI.waitForPageLoad(120)
		//			WebUI.delay(3)
		//			new Shahid().scrollElementIntoView()
		//			WebUI.mouseOverOffset(findTestObject('HomeScreen/shahidOriginalFirstAsset'), 100, 100)
		//			WebUI.delay(4)
		//			WebUI.click(findTestObject('Object Repository/HomeScreen/bundleComponents/watchNowButton'))
		//			WebUI.waitForPageLoad(120)
		//			WebUI.delay(5)
		//			WebUI.back()
		//			WebUI.waitForPageLoad(120)
		//			WebUI.verifyElementPresent(findTestObject('HomeScreen/shahidOriginalFirstAsset'), 3)
		//		}
		//		if(userType!="Anonymous") {
		//			new Shahid().scrollElementIntoView()
		//			WebUI.delay(5)
		//			WebUI.waitForPageLoad(120)
		//			WebUI.delay(5)
		//
		//
		//			WebUI.mouseOverOffset(findTestObject('HomeScreen/shahidOriginalFirstAsset'), 100, 100)
		//			WebUI.delay(5)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleCompnentMyListButton'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/titleOfTheAsset'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleComponentMyListText'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/timingOfTheShow'), 3)
		//			//WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/timingOfTheShow'), 3) here is the type
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleComponentMyListText'), 3)
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/bundleComponents/watchNowButton'), 3)
		//			WebUI.delay(3)
		//			WebUI.click(findTestObject('Object Repository/HomeScreen/bundleComponents/bundleCompnentMyListButton'))
		//			WebUI.delay(3)
		//			WebUI.click(findTestObject('Object Repository/HomeScreen/bundleComponents/watchNowButton'))
		//			WebUI.delay(5)
		//
		//		}
		//
		//
		//
		//
		//		//Take Screenshot
		//		String featureName = getClass().getName()
		//		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		//		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		//		List<WebElement> numberOfShows = driver.findElements(By.xpath('//img[@alt="PlayIcon"]'))
		//		def b =0
		//		for (def i = 1 ; i <= numberOfShows.size(); i++) {
		//			def Xpath  ='(//img[@alt="PlayIcon"])'+ [i]
		//			TestObject showItem = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/Main Thumbnail/showButton'), 'xpath', 'equals', Xpath, true)
		//			WebUI.verifyElementPresent(showItem, 2)
		//			b++
		//			println b
		//		}
		//
		//		WebUI.verifyEqual(b, numberOfShows.size())
		WebUI.closeBrowser()
	}


	@Given("I want to Check Shahid Home Page Elements Clickable (.*)")
	def verifyHomePageElementsClickable(String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType!='Anonymous') {
			if(userType=="Subscribed") {
				new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
			}else if(userType=="Registered") {
				new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
			}else if(userType=="sportsubscribed") {
				new Shahid().shahidLogin(GlobalVariable.sportSubscribedd, GlobalVariable.sportSubPassword)
			}
			WebUI.delay(2)
			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			UserProfile[0].click()
		}
		new Shahid().popupNotification()
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/homePageLink'))
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/browseLink'))
		println "Allchannels"+ driver.findElements(By.xpath("//div[contains(@class,'gridItemBase')]")).size()
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/browseLink'))
		WebUI.back()
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/moviesLink'))
		WebUI.delay(2)
		WebUI.getUrl().contains('movies')
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/moviesLink'))
		WebUI.back()
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/seriesAndProgramsLink'))
		WebUI.delay(2)
		WebUI.getUrl().contains('series')
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/seriesAndProgramsLink'))
		WebUI.back()
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/liveLink'))
		WebUI.delay(2)
		WebUI.getUrl().contains('livestream')
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/liveLink'))
		WebUI.back()

		WebUI.closeBrowser()
	}


	@Given("I want to Verfiy Live streaming for (.*) with (.*)")
	def verfiyLivestreaming(String userType,String profile) {

		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}

		if(userType!="Anonymous") {
			WebUI.delay(2)
			new Shahid().popupNotification()

			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			if(profile=="Adult") {
				UserProfile[0].click()
			}else if(profile=="Kid") {
				UserProfile[1].click()
			}
		}
		WebUI.delay(2)
		new Shahid().ScrollUntilElementPresent("//h2[contains(@class,'carousel_app-carousel-title') and contains(text(),'Live') or contains(text(),'البث المباشر')]", 2)
		//		new Shahid().ScrollUntilElementPresent("(//span[text()='LIVE'])[1]", 2)
		//		new Shahid().ScrollToText("LIVE")
		//		WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/liveStreaming/Channels'))
		//		WebUI.click(findTestObject('Object Repository/HomeScreen/liveStreaming/Channels'))
		//WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/liveStreaming/channelIcon'), 5)
		List<WebElement> channelsList
		TestObject channelOBJ
		TestObject channelOBJE
		channelsList = driver.findElements(By.xpath("//div[contains(span,'LIVE')]"))

		for(int i=1;i<=channelsList.size();i++) {
			String channelXpath = "(//div[contains(span,'LIVE')])["+i+"]"

			channelOBJ = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/liveStreaming/ChannelModifed'), 'xpath', 'equals', channelXpath, true)
			WebUI.click(channelOBJ)
			WebUI.click(findTestObject('Object Repository/HomeScreen/liveStreaming/LatestEpisodes'))

			if(!(WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/liveStreaming/NoRelatedEpisodes'), 2))) {
				for(int x=1;x<=channelsList.size();x++) {
					String channelXpathE = "(//div[contains(@class,'PlayerPlaylistItem_imageContainer')])["+x+"]"

					channelOBJE = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/liveStreaming/ChannelModifed'), 'xpath', 'equals', channelXpathE, true)
					WebUI.mouseOver(channelOBJE)
					WebUI.scrollToElement(channelOBJE, 2)
				}
			}
			WebUI.click(findTestObject('Object Repository/HomeScreen/liveStreaming/AllChannelTab'))
			WebUI.scrollToElement(channelOBJ, 2)
		}

		WebUI.closeBrowser()
	}


	@Given("I want to check five minutes label for (.*)")
	def verifyFiveMinutesLabel(String userType) {

		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}

		if(userType!="Anonymous") {
			WebUI.delay(2)
			new Shahid().popupNotification()
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))

			UserProfile[0].click()

		}else {
			WebUI.delay(2)
			new Shahid().popupNotification()

		}

		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/CommonElements/liveLink'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/liveStreaming/channelIcon'), 5)
		WebUI.click(findTestObject('Object Repository/HomeScreen/liveStreaming/channelIcon'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/liveStreaming/FreePreviewWindow'), 5)

		if(userType!="Subscribed") {
			WebUI.click(findTestObject('Object Repository/thirdChannelClick'))
			WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/liveStreaming/LiveStreamTimer'), 5)
		}
		WebUI.delay(2)

		WebUI.closeBrowser()
	}

	@Given("I want to verify cw (.*)")
	def verifyCW(String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(9)


		new Shahid().ScrollUntilElementPresent("//h2[contains(@class,'carousel_app-carousel-title') and contains(text(),'Continue Watching') or contains(text(),'متابعة المشاهدة')]", 0)
		WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)


		new Shahid().ScrollUntilElementPresent('//h2[text()=\'Continue Watching\']//following::div[contains(@class,\'Slider_item\')][1]', 0)
		WebUI.delay(2)
		WebElement CWCarousel = driver.findElement(By.xpath('//h2[text()=\'Continue Watching\']//following::div[contains(@class,\'Slider_slider__container\')][1]'))

		List<WebElement> assetList= CWCarousel.findElements(By.xpath('//h2[text()=\'Continue Watching\']//following::div[contains(@class,\'Slider_item\')]'))
		println "asset list  "+ assetList.size()
		String videoLink='//h2[text()=\'Continue Watching\']//following::div[contains(@class,\'Slider_item\')]['
		Actions actions = new Actions(driver)

		for (int i=1; i < assetList.size(); i++) {
			//			new Shahid().ScrollUntilElementPresent("//h2[contains(@class,'carousel_app-carousel-title') and contains(text(),'Continue Watching') or contains(text(),'متابعة المشاهدة')]", 0)
			//			WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)
			//			new Shahid().ScrollUntilElementPresent('(//div[contains(@class,"item_Progress")])', 0)


			videoLink= videoLink+i+']'
			TestObject video = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/CW/CWThumbnail'), 'xpath', 'equals', videoLink, true)
			//actions.moveToElement(asset).perform()

			WebUI.mouseOver(video)
			WebUI.delay(2)

			String detailsText=WebUI.getText(findTestObject('Object Repository/HomeScreen/CW/showDetails'))
			println detailsText
			//	asset.click()
			WebUI.click(video)
			WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'), 4)
			WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))

			WebUI.delay(2)
			String time=WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'))
			List<String> timeList = time.split("\n")
			String watchTime=timeList.get(1)
			String realTime="0:02:00"
			if(!WebUI.getUrl().contains("movies")) {
				watchTime="0:"+watchTime
			}
			println watchTime

			SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss")
			Date d1 = sdf.parse(watchTime)
			Date d2 = sdf.parse(realTime)
			boolean result= d2.getTime() < d1.getTime()

			String name=WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/playerScreenText'))
			println name
			String info=WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/Info'))
			//	if(WebUI.getUrl().contains("movies")) {
			//		 boolean sameTitle=name.contains(name)
			//	}else

			WebUI.delay(2)
			if(!WebUI.getUrl().contains("movies")) {
				//boolean sameTitle=name.contains(name)
				boolean sameSeason=info.equals(detailsText)
			}

			WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/exitVideo'))
			WebUI.click(findTestObject('Object Repository/HomeScreen/mainHeaderLink'))
			WebUI.delay(2)

			WebUI.waitForElementPresent(findTestObject('HomeScreen/searchButton'), 6)
			WebUI.click(findTestObject('HomeScreen/searchButton'))
			WebUI.waitForElementPresent(findTestObject('Search/searchFiled'), 4)
			WebUI.setText(findTestObject('Search/searchFiled'), name)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchResultContainer'), 9)
			WebUI.delay(4)

			WebUI.focus(findTestObject('Object Repository/Search/assetSearch'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/CW/CWAssetButton'), 4)

			WebUI.click(findTestObject('Object Repository/Search/closeButton'))
			WebUI.delay(4)
			WebUI.click(findTestObject('Object Repository/HomeScreen/mainHeaderLink'))
			WebUI.delay(2)
			new Shahid().popupNotification()
			videoLink='(//div[contains(@class,"item_Progress")])['

		}
	}



	@Given("I want to check Top 10 as (.*)")
	def checkTop10as(String userType) {

		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		if(userType=="Subscribed") {
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}

		if(userType!="Anonymous") {
			WebUI.delay(2)
			new Shahid().popupNotification()

			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
			List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
			//			if(profile=="Adult") {
			UserProfile[0].click()
			//			}else if(profile=="Kid") {
			//				UserProfile[1].click()
			//			}
		}



		WebUI.delay(2)
		new Shahid().ScrollUntilElementPresent("//img[@alt='topRan']", 2)

		WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/top10/top10Carousel'),3)

		WebUI.delay(3)
		List<WebElement> top10CarouselItems=driver.findElements(By.xpath("//img[@alt='topRan']"))



		println "carouselItems.size()"+top10CarouselItems.size()

		if(top10CarouselItems.size()==10) {
			KeywordUtil.markPassed("top 10 carousel have 10 assets")
		}else {
			KeywordUtil.markErrorAndStop("top 10 carousel haven't 10 assets")
		}

		//		WebUI.closeBrowser()
	}
}
