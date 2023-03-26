package com.chatapplication.personalchat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.chatapplication.editprofile.ProfileView;
import com.chatapplication.groupchat.GroupChatView;
import com.chatapplication.personalchatlist.Message;
import com.chatapplication.userdetails.User;
import com.chatapplication.util.ChatUtil;

public class PersonalChatView implements PersonalChatControllerToViewCall {

	private Scanner scan = new Scanner(System.in);
	private PersonalChatViewToControllerCall personalChatViewToControllerCall;

	public PersonalChatView() {

		personalChatViewToControllerCall = new PersonalChatController(this);
	}

	public void mainOptionsPage(User user) {

		boolean isTrue = true;
		while (isTrue) {
			try {
				
				System.out.println("\n*****************Welcome Chat App****************");
				System.out.println("\n1) Private Chat");
				System.out.println("2) Group Chat");
				System.out.println("3) Profile Page");
				System.out.println("4) Exit");
				System.out.print("\nEnter Input : ");
				int input = scan.nextInt();
				switch (input) {

				case 1:
					personalChatViewToControllerCall.getPersonalChats(user);
					break;
				case 2:
					new GroupChatView().getDetails(user);
					break;
				case 3:
					new ProfileView().profilePage(user);
					break;
				case 4:
					System.out.println("\nExitted!!!");
					personalChatViewToControllerCall.closeConnection();
					isTrue = false;
					break;
				default:
					System.out.println("\nWrong Input!!!");

				}
			} catch (Exception e) {

				scan.nextLine();
				System.out.println("\nWrong input!!!");
			}
		}
	}

	private void addFriend(User user, String newNumber) {

		if (!user.getMobileNo().equals(newNumber)) {

			personalChatViewToControllerCall.addFriend(user, newNumber);
		} else {
			System.out.println("\nSorry!!!Its Your Number!!!");
		}
	}

	@Override
	public void friendNotInapp(User user) {

		System.out.println("\nYour Friend Not In This App!!!");
	}

	@Override
	public void alreadyFriend(User user) {

		System.out.println("\nAlready In Your Friend List!!!");
	}

	@Override
	public void addedFailed(User user) {

		System.out.println("\nOops!!!");
		System.out.println("Sorry!!Not Added!!!");
	}

	@Override
	public void addedSuccessfully(User user) {

		System.out.println("\nAdded Successfully!!!");
	}

	@Override
	public void showContacts(List<List<Map<String, List<Message>>>> data, User user, List<String> friendsName,
			int[] totalRegisterCount) {

		int k = 0;
		for (k = 0; k < data.size(); ++k) {

			System.out.println(k + 1 + ") " + friendsName.get(k));
		}
		if (friendsName.size() == (totalRegisterCount[0] - 1)) {

			System.out.println(k + 1 + ") Back");
			System.out.print("\nEnter Input : ");
			int input = scan.nextInt();
			scan.nextLine();
			if (k + 1 == input) {

			} else if (input > 0 && k + 1 > input) {

				showPersonalChats(data, user, k, input, friendsName);
			} else {

				System.out.println("Wrong Input!!!");
			}
		} else {

			System.out.println(k + 1 + ") Add Friend");
			System.out.println(k + 2 + ") Back");
			System.out.print("\nEnter Input : ");
			int input = scan.nextInt();
			scan.nextLine();
			System.out.println();
			if (k + 1 == input) {

				System.out.println("If you Want Exit Please Press \"2\"");
				String newNumber = getMobileNo();
				addFriend(user, newNumber);
			} else if (k + 2 == input) {

			} else if (input > 0 && k + 1 > input) {

				showPersonalChats(data, user, k, input, friendsName);
			} else {

				System.out.println("Wrong Input!!!");
			}

		}
	}

	private void showPersonalChats(List<List<Map<String, List<Message>>>> data, User user, int k, int input,
			List<String> friendsName) {

		List<Message> list1 = new LinkedList<>();
		List<Message> list2 = new LinkedList<>();
		for (int i = 0; i < data.get(input - 1).size(); ++i) {

			int l = 0;
			String loginerId = "";
			for (Entry<String, List<Message>> entry : data.get(input - 1).get(i).entrySet()) {

				if (l == 0) {

					list1 = entry.getValue();
					loginerId = entry.getKey();
				}
				if (l == 1) {

					list2 = entry.getValue();
					String personId = entry.getKey();
					System.out
							.println("---------- " + friendsName.get(input - 1)/* entry.getKey() */ + " -----------\n");
					showMessages(data, list1, list2, user, k, input, personId, loginerId, friendsName);
				}
				l++;
			}

		}
	}

