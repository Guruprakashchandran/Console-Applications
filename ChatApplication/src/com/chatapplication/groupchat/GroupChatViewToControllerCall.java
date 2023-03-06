package com.chatapplication.groupchat;

import java.util.List;

import com.chatapplication.userdetails.User;

public interface GroupChatViewToControllerCall {

	void getGroupChatDetails(User user);

	void setMessagesViewed(String string, String loginerId);

	void addMessage(User user, String id, String msg, String groupId, String status);

	void getFriendsList(User user);

	void createGroup(List<String> mobileNoList, String grpName, User user);

	void addAdditionalFriendsInGroup(User user, String groupId, List<String> noList);

	void exitGroup(String groupId, User user);

	void getFriends(User user, String id, String groupId);

}
