package com.ness.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="file")
public class FileStorageProperties {
	private  String fileUploadDir;

	public String getFileUploadDir() {
		return fileUploadDir;
	}

	public void setFileUploadDir(String fileUploadDir) {
		this.fileUploadDir = fileUploadDir;
	}
	
}
