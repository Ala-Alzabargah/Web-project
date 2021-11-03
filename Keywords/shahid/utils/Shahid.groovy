package shahid.utils;


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.time.StopWatch
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
import org.frontendtest.components.ImageComparison
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords

import ch.qos.logback.core.status.Status
import internal.GlobalVariable





class Shahid {

	protected WebDriver driver

	@Keyword
	def takeScreenshot(String featureName,String fullMethodName){
		String authName =System.getProperty("user.name")
		String picName
		def date = new Date()
		def sdf = new SimpleDateFormat("|MM-d-yyyy HH-mm-ss")
		String currentDate= sdf.format(date)
		def sdf1 = new SimpleDateFormat("|MM-d-yyyy")
		String currentDateWithoutTime= sdf1.format(date)
		String replaceName=fullMethodName.replaceAll('_',' ')
		String[] splitName
		if (replaceName.contains("'I want to '")) {
			splitName = replaceName.split('I want to ')
			picName=splitName[1]
		}else {
			picName = replaceName
		}

		String browserName= DriverFactory.getExecutedBrowser().getName()
		String[] splitfeatureName = featureName.split('shahid.Web.Steps.')
		WebUI.delay(1)
		WebUI.takeScreenshot(GlobalVariable.ScreenShotsFolderPath+'/'+"katalon-web-automation"+'/'+currentDateWithoutTime+'/'+splitfeatureName[1]+'/'+fullMethodName+'/'+authName+'/'+browserName+'/'+picName+currentDate+'.png')
	}