	private void showMessages(List<List<Map<String, List<Message>>>> data, List<Message> list1, List<Message> list2,
			User user, int k, int input, String personId, String loginerId, List<String> friendsName) {
		boolean isNewMessage = false;
		int person1msg = 0, person2msg = 0;
		while (person1msg != list1.size() || person2msg != list2.size()) {

			if (person1msg != list1.size() && person2msg != list2.size()) {

				boolean compare = compareToDates(list1.get(person1msg).getDate().toString(),
						list2.get(person2msg).getDate().toString());
				if (compare == true) {

					System.out.println("\t\t\t" + list1.get(person1msg).getMessage());
					System.out.println("\t\t\t\t" + list1.get(person1msg).getDate().substring(0, 19));
					System.out.println();
					person1msg++;
				} else {

					if (isNewMessage == false && list2.get(person2msg).getStatus().equalsIgnoreCase("Not Viewed")) {

						isNewMessage = true;
						System.out.println("\n---------------New Message-----------------\n");
					}
					System.out.println(list2.get(person2msg).getMessage());
					System.out.println("\t" + list2.get(person2msg).getDate().substring(0, 19));
					System.out.println();
					person2msg++;
				}
			} else if (list1.size() != person1msg) {

				System.out.println("\t\t\t" + list1.get(person1msg).getMessage());
				System.out.println("\t\t\t\t" + list1.get(person1msg).getDate().substring(0, 19));
				System.out.println();
				person1msg++;
			} else if (list2.size() != person2msg) {

				if (isNewMessage == false && list2.get(person2msg).getStatus().equalsIgnoreCase("Not Viewed")) {

					isNewMessage = true;
					System.out.println("\n---------------New Message-----------------\n");
				}
				System.out.println(list2.get(person2msg).getMessage());
				System.out.println("\t" + list2.get(person2msg).getDate().substring(0, 19));
				System.out.println();
				person2msg++;
			}
		}
		personalChatViewToControllerCall.setMessagesViewed("Viewed", loginerId);
		getMessage(data, user, personId, k, input, loginerId, list1, list2, friendsName);
	}

	private void getMessage(List<List<Map<String, List<Message>>>> data, User user, String personId, int k, int input,
			String loginerId, List<Message> list1, List<Message> list2, List<String> friendsName) {

		try {

			System.out.println("\n----------------Message-----------------\n");

			System.out.println("If You want Exit Press \"`\"");
			System.out.print("\nSend Message : ");
			String msg = scan.nextLine();
			if (!msg.equals("`")) {

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String s = dtf.format(now);
				Message message = new Message(msg, s, "Viewed");
				data.get(input - 1).get(0).get(loginerId).add(message);

				if (msg.length() > 0) {

					String status = "Not Viewed";
					personalChatViewToControllerCall.addMessage(user, personId, msg, loginerId, status);
					showPersonalChats(data, user, k, input, friendsName);
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private boolean compareToDates(String date1, String date2) {

		String[] s1 = date1.split(" ");
		String[] s2 = s1[0].split("-");
		String[] s3 = s1[1].split(":");
		String[] s4 = date2.split(" ");
		String[] s5 = s4[0].split("-");
		String[] s6 = s4[1].split(":");
		for (int i = 2; i >= 0; --i) {

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

	private String getMobileNo() {

		String mobileNo = "";
		try {

			System.out.print("\nEnter Mobile Number : ");
			mobileNo = scan.next();
			if (mobileNo.equals("2")) {

				return "2";
			} else {

				if (!ChatUtil.checkMobileNumber(mobileNo)) {

					System.out.println("Invalid Mobile Number!!!");
					mobileNo = getMobileNo();
				}
			}

		} catch (Exception e) {

			System.out.println("\nWrong Input!!!");
			mobileNo = getMobileNo();
		}
		return mobileNo;
	}

	@Override
	public void msgAddedFailed(String mobileNo) {

		System.out.println("\nMessage Not Added!!!");
	}
}
