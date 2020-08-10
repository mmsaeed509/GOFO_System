package GOFO;
import java.util.Scanner;

public class Booking {
    private
    int from;
    int to;
    float price;
    String day;
    Playground p1=new Playground();
    public void Bookings (Playground p)
    {
        Scanner sc=new Scanner(System.in);
        this.p1=p;
        System.out.println("enter the day");
        day=sc.nextLine();
        System.out.println("enter the from hour");
        from=sc.nextInt();
        to=from;
        to++;
        this.price=p.getPriceperhour();
        p1=p;
    }
    public Playground getP1() {
        return p1;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public String getDay() {
        return day;
    }
    public void show ()
    {
        System.out.println("booking at day "+getDay());
        System.out.println("booking start at "+getFrom());
        p1.print();
    }
}