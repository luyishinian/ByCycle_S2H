package com.wjf.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class ChangePIC extends ActionSupport{
	private int id;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private File uploadFile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String execute() throws Exception{
		CycleDao cycledao = new CycleDao();
		Cycle cycle = new Cycle();
		cycle = cycledao.ByID(id);
		String realPath = ServletActionContext.getServletContext().getRealPath("/image");
		if(uploadFile !=null ){  
            File destFile = new File(new File(realPath), uploadFileFileName);//根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
            if(!destFile.getParentFile().exists())//判断路径"/images"是否存在  
                destFile.getParentFile().mkdirs();//如果不存在，则创建此路径  
            //将文件保存到硬盘上，因为action运行结束后，临时文件就会自动被删除  
            FileUtils.copyFile(uploadFile, destFile);  
        }
        String c_pic = "image/"+uploadFileFileName;
        cycle.setC_img(c_pic);
        cycledao.update(cycle);
	    //System.out.print(id);
	    //System.out.print(c_pic);
		return SUCCESS;
	}

}
