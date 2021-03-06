package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import kr.or.ddit.common.model.PageBoard;
import kr.or.ddit.user.model.User;

public class UserServiceTest {
   private IUserService userService;
   @Before
   public void setup() {
      userService = new UserService();
   }

   /**
    * 
   * Method : getUserListTest
   * 작성자 : PC-07
   * 변경이력 :
   * Method 설명 : getUserList 테스트
    */
   @Test
   public void getUserList() {
      /***Given***/
      
      /***When***/
      List<User> userList = userService.getUserList();
      
      /***Then***/
      assertEquals(105, userList.size());
   }
   
   /**
    * 
   * Method : getUserTest
   * 작성자 : PC-07
   * 변경이력 :
   * Method 설명 : 사용자 정보 조회 테스트
    */
   @Test
   public void getUser() {
      /***Given***/
      String userId = "brown";
      
      /***When***/
      User userVo = userService.getUser(userId);
      
      /***Then***/
      assertEquals("브라운", userVo.getUserNm());
      assertEquals("brown1234", userVo.getPass());
   }
   
   /**
	 * 
	* Method : getUserPagingListTest
	* 작성자 : PC-04
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Test
	public void getUserPagingListTest(){
		/***Given***/
		PageBoard page = new PageBoard();
		page.setPage(3);
		page.setPagesize(10);
		
		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 105;
		int pagesize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	

}