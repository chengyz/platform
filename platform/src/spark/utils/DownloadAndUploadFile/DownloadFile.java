package spark.utils.DownloadAndUploadFile;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 下载方法
 * @author Administrator
 *
 */
public class DownloadFile extends HttpServlet {

private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		javax.servlet.ServletOutputStream out = response.getOutputStream();
		String filePatha = request.getParameter("filePath");
		if(filePatha.equals("execlPath")){
			String execlPath =  ReadProperties.getSJLMConfig("userTemplatePath");
			String savePath = ReadProperties.getSJLMConfig("savePath");
			String userMobileName= ReadProperties.getSJLMConfig("userTemplateName")+".xls";
			filePatha = savePath + execlPath + userMobileName;
		}else if(filePatha.equals("execlOut")){
			//你你脸色脸色脸色
		}
		String filePath=URLDecoder.decode(filePatha,"utf-8");
		System.out.println("DownloadFile1 filename:" + filePath);
		java.io.File file = new java.io.File(filePath);
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + "");
			return;
		}
		java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
		String filename = filePath.substring(filePath.lastIndexOf("/") + 1);
		if (filePath != null && filePath.length() > 0) {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(filename.getBytes("gb2312"),"iso8859-1") + "");
			if (fileInputStream != null) {
			int filelen = fileInputStream.available();
			byte a[] = new byte[filelen];
			fileInputStream.read(a);
			out.write(a);
			}
			fileInputStream.close();
			out.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 
}

