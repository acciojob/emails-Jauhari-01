package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(!oldPassword.equals(this.password)){
            return;
        }

        boolean[] flags = new boolean[5];
        //flag 0 for checking digit
        //flag 1 for checking uppercase
        //flag 2 for checking is character
        //flag 3 for checking is lowerCase

        for(char c : newPassword.toCharArray()){
            if(Character.isDigit(c)){
                flags[0] = true;
            }
            if(Character.isLetter(c)){
                flags[2] = true;
            }
            if(Character.isUpperCase(c)){
                flags[1] = true;
            }
            if(Character.isLowerCase(c)){
                flags[3] = true;
            }
            if (!Character.isDigit(c)
                && !Character.isLetter(c)
                && !Character.isWhitespace(c) ){
                    flags[4] = true;
                }

            for(boolean f : flags){
                if(f==false){
                    return;
                }
            }

            this.password = newPassword;
        }
    }
}
