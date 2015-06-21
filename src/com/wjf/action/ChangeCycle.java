package com.wjf.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;
import com.wjf.bean.Cycle;
import com.wjf.dao.CycleDao;

public class ChangeCycle extends ActionSupport{
	private int id;
	private String title;
	private String message;
	private String address;
	private int count;
	private float price;
	private String uploadFileContentType;
	private String uploadFileFileName;
	private File uploadFile;
	private Map<String,Object> cycleMap;
	public Map<String, Object> getCycleMap() {
		return cycleMap;
	}
	public void setCycleMap(Map<String, Object> cycleMap) {
		this.cycleMap = cycleMap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
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
        cycle.setC_name(title);
        cycle.setC_message(message);
        //cycle.setC_img(c_pic);
        cycle.setC_address(address);
        cycle.setC_count(count);
        cycle.setC_price(price);
        cycledao.update(cycle);
        cycleMap = new HashMap<String,Object>();
		
		cycleMap.put("cycle", cycle);  
	        // ����һ ���Ƿ�����ɹ��ı�ʶ  
		cycleMap.put("success", true);  
	        // ���ؽ��  
        
        return SUCCESS;
	}
}
