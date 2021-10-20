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

public class LinkPenCallManageExcelDownload extends AbstractExcelView {
	
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
		setText(getCell(sheet, 2, 0), messageSource.getMessage("linkpenrec.name.column.number", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 1), messageSource.getMessage("linkpenrec.name.column.gubun", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 2), messageSource.getMessage("linkpenrec.name.column.counselor", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 3), messageSource.getMessage("linkpenrec.name.column.customernumber", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 4), messageSource.getMessage("linkpenrec.name.column.customername", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 5), messageSource.getMessage("linkpenrec.name.column.facetoface", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 6), messageSource.getMessage("linkpenrec.name.column.visitingplace", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 7), messageSource.getMessage("linkpenrec.name.column.date", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 8), messageSource.getMessage("linkpenrec.name.column.visitdateclass", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 9), messageSource.getMessage("linkpenrec.name.column.playlength", null, Locale.getDefault()));
		setText(getCell(sheet, 2, 10), messageSource.getMessage("linkpenrec.name.column.uploaddate", null, Locale.getDefault()));
		
		
		
		
		
		Map<String, Object> map= (Map<String, Object>) model.get("recordExcelMap");
		List<Object> categories = (List<Object>) map.get("recordExcel");
 
		boolean isVO = false;
 
		if (categories.size() > 0) {
			Object obj = categories.get(0);
		}
		
		for (int i = 0; i < categories.size(); i++) {

				Map<String, String> category = (Map<String, String>) categories.get(i);
				
				//번호
				cell = getCell(sheet,3+i,0);
				setText(cell,String.valueOf(category.get("rownum")));
				
				//구분
				cell = getCell(sheet,3+i,1);
				if(category.get("recordFileName").substring(category.get("recordFileName").length()-3,category.get("recordFileName").length()).equals("amr")){
					setText(cell, messageSource.getMessage("linkCall.name.tableValue.division.cellphone", null, Locale.getDefault()));
				}else if(category.get("recordFileName").substring(category.get("recordFileName").length()-3,category.get("recordFileName").length()).equals("wav")){
					setText(cell, messageSource.getMessage("linkCall.name.tableValue.division.ziphone", null, Locale.getDefault()));
				}else{
					
				}
				
				//상담원
				cell = getCell(sheet,3+i,2);
				setText(cell,category.get("firstname"));

				//고객번호
				cell = getCell(sheet,3+i,3);
				setText(cell,category.get("phoneNumber"));

				//고객명
				cell = getCell(sheet,3+i,4);
				setText(cell,category.get("customerName"));

				//대면
				cell = getCell(sheet,3+i,5);
				setText(cell,category.get("facetoface"));
				
				//방문지
				cell = getCell(sheet,3+i,6);
				setText(cell,category.get("visitPlace"));
				
				//방문일
				cell = getCell(sheet,3+i,7);
				setText(cell,category.get("visitDate"));

				//방문일 구분
				cell = getCell(sheet,3+i,8);
				setText(cell,category.get("visitDateClass"));

				//재생길이
				cell = getCell(sheet,3+i,9);
				setText(cell,TextUtil.convertDuration(String.valueOf(category.get("playTime"))));

				//업로드 일시
				cell = getCell(sheet,3+i,10);
				setText(cell,category.get("uploadDate"));
			
		}
	}
	
}