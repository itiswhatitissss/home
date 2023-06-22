package com.saeyan.dto;

import util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    private static BoardDAO instance = new BoardDAO();
    private BoardDAO(){}
    public static  BoardDAO getInstance(){
        return instance;
    }
    //리스트
    public List<BoardVO> selectAllBoard(){
        List<BoardVO> list = new ArrayList<BoardVO>();

        String sql = "select * from Board order by num";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()){
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setPass(rs.getString("pass"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setReadcount(rs.getInt("readcount"));
                vo.setWritedate(rs.getTimestamp("writedate"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return list;
    }

    public int insertBoard(BoardVO vo) {
        int result = -1;
        String sql = "insert into board(num,pass,name,email,title,content) values(board_seq.nextval,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, vo.getPass());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getTitle());
            pstmt.setString(5, vo.getContent());
            result=pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DBManager.close(conn,pstmt);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public BoardVO selectOneBoardByNum(int num) {
        BoardVO vo = null;
        String sql = "select * from board where num=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            rs=pstmt.executeQuery();

            if (rs.next()){
                vo=new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setPass(rs.getString("pass"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setReadcount(rs.getInt("readcount"));
                vo.setWritedate(rs.getTimestamp("writedate"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return vo;
    }


    public void updateReadCount(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update board set readcount =readcount+1 where num=?";;

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, num);
            pstmt.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
    public int updateBoard(BoardVO vo) {
        int result = -1;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "update board set name=?, pass=?, email=?, title=?, content=? where num=?";

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPass());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getTitle());
            pstmt.setString(5, vo.getContent());
            pstmt.setInt(6,vo.getNum());
            pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
        return result;
    }

    public void deleteBoard(int num) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "delete from board where num=?";

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,num);
            pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt);
        }
    }
}
