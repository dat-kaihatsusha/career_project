package com.example.career_project.service;

import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RunningToolService {
  @Value("${excelFilePath}")
  private String excelFilePath;

  public static String SQL_STATEMENT = "update tableName set minout = ' ' where seqno = '%s'";

  public void runningTool() {
    try {
      List<String> stringList = new ArrayList<>();
      FileInputStream file = new FileInputStream(new File(excelFilePath));
      Workbook workbook = WorkbookFactory.create(file);
      Sheet sheet = workbook.getSheetAt(0);
      for (Row row : sheet) {
        for (Cell cell : row) {
          stringList.add(regexCell(String.valueOf(cell)));
        }
      }
      workbook.close();
      file.close();

      stringList.forEach(el -> {
        String record = String.format(SQL_STATEMENT, el);
        System.out.println(record);
      });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String regexCell(String input) {
    List<String> result = new ArrayList<>();
    String regex = "Seqno:\\d{5,6}";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
      String match = matcher.group();
      result.add(match);
    }
    return result.get(0);
  }
}
