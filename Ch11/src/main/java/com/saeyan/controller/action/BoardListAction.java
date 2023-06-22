package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BoardListAction implements Action{
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String url="/board/boardList.jsp";

        BoardDAO bDao = BoardDAO.getInstance();
        List<BoardVO> list =bDao.selectAllBoard();

        request.setAttribute("boardList",list);

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);

    }
}
