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
            File destFile = new File(new File(realPath), uploadFileFileName);//���� parent ����·������ child ·�����ַ�������һ���� File ʵ����  
            if(!destFile.getParentFile().exists())//�ж�·��"/images"�Ƿ����  
                destFile.getParentFile().mkdirs();//��������ڣ��򴴽���·��  
            //���ļ����浽Ӳ���ϣ���Ϊaction���н�������ʱ�ļ��ͻ��Զ���ɾ��  
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
