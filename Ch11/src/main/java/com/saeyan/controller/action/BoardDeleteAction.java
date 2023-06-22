package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardDeleteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));

        BoardDAO dDao = BoardDAO.getInstance();
        dDao.deleteBoard(num);

        new BoardListAction().execute(request,response);
    }
}
