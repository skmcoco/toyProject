package com.excel.practice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExcelMapper {
	void insertExcelData(FileVO fileVO);
}
