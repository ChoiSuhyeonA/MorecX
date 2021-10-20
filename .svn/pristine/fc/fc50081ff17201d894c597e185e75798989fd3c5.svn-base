package kr.co.irlink.zirecx.record.web;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.TextUI;

import kr.co.irlink.zirecx.util.TextUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class RecordManageExcelDownload extends AbstractExcelView {
	
	@Resource(name="messageSource")
	MessageSource messageSource ;

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook wb,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HSSFCell cell = null;

		HSSFSheet sheet = wb.createSheet(messageSource.getMessage("recordManagerMain.title.recordlist", null, Locale.getDefault()));
		sheet.setDefaultColumnWidth((int) 12);
 
		// put text in first cell
		cell = getCell(sheet, 0, 0);
 
		// set header information
		setText(getCell(sheet, 2, 0), messageSource.getMessage("record.name.column.number", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 1), messageSource.getMessage("record.name.column.groupname", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 2), messageSource.getMessage("record.name.column.username", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 3), messageSource.getMessage("record.name.column.userid", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 4), messageSource.getMessage("record.name.column.phonenumber", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 5), messageSource.getMessage("record.name.column.sendreceive", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 6), messageSource.getMessage("record.name.column.custphonenumber", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 7), messageSource.getMessage("record.name.column.calldate", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 8), messageSource.getMessage("record.name.column.callstarttime", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 9), messageSource.getMessage("record.name.column.callduration", null, Locale.getDefault()));
//		setText(getCell(sheet, 2, 10), messageSource.getMessage("record.name.column.filename", null, Locale.getDefault()));

		Map<String, Object> map= (Map<String, Object>) model.get("recordExcelMap");
		List<Object> categories = (List<Object>) map.get("recordExcel");
 
		boolean isVO = false;
 
		if (categories.size() > 0) {
			Object obj = categories.get(0);
		}
 
		for (int i = 0; i < categories.size(); i++) {

				Map<String, String> category = (Map<String, String>) categories.get(i);
 
				cell = getCell(sheet, 3 + i, 0);
				setText(cell, String.valueOf(i+1));
 
				cell = getCell(sheet, 3 + i, 1);
				setText(cell, category.get("groupName"));
 
				cell = getCell(sheet, 3 + i, 2);
				setText(cell, category.get("firstname"));
 
				cell = getCell(sheet, 3 + i, 3);
				setText(cell, category.get("zirecxId"));
				 
				cell = getCell(sheet, 3 + i, 4);
				setText(cell, category.get("phonenumber"));
				 
				cell = getCell(sheet, 3 + i, 5);
				setText(cell, category.get("io"));
				 
				cell = getCell(sheet, 3 + i, 6);
				setText(cell, category.get("remoteparty"));
				 
				cell = getCell(sheet, 3 + i, 7);
				setText(cell, category.get("date"));
				 
				cell = getCell(sheet, 3 + i, 8);
				setText(cell, category.get("time"));
				
				cell = getCell(sheet, 3 + i, 9);
				setText(cell, TextUtil.convertDuration(String.valueOf(category.get("duration"))));
				
//				cell = getCell(sheet, 3 + i, 10);
//				setText(cell, category.get("fileName"));
 
		}
	}
}