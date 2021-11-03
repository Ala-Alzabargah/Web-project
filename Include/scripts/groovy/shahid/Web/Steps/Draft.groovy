package shahid.Web.Steps;


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.xmlbeans.UserType
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import internal.GlobalVariable
import java.text.SimpleDateFormat
import shahid.utils.Shahid

class Draft {

	@Given("Verify Deleting Profiles")
	def verifyDeletingProfiles() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))
		List<WebElement> UserProfileList = driver.findElements(By.xpath("//div[contains(@class,'profile-item')]"))
		String UserProfile="//div[contains(@class,'profile-item')]"
		println "UserProfile "+ UserProfile
		println "UserProfile list "+ UserProfileList

		for (int i=UserProfileList.size(); i > 0; i--) {

			UserProfile=UserProfile+'['+i+']'
			println UserProfile
			TestObject UserProfileNumber = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/Show Thumbnail/showThumbnail'), 'xpath', 'equals', UserProfile, true)
			WebUI.click(UserProfileNumber)

			if( i==1 || i==2) {
				WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 2)
				WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
				println "this is a primary profile should not be deleted"
			}else {
				WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))
				WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deletePopupButton'),2)
				WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupButton'))
				WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 10)
			}
			UserProfile="//div[contains(@class,'profile-item')]"
		}
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
	}

	@Given("Verify Adding Five Profiles")
	def verifyAdding5Profiles() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		String profileType
		String profileName
		int remainsProfiles = 5 - driver.findElements(By.xpath("//p[contains(@class,'profile-name')]")).size()
		println "remainsProfiles "+ remainsProfiles
		for (int i = 0; i <= remainsProfiles; i++) {
			if (i % 2 == 0) {
				profileType = "Adult"
			} else {
				profileType = "Kids"
			}
			if (WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/addNewProfile'), 3)) {
				WebUI.click(findTestObject('Object Repository/UserProfile/addNewProfile'))
				WebUI.click(findTestObject('Object Repository/UserProfile/addProfileAvatar'))
				new Shahid().selectAvatar(driver)
				profileName = new Shahid().getRandomName(profileType)
				WebUI.sendKeys(findTestObject('Object Repository/UserProfile/enterNameField'), profileName)
				if (profileType == "Kids") {
					WebUI.click(findTestObject('Object Repository/UserProfile/KidsModeToggle'))
					WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'))
					new Shahid().setKidsAge()
				}
				WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))
				WebUI.delay(2)
				println "i "+i
				println "remainsProfiles after adding"+ remainsProfiles
			}
			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 10)
			WebUI.delay(2)
		}

		WebUI.closeBrowser()
	}


	@Given("I want to verify cw2 (.*)")
	def verifyCW2(String userType) {
		new Shahid().NavigateToShahid()

		WebDriver driver = DriverFactory.getWebDriver()

		new Shahid().shahidLogin(GlobalVariable.dinaUser, GlobalVariable.dinaPassword)

		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
		UserProfile[0].click()
		WebUI.delay(5)

		new Shahid().ScrollUntilElementPresent("//h2[contains(@class,'carousel_app-carousel-title') and contains(text(),'Continue Watching') or contains(text(),'متابعة المشاهدة')]", 0)
		WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)
		new Shahid().ScrollUntilElementPresent('(//div[contains(@class,"item_Progress")])', 0)
		WebUI.delay(2)
		List<WebElement> assetList= driver.findElements(By.xpath('(//div[contains(@class,"item_Progress")])'))
		println "asset list  "+ assetList.size()
		String videoLink='(//div[contains(@class,"item_Progress")])['
		Actions actions = new Actions(driver)


		for (int i=1; i < assetList.size(); i++) {
			new Shahid().ScrollUntilElementPresent("//h2[contains(@class,'carousel_app-carousel-title') and contains(text(),'Continue Watching') or contains(text(),'متابعة المشاهدة')]", 0)
			WebUI.scrollToElement(findTestObject('Object Repository/HomeScreen/CW/CWCarouselTitle'), 3)
			new Shahid().ScrollUntilElementPresent('(//div[contains(@class,"item_Progress")])', 0)


			videoLink= videoLink+i+']'
			TestObject video = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/CW/CWThumbnail'), 'xpath', 'equals', videoLink, true)
			//actions.moveToElement(asset).perform()


			WebUI.mouseOver(video)

			WebUI.delay(2)

			String detailsText=WebUI.getText(findTestObject('Object Repository/HomeScreen/CW/textss'))
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


	@Given("I want to Check Shahid Home Page Elements for Subscribed Users hhhhhh")
	def I_want_to_Check_Shahid_Home_Page_Elements_for_Subscribed_Users() {
		new Shahid().NavigateToShahid()
		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)
		WebUI.refresh()
		new Shahid().VerifyShahidMainBarComponents('Subscribed')

		//Verify Main Thumbnail
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/itemImage'), 2)

		//		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/showInfoText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/viewNowButton'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/AddToMyListButton'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/Main Thumbnail/showDescriptionText'), 2)

		//		WebUI.verifyElementPresent(findTestObject("Object Repository/HomeScreen/Main Thumbnail/showNoteText"), 0)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		def numberOfShows = 4
		def b =0
		for (def i = 1 ; i <= numberOfShows; i++) {
			def Xpath  ='(//button[@type="button"])'+ [i]
			TestObject showItem = WebUI.modifyObjectProperty(findTestObject('Object Repository/HomeScreen/Main Thumbnail/showButton'), 'xpath', 'equals', Xpath, true)
			WebUI.verifyElementPresent(showItem, 2)
			b++
			println b
		}

		WebUI.verifyEqual(b, numberOfShows)
		WebUI.closeBrowser()
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Suspended Subscribed User
	@Given("I want to Verify Parental control interface For Suspended Subscribed User")
	def I_want_to_Verify_Parental_Control_Interface_For_Suspended_Subscribed_User(){
		for (def i = 1 ; i <= 4; i++) {
			def Xpath  ='(//input[@class="_18Ti-FoR9yWcTVsg3rVP41"])'+ [i]
			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/Parental control interface/codeDigitField'), 'xpath', 'equals', Xpath, true)
			String digitNumber= WebUI.getAttribute(digit, 'value')
			println "{{{{{{"+digitNumber+"}}}}}}"
			WebUI.verifyEqual(digitNumber,codeDigits[y].toString())
			println "digitNumber"+digitNumber + "==" + "codeDigits{"+ y +"}"+codeDigits[y]
			y++
		}

		WebUI.closeBrowser()
	}









	//Cancelled Subscribed User
	@Given("I want to Verify View previous operations Screen For Cancelled Subscribed User")
	def I_want_to_Verify_View_previous_operations_Screen_For_Cancelled_Subscribed_User() {
		new Shahid().NavigateToShahid()
		new Shahid().shahidLogin(GlobalVariable.CancelledUser, GlobalVariable.CancelledUserpassword)
		WebUI.delay(2)
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()
		WebUI.delay(2)


		WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
		WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"))

		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/Settings Screen/Account Settings Screen/previousOperations'))
		WebUI.delay(2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/Settings Screen/previousOperationsSection/previousOperationsText"), 2)

		String noPreviousOperationsText='Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText'
		//		boolean condition = WebUI.verifyElementNotPresent(findTestObject(noPreviousOperationsText), 0,FailureHandling.CONTINUE_ON_FAILURE)
		Boolean FEcondition = new Shahid().findElement(noPreviousOperationsText)
		if(FEcondition){
			WebElement PreviousOperationsList= driver.findElement(By.tagName("ul"));
			List<WebElement> PreviousOperationsItem = PreviousOperationsList.findElements(By.tagName("li"))
			int Listsize=PreviousOperationsItem.size()

			println  '{{{{{{'+Listsize+'}}}}}}'

			for (def i = 1 ; i <=Listsize ; i++) {

				def Xpath  ="(//li[@class='_1ndiA-3Gch8J8-Ww4Sw9Zg'])"+ [i]
				TestObject listItem = WebUI.modifyObjectProperty(findTestObject('Object Repository/Settings Screen/previousOperationsSection/previousOperationItem'), 'xpath', 'equals', Xpath, true)
				WebUI.verifyElementPresent(listItem, 0)
				String itemText= WebUI.getText(listItem)
				print itemText


			}


		}else{
			WebUI.verifyElementPresent(findTestObject("Object Repository/Settings Screen/previousOperationsSection/noPreviousOperationsText"), 2)
			println  '{{{{{{{{{{alaa}}}}}}}}}'
		}

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.closeBrowser()

	}






}



