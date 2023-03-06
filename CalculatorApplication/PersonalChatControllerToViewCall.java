package com.chatapplication.personalchat;

import java.util.List;
import java.util.Map;

import com.chatapplication.personalchatlist.Message;

public interface PersonalChatControllerToViewCall {

	void friendNotInapp(String mobileNo);

	void alreadyFriend(String mobileNo);

	void addedFailed(String mobileNo);

	void addedSuccessfully(String mobileNo);

	void showContacts(List<List<Map<String, List<Message>>>> data);

}
