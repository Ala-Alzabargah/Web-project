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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class StaticPages {

	@Given("I want to Check Privacy Policy Page")
	def I_want_to_Check_Privacy_Policy_Page () {
		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/privacyPolicyPageLink')

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Privacy Policy/mainBar/facebookIcone'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Privacy Policy/mainBar/mbcLoginButton'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Privacy Policy/mainBar/mbcLogo'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Privacy Policy/mainBar/menuButton'), 0)

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText1'), findTestData('privacyPolicyText').getValue(
				1, 1))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText2'), findTestData('privacyPolicyText').getValue(
				1, 2))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText3'), findTestData('privacyPolicyText').getValue(
				1, 3))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText4'), findTestData('privacyPolicyText').getValue(
				1, 4))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText5'), findTestData('privacyPolicyText').getValue(
				1, 5))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText6'), findTestData('privacyPolicyText').getValue(
				1, 6))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText7'), findTestData('privacyPolicyText').getValue(
				1, 7))
		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText8'), 0)
		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Privacy Policy/privacyPolicyText8'), findTestData('privacyPolicyText').getValue(
				1, 8))
		WebUI.closeBrowser()
	}

	@Then("I want to Check Contact Us Page")
	def I_want_to_Check_Contact_Us_Page () {
		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/contactUsLink')

		CustomKeywords.'Shahid.VerifyStaticPagesMainBarComponents'()

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/callUsText'), 'اتصل بنا:\nنحن نقدر زيارتكم لموقعنا و نرحب بجميع ملاحظاتكم و ارائكم و استفساراتكم.')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/phoneNumbersGridText'), 'اتصل على الأرقام التالية:\nالمملكة العربية السعودية : 920 006 858\nالإمارات العربية المتحدة: 04 5677 477\nالمملكة الأردنية الهاشمية : 06 5777 577\nالرقم الدولي : +966 138 219 595')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/secondaryHeaderText'), 'أو تواصل معنا من خلال ترك البيانات الخاصة بك و سنقوم بالرد عليك فى اقرب وقت ممكن.')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/name'), 'الاسم')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/email'), 'البريد الإلكتروني')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/phoneNumber'), 'رقم الجوال')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/messageContent'), 'نص الرسالة')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/subject'), 'الموضوع')


		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Contact Us/secondaryHeaderText'), 0)

		WebUI.click(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'))

		def TotalOptions = WebUI.getNumberOfTotalOption(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'))

		WebUI.verifyEqual(TotalOptions, 9)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'الاعلان على SHAHID',
				false, 0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'المحتوى', false,
				0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'مشاكل في الموقع',
				false, 0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'تسجيل الدخول', false,
				0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'الاشتراك', false,
				0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'مشاهدة محتويات الموقع',
				false, 0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'التطبيقات والاجهزة',
				false, 0)

		WebUI.verifyOptionPresentByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'استفسار عام', false,
				0)

		WebUI.scrollToElement((findTestObject('StaticPagesScreen/Contact Us/messageContentFiled')), 0)

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/FieldsLabels/submitButton'), 'أرسل')

		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}

	@Then("I want to Check Applications Page")
	def I_want_to_Check_Applications_Page () {
		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/applicationsLink')
		CustomKeywords.'Shahid.VerifyStaticPagesMainBarComponents'()


		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/posterImage'), 0)

		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Applications/titleText'), 0)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/ipadButton'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/smartTvButton'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/iphoneButton'), 0)

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/androidButton'), 0)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/samsungButton'), 0)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/aramediaButton'), 0)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/hisenseButton'), 0)
		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/lgButton'), 0)
		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Applications/posterImage'), 0)

		WebUI.click(findTestObject('StaticPagesScreen/Applications/ipadButton'))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Applications/appStoreText'), 'App Store')

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/appStoreShahidLogo'), 0)

		WebUI.back()

		WebUI.click(findTestObject('StaticPagesScreen/Applications/iphoneButton'))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Applications/appStoreText'), 'App Store')

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/appStoreShahidLogo'), 0)

		WebUI.back()

		WebUI.click(findTestObject('StaticPagesScreen/Applications/androidButton'))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Applications/googleStoreText'), 'SHAHID')

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Applications/googleStoreShahidLogo'), 0)

		WebUI.back()

		WebUI.click(findTestObject('StaticPagesScreen/Applications/smartTvButton'))

		WebUI.verifyElementPresent(findTestObject('PromoPages/samsungTvApp/promoImage'), 0)

		WebUI.back()



		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Applications/titleText'), 0)

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Applications/titleText'),'استمتع بتطبيقات SHAHID\nفي كل مكان')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Applications/textDescription'),'SHAHID هى خدمة الفيديو حسب الطلب الأولى في العالم العربي\n\nو التي تقدم لك خدمة متابعة أضخم المسلسلات والبرامج و الأفلام بالعربي في أي وقت\nواينما كنت من خلال تطبيقات SHAHID المختلفة.\nمع SHAHID يمكنك\nمتابعة مجموعة كبيرة من المسلسلات و البرامج المميزة و الحصرية من أقوى و أهم\nالإنتاجات العربية و العالمية بالعربى و التي يتم تحديثها على مدار اليوم..\nلن تزعجك سرعة الإنترنت، مهما كانت ، سوف تتكيف جودة صورة الفيديو بحسب\nالسرعة التي لديك، ولن تزعجك سرعة التحميل.\nحمل تطبيقك المفضل الأن..')

		CustomKeywords.'Shahid.verifyFooterElements'()

		WebUI.closeBrowser()
	}

	@Then("I want to Check Complaint Sending")
	def I_want_to_Check_Complaint_Sending () {
		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/contactUsLink')

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/nameFiled'), 'Shahid Automation User')

		String randomKey  = CustomKeywords.'Shahid.RandomKey'()
		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/emailFiled'), 'ShahidAutomationUser'+ '+' + randomKey + '@gmail.net')

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/phoneNumberFiled'), '+962690000000')

		WebUI.selectOptionByLabel(findTestObject('StaticPagesScreen/Contact Us/subjectDropDownList'), 'استفسار عام', false)

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/messageContentFiled'), 'This Message Sent By Shahid Automated User for Test Automation purpose')

		WebUI.click(findTestObject('StaticPagesScreen/Contact Us/submitButton'))

		//WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Contact Us/congratsPopup'), 0)
		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/congratsPopupText'), 'شكرا للتواصل معنا ، سوف يتم الرد على استفسارك في أقرب فرصة ممكنه.')

		WebUI.click(findTestObject('StaticPagesScreen/Contact Us/congratsPopupCloseButton'))

		WebUI.verifyElementNotVisible(findTestObject('StaticPagesScreen/Contact Us/congratsPopup'), FailureHandling.STOP_ON_FAILURE)

		WebUI.closeBrowser()
	}


	@Then("I want to Check Invalid User Credentials")
	def I_want_to_Check_Invalid_User_Credentials () {

		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/contactUsLink')

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/emailFiled'), 'd')

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/phoneNumberFiled'), '00962xxxxxx')

		WebUI.click(findTestObject('StaticPagesScreen/Contact Us/submitButton'))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/Error Messages/wrongEmail'), 'error البريد الإلكتروني الذي أدخلته غير صحيح')

		WebUI.verifyElementPresent(findTestObject('StaticPagesScreen/Contact Us/Error Messages/errorIcon'), 0)

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/Error Messages/wrongPhoneNumber'), 'الرجاء إدخال الرقم علي النحو التالي : +000 0000000000')

		WebUI.setText(findTestObject('StaticPagesScreen/Contact Us/phoneNumberFiled'), '00962690000000')

		WebUI.clearText(findTestObject('StaticPagesScreen/Contact Us/emailFiled'))

		WebUI.click(findTestObject('StaticPagesScreen/Contact Us/submitButton'))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/Error Messages/emptyMessageContent'), 'error هذا الحقل مطلوب')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/Error Messages/emptyNameFiled'), 'errorبيانات مفقودة، قم بإدخال بيانات صحيحة')

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Contact Us/Error Messages/emptySubjectFiled'), 'error هذا الحقل مطلوب')

		WebUI.closeBrowser()
	}

	@Then("I want to Check Terms & Conditions Page")
	def I_want_to_Check_Terms_Conditions_Page () {
		CustomKeywords.'Shahid.NavigateToStaticPage'('HomeScreen/FooterLinks/termsAndConditionsLink')
		CustomKeywords.'Shahid.VerifyStaticPagesMainBarComponents'()
		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText'), findTestData('termsAndConditionsText').getValue(
				1, 1))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText1'), findTestData('termsAndConditionsText').getValue(
				1, 2))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText2'), findTestData('termsAndConditionsText').getValue(
				1, 3))
		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText3'), 0)
		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText3'), findTestData('termsAndConditionsText').getValue(
				1, 4))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText4'), findTestData('termsAndConditionsText').getValue(
				1, 5))

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText5'), findTestData('termsAndConditionsText').getValue(
				1, 6))

		WebUI.scrollToElement(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText6'), 0)

		WebUI.verifyElementText(findTestObject('StaticPagesScreen/Terms And Conditions/termsAndConditionsText6'), findTestData('termsAndConditionsText').getValue(
				1, 7))
		CustomKeywords.'Shahid.verifyFooterElements'()
		WebUI.closeBrowser()
	}
}