package GOFO;

import java.util.Random;
import java.util.Scanner;
public class User {
    private
    String firstname;
    String lastname;
    String street;
    String area;
    String gov;
    String mail;
    String date;
    String userID;
    String phone;
    String password;

    public void setGov(String gov) {
        this.gov = gov;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword() {
        String p1,p2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your password :");
        p1=sc.nextLine();
        System.out.println("Enter your password again :");
        p2=sc.nextLine();
        while (!p1.equals(p2))
        {
            System.out.println("invalid ,doesn't match");
            System.out.println("Enter your password :");
            p1=sc.nextLine();
            System.out.println("Enter your password again :");
            p2=sc.nextLine();
        }
        this.password=p1;
    }
    public void setPassword(String s1)
    {
        this.password=s1;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    void edituserdata ()
    {
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        System.out.println("choose one of the following options:");
        System.out.println("1-Edit Name");
        System.out.println("2-Edit address");
        System.out.println("3-Edit mail");
        System.out.println("4-Edit date");
        System.out.println("5-Edit phone");
        System.out.println("6-Edit password");
        System.out.println("7-Exit");
        int choice=inputInt.nextInt();
        while (choice < 1 && choice > 7)
        {
            System.out.println("invalid input try again:");
            System.out.println("choose one of the following options:");
            System.out.println("1-Edit Name");
            System.out.println("2-Edit address");
            System.out.println("3-Edit mail");
            System.out.println("4-Edit date");
            System.out.println("5-Edit phone");
            System.out.println("6-Edit password");
            choice=input.nextInt();
        }
        if (choice==1)
        {
            System.out.println(firstname+"   "+lastname);
            System.out.println("enter your new first : ");
            String name=input.nextLine();
            firstname=name;
            System.out.println("enter your new last : ");
            name=input.nextLine();
            lastname=name;
        }
        else if (choice==2)
        {
            System.out.println("your address was   "+street+" "+area+" "+gov);
            System.out.println("enter your new address ");
            System.out.println("enter your new street ");
            String add=input.nextLine();
            setStreet(add);
            System.out.println("enter your new area ");
            add=input.nextLine();
            setArea(add);
            System.out.println("enter your new gov ");
            add=input.nextLine();
            setGov(add);
        }
        else if (choice==3)
        {
            System.out.println("your mail was   "+mail);
            System.out.println("enter your new mali ");
            String mal=input.nextLine();
            mail=mal;
        }
        else if (choice==4)
        {
            System.out.println("your date was   "+date);
            System.out.println("enter your new date ");
            String dat=input.nextLine();
            date=dat;
        }
        else if (choice==5)
        {
            System.out.println("your phone was   "+phone);
            System.out.println("enter your new phone ");
            String phon=input.nextLine();
            phone=phon;
        }
        else if (choice==6) {
            System.out.println("your password was   " + password);
            System.out.println("enter your new password ");
            String ps1 = input.nextLine();
            System.out.println("enter your new password again");
            String ps2 = input.nextLine();
            while (ps1 != ps2) {
                System.out.println("doesn't match try again");
                System.out.println("enter your new password ");
                ps1 = input.nextLine();
                System.out.println("enter your new password again ");
                ps2 = input.nextLine();
            }
            password = ps1;
        }
        else
            return;

    }
    public void resetPassword(){
        Scanner scanner = new Scanner(System.in);
        String pass_1,pass_2;
        System.out.println("Enter New Password ");
        pass_1=scanner.nextLine();
        System.out.println("Enter New Password again ");
        pass_2=scanner.nextLine();
        while (!pass_1.equals(pass_2)) {
            System.out.println("doesn't match try again");
            System.out.println("enter your new password ");
            pass_1 = scanner.nextLine();
            System.out.println("enter your new password again ");
            pass_2 = scanner.nextLine();
        }
        this.password=pass_1;


    }

    public void setUserID() {
        String g1 = "";
        Random rand = new Random();
        int index=rand.nextInt(firstname.length());
        g1+=firstname.charAt(index);
        index=rand.nextInt(lastname.length());
        g1+=lastname.charAt(index);
        index=rand.nextInt(password.length());
        g1+=password.charAt(index);
        index=rand.nextInt(password.length());
        g1+=password.charAt(index);
        this.userID = g1;
    }

    public String getUserID() {
        return userID;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public String getGov() {
        return gov;
    }

    public String getDate() {
        return date;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return this.mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return this.password;
    }
    public void setUserdata() {
        String input;
        Scanner sc=new Scanner(System.in);
        System.out.println("First name:    ");
        input=sc.nextLine();
        setFirstname(input);
        System.out.println("Last name:      ");
        input=sc.nextLine();
        setLastname(input);
        System.out.println("Password    \n");
        setPassword();
        setUserID();
        System.out.println("Address    ");

        System.out.println("street:    ");
        input=sc.nextLine();
        setStreet(input);
        System.out.println("area:    ");
        input=sc.nextLine();
        setArea(input);
        System.out.println("gov:    ");
        input=sc.nextLine();
        setGov(input);
        System.out.println("Mail:    ");
        input=sc.nextLine();
        while (!eMail(input))
        {
            System.out.println("invalid mail please try again");
            System.out.println("Mail:    ");
            input=sc.nextLine();
        }
        setMail(input);
        System.out.println("Phone:    ");
        input=sc.nextLine();
        setPhone(input);
        System.out.println("Date:    ");
        input=sc.nextLine();
        setDate(input);

    }
    public boolean eMail(String e) {
        if(e.contains(" ")||!e.contains("@")) {
            return false;
        }
        else if(!e.contains(".")) {
            return false;
        }
        else if(!e.contains("gmail")&&!e.contains("inbox")&&!e.contains("yahoo")&&!e.contains("outlook")&&!e.contains("zoho"))
        {return false;}
        else
        { return true;}
    }
    void print ()
    {
        System.out.println("First name:    "+getFirstname());
        System.out.println("Last name:      "+getLastname());
        System.out.println("UserID:      "+getUserID());
        System.out.println("Address:    "+getStreet()+" "+getArea()+" "+getGov());
        System.out.println("Mail:    "+getMail());
        System.out.println("Phone:    "+getPhone());
        System.out.println("Date:    "+getDate());
        System.out.println("Password:    "+getPassword());
    }
}