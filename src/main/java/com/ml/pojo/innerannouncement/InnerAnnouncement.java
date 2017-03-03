package com.ml.pojo.innerannouncement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InnerAnnouncement implements Serializable {
	
	private static final long serialVersionUID = -5214709367292601829L;

	private Integer id;
	private String title;
	private String summary;
	private String content;
	private Date createTime;
	private Date updateTime;
	
	private String createdByCode;
	private String createdByName;
	private String updatedByCode;
	private String updatedByName;
	
	private Date startTime;
	private Date endTime;
	
	private String hidden;
	private Boolean read;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreatedByCode() {
		return createdByCode;
	}

	public void setCreatedByCode(String createdByCode) {
		this.createdByCode = createdByCode;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public String getUpdatedByCode() {
		return updatedByCode;
	}

	public void setUpdatedByCode(String updatedByCode) {
		this.updatedByCode = updatedByCode;
	}

	public String getUpdatedByName() {
		return updatedByName;
	}

	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}
	
	    public static void main(String[] args) {

/*        System.out.println("现在开始初始化容器");
        
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-general.xml");
        System.out.println("容器初始化成功");    
        //得到Preson，并使用
        TestBean person = factory.getBean("testBean",TestBean.class);
        System.out.println(person);
        
        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();*/
	     TestStatic myBeanPostProcessor = new TestStatic();
		 List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");
		System.out.println(a);
		a.add(a.remove(a.indexOf("4")));
		System.out.println(a);
	}
	
	    
}
