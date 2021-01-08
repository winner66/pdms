package com.chk.pdms.fpd.controller.V2;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.data.service.PdExportExcelService;
import com.chk.pdms.fpd.domain.FpdMap;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.domain.FpdSeries;
import com.chk.pdms.fpd.service.FpdSeriesService;
import com.chk.pdms.fpd.vo.FpdMapVo;
import com.chk.pdms.fpd.vo.FpdSeriesVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.apache.shiro.util.LifecycleUtils.init;

@Controller
@RequestMapping("/fpd/V2/fpdSeries")
public class fpdSeriesController {


    private String prefix = "fpd/V2/fpdSeries";
    @Autowired
    private FpdSeriesService fpdService;

    @Autowired
    private PdExportExcelService excel;

//    @ResponseBody
    @PostMapping("/exportFpdSeries")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public void exportfpd( HttpServletResponse response)  throws IOException {

        try {
            List<FpdSeries> FpdSeries =fpdService.listAll();
            excel.exportFpdSeriesData(FpdSeries,response,"国内外系列替代");
//            ExcelUtil.writeExcel(response,FpdSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @ResponseBody
//    @GetMapping("/exportFpdSeries")
//    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
//    public void downloadFailedUsingJson(HttpServletResponse response) throws IOException {
//        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//        try {
//            response.setContentType("application/vnd.ms-excel");
//            response.setCharacterEncoding("utf-8");
//            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
//            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//            // 这里需要设置不关闭流
//            EasyExcel.write(response.getOutputStream(), DownloadData.class).autoCloseStream(Boolean.FALSE).sheet("模板")
//                    .doWrite(data());
//        } catch (Exception e) {
//            // 重置response
//            response.reset();
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("status", "failure");
//            map.put("message", "下载文件失败" + e.getMessage());
//            response.getWriter().println(JSON.toJSONString(map));
//        }
//    }

    @GetMapping()
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public String pdModel() {
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public Page<FpdSeriesVo> list(PageReq pageReq) {
        Page<FpdSeriesVo> list = fpdService.list(pageReq);
        return list;
    }



    @GetMapping("/add")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public String add(Model model) {
        FpdSeries map = new FpdSeries();
        model.addAttribute("fpdSeries", map);
        return prefix + "/edit";
    }

    @GetMapping("/get/{id}")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public String get(Model model, @PathVariable("id") Long id) {
        FpdSeries map = fpdService.get(id);
        model.addAttribute("fpdSeries", map);
        return prefix + "/edit";
    }

    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public R save(FpdSeriesVo map) {
        fpdService.save(map);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("delete")
    @RequiresPermissions("fpd:fpdSeries:fpdSeries")
    public R delete(Long id) {
        fpdService.delete(id);
        return R.ok();
    }

}
