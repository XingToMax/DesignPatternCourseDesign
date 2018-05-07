package cn.nuaa.tomax.controller;

import cn.nuaa.tomax.entity.ResultCause;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author: ToMax
 * @Description: 测试新增的文件上传功能的controller
 * @Date: Created in 2018/5/7 15:02
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    /**
     * 默认上传文件输出路径
     */
    private static final String OUT_DIRECTORY_PATH = "E://tmp/";

    /**
     * 单个文件上传测试，无输入校验（单个文件大小应低于5M）
     * @param file
     * @return JsonObject 上传结果
     * @throws IOException
     */
    @RequestMapping(value = "single", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause uploadSingleFile(MultipartFile file) throws IOException {
        FileCopyUtils.copy(file.getBytes(),new File(OUT_DIRECTORY_PATH+file.getOriginalFilename()));
        return new ResultCause(ResultCause.SUCCESS_CODE,"文件上传成功");
    }


    /**
     * 多个文件上传测试接口
     * @param files
     * @return JsonObject 上传结果
     * @throws IOException
     */
    @RequestMapping(value = "multi", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    ResultCause uploadMultiFiles(List<MultipartFile> files) throws IOException {
        for (MultipartFile in : files){
            FileCopyUtils.copy(in.getBytes(),new File(OUT_DIRECTORY_PATH+in.getOriginalFilename()));
        }
        return new ResultCause(ResultCause.SUCCESS_CODE, "多文件上传成功");
    }
}
