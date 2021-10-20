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

public class GoodCallManageExcelDownload extends AbstractExcelView {
	
	@Resource(name="messageSource")
	MessageSource messageSource ;

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook wb,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HSSFCell cell = null;

		HSSFSheet sheet = wb.createSheet(messageSource.getMessage("recordManagerMain.title.recordlist", null, Locale.getDefault()));
		sheet.setDefaultColumnWidth((int) 15);
 
		// put text in first cell
		cell = getCell(sheet, 0, 0);
 
		// set header information
		setText(getCell(sheet, 2, 0), messageSource.getMessage("linkCall.name.column.number", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 1), messageSource.getMessage("linkCall.name.column.groupname", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 2), messageSource.getMessage("linkCall.name.column.username", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 3), messageSource.getMessage("linkCall.name.column.userid", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 4), messageSource.getMessage("linkCall.name.column.campaign", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 5), messageSource.getMessage("linkCall.name.column.customerName", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 6), messageSource.getMessage("linkCall.name.column.calldate", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 7), messageSource.getMessage("linkCall.name.column.callstarttime", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 8), messageSource.getMessage("linkCall.name.column.callduration", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 9), messageSource.getMessage("linkCall.name.column.callOutcomeMaster", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 10), messageSource.getMessage("linkCall.name.column.socialId", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 11), messageSource.getMessage("linkCall.name.column.inoutboundCode", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 12), messageSource.getMessage("linkCall.name.column.customerPhoneNumber", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 13), messageSource.getMessage("linkCall.name.column.callMemo", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 14), messageSource.getMessage("linkCall.name.column.goodcallMemo", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 15), messageSource.getMessage("linkCall.name.column.phonenumber", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 16), messageSource.getMessage("linkCall.name.column.customerUniqueCode", null, Locale.getDefault()));
		
		
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
				setText(cell, category.get("schGroupName"));
 
				cell = getCell(sheet, 3 + i, 2);
				setText(cell, category.get("firstname"));
 
				cell = getCell(sheet, 3 + i, 3);
				setText(cell, category.get("zirecxId"));
				 
				cell = getCell(sheet, 3 + i, 4);
				setText(cell, category.get("campaignName"));
				 
				cell = getCell(sheet, 3 + i, 5);
				setText(cell, category.get("customerName"));
				 
				cell = getCell(sheet, 3 + i, 6);
				setText(cell, category.get("callStartDate"));
				 
				cell = getCell(sheet, 3 + i, 7);
				setText(cell, category.get("callStartTime"));
				
				cell = getCell(sheet, 3 + i, 8);
				setText(cell, TextUtil.convertDuration(String.valueOf(category.get("durationCall"))));
				
				cell = getCell(sheet, 3 + i, 9);
				setText(cell, category.get("callOutcomeMaster"));
				
				cell = getCell(sheet, 3 + i, 10);
				setText(cell, category.get("socialId"));
				
				cell = getCell(sheet, 3 + i, 11);
				setText(cell, category.get("inoutboundCode"));
				
				cell = getCell(sheet, 3 + i, 12);
				setText(cell, category.get("phoneNumber"));
				
				cell = getCell(sheet, 3 + i, 13);
				setText(cell, category.get("callMemo"));
				
				cell = getCell(sheet, 3 + i, 14);
				setText(cell, category.get("description"));
				
				cell = getCell(sheet, 3 + i, 15);
				setText(cell, category.get("phonenumber"));
				
				cell = getCell(sheet, 3 + i, 16);
				setText(cell, category.get("customerUniqueCode"));
		}
	}
}