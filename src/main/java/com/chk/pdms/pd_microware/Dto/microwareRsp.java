package com.chk.pd.pd_microware.Dto;

import java.lang.reflect.Field;

public class microwareRsp {

    public boolean isNull() {
        try {
            for (Field f : this.getClass().getDeclaredFields()) {
                if (!f.getName().equals("filterType")) {
                    Object o = f.get(this);
                    if (o != null) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
