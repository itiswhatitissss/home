package com.saeyan.controller.action;

import com.saeyan.dto.BoardDAO;
import com.saeyan.dto.BoardVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BoardCheckPassAction implements Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        String pass = request.getParameter("pass");
        String url = null;

        BoardDAO bDao = BoardDAO.getInstance();
        BoardVO vo =bDao.selectOneBoardByNum(num);

        if(vo.getPass().equals(pass)){
            url = "/board/checkSuccess.jsp";
        }else{
            url = "/board/boardCheckPass.jsp";
            request.setAttribute("message","비밀번호가 틀립니다");
        }
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }
}
