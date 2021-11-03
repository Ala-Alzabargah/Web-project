package shahid.Web.Steps;

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import internal.GlobalVariable
import shahid.utils.Shahid


class SignUp {

	@Given("I want to Verify create account page")
	def I_want_to_Verify_create_account_page() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		String Email= new Shahid().mohmalEmail()
		WebUI.setText(findTestObject('LoginScreen/usernameField'), Email)
		WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 3)){
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			}
		}

		if(WebUI.waitForElementNotPresent(findTestObject('LoginScreen/passwordField'),6)) {
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		}

		WebUI.delay(1)
		//		new Shahid().VerifyStaticPagesMainBarComponents()
		WebUI.waitForElementPresent(findTestObject('Object Repository/SignUpScreen/createAccountTitleText'), 7)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/personalFileText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/continueWatchingText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/myListText') , 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/enterCreatePasswordText'), 3)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/SignUpScreen/usernameField'),'value', Email, 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/passwordField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/termsAndConditionsText'),2)
		WebUI.verifyElementNotChecked(findTestObject('Object Repository/SignUpScreen/termsAndConditionsCheckbox'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsText'),2)
		WebUI.verifyElementNotChecked(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'), 2)
		WebUI.doubleClick(findTestObject('Object Repository/SignUpScreen/termsAndConditionsCheckbox'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/Error Messages/termsAndConditions'),3)
		WebUI.click(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/createButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/backButton'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/reCAPTCHAText'), 3)
		new Shahid().verifyFooterElements()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()

	}


	@Given("I want to Verify create account page form Try ShahidVIP Button")
	def I_want_to_Verify_create_account_page_form_Try_ShahidVIP_Button() {
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject("Object Repository/SignUpScreen/tryShahidVIPButton"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/SignUpScreen/tryShahidVIPNowButton'))
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/subscribeNowDescriptionText'), 'اشترك الآن واستمتع بالتجربة المجانية')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/FHDIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/FHDIconText'), 'جودة عالية الدقة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/noADsIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/noADsIconText'), 'بدون فواصل إعلانية')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/continueWatchingIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/continueWatchingIconText'), 'مواصلة المشاهدة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/offlineIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/offlineIconText'), 'تحميل اوفلاين')

		//Verify Packages Section
		//verify Monthly Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyPackageGrid"), 2)

		String monthlyPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyPackageGrid"))
		String[] monthlyPackageTextSplit=monthlyPackageText.split('\n')
		String monthlyPackageTitle=monthlyPackageTextSplit[0]
		String monthlyPackagePrice=monthlyPackageTextSplit[1]
		String monthlyPackageSpotifyText=monthlyPackageTextSplit[2]
		WebUI.verifyEqual(monthlyPackageTitle, 'الباقة الشهرية')
		WebUI.verifyEqual(monthlyPackagePrice, '2.99 JOD / شهرياً')
		WebUI.verifyEqual(monthlyPackageSpotifyText, '6 أشهر مجانية من Spotify')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCIcon'),'البطاقة المصرفية')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorIcon'),'الجوّال')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		//verify Annual Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualPackageGrid"), 2)
		String annualPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualPackageGrid"))
		String[] annualPackageTextSplit=annualPackageText.split('\n')
		String annualPackageTitle=annualPackageTextSplit[0]
		String annualPackageMoreFrugal=annualPackageTextSplit[1]
		String annualPackagePrice=annualPackageTextSplit[2]
		String annualPackageSpotifyText=annualPackageTextSplit[3]
		WebUI.verifyEqual(annualPackageTitle, 'الباقة السنوية')
		WebUI.verifyEqual(annualPackageMoreFrugal, '44% اوفر')
		WebUI.verifyEqual(annualPackagePrice, '19.99 JOD / سنوياً')
		WebUI.verifyEqual(annualPackageSpotifyText, '6 أشهر مجانية من Spotify')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCIcon'),'البطاقة المصرفية')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		////verify weekly Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyPackageGrid"), 2)
		String weeklyPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyPackageGrid"))
		String[] weeklyPackageTextSplit=weeklyPackageText.split('\n')
		String weeklyPackageTitle=weeklyPackageTextSplit[0]
		String weeklyPackagePrice=weeklyPackageTextSplit[1]
		String weeklyPackageSpotifyCancellationText=weeklyPackageTextSplit[2]
		WebUI.verifyEqual(weeklyPackageTitle, 'الباقة الأسبوعية')
		WebUI.verifyEqual(weeklyPackagePrice, '0.99 JOD / أسبوعياً')
		WebUI.verifyEqual(weeklyPackageSpotifyCancellationText, 'يمكنك إلغاء الإشتراك في أي وقت')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorIcon'),'الجوّال')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherDescriptionText'), 'إذا كان لديك قسيمة اشتراك')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherButton'), 'اضغط هنا')

		//Verify Redeem Voucher Page
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/redeemVoucherTitleText'), 'احصل على اشتراك SHAHID VIP')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/enterVoucherText'), 'بمجرد ادخال رمز القسيمة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/enterVouherField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/activeSubscriptionButton'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/termsAndConditionsText'), 'تطبق الشروط والأحكام، في حال واجهتك أي مشكلة الرجاء التواصل مع مركز رعاية المتعاملين .')
		WebUI.back()

		//Verify ShahidVIP Features List
		WebUI.scrollToElement(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/shahidVIPFeatureTitleText'), 0)
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/liveFeatureText"), 'شاهد أفضل محتوى مباشرةً بعد بث التلفزيون')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/arabicContantFeatureText"), 'أكبر مكتبة للمحتوى العربي أكثر من 40,000 حلقة')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/multiDevicesFeatureText"), 'على أي جهاز - الكمبيوتر والجوّال والأجهزة اللوحية والتلفاز')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/noADSFeatureText'), 'بدون فواصل إعلانية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/shahidOriginalsFeatureText"), 'أعمال شاهد الأصلية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/exclusiveSeriesFeatureText"), 'مسلسلات حصرية لأول مرة')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/arabicMoviesFeatureText"), 'أحدث الأفلام العربية بعد عرض السينما مباشرةً')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/marvel-DisneyContantFeatureText"), 'أضخم الإنتاجات والبرامج الحاصلة على جوائز من ديزني و مارفل')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/offlineFeatureText"), 'التحميل للمشاهدة أوفلاين')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/kidsSafeContantFeatureText"), 'أفضل محتوى ترفيهي آمن للأطفال من ديزني، بيكسار، كرتون نتورك ونيكلوديون')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/liveBroadcastfeatureText"), 'قنوات تلفزيونية مباشرة بجودة عالية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/watchWhileTravelingFeatureText"), 'مشاهدة أثناء السفر')

		//Verify VIP&FreeCheck
		for (def i = 1; i <=15; i++){
			String Xpath  ="(//img[@src='/static/fonts/2d48ee763477ce8dac5a1713ed4230d4.svg'])"+ [i]
			TestObject Check = WebUI.modifyObjectProperty(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/VIP-FreeCheck"),'xpath', 'equals', Xpath, true)
			if( i==1 || i==3 || i==5){
				WebUI.focus(Check)
				WebUI.verifyElementAttributeValue(Check,'alt', 'free_Check', 1)
			}else{
				WebUI.verifyElementAttributeValue(Check, 'alt', 'VIP_Check', 1)
			}
		}

		//Verify FreeUncheck
		for (def i = 1; i <=9 ; i++) {
			def Xpath  ="//img[@src='/static/fonts/1be624b7e735db6ea7c64cf867a299e9.svg'])"+ [i]

			TestObject FreeUncheck = WebUI.modifyObjectProperty(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/freeUncheck'),'xpath', 'equals', Xpath, true)
			WebUI.verifyElementAttributeValue(FreeUncheck, 'alt', 'free_uncheck', 1)
		}

		//Verify Other Inquiries Section
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/otherInquiriesTitleText"), 'هل لديك استفسارات أخرى؟')

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"), 'كيف يمكنني الاشتراك بخدمة شاهد VIP؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeDescriptionText"), 'يمكنك الاشتراك في شاهد VIP من خلال اتباع الخطوات التالية هنا:\n\n1- حدد الباقة وطريقة الدفع الأنسب لك\n2- أدخل بريدك الإلكتروني وكلمة المرور\n3- أدخل تفاصيل الدفع الخاصة بك\n4- استمتع بمشاهدة أفضل محتوى على شاهد VIP')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"), 'إذا كانت فترة تجريبية مجانية ، فلماذا يتوجب عليّ إدخال تفاصيل الدفع؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodDescriptionText"), 'نطلب منك تزويدنا بطريقة دفع للتأكد من عدم انقطاع الخدمة بعد انتهاء التجربة المجانية. نقوم بذلك عن طريق إرسال طلب تفويض إلى مؤسستك المالية للتحقق من أن طريقة الدفع فعّالة. لا تعتبر هذه الطلبات كرسوم لكنها في بعض الحالات قد تؤثر مؤقتًا على رصيد حسابك المتاح')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"), 'هل يمكنني إلغاء إشتراك شاهد VIP في أي وقت؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeDescriptionText"), 'نعم ، يمكنك الإلغاء في أي وقت. لن يتم محاسبتك مرة أخرى ، ما لم تقم بإعادة تفعيل عضويتك.\n\nخطوات الإلغاء:\nلخيارات الدفع عبر الهاتف وبطاقات الائتمان:\n1- اذهب إلى إعدادات الحساب باستخدام ملف تعريف البالغين\n2- اضغط على معلومات الاشتراك\n3- إضغط على \'\' إلغاء اشتراكي \'\'\n\nبالنسبة إلى iTunes و Google Play:\nانتقل إلى إدارة اشتراك Google Play أو iTunes على جهازك لإلغاء اشتراكك.\n\nيمكنك متابعة مشاهدة Shahid VIP ، حتى يتم إغلاق حسابك تلقائيًا في نهاية فترة الإشتراك الحالية.')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"), 'كم عدد الأجهزة المسموح بها لكل حساب؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesDescriptionText"), 'يمكنك ربط ما يصل إلى 5 أجهزة لكل حساب ، ويمكنك التحكم فيها من خلال \'\'إدارة الجهاز\'\' ضمن حسابك / الإعدادات.')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"))

		new Shahid().verifyFooterElements()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.closeBrowser()
	}


	@Given('I want to Verify create account page form Player')
	def I_want_to_Verify_create_account_page_form_Player(){
		new Shahid().NavigateToShahid()

		List<String> Itemslist = new Shahid().ScrollUntilElementPresent('Object Repository/HomeScreen/Show Thumbnail/showThumbnail','الفتوة')
		String ThmbnailXpath= Itemslist[0]
		String ThmbnailName = Itemslist[1]
		String[] HomePageShowTextDesc = ThmbnailName.split("،")
		String HomePageShowTitle=HomePageShowTextDesc[0]

		TestObject ThmbnailOBJ = WebUI.modifyObjectProperty(findTestObject("Object Repository/HomeScreen/Show Thumbnail/showThumbnail"), 'xpath', 'equals', ThmbnailXpath, true)
		WebUI.click(ThmbnailOBJ)

		//ShowPageMetaData to Get Show Title
		String ShowPageShowText = WebUI.getAttribute(findTestObject('Object Repository/ShowScreen/showMetaData'), 'alt')
		String[] ShowPageShowTextDesc = ShowPageShowText.split("،")
		String ShowPageShowTitle="مسلسل "+ShowPageShowTextDesc[0]
		WebUI.verifyEqual(HomePageShowTitle, ShowPageShowTitle )

		WebUI.scrollToElement(findTestObject('Object Repository/ShowScreen/RelatedSection/episodeSection'), 2)
		WebUI.click(findTestObject('Object Repository/ShowScreen/RelatedSection/episodeSection'))
		WebUI.click(findTestObject('Object Repository/ShowScreen/RelatedSection/episodeSliderElement-TryShahidVIP'))
		WebUI.click(findTestObject('Object Repository/MovieScreen/tryShahidVIPButton'))

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/subscribeNowDescriptionText'), 'اشترك الآن واستمتع بالتجربة المجانية')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/FHDIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/FHDIconText'), 'جودة عالية الدقة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/noADsIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/noADsIconText'), 'بدون فواصل إعلانية')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/continueWatchingIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/continueWatchingIconText'), 'مواصلة المشاهدة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/offlineIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/CenterSection/offlineIconText'), 'تحميل اوفلاين')

		//Verify Packages Section

		//verify Monthly Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyPackageGrid"), 2)
		String monthlyPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyPackageGrid"))
		String[] monthlyPackageTextSplit=monthlyPackageText.split('\n')
		String monthlyPackageTitle=monthlyPackageTextSplit[0]
		String monthlyPackagePrice=monthlyPackageTextSplit[1]
		String monthlyPackageSpotifyText=monthlyPackageTextSplit[2]
		WebUI.verifyEqual(monthlyPackageTitle, 'الباقة الشهرية')
		WebUI.verifyEqual(monthlyPackagePrice, '2.99 JOD / شهرياً')
		WebUI.verifyEqual(monthlyPackageSpotifyText, '6 أشهر مجانية من Spotify')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCIcon'),'البطاقة المصرفية')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorIcon'),'الجوّال')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyNetworkOperatorButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		//verify Annual Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualPackageGrid"), 2)
		String annualPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualPackageGrid"))
		String[] annualPackageTextSplit=annualPackageText.split('\n')
		String annualPackageTitle=annualPackageTextSplit[0]
		String annualPackageMoreFrugal=annualPackageTextSplit[1]
		String annualPackagePrice=annualPackageTextSplit[2]
		String annualPackageSpotifyText=annualPackageTextSplit[3]
		WebUI.verifyEqual(annualPackageTitle, 'الباقة السنوية')
		WebUI.verifyEqual(annualPackageMoreFrugal, '44% اوفر')
		WebUI.verifyEqual(annualPackagePrice, '19.99 JOD / سنوياً')
		WebUI.verifyEqual(annualPackageSpotifyText, '6 أشهر مجانية من Spotify')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCIcon'),'البطاقة المصرفية')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/annualCCButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()


		////verify weekly Package Grid
		WebUI.verifyElementPresent(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyPackageGrid"), 2)
		String weeklyPackageText= WebUI.getText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyPackageGrid"))
		String[] weeklyPackageTextSplit=weeklyPackageText.split('\n')
		String weeklyPackageTitle=weeklyPackageTextSplit[0]
		String weeklyPackagePrice=weeklyPackageTextSplit[1]
		String weeklyPackageSpotifyCancellationText=weeklyPackageTextSplit[2]
		WebUI.verifyEqual(weeklyPackageTitle, 'الباقة الأسبوعية')
		WebUI.verifyEqual(weeklyPackagePrice, '0.99 JOD / أسبوعياً')
		WebUI.verifyEqual(weeklyPackageSpotifyCancellationText, 'يمكنك إلغاء الإشتراك في أي وقت')

		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorIcon'),'الجوّال')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorButton'), 'اشترك')
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/weeklyNetworkOperatorButton'))

		//Verify Login Page
		new Shahid().VerifyLoginPage()

		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherIcon'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherDescriptionText'), 'إذا كان لديك قسيمة اشتراك')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherButton'), 'اضغط هنا')

		//Verify Redeem Voucher Page
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/voucherButton'))
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/redeemVoucherTitleText'), 'احصل على اشتراك SHAHID VIP')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/enterVoucherText'), 'بمجرد ادخال رمز القسيمة')
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/enterVouherField'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/activeSubscriptionButton'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/RedeemVoucherPage/termsAndConditionsText'), 'تطبق الشروط والأحكام، في حال واجهتك أي مشكلة الرجاء التواصل مع مركز رعاية المتعاملين .')
		WebUI.back()

		//Verify ShahidVIP Features List
		WebUI.scrollToElement(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/shahidVIPFeatureTitleText'), 2)
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/shahidVIPFeatureTitleText'), 'مميزات Shahid VIP',FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/liveFeatureText"), 'شاهد أفضل محتوى مباشرةً بعد بث التلفزيون')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/arabicContantFeatureText"), 'أكبر مكتبة للمحتوى العربي أكثر من 40,000 حلقة')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/multiDevicesFeatureText"), 'على أي جهاز - الكمبيوتر والجوّال والأجهزة اللوحية والتلفاز')
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/noADSFeatureText'), 'بدون فواصل إعلانية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/shahidOriginalsFeatureText"), 'أعمال شاهد الأصلية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/exclusiveSeriesFeatureText"), 'مسلسلات حصرية لأول مرة')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/arabicMoviesFeatureText"), 'أحدث الأفلام العربية بعد عرض السينما مباشرةً')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/marvel-DisneyContantFeatureText"), 'أضخم الإنتاجات والبرامج الحاصلة على جوائز من ديزني و مارفل')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/offlineFeatureText"), 'التحميل للمشاهدة أوفلاين')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/kidsSafeContantFeatureText"), 'أفضل محتوى ترفيهي آمن للأطفال من ديزني، بيكسار، كرتون نتورك ونيكلوديون')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/liveBroadcastfeatureText"), 'قنوات تلفزيونية مباشرة بجودة عالية')
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/watchWhileTravelingFeatureText"), 'مشاهدة أثناء السفر')

		//Verify VIP&FreeCheck
		for (def i = 1; i <=15; i++){
			String Xpath  ="(//img[@src='/static/fonts/2d48ee763477ce8dac5a1713ed4230d4.svg'])"+ [i]
			TestObject Check = WebUI.modifyObjectProperty(findTestObject("Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/VIP-FreeCheck"),'xpath', 'equals', Xpath, true)
			if( i==1 || i==3 || i==5){
				WebUI.focus(Check)
				WebUI.verifyElementAttributeValue(Check,'alt', 'free_Check', 1)
			}else{
				WebUI.verifyElementAttributeValue(Check, 'alt', 'VIP_Check', 1)
			}
		}

		//Verify FreeUncheck
		for (def i = 1; i <=9 ; i++) {
			def Xpath  ="//img[@src='/static/fonts/1be624b7e735db6ea7c64cf867a299e9.svg'])"+ [i]

			TestObject FreeUncheck = WebUI.modifyObjectProperty(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/freeUncheck'),'xpath', 'equals', Xpath, true)
			WebUI.verifyElementAttributeValue(FreeUncheck, 'alt', 'free_uncheck', 1)
		}



		//Verify Other Inquiries Section
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/otherInquiriesTitleText"), 'هل لديك استفسارات أخرى؟')

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"), 'كيف يمكنني الاشتراك بخدمة شاهد VIP؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeDescriptionText"), 'يمكنك الاشتراك في شاهد VIP من خلال اتباع الخطوات التالية هنا:\n\n1- حدد الباقة وطريقة الدفع الأنسب لك\n2- أدخل بريدك الإلكتروني وكلمة المرور\n3- أدخل تفاصيل الدفع الخاصة بك\n4- استمتع بمشاهدة أفضل محتوى على شاهد VIP')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/howCanISubscribeInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"), 'إذا كانت فترة تجريبية مجانية ، فلماذا يتوجب عليّ إدخال تفاصيل الدفع؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodDescriptionText"), 'نطلب منك تزويدنا بطريقة دفع للتأكد من عدم انقطاع الخدمة بعد انتهاء التجربة المجانية. نقوم بذلك عن طريق إرسال طلب تفويض إلى مؤسستك المالية للتحقق من أن طريقة الدفع فعّالة. لا تعتبر هذه الطلبات كرسوم لكنها في بعض الحالات قد تؤثر مؤقتًا على رصيد حسابك المتاح')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/trialPeriodInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"), 'هل يمكنني إلغاء إشتراك شاهد VIP في أي وقت؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeDescriptionText"), 'نعم ، يمكنك الإلغاء في أي وقت. لن يتم محاسبتك مرة أخرى ، ما لم تقم بإعادة تفعيل عضويتك.\n\nخطوات الإلغاء:\nلخيارات الدفع عبر الهاتف وبطاقات الائتمان:\n1- اذهب إلى إعدادات الحساب باستخدام ملف تعريف البالغين\n2- اضغط على معلومات الاشتراك\n3- إضغط على \'\' إلغاء اشتراكي \'\'\n\nبالنسبة إلى iTunes و Google Play:\nانتقل إلى إدارة اشتراك Google Play أو iTunes على جهازك لإلغاء اشتراكك.\n\nيمكنك متابعة مشاهدة Shahid VIP ، حتى يتم إغلاق حسابك تلقائيًا في نهاية فترة الإشتراك الحالية.')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/unsubscribeInquiryText"))

		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"), 'كم عدد الأجهزة المسموح بها لكل حساب؟')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"))
		WebUI.verifyElementText(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesDescriptionText"), 'يمكنك ربط ما يصل إلى 5 أجهزة لكل حساب ، ويمكنك التحكم فيها من خلال \'\'إدارة الجهاز\'\' ضمن حسابك / الإعدادات.')
		WebUI.click(findTestObject("Object Repository/SignUpScreen/subscriptionPage/OtherInquiriesSection/allowedDevicesInquiryText"))

		//Verify Footer Elements
		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/DoYouNeedHelpText'), 'هل تحتاج للمساعدة بخصوص اشتراكك ؟ اتصل على الأرقام التالية :')
		String DoYouNeedHelpText=WebUI.getText(findTestObject('Object Repository/SignUpScreen/footerText'))
		String[] DoYouNeedHelpTextSplit=DoYouNeedHelpText.split('\n')
		String ContactUsTest=DoYouNeedHelpTextSplit[1]
		for(def i=2;i<=8;i++){

			ContactUsTest+=DoYouNeedHelpTextSplit[i]
		}

		WebUI.verifyEqual(ContactUsTest, 'المملكة العربية السعودية:00966920006858الإمارات العربية المتحدة:0097145677477المملكة الأردنية الهاشمية:0096265777577الرقم الدولي:00966138219595')
		new Shahid().verifyFooterElements()


		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)


		WebUI.closeBrowser()
	}


	//Verify SignUP Steps
	@Given("I want to Verify SignUP Steps")
	def I_want_to_Verify_SignUP_Steps(){
		new Shahid().NavigateToShahid()
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		String RandomKey='mbc@123'
		String Email= new Shahid().mohmalEmail()

		WebUI.setText(findTestObject('LoginScreen/usernameField'), Email)
		WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		if(WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 2)){
			if(WebUI.waitForElementNotPresent(findTestObject('Object Repository/LoginScreen/Error Messages/EC1002'), 3)){
				WebUI.delay(2)
				WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
			}
		}

		if(WebUI.waitForElementNotPresent(findTestObject('LoginScreen/passwordField'),6)) {
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/LoginScreen/continueButton'))
		}

		WebUI.waitForElementPresent(findTestObject('Object Repository/LoginScreen/passwordField'), 5)
		WebUI.setText(findTestObject('Object Repository/LoginScreen/passwordField'), RandomKey)
		WebUI.click(findTestObject('Object Repository/SignUpScreen/termsAndConditionsCheckbox'))
		WebUI.click(findTestObject('Object Repository/SignUpScreen/accepttoReceivePromotionsandNewsCheckbox'))
		WebUI.click(findTestObject('Object Repository/SignUpScreen/createButton'))
		//		WebUI.verifyElementText(findTestObject('Object Repository/SignUpScreen/Error Messages/operationFailed'),'لم تتم العملية. يرجى المحاولة مجدداً، أو مراجعة خدمة العملاء في حال استمرار المشكلة.')
		new Shahid().popupNotification()
		WebUI.waitForElementPresent(findTestObject('Object Repository/UserProfile/userprofileIconDEF'), 5)
		List<WebElement> UserProfile = driver.findElements(By.xpath(GlobalVariable.userProfileXpath))
		UserProfile[0].click()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()
	}

	@Then("I want to Verify SignUP Steps form Try ShahidVIP Button")
	def I_want_to_Verify_SignUP_Steps_form_Try_ShahidVIP_Button(){
		new Shahid().NavigateToShahid()
		WebUI.click(findTestObject("Object Repository/SignUpScreen/tryShahidVIPButton"))
		WebUI.delay(2)

		WebUI.click(findTestObject('Object Repository/SignUpScreen/tryShahidVIPNowButton'))
		WebUI.delay(2)

		//Verify SignUP Steps in Packages Section
		//verify SignUP Steps in Monthly Package Grid
		WebUI.click(findTestObject('Object Repository/SignUpScreen/subscriptionPage/packagesSection/monthlyCCButton'))
		String MSISDN=new Shahid().RandomMSISDN()
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), MSISDN)
		WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
		WebUI.delay(1)
		new Shahid().verifyCounter('Object Repository/Custom Keywords OBJ/ResendCode')
	}
	
	
	//Signup using Invalid Username
	@Given('I want to Signup using Invalid (.*)')
	def I_want_to_Signup_using_Invalid_Username(String userType) {
		String user
		new Shahid().NavigateToShahid()
		if(userType=="Email") {
			user ='alaa@alaa'
		}else if(userType=="Mobile") {
			user=GlobalVariable.invalidMsisdn
		}


		WebUI.click(findTestObject('Object Repository/LoginScreen/loginLink'))
		WebUI.setText(findTestObject('Object Repository/LoginScreen/usernameField'), user)
		Boolean emailvalidation=new Shahid().isEmailValid('alaa@alaa')
		if(emailvalidation) {
			WebUI.click(findTestObject('Object Repository/LoginScreen/loginButton'))
			WebUI.delay(2)
			String PageUrl=WebUI.getUrl()
			PageUrl.contains('shahid.net/ar/widgets/registration')
			WebUI.verifyElementText(findTestObject('Object Repository/Registration Page/createShahidAccountTitleText'), 'إنشاء حساب SHAHID')

		}else {
			if(userType=="Email") {
				WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyUsername'), 3)
			}else if(userType=="Mobile") {
				WebUI.verifyElementPresent(findTestObject('Object Repository/LoginScreen/Error Messages/emptyMsisdn'), 3)
			}

		}
		WebUI.delay(1)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		String methodName = stacktrace[5].getMethodName()
		//new Shahid().takeScreenshot(featureName,methodName)

		WebUI.closeBrowser()


	}
}
