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
        String fileName = "d:/vEMI.xlsx"    ;
//        EasyExcel.write(fileName, PdDetailExcel.class).sheet("模板1").doWrite(excel.data1());
//        EasyExcel.write(fileName, PdDetailExcel.class).sheet("模板2").doWrite(excel.data2());

        try {
            List<PdDetailExcel> data=excel.getExcelList();

            if(data.size()>0){
                EasyExcelUtil.writeExcel(data,fileName, PdDetailExcel.class);
            }else{
                System.out.println("没有数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
