package com.kitri.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@RequestMapping("/fileuploadpage")
	public String file() {
		return "file-upload-page";
	}
	@RequestMapping("/multifileuploadpage")
	public String multifile() {
		return "multifile-upload-page";
	}
	@RequestMapping("/filedownloadpage")
	public String fileDownloadPage() {
		return "download";
	}
	

	@RequestMapping("/fileupload")
	public void fileupload(MultipartFile uploadfile, HttpServletRequest req) {
//		String uploadPath = "C:\\java_study\\spring_workspace\\fileupload-download-prj\\src\\main\\webapp\\uploadfolder";
		String uploadPath = req.getRealPath("uploadfolder");//경로를 webapp부터 인식함
		String saveName = uploadfile.getOriginalFilename();
		System.out.println("파일명 : " + saveName);
		
		File saveFile = new File(uploadPath,saveName);
		//						 uploadPath+"/""+saveName
		try {
			uploadfile.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@RequestMapping("/multifileupload")
	public void multifileupload(MultipartHttpServletRequest multipart, HttpServletRequest req) {
		List<MultipartFile> fileList = multipart.getFiles("uploadfile");
		String uploadPath = req.getRealPath("uploadfolder");
		for(MultipartFile file : fileList) {
			String originalFileName = file.getOriginalFilename();
			File saveFile = new File(uploadPath, System.currentTimeMillis()+"_"+originalFileName);
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("/filedownload")
	public void filedownload(String filename, HttpServletRequest req, HttpServletResponse res) {
		String uploadFolder = req.getRealPath("uploadfolder");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//response 응답 설정
			res.setContentType("application/octet-stream"); 
			res.setHeader("Content-Disposition", "attachment; "
					+ "filename=" + URLEncoder.encode(filename, "utf-8"));
			
			//stream을 이용한 서버 -> 클라이언트 file 받아옴
			bis = new BufferedInputStream(new FileInputStream(uploadFolder + File.separator+filename));
			bos = new BufferedOutputStream(res.getOutputStream());
			
			byte[] b = new byte[4096];
			int num = 0;
			while ((num = bis.read(b, 0 , b.length)) != -1) {
				bos.write(b,0,num);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
