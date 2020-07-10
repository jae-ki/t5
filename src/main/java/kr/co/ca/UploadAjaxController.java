package kr.co.ca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.util.utils;

@Controller
public class UploadAjaxController {
	private String uploadPath = "C:" + File.separator + "upload";

	
	@ResponseBody
	@RequestMapping(value = "/deletefile", method = RequestMethod.POST)
	public String deletefile(String filename) {
		
		filename.replace('/', File.separatorChar);
		int idx = filename.lastIndexOf(".");
		String format = filename.substring(idx+1);
		
		MediaType mType = utils.getMediaType(format);
		if(mType != null) {
				String pre = filename.substring(0,12);
				String suf = filename.substring(14);
				
				String oriname = pre+suf;
				
				File orifile = new File(uploadPath+oriname);
				orifile.delete();
		}
		File f = new File(uploadPath+filename);
		f.delete();
		
		
		
		return "success";
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/displayfile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayfile(String filename) {
		ResponseEntity<byte[]> entity = null;
		
		InputStream in = null;
		
		try {
			
			int idx = filename.lastIndexOf(".");
			String format = filename.substring(idx+1);
			
			MediaType mType = utils.getMediaType(format);
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath+filename);

			if(mType != null) {
				headers.setContentType(mType);
			}else {
				
				idx = filename.indexOf("_");	
				String ortginalname = filename.substring(idx+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""+new String(ortginalname.getBytes("UTF-8"),"ISO-8859-1"));

				
						
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
					headers ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			try {
				if (in != null) in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return entity;
	}

	
	@ResponseBody
	@RequestMapping(value = "/uploadajax", method = RequestMethod.POST ,produces = "text/plain;charset=UTF-8")
	public String uploadajax(MultipartHttpServletRequest request) throws Exception {
		
		
		MultipartFile file = request.getFile("file");
	
		String originalName = file.getOriginalFilename();
		String savefilename = utils.saveFile(originalName, file, uploadPath);
		
		
		return savefilename;
	}

	@RequestMapping(value = "/uploadajax", method = RequestMethod.GET)
	public void uploadajax() {
		
		
		
		
	}
		
}
