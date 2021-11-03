import java.text.SimpleDateFormat

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.Sheet
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable 

Workbook  workbookXLS = ExcelKeywords.getWorkbook(GlobalVariable.parentalControlCodeDataPath)
Sheet sheetVIP = workbookXLS.getSheet("VIP")
Sheet sheetRegistered = workbookXLS.getSheet("Registered")
	

def date = new Date()

def sdf = new SimpleDateFormat('MM-d-yyyy||HH:mm:ss')
String currentDate= sdf.format(date)

println(ExcelKeywords.getCellValueByAddress(sheetVIP, 'A2'))
ExcelKeywords.setValueToCellByAddress(sheetVIP, 'B2', currentDate)


ExcelKeywords.saveWorkbook(GlobalVariable.parentalControlCodeDataPath, workbookXLS)