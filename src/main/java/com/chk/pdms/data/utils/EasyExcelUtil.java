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
import com.chk.pdms.data.vo.FPDSeriesVo;
import org.apache.commons.codec.CharEncoding;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
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


public static void downloadFile(String filename, ByteArrayOutputStream bos, HttpServletResponse response) {
    if (filename == null) {
        throw new NullPointerException("下载文件名为空！");
    }

    // 文件名处理
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    filename = filename.matches("^.*?\\.(?:xls)x?$") ? filename : filename + ".xls";
    filename = filename.split("\\.")[0] + sdf.format(new Date()) + "." + filename.split("\\.")[1];

    try {
        filename = URLEncoder.encode(filename, CharEncoding.UTF_8);
    } catch (UnsupportedEncodingException e) {

        e.printStackTrace();
    }

    response.setHeader(HttpHeaders.ACCEPT_CHARSET, CharEncoding.UTF_8);
    response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename);

    try (OutputStream outputStream = response.getOutputStream()) {
        outputStream.write(bos.toByteArray() == null ? "".getBytes() : bos.toByteArray());
        outputStream.flush();
        bos.close();
    } catch (IOException e) {

        e.printStackTrace();
    }
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
    public static<T> void writeExcelWin( HttpServletResponse response, List<T> data, String fileName, Class clazz) throws Exception {
        long exportStartTime = System.currentTimeMillis();
//        EasyExcel.write(response.getOutputStream(), clazz).sheet("模板").doWrite(data);

        List<List<T>> lists = ExcelSheetSplitList.splitList(data,MAXROWS); // 分割的集合

        OutputStream out = getOutputStream(fileName, response);

        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(out,clazz).excelType(ExcelTypeEnum.XLSX).registerWriteHandler(getDefaultHorizontalCellStyleStrategy());
        ExcelWriter excelWriter = excelWriterBuilder.build();
        ExcelWriterSheetBuilder excelWriterSheetBuilder;
        WriteSheet writeSheet;
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
        System.out.println("写入耗时: "+(System.currentTimeMillis()-exportStartTime)+"ms" );
    }


    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
//        fileName = URLEncoder.encode(fileName, "UTF-8");
//        //  response.setContentType("application/vnd.ms-excel"); // .xls

//        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"); // .xlsx
        response.setCharacterEncoding("utf8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String file = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + file + ".xlsx");
        return response.getOutputStream();
    }

}
