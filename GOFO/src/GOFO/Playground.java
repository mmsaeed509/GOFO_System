package GOFO;


import java.util.Random;
import java.util.Scanner;



public class Playground {
    private
    String name;
    String playgroundnum;
    String streetname;
    String area;
    String gov;
    float space;
    float priceperhour;
    String date;
    int opentime;
    int closetime;
    String ID;
    float rate;
    boolean state;
    float cancellationberiod;
    public String getName() {
        return name;
    }

    public String getPlaygroundnum() {
        return playgroundnum;
    }

    public float getSpace() {
        return space;
    }

    public float getPriceperhour() {
        return priceperhour;
    }

    public float getOpentime() {
        return opentime;
    }

    public float getClosetime() {
        return closetime;
    }

    public String getDate() {
        return date;
    }

    public float getRate() {
        return rate;
    }

    public float getCancellation() {
        return cancellationberiod;
    }

    public String getArea() {
        return area;
    }

    public String getGov() {
        return gov;
    }

    public String getStreetname() {
        return streetname;
    }
    public String getID() {
        return ID;
    }
    public boolean getstate()
    {
        return state;
    }
    void print ()
    {
        System.out.println("playground name  : "+getName());
        System.out.println("playground ID  : "+getID());
        System.out.println("playground address  : ");
        System.out.print(getPlaygroundnum()+" ");
        System.out.print(getStreetname()+" ");
        System.out.print(getArea()+" ");
        System.out.print(getGov()+" ");
        System.out.println("playground price per hour:"+getPriceperhour());
        System.out.println("Date of establishment:  "+getDate());
        System.out.println("Open time : "+getOpentime());
        System.out.println("Close time : "+getClosetime());
        System.out.println("Cancellation period : "+ getCancellation());
        System.out.println("state is  :"+ getstate());
        System.out.println("space is  :"+ getSpace());
    }
    void editplaygrounddata () {
        Scanner input = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        Scanner inputFloat = new Scanner(System.in);
        String data;
        System.out.println("choose one of the following options");
        System.out.println("1-edit playground name");
        System.out.println("2-edit playground address");
        System.out.println("3-edit playground date");
        System.out.println("4-edit playground price");
        System.out.println("5-edit playground open time");
        System.out.println("6-edit playground closing time");
        System.out.println("7-Exit");
        int choice = inputInt.nextInt();
        while (choice > 7 || choice < 1)
        {
            System.out.println("invalid input try again");
            System.out.println("choose one of the following options");
            System.out.println("1-edit playground name");
            System.out.println("2-edit playground address");
            System.out.println("3-edit playground date");
            System.out.println("4-edit playground price");
            System.out.println("5-edit playground open time");
            System.out.println("6-edit playground closing time");
            System.out.println("7-Exit");
            choice = inputInt.nextInt();
        }
        if (choice==1)
        {
            System.out.println("old name was: "+getName());
            System.out.println("enter new name");
            data=input.nextLine();
            setname(data);
        }
        else if (choice==2)
        {
            System.out.println("playground address  : ");
            System.out.print(getPlaygroundnum()+" ");
            System.out.print(getStreetname()+" ");
            System.out.print(getArea()+" ");
            System.out.print(getGov()+" ");
            System.out.println("enter new num");
            data=input.nextLine();
            setPlaygroundnum(data);
            System.out.println("enter new street");
            data=input.nextLine();
            setStreetname(data);
            System.out.println("enter new area");
            data=input.nextLine();
            setArea(data);
            System.out.println("enter new gov");
            data=input.nextLine();
            setGov(data);
        }
        else if (choice==3)
        {
            System.out.println("Old Date was : "+getDate());
            System.out.println("Enter new Date" );
            data=input.nextLine();
            setDate(data);
        }
        else if (choice==4)
        {
            float rt;
            System.out.println("Old price was : "+getPriceperhour());
            System.out.println("Enter new Price" );
            rt=inputFloat.nextFloat();
            while (rt<=0)
            {
                System.out.println("Invalid price");
                System.out.println("Old price was : "+getPriceperhour());
                System.out.println("Enter new Price" );
                rt=inputFloat.nextFloat();
            }
            setPriceperhour(rt);
        }
        else if (choice==5)
        {
            int rt;
            System.out.println("open time  was : "+getOpentime());
            System.out.println("Enter new time" );
            rt=inputInt.nextInt();
            while (rt==getClosetime())
            {
                System.out.println("invalid time please try again");
                System.out.println("open time  was : "+getOpentime());
                System.out.println("Enter new time" );
                rt=inputInt.nextInt();
            }
            setOpentime(rt);
        }
        else if (choice==6)
        {
            int rt;
            System.out.println("close time  was : "+getClosetime());
            System.out.println("Enter new time" );
            rt=inputInt.nextInt();
            while (rt==getOpentime())
            {
                System.out.println("invalid time please try again");
                System.out.println("close time  was : "+getClosetime());
                System.out.println("Enter new time" );
                rt=inputInt.nextInt();
            }
            setClosetime(rt);
        }
        else
            return;
    }

