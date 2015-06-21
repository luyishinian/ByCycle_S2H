package com.wjf.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.User;
import com.wjf.dao.UserDao;

public class ChangeMessage extends ActionSupport{
	private int userID;
	private String username;
	private String usersex;
	private String userbirth;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private File uploadFile;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getUserbirth() {
		return userbirth;
	}

	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String execute() throws Exception {
		if(username == null || username.equals("") || userbirth == null || userbirth.equals("") || usersex == null || usersex.equals("")){
			return ERROR;
	        }
		else{
		ActionContext ac = ActionContext.getContext();
		UserDao userDao = new UserDao();  
        User user = new User();
        user = userDao.ByID(userID);
		String realPath = ServletActionContext.getServletContext().getRealPath("/image");
		if(uploadFile !=null ){  
            File destFile = new File(new File(realPath), uploadFileFileName);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
            if(!destFile.getParentFile().exists())//判断路径"/images"是否存在  
                destFile.getParentFile().mkdirs();//如果不存在，则创建此路径  
            //将文件保存到硬盘上，因为action运行结束后，临时文件就会自动被删除  
            FileUtils.copyFile(uploadFile, destFile);  
        }
        String user_pic = "image/"+uploadFileFileName;
        user.setU_name(username);
       
        user.setU_sex(usersex);
        user.setU_img(user_pic);
        userDao.update(user);
    	ac.put("login", user);
		ac.getSession().put("login", user);
        return SUCCESS; 
	}
	}

}
