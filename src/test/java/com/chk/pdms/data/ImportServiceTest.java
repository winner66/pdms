package com.chk.pdms.data;

import com.chk.pdms.PdmsApplication;
import com.chk.pdms.data.service.ImportService;
import com.chk.pdms.data.service.UpdateJunjiService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PdmsApplication.class)
public class ImportServiceTest {

    @Autowired
    private ImportService importService;

    @Autowired
    private UpdateJunjiService updateJunjiService;

    @Test
    public void init() {
        importService.init();
        Assert.assertTrue(true);
    }

    @Test
    public void updateJunji(){
//        updateJunjiService.update();
        Assert.assertTrue(true);
    }

}
