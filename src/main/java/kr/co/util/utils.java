package kr.co.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class utils {

	
	
		public static String saveFile(String originalName, MultipartFile file) throws Exception {
			String newName = utils.makeNewName(originalName);
			
			File target= new File("C:"+File.separator+"upload", newName);
			FileCopyUtils.copy(file.getBytes(), target);
			
			return newName;
		}
	
		public static String makeNewName(String originalName) {
			UUID uid = UUID.randomUUID();
			String newName= uid.toString()+"_"+originalName;
			
			
			return newName;
		}
	
		public static String toKor(String msg) {
			try {
				return new String(msg.getBytes("8859_1"),"UTP-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		
		/*
		public String toKor(String name) {
			try {
				return new String(name.getBytes("8859_1"),"UTP-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		*/
}
