package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ModifyBoardController
 */
@WebServlet("/modifyBoard")
public class ModifyBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(ModifyBoardController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> boardList = boardService.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("/board/insertBoard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int inum = Integer.parseInt(request.getParameter("inum"));
		String boardname = request.getParameter("boardname");
		String usagestatus = request.getParameter("usagestatus");
		
		Board board = new Board();
		board.setInum(inum);
		board.setBoardname(boardname);
		board.setUsagestatus(usagestatus);
		
		int updateCnt;
		try {
			updateCnt = boardService.updateBoard(board);
				response.sendRedirect(request.getContextPath() + "/newBoard");
		}catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher(request.getContextPath() + "/newBoard").forward(request, response);
		}
	}
}
