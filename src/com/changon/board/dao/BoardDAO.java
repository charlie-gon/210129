package com.changon.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.changon.board.common.DAO;
import com.changon.board.vo.BoardVO;
import com.changon.board.vo.ReplyVO;

public class BoardDAO extends DAO {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 전체선택
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "SELECT * FROM BOARD";
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	// 상세보기
	public BoardVO select(BoardVO vo) {
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
				hitCount(vo.getbId()); // 글 조회수
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 수정할 때 호출하는
public BoardVO editSelect(BoardVO vo) {
		
		String sql = "SELECT * FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bId"));
				vo.setbName(rs.getString("bName"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbDate(rs.getDate("bDate"));
				vo.setbHit(rs.getInt("bHit"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 조회수 메소드
	public void hitCount(int hit) {
		// TODO Auto-generated method stub
		String sql = "UPDATE BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hit);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	// 새 글 입력
	public int insert(BoardVO vo){
		int n = 0;
		
		String sql = "INSERT INTO BOARD(BID,BNAME,BTITLE,BCONTENT,BDATE) VALUES(BIDSEQ.NEXTVAL,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			psmt.setDate(4, vo.getbDate());
			
			n = psmt.executeUpdate();
			System.out.println(n + "건 Insert 완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}	

	// 글 수정
	public int update(BoardVO vo){
		int n = 0;
		String sql = "UPDATE BOARD SET BCONTENT = ? WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			
			n = psmt.executeUpdate();
			System.out.println(n + "건 Update 완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	// 글 삭제
	public int delete(BoardVO vo){
		int n = 0;
		String sql = "DELETE FROM BOARD WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			
			n = psmt.executeUpdate();
			System.out.println(n + "건 Delete 완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			// 실행의 반대 순서
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 댓글 가져오기
	public ArrayList<ReplyVO> replySelect(ReplyVO rvo){
		ArrayList<ReplyVO> replyList = new ArrayList<ReplyVO>();
		
		String sql = "SELECT * FROM REPLY WHERE BID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rvo.getBid());
			rs = psmt.executeQuery();
			while(rs.next()) {
				rvo = new ReplyVO();
				rvo.setBid(rs.getInt("bid"));
				rvo.setRnum(rs.getInt("rnum"));
				rvo.setSubject(rs.getString("subject"));
				rvo.setRdate(rs.getDate("rdate"));
				replyList.add(rvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return replyList;
	}
	
	
	

}
