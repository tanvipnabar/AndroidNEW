/*
 * Copyright 2009-2011 AppFirst, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appfirst.types;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author Tanvi Nabar
 * 
 *         Mapping between User Profile object in Java and JSON object in AppFirst
 *         Public API.
 *         <p>
 
 */
public class UserProfile extends BaseObject {
	private int uId;
	private int userId;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String company;
	private int country_code;
	private boolean is_account_owner;
	private String account_type;

	/**
	 * @param jsonObject
	 */
	public UserProfile(JSONObject jsonObject) {
		super(jsonObject);
		// TODO Auto-generated constructor stub
		try {
			uId = BaseObject.getIntField("id", jsonObject);
			userId = BaseObject.getIntField("user_id", jsonObject);
			first_name = BaseObject.getStringField("first_name", jsonObject);
			last_name = BaseObject.getStringField("last_name", jsonObject);
			email = BaseObject.getStringField("email", jsonObject);
			phone_number = BaseObject.getStringField("phone_number", jsonObject);
			country_code = BaseObject.getIntField("country_code", jsonObject);
			is_account_owner = BaseObject.getBooleanField("is_account_owner", jsonObject);
			company = BaseObject.getStringField("company", jsonObject);
			account_type = BaseObject.getStringField("account_type", jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getUId() {
		return uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getCountry_code() {
		return country_code;
	}
	
	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}
	
	public boolean getIs_account_owner() {
		return is_account_owner;
	}
	
	public void setIs_account_owner(boolean is_account_owner) {
		this.is_account_owner = is_account_owner;
	}
}
