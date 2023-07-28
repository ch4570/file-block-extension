package com.flow.hirework.controller;

import com.flow.hirework.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService uploadService;

    @PostMapping("/api/files")
    public ResponseEntity<HttpStatus> uploadFile(MultipartFile file, HttpServletRequest request) {
        System.out.println("file = " + file);
        uploadService.uploadFile(file, request);
        return ResponseEntity.ok().build();
    }
}
