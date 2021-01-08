package com.chk.pdms.fpd.service;


import com.chk.pdms.common.utils.FileUtil;

import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.data.service.ImportService;
import com.chk.pdms.fpd.dao.extmapper.ExtFpdSeriesMapper;
import com.chk.pdms.fpd.dao.mapper.FpdMapMapper;
import com.chk.pdms.fpd.dao.mapper.FpdSeriesMapper;
import com.chk.pdms.fpd.domain.*;

import com.chk.pdms.fpd.vo.FpdMapVo;
import com.chk.pdms.fpd.vo.FpdSeriesVo;
import com.chk.pdms.pd.dao.PdParamDao;
import com.chk.pdms.pd.service.PdInfoService;

import com.chk.pdms.pd.vo.ImportDataVo;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.chk.pdms.fpd.dao.FpdSeriesDao;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@Service
public class FpdSeriesService {
    private Logger log = LoggerFactory.getLogger(FpdSeriesService.class);

    @Value("${virtual.filePath}")
    private String filePath;



    @Autowired
    private FpdSeriesMapper seriesMapper;
    @Autowired
    private ExtFpdSeriesMapper extFpdSeriesMapper;



    @Autowired
    private PdInfoService pdInfoService;

    @Autowired
    private PdParamDao pdParamDao;
    @Autowired
    private ImportService importService;

    @Autowired
    private FpdSeriesDao fpdSeriesDao;

    public FpdSeriesMapper getSeriesMapper() {
        return seriesMapper;
    }

    public void setSeriesMapper(FpdSeriesMapper seriesMapper) {
        this.seriesMapper = seriesMapper;
    }
    private String getFcode(String fpdCode, Integer pos, Integer bit) {
        String s = StringUtils.substring(fpdCode, pos - 1, pos + bit - 1);
        if (StringUtils.isBlank(s)) {
            return null;
        } else {
            return s;
        }
    }
    public ExtFpdSeriesMapper getExtFpdSeriesMapper() {
        return extFpdSeriesMapper;
    }

    public void setExtFpdSeriesMapper(ExtFpdSeriesMapper extFpdSeriesMapper) {
        this.extFpdSeriesMapper = extFpdSeriesMapper;
    }


    public  FpdSeries getFpdSeries(Integer id){
         FpdSeries fpdSeries= fpdSeriesDao.getSeriesMapper().selectByPrimaryKey(id);

         return  fpdSeries;
    }

    public   List<FpdSeries>  getAllFpdSeries(){
        List<FpdSeries> fpdSeries= fpdSeriesDao.getSeriesMapper().getList();
        return  fpdSeries;
    }

    public ImportDataVo importData(ImportDataVo vo) {


        String file = FileUtil.transferTo(vo.getData(), filePath, "import-data/fpd/info");
        String path = filePath + file.replace("/files", "");
        Map<String, Object> map = importService.importFPDInfo(path);
        String code = (String)map.get("code");

        ImportDataVo rsp = new ImportDataVo();
        if (code.equals("200")){
            rsp.setCode(code);
            Integer num = (Integer)map.get("num");
            if (num > 0){
                rsp.setMsg("导入成功<br>导入数量:" + num);
            }else{
                rsp.setMsg("导入完成<br>导入数量:" + num + "<br>请确认模板正确且有数据");
            }
        }else{
            rsp.setCode(code);
            Set<String> noModelInfo = (Set) map.get("noModelInfo");
            rsp.setCode(code);
            StringBuilder sb = new StringBuilder();
            for (String s : noModelInfo) {
                sb.append("<br>").append(s);
            }
            rsp.setMsg("导入失败<br>无对应型号的产品:" + sb.toString());
        }
        File dataFile = new File(path);
        if (dataFile.isFile()) {
            dataFile.delete();
        }
        return rsp;
    }
    @Transactional
    public void delete(Long id) {
        fpdSeriesDao.getSeriesMapper().deleteByPrimaryKey(Integer.valueOf(id.toString()));
    }


    public void save(FpdModel model) {

    }
    @SneakyThrows
    @Transactional
    public void save(FpdSeriesVo map) {
        if (map.getId() == null) {
            fpdSeriesDao.getSeriesMapper().insert(map);
        } else {
            fpdSeriesDao.getSeriesMapper().updateByPrimaryKey(map);
        }
    }

    public Page<FpdSeriesVo> list(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<FpdSeriesVo> fpds =fpdSeriesDao.getExtFpdSeriesMapper().list();

        Page<FpdSeriesVo> page = new Page(fpds);
        return page;
    }

    public FpdSeries get(Long id) {
        FpdSeriesExample exp= new FpdSeriesExample();
        exp.createCriteria().andIdEqualTo(Integer.valueOf(id.toString()));
        exp.setOrderByClause("id asc limit 1");
        List<FpdSeries> fpd =fpdSeriesDao.getSeriesMapper().selectByExample(exp);
        if (fpd.size() >= 1){
            return fpd.get(0);
        }else{
            return null;
        }
    }


    public List<FpdSeries> listAll() {
        return fpdSeriesDao.getSeriesMapper().getList();
    }
}
