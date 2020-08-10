package GOFO;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends User
{

    private
    float money=1000;
    ArrayList <String> invitations=new ArrayList<String>();
    ArrayList <Player> favorite =new ArrayList<Player>();
    ArrayList <Booking> history =new ArrayList<Booking>();
    public float getMoney() {
        return money;
    }

    public boolean Searchwithlocation(Playground p1)
    {
        if (p1.getStreetname().equals(this.street) && p1.getstate()) {
            return true;
        }
        else if (p1.getArea().equals(this.area) && p1.getstate())
        {
            return true;
        }
        else if (p1.getGov().equals(this.gov) && p1.getstate())
        {
            return true;
        }
        else
            return false;
    }
    public Playground Searchwithprice(Playground p1,float p2)
    {
        if (p1.getPriceperhour()==p2 && p1.getstate()) {
            return p1;
        }
        else
            return null;
    }
    public void displayplaygrounds(Playground p1)
    {
        if (p1.getstate())
            p1.print();
        else
            return;
    }
    public void sendmail (String p1)
    {
        String mail;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter mail content");
        mail=sc.nextLine();
        System.out.println("mail has been send successfully");
    }
    public void viewinvitations ()
    {
        for (int i=0;i<invitations.size();i++)
        {
            System.out.println(invitations.get(i));
        }
    }
    public void createfavouriteteam (ArrayList <Player> PP)
    {
        System.out.println("number of members mustn't exceed 22");
        if (favorite.size()==22)
        {
            System.out.println("number of members mustn't exceed 22");
            return;
        }
        else {
            String n1;
            boolean s=false;
            Scanner input=new Scanner(System.in);
            System.out.println("enter player ID");
            n1=input.nextLine();
            Player p1=new Player();
            for (int i=0;i<PP.size();i++)
            {
                p1=PP.get(i);
                if (p1.getUserID().equals(n1))
                {
                    s=true;
                    favorite.add(p1);
                    return;
                }
            }
            if (!s)
                System.out.println("invalid ID");
        }
    }
    public void editfavouriteteam ()
    {
        if (favorite.size()==0)
        {
            System.out.println("No members to edit");
            return;
        }
        else
        {
            Player p1 = new Player();
            boolean state=true;
            for (int i=0;i<favorite.size();i++)
            {
                p1=favorite.get(i);
                p1.print();
                System.out.println("********************////*******************************///***************************");
            }
            System.out.println("Enter player ID: ");
            String n1;
            Scanner input=new Scanner(System.in);
            n1=input.nextLine();
            for (int i=0;i<favorite.size();i++)
            {
                p1=favorite.get(i);
                if (p1.getUserID().equals(n1))
                {
                    favorite.remove(p1);
                    state=false;
                    return;
                }
            }
            if (state) {
                System.out.println("player ID not valid or may not exist try again ");
                return;
            }
        }

    }
    void book (ArrayList <Playgroundowner> r1)
    {
        boolean s=true;
        String plID;
        Playgroundowner pp=new Playgroundowner();
        Playground p2=new Playground();
        Scanner input= new Scanner(System.in);
        System.out.println("Enter playground ID");
        plID=input.nextLine();
        for (int i=0;i<r1.size();i++)
        {
            pp=r1.get(i);
            p2=pp.returnplayground();
            if (p2.getID().equals(plID))
            {
                s=false;
                break;
            }
        }
        if (s)
        {
            System.out.println("invalid ID try again later");
            return;
        }
        else
        {
            Booking b1 =new Booking();
            b1.Bookings(p2);
            if (b1!=null)
            {
                wallet(b1.getP1());
                history.add(b1);
            }
            else if (p2==null)
            {
                System.out.println("p2 is null");
            }
            else if (b1==null)
            {
                System.out.println("b1 is null");
            }
        }
    }

    public void wallet(Playground p) {
        if (money<p.getPriceperhour())
            System.out.println("sorry,we can't book because of invalid input");
        else
        {
            money-=p.getPriceperhour();
        }
    }
    public void wallet() {
        System.out.println("you have in ur wallet "+getMoney());
    }
    public void showhistory ()
    {
        Booking b1 =new Booking();
        for (int i=0;i<history.size();i++)
        {
            b1=history.get(i);
            b1.show();
        }
    }
}