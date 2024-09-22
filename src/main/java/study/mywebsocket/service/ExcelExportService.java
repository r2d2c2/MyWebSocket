package study.mywebsocket.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.mywebsocket.entity.user_chat;
import study.mywebsocket.repository.UserCharRepository;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelExportService {
    private final UserCharRepository user_char_repository;

    public ByteArrayInputStream exportDataToExcel() throws IOException {
        List<user_chat> entities = user_char_repository.findAll();//데이터베이스에서 모든 데이터 가져옴
        // 데이터베이스 리스트로 저장
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Data");//엑셀 파일이름

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("id");// 엑셀 헤더
            headerRow.createCell(1).setCellValue("메시지");
            // 열의 가장 첫번째 행에 셀을 만들어서 값을 넣어줌

            int rowIdx = 1;//엑셀 헤더가 있어 1부터
            for (user_chat entity : entities) {//모든 리스트 엑셀로 저장
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(entity.getName());
                row.createCell(1).setCellValue(entity.getMessage());
                // 타입을 나름 알아서 설정해 주지만 date 타입은 format을 해줘야 함
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}