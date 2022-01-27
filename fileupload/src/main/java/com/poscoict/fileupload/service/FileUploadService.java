package com.poscoict.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/upload-images";
	
	public String restore(MultipartFile multipartfile) {
		
		String url = null;
		
		try {
			
			
			
			if(multipartfile.isEmpty()) {
				return url;
			}
			
			String originfilename =  multipartfile.getOriginalFilename();
			long filesize = multipartfile.getSize();
			
			System.out.println("!@#!@#!@#!@#!@#!@#!@#!#!#!@#!#!@#!@#!@#!@#" + originfilename);
			System.out.println("!@#!@#!@#!@#!@#!@#!@#!#!#!@#!#!@#!@#!@#!@#" + filesize);
		
			
			byte[] data =  multipartfile.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "");
			
		} catch(IOException ex) {
			//fileuploadexception으로 만들어서 메ㅐ핑
			throw new RuntimeException("file upload errrrr.. :" + ex);
		}
		return url;
	}

}
