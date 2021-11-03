package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid
class UserProfile {

	//Verify User Profile Page
	@Given("I want to Verfiy User Profiles as (.*)")
	def I_want_to_Verfiy_User_Profiles(String userType) {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		String invalidParentalControlCode='1923'
		char codeDigit
		String parentalControlCode

		if(userType=="Subscribed") {

			parentalControlCode= new Shahid().getParentalControlCode("VIP")
			new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		}else if(userType=="Registered") {
			parentalControlCode= new Shahid().getParentalControlCode("Registered")
			new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		}

		WebUI.delay(2)
		new Shahid().popupNotification()
		//		WebUI.verifyElementPresent(findTestObject("Object Repository/UserProfile/shahidIcon"),0)
		//		//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/welcomeText"), 'مرحبا! اختر من يشاهد الآن')
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int Listsize=UserProfile.size()
		String ProfileName=''
		int index=0
		def UserProfilesName = new String[Listsize]
		TestObject User=new TestObject()
		for(def i=1;i<=Listsize;i++){
			String xpath=GlobalVariable.userProfileXpath+[i]
			User =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath, true)
			ProfileName=WebUI.getAttribute(User, 'alt')
			UserProfilesName[index]=ProfileName
			index++
		}
		int index1=0
		for(def i=1;i<=Listsize;i++){
			String xpath='//img[@alt="'+UserProfilesName[index1]+'"]'
			if(xpath=='//img[@alt="Kids"]' || xpath=='//img[@alt="أطفال"]'){
				xpath='//img[@alt="Kids" or @alt="أطفال"]'
			}else if(xpath=='//img[@alt="Guest"]' ||xpath=='//img[@alt="زائر"]'){
				xpath='//img[@alt="Guest" or @alt="زائر"]'
			}

			User =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath, true)
			WebUI.click(User)
			//			Boolean kidsProfileCondition=WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'), 2, FailureHandling.CONTINUE_ON_FAILURE)

