package kr.co.ca;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import kr.co.util.utils;


@Controller
public class UploadController {


	@RequestMapping(value = "/uploadform", method = RequestMethod.POST)
	public void uploadform(MultipartHttpServletRequest request, Model model) throws Exception {
		MultipartFile file = request.getFile("file");
		
		String originalName = file.getOriginalFilename();
		
		String fileName = utils.saveFile(originalName, file);
		model.addAttribute("fileName", fileName);
	}
	
	
	@RequestMapping(value = "/uploadform", method = RequestMethod.GET)
	public void uploadform() {
		
	}
	
	
}
