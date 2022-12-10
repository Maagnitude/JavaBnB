/**
 *  A Backup class, for useful methods
 *  @author: George Kazazis, it214124
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Backup {
    
    Scanner input = new Scanner(System.in);
    
    public void printMenu() {                                                   //-
        System.out.println("Please choose one of the following options,"        //--
                + " by selecting the number (1-5):\n"                           //---
                + "\t\t\t1. Register a new residence.\n"                        //----
                + "\t\t\t2. Make a reservation.\n"                              //-----This method prints the menu to the screen.
                + "\t\t\t3. Change/Cancel a reservation.\n"                     //----
                + "\t\t\t4. Show info (about reservations, or residences).\n"   //---
                + "\t\t\t5. Exit.\n");                                          //--
    }                                                                           //-
    
    public void getReport(ArrayList <Owner> ownerArray,                         //-
            ArrayList <Residence> residenceArray,                               //-
            ArrayList <Tenant> tenantArray,                                     //-
            ArrayList <Reservation> reservationArray){                          //-
        System.out.println("You chose to view reports. Please "                 //-
                            + "enter your VAT Number: ");                       //--
        int vat = input.nextInt();                                              //-- User inputs the VAT number
        System.out.println("Are you an owner or a tenant?\n"                    //--
                            + "1.Owner\n2.Tenant\n");                           //--
        int choice;                                                             //--
        int position;                                                           //---
        do {                                                                    //---
            choice = input.nextInt();                                           //--- User enters '1' if he's an owner
            if ((choice !=1) && (choice != 2)) {                                //--- or '2' if he's a tenant.
                System.out.println("Invalid option. Please choose 1 or 2!");    //---
            }                                                                   //--
        } while ((choice != 1) && (choice != 2));                               //--
        if (choice == 1) {                                                      //-- Checking if the VAT number the user gave
            position = -1;                                                      //-- us, belongs to an owner, because he
            for (int i = 0; i < ownerArray.size(); i++) {                       //-- pressed '1'.
                if (ownerArray.get(i).getVatNumber() == vat) {                  //-
                    position = i;                                               //-
                }                                                               //-
            }                                                                   //-
            if (position == -1) {                                               //-   
                System.out.println("You chose '1' but you are not an owner!");  //-- If he chooses '1' and he's not an owner
            } else {                                                            //-- this process is terminated.
                System.out.println("Owner's name: "                             //-- 
                        + ownerArray.get(position).getFullName());              //--  Outputing owner's full name, and the 
                System.out.println("Residences you own: ");                     //--  residences he has registered to the 
                for (int j = 0; j < residenceArray.size(); j++) {               //--- system.
                    if (residenceArray.get(j).getVatNumber() ==                 //---
                            ownerArray.get(position).getVatNumber()) {          //--- TODO: IT MUST OUTPUT THE RESERVATION DAYS
                        System.out.println(residenceArray.get(j).toString       //--- OF A SPECIFIC RESIDENCE AFTER THE OWNER
                                                            (residenceArray));  //--- GIVES ITS VERIFICATION ID.
                    }                                                           //--
                }                                                               //--
            }                                                                   //--
        } else if (choice == 2) {                                               //--
            double totalcost = 0.0;                                             //--
            double eachcost;                                                    //-
            ArrayList <Reservation> yourReservations = new ArrayList<>();       //- Checking if the VAT number the user gave
            position = -1;                                                      //- us, belongs to a tenant, because he
            for (int i = 0; i < tenantArray.size(); i++) {                      //- pressed '2'.
                if (tenantArray.get(i).getVatNumber() == vat) {                 //-
                    position = i;                                               //-
                }                                                               //-
            }                                                                   //- 
            if (position == -1) {                                               //-
                System.out.println("You chose '2' but you are not a tenant!");  //- If he chooses '2' and he's not a tenant
                return;                                                         //- this process is terminated.
            } else {                                                            //-
                for (int i = 0; i < reservationArray.size(); i++) {             //-
                    if (reservationArray.get(i).getTenantVatNumber() == vat) {  //--
                        yourReservations.add(reservationArray.get(i));          //--
                    }                                                           //--
                }                                                               //--
            }                                                                   //--
            System.out.println("Your reservations are: \n");                    //--- Outputing owner's full name, and the 
            for (int i = 0; i < yourReservations.size(); i++) {                 //--- reservations he has made, along with 
                eachcost = (double)(yourReservations.get(i).getDailyCost()      //--- the total cost for each and all of them.
                        * ((yourReservations.get(i).getResEndDate().get         //---
                                                    (Calendar.DAY_OF_YEAR))     //---
                        - (yourReservations.get(i).getResBeginDate().get        //--
                                                    (Calendar.DAY_OF_YEAR))));  //--
                totalcost += eachcost;                                          //--
                System.out.println(yourReservations.get(i).toString());         //--
                System.out.println("Total cost for this residence: "            //--
                                    + eachcost + " €");                         //-
            }                                                                   //-
            System.out.println("\nTotal cost for all your reservations"         //-
                    + " is: " + totalcost + " €");                              //-
        }                                                                       //-
    }                                                                        
    
    public boolean isIncorrectVat(int vat) {    
        if (String.valueOf(vat).length() > 6) {
            System.out.println("Please enter a 6-digit number.");
            return true;
        } else {
            return false;
        }
    }
                                                                                            
    public char exitMenu(){                                                     //-
        System.out.println("\nThanks for visiting JavaBnb! Have a "             //--
                + "great day!\n\nExiting...");                                  //---Returns 'n', and the program is terminated.
        return 'n';                                                             //--
    }                                                                           //-
}