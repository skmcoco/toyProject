package com.excel.practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;

	@RequestMapping("/")
	public String test() {
		return "test";
	}

	@RequestMapping(value = "excel.do")
	public String excel() throws IOException{
		
		
		return "excel";
	}
	
	@RequestMapping(value = "excelUpload.do")
	public String excelUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		
		FileVO fv = new FileVO();
		
		List<FileVO> ExcelData = new ArrayList();
		
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		try {

			Workbook wb = null;
			
			if ("xlsx".equals(extension)) {
				wb = new XSSFWorkbook(file.getInputStream());
			} else if ("xls".equals(extension)) {
				wb = new HSSFWorkbook(file.getInputStream());
			}
			
			Sheet workSheet  = wb.getSheetAt(0);
			
			int rowindex  = workSheet.getPhysicalNumberOfRows();
			
			for (int i = 1; i < rowindex; i++) {
				
				XSSFRow row = (XSSFRow) workSheet.getRow(i);
				
				if (null == row) {
					continue;
				}
				
				// 이름
				XSSFCell cell = row.getCell(0);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (null != cell) fv.setName(cell.getStringCellValue());
				
				// 이메일
				cell = row.getCell(1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (null != cell) fv.setEmail(cell.getStringCellValue());
				
				// 별명
				cell = row.getCell(2);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (null != cell) fv.setExname(cell.getStringCellValue());
				
				// 주소
				cell = row.getCell(3);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (null != cell) fv.setAddress(cell.getStringCellValue());
				
				// 아이디
				cell = row.getCell(4);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				if (null != cell) fv.setId(cell.getStringCellValue());
				ExcelData.add(fv);
			}
			
			for (int i = 0; i < ExcelData.size(); i++) {
				excelService.insertData(ExcelData.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "excel";
	}
}
