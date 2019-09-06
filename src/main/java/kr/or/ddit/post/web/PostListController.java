package kr.or.ddit.post.web;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.post.service.IPostService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.model.Post;

@WebServlet("/postPagingList")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(PostListController.class);
	private IPostService postService;
	
	@Override
	public void init() throws ServletException {
		postService = PostService.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inum = Integer.parseInt(request.getParameter("inum"));
		String pagev = request.getParameter("page");
		String pageSizev = request.getParameter("pagesize");
		
		int page = pagev == null ? 1 : Integer.parseInt(pagev);
		int pagesize = pageSizev == null ? 10 : Integer.parseInt(pageSizev);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("inum", inum);
		map.put("page", page);
		map.put("pagesize", pagesize);
		
		Map<String, Object> resultMap = postService.getPostPagingList(map, inum);
		
		List<Post> postList = (List<Post>) resultMap.get("postList");
		int paginationSize = (int) resultMap.get("paginationSize");
		
		request.setAttribute("inum", inum);
		request.setAttribute("page", page);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);
		
		request.getRequestDispatcher("/post/postList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
