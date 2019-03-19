package com.xianke.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传service
 */
public interface UploadService {

    String uploadImage(MultipartFile file);
}
