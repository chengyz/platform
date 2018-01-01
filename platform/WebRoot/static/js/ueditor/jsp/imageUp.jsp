<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
 <%@page import="com.util.ReadProperties"%>
<%@ page import="com.util.Uploader" %>

    <%
    
    try{
    request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String folder_url = request.getParameter("folder_url");
    Uploader up = new Uploader(request);
    //up.setSavePath("/../upload");
    
    up.setSavePath(folder_url);
    
    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
    up.setAllowFiles(fileType);
    up.setMaxSize(10000); //单位KB
    up.upload();
    
    String url = up.getUrl();
    /* int index = up.getUrl().indexOf(":");
    if(index != -1) {
    	url = url.substring(up.getUrl().indexOf(":") + 1);
    } */
    
    url = ReadProperties.getValue("imgVisitPath") + url;//文件访问路径
// 	System.out.println(url);
    
    //System.out.print(up.getOriginalName()+"-----------------"+url);
    response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+url+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
    } catch(Exception e) {
    	e.printStackTrace();
    }
    %>
