package com.chk.pdms.data;

import com.chk.pdms.PdmsApplication;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.data.utils.EasyExcelUtil;
import com.chk.pdms.pd.domain.PdDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PdmsApplication.class)
public class exportTest {
    @Autowired
    private PdExportExcelService excel;


    @Test
    public  void inTest(){
        String fileName = "d:/v01.xlsx" ;
//        EasyExcel.write(fileName, PdDetailExcel.class).sheet("模板1").doWrite(excel.data1());
//        EasyExcel.write(fileName, PdDetailExcel.class).sheet("模板2").doWrite(excel.data2());

        try {
//            EasyExcelUtil.writeExcel(excel.data(),fileName, PdDetailExcel.class);
//            PdDetail pdDetail= new PdDetail();
            List<PdDetailExcel> data=excel.getModelExcel(133L);


            EasyExcelUtil.writeExcel(data,fileName, PdDetailExcel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ExcelWriter excelWriter = EasyExcel.write(fileName).build();
//
//        //这里 需要指定写用哪个class去写
//        WriteSheet writeSheet1 = EasyExcel.writerSheet(0, "模板1").head(PdDetailExcel.class).build();
//
//        excelWriter.write(excel.data1(), writeSheet1);
//        WriteSheet writeSheet = EasyExcel.writerSheet(1, "模板2").head(PdDetailExcel.class).build();
//        excelWriter.write(excel.data2(), writeSheet);
//        //千万别忘记finish 会帮忙关闭流
//        excelWriter.finish();

    }


}
