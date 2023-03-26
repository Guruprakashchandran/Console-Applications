package com.chatapplication.groupchat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.chatapplication.groupchatlist.Messages;
import com.chatapplication.userdetails.User;
import com.chatapplication.util.ChatUtil;

public class GroupChatView implements GroupChatControllerToViewCall {

	private GroupChatViewToControllerCall groupChatViewToControllerCall;
	private Scanner scan = new Scanner(System.in);

	public GroupChatView() {

		groupChatViewToControllerCall = new GroupChatController(this);
	}

	public void getDetails(User user) {

		groupChatViewToControllerCall.getGroupChatDetails(user);
	}

	@Override
	public void showDetails(List<List<Map<String, List<Messages>>>> data, User user, List<String> groupNames,
			int[] friendsCount, List<List<Integer>> groupMembersCount) {

		int k = 0, i = 0;
		System.out.println();
		for (k = 0; k < data.size(); ++k) {

			for (i = 0; i < data.get(k).size(); ++i) {

				if (k == 0) {

					System.out.println(i + 1 + ") " + groupNames.get(i));// +" - "+(i + 1) + ") " + entry.getKey());
				}
			}
		}
		System.out.println(k + 1 + ") Create Group");
		System.out.println(k + 2 + ") back");
		System.out.print("\nEnter Input : ");
		try {

			int input = scan.nextInt();
			scan.nextLine();
			System.out.println();
			if (k + 1 == input) {

				createGroup(user);
			} else if (k + 2 == input) {

			} else {

				showGroupChats(data, user, k, input, i, groupNames, friendsCount, groupMembersCount);
			}
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
		}
	}

	private void createGroup(User user) {

		System.out.print("Enter Group Name : ");
		String grpName = scan.nextLine();
		System.out.println("\nGroup Created!!!");
		Map<String,String> friendList = groupChatViewToControllerCall.getFriendsList(user);
		int i = 0;
		for (Map.Entry<String, String> entry : friendList.entrySet()) {

			System.out.println(i + 1 + ") " + entry.getValue());
			i++;
		}
		List<String> mobileNoList = new LinkedList<>();
		List<Integer> mobileNo = new ArrayList<>();
		System.out.println("\nIf You want Exit Press \" 0 \"");
		while (true) {

			System.out.print("Enter Friend Serial No : ");
			int no = scan.nextInt();
			if (!(no == 0)) {

//				if (ChatUtil.checkMobileNumber(no)) {
				if(mobileNo.contains(no)) {
					
					System.out.println("Already You Select the Number!!!");
				}
				else if(i >= (no-1)) {
					
					mobileNo.add(no);
			
					if(i-- == 0) {
						
						System.out.println("You Select All Friends!!");
						break;
					}
				}
				else {
					
					System.out.println("Wrong Serial Number!!!");
				}
//				} else {
//
//					System.out.println("Sorry!!Wrong Input!!!");
//				}
			} else {

				break;
			}
		}
		int j = 0;
		i = 0;
		Collections.sort(mobileNo);
		for(Map.Entry<String, String> entry : friendList.entrySet()) {
			
			if(mobileNo.size()>j) {
				
				if(mobileNo.get(j)-1 == i) {
					
					mobileNoList.add(entry.getKey());
				}
			}
			i++;
		}
		
		groupChatViewToControllerCall.createGroup(mobileNoList, grpName, user);
	}

	private void showGroupChats(List<List<Map<String, List<Messages>>>> data, User user, int k, int input, int i,
			List<String> groupNames, int[] friendsCount, List<List<Integer>> groupMembersCount) {

		List<Messages> list1 = new LinkedList<>();
		List<Messages> list2 = new LinkedList<>();

		int set = 0;
		String id = "";
		for (Entry<String, List<Messages>> entry : data.get(input - 1).get(input - 1).entrySet()) {

			if (set == 0) {

				list1 = entry.getValue();
				id = entry.getKey();
			}
			if (set == 1) {

				list2 = entry.getValue();
				String groupId = entry.getKey();
				System.out.println("-----------------" + groupNames.get(input - 1) + "-----------------\n");// "----------
																											// " +
																											// entry.getKey()
																											// + "
																											// -----------\n");
				showMessages(data, list1, list2, user, k, input, i, groupId, id, groupNames, friendsCount,
						groupMembersCount);
			}
			set++;
		}
	}