	@Keyword
	def switchLanguage(){

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/loginLink'), 3)){
			WebUI.click(findTestObject('Object Repository/Switch Language/mainBarSwitchLanguageOption'))
		}else{
			WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'))

			WebUI.click(findTestObject('Object Repository/Switch Language/settingSwitchLanguageLink'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/Switch Language/changelanguageTitle'), 7)

			WebUI.click(findTestObject('Object Repository/Switch Language/settingSwitchlanguageOption'))

			WebUI.click(findTestObject('Object Repository/Switch Language/saveButton'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/Switch Language/languageUpdatedSuccessfullyMessage'), 7)
		}
	}

	@Keyword
	def selectAvatar(WebDriver driver){

		String generalAvatarXpath = findTestObject('Object Repository/UserProfile/generalAvatarPath').findPropertyValue("xpath")
		List<WebElement> avatarList = driver.findElements(By.xpath(generalAvatarXpath))
		int avatarListsize=avatarList.size()
		int AvatarNumber = RandomStringUtils.random(1,false,true)

		if(AvatarNumber<=0|| AvatarNumber>avatarListsize || AvatarNumber ==5 || AvatarNumber ==6){
			AvatarNumber =8
		}

		String avatarXpath=generalAvatarXpath+[AvatarNumber]
		println "avatarXpath:: "+avatarXpath
		TestObject avatar =WebUI.modifyObjectProperty(findTestObject('UserProfile/profile1alaa'), 'xpath', 'equals', avatarXpath, true)
		String Avatar6 =avatar.findProperty('src')
		WebUI.delay(2)
		WebUI.mouseOver(avatar)
		WebUI.click(avatar)

		println "AvatarNumber:: "+AvatarNumber
	}

	@Keyword
	public def updateParentalControlCode(String newCode,String userType){
		Sheet sheet

		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
		String currentDate= sdf.format(date)

		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		if(userType.equals("VIP")) {
			sheet = workbookXLS.getSheet("VIP")
		}else if(userType.equals("Registered")) {
			sheet = workbookXLS.getSheet("Registered")
		}
		ExcelKeywords.setValueToCellByAddress(sheet, 'A2', newCode)
		ExcelKeywords.setValueToCellByAddress(sheet, 'B2', currentDate)

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)
	}

	@Keyword
	public String getParentalControlCode(String userType){
		Sheet sheet
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
		if(userType.equals("VIP")) {
			sheet = workbookXLS.getSheet("VIP")
		}else if(userType.equals("Registered")) {
			sheet = workbookXLS.getSheet("Registered")
		}

		return ExcelKeywords.getCellValueByAddress(sheet, 'A2')
	}

	@Keyword
	public String getUserProfileName(String profileType,int columnNUm = 2){


		String name
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)

		Sheet sheet = workbookXLS.getSheet("userprofilename")

		if(profileType.equals("Adult")) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'A'+columnNUm)
		}else if(profileType.equals("Kid")) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'C'+columnNUm)
		}

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)
		println "getUserProfileName:: "+name
		return name
	}

	@Keyword
	public def changeUserTypeTo(String profileType,int columnNUm = 2,int KidcolumnNUm=2){
		String name
		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
		String currentDate= sdf.format(date)
		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)

		Sheet sheet = workbookXLS.getSheet("userprofilename")

		if(profileType.equals("Adult")) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'C'+columnNUm)
			ExcelKeywords.setValueToCellByAddress(sheet, 'C'+columnNUm, " ")
			ExcelKeywords.setValueToCellByAddress(sheet, 'D'+columnNUm, currentDate)
			ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columnNUm, name)
			ExcelKeywords.setValueToCellByAddress(sheet, 'B'+columnNUm, currentDate)
		}else if(profileType.equals("Kid")) {
			name = ExcelKeywords.getCellValueByAddress(sheet, 'A'+columnNUm)
			ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columnNUm, " ")
			ExcelKeywords.setValueToCellByAddress(sheet, 'B'+columnNUm, currentDate)
			ExcelKeywords.setValueToCellByAddress(sheet, 'C'+KidcolumnNUm, name)
			ExcelKeywords.setValueToCellByAddress(sheet, 'D'+KidcolumnNUm, currentDate)
		}

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)

	}

	@Keyword
	public String getRandomName(String profileType,int columnNUm = 2){

		//currentDate
		def date = new Date()
		def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
		String currentDate= sdf.format(date)

		ResponseObject nameRes = WS.sendRequest(findTestObject('Object Repository/randomName'))
		//control json
		def slurper = new groovy.json.JsonSlurper()
		def nameResBody = slurper.parseText(nameRes.getResponseBodyContent())

		Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)

		Sheet sheet = workbookXLS.getSheet("userprofilename")

		if(profileType.equals("Adult")) {
			ExcelKeywords.setValueToCellByAddress(sheet, 'A'+columnNUm, nameResBody.get(0))
			ExcelKeywords.setValueToCellByAddress(sheet, 'B'+columnNUm, currentDate)
		}else if(profileType.equals("Kid")) {
			ExcelKeywords.setValueToCellByAddress(sheet, 'C'+columnNUm, nameResBody.get(0))
			ExcelKeywords.setValueToCellByAddress(sheet, 'D'+columnNUm, currentDate)
		}

		ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)

		println "getRandomName:: "+nameResBody.get(0)
		return nameResBody.get(0)
	}

	@Keyword
	def clickOnSettings(){
		def a=1
		for (def i = 0; i <a; i++) {
			String homePage=WebUI.getUrl()
			WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'))
			//			WebUI.click(findTestObject("Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink"), FailureHandling.CONTINUE_ON_FAILURE)
			Boolean FEcondition = new Shahid()findElement('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink')
			if(FEcondition){
				WebUI.click(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/accountSettingsLink'))
			}

			String currentPage=WebUI.getUrl()
			if (homePage == currentPage ) {
				a++
			}
		}
	}

	@Keyword
	def findElement(String Xpath) throws Exception {
		Boolean condition= true

		try {
			WebUI.verifyElementPresent(findTestObject(Xpath), 3)
		}
		catch (Exception e) {
			System.out.println(e.getCause())
			condition= false
		}

		return condition
	}


	@Keyword
	def public generateNewUser() {
		return RandomStringUtils.random(10, false, true) +'@automationtest.com'
	}

	@Keyword
	def public randomName() {
		ResponseObject nameRes = WS.sendRequest(findTestObject('Object Repository/randomName'))
		//control json
		def slurper = new groovy.json.JsonSlurper()
		def nameResBody = slurper.parseText(nameRes.getResponseBodyContent())

		return nameResBody.get(0)
	}

	@Keyword
	void addGlobalVariable(String name, def value) {
		GroovyShell shell1 = new GroovyShell()
		MetaClass mc = shell1.evaluate("internal.GlobalVariable").metaClass
		String getterName = "get" + name.capitalize()
		mc.'static'."$getterName" = { -> return value }
		mc.'static'."$name" = value
	}


	@Keyword
	public static void compare (String Image1, String Image2) throws IOException {



		String imgOriginal = Image1
		String imgToCompareWithOriginal = Image2
		String imgOutputDifferences = WebUI.takeScreenshot('/Users/admin/git/ScreenShots')

		ImageComparison imageComparison = new ImageComparison(10,10,0.05);

		if(imageComparison.fuzzyEqual(imgOriginal,imgToCompareWithOriginal,imgOutputDifferences))
			System.out.println("Images are fuzzy-equal.");
		else
			System.out.println("Images are not fuzzy-equal.");
	}


	@Keyword
	def ScrollToText(String x) {

		TestObject new_value = WebUI.modifyObjectProperty(findTestObject('Object Repository/Others/textScrollTo'), 'text', 'equals', x, true)
		Thread.sleep(2000)
		WebUI.scrollToElement(new_value , 2)
		println new_value
	}


	@Keyword
	def VerifyFirstThumbnial (APIResponse) {
		String temp2 = APIResponse.getResponseText()
		String[] temp3 = temp2.split(",");
		String temp4 = temp3 [8]
		String [] temp5 = temp4.split(":");
		String APIContentTitle =  temp5 [1]
		WebUI.mouseOver(findTestObject('Categories/Shared Categories Objects/firstContentThumbnail'))
		String FirstThumbnailText = WebUI.getText(findTestObject('Categories/Shared Categories Objects/firstContentThumbnail'))
		String[] temp9 = FirstThumbnailText.split("\n");
		String UIFirstThumbnailTitle = temp9[0]
		WebUI.verifyEqual('"'+UIFirstThumbnailTitle+'"', APIContentTitle)
	}


	@Keyword
	boolean isEmailValid(String email) {
		String  emailPattern = /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[A-Za-z]{2,4}/
		return email ==~ emailPattern
	}


	@Keyword
	def VerifyLoginPage(){
		WebUI.delay(1)
		//WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/loginPage/anAccountIsRequiredText'), 'مطلوب حساب للاستمرار بعملية الاشتراك')
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/anAccountIsRequiredText'),2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/shahidAccountDescriptionText'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/enterEmailDescriptionText'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/emailField'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/submitButton'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/facebookLoginButton'), 2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/googleLoginButton'), 2)
		//WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/reCAPTCHAText'), 'هذا الموقع محمي من خلال reCAPTCHA لمعرفة المزيد يمكنك زيارة سياسة الخصوصية لدى جوجل و تطبق شروط الخدمة')
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/loginPage/reCAPTCHAText'),2)
		WebUI.back()
	}


	@Keyword
	def List<String> ScrollUntilElementPresent(String ObjectRepositoryPath,int asset=1) {


		println "ObjectRepositoryPath:: "+ObjectRepositoryPath
		WebDriver driver = DriverFactory.getWebDriver()
		List<String> Itemslist
		String assetXpath
		if(asset==1) {
			assetXpath= GlobalVariable.assetXpath
		}else {
			assetXpath= ObjectRepositoryPath
		}


		for (int retries = 0;; retries++)
			try {
				driver.findElement(By.xpath(assetXpath))

				if(asset==1) {
					//GetItemName
					TestObject toUpdateXpath = WebUI.modifyObjectProperty(findTestObject(ObjectRepositoryPath), 'xpath', 'equals', assetXpath, true)
					String itemName= WebUI.getAttribute(toUpdateXpath, 'alt')
					Itemslist = [
						assetXpath,
						itemName,
						assetXpath
					]
				}
				return Itemslist

			}
			catch (Exception x) {
				if (retries < 800) {
					scrollElementIntoView()
					continue;
				} else {
					throw x
				}
			}
	}

	@Keyword
	def  scrollElementIntoView() {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("javascript:window.scrollBy(350,300)")
	}


	@Keyword
	def  scrollFooterView() {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = (JavascriptExecutor) driver
		js.executeScript("javascript:window.scrollBy(500,500)")
	}

	@Keyword
	def String GetItemName(String ObjectRepositoryPath,String name){
		String Xpath='//img[contains(@alt,"'+ name+'")]'
		TestObject toUpdateXpath = WebUI.modifyObjectProperty(findTestObject(ObjectRepositoryPath), 'xpath', 'equals', Xpath, true)
		String itemName= WebUI.getAttribute(toUpdateXpath, 'alt')

		return itemName
	}


	@Keyword
	def popupNotification(){

		if(WebUI.waitForElementPresent(findTestObject('Object Repository/iframePOPup'), 6)){
			WebUI.switchToFrame(findTestObject('Object Repository/iframePOPup'), 6)
			if(WebUI.waitForElementPresent(findTestObject('Object Repository/popupNot/popup'), 6)){
				WebUI.click(findTestObject('Object Repository/popupNot/closePopup'))
			}}
		WebUI.switchToDefaultContent()

	}


	@Keyword
	def VerifyRankingSection() {
		String PageUrl = WebUI.getUrl()
		switch (PageUrl) {
			case 'https://shahid.mbc.net/ar/foxcinema' :
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/rankingText'), 'الترتيب')
				WebUI.click(findTestObject('Object Repository/Categories/FOX/FOX Cinema Page/rankingButton'))
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/newToOld'), 'الأحدث إلى الأقدم')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'), 'الأقدم إلى الأحدث')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/A-Z'),'أ - ي')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/Z-A'), 'ي - أ')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisMonth'), 'الأشهر هذا الشهر')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisWeek'), 'الأشهر هذا الأسبوع')
				break
			default:
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/rankingText'), 'الترتيب')
				WebUI.click(findTestObject('Categories/Shared Categories Objects/Ranking/rankingButton'))
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/newToOld'), 'الأحدث إلى الأقدم')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/oldToNew'), 'الأقدم إلى الأحدث')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/A-Z'),'أ - ي')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/Z-A'), 'ي - أ')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisMonth'), 'الأشهر هذا الشهر')
				WebUI.verifyElementText(findTestObject('Categories/Shared Categories Objects/Ranking/mostPopularThisWeek'), 'الأشهر هذا الأسبوع')
				break
		}
	}


	@Keyword
	def VerifyShahidMainBarComponents(String UserCondition) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/searchIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/homePageLink'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/browseLink'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/liveLink'), 3)
		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/Menu Bar/searchIcon"), 3)
		WebUI.verifyElementPresent(findTestObject("Object Repository/HomeScreen/MenuBar/sportLinkMenuBar"), 3)


		switch (UserCondition) {
			case 'Anonymous' :
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/loginLink'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/juniorLink'), 2)
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/subscribeToShahidVipLink'), 2)

				break

			case 'Subscribed' :
				WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'), 2)
				break

			case 'Registered' :
				WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/MenuBar/Subscribed/settingsLink'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/MyFavoriteScreen/MyListMainPage/myListLink'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/juniorLink'), 2)



				break
		}
	}


	@Keyword
	def VerifyShahidPlayer(String userType,Boolean VIPContent) {
		String UserCondition
		String expectedTextAr='عذراً، هذا المحتوى متوفر حصرياً لمستخدمي Shahid VIP'
		String expectedTextEng='Sorry, this content is only available for Shahid VIP users'

		if(VIPContent){
			UserCondition='VIPContent'
			println "VIPContent::"+VIPContent +"&&&"+UserCondition
		}



		println "User Condition::"+UserCondition
		switch (UserCondition) {

			case 'AdBlock' :

				WebUI.verifyElementText(findTestObject('VideoPlaybackScreen/Users with AdBlock/adBlockMessageText'), 'لمشاهدة هذا المحتوى، يرجى تعطيل حجب الإعلانات AdBlock أو شاهد بدون إعلانات من خلال الاشتراك في SHAHID PLUS')

				WebUI.verifyElementText(findTestObject('VideoPlaybackScreen/Users with AdBlock/noAdsButton'), 'شاهد بدون اعلانات')

				break

			case 'VIPContent' :

				println "VIPContent User Condition::"+UserCondition
				WebUI.waitForElementPresent(findTestObject("Object Repository/VideoPlaybackScreen/playListIcon"), 2)
			//TODO
			//				//String message= WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/VIPError'))
			//				if (WebUI.getUrl().contains("/ar/")) {
			//					WebUI.verifyElementText((findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/VIPError')), expectedTextAr)
			//				}else if (WebUI.getUrl().contains("/en/")) {
			//					WebUI.verifyElementText((findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/VIPError')), expectedTextEng)
			//				}

				if (userType=="Anonymous" ||  userType=="Registered") {

					if (WebUI.waitForElementPresent(findTestObject('Object Repository/ShowScreen/advertismentForShwPage'), 2)) {


					}else if(WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/loginButton'), 2)) {
						WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/loginButton'))
						WebUI.delay(2)
						WebUI.back()
						WebUI.delay(2)
						WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/signUpButton'), 2)
						WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/signUpButton'))
						WebUI.delay(2)
						WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/SubscribeFromPlayer'), 2)
						WebUI.back()
						WebUI.delay(2)

					}else if(WebUI.waitForElementPresent(findTestObject('Object Repository/mobileOnly/mobileOnlyPlayerText'), 2)) {
						WebUI.verifyElementPresent(findTestObject('Object Repository/mobileOnly/mobileOnlyPlayerText'), 3)
					}
				}



				break

			default:
				println "default User Condition::"+UserCondition
				if(userType=='Subscribed'){
					println "yes,is "+UserCondition
					//					WebUI.doubleClick(findTestObject('Object Repository/VideoPlaybackScreen/videoPlayer'))
					//WebUI.mouseOver(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))
					//WebUI.delay(3)
					//WebUI.mouseOver(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))
					//WebUI.doubleClick(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))
					//WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))
					WebUI.delay(2)

				}else{
					println "No,isn't "+UserCondition
					WebUI.delay(2)
					WebUI.doubleClick(findTestObject('Object Repository/VideoPlaybackScreen/videoPlayer'))
				}

				Boolean Condition= WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/adsSwitchButton'), 4)
				println  "Condition::"+Condition
				if(Condition){
					println "true if statment"
					WebUI.waitForElementPresent(findTestObject('VideoPlaybackScreen/adIcon'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/adCountDownText'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/muteButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/fullScreenButton'), 2)
					WebUI.back()
				}else{
					println "false if statment"
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/playerScreenText'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Anonymous and Registered Users/Info'), 2)
					WebUI.waitForElementPresent(findTestObject("Object Repository/VideoPlaybackScreen/controlPanel"), 2)
					WebUI.waitForElementPresent(findTestObject("Object Repository/VideoPlaybackScreen/playButton"), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/muteButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/duartionDisplay'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/fullScreenButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/playListIcon'), 2)
					WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/shareButton'))
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/twitterButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/facebookButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/embedVideoButton'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Share Options/copyLink'), 2)
					WebUI.click(findTestObject("Object Repository/VideoPlaybackScreen/Share Options/shareButton"))
					WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/videoQuality'))
					WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/settingsButton'))
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/qualityList'), 2)
					WebUI.waitForElementPresent(findTestObject('Object Repository/VideoPlaybackScreen/Content Quality/automatic'), 2)

					String d=WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'))
					List<String> t = d.split("\n")
					String startTime1=t.get(1)
					if(!WebUI.getUrl().contains("movies")) {
						startTime1="0:"+startTime1
					}
					println startTime1

					//WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/playButton'))
					//WebUI.doubleClick(findTestObject('Object Repository/VideoPlaybackScreen/farwardButton'))
					//WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))

					String e = WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'))
					List<String> f = e.split("\n")
					String endTime1=f.get(1)
					if(!WebUI.getUrl().contains("movies")) {
						endTime1="0:"+endTime1
					}
					println endTime1

					SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss")
					Date d1 = sdf.parse(startTime1)
					Date d2 = sdf.parse(endTime1)
					boolean result= d2.getTime() > d1.getTime()
					println "the farward is working " + result

					String s = WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'))
					List<String> g = s.split("\n")
					String startTime2=g.get(1)
					if(!WebUI.getUrl().contains("movies")) {
						startTime2="0:"+startTime2
					}
					println startTime2

					//WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/playButton'))
					//WebUI.doubleClick(findTestObject('Object Repository/VideoPlaybackScreen/backwardButton'))
					//WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/pauseButton'))

					String n = WebUI.getText(findTestObject('Object Repository/VideoPlaybackScreen/currentTimeDisplay'))
					List<String> m = n.split("\n")
					String endTime2=m.get(1)
					if(!WebUI.getUrl().contains("movies")) {
						endTime2="0:"+endTime2
					}
					println endTime2
					sdf = new SimpleDateFormat("h:mm:ss")
					d1 = sdf.parse(startTime2)
					d2 = sdf.parse(endTime2)
					result= d2.getTime() < d1.getTime()
					println "the backward is working " + result

					WebUI.click(findTestObject('Object Repository/VideoPlaybackScreen/exitVideo'))
				}
				break
		}
	}


	@Keyword
	int  numberOfRelatedItems(String ObjectRepositoryPath){
		int itemCounter= 1
		TestObject OBJ=findTestObject(ObjectRepositoryPath)
		String OBJXpath = OBJ.findPropertyValue('xpath')
		println "OBJXpath::"+OBJXpath
		for (def i = 1; i <=itemCounter; i++) {
			def Xpath  =OBJXpath+ [i]
			TestObject SliderElement = WebUI.modifyObjectProperty(findTestObject('Custom Keywords OBJ/ModifiedItemXpath'), 'xpath', 'equals', Xpath, true)
			if(WebUI.waitForElementPresent(SliderElement,2)){
				itemCounter ++
			}
		}
		itemCounter-=1
		return itemCounter
	}

	@Keyword
	def shahidLogin(String ShahidUsername, String ShahidPassword, int svod=1) {

		if (svod==1){
			WebUI.waitForElementPresent(findTestObject('Object Repository/HomeScreen/loginButton'), 6)
			new Shahid().popupNotification()
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/HomeScreen/loginButton'))
			WebUI.delay(2)
		}
		WebUI.waitForElementPresent(findTestObject('LoginScreen/usernameField'), 4)

		WebUI.setText(findTestObject('LoginScreen/usernameField'), ShahidUsername)
		WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 3)){
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			}
		}
		String passwordValue
		try {
			if(WebUI.waitForElementNotPresent(findTestObject('LoginScreen/passwordField'),8)) {
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			}


			WebUI.setEncryptedText(findTestObject('LoginScreen/passwordField'), ShahidPassword)
			WebUI.click(findTestObject('LoginScreen/loginButton'))

			if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/notdone'),4)){
				passwordValue = findTestObject('LoginScreen/passwordField').findPropertyValue("value")
				WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/notdone'),4)
				if(passwordValue==null) {
					if((WebUI.getUrl().contains("login-password"))) {
						WebUI.setEncryptedText(findTestObject('LoginScreen/passwordField'), ShahidPassword)
					}
					WebUI.click(findTestObject('LoginScreen/loginButton'))
					WebUI.delay(3)
				}}else if(!(WebUI.getUrl().contains("/home"))) {
				WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/notdone'),4)
				if(passwordValue==null) {
					if((WebUI.getUrl().contains("login-password"))) {
						WebUI.setEncryptedText(findTestObject('LoginScreen/passwordField'), ShahidPassword)
					}
				}
				//WebUI.click(findTestObject('LoginScreen/loginButton'))
			}
		}catch(Exception e) {
			println "select profile"

		}




		//
		//		if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/firstUserProflie'), 5)){
		//			if((WebUI.getUrl()).contains("login-password")) {
		//				WebUI.delay(2)
		//				if(WebUI.waitForElementNotPresent(findTestObject('LoginScreen/loginButton'), 5)){
		//
		//					try {
		//						WebUI.click(findTestObject('LoginScreen/loginButton'))
		//					}
		//					catch (Exception e) {
		//						println "loginButton CLicked"
		//					}
		//
		//				}
		//			}
		//
		//		}
	}


	@Keyword
	def public void NavigateToShahid() {
		WebUI.openBrowser('')
		WebUI.deleteAllCookies()
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.ShahidUrl)

		new Shahid().popupNotification()
		if(WebUI.waitForElementPresent(findTestObject('HomeScreen/dissmissButton'), 6)) {
			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
	}

	@Keyword
	def newBrowser() {
		WebUI.openBrowser("")

		WebDriver driver = new ChromeDriver()
		driver.get("https://shahid.mbc.net/ar")

	}

	@Keyword
	def public void NavigateTo(String pageUrl) {

		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(pageUrl)

		new Shahid().popupNotification()
		if(WebUI.waitForElementPresent(findTestObject('HomeScreen/dissmissButton'), 6)) {
			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
	}


	@Keyword
	def NavigateToShahidEnvironment(String Environment) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		switch(Environment){
			case'Production':
				WebUI.navigateToUrl(GlobalVariable.ShahidUrl)
				break
			case'Frontend1':
				WebUI.navigateToUrl(GlobalVariable.ShahidUrl)
				break
			case'Frontend2':
				WebUI.navigateToUrl(GlobalVariable.ShahidUrl)
				break
			case'Revamp':
				WebUI.navigateToUrl(GlobalVariable.ShahidUrl)
				break
		}
		def Status = WebUI.verifyElementPresent(findTestObject('HomeScreen/dissmissButton'), 2)
		if (Status) {

			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
	}

	@Keyword
	def public void NavigateToStaticPage(String StaticPage) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('www.Shahid.net')
		def Status1 = WebUI.verifyElementPresent(findTestObject('HomeScreen/dissmissButton'), 2)
		println Status1
		if (Status1) {
			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
		WebUI.scrollToElement(findTestObject(StaticPage), 2)
		WebUI.click(findTestObject(StaticPage))
		WebUI.delay (3)
		if (StaticPage == 'HomeScreen/FooterLinks/privacyPolicyPageLink') {
			WebUI.switchToWindowIndex(1)
			def Status2 = WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Privacy Policy/dissmissButton'), 2)
			println Status2
			if (Status2) {
				WebUI.click(findTestObject('StaticPagesScreen/Privacy Policy/dissmissButton'))
			}
		}
	}


	@Keyword
	def public void NavigateToPromoPage(String PromoPage) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(PromoPage)
		Boolean Status3 = WebUI.waitForElementPresent(findTestObject('HomeScreen/dissmissButton'), 2)
		println Status3
		if (Status3) {
			WebUI.click(findTestObject('HomeScreen/dissmissButton'))
		}
	}

	@Keyword
	def public RandomKey() {
		def key
		String alphabet = (('A'..'Z')+('0'..'9')).join()
		def length = 10
		key = new Random().with {
			(1..length).collect { alphabet[ new Random().nextInt( alphabet.length() ) ] }.join()
		}
		return key
	}

	@Keyword
	def public mohmalEmail() {
		String email
		int currentTab = WebUI.getWindowIndex()
		WebDriver driver = DriverFactory.getWebDriver()

		JavascriptExecutor js = ((driver) as JavascriptExecutor)

		js.executeScript('window.open();')
		WebUI.switchToWindowIndex(currentTab+1)
		WebUI.navigateToUrl('https://www.mohmal.club/ar/inbox')
		//		WebUI.click(findTestObject('Object Repository/Mohmal/randomNameButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Mohmal/emailBox'), 3)
		email= WebUI.getAttribute(findTestObject('Object Repository/Mohmal/emailBox'), 'data-email')
		js.executeScript('window.close();')
		WebUI.switchToWindowIndex(currentTab)
		return email
	}

	@Keyword
	def public RandomMSISDN() {
		def key
		def networkOperator

		//networkOperator
		String NONumber = (('7'..'9')).join()

		networkOperator = new Random().with {
			(1).collect { NONumber[ new Random().nextInt( NONumber.length() ) ] }.join()
		}

		//MSISDN
		String Number = (('0'..'9')).join()
		def length = 7
		key = new Random().with {
			(1..length).collect { Number[ new Random().nextInt( Number.length() ) ] }.join()
		}
		println "07"+networkOperator+key
		return "07"+networkOperator+key
	}
	@Keyword
	def public verifyCounter(String objectRepository){
		WebDriver driver = DriverFactory.getWebDriver()
		StopWatch stopwatch = new StopWatch();
		stopwatch.start()
		def condition
		int c=1
		for(def i=1;i<=c;i++){
			condition= WebUI.verifyElementPresent(findTestObject(objectRepository), 2,FailureHandling.CONTINUE_ON_FAILURE)
			if(condition){
				// Stop the StopWatch
				stopwatch.stop();
			}else{
				c++
			}
		}

		//Get the timer and put it in a variable
		long x = stopwatch.getTime();

		//Convert the result to a string
		String numberAsString = Long.toString(x);

		//Report it to Perfecto
		Map<String, Object> params1 = new HashMap<>();
		params1.put("name", "stopwatch timer");
		params1.put("result", numberAsString);
		println params1


	}



	@Keyword
	def public void verifyFooterElements() {

		String browserName= DriverFactory.getExecutedBrowser().getName()

		String PageUrl= WebUI.getUrl()
		String PromoPageUrl
		if(PageUrl.contains('spotify') || PageUrl.contains('arabbank')){
			PromoPageUrl=1
		}else if(PageUrl.contains('favorite')){
			PromoPageUrl=2
		}


		switch (PromoPageUrl) {
			case '1':

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/mainPageLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/contactUsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/applicationsLink'), 3)

			//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Footer Section/lastNewsLink'), 3)


				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/termsAndConditionsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/privacyLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/copyRightText'), 3)


				break
			case '2':

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/mainPageLinkMyFavList'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/contactUsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/applicationsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/termsAndConditionsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/privacyLink'), 3)

				WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/copyRightText'), 3)


				break
			default:


				if(browserName=='SAFARI_DRIVER'){
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/mainPageLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/contactUsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/applicationsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Footer Section/lastNewsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/termsAndConditionsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/privacyLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/copyRightText'), 3)
				}else{
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/mainPageLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/contactUsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/applicationsLink'), 3)
					//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Footer Section/lastNewsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/termsAndConditionsLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/privacyLink'), 3)
					WebUI.verifyElementPresent(findTestObject('PromoPages/Footer Section/copyRightText'), 3)
				}
				break
		}
	}

	@Keyword
	def public void VerifyStaticPagesMainBarComponents() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/shahidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/homePageLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/browseLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/liveLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/searchIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/loginLink'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/juniorLink'), 2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/tryShahidVIPButton'))
		WebUI.delay(3)
		//WebUI.waitForElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/sub-tryShahidVIPButton'), 3)
		WebUI.back()
		//WebUI.delay(3)
	}

	@Keyword
	def public void VerifyPromoPagesMainBarComponents() {

		String PageUrl= WebUI.getUrl()
		String PromoPageUrl
		if(PageUrl.contains('spotify') || PageUrl.contains('arabbank')){
			PromoPageUrl=1
		}else if(PageUrl.contains('mena') ){
			PromoPageUrl=2
		}

		switch (PromoPageUrl) {

			case '1':
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/shahidIcon'),2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/homePageLink'), 2)

			//				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/knowAboutShahid Know about'), 2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/MainBar/loginLink'), 2)
				break

			case '2':
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/mainBar/shahidIcon'),2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/mainBar/homePageLink'), 2)


			// here we add languagw switcher
				break

			default:
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/shahidIcon'), 2)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/homePageLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/seriesAndProgramsLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/moviesLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/browseLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/liveLink'), 3)

				WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/Menu Bar/searchIcon"), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/loginLink'), 3)

				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/juniorLink'), 2)

				WebUI.click(findTestObject('Object Repository/PromoPages/Menu Bar/tryShahidVIPButton'))
				WebUI.delay(3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/Menu Bar/sub-tryShahidVIPButton'), 2)
				WebUI.back()
				break
		}
	}

	@Keyword
	def public void setKidsAge() {
		// increase year
		WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/increaseYearButton'))
		//increase month
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/selectMonth'))
	}

	@Keyword
	def scrollToElement() {
		WebElement element = driver.findElement(By.xpath("(//img[contains(@class,'BundleCarousel')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	@Keyword
	def elementHover() {
		WebElement we = driver.findElement(By.xpath("((//img[contains(@class,'BundleCarousel')])[1]//following::div[contains(@class,'BundleItem_posterGradien')])[1]"));

		Actions action2 = new Actions(driver);
		action2.moveToElement(we).build().perform()
	}
}
