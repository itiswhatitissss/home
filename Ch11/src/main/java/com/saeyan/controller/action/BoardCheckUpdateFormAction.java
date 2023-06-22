package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardCheckUpdateFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/board/boardUpdate.jsp";
        int num = Integer.parseInt(request.getParameter("num"));

        BoardDAO bDao = BoardDAO.getInstance();
        bDao.updateReadCount(num);

        BoardVO vo =bDao.selectOneBoardByNum(num);
        request.setAttribute("board",vo);

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }
}
