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
            File destFile = new File(new File(realPath), uploadFileFileName);//���� parent ����·������ child ·�����ַ�������һ���� File ʵ����  
            if(!destFile.getParentFile().exists())//�ж�·��"/images"�Ƿ����  
                destFile.getParentFile().mkdirs();//��������ڣ��򴴽���·��  
            //���ļ����浽Ӳ���ϣ���Ϊaction���н�������ʱ�ļ��ͻ��Զ���ɾ��  
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
