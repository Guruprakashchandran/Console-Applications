package com.bankingapplication.loginorregisterpage;

import com.bookingapplication.bankdetailsrepository.BankDetailsRepository;

public class LoginOrRegisterPageModel implements LoginOrRegisterPageControllerToModelCall {

//	private String userId;
//	private boolean isRegistered = false;
	private int setaPin;
	private LoginOrRegisterPageModelToControllerCall loginOrRegisterPageModelToControllerCall;

	public LoginOrRegisterPageModel(LoginOrRegisterPageController loginOrRegisterPageController) {

		loginOrRegisterPageModelToControllerCall = loginOrRegisterPageController;
	}

	@Override
	public void checkLoginCredentials(String userId, String password) {

		int detailExist = BankDetailsRepository.getInstance().checkLogin(userId, password);
		if (detailExist == 0) {

//			this.userId = userId;
//			loginSuccessfully
			loginOrRegisterPageModelToControllerCall.loginSuccessfully(userId);
		} else if (detailExist == 1) {

			loginOrRegisterPageModelToControllerCall.wrongPassword();
		} else {

			loginOrRegisterPageModelToControllerCall.userIdNotFound();
		}
	}

	public String checkUserId(String userId) {

		if (userId.length() == 4) {

			if (BankDetailsRepository.getInstance().userIdIsExist(userId)) {

				return "UserId ";
			} else {

				for (int i = 0; i < 4; ++i) {

					if (userId.charAt(i) < 48 || userId.charAt(i) > 57) {

						return "UserId ";
					}
				}

			}
		} else {

			return "UserId ";
		}
		return "";
	}

	public String checkAccountNumber(String accountNumber) {

		if (accountNumber.length() > 7 && accountNumber.length() < 14) {

			for (int i = 0; i < accountNumber.length(); ++i) {

				if (accountNumber.charAt(i) < 48 || accountNumber.charAt(i) > 57) {

					return "AccountNumber ";
				}
			}
		} else {

			return "AccountNumber ";
		}
		return "";
	}

	public String checkDateOfBirth(String dateOfBirth) {
		String[] num = dateOfBirth.split("/");
		int[] val = new int[num.length];
		for (int i = 0; i < num.length; ++i) {

			if (i != 2 && num[i].charAt(0) >= 48 && num[i].charAt(0) <= 57 && num[i].charAt(1) >= 48
					&& num[i].charAt(1) <= 57) {

				val[i] = Integer.parseInt(num[i]);
				if (val[0] > 31 || val[0] < 0) {

					return "DataOfBirth ";
				} else if (val[1] < 0 || val[1] > 12) {

					return "DataOfBirth ";
				}
			} else if (num[i].length()==4 && num[i].charAt(0) >= 48 && num[i].charAt(0) <= 57 && num[i].charAt(1) >= 48
					&& num[i].charAt(1) <= 57 && num[i].charAt(2) >= 48 && num[i].charAt(2) <= 57
					&& num[i].charAt(3) >= 48 && num[i].charAt(3) <= 57) {

				val[i] = Integer.parseInt(num[i]);
				if (val[i] < 1950 || val[i] > 2020) {

					return "DataOfBirth ";
				}
			} else {

				return "DataOfBirth ";
			}
		}
		return "";
	}

	public String checkMobileNumber(String mobileNo) {

		if (mobileNo.length() == 10) {

			for (int i = 0; i < 10; i++) {

				if (mobileNo.charAt(i) < 48 || mobileNo.charAt(i) > 57) {

					return "MobileNumber ";
				}
			}
		} else {

			return "MobileNumber ";
		}
		return "";
	}

	@Override
	public void checkRegistrationDetails(String userId, String name,String accountNumber,  String password,
			String mobileNo, String dateOfBirth, String conPassword) {

		String s = "";
		s += checkUserId(userId);
		s += checkAccountNumber(accountNumber);
//		s += checkCreditCardNumber(creditCardNumber);
		s += checkDateOfBirth(dateOfBirth);
		s += checkMobileNumber(mobileNo);

		if (!password.equals(conPassword) || password.length() < 8) {

			s += "Password ";
		}
		if (s.length() == 0) {

//			int otp = (int) (Math.random() * (9999 - 1000) + 1000);
//			loginOrRegisterPageModelToControllerCall.checkingOTP(otp);
			loginOrRegisterPageModelToControllerCall.setOtpPin();
//			if (isRegistered) {
				if (setaPin != 0) {

					BankDetailsRepository.getInstance().addDetails(userId, name,accountNumber, password, setaPin,
							mobileNo, dateOfBirth);
					loginOrRegisterPageModelToControllerCall.registerSuccessfully();
				}
				else {

				loginOrRegisterPageModelToControllerCall.registrationFailed();
			}

		} else {

			loginOrRegisterPageModelToControllerCall.wrongDetail(s);
		}
	}

	@Override
	public void verifyOTP(int newOtp, int otp) {

		if (otp != newOtp) {

			loginOrRegisterPageModelToControllerCall.wrongOTP();
		} else {}
	}

	@Override
	public void setPin(int pin) {

		if (pin > 999 && pin < 10000) {

			setaPin = pin;
		} else {

			setaPin = 0;
		}
	}

	@Override
	public void checkAdminLogin(String userName, String password) {

		if(userName.equals("guru")) {
			
			if(password.equals("Owner")) {
				
				loginOrRegisterPageModelToControllerCall.adminLoginSuccess();
			}
			else {
				
				loginOrRegisterPageModelToControllerCall.adminPasswordWrong();
			}
		}
		else {
			
			loginOrRegisterPageModelToControllerCall.adminUsernameWrong();
		}
	}
}
