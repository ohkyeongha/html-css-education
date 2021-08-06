package kr.re.kitri.memo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.re.kitri.memo.dao.MemoDAO;
import kr.re.kitri.memo.vo.MemoVO;
import kr.re.kitri.memo.vo.MemoJson;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
		} else {
			MemoDAO mdao = new MemoDAO();
			List<MemoVO> mlist = mdao.selectAllMemo(id);
			
			List<MemoJson> mjlist = new ArrayList<MemoJson>();
			for(MemoVO mvo : mlist) {
				MemoJson mj = new MemoJson();
				mj.setId(mvo.getMno());
				mj.setTitle(mvo.getTitle());
				mj.setStart(String.valueOf(mvo.getMdate()));
				mj.setDescription(mvo.getMemo());
				
				mjlist.add(mj);
			}
			
			Gson gson = new Gson();
			String json = gson.toJson(mjlist);
//			System.out.println(json);
			
			request.setAttribute("mjson", json);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
