package kr.co.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class utils {


	public static String makeDir(String uploadPath) {
		
			String[] paths = utils.makeDirName();
			
			File f = new File(uploadPath+paths[2]);
			if(f.exists()) {
				return paths[2];
				
			}
			
			for(String path : paths) {
				File dirPath = new File(uploadPath+path);
						if(!dirPath.exists()){
							dirPath.mkdir();
						}
			}
			return paths[2];
		}
		

	

	public static String[] makeDirName() {
		
		int[] arr = utils.getDateInfo();
		
		String yearPath = File.separator+arr[0];
		String monthPath = yearPath+File.separator+String.format("%02d", arr[1]);
		String datePath = monthPath+File.separator+String.format("%02d", arr[2]);
	
		String[] paths = {yearPath, monthPath, datePath};
		
		return paths;
	}
	
	
	
		public static int[] getDateInfo() {
			Calendar cal =Calendar.getInstance();
			
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int date = cal.get(Calendar.DATE);
			int[] arr= {year, month, date};
			return arr;
		}
	
		public static String saveFile(String originalName, MultipartFile file, String uploadPath) throws Exception {
			String newName = utils.makeNewName(originalName);
			String datePath = utils.makeDir(uploadPath);
			File target= new File(uploadPath+datePath, newName);
			
			FileCopyUtils.copy(file.getBytes(), target);
			
			boolean isimgFile= isImg(originalName);
			
			if(isimgFile) {
				return makeThunail(uploadPath, datePath, newName);
		
			}else {
				String beforChangeName = datePath+File.separator+newName;
				return beforChangeName.replace(File.separatorChar, '/');
				
			}
			
			
		}
		
		public static String makeThunail(String uploadPath, String datePath, String newName) throws Exception {
			
			File f1 = new File(uploadPath+datePath, newName);
			BufferedImage sourceImg = ImageIO.read(f1);
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT, 100);
			
			String makeThunailName = uploadPath+datePath+File.separator+"s_" +newName;
			File newFile = new File(makeThunailName);
			
			int idx = newName.lastIndexOf(".");
			String format = newName.substring(idx+1).toUpperCase();
			ImageIO.write(destImg, format, newFile);
			
						
			return makeThunailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
		}
		
		
		
		
		public static boolean isImg(String filename) {

			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx + 1);

			MediaType mType = getMediaType(format);
			
			if (mType != null) {
				return true;
			} else {
				return false;
			}
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




		public static MediaType getMediaType(String format) {
			
			Map<String, MediaType> map = new HashMap<String, MediaType>();
			map.put("JPG", MediaType.IMAGE_JPEG);
			map.put("JPEG", MediaType.IMAGE_JPEG);
			map.put("PNG", MediaType.IMAGE_PNG);
			map.put("GIF", MediaType.IMAGE_GIF);

			MediaType mType = map.get(format.toUpperCase());
			
			
			return mType;
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
