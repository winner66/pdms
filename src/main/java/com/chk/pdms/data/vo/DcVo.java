package com.chk.pdms.data.vo;

import com.chk.pdms.data.domain.DataCollect;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

@Data
public class DcVo extends DataCollect {
    private Date startDate;

    private Date endDate;

    private Integer total;

    private String dateStr;

    public String getDateStr() {
        if (this.getDate() != null){
            return new DateTime(this.getDate()).toString("yyyy-MM-dd");
        }
        return "";
    }
}
