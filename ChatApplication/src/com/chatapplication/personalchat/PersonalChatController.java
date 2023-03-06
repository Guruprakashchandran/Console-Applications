package com.chatapplication.personalchat;

import java.util.List;
import java.util.Map;

import com.chatapplication.personalchatlist.Message;
import com.chatapplication.userdetails.User;

public class PersonalChatController implements PersonalChatViewToControllerCall,PersonalChatModelToControllerCall{

	private PersonalChatControllerToViewCall personalChatControllerToViewCall;
	private PersonalChatControllerToModelCall personalChatControllerToModelCall;
	public PersonalChatController(PersonalChatView personalChatView) {
		
		personalChatControllerToViewCall = personalChatView;
		personalChatControllerToModelCall = new PersonalChatModel(this);
	}
	@Override
	public void addFriend(User user, String newNumber) {
		
		personalChatControllerToModelCall.addFriend(user,newNumber);
	}
	@Override
	public void friendNotInapp(User user) {
		
		personalChatControllerToViewCall.friendNotInapp(user);
	}
	@Override
	public void alreadyFriend(User user) {
		
		personalChatControllerToViewCall.alreadyFriend(user);
	}
	@Override
	public void addedFailed(User user) {
		
		personalChatControllerToViewCall.addedFailed(user);
	}
	@Override
	public void addedSuccessfully(User user) {
		
		personalChatControllerToViewCall.addedSuccessfully(user);
	}
	@Override
	public void getPersonalChats(User user) {

		personalChatControllerToModelCall.getPersonalChats(user);
	}
	
	@Override
	public void showContacts(List<List<Map<String, List<Message>>>> data,User user,List<String> friendsName,int[] totalRegisterCount) {
		
		personalChatControllerToViewCall.showContacts(data,user,friendsName,totalRegisterCount);
	}
	@Override
	public void addMessage(User user, String personId, String msg,String loginerId,String status) {
		
		personalChatControllerToModelCall.addMessage(user,personId,msg,loginerId,status);
	}
	@Override
	public void msgAddedFailed(String mobileNo) {
		
		personalChatControllerToViewCall.msgAddedFailed(mobileNo);
	}
	@Override
	public void setMessagesViewed(String status, String loginerId) {
		
		personalChatControllerToModelCall.setMessageViewed(status,loginerId);
	}
	@Override
	public void closeConnection() {
		
		personalChatControllerToModelCall.closeConnection();
	}
}
