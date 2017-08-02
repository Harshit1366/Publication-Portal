package com.patents;

public class Patents {
	

private String pcn , name , dept , title , scope , country , application_no , application_date , award_date , patent_no , patent_file , plag_report , status, comment , username;

public String getPcn() {
	return pcn;
}

public void setPcn(String pcn) {
	this.pcn = pcn;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getScope() {
	return scope;
}

public void setScope(String scope) {
	this.scope = scope;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getApplication_no() {
	return application_no;
}

public void setApplication_no(String application_no) {
	this.application_no = application_no;
}

public String getApplication_date() {
	return application_date;
}

public void setApplication_date(String application_date) {
	this.application_date = application_date;
}

public String getAward_date() {
	return award_date;
}

public void setAward_date(String award_date) {
	this.award_date = award_date;
}

public String getPatent_no() {
	return patent_no;
}

public void setPatent_no(String patent_no) {
	this.patent_no = patent_no;
}

public String getPatent_file() {
	return patent_file;
}

public void setPatent_file(String patent_file) {
	this.patent_file = patent_file;
}

public String getPlag_report() {
	return plag_report;
}

public void setPlag_report(String plag_report) {
	this.plag_report = plag_report;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public int getApplication_year() {
	return application_year;
}

public void setApplication_year(int application_year) {
	this.application_year = application_year;
}

public int getAward_year() {
	return award_year;
}

public void setAward_year(int award_year) {
	this.award_year = award_year;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getRevision() {
	return revision;
}

public void setRevision(int revision) {
	this.revision = revision;
}

private int application_year , award_year , id , revision;

}
