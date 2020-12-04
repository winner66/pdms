package com.chk.pdms.data.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class EasyExcelUtil {

  //一个sheet 10万条数据
    private static final int MAXROWS = 100000;


    /**
     * 获取默认表头内容的样式
     * @return
     */
    private static HorizontalCellStyleStrategy getDefaultHorizontalCellStyleStrategy(){
        /** 表头样式 **/
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景色（浅灰色）
        // 可以参考：https://www.cnblogs.com/vofill/p/11230387.html
        headWriteCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        // 字体大小
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 10);
        headWriteCellStyle.setWriteFont(headWriteFont);
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        /** 内容样式 **/
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 内容字体样式（名称、大小）
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontName("宋体");
        contentWriteFont.setFontHeightInPoints((short) 10);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //设置内容垂直居中对齐
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置内容水平居中对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //设置边框样式
        contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
        contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
        contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        // 头样式与内容样式合并
        return new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
    }

    /**
     * 导出
     * @param response
     * @param data
     * @param fileName
     * @param sheetName
     * @param clazz
     * @throws Exception
     */
    public static void writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName, String sheetName, Class clazz) throws Exception {
        long exportStartTime = System.currentTimeMillis();
//        log.info("报表导出Size: "+data.size()+"条。");
        EasyExcel.write(getOutputStream(fileName, response), clazz).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).registerWriteHandler(getDefaultHorizontalCellStyleStrategy()).doWrite(data);
//        System.out.println("报表导出结束时间:"+ new Date()+";写入耗时: "+(System.currentTimeMillis()-exportStartTime)+"ms" );
    }

    /**


     * @param data  查询结果
     * @param fileName 导出文件名称
     * @param clazz 映射实体class类
     * @param <T>  查询结果类型
     * @throws Exception
     */
    public static<T> void writeExcel( List<T> data, String fileName, Class clazz) throws Exception {
        long exportStartTime = System.currentTimeMillis();


        List<List<T>> lists = ExcelSheetSplitList.splitList(data,MAXROWS); // 分割的集合

//        OutputStream out = getOutputStream(fileName, response);
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(fileName+".xlsx",  clazz).excelType(ExcelTypeEnum.XLSX).registerWriteHandler(getDefaultHorizontalCellStyleStrategy());
        ExcelWriter excelWriter = excelWriterBuilder.build();
        ExcelWriterSheetBuilder excelWriterSheetBuilder;
        WriteSheet writeSheet;
        System.out.println("!!!!!!!!!!!!");
        System.out.println(data.size());
        System.out.println(lists.size());

        for (int i =1;i<=lists.size();i++){
            excelWriterSheetBuilder = new ExcelWriterSheetBuilder(excelWriter);
            excelWriterSheetBuilder.sheetNo(i);
            excelWriterSheetBuilder.sheetName("sheet"+i);
            writeSheet = excelWriterSheetBuilder.build();
            excelWriter.write(lists.get(i-1),writeSheet);
        }
//        out.flush();
        excelWriter.finish();
//        out.close();
//        System.out.println("报表导出结束时间:"+ new Date()+";写入耗时: "+(System.currentTimeMillis()-exportStartTime)+"ms" );
    }
// 浏览器中调用
//    public static<T> void writeExcelWin( List<T> data, String fileName, Class clazz) throws Exception {
//        long exportStartTime = System.currentTimeMillis();
//
//
//        List<List<T>> lists = ExcelSheetSplitList.splitList(data,MAXROWS); // 分割的集合
//
//        OutputStream out = getOutputStream(fileName, response);
//        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(fileName,  clazz).excelType(ExcelTypeEnum.XLSX).registerWriteHandler(getDefaultHorizontalCellStyleStrategy());
//        ExcelWriter excelWriter = excelWriterBuilder.build();
//        ExcelWriterSheetBuilder excelWriterSheetBuilder;
//        WriteSheet writeSheet;
//        for (int i =1;i<=lists.size();i++){
//            excelWriterSheetBuilder = new ExcelWriterSheetBuilder(excelWriter);
//            excelWriterSheetBuilder.sheetNo(i);
//            excelWriterSheetBuilder.sheetName("sheet"+i);
//            writeSheet = excelWriterSheetBuilder.build();
//            excelWriter.write(lists.get(i-1),writeSheet);
//        }
////        out.flush();
//        excelWriter.finish();
////        out.close();
////        System.out.println("报表导出结束时间:"+ new Date()+";写入耗时: "+(System.currentTimeMillis()-exportStartTime)+"ms" );
//    }


    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //  response.setContentType("application/vnd.ms-excel"); // .xls
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); // .xlsx
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        return response.getOutputStream();
    }

}
