package com.poscoict.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public String restore(MultipartFile multipartfile) {
		String url = null;
		
		if(multipartfile.isEmpty()) {
			return url;
		}
		
		String originfilename =  multipartfile.getOriginalFilename();
		long filesize = multipartfile.getSize();
		
		System.out.println("!@#!@#!@#!@#!@#!@#!@#!#!#!@#!#!@#!@#!@#!@#" + originfilename);
		System.out.println("!@#!@#!@#!@#!@#!@#!@#!#!#!@#!#!@#!@#!@#!@#" + filesize);
	
		return url;
	}

}