	private void showMessages(List<List<Map<String, List<Messages>>>> data, List<Messages> list1, List<Messages> list2,
			User user, int k, int input, int i, String groupId, String id, List<String> groupNames, int[] friendsCount,
			List<List<Integer>> groupMembersCount) {

		boolean isNewMessage = false;
		int person1msg = 0, person2msg = 0;
		while (person1msg != list1.size() || person2msg != list2.size()) {

			if (person1msg != list1.size() && person2msg != list2.size()) {

				boolean compare = compareToDates(list1.get(person1msg).getDate().toString(),
						list2.get(person2msg).getDate().toString());
				if (compare == true) {

					System.out.println("\t\t\t" + list1.get(person1msg).getMessage());
					System.out.print("\t\t\tYou");
					System.out.println("\t" + list1.get(person1msg).getDate().substring(0, 19));
					System.out.println();
					person1msg++;
				} else {

					if (isNewMessage == false && list2.get(person2msg).getStatus().equalsIgnoreCase("Not Viewed")) {

						isNewMessage = true;
						System.out.println("\n---------------New Message-----------------\n");
					}
					System.out.println(list2.get(person2msg).getMessage());
					System.out.print(list2.get(person2msg).getName());
					System.out.println("\t" + list2.get(person2msg).getDate().substring(0, 19));
					System.out.println();
					person2msg++;
				}
			} else if (list1.size() != person1msg) {

				System.out.println("\t\t\t" + list1.get(person1msg).getMessage());
				System.out.print("\t\t\tYou");
				System.out.println("\t" + list1.get(person1msg).getDate().substring(0, 19));
				System.out.println();
				person1msg++;
			} else if (list2.size() != person2msg) {

				if (isNewMessage == false && list2.get(person2msg).getStatus().equalsIgnoreCase("Not Viewed")) {

					isNewMessage = true;
					System.out.println("\n---------------New Message-----------------\n");
				}
				System.out.println(list2.get(person2msg).getMessage());
				System.out.print(list2.get(person2msg).getName());
				System.out.println("\t" + list2.get(person2msg).getDate().substring(0, 19));
				System.out.println();
				person2msg++;
			}
		}
		groupChatViewToControllerCall.setMessagesViewed("Viewed", groupId);
		getChoice(data, list1, list2, user, k, input, i, groupId, id, groupNames, friendsCount, groupMembersCount);
	}

	private void getChoice(List<List<Map<String, List<Messages>>>> data, List<Messages> list1, List<Messages> list2,
			User user, int k, int input, int i, String groupId, String id, List<String> groupNames, int[] friendsCount,
			List<List<Integer>> groupMembersCount) {

		try {

			if (0 < groupMembersCount.get(input - 1).get(0)) {

				System.out.println("\n1) Send Message");
				System.out.println("2) Add Friend");
				System.out.println("3) Exit Group");
				System.out.println("4) Back");
				System.out.print("\nEnter Input : ");
				int category = scan.nextInt();
				scan.nextLine();
				switch (category) {

				case 1:
					getMessage(data, list1, list2, user, k, input, i, groupId, id, groupNames, friendsCount,
							groupMembersCount);
					break;
				case 2:
					addFriend(groupId, id, user);
					break;
				case 3:
					groupChatViewToControllerCall.exitGroup(groupId, user);
					break;
				case 4:
					break;
				default:
					System.out.println("\nWrong Input!!!");
				}
			} else {

				System.out.println("\n1) Send Message");
				System.out.println("2) Exit Group");
				System.out.println("3) Back");
				System.out.print("\nEnter Input : ");
				int category = scan.nextInt();
				scan.nextLine();
				switch (category) {

				case 1:
					getMessage(data, list1, list2, user, k, input, i, groupId, id, groupNames, friendsCount,
							groupMembersCount);
					break;
				case 2:
					groupChatViewToControllerCall.exitGroup(groupId, user);
					break;
				case 3:
					break;
				default:
					System.out.println("\nWrong Input!!!");
				}
			}
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
		}
	}

	private void addFriend(String groupId, String id, User user) {

		groupChatViewToControllerCall.getFriends(user, id, groupId);
	}