    public void setname(String data) {
        this.name=data;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCancellationberiod(float cancellationberiod) {
        this.cancellationberiod = cancellationberiod;
    }

    public void setClosetime(int closetime) {
        this.closetime = closetime;
    }

    public void setGov(String gov) {
        this.gov = gov;
    }

    public void setID() {
        String g1="";
        Random rand = new Random();
        int index=rand.nextInt(name.length());
        g1+=name.charAt(index);
        index=rand.nextInt(playgroundnum.length());
        g1+=playgroundnum.charAt(index);
        index=rand.nextInt(streetname.length());
        g1+=streetname.charAt(index);
        index=rand.nextInt(gov.length());
        g1+=gov.charAt(index);
        index=rand.nextInt(area.length());
        g1+=area.charAt(index);
        this.ID=g1;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean setstate ()
    {
        System.out.println("new playground state");
        System.out.println("1- active it");
        System.out.println("2- don't active");
        int in;
        Scanner sc=new Scanner(System.in);
        in=sc.nextInt();
        while (in>2 || in<1)
        {
            System.out.println("invalid choice ");
            System.out.println("new playground state");
            System.out.println("1-active it");
            System.out.println("2-don't active");
        }
        if (in==1)
            state=true;
        else
            state=false;
        return state;
    }

    public void setOpentime(int opentime) {
        this.opentime = opentime;
    }

    public void setPlaygroundnum(String playgroundnum) {
        this.playgroundnum = playgroundnum;
    }

    public void setPriceperhour(float priceperhour) {
        this.priceperhour = priceperhour;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setSpace(float space) {
        this.space = space;
    }
    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setplaygrounddata()
    {
        String s1;
        Float f1;
        int i1;
        Scanner sc=new Scanner(System.in);
        Scanner scInt=new Scanner(System.in);
        Scanner scFloat=new Scanner(System.in);
        System.out.println("playground name  : ");
        s1=sc.nextLine();
        setname(s1);
        System.out.println("playground address   ");
        System.out.println("playground num  : ");
        s1=sc.nextLine();
        setPlaygroundnum(s1);
        System.out.print("playground street");
        s1=sc.nextLine();
        setStreetname(s1);
        System.out.print("playground area");
        s1=sc.nextLine();
        setArea(s1);
        System.out.print("playground gov");
        s1=sc.nextLine();
        setGov(s1);
        System.out.print("playground space");
        f1=scFloat.nextFloat();
        setSpace(f1);
        System.out.print("playground price");
        f1=scFloat.nextFloat();
        setPriceperhour(f1);
        System.out.print("playground date of establishment:");
        s1=sc.nextLine();
        setDate(s1);
        System.out.println("Open time : ");
        i1=scInt.nextInt();
        setOpentime(i1);
        System.out.println("Close time : ");
        i1=scInt.nextInt();
        setClosetime(i1);
        System.out.println("Cancellation period :" );
        f1=scFloat.nextFloat();
        setCancellationberiod(f1);
        setID();
        state=false;
    }
}