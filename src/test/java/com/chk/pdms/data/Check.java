package com.chk.pdms.data;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Check {
    public static void main(String[] args) {
//        String s = ";C;D;\n" +
////                ";J;K;\n" +
////                ";G;J;K;\n" +
////                ";K;M;\n" +
////                ";B;C;D;\n" +
////                ";F;G;J;K;M;\n" +
////                ";J;K;M;\n" +
////                ";M;\n" +
////                ";B;\n" +
////                ";B;C;\n" +
////                ";F;G;J;K;\n" +
////                ";D;\n" +
////                ";G;J;K;M;\n" +
////                ";Z;\n" +
////                ";M;Z;\n" +
////                ";J;K;M;S;\n" +
////                ";K;M;S;Z;\n" +
////                ";C;D;;\n" +
////                ";D;K;M;\n" +
////                ";M;K;S;\n" +
////                ";K;M;S;\n" +
////                ";M;S;\n" +
////                ";A;B;C;D;\n" +
////                ";F;G;J;K;M;S;Z;";

        String s = "\n" +
                ";Z;M;\n" +
                ";Z;\n" +
                ";M;\n" +
                ";Z;M;Y;\n" +
                ";Z;M;Y;A;\n" +
                ";Z;Y;A;\n" +
                ";C;G;\n" +
                ";C;D;\n" +
                ";P-C;\n" +
                ";C;\n" +
                ";P;\n" +
                ";N;\n" +
                ";B;\n" +
                ";E;";

        s = StringUtils.replace(s, "\n", "");
        String[] ss = StringUtils.split(s, ";");
        Set<String> set =new LinkedHashSet<>();
        for (String s1 : ss) {
            set.add(s1);
        }
        System.out.println(set);
    }
}
