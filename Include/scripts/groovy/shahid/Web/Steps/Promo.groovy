package shahid.Web.Steps


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.Given
import internal.GlobalVariable
import shahid.utils.Shahid

class Promo {

	@Given("I want to Check Samsung Promo Page")
	def I_want_to_Check_Samsung_Promo_Page() {
		new Shahid().NavigateToPromoPage(GlobalVariable.SamsungPromoPageUrl)
		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		//Verify Center Section//
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/shahidVIPIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/samsungMobilesImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/promoTitleText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/promoDescriptionText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/includedDevicesTitleText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/includedDecvicesList'), 2)

		WebUI.click(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/activeShahidVIPNowButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/Sub-activeShahidVIPNowButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/samsungMemberText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/includedContriesDescriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/samsungPromo/Center Section/icludedCountriesList'),3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SamsungPromo/Center Section/termsAndConditionsText'), 3)

		//new Shahid().verifyFooterElements()


		WebUI.closeBrowser()


	}

	@Given("I want to Check Hisense Promo Page")
	def I_want_to_Check_Hisense_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.HisensePromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/hisenseTVImage'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/promoDescriptionText'), 3)

		WebUI.click(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/activeShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/Sub-activeShahidVIPButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/HisensePromoPage/CenterSection/termsAndConditionsText'), 3)

		//Verify Footer Elements
		//new Shahid().verifyFooterElements()


		WebUI.closeBrowser()
	}

	@Given("I want to Check Aramedia Promo Page")
	def I_want_to_Check_Aramedia_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.AramediaPromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/aramediaDescriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/AramediaLogo'), 2)

		WebUI.click(findTestObject('Object Repository/PromoPages/AramediaPromoPage/activeShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/Sub-activeShahidVIPButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/AramediaPromoPage/termsAndConditionsText'), 3)

		//Verify Footer Elements
		//new Shahid().verifyFooterElements()

		WebUI.closeBrowser()
	}

	@Given("I want to Check Toshiba Promo Page")
	def I_want_to_Check_Toshiba_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.ToshibaPromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaTVImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/toshibaPromoDescriptionText'), 3)

		WebUI.click(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/activeShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/Sub-activeShahidVIPButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ToshibaPromoPgae/termsAndConditionsText'), 3)

		//Verify Footer Elements
		//new Shahid().verifyFooterElements()

		WebUI.closeBrowser()

	}

	@Given("I want to Check Spotify Promo Page")
	def I_want_to_Check_Spotify_Promo_Page(){

		new Shahid().NavigateToPromoPage(GlobalVariable.SpotifyPromoPageUrl)
		WebDriver driver = DriverFactory.getWebDriver()

		WebUI.refresh()

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)


		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()


		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/shahid-SpotifyIcon'), 3)


		List<WebElement> TextCounter=driver.findElements(By.xpath(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/spotifyPremiumText').findPropertyValue('xpath')))

		for(int i=1;i<=TextCounter.size();i++){
			WebUI.verifyElementPresent(TextCounter[i], 3)
		}



		WebUI.click(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/tryShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/sub-tryShahidVIPButton'), 2)
		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/newSubscribersRightSectionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/existingUsersLeftSectionText'), 3)


		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/additionalInformationButton'), 2)


		//Verify Footer Elements
		new Shahid().verifyFooterElements()

		WebUI.closeBrowser()
	}

	@Given("I want to Check ArabBank Promo Page")
	def I_want_to_Check_ArabBank_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.ArabbankPromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/arabBankCustomersPromoText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/arabBankPromoImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/arabBankPromoDescriptionText'), 3)

		WebUI.click(findTestObject('Object Repository/PromoPages/SpotifyPromoPage/CenterSection/tryShahidVIPButton'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/sub-tryShahidVIPButton'), 2)
		WebUI.back()



		WebUI.click(findTestObject('Object Repository/PromoPages/ArabBankPromo/activeOfferButton'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/offersList'), 4)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/ArabBankPromo/unsubscribeText'), 2)


		//Verify Footer Elements
		new Shahid().verifyFooterElements()

		WebUI.closeBrowser()
	}

	@Given("I want to Check Mena Promo Page")
	def I_want_to_Check_Mena_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.MenaPromoPageUrl)


		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)

		//Verify Main Bar Components
		new Shahid().VerifyPromoPagesMainBarComponents()

		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/shahidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/centerDescriptionText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowButton'),2)
		//		WebUI.click(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowButton'))
		//		WebUI.waitForPageLoad(120)
		//		WebUI.back()

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/seeAvailavlePackagesText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/offlineIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/noADSIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/multipleDevicesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/cancelAnytimeIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/safeContentIcon'), 2)

		//Verify Shahid Originals Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/titleText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/descriptionText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidOriginalsSlider'), 2)
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/tryShahidVIPButton'), 2)


		//Verify Movies Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesDescriptionText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesImageContainer'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/channelsLibraryIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/tryShahidVIPButton'),2)

		//Verify Junior Section
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorhowsIcon'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorhowsIcon'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorIcon'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorDescriptionText'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/parentalControlsIcon'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/safeContentIcon'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/channelsLibrary'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/tryShahidVIPButton'),2)


		//verify prince mohammad pro leage
		//
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/princeMohLeageTitle'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/princeMohLeageDiscription'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/theRedIconLeage'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/fightSportIcon'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/AfcCupIcon'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/AfcCupText'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/MbsIcon'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowLeageButoon'),2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/sportsBroughtToYouBySscText'),2)

		//Verify TVCannels Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsPromoDescriptionText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/liveBroadcastIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsSlider'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/tryShahidVIPButton'),2)

		//verify One Subscription-Multiple Devices Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesImage'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionTitleText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionDescriptionText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidtvIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/IOSIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/appleTVIcon'), 2)
		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/smartTVIcon"), 2)
		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/chromeCastIcon"), 2)
		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/airPlayIcon"), 2)

		//sport changes table
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/startingFromText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/shahidOriginalExclusiveText'), 3)
		new Shahid().scrollFooterView()


		//TODO      alaa will check
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick1'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick1'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick2'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick3'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/MovieSeriesText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick4'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick5'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick6'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/liveTvChannelText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick7'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick8'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick9'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/princeMohLeageText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/dash'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick10'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick11'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/gBoxText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/dash2'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/dash3'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/tick12'), 3)
		//		//more features button
		//		WebUI.click(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/moreFeaturesButton'))
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/otherSportOnCssChannelText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/cancelAnyTimeText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedDevicesText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/mbc3Text'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/adFreeText'), 3)



		//Verify Packages Section
		//								WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/choosePackagesTitle'), 4)
		//		                WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/monthlyPackageCCGrid'), 2)
		//						WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/soptifyTrialPeriodText1'), 3)
		//						WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/packagesSection/weeklyPackageGrid"), 2)
		//						WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/monthlyPackageNetworkOperatorGrid'), 2)
		//						WebUI.verifyElementText(findTestObject("Object Repository/PromoPages/MenaPromoPage/packagesSection/soptifyTrialPeriodText1"), 'بعد انتهاء الفترة التجريبية المجانية، ستصلك قسيمة Spotify Premium من شاهد عبر البريد الإلكتروني.')
		//						WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/packagesSection/annualPackageGrid"), 2)
		//						WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/packagesSection/marketingOffersGrid"), 2)


		//		//Verify ShahidVIP Features List
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/liveFeatureText'), 2)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/arabicContantFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/multiDevicesFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/SignUpScreen/subscriptionPage/ShahidVIPFeaturesList/noADSFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/shahidOriginalsFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/exclusiveSeriesFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/arabicMoviesFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/liveBroadcastfeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/marvel-DisneyContantFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/offlineFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/kidsSafeContantFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/watchWhileTravelingFeatureText'), 3)
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidVIPFeaturesList/cancleAnytimeText'), 3)

		//Verify naicon
		//		for (def i = 1; i <=2; i++){
		//			def Xpath  ="(//img[contains(@class, 'DesktopView_NAIcon')])"+ [i]
		//			TestObject feature = WebUI.modifyObjectProperty(findTestObject("PromoPages/MenaPromoPage/ShahidVIPFeaturesList/VIP-FreeCheck"),'xpath', 'equals', Xpath, true)
		//
		//			WebUI.focus(feature)
		//			WebUI.verifyElementPresent(feature, 2)
		//
		//		}
		//
		//		for (def i = 1; i <=8; i++){
		//			def Xpath  ="(//img[contains(@class, 'DesktopView_tickIcon_')])"+ [i]
		//			TestObject feature = WebUI.modifyObjectProperty(findTestObject("PromoPages/MenaPromoPage/ShahidVIPFeaturesList/VIP-FreeCheck"),'xpath', 'equals', Xpath, true)
		//
		//			WebUI.focus(feature)
		//			WebUI.verifyElementPresent(feature, 2)
		//
		//		}


		//		//packages
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/ChooseYourPackageTextPromo'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/ChooseYourPackageTextPromo'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/noCommitmentCancelYourSubText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/shahidVipText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/sportOnShahidVipText'), 3)
		//
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/sportonShahidVipTextGbox'), 3)
		//
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEntertainmentHd'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEnertainmentAndSportHd'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEntertainmentSportHdGbox'), 3)




		// changed
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/yearlyPackageText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/monthlyPackageText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/save44Text'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/yearlyPriceText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/monthyPriceText'), 3)
		//

		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/cancelYourSubscribtionAnyTimeMonthyText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/cancelYourSubscribtionAnyTimeYearlyText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditDebitMonthyText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditDebitYearlyText'), 3)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/mobilePaymentText'), 3)
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
		//		WebUI.delay(4)
		//		WebUI.click(findTestObject('Object Repository/PromoPages/package/creditCardDebitSubscribeButtonMonthy'))
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/anAccountIsRequiredToCompleteRegistrationProcessText'), 3)



		//WebUI.back()
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/package/mobilePaymentText'), 3)
		//		WebUI.delay(4)
		//		WebUI.click(findTestObject('Object Repository/PromoPages/package/mobilePaymentSubscribeButton'))
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/anAccountIsRequiredToCompleteRegistrationProcessText'), 3)
		//		WebUI.back()
		//
		//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
		//		WebUI.click(findTestObject('Object Repository/PromoPages/package/creditCardDebitSubscribeButtonYearly'))
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/anAccountIsRequiredToCompleteRegistrationProcessText'), 3)
		//		WebUI.back()
		//
		////		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditCardDebitIcon'), 3)
		////		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/creditCardDebitYearlyIcon'), 3)
		////		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/mobilePaymentIcon'), 3)




		//sport changes
		//
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/selectVipButton'), 3)
		//		     WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/selectSportVipButton'), 3)
		//			 WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/selectSportVipButtonGbox'), 3)
		//
		//				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/priceOnMonth'), 3)
		//				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/priceSportOnMonth'), 3)
		//				WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/priceSportOnMonthGbox'), 3)
		//
		//
		//
		//
		//
		//
		// alternative methods
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ifYouHaveVoucherCode'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/otherPaymentMethodsText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/followingAlternativeMethodsText'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereOtherPaymentMethods'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/ifYouHaveAvoucherCodeIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherPaymentMethodsIcon'), 3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/subscribtionFeesText'), 3)

		//		//Verify Other Inquiries Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText'), 2)
		WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText"), 2)
		WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/howCanISubscribeInquiryText"),2)
		//WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/trialPeriodInquiryText"), 2)
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/unsubscribeInquiryText'), 2)
		WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/allowedDevicesInquiryText"), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailDetailsText'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		//WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappContactUSText'), 3)

		//


		//WebUI.closeBrowser()
	}


	@Given("I want to Check Others Promo Page")
	def I_want_to_Check_Others_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.OthersMenaPromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)


		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/shahidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/centerDescriptionText'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/tryShahidVIPButton'),2)

		WebUI.delay(5)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/offlineIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/noADSIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/multipleDevicesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/cancelAnytimeIcon'), 2)

		//Verify Shahid Originals Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/titleText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/descriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidOriginalsSlider'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/tryShahidVIPButton'), 2)


		//Verify Movies Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesDescriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesImageContainer'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/tryShahidVIPButton'),2)


		//Verify TVCannels Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsPromoDescriptionText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/liveBroadcastIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsSlider'), 2)



		//verify One Subscription-Multiple Devices Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionTitleText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidtvIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/IOSIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/appleTVIcon'), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/smartTVIcon"), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/chromeCastIcon"), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/airPlayIcon"), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/tryShahidVIPButton'),2)

		//		//Verify Other Inquiries Section
		//WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText - Others'), 2)

		WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/howCanISubscribeInquiryText"),2)


		//WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/trialPeriodInquiryText"), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/unsubscribeInquiryText'), 2)

		WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/allowedDevicesInquiryText"), 2)


		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailDetailsText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		//
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappContactUSText'),  2)


		//Verify Footer Elements
		//new Shahid().verifyFooterElements()

		WebUI.closeBrowser()
	}

	@Given("I want to Check US Promo Page")
	def I_want_to_Check_US_Promo_Page(){
		new Shahid().NavigateToPromoPage(GlobalVariable.USMenaPromoPageUrl)

		//Take Screenshot
		String featureName = getClass().getName()
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace()
		String methodName = stacktrace[5].getMethodName()
		new Shahid().takeScreenshot(featureName,methodName)


		//Verify Center Section
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/shahidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/centerDescriptionText'), 2)
		//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/tryShahidVIPButton'),2)


		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/offlineIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/noADSIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/multipleDevicesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/cancelAnytimeIcon'), 2)

		//Verify Shahid Originals Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/titleText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/descriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidOriginalsSlider'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/tryShahidVIPButton'), 2)


		//Verify Movies Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesDescriptionText'), 3)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesImageContainer'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/tryShahidVIPButton'),2)


		//Verify TVCannels Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsPromoDescriptionText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/liveBroadcastIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsSlider'), 2)



		//verify One Subscription-Multiple Devices Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesImage'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionTitleText'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidtvIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/IOSIcon'), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/appleTVIcon'), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/smartTVIcon"), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/chromeCastIcon"), 2)

		WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/airPlayIcon"), 2)

		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/tryShahidVIPButton'),2)

		//		//Verify Other Inquiries Section
		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText - Others'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/howCanISubscribeInquiryText'),2)


		//WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/trialPeriodInquiryText'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/unsubscribeInquiryText'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/allowedDevicesInquiryText'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/loginUsingAppleTV'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/subscribeUsingAppleTV'), 2)

		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/reactivateShahidSubscription'), 2)
		//
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
		//
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailDetailsText'), 2)
		//
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
		//
		//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappContactUSText'),  2)


		//		//Verify Footer Elements
		//		new Shahid().verifyFooterElements()

		WebUI.closeBrowser()
	}
}