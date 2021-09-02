package com.kitri.mini.user;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kitri.mini.board.service.ImgBoardService;
import com.kitri.mini.board.vo.ImgBoardVO;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private ImgBoardService imgBoardService;
	
	@RequestMapping("")
	public String main(Model model, Map<String, String> map) {
		
		map.put("start", "1");
		map.put("end", "9");
		
		List<ImgBoardVO> ibList = imgBoardService.getImgBoardList(map);
		model.addAttribute("ibList",ibList);
		
		return "main";
	}
	
	@RequestMapping("/imgboard-regist-page")
	public String imgBoardRegistPage() {
		return "imgboard-regist";
	}
	
	@RequestMapping("/imgboard-regist")
	public String fileupload(MultipartFile uploadfile, 
							String content, 
							HttpServletRequest req, 
							HttpSession session) {
		
		String id = (String)session.getAttribute("id");
		String uploadPath = req.getRealPath("uploadfolder");//경로를 webapp부터 인식함
		String saveName = uploadfile.getOriginalFilename();
		
		String uploadUniquePath = uploadPath + File.separator + id;
		boolean uploadConfirm = false;
		boolean registFlag = false;
		String path = "";
		
		try {
			File idFile = new File(uploadUniquePath);
			if (!idFile.exists()) {
				idFile.mkdir();
			}
			File saveFile = new File(idFile, saveName);
//						/uploadfolder/id + "/" + saveName

			uploadfile.transferTo(saveFile);
			uploadConfirm = true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			uploadConfirm = false;
		} catch (IOException e) {
			e.printStackTrace();
			uploadConfirm = false;
		}
		
		if(uploadConfirm) {
			
			ImgBoardVO ibvo = new ImgBoardVO();
			ibvo.setUserid(id);
			ibvo.setContent(content);
			
			String insertImgPath = File.separator + "upload" + File.separator // /upload/
								+ id + File.separator // admin/
								+ saveName;	// a.jpg
								// /upload/admin/a.jpg
			
			ibvo.setImg(insertImgPath);
			
			registFlag = imgBoardService.registImgBoard(ibvo);
			if(registFlag) {
				path = "redirect:/main";
			} else {
				path = "redirect:/imgboard-regist-page";
			}
		}
		
		return path;
	}
	
	@RequestMapping("/morelist")
	@ResponseBody
	public List<ImgBoardVO> moreList(String start, String end, Map<String,String> map){
		map.put("start", start);
		map.put("end", end);
		
		List<ImgBoardVO> ibList = imgBoardService.getImgBoardList(map);
		return ibList;
	}
	
	
	
	
}
