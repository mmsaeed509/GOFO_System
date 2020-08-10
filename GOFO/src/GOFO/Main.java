package GOFO;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String [] args) {

        ArrayList<Player> Accounts= new ArrayList<Player>();
        ArrayList<Playgroundowner> grounds = new ArrayList<Playgroundowner>();

        //------------------------------------------------------------

        ArrayList<Admin> admins = new ArrayList<Admin>();
        Admin A1=new Admin();
        String mail="adminadmin@GOFO.com";
        A1.setMail(mail);
        String pass="0123456789";
        A1.setPassword(pass);
        admins.add(A1);

        //------------------------------------------------------------

        User user=null;
        Player player = null;

        //------------------------------------------------------------

        Player playerone = new Player();
        playerone.setFirstname("moaz");
        playerone.setLastname("mahmoud");
        playerone.setPassword("012345");
        playerone.setStreet("horya");
        playerone.setArea("ainshams");
        playerone.setGov("cairo");
        playerone.setPhone("012345");
        playerone.setDate("5/5/2000");
        playerone.setMail("moazmahmoudsaad@gmail.com");
        playerone.setUserID();
        Accounts.add(playerone);

        //------------------------------------------------------------

        Playgroundowner playgroundowner1=new Playgroundowner();
        playgroundowner1.setFirstname("moaz");
        playgroundowner1.setLastname("mahmoud");
        playgroundowner1.setPassword("012345");
        playgroundowner1.setStreet("horya");
        playgroundowner1.setArea("ainshams");
        playgroundowner1.setGov("cairo");
        playgroundowner1.setPhone("012345");
        playgroundowner1.setDate("5/8/1988");
        playgroundowner1.setMail("moazmahmoudsaad@gmail.com");
        playgroundowner1.setUserID();
        grounds.add(playgroundowner1);

        //------------------------------------------------------------

        Playgroundowner playgroundowner = null;
        Playground playground = null;
        Booking booking = null;
        Admin admin = null;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerFloat = new Scanner(System.in);
        String E_Mail,password;
        String choice;

        menu :

        //------------------ Start Of Loop ----------------------------------

        while (true){

            System.out.println("**************************");
            System.out.println("* Welcome IN GOFO System *");
            System.out.println("**************************");
            System.out.println( " [1]  Sing up \n [2]  Sign in \n [3]  Login As Administrator \n [4]  Exit " );
            choice=scanner.nextLine();


            //---------------- Sign up -------------------------------------------------

            if (choice.equals("1") ){

                System.out.println("\n*******************");
                System.out.println(" Sign up As \n [1]  Player \n [2]  Ground Owner ");
                System.out.println("*******************");
                choice=scanner.nextLine();

                //-------------- Sign up As a Player ---------------------------

                if (choice.equals("1")){
                    player = new Player();
                    player.setUserdata();
                    System.out.println( "**************************************************\n ");
                    System.out.println("\n Sending Code Via e-mail...... ");

                    VerifyViaMail.Send_Verify_Code(player.getMail(),player.getFirstname());

                    System.out.println("\nCode has been sent successfully\n");
                    int code;
                    System.out.println("Enter Verification Code : ");
                    code=scannerInt.nextInt();
                    if ( VerifyViaMail.Check_Validation_Code(code) ){
                        Accounts.add(player);
                        System.out.println("\nYour Account Created successfully");
                        System.out.println("***********************************\n\n");
                    }
                }

                //----------- End Of Sign up As a Player -----------------------------------


                //------------ Sign up As a Owner --------------------------------------------

                else if (choice.equals("2")){
                    playgroundowner = new Playgroundowner();
                    playgroundowner.setUserdata();
                    System.out.println("\n***************************************************\n");
                    System.out.println("\n Sending Code Via e-mail...... ");
                    VerifyViaMail.Send_Verify_Code(playgroundowner.getMail(),playgroundowner.getFirstname());
                    System.out.println("\nCode has been sent successfully\n");
                    int code;
                    System.out.println("Enter Verification Code : ");
                    code=scanner.nextInt();
                    if ( VerifyViaMail.Check_Validation_Code(code) ){
                        grounds.add(playgroundowner);
                        System.out.println("\nYour Account Created successfully");
                        System.out.println("***********************************\n\n");
                    }
                }
                //-------------- End Of Sign up As a Owner ----------------------------------------

                //------------------------------------------------------------
                else {
                    System.out.println(" Invalid Chaise ");
                }
                //------------------------------------------------------------


            }
            //------------------ End Of Sign up ----------------------


            //------------------ Sign in ------------------------------------------------------

            else if (choice.equals("2")){

                System.out.println("[1]Sign in as player");
                System.out.println("[2]Sign in as playGroundOwner");
                choice=scanner.nextLine();
                System.out.println("Enter your e-mail");
                E_Mail=scanner.nextLine();
                System.out.println("Enter your password");
                password=scanner.nextLine();

                if (choice.equals("1")) {

                    //------------------ Start Of Loop --------------------------------------------

                    for (Player i : Accounts) {

                        //------------------ Player Home Page -----------------------
                        if (E_Mail.equals(i.getMail()) && password.equals(i.getPassword())) {

                            player=i;

                            //------------------ Start Of Loop -------------

                            while (true) {

                                System.out.println("*******************************");
                                System.out.println("* Welcome In Player Home Page *");
                                System.out.println("*******************************\n");
                                System.out.println(" [1]  PlayGround \n [2]  Your Team \n [3]  E-Wallet \n [4]  Edit Your Personal Information ");
                                System.out.println(" [5]  View Your Personal Data \n [6]  show hoistory \n [7]  Return To GOFO Home Page ");
                                choice = scanner.nextLine();

                                //------------------ Start Of PlayGround -----------------------

                                if (choice.equals("1")) {

                                    System.out.println(" [1]  Search With Location \n [2]  Search With Price ");
                                    System.out.println(" [3]  Display Ground \n [4]  Booking ");
                                    choice = scanner.nextLine();

                                    //------------------ Start Of Search With Location -----------------------

                                    if (choice.equals("1")) {
                                        playground = new Playground();
                                        boolean pow;
                                        Playgroundowner owner=new Playgroundowner();
                                        for (int p=0;p<grounds.size();p++)
                                        {
                                            owner=grounds.get(p);
                                            playground=owner.returnplayground();
                                            pow=player.Searchwithlocation(owner.returnplayground());
                                            System.out.println(pow);
                                            if (pow)
                                                playground.print();
                                        }
                                    }
                                    //------------------ End Of Search With Location --------------------------


                                    //------------------ Start Of Search With Price -----------------------

                                    else if (choice.equals("2")) {
                                        assert playground != null;
                                        float price = 0;
                                        Playground temp=new Playground();
                                        System.out.println(" Enter The Price You Want to Search ");
                                        price = scannerFloat.nextFloat();
                                        playground= new Playground();
                                        Playgroundowner owner=new Playgroundowner();
                                        for (int p=0;p<grounds.size();p++)
                                        {
                                            owner=grounds.get(p);
                                            playground=owner.returnplayground();
                                            temp=player.Searchwithprice(playground,price);
                                            if (temp!=null)
                                                temp.print();
                                        }
                                    }
                                    //------------------ End Of Search With Price -------------------

                                    //------------------ Start Of Display Ground -------------------

                                    else if (choice.equals("3")) {
                                        playground= new Playground();
                                        Playgroundowner owner=new Playgroundowner();
                                        for (int p=0;p<grounds.size();p++)
                                        {
                                            owner=grounds.get(p);
                                            playground=owner.returnplayground();
                                            if (playground!=null)
                                                player.displayplaygrounds(playground);
                                        }
                                    }
                                    //------------------ End Of Display Ground ----------------

                                    //------------------ Start Of Booking -------------------

                                    else if (choice.equals("4")) {
                                        if (player!=null)
                                            player.book(grounds);
                                        else
                                            System.out.println("no player data");
                                    }
                                    //------------------ End Of Booking -----------
                                    else {
                                        System.out.println(" Invalid Choice ");
                                    }

                                }
                                //------------------ End Of PlayGround ---------------




                                //------------------ Start Of Your Team ----------------

                                else if (choice.equals("2")) {
                                    System.out.println(" [1]  Creat Team \n [2] edit team \n[3]  send invitations ");
                                    choice = scanner.nextLine();

                                    //------------------ Start Of Creat Team -------------

                                    if (choice.equals("1")) {
                                        player.createfavouriteteam(Accounts);
                                        System.out.println(" new member added  ");
                                    }
                                    //------------------ End Of Creat Team -----------------------

                                    //------------------ Start Of Edit Team --------------

                                    else if (choice.equals("2")) {
                                        player.editfavouriteteam();
                                    }
                                    //------------------ End Of Edit Team ----------------

                                    //------------------ Start Of send mail Team ----------------

                                    else if (choice.equals("3")) {
                                        boolean se=false;
                                        System.out.println("enter user mail");
                                        String mail1;
                                        Scanner sc=new Scanner(System.in);
                                        mail1=sc.nextLine();
                                        for (Player P:Accounts)
                                        {
                                            if (player.getMail().equals(mail1))
                                            {
                                                player.sendmail(mail1);
                                                se=true;
                                                break ;
                                            }
                                        }
                                        if (!se)
                                            System.out.println("user not exist");
                                    }
                                    //------------------ End Of send mail Team ------------------
                                    else {
                                        System.out.println(" Invalid Choice ");
                                    }

                                }
                                //------------------ End Of Your Team ----------------------------------------



                                //------------------ Start Of E-Wallet --------------------

                                else if (choice.equals("3")) {
                                    player.wallet();
                                }
                                //------------------ End Of E-Wallet ------------------



                                //------------------ Start Of Edit Personal Info -------------

                                else if (choice.equals("4")){
                                    player.edituserdata();
                                }
                                //------------------ End Of Edit Personal Info ------------------




                                //------------------ Start Of View Your Personal Data ------------

                                else if (choice.equals("5")) {
                                    player.print();
                                }
                                //------------------ End Of View Your Personal Data ----------------



                                //------------------ Start Of View Your history Data --------------
                                else if (choice.equals("6")) {
                                    player.showhistory();
                                }
                                //------------------ End Of View Your Personal Data -------------------




                                //------------------ Start Of Return To GOFO Home Page -------------

                                else if (choice.equals("7")) {
                                    continue menu;
                                }
                                //------------------ End Of Return To GOFO Home Page ----------------------
                                else {
                                    System.out.println(" Invalid Choice ");
                                }



                            }
                            //------------------ End Of Loop ----------------------
                        }
                        //------------------ End Of Player Home Page -----------------------
                    }
                }




                else if (choice.equals("2")) {
                    for (Playgroundowner i : grounds) {

                        //------------------ Owner Home Page -----------------

                        if (E_Mail.equals(i.getMail()) && password.equals(i.getPassword()) ) {

                            //------------------ Start Of Loop --------------------------------

                            playgroundowner=i;

                            while (true) {

                                System.out.println("******************************");
                                System.out.println("* Welcome In Owner Home Page *");
                                System.out.println("******************************\n");
                                System.out.println(" [1]  Show Your Personal Information \n [2]  Edit Your Personal Information \n [3]  Register PlayGround ");
                                System.out.println(" [4]  Edit PlayGround \n [5]  Display PlayGround \n [6]  Return To GOFO Home Page ");
                                choice = scanner.nextLine();

                                //------------------ Start Of Show Your Personal Information -----------

                                if (choice.equals("1")) {
                                    playgroundowner.print();
                                }
                                //------------------ End OF Show Your Personal Information -------------------


                                //------------------ Start Of Edit Your Personal Information ------------

                                else if (choice.equals("2")) {
                                    playgroundowner.edituserdata();
                                }
                                //------------------ End Of Edit Your Personal Information -------------


                                //------------------ Start Of Register PlayGround --------------------

                                else if (choice.equals("3")) {
                                    Playground p1=new Playground();
                                    p1=playgroundowner.registerplayground();
                                    A1.PLX(p1);
                                }
                                //------------------ End Of Register PlayGround -----------------------


                                //------------------ Start Of Edit PlayGround -------------------

                                else if (choice.equals("4") && playgroundowner.ground!=null) {
                                    playgroundowner.editplayground();
                                }
                                //------------------ End Of Edit PlayGround ---------------


                                //------------------ Start Of Display PlayGround ---------------

                                else if (choice.equals("5") && playgroundowner.ground!=null) {
                                    playgroundowner.displayplayground();
                                }
                                //------------------ End Of Display PlayGround --------------------


                                //------------------ Start Of Return To GOFO Home Page ---------------------

                                else if (choice.equals("6")) {
                                    continue menu;
                                }
                                //------------------ End Of Return To GOFO Home Page ------------------------------
                                else {
                                    System.out.println(" Invalid Choice ");
                                }


                            }
                            //------------------ End Of Owner Home Page -----------------------

                        }

                    }
                    //------------------ End Of Loop -------------------------
                }

            }
            //------------------ End Of Sign ip ----------------



            //------------------ Administrator Home Page ------------------------

            else if (choice.equals("3")  ){

                System.out.println(" Enter Your Mail : ");
                String mail0 ;
                mail0=scanner.nextLine();
                System.out.println(" Enter Your password : ");
                String passwordAdmin;
                passwordAdmin=scanner.nextLine();

                //------------------ Start Of If -----------------------------

                if (mail0.equals("adminadmin@GOFO.com") && passwordAdmin.equals("0123456789")) {

                    //------------------ Start Of Loop -------------

                    while (true) {
                        System.out.println("**************************************");
                        System.out.println("* Welcome In Administrator Home Page *");
                        System.out.println("**************************************\n");
                        System.out.println(" \n [1]  Active PlayGround \n [2]  Return To Home Page ");
                        choice = scanner.nextLine();

                        //------------------ Start Of Delete PlayGround --------------

                        if (choice.equals("1")) {
                            A1.activeplayground();
                        }
                        //------------------ End Of Delete PlayGround ----------------------------

                        //------------------ Start Of Return To GOFO Home Page ------------------

                        else if (choice.equals("2")){
                            continue menu;
                        }
                        //------------------ End Of Return To GOFO Home Page -------------------------

                    }
                    //------------------ End Of Loop -----------------

                }
                //------------------ End Of If --------------------------
                else {
                    System.out.println(" Wrong Password ");
                }

            }
            //------------------ End Of Login As an Administrator ----------------


            //------------------ Exit From GOFO System ----------------
            else if (choice.equals("4") ){
                System.out.println(" Good bye ^_^ ");
                System.exit(0);
            }
            //------------------
            else {
                System.out.println(" Invalid Choice ");
            }

        }
        //------------------ End Of Loop ------------------------------------


    }
}