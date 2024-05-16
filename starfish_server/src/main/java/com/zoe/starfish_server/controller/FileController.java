package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/files")
@Slf4j
public class FileController {
    @Autowired
    FileService fileService;


    @PostMapping("/upload")
    public CommonResp uploadFiles(@RequestParam("files") MultipartFile[] files) {
        List<String> fileDownloadUris = new ArrayList<>();
        for (MultipartFile file : files) {
            fileService.storeFile(file);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/download/")
                    .path(file.getOriginalFilename())
                    .toUriString();
            fileDownloadUris.add(fileDownloadUri);
        }
        return CommonResp.success(fileDownloadUris);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            Path filePath = fileService.loadFile(filename);
            Resource resource = new UrlResource(filePath.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + filename, ex);
        }
    }


//    @Value("${file.upload.url}")
//    private String uploadFilePath;
//
//    @RequestMapping("/upload")
//    public CommonResp uploadFiles(@RequestParam("files") MultipartFile files[]) {
//        for (int i = 0; i < files.length; i++) {
//            String fileName = files[i].getOriginalFilename();  // 文件名
//            File dest = new File(uploadFilePath + '/' + fileName);
//            if (!dest.getParentFile().exists()) {
//                dest.getParentFile().mkdirs();
//            }
//            try {
//                files[i].transferTo(dest);
//            } catch (Exception e) {
//                log.error("uploadFiles", e);
//                return CommonResp.error(RespCodeEnum.UPLOADFILEERR);
//            }
//        }
//        return CommonResp.success(true);
//    }
}
