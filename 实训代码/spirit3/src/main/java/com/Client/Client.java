package com.Client;


public class Client {

	private String company_name;
	private String user_id;
    private String user_name;
    private String user_password;
    private String user_sex;
    private String user_birthday;
    private String user_number;
    private String user_jointime;
    private String user_salary;
    private String user_absent;
    private String user_position;
    private String user_evaluate;
    
    public Client() {
    	
    }
    
    public Client(String user_id,String user_password) {
    	
    	super();
        this.user_id = user_id;
        this.user_password = user_password;
   
    	
    }
    
    public Client(String company_name,String user_id,String user_password) {
    	
    	super();
    	this.company_name = company_name;
        this.user_id = user_id;
        this.user_password = user_password;
   
    	
    }

    public String getUser_position() {
        return user_position;
    }

    public void setUser_position(String user_position) {
        this.user_position = user_position;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_jointime() {
        return user_jointime;
    }

    public void setUser_jointime(String user_jointime) {
        this.user_jointime = user_jointime;
    }

    public String getUser_salary() {
        return user_salary;
    }

    public void setUser_salary(String user_salary) {
        this.user_salary = user_salary;
    }

    public String getUser_absent() {
        return user_absent;
    }

    public void setUser_absent(String user_absent) {
        this.user_absent = user_absent;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getUser_evaluate() {
        return user_evaluate;
    }

    public void setUser_evaluate(String user_evaluate) {
        this.user_evaluate = user_evaluate;
    }
    
}
