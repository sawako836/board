package kr.or.ddit.util;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileuploadUtil {

	/**
	 * 
	* Method : getFilenameTest
	* 작성자 : PC-04
	* 변경이력 :
	* Method 설명 : Content-disposition 해더 문자열로 부터 파일이름 추출
	 */
	private static final Logger logger = LoggerFactory.getLogger(FileuploadUtil.class);
	public static String getFilename(String contentDisposition) {
		// 메서드 인자 : "form-data; name=\"file\"; filename=\"sally.png\"";
		String[] attrs = contentDisposition.split("; ");
		// attrs[0] = form-data
		// attrs[1] = filename="sally.png"
			// keyValue[0] filename
			// keyValue[1] "brown.png"
		// attrs[2] =  name="file"
		
		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) { // 문자열이 filename으로 시작하는지 검사
				String[] keyValue = attr.split("=");
				logger.debug("keyValue[1].indexOf(\") : {} ", keyValue[1].indexOf("\""));
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		
		return filename;
	}
	/**
	 * 
	* Method : getFilenameTest
	* 작성자 : PC-04
	* 변경이력 :
	* Method 설명 : Content-disposition 해더 문자열로 부터 파일확장자 추출
	 */
	public static String getFileExtension(String contentDisposition) {
		
		// brown.png, cony.xx.png, moon
		String filename = getFilename(contentDisposition);
		
		if(filename.lastIndexOf(".") > 0) // 존재하지 않으면 -1이 return이 된다.
			return filename.substring(filename.lastIndexOf("."), filename.length());
		else
			return "";
	}
	
	/**
	 * 
	* Method : getPath
	* 작성자 : PC-04
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드할 경로를 조회한다.
	 */
	public static String getPath() {
		String basicPath = "e:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date()); // 201908
		String yyyy = yyyyMM.substring(0, 4); // 2019
		String mm = yyyyMM.substring(4, 6);
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + mm);
		if(!yyyyDirectory.exists()) // 존재하지 않을 경우 만들어준다.
			yyyyDirectory.mkdirs();
		
			// e:\\upload\\2019\\08\\ -> 경로를 리턴해준다.
		return basicPath + "\\" + yyyy + "\\" + mm + "\\";
	}
	
}
