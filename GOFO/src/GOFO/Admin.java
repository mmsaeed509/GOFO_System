package GOFO;

import java.util.ArrayList;

public class Admin extends User{
    protected ArrayList <Playground> nonactive=new ArrayList<Playground>();
    public void activeplayground ()
    {
        if (nonactive.size()>0)
        {
            boolean state;
            Playground p3=new Playground();
            for (int i=0;i<nonactive.size();i++)
            {
                p3=nonactive.get(i);
                p3.print();
                state=p3.setstate();
                if (state)
                {
                    nonactive.remove(p3);
                    return;
                }
            }
        }
        else
        {
            System.out.println("no playgrounds to activate");
            return;
        }
    }
    public void PLX (Playground pp)
    {
        nonactive.add(pp);
    }
}