package validators;

import exceptions.MailException;

public class MailValidator {
    private String mail;

    public MailValidator(String mail) {
        this.mail = mail;
    }
    public boolean validate() {
        if(mail.contains(".com") || mail.contains(".net") || mail.contains(".org") || mail.contains(".bd")) {
        }else {
            throw new MailException("Invalid mail format. Need .com or .net or .org or .bd");
        }
        if(mail.contains("@")) {
            //has '@'
        }
        else{
            throw new MailException("Invalid mail format. Need @");
        }
        return true;
    }
}
