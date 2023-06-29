package com.tushar.payload;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ImagePath {

	 public static String ImagePath(String fileName) {
	    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	    	return fileDownloadUri;
	    }
}
