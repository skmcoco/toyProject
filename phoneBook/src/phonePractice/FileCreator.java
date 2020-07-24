package phonePractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileCreator {
	
	public void excelCreator(ArrayList<MyPhoneInfo> phoneBook) {
		
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));

		String path = "C:\\Users\\shincom\\Desktop\\BackEnd\\Spring4.0\\fileSave";
		String fileNm = "phoneBook_" + today + ".xlsx";
		String fileFullNm = path + fileNm;

		int rowIdx = 0;

		// 워크북 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 워크시트 생성
		XSSFSheet sheet = workbook.createSheet();
		// 행생성
		XSSFRow row = sheet.createRow(rowIdx);
		// 셀 셍성
		XSSFCell cell;

		// 셀 스타일 설정
		CellStyle alignCenter = workbook.createCellStyle();
		alignCenter.setAlignment(HorizontalAlignment.CENTER);

		// 셀 병합
//		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));

		cell = row.createCell(rowIdx);
		cell.setCellStyle(alignCenter);
		cell.setCellValue("PhoneInfo List");

		// 헤드 행 생성
		row = sheet.createRow(rowIdx++);

		// 헤더 정보 구성
		String[] nameList = { "전화번호", "이름", "관계 ", "생년월일" };

		for (int i = 0; i < nameList.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(nameList[i]);
		}

		MyPhoneInfo mpi;

		// 데이터 입력
		for (int i = 0; i < phoneBook.size(); i++) {
			mpi = phoneBook.get(i);

			row = sheet.createRow(rowIdx++);

			// 셀 내용입력
			String[] arrCell = { mpi.getPhoneNumber(), mpi.getName(), mpi.getRelation(), mpi.getBirthday() };

			for (int j = 0; j < arrCell.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(arrCell[j]);
			}
		}

		// 입력된 내용을 파일로 쓰기
		File file = new File(fileFullNm);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}