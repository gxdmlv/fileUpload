package com.gx.springbootfileupload.controller;

import com.gx.springbootfileupload.model.ReturnValue;
import com.gx.springbootfileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootfileupload.controller
 * @date 2021/1/4 16:11
 */
@Controller
public class FileUploadController {


    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/fileUpload",method = RequestMethod.GET)
    public String toFileUpload(){

        return "file-upload";
    }



    @RequestMapping("/upload")
    @ResponseBody
    public ReturnValue uploadFile(@RequestParam("myfile")  MultipartFile file){

        return fileUploadService.uploadFileTest(file);
    }

}
