package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@WebServlet("/gbc")
public class GuestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//컨트롤러 테스트
   		System.out.println("Controller"); //ok
   		
   		//action 값 읽어오기
   		String action = request.getParameter("action");
   		System.out.println(action);
   		
   		if("addlist".equals(action)) {
   			
   			//action = addlist 출력
   			
   			//리스트 출력
   			GuestDao guestDao = new GuestDao();
   			List<GuestVo> guestList = guestDao.getGuestList();
   			
   			System.out.println(guestList.toString());
   			
   			//데이터 전달
   			request.setAttribute("gList", guestList);
   			
   			//addlist에 포워드
   			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/addlist.jsp");
   			rd.forward(request, response);
   			
   		}else if("add".equals(action)) {
   			
   			//action=add 방명록 등록
   			System.out.println("방명록 등록");
   			
   			//파라미터 값
   			String name = request.getParameter("name");
   			String password = request.getParameter("password");
   			String content = request.getParameter("content");
   			
   			//guestVo 묶기
   			GuestVo guestVo = new GuestVo(name, password, content);
   			
   			//new dao > 등록
   			GuestDao guestDao = new GuestDao();
   			guestDao.addGuest(guestVo);
   			
   			response.sendRedirect("/guestbook2/gbc?action=add");
   			
   		}else if("dform".equals(action)) {
   			
   			//delete 폼
   			System.out.println("삭제 폼");
   			
   			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/dform.jsp");
   			rd.forward(request, response);
   		}else if("delete".equals(action)) {
   			System.out.println("삭제 기능");
   			
   			//파라미터 값
   			int no = Integer.parseInt(request.getParameter("no"));
   			String password = request.getParameter("password");
   			
   			//Vo로 보내고
   			GuestVo guestVo = new GuestVo(no, password);
   			
   			//new dao > 삭제
   			GuestDao guestDao = new GuestDao();
   			guestDao.guestDelete(guestVo);
   			
   			//이 다음을 모르겠네
   			//password 확인을 하고 삭제하는 것 같은데
   		}
	}   		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		//post로 옮기는 순간 안 보여서
	}

}
