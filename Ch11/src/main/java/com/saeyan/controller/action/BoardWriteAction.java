package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public  class BoardWriteAction implements Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardVO vo = new BoardVO();

        vo.setPass(request.getParameter("pass"));
        vo.setName(request.getParameter("name"));
        vo.setEmail(request.getParameter("email"));
        vo.setTitle(request.getParameter("title"));
        vo.setContent(request.getParameter("content"));

        BoardDAO bDao = BoardDAO.getInstance();
        int result = bDao.insertBoard(vo);

        //list로 가주라 new BoardListAction().execute(request,response);
        response.sendRedirect("BoardServlet?command=board_list");//list로 가주라2

    }
}
