package com.chk.pdms.common.utils;

import lombok.SneakyThrows;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IKUtil {
    @SneakyThrows
    public static List<String> analyzList(String text){
        if (StringUtils.isBlank(text)){
            return null;
        }
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex;
        List<String> list=new ArrayList<>();
        while((lex=ik.next())!=null){
            list.add(lex.getLexemeText());
        }
        return list;
    }

    @SneakyThrows
    public static String analyzStr(String text){
        if (StringUtils.isBlank(text)){
            return null;
        }
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex;
        StringBuilder sb = new StringBuilder();
        while((lex=ik.next())!=null){
            sb.append(lex.getLexemeText()).append(" ");
        }
        return sb.toString().trim();
    }

    @SneakyThrows
    public static String analyzWithSymbol(String text, String symbol) {
        if (StringUtils.isBlank(text)){
            return null;
        }
        StringReader sr=new StringReader(text);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex;
        StringBuilder sb = new StringBuilder();
        while((lex=ik.next())!=null){
            sb.append(symbol + lex.getLexemeText()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String text="中高压高频无引线多层瓷介电容器(1类瓷)|CC41L|Q/HK26013-2012+QZJ840624|G|0805|CG|500V|R01 R02 R03 R04 R05 R06 R07 R08 R09 0R1 0R2 0R3 0R4 0R5 0R6 0R7 0R8 0R9 1R0|C D|Z M Y！";
        List<String> list=analyzList(text);
        System.out.println(list);
        String s = analyzStr(text);
        System.out.println(s);
        String s1 = analyzWithSymbol(text, "+");
        System.out.println(s1);
    }
}
