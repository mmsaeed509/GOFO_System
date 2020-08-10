package GOFO;

public class Playgroundowner extends User
{
    protected
    Playground ground;
    public Playgroundowner() {
        ground=null;
    }
    public Playground registerplayground ()
    {
        ground=new Playground();
        ground.setplaygrounddata();
        return ground;

    }
    public void showplayground()
    {
        ground.print();
    }
    public void editplayground()
    {
        ground.editplaygrounddata();
    }
    public void displayplayground ()
    {
        ground.print();
    }
    public Playground returnplayground ()
    {
        return ground;
    }
    public void setGround (Playground p4)
    {
        this.ground=p4;
    }

}