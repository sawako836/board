package kr.or.ddit.board.web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.Board;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class InsertBoardController
 */
@WebServlet("/newBoard")
public class NewBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(NewBoardController.class);
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
		
		String boardname = request.getParameter("boardname");
		String usagestatus = request.getParameter("usagestatus");
		
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		logger.debug("userid : {}", userid);
		

		Board board = new Board();
		board.setBoardname(boardname);
		board.setUsagestatus(usagestatus);

		board.setUserid("cony");
		
		int insertCnt = 0;
		try {
			insertCnt = boardService.insertBoard(board);
			if(insertCnt == 1) {
				//request.getRequestDispatcher("/user").forward(request, response);
				response.sendRedirect(request.getContextPath() + "/newBoard");
			}
		}catch(Exception e) {
			e.printStackTrace();
			doGet(request, response);
		}

	}
}
