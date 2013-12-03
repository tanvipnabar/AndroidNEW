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
package com.appfirst.activities.lists;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.appfirst.activities.details.AFLogDetail;
import com.appfirst.monitoring2.R;
import com.appfirst.monitoring2.MainApplication;
import com.appfirst.types.UserProfile;
import com.appfirst.utils.DoubleLineLayoutArrayAdapter;
import com.appfirst.utils.DynamicComparator;

public class AFUserProfile extends ListActivity {
    /** Called when the activity is first created. */
	static UserProfile currentUserProfile;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
    	String url = String.format("%s%s",
    							getString(R.string.frontend_address),
    							getString(R.string.api_user_profiles));
    	MainApplication.loadUserList(url);
    	List<UserProfile> items = MainApplication.getUserList();
    	String currentUserName = MainApplication.getCurrentUsername();
    	
    	for(int i=0; i<items.size(); i++) {
    		if(items.get(i).getEmail().equals(currentUserName)) {
    			currentUserProfile = items.get(i);
    			break;
    		}
    	}
    	
        super.onCreate(savedInstanceState);
 
        ListAdapter adapter = createAdapter();
        setListAdapter(adapter);
    }
 
    /**
     * Creates and returns a list adapter for the current list activity
     * @return
     */
    protected ListAdapter createAdapter()
    {
    	String[] testValues = new String[] {
    			"First Name - " + currentUserProfile.getFirst_name(),
    			"Last Name  - " + currentUserProfile.getLast_name(),
    			"ID - " + currentUserProfile.getId(),
    			"Company - " + currentUserProfile.getCompany(),
    			"Email Address - " + currentUserProfile.getEmail(),
    			"Account Type - " + currentUserProfile.getAccount_type(),
    			"Phone Number - " + determinePhoneNumber()
    	};
 
    	ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.user_profile_listview, testValues);
 
    	return adapter;
    }
    
    protected String determinePhoneNumber() {
    	if(currentUserProfile.getPhone_number().equals("null")) {
    		return "Not Listed";
    	}
    	return currentUserProfile.getPhone_number();
    }
}