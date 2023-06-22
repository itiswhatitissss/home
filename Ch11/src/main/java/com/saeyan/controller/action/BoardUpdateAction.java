package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardUpdateAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardVO vo = new BoardVO();

        vo.setNum(Integer.parseInt(request.getParameter("num")));
        vo.setName(request.getParameter("name"));
        vo.setPass(request.getParameter("pass"));
        vo.setEmail(request.getParameter("email"));
        vo.setTitle(request.getParameter("title"));
        vo.setContent(request.getParameter("content"));

        BoardDAO bDao = BoardDAO.getInstance();
        bDao.updateBoard(vo);

        new BoardListAction().execute(request,response);
    }
}
