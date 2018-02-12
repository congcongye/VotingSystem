package com.service;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ycc on 18/2/12.
 */
@Service
public class RecoginzeExcel {
    private AipOcr client = RecoginzeUtil.getAipOcr();

    public String recoginze(String image){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();

        // 参数为本地图片路径
        JSONObject res = client.tableRecognitionAsync(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
        byte[] file = image2byte(image);
        res = client.tableRecognitionAsync(file, options);
        System.out.println(res.toString(2));
        return res.toString(2);
    }

    private byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }


    public String getRecoginzeResult(String requestId,String result_type){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("result_type", result_type);
        // 表格识别结果
        JSONObject res = client.tableResultGet(requestId, options);
        return res.toString(2);

    }
}
