package com.ness.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.ness.exception.FileStorageException;

@Service
public class FileUploadService {

	public String storeFile(MultipartFile file) {
		String FileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(FileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence "+ FileName);
				//Path largetPath=this.fileS
			}
		}catch (Exception e) {
			
		}
		return null;
	}

}
