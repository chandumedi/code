package com.ness.dto;

public class FileUploadResponse {
	private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
	public FileUploadResponse(String fileName, String fileDownloadUri, String fileType, long size) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}
    
}
