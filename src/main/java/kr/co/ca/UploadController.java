package kr.co.ca;



import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import kr.co.util.utils;


@Controller
public class UploadController {


	private String uploadPath = "C:" + File.separator + "upload";


	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		MultipartFile file = request.getFile("file");
		
		String originalName = file.getOriginalFilename();
		
		String fileName = utils.saveFile(originalName, file, uploadPath);
		model.addAttribute("fileName", fileName);
	}
	
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public void uploadform() {
		
	}
	
	
}
