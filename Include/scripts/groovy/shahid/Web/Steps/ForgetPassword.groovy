package shahid.Web.Steps
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


class ForgetPassword {


	@Then("I Click Forget Password Link")
	def I_Click_Forget_Password_Link() {

		WebUI.scrollToElement(findTestObject('LoginScreen/forgetPasswordLink'), 0)

		WebUI.click(findTestObject('LoginScreen/forgetPasswordLink'))
	}

	@Then("I Enter Username (.*)&(.*)")
	def I_Enter_Username(String Username , String Captcha) {
		WebUI.scrollToElement(findTestObject('ForgotPasswordScreen/forgetPasswordText'), 0)
		WebUI.setText(findTestObject('ForgotPasswordScreen/usernameFiled'), Username)
		WebUI.setText(findTestObject('ForgotPasswordScreen/captchaField'), Captcha)
	}


	@Then("I Click on Forget Password Submit")
	def I_Click_on_Forget_Password_Submit() {
		WebUI.click(findTestObject('ForgotPasswordScreen/forgetPasswordSumbitButton'))
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/forgetPasswordText'), 'استعادة كلمة السر')
	}

	@Then("I Verfiy Forget Password wedgit Text")
	def I_Verfiy_Forget_Password_wedgit_Text() {

		WebUI.scrollToElement(findTestObject('ForgotPasswordScreen/forgetPasswordText'), 0)
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/forgetPasswordText'), 'استعادة كلمة السر')
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/forgetPasswordTextDescription'), 'قم بالمرور على الخطوات لتعيين كلمة سر جديدة')
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/enterUsernameText'), 'أدخل البريد الإلكتروني الخاص بك للحصول على كلمة سر جديدة')
		WebUI.verifyElementAttributeValue(findTestObject('ForgotPasswordScreen/usernameFiled'), 'placeholder', 'البريد الإلكتروني', 0)
		WebUI.verifyElementAttributeValue(findTestObject('ForgotPasswordScreen/captchaField'), 'placeholder', 'الرجاء إعادة كتابة الرمز', 0)
		WebUI.verifyElementPresent(findTestObject('ForgotPasswordScreen/captchaRefreshButton'), 0)
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/forgetPasswordSumbitButton'), 'أرسل')
		WebUI.scrollToElement(findTestObject('ForgotPasswordScreen/backLink'), 0)
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/backLink'), 'رجوع')
		WebUI.closeBrowser()
	}


	@Then("I Click Back Link at Forget Passwoed Page")
	def I_Click_Back_Link_at_Forget_Passwoed_Page() {
		WebUI.scrollToElement(findTestObject('ForgotPasswordScreen/backLink'), 0)
		WebUI.click(findTestObject('ForgotPasswordScreen/backLink'))
		WebUI.verifyElementText(findTestObject('LoginScreen/loginText'), 'تسجيل الدخول')
		WebUI.closeBrowser()
	}

	@Then("I Verfiy Success Forget Passwoed Page")
	def I_Verfiy_Success_Forget_Passwoed_Page() {

		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/mainSuccessText'), 'استعادة كلمة السر')
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/successTitleDescription'), 'قم بالمرور على الخطوات لتعيين كلمة سر جديدة')
		WebUI.verifyElementText(findTestObject('ForgotPasswordScreen/successText'), 'تم إرسال طلب استعادة كلمة السر، قم بزيارة بريدك الإلكتروني لتعيين كلمة سر جديدة')
		WebUI.verifyElementPresent(findTestObject('ForgotPasswordScreen/successIcone'), 0)
		WebUI.verifyElementPresent(findTestObject('ForgotPasswordScreen/spinnerIcone'), 0)
	}
}