			Boolean kidsProfileCondition=WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'), 3)
			println 'kidsProfileCondition:::::'+kidsProfileCondition
			if(kidsProfileCondition) {
				WebUI.click(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'))
				WebUI.delay(2)
				int a=1
				for(int x=0;x<parentalControlCode.length();x++){

					codeDigit=invalidParentalControlCode.charAt(x)
					def Xpath  ='(//input[@type="tel"])'+ [a]
					TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 'xpath', 'equals', Xpath, true)
					WebUI.setText(digit, codeDigit.toString())
					println "codeDigit:: "+codeDigit
					a++
				}

				WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/wrongPinCode'), 3)

				driver.findElement(By.xpath('//img[contains(@class,"CloseModal_close-modal_")]')).click()
				WebUI.click(findTestObject('Object Repository/UserProfile/ExitKidsProfileButton'))
				int s=1
				for(int y=0;y<parentalControlCode.length();y++){
					codeDigit=parentalControlCode.charAt(y)
					def Xpath  ='(//input[@type="tel"])'+ [s]
					println "Xpath:: "+Xpath
					TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 'xpath', 'equals', Xpath, true)

					WebUI.setText(digit, codeDigit.toString())
					println "codeDigit:: "+codeDigit
					println"s:: "+s++
				}
			}else {

				WebUI.mouseOver(findTestObject('Object Repository/HomeScreen/mainbarUserProfileIcon'))
				WebUI.click(findTestObject('Object Repository/HomeScreen/backToUserProfilesPage'))

				//Take Screenshot
				//new Shahid().takeScreenshot(featureName,methodName)

				WebUI.delay(2)
			}
			println " index1::"+index1

			index1++
		}


		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/profileManagementIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/activeKidsInterfaceText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/activeKidsIntefaceDescription'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	//Check Number of User Profile
	@Given("I want to Check Number of User Profile For New User")
	def I_want_to_Check_Number_of_User_Profile_For_New_User() {
		new Shahid().NavigateToShahid()
		WebUI.refresh()

		new Shahid().shahidLogin(GlobalVariable.NewUser, GlobalVariable.NewUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int Listsize=UserProfile.size()
		String ProfileName=''
		int index=0
		def UserProfilesName = new String[Listsize]
		String[] UserProfilesDefaultName
		String PageUrl=WebUI.getUrl()
		if(PageUrl.contains('ar')){
			UserProfilesDefaultName = ["زائر", "أطفال"]
		}else if(PageUrl.contains('en')){
			UserProfilesDefaultName = ["Guest", "Kids"]
		}

		for(def i=1;i<=Listsize;i++){
			String xpath=GlobalVariable.userProfileXpath+[i]
			TestObject User =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath, true)
			ProfileName=WebUI.getAttribute(User, 'alt')
			WebUI.verifyEqual(ProfileName, UserProfilesDefaultName[index])
			UserProfilesName[index]=ProfileName
			index++
		}


		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()

	}


	//Verfiy Adult User Profile

	//Add New Adult User Profile
	@Given("I want to Add New Adult User Profile")
	def I_want_to_Add_New_Adult_User_Profile() {
		addNewAdultUser()
	}


	def addNewAdultUser(int columnNUm=2) {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()


		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		String name = new Shahid().getRandomName("Adult",columnNUm)
		int Listsize=UserProfile.size()
		Boolean addButtonCondition = WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/addNewProfile'), 3)
		Boolean numberofProfileCondition= Listsize < 5
		if(numberofProfileCondition&&addButtonCondition){
			WebUI.click(findTestObject("Object Repository/UserProfile/addNewProfile"))
			WebUI.delay(2)
			//			//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/addProfileText"), 'اضافة ملف')
			WebUI.mouseOver(findTestObject('Object Repository/UserProfile/addProfileAvatar'))
			WebUI.click(findTestObject('Object Repository/UserProfile/addProfileAvatar'))
			WebUI.delay(2)

			new Shahid().selectAvatar(driver)

			WebUI.delay(2)
			//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/pickAvatarText"), 'اختر شخصية')
			WebUI.setText(findTestObject('Object Repository/UserProfile/enterNameField'), name)
			//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/kidsProfileText"), 'حساب أطفال')
			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)
			WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))

			//Take Screenshot
			//new Shahid().takeScreenshot(featureName,methodName)


			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/addProfileSuccessfullyText'), 5)
		}else{
			if(addButtonCondition){
				println "number of user profile is above the limit"
			}else if(numberofProfileCondition){
				println "Add new profile button does not exist"
			}else{
				println "You have reached the maximum number of profiles\n*Kindly note that the maximum number of profiles per user is 5"
			}
		}

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	//Update Adult User Profile
	@Given("I want to Update Adult User Profile")
	def I_want_to_Update_Adult_User_Profile() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))
		WebUI.delay(2)
		String User = new Shahid().getUserProfileName("Adult")
		
		String newUser = new Shahid().getRandomName("Adult")
		String xpath ="//img[not(@class) and @alt='"+User+"']"
		println "Xpath:::"+xpath
		//		TestObject userProfile =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/ModifiedUserProfileXpath'), 'xpath', 'equals', xpath, true)

		WebElement element = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		//		//WebUI.verifyElementText(findTestObject('Object Repository/UserProfile/profileManagementText'), 'إدارة الملفات')
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.click(findTestObject("Object Repository/UserProfile/addProfileAvatar"))
		WebUI.delay(2)

		new Shahid().selectAvatar(driver)

		WebUI.delay(2)
		//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/pickAvatarText"), 'اختر شخصية')
		WebUI.setText(findTestObject('Object Repository/UserProfile/enterNameField'), newUser)
		//WebUI.verifyElementText(findTestObject("Object Repository/UserProfile/kidsProfileText"), 'حساب أطفال')
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)
		WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))


		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/updateProfileSuccessfullyText'), 7)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)
		WebUI.closeBrowser()
	}


	//Delete Adult User Profile
	@Given("I want to Delete Adult User Profile")
	def I_want_to_Delete_Adult_User_Profile() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))

		String User = new Shahid().getUserProfileName("Adult")
		String xpath ="//img[@alt='"+User+"']"
		println "xpath::"+xpath
		TestObject userProfile =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/ModifiedUserProfileXpath'), 'xpath', 'equals', xpath, true)
		WebUI.waitForElementPresent(userProfile, 6)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int ListsizeBeforedelete=UserProfile.size()
		println "List Size Before Delete::"+ListsizeBeforedelete

		WebUI.delay(4)

		WebElement element = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/addProfileAvatar'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/pickAvatarText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/enterNameField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/kidsProfileText'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/createButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileText'), 4)
		WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deletePopupTilte'), 6)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deletePopupDescriptionText'), 4)
		WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupcloseButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

		List<WebElement> UserProfile2 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int ListsizeAfterdelete22=UserProfile2.size()
		println "List Size After Delete::"+ListsizeAfterdelete22
		WebUI.verifyEqual(ListsizeAfterdelete22, ListsizeBeforedelete)

		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(4)
		WebElement element1 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileSuccessfullyText'), 7)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)
		//		WebUI.delay(2)
		//		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		List<WebElement> UserProfile9 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int ListsizeAfterdelete1=UserProfile9.size()
		println "List Size After Delete::"+ListsizeAfterdelete22
		WebUI.verifyLessThan(ListsizeAfterdelete1, ListsizeBeforedelete)

		WebUI.delay(2)


		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}



	//change Adult User Profile to Kids User Profile
	@Given("I want to change Adult User Profile to Kids User Profile")
	def I_want_to_change_Adult_User_Profile_to_Kids_User_Profile() {
		WebUI.delay(4)
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()



		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()


		WebUI.refresh()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(2)
		String User = new Shahid().getUserProfileName("Adult")
		String xpath ="//img[@alt='"+User+"']"
		println "xpath::"+xpath
		TestObject userProfile =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/ModifiedUserProfileXpath'), 'xpath', 'equals', xpath, true)
		WebElement element1 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteSwitchPopupTilte'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteSwitchPopupDescriptionText'), 4)

		WebUI.click(findTestObject('Object Repository/UserProfile/deleteSwitchPopupcloseButton'))
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'), 2)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/isAgeRestrictedCheckbox'), 2)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/ageRestrictedText'), 2)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(2)
		WebElement element2 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);

		WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/UserProfile/deleteSwitchPopupButton'))
		WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/updateProfileSuccessfullyText'), 7)
		new Shahid().changeUserTypeTo("Kid",2,3)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()

	}


	//Verify Kids User Profile//

	//Active the Kids interface
	@Given("I want to Active the Kids interface")
	def I_want_to_Active_the_Kids_interface() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.refresh()
		String parentalControlCode = new Shahid().getParentalControlCode("Registered")
		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.click(findTestObject("Object Repository/UserProfile/switchToKidsProfile"))

		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int Listsize=UserProfile.size()
		println "User List size::"+Listsize
		String ProfileName=''
		int index=0
		def UserProfilesName = new String[Listsize]
		for(def i=1;i<=Listsize;i++){
			String xpath=GlobalVariable.userProfileXpath+[i]
			TestObject User =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath, true)
			ProfileName=WebUI.getAttribute(User, 'alt')
			UserProfilesName[index]=ProfileName
			println "i::"+i+"index::"+index
			index++
		}
		println "User Profiles List::"+UserProfilesName
		WebUI.verifyElementNotPresent(findTestObject("Object Repository/UserProfile/addNewProfile"),0)
		//WebUI.verifyElementText(findTestObject('Object Repository/UserProfile/Kids Interface/stopKidsInteface'), 'ايقاف واجهة الأطفال')
		WebUI.click(findTestObject("Object Repository/UserProfile/switchToKidsProfile"))
		//WebUI.verifyElementText(findTestObject('Object Repository/UserProfile/Kids Interface/exitKidsIntefaceText'),'خروج من واجهة الأطفال\nيحتاج هذا القسم إلى شخص بالغ للوصول إليه\nأدخل الرمز المكون من 4 أرقام\nنسيت رمز الرقابة الأبوية؟\nلإعادة ضبط الرمز، يمكنك زيارة shahid.net/parental باستخدام متصفح آخر.')
		int a=1
		for(int i=0;i<parentalControlCode.length();i++){
			char codeDigit=parentalControlCode.charAt(i)
			println codeDigit
			def Xpath  ='(//input[@type="tel"])'+ [a]
			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 'xpath', 'equals', Xpath, true)
			WebUI.setText(digit, codeDigit.toString())
			a++
		}
		WebUI.delay(2)
		WebUI.closeBrowser()


	}


	//Add New Kids User Profile
	@Given("I want to Add New Kids User Profile")
	def I_want_to_Add_New_Kids_User_Profile() {
		addNewKidUser()
	}

	def addNewKidUser(int columnNUm=2) {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.refresh()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		String name = new Shahid().getRandomName("Kid",columnNUm)
		int Listsize=UserProfile.size()
		println "User List size::"+Listsize
		Boolean addButtonCondition = WebUI.verifyElementPresent(findTestObject("Object Repository/UserProfile/addNewProfile"), 2, FailureHandling.CONTINUE_ON_FAILURE)
		Boolean numberofProfileCondition= Listsize < 5
		if(numberofProfileCondition&&addButtonCondition){
			WebUI.click(findTestObject('Object Repository/UserProfile/addNewProfile'))
			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/addProfileText'), 3)
			WebUI.click(findTestObject('Object Repository/UserProfile/addProfileAvatar'))
			WebUI.delay(2)

			new Shahid().selectAvatar(driver)

			WebUI.delay(2)
			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/pickAvatarText'), 3)
			WebUI.setText(findTestObject('Object Repository/UserProfile/enterNameField'), name)
			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/kidsProfileText'), 3)
			WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
			//			WebUI.verifyElementAttributeValue(findTestObject("Object Repository/UserProfile/Kids Interface/defaultKidBD"), 'value', '2008 مايو٫', 2)
			//			WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'))
			//			String[] BDList = BD.split("/")
			//			def initBDMonth= BDList[0] as int
			//			println "BDMonth::"+initBDMonth
			//			int BDMonth= initBDMonth - 1
			//			println "initBDMonth::"+initBDMonth
			//			println "BDMonth::"+BDMonth
			//			int BDYear= BDList[1] as int
			//			Date d = new Date()
			//			Locale months = new Locale("ar","SA")
			//			Locale ENmonths = new Locale("en","US")
			//			String month= DateFormatSymbols.getInstance(months).getMonths()[BDMonth]
			//			String ENmonth= DateFormatSymbols.getInstance(ENmonths).getMonths()[BDMonth]
			//			println "month name::"+month
			//			println "ENmonth name::"+ENmonth
			//			int selectedYear=WebUI.getAttribute(findTestObject('Object Repository/UserProfile/Kids Interface/selectedYear'), 'value') as int
			//			Boolean yearCondition=WebUI.verifyGreaterThan(BDYear, selectedYear,FailureHandling.CONTINUE_ON_FAILURE)
			//			TestObject movetoYear=new TestObject()
			//			if(yearCondition) {
			//				movetoYear=findTestObject('Object Repository/UserProfile/Kids Interface/increaseYearButton')
			//			}else {
			//				movetoYear=findTestObject('Object Repository/UserProfile/Kids Interface/decreaseYearButton')
			//			}
			//			String yearXpath="//input[@value='"+BDYear+"']"
			//			println "year Xpath::"+yearXpath
			//			TestObject desiredYear=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDYear'), 'xpath', 'equals', yearXpath, true)
			//			int c1 =0
			//			String maymonthXpath="//button[contains(text(),'مايو')]"
			//			for(def i=0;i<=c1;i++) {
			//				Boolean con=new Shahid().findElement(yearXpath)
			////				WebUI.verifyElementNotPresent(desiredYear, 2, FailureHandling.CONTINUE_ON_FAILURE)
			//				if(con) {
			//					WebUI.click(movetoYear)
			//					c1++
			//				}else {
			//					String monthXpath="//button[contains(text(),'"+month+"')]"
			//					println "month Xpath::"+monthXpath
			//					TestObject desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', monthXpath, true)
			//					if(BDYear==2008 && BDMonth<5) {
			//						desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', maymonthXpath, true)
			//						println "when BD year is 2008 you can't select month before May"
			//						WebUI.click(desiredMonth)
			//					}else if(BDYear==2019 && BDMonth>5) {
			//						desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', maymonthXpath, true)
			//						println "when BD year is 2019 you can't select month after May"
			//						WebUI.click(desiredMonth)
			//					}else {
			//						WebUI.click(desiredMonth)
			//					}
			//				}
			//			}
			//
			//			WebUI.verifyElementChecked(findTestObject('Object Repository/UserProfile/Kids Interface/isAgeRestrictedCheckbox'), 2,FailureHandling.CONTINUE_ON_FAILURE)
			//WebUI.verifyElementText(findTestObject('Object Repository/UserProfile/Kids Interface/ageRestrictedText'), 'تحديد المحتوى المناسب لعمر الطفل')
			WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))
			WebUI.delay(1)

			//Take Screenshot
			//new Shahid().takeScreenshot(featureName,methodName)

			WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/addProfileSuccessfullyText'), 4)

			//Take Screenshot
			//new Shahid().takeScreenshot(featureName,methodName)

		}else{
			if(addButtonCondition){
				println "number of user profile is above the limit"
			}else if(numberofProfileCondition){
				println "Add new profile button does not exist"
			}else{
				println "You have reached the maximum number of profiles\n*Kindly note that the maximum number of profiles per user is 5"
			}
		}

		WebUI.closeBrowser()
	}

	//Update Kids User Profile
	@Given("I want to Update Kids User Profile")
	def I_want_to_Update_Kids_User_Profile() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.refresh()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(2)
		String User = new Shahid().getUserProfileName("Kid")
		String newUser = "Update Kid"
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()


		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 7)
		List<WebElement> UserProfile = driver.findElements(By.xpath("//img[@style and not(@class)]"))
        

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)
		new Shahid().popupNotification()
		WebUI.delay(4)
		
		//UserProfile[2].click()
		WebUI.click(findTestObject('Object Repository/updateKidsUserProfileEdit'))
		WebUI.delay(4)
		WebUI.click(findTestObject('Object Repository/UserProfile/addProfileAvatar'))
		new Shahid().selectAvatar(driver)

		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/pickAvatarText'), 4)
		if(newUser!='0') {
			WebUI.setText(findTestObject('Object Repository/UserProfile/enterNameField'), newUser)
		}else {
			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/enterNameField'), 2)
		}
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/kidsProfileText'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'),0)

		//		if(BD!='0') {
		//			WebUI.click(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'))
		//			String[] BDList = BD.split("/")
		//			def initBDMonth= BDList[0] as int
		//			println "BDMonth::"+initBDMonth
		//			int BDMonth= initBDMonth - 1
		//			println "initBDMonth::"+initBDMonth
		//			println "BDMonth::"+BDMonth
		//			int BDYear= BDList[1] as int
		//			Date d = new Date()
		//			Locale months = new Locale("ar","SA")
		//			String month= DateFormatSymbols.getInstance(months).getMonths()[BDMonth]
		//			println "month name::"+month
		//			int selectedYear=WebUI.getAttribute(findTestObject('Object Repository/UserProfile/Kids Interface/selectedYear'), 'value') as int
		//			Boolean yearCondition=WebUI.verifyGreaterThan(BDYear, selectedYear,FailureHandling.CONTINUE_ON_FAILURE)
		//			TestObject movetoYear=new TestObject()
		//			if(yearCondition) {
		//				movetoYear=findTestObject('Object Repository/UserProfile/Kids Interface/increaseYearButton')
		//			}else {
		//				movetoYear=findTestObject('Object Repository/UserProfile/Kids Interface/decreaseYearButton')
		//			}
		//			String yearXpath="//input[@value='"+BDYear+"']"
		//			println "year Xpath::"+yearXpath
		//			TestObject desiredYear=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDYear'), 'xpath', 'equals', yearXpath, true)
		//			int c1 =0
		//			String maymonthXpath="//button[contains(text(),'مايو')]"
		//			for(def i=0;i<=c1;i++) {
		//				if(WebUI.verifyElementNotPresent(desiredYear, 2, FailureHandling.CONTINUE_ON_FAILURE)) {
		//					WebUI.click(movetoYear)
		//					c1++
		//				}else {
		//					String monthXpath="//button[contains(text(),'"+month+"')]"
		//					println "month Xpath::"+monthXpath
		//					TestObject desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', monthXpath, true)
		//					if(BDYear==2008 && BDMonth<5) {
		//						desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', maymonthXpath, true)
		//						println "when BD year is 2008 you can't select month before May"
		//						WebUI.click(desiredMonth)
		//					}else if(BDYear==2019 && BDMonth>5) {
		//						desiredMonth=WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedKidBDMonth'), 'xpath', 'equals', maymonthXpath, true)
		//						println "when BD year is 2019 you can't select month after May"
		//						WebUI.click(desiredMonth)
		//					}else {
		//						WebUI.click(desiredMonth)
		//					}
		//				}
		//			}
		//		}else {
		//			WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'), 2)
		//		}

		//		WebUI.verifyElementChecked(findTestObject('Object Repository/UserProfile/Kids Interface/isAgeRestrictedCheckbox'), 2,FailureHandling.CONTINUE_ON_FAILURE)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/ageRestrictedText'), 3)
		WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/kidsNotAllowedMessage'),4)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()

	}

	//Delete Kids User Profile
	@Given("I want to Delete Kids User Profile")
	def I_want_to_Delete_Kids_User_Profile() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		WebUI.delay(2)
		new Shahid().popupNotification()

		String User = new Shahid().getUserProfileName("Kid",3)

		WebUI.delay(2)
		String xpath ="//img[@alt='"+User+"']"
		println "xpath::"+xpath
		TestObject userProfile =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/ModifiedUserProfileXpath'), 'xpath', 'equals', xpath, true)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		WebUI.delay(2)
		int ListsizeBeforedelete=UserProfile.size()
		println "List Size Before Delete::"+ListsizeBeforedelete
		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(4)

		WebElement element = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profileManagementText'), 7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/addProfileAvatar'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/pickAvatarText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/enterNameField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/kidsProfileText'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/switchToKidsProfile'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/createButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileText'), 4)
		WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deletePopupTilte'), 6)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deletePopupDescriptionText'), 4)
		WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupcloseButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/closeButton'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))

		List<WebElement> UserProfile2 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int ListsizeAfterdelete22=UserProfile2.size()
		println "List Size After Delete::"+ListsizeAfterdelete22
		WebUI.verifyEqual(ListsizeAfterdelete22, ListsizeBeforedelete)

		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(4)
		WebElement element1 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileIcon'), 6)
		WebUI.click(findTestObject('Object Repository/UserProfile/deleteProfileIcon'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/UserProfile/deletePopupButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/deleteProfileSuccessfullyText'), 7)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)
		//		WebUI.delay(2)
		//		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		List<WebElement> UserProfile9 = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int ListsizeAfterdelete1=UserProfile9.size()
		println "List Size After Delete::"+ListsizeAfterdelete22
		WebUI.verifyLessThan(ListsizeAfterdelete1, ListsizeBeforedelete)

		WebUI.delay(2)

		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}


	//change Adult User Profile to Kids User Profile
	@Given("I want to change Kid User Profile to Adult User Profile")
	def I_want_to_change_Kid_User_Profile_to_Adult_User_Profile() {

		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()

		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.TeamUser, GlobalVariable.TeamUserPassword)
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/profileManagementIcon'), 5)
		WebUI.click(findTestObject('Object Repository/UserProfile/profileManagementIcon'))
		WebUI.delay(2)


		String User =   new Shahid().getUserProfileName("Kid")
		String xpath ="//img[@alt='"+User+"']"
		println "xpath::"+xpath
		TestObject userProfile =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/ModifiedUserProfileXpath'), 'xpath', 'equals', xpath, true)
		WebElement element1 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
		WebUI.delay(1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteSwitchPopupTilte'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/deleteSwitchPopupDescriptionText'), 4)

		WebUI.click(findTestObject('Object Repository/UserProfile/deleteSwitchPopupcloseButton'))
		//		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/kidBirthdateField'), 2)
		//		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/isAgeRestrictedCheckbox'), 2)
		//		WebUI.verifyElementNotPresent(findTestObject('Object Repository/UserProfile/Kids Interface/ageRestrictedText'), 2)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/UserProfile/closeButton'))
		WebUI.delay(2)
		WebUI.click(findTestObject("Object Repository/UserProfile/profileManagementIcon"))
		WebUI.delay(2)
		WebElement element2 = driver.findElement((By.xpath("//img[not(@class) and @alt='"+User+"']")));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", element2);

		WebUI.click(findTestObject('Object Repository/UserProfile/switchToKidsProfile'))
		WebUI.delay(1)

		WebUI.click(findTestObject('Object Repository/UserProfile/deleteSwitchPopupButton'))
		WebUI.click(findTestObject('Object Repository/UserProfile/createButton'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/updateProfileSuccessfullyText'), 7)
		new Shahid().changeUserTypeTo("Adult",2,3)
		//Take Screenshot
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	@Given("I want to Enable Kids Mode")
	def I_want_to_change_Enable_Kids_Mode() {
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		String parentalControlCode= new Shahid().getParentalControlCode("VIP")
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()

		new Shahid().shahidLogin(GlobalVariable.SubscribedUser, GlobalVariable.SubscribedUserPassword)
		new Shahid().popupNotification()

		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/KidsModeToggle'), 4)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/EnterKidsMode'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/EnterKidsModeSubtext'), 3)
		WebUI.click(findTestObject('Object Repository/UserProfile/KidsModeToggle'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/UserProfile/Kids Interface/EnterKidsMode'), 3)
		WebUI.delay(2)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int Listsize=UserProfile.size()
		String ProfileName=''
		int index=0
		def UserProfilesName = new String[Listsize]
		TestObject User=new TestObject()
		for(def i=1;i<=Listsize;i++){
			String xpath=GlobalVariable.userProfileXpath+[i]
			User =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath, true)
			ProfileName=WebUI.getAttribute(User, 'alt')
			UserProfilesName[index]=ProfileName
			index++
		}

		WebUI.click(findTestObject('Object Repository/UserProfile/KidsModeToggle'))
		WebUI.delay(2)
		int a=1
		for(int x=0;x<parentalControlCode.length();x++){
			char codeDigit=parentalControlCode.charAt(x)
			def Xpath  ='(//input[@type="tel"])'+ [a]
			TestObject digit = WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedCodeDigitField'), 'xpath', 'equals', Xpath, true)
			WebUI.setText(digit, codeDigit.toString())
			a++
		}

		WebUI.delay(2)
		List<WebElement> UserProfileAFter = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		int Listsize1=UserProfile.size()
		String ProfileName1=''
		int index1=0
		def UserProfilesName1 = new String[Listsize1]
		TestObject User1=new TestObject()
		for(def i=1;i<=Listsize1;i++){
			String xpath1=GlobalVariable.userProfileXpath+[i]
			User1 =WebUI.modifyObjectProperty(findTestObject('Object Repository/Custom Keywords OBJ/modifiedUserIconXpath'), 'xpath', 'equals', xpath1, true)
			ProfileName1=WebUI.getAttribute(User1, 'alt')
			UserProfilesName1[index1]=ProfileName1
			index++
		}

		UserProfilesName.size()<UserProfilesName1.size()

		WebUI.closeBrowser()
	}

}