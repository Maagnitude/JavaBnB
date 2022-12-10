/**
 *  Here we have the main method of the project.
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.InputMismatchException;

public class it214124 {
    
    public static void main(String[] args) {                                    //-Making object: next 112 lines
                                                                                // Making an:
        ArrayList <Residence> residenceArray = new ArrayList<>();               //-ArrayList for apartments and detached houses.
        ArrayList <Owner> ownerArray = new ArrayList<>();                       //-ArrayList for owners.
        ArrayList <Tenant> tenantArray = new ArrayList<>();                     //-ArrayList for tenants.
        ArrayList <Reservation> reservationArray = new ArrayList<>();           //-ArrayList for reservations.
        
        Apartment apartment1 = new Apartment("Agios Dimitrios", "Fedonos 20",   //-
                232994, 4, 1, true, true, true, true, "Sea", 34.5,              //---
                (float) 45.0, 1, true, true);                                   //-----
        Apartment apartment2 = new Apartment("Ilioupoli", "Parnithos 7",        //-------
                232995, 3, 1, true, true, true, false, "Mountain", 45.5,        //--------
                (float) 40.5, 1, true, true);                                   //--------- Making 4 Apartment objects.
        Apartment apartment3 = new Apartment("Dafni", "Thermopulwn 34",         //--------
                232995, 4, 2, true, true, true, false, "Sea", 20.0,             //-------
                (float) 60.5, 5, true, true);                                   //-----
        Apartment apartment4 = new Apartment("Peristeri", "Baknana 88",         //---
                232994, 5, 1, true, true, true, false, "Mountain", 12.5,        //-
                (float) 35.5, 1, true, true);
        
        DetatchedHouse detatched1 = new DetatchedHouse("Dafni", "Filonos 23",   //-
                232996, 4, 2, true, true, true, true, "Street", 22.5,           //---
                (float)55.0, 24.0, 0.0, true);                                  //-----
        DetatchedHouse detatched2 = new DetatchedHouse("Aigaleo", "Thiseos 87", //-------
                232993, 6, 2, true, true, true, true, "Street", 9.5,            //-------- Making 3 Detatched House objects.
                (float)46.5, 15.5, 5.0, true);                                  //-------
        DetatchedHouse detatched3 = new DetatchedHouse("Ilioupoli", "Sofouli 3",//-----
                232996, 5, 2, true, true, true, true, "Mountain", 22.5,         //---
                (float)55.0, 0.0, 10.0, true);                                  //-
        
        Owner owner1 = new Owner(232994, "George", "Kazazis", "Fedonos 25",     //-
                123444);                                                        //---
        Owner owner2 = new Owner(232995, "Nick", "Ioannou", "Parnithos 85",     //-----
                234533);                                                        //------- Making 4 Owner objects.
        Owner owner3 = new Owner(232996, "John", "Pappas", "Filonos 28",        //-------
                345611);                                                        //-----
        Owner owner4 = new Owner(232993, "Mary", "Antoniou", "Parnasou 33",     //---
                456722);                                                        //-
        
        Tenant tenant1 = new Tenant(232001, "Mike", "Louis", 123456,            //-
                "mike4ever@hotmail.com");                                       //---
        Tenant tenant2 = new Tenant(232002, "Marco", "Polo", 876543,            //-----
                "marcopolo@hotmail.com");                                       //------- Making 4 Tenant objects. 
        Tenant tenant3 = new Tenant(232003, "Xristina", "Kordatou", 121212,     //-------
                "ChristinePalm@hotmail.com");                                   //-----
        Tenant tenant4 = new Tenant(232004, "Athanasia", "Angou", 020717,       //---
                "nasiavre@gmail.com");                                          //-
        
        Calendar resbegindate1 = Calendar.getInstance();                        //-
        resbegindate1.set(2022,6,20);                                           //---
        Calendar resbegindate2 = Calendar.getInstance();                        //-----
        resbegindate2.set(2022,7,14);                                           //------- Making 4 Calendar object for 
        Calendar resbegindate3 = Calendar.getInstance();                        //------- the reservation begin dates.
        resbegindate3.set(2022,6,25);                                           //-----
        Calendar resbegindate4 = Calendar.getInstance();                        //---
        resbegindate4.set(2022,6,10);                                           //-
        
        Calendar resenddate1 = Calendar.getInstance();                          //-
        resenddate1.set(2022,6,28);                                             //---
        Calendar resenddate2 = Calendar.getInstance();                          //-----
        resenddate2.set(2022,7,22);                                             //------- Making 4 Calendar object for 
        Calendar resenddate3 = Calendar.getInstance();                          //------- the reservation end dates.
        resenddate3.set(2022,7,3);                                              //-----
        Calendar resenddate4 = Calendar.getInstance();                          //---
        resenddate4.set(2022,6,15);                                             //-
        
        Calendar today = Calendar.getInstance();                                // Making an instance for current system 
                                                                                // date to use in several cases.
         
        Reservation reserve1 = new Reservation("Agios Dimitrios", 232994,       //- 
                232003, resbegindate1, resenddate1, (float)45.0);               //--
        Reservation reserve2 = new Reservation("Ilioupoli", 232995,             //---
                232002, resbegindate2, resenddate2, (float)40.5);               //----
        Reservation reserve3 = new Reservation("Dafni", 232995,                 //-----
                232001, resbegindate3, resenddate3, (float)55.0);               //------
        Reservation reserve4 = new Reservation("Peristeri", 232994,             //------- Making 7 Reservation objects.
                232004, resbegindate4, resenddate4, (float)60.5);               //------
        Reservation reserve5 = new Reservation("Dafni", 232996, -1,             //-----
                today, today, (float)35.5);                                     //----
        Reservation reserve6 = new Reservation("Aigaleo", 232993, -1,           //---
                today, today, (float)46.5);                                     //--
        Reservation reserve7 = new Reservation("Ilioupoli", 232996, -1,         //-
                today, today, (float)55.0);
                
        residenceArray.add(apartment1);                                         //-
        residenceArray.add(apartment2);                                         //---
        residenceArray.add(detatched1);                                         //-----|| Adding the Residence objects 
        residenceArray.add(apartment3);                                         //------| in their ArrayList 
        residenceArray.add(apartment4);                                         //-----|| (residenceArray). 
        residenceArray.add(detatched2);                                         //---
        residenceArray.add(detatched3);                                         //-
        
        ownerArray.add(owner1);                                                 //-
        ownerArray.add(owner2);                                                 //--- Adding the Owner objects in 
        ownerArray.add(owner3);                                                 //--- their ArrayList (ownerArray).
        ownerArray.add(owner4);                                                 //-
        
        tenantArray.add(tenant1);                                               //-
        tenantArray.add(tenant2);                                               //--- Adding the Tenant objects in 
        tenantArray.add(tenant3);                                               //--- their ArrayList (tenantArray).
        tenantArray.add(tenant4);                                               //-
        
        reservationArray.add(reserve1);                                         //-
        reservationArray.add(reserve2);                                         //---
        reservationArray.add(reserve3);                                         //----|| Adding the Reservation objects 
        reservationArray.add(reserve4);                                         //-----| in their ArrayList 
        reservationArray.add(reserve5);                                         //----|| (reservationArray).
        reservationArray.add(reserve6);                                         //---
        reservationArray.add(reserve7);                                         //-
        
        Scanner input = new Scanner(System.in);                                 //-Making Scanner object for user input.        
        Backup backup = new Backup();                                           //-Making Backup object for useful methods.
        Owner owner = new Owner(-1, "", "", "", -1);                            //-Making Owner object for calling methods.
        Reservation reserve = new Reservation("", -1, -1, today, today,         //-Making Reservation object for calling 
                (float)0.0);                                                    // the methods.
        
        int option = 0;                                                         //-Option for the menu (1-5).
        char run = 'y';                                                         //-A "Do you wish to continue?" used variable.
        
//==============================> THE MENU <==================================// menu: next 38 lines
//                               (5 OPTIONS)
        while ( (option != 5) && (run == 'y') ) {
            backup.printMenu();                                                 //-Menu is printed to the screen.
            do {
                try {
                    option = input.nextInt();                                   //-User inputs option for the menu (1-5).   
                    break;
                } catch (InputMismatchException e) {                            //-We use InputMismatchException, to help
                    String str = input.nextLine();                              // the program, not get terminated, if the user
                    System.out.println("Please enter a number from 1 to 5!"     // enters something, other than an integer.
                            + " You entered " + str + " which is of incorrect "
                                    + "datatype.");
                }
            } while (true);
            switch (option) {
                case 1:
                    owner.registerResidence(ownerArray, residenceArray,         //- Owner's method for 
                                            reservationArray);                  //- registering a residence.
                    break;                                                       
                case 2:
                    reserve.makeReservation(residenceArray, reservationArray,   //- Reservation's method for 
                                            tenantArray);                       //- making a new reservation.
                    break;                                                      
                case 3:
                    reserve.changeReservation(residenceArray, reservationArray, //- Reservation's method for changing
                                              tenantArray);                     //- an existing reservation (Date
                    break;                                                      //- modification or cancellation).
                case 4:
                    backup.getReport(ownerArray, residenceArray, tenantArray,   //- Backup's method for getting a report.
                                     reservationArray);                         //- Either for owners (their residences)
                    break;                                                      //- or for tenants (their reservations).
                case 5:
                    run = backup.exitMenu();                                    //- Backup's method for exiting the menu.
                    break;
            }
            if (run == 'y') {                                                   //-If run is still 'y', the users is asked
                System.out.println("Do you wish to continue? (y/n)");           //-If he inputs 'y', the menu is printed
                run = input.next().charAt(0);                                   //-If he inputs 'n', the program is terminated.
            }
        }       
    }
}