	private boolean compareToDates(String date1, String date2) {

		String[] s1 = date1.split(" ");
		String[] s2 = s1[0].split("-");
		String[] s3 = s1[1].split(":");
		String[] s4 = date2.split(" ");
		String[] s5 = s4[0].split("-");
		String[] s6 = s4[1].split(":");
		for (int i = 0; i < 3; ++i) {

			if (Integer.parseInt(s2[i]) < Integer.parseInt(s5[i])) {

				return true;
			} else if (Integer.parseInt(s2[i]) > Integer.parseInt(s5[i])) {

				return false;
			}
		}

		for (int i = 0; i < 3; ++i) {

			if (Integer.parseInt(s3[i]) < Integer.parseInt(s6[i])) {

				return true;
			} else if (Integer.parseInt(s3[i]) > Integer.parseInt(s6[i])) {

				return false;
			}
		}
		return true;

	}

	private void getMessage(List<List<Map<String, List<Messages>>>> data, List<Messages> list1, List<Messages> list2,
			User user, int k, int input, int i, String groupId, String id, List<String> groupNames, int[] friendsCount,
			List<List<Integer>> groupMembersCount) {

		System.out.println("\n----------------Message-----------------\n");

		System.out.println("If You want Exit Press \"`\"");
		System.out.print("\nSend Message : ");
		String msg = scan.nextLine();
		if (msg.equals("`")) {

		} else {
			String status = "Not Viewed";
			System.out.println(msg);
			groupChatViewToControllerCall.addMessage(user, id, msg, groupId, status);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String s = dtf.format(now);
			Messages message = new Messages(msg, "Not Viewed", s, null, null, null);
			data.get(input - 1).get(input - 1).get(id).add(message);
			showGroupChats(data, user, k, input, i, groupNames, friendsCount, groupMembersCount);
		}
	}

	@Override
	public void noFreinds() {

		System.out.println("\nNo Friends !!!");
	}

	@Override
	public void friendsList(Map<String, String> friendsList) {

		int i = 0;
		for (Map.Entry<String, String> entry : friendsList.entrySet()) {

			System.out.println(i + 1 + ") " + entry.getValue());
			i++;
		}
	}

	@Override
	public void notAddedFriends(int notFriendsCount, User user) {

		System.out.println("\nGroup Created!!!");
		System.out.println(notFriendsCount + " not Added In Group !!!");
	}

	@Override
	public void friendsAdded(User user) {

		System.out.println("\nAll Friend Added In group!!!");
	}

	@Override
	public void friendsRejectedList(List<String> rejectedNumbers, User user) {

		System.out.println("\n" + rejectedNumbers.size() + " friends Not added in group!!");
		System.out.println("Numbers : ");
		for (int i = 0; i < rejectedNumbers.size(); ++i) {

			System.out.println(rejectedNumbers.get(i));
		}
	}

	@Override
	public void successExit(User user) {

		System.out.println("\nExitted Successfully!!!");
	}

	@Override
	public void availableFriends(Map<String, String> friends, User user, String groupId, String id) {

		System.out.println("\n---------Friends-----------\n");
		int i = 0;
		for (Map.Entry<String, String> entry : friends.entrySet()) {

			System.out.println(i + 1 + ") " + entry.getValue());
			i++;
		}
		addFriendsInGroup(friends, user, groupId, id, i);
	}

	public void addFriendsInGroup(Map<String, String> friends, User user, String groupId, String id, int i) {

		List<String> noList = new LinkedList<>();
		List<Integer> list = new LinkedList<>();

		try {
			System.out.println("If you want Exit Press \"`\"");
			while (true) {

				System.out.print("\nChoose Friends Serial Number : ");
				String input = scan.nextLine();

				if (input.equals("`")) {

					break;
				} else {

					if (Integer.parseInt(input) <= i && Integer.parseInt(input) > 0) {

						boolean isExist = false;
						for (int j = 0; j < list.size(); ++j) {

							if (list.get(j) == Integer.parseInt(input)) {

								isExist = true;
							}
						}
						if (isExist == false) {

							int j = 0;
							for (Map.Entry<String, String> entry : friends.entrySet()) {

								if (j + 1 == Integer.parseInt(input)) {

									noList.add(entry.getKey());
								}
								j++;
							}
							list.add(Integer.parseInt(input));
						} else {

							System.out.println("\nAlready You give this number!!!");
						}
					} else {

						System.out.println("\nWrong Input!!!");
					}
				}
				if (noList.size() == friends.size()) {

					System.out.println("\nYou Select All Friends in your Friend List!!!");
					break;
				}
			}
			if (noList.size() > 0) {

				groupChatViewToControllerCall.addAdditionalFriendsInGroup(user, groupId, noList);
			}
		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
			groupChatViewToControllerCall.addAdditionalFriendsInGroup(user, groupId, noList);
		}
	}

}