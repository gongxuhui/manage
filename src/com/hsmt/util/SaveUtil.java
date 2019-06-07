package com.hsmt.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SaveUtil {
	/* 生成excle */
	public void exportExcle(String url, String excleName, List<?> listData) {
		isExclePath(url);//判文件夹是不是存在
		/* 创建一个excle */
		HSSFWorkbook workbook = new HSSFWorkbook();
		/* 创建一个工作表 可以创建多个 */
		HSSFSheet sheet = workbook.createSheet("巩旭辉");
		/*
		 * 动态创建第一行的列信息 for (int i = 0; i <= listCell.size() - 1; i++) { HSSFCell
		 * cell = row.createCell((short) i); cell.setCellValue(listCell.get(i));
		 * }
		 */
		/* 静态创建第一行列信息 */
		HSSFRow row1 = sheet.createRow(0);
		@SuppressWarnings("deprecation")
		HSSFCell cell0 = row1.createCell((short) 0);
		cell0.setCellValue("员工编号");
		@SuppressWarnings("deprecation")
		HSSFCell cell1 = row1.createCell((short) 1);
		cell1.setCellValue("员工名字");
		@SuppressWarnings("deprecation")
		HSSFCell cell2 = row1.createCell((short) 2);
		cell2.setCellValue("员工年龄");
		@SuppressWarnings("deprecation")
		HSSFCell cell3 = row1.createCell((short) 3);
		cell3.setCellValue("员工性别");
		@SuppressWarnings("deprecation")
		HSSFCell cell4 = row1.createCell((short) 4);
		cell4.setCellValue("入职时间");
		@SuppressWarnings("deprecation")
		HSSFCell cell5 = row1.createCell((short) 5);
		cell5.setCellValue("学历");
		@SuppressWarnings("deprecation")
		HSSFCell cell6 = row1.createCell((short) 6);
		cell6.setCellValue("等级");
		@SuppressWarnings("deprecation")
		HSSFCell cell7 = row1.createCell((short) 7);
		cell7.setCellValue("薪水");
		@SuppressWarnings("deprecation")
		HSSFCell cell8 = row1.createCell((short) 8);
		cell8.setCellValue("部门");
		/* 创建列 */
		for (int i = 1; i <= listData.size() - 1; i++) {
			/* 在一个工作表中创建一行 */
			HSSFRow row = sheet.createRow(i);
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) listData.get(i);
			for (int j = 0; j <= list.size() - 1; j++) {
				@SuppressWarnings("deprecation")
				HSSFCell cell = row.createCell((short) j);
				cell.setCellValue(list.get(j));
			}
		}
		/* 保存文件 */
		try

		{
			FileOutputStream fos = null;
			fos = new FileOutputStream(url + excleName);
			System.out.println("1111" + url + excleName);
			try {
				workbook.write(fos);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/* 判断数据文件夹是不是存在 */
	public void isExclePath(String exclePath) {
		File file = new File(exclePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/* 判断文件夹是不是存在 */
	public void isChartPathExist(String chartPath) {
		File file = new File(chartPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
}
