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
import org.openqa.selenium.Keys as Keys

import shahid.utils.Shahid

class Search {

	@Given("I want to verfiy Search elements")
	def I_want_to_verfiy_Search_elements () {

		new Shahid().NavigateToShahid()
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('HomeScreen/searchButton'), 6)

		WebUI.click(findTestObject('HomeScreen/searchButton'))

		WebUI.waitForElementPresent(findTestObject('Search/searchFiled'), 4)

		WebUI.setText(findTestObject('Search/searchFiled'), 'باب')

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchResultContainer'), 9)

		WebUI.click(findTestObject('Object Repository/Search/closeIcon'))

		WebUI.setText(findTestObject('Search/searchFiled'), '  ')

		WebUI.sendKeys(findTestObject('Search/searchFiled'), Keys.chord(Keys.ENTER))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/noSearchMatchesFound'), 7)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/ItMayInterestYouToWatch'), 7)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/ToWatchList'), 7)
		WebUI.delay(5)
		WebUI.closeBrowser()
	}



	@Given("I want to Search For Valid Keyword (.*)")
	def I_want_to_Search_For_Valid_Keyword (String searchType) {
		String searchValue='باب'

		if(searchType=='Genre') {
			searchValue='تشويق'
		}else if(searchType=='Star') {
			searchValue='محمد رمضان'
		}else if(searchType=='exact title AR') {
			searchValue='beirut of the balkans'
		}else if(searchType=='exact title EN') {
			searchValue='blinded'
		}else if(searchType=='exact title wrong kb EN') {
			searchValue='fdj fmskv'
		}else if(searchType=='exact title wrong kb AR') {
			searchValue='زمهريثي'
		}else if(searchType=='exact search for cast member EN') {
			searchValue='Bruce Willis'
		}else if(searchType=='exact search for cast member AR') {
			searchValue='عادل امام'
		}else if(searchType=='fit search channels name EN') {
			searchValue='MBC'
		}else if(searchType=='fit search channels name EN wrong kb') {
			searchValue='قخفشرش'
		}else if(searchType=='fit search for years EN') {
			searchValue='1999'
		}else if(searchType=='fit search for years AR') {
			searchValue='١٩٩٩'
		}else if(searchType=='Fit search for genre AR') {
			searchValue='اكشن'}
	
		
			new Shahid().NavigateToShahid()
			if(searchType=='exact title EN' || searchType=='exact search for cast member EN' || searchType=='fit search channels name EN wrong kb') {
				new Shahid().switchLanguage()
				new Shahid().popupNotification()
			}

			WebUI.delay(3)
			WebUI.waitForElementPresent(findTestObject('HomeScreen/searchButton'), 6)
			WebUI.click(findTestObject('HomeScreen/searchButton'))
			WebUI.waitForElementPresent(findTestObject('Search/searchFiled'), 4)
			WebUI.setText(findTestObject('Search/searchFiled'), searchValue)
			WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchResultContainer'), 9)
			WebUI.delay(5)

			if(searchType=='exact title AR') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 30)
				WebUI.mouseOver(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/hellsGateTitle'), 3)
			}

			if(searchType=='exact title EN') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 30)
				WebUI.mouseOver(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/blindedSearch'), 3)
			}

			if(searchType=='exact title wrong kb EN') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 30)
				WebUI.mouseOver(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/betBoSanadSearch'), 3)
			}

			if(searchType=='exact title wrong kb AR') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 30)
				WebUI.mouseOver(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/blindedSearch'), 3)
			}

			if(searchType=='exact search for cast member EN') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
				WebUI.click(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.delay(3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/bruceWillis'), 3)
			}

			if(searchType=='exact search for cast member AR') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
				WebUI.click(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.delay(3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/adelEmamText'), 3)
			}

			else if(searchType=='fit search channels name EN') {
				WebUI.delay(3)
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
				WebUI.click(findTestObject('Object Repository/Search/searchFeature/firstElement'))
				WebUI.delay(3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/searchMBC'), 3)
			}
			//		here to check with content
			if(searchType=='fit search channels name EN wrong kb') {


			}

			if((searchType=='fit search for years EN')) {
				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
			}

			if(searchType=='fit search for years AR') {

				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/firstElement'), 3)
			}

			if(searchType=='Fit search for genre AR') {

				WebUI.waitForElementPresent(findTestObject('Object Repository/Search/secondElementSearch'), 3)
				WebUI.mouseOver(findTestObject('Object Repository/Search/secondElementSearch'))
				WebUI.verifyElementPresent(findTestObject('Object Repository/Search/searchFeature/actionGenre'), 3)


			}


			WebUI.closeBrowser()
		}
	
	@Given("I want to Search For InValid Keyword")

	def I_want_to_Search_For_InValid_Keyword () {
		new Shahid().NavigateToShahid()
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('HomeScreen/searchButton'), 6)

		WebUI.click(findTestObject('HomeScreen/searchButton'))

		WebUI.waitForElementPresent(findTestObject('Search/searchFiled'), 4)

		WebUI.setText(findTestObject('Search/searchFiled'), 'WrongKeyWord')

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/noSearchMatchesFound'), 7)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/ItMayInterestYouToWatch'), 7)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Search/ToWatchList'), 7)

		WebUI.delay(3)
		WebUI.closeBrowser()
	}
}