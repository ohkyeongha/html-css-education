package kr.re.kitri.memo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.re.kitri.memo.dao.MemberDAO;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//id, pw request
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인 DB 조회
		MemberDAO mdao = new MemberDAO();
		String result = mdao.login(id, pw);
		String msg = "";
		//세션 연결
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			//페이지 이동(인덱스)
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
//			rd.forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index");
			
		} else {
			//페이지 이동 (로그인)
			msg = "ID 또는 PW가 존재하지 않습니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/member/login.jsp");
			rd.forward(request, response);
		}
	}

}
