package com.gx.springbootfileupload.service.impl;

import com.gx.springbootfileupload.model.ReturnCodeAndMsgEnum;
import com.gx.springbootfileupload.model.ReturnValue;
import com.gx.springbootfileupload.service.FileUploadService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootfileupload.service.impl
 * @date 2021/1/4 16:39
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Override
    public ReturnValue uploadFileTest(MultipartFile file) {

        //上传文件路径
        String targetFilePath = "E:\\test\\uploadTest";
        File dir = new File(targetFilePath);

        //创建路径
        if(!dir.isDirectory()){
            dir.mkdir();

        }

        String fileName = file.getOriginalFilename();
        File targetFile = new File(targetFilePath + File.separator + fileName);


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(file.getInputStream(), fileOutputStream);
            logger.info("------>>>>>>uploaded a file successfully!<<<<<<------");
        } catch (IOException e) {
            return new ReturnValue<>(-1, null);
        } finally {
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return new ReturnValue<>(ReturnCodeAndMsgEnum.Success, null);
    }
}
