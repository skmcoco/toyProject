package com.excel.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
	
	@Autowired 
	private ExcelMapper excelMapper;
	
	public void insertData(FileVO fileVO) {
		 excelMapper.insertExcelData(fileVO);
	}
}
