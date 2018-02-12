package com.controller;

import com.service.RecoginzeExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ycc on 18/2/12.
 */
@Controller
@RequestMapping(value = "/recoginze")
public class RecoginzeController {
    @Autowired
    private RecoginzeExcel recoginzeExcel;


    /**
     * 获得表格图片识别的结果id
     * @param filename
     * @return
     */
    @RequestMapping(value = "/readpicture",method = RequestMethod.GET)
    @ResponseBody
    public String getRequestId(@RequestParam(value = "filename")String filename){
        String result = recoginzeExcel.recoginze(filename);
        return result;
    }

    @RequestMapping(value = "/getresultfile",method = RequestMethod.GET)
    @ResponseBody
    public String getResult(@RequestParam(value = "requestid")String requestid,String resulttype){
        String result = recoginzeExcel.getRecoginzeResult(requestid,resulttype);
        return result;
    }


}
