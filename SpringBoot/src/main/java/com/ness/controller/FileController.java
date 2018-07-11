package com.ness.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ness.dto.FileUploadResponse;
import com.ness.service.FileUploadService;

@RestController
public class FileController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/uploadFile")
	public FileUploadResponse uploadFileForReport(@RequestParam("file") MultipartFile file) {
		String fileName=fileUploadService.storeFile(file);
		String fileDownloadUrl=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadfile/").path(fileName).toUriString();
		return new FileUploadResponse(fileName,fileDownloadUrl,file.getContentType(),file.getSize());
	}
}
