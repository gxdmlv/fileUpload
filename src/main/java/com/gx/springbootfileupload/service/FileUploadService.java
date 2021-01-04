package com.gx.springbootfileupload.service;

import com.gx.springbootfileupload.model.ReturnValue;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootfileupload.service
 * @date 2021/1/4 16:33
 */
public interface FileUploadService {

    public ReturnValue uploadFileTest(MultipartFile file);

}
