package com.chk.pdms.data;

import com.alibaba.excel.EasyExcel;
import com.chk.pdms.data.vo.*;

import java.util.*;

public class CheckModel {

    //TODO 检查了目前已有的数据，每个产品数据sheet下的mode+std都是不重复的，即可用mode+std去设置对应产品型号的订货标识
    public static void main(String[] args) {
        String path1 = "C:\\Users\\admin\\Desktop\\new\\合并总（徐琴返）20200224.xlsx";
        String path2 = "C:\\Users\\admin\\Desktop\\new\\合并总（徐琴返）20200229-补充宇标.xlsx";
        List<DataRuleVo> dataRuleVos = EasyExcel.read(path1).head(DataRuleVo.class).sheet(DataRuleVo.sheet).doReadSync();
        List<PinVo> pinVo = EasyExcel.read(path1).head(PinVo.class).sheet(PinVo.sheet).doReadSync();
        List<MutilVo> mutilVos = EasyExcel.read(path1).head(MutilVo.class).sheet(MutilVo.sheet).doReadSync();
        List<SingleVo> singleVos = EasyExcel.read(path1).head(SingleVo.class).sheet(SingleVo.sheet).doReadSync();
        List<HKIVo> hkiVos = EasyExcel.read(path1).head(HKIVo.class).sheet(HKIVo.sheet).doReadSync();
        List<ThreeVo> threeVos = EasyExcel.read(path1).head(ThreeVo.class).sheet(ThreeVo.sheet).doReadSync();
        List<TerVo> terVos = EasyExcel.read(path1).head(TerVo.class).sheet(TerVo.sheet).doReadSync();
        List<HeartVo> heartVos = EasyExcel.read(path1).head(HeartVo.class).sheet(HeartVo.sheet).doReadSync();

        dataRuleVos.addAll(EasyExcel.read(path2).head(DataRuleVo.class).sheet(DataRuleVo.sheet).doReadSync());
        pinVo.addAll(EasyExcel.read(path2).head(PinVo.class).sheet(PinVo.sheet).doReadSync());
         mutilVos.addAll(EasyExcel.read(path2).head(MutilVo.class).sheet(MutilVo.sheet).doReadSync());
        singleVos.addAll(EasyExcel.read(path2).head(SingleVo.class).sheet(SingleVo.sheet).doReadSync());
        hkiVos.addAll(EasyExcel.read(path2).head(HKIVo.class).sheet(HKIVo.sheet).doReadSync());
        threeVos.addAll(EasyExcel.read(path2).head(ThreeVo.class).sheet(ThreeVo.sheet).doReadSync());
        terVos.addAll(EasyExcel.read(path2).head(TerVo.class).sheet(TerVo.sheet).doReadSync());
        heartVos.addAll(EasyExcel.read(path2).head(HeartVo.class).sheet(HeartVo.sheet).doReadSync());

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        Set<String> set4 = new HashSet<>();
        Set<String> set5 = new HashSet<>();
        Set<String> set6 = new HashSet<>();
        Set<String> set7 = new HashSet<>();
        Set<String> set8 = new HashSet<>();
        for (DataRuleVo vo : dataRuleVos) {
            set1.add(vo.getModel() + "|" + vo.getStd());
        }
        for (PinVo vo : pinVo) {
            set2.add(vo.getModel() + "|" + vo.getStd());
        }
        for (MutilVo vo : mutilVos) {
            set3.add(vo.getModel() + "|" + vo.getStd());
        }
        for (SingleVo vo : singleVos) {
            set4.add(vo.getModel() + "|" + vo.getStd());
        }
        for (HKIVo vo : hkiVos) {
            set5.add(vo.getModel() + "|" + vo.getStd());
        }
        for (ThreeVo vo : threeVos) {
            set6.add(vo.getModel() + "|" + vo.getStd());
        }
        for (TerVo vo : terVos) {
            set7.add(vo.getModel() + "|" + vo.getStd());
        }
        for (HeartVo vo : heartVos) {
            set8.add(vo.getModel() + "|" + vo.getStd());
        }

        int size = set1.size() + set2.size() + set3.size() + set4.size() + set5.size() + set6.size() + set7.size() + set8.size();

        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        set.addAll(set3);
        set.addAll(set4);
        set.addAll(set5);
        set.addAll(set6);
        set.addAll(set7);
        set.addAll(set8);

        System.out.println(size == set.size());
        System.out.println("over");

    }
}
