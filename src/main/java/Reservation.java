/**
 *  A Reservation class with its attributes and methods.
 *  @author: George Kazazis, it214124
 */

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation {
    
    private String municipality;                                                //-Reservation's residence's municipality.
    private int ownerVatNumber;                                                 //-Owner's VAT number (ΑΦΜ).
    private int tenantVatNumber;                                                //-Tenant's VAT number (ΑΦΜ).
    private Calendar resBeginDate;                                              //-The date the reservation begins.
    private Calendar resEndDate;                                                //-The date the reservation ends.
    private float dailyCost;                                                    //-Daily cost of the residence.
    String count;                                                               //-Used for the getReservationCode() method.
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");           //-Setting the date format of the output date.
    Scanner input = new Scanner(System.in);                                     //-Making Scanner object for user input.
    Backup backup = new Backup();                                               //-Making a Backup object to use its method.
  
    public Reservation (String municipality, int ownerVatNumber,                //-
            int tenantVatNumber, Calendar resBeginDate, Calendar resEndDate,    //--
            float dailyCost) {                                                  //---
        this.municipality = municipality;                                       //----
        this.ownerVatNumber = ownerVatNumber;                                   //----- Reservation's
        this.tenantVatNumber = tenantVatNumber;                                 //----- Constructor
        this.resBeginDate = resBeginDate;                                       //----
        this.resEndDate = resEndDate;                                           //---
        this.dailyCost = dailyCost;                                             //--
    }                                                                           //-
    
    public void setMunicipality(String municipality) {                          //-
        this.municipality = municipality;                                       //--- Reservation's municipality setter.
    }                                                                           //-
    
    public String getMunicipality() {                                           //-
        return municipality;                                                    //--- Reservation's municipality getter.
    }                                                                           //-
            
    public void setOwnerVatNumber (int ownerVatNumber) {                        //-
        this.ownerVatNumber = ownerVatNumber;                                   //--- Owner's VAT number setter.
    }                                                                           //-
    
    public int getOwnerVatNumber() {                                            //-
        return ownerVatNumber;                                                  //--- Owner's VAT number getter.
    }                                                                           //-
    
    public void setTenantVatNumber (int tenantVatNumber) {                      //-
        this.tenantVatNumber = tenantVatNumber;                                 //--- Tenant's VAT number setter.
    }                                                                           //-
        
    public int getTenantVatNumber() {                                           //-
        return tenantVatNumber;                                                 //--- Tenant's VAT number getter.
    }                                                                           //-
    
    public void setResBeginDate (Calendar resBeginDate) {                       //-
        this.resBeginDate = resBeginDate;                                       //--- Reservation Beginning Date setter.
    }                                                                           //-
    
    public Calendar getResBeginDate () {                                        //-
        return resBeginDate;                                                    //--- Reservation Beginning Date getter.
    }                                                                           //-
    
    public void setResEndDate (Calendar resEndDate) {                           //-
        this.resEndDate = resEndDate;                                           //--- Reservation Ending Date setter.
    }                                                                           //-
    
    public Calendar getResEndDate () {                                          //-
        return resEndDate;                                                      //--- Reservation Ending Date getter.
    }                                                                           //-
    
    public void setDailyCost (float dailyCost) {                                //-
        this.dailyCost = dailyCost;                                             //--- Reservation Daily cost setter.
    }                                                                           //-
    
    public float getDailyCost () {                                              //-
        return dailyCost;                                                       //--- Reservation Daily cost getter.
    }                                                                           //-
    
    public float getTotalCost() {                                               //-- This method calculates the total cost of
        return (getResEndDate().get(Calendar.DAY_OF_YEAR)                       //-- the reservation by multiplying the daily
                - getResBeginDate().get(Calendar.DAY_OF_YEAR)) * getDailyCost();//-- cost with the total days reserved.
    }                                                                           //-
    
    public String getReservationCode(ArrayList <Reservation> reservationArray) {//---------------- This method makes the 
        if (reservationArray.size() < 10) {                                     //---------------- Reservation code, the same way
            count = String.format("%05d", reservationArray.indexOf(this)+1);    //---------------- it does in the Residence class.
        } else if ((reservationArray.size() >= 10) && (reservationArray.size() < 100)){       //-- It returns it in the form of
            count = String.format("%04d", reservationArray.size()+1);                        //--- "XX-ΕΤΟΣ-AAAAA".
        } else if ((reservationArray.size() >= 100) && (reservationArray.size() < 1000)){   //---- (For more details, please go  
            count = String.format("%03d", reservationArray.size()+1);                      //-----  go check the Residence class).
        } else if ((reservationArray.size() >= 1000) && (reservationArray.size() < 10000)){     //
            count = String.format("%02d", reservationArray.size()+1);                          //
        } else if ((reservationArray.size() >= 10000) && (reservationArray.size() < 100000)){ //
            count = String.format("%01d", reservationArray.size()+1);           ///////////////
        }                                                                       //------------
        return getMunicipality().substring(0, 2).toUpperCase() +                //---------
                "-" + resBeginDate.get(Calendar.YEAR) + "-" +                   //------
                count;                                                          //---
    }
    
    @Override
    public String toString() {                                                  //-
        return "A reservation at " + getMunicipality()                          //--
                + "\nOwner VAT number: " +  getOwnerVatNumber()                 //---
                + "\nYour VAT number: " + getTenantVatNumber()                  //---- This method outputs the reservation's
                + "\nBegining Date: " + dateFormat.format                       //---- info, if the tenant chooses to see his
                                                   (getResBeginDate().getTime())//---- reservations with menu option "4".
                + "\nEnding Date: " + dateFormat.format                         //---
                                                    (getResEndDate().getTime()) //--
                + "\nDaily cost: "+ getDailyCost();                             //-
    }
    
    public void makeReservation(ArrayList <Residence> residenceArray,           //
            ArrayList <Reservation> reservationArray,                           //
            ArrayList <Tenant> tenantArray) {                                   //
        System.out.println("You chose to make a reservation!\n" +               //
        "Please enter the following criteria, so we can show you " +            //
        "your options");                                                        //
        Calendar yesterday = Calendar.getInstance();
        yesterday.roll(Calendar.DAY_OF_YEAR, -1);
        Calendar rbegin = Calendar.getInstance();                               // Making an date instance.
        Calendar rend = Calendar.getInstance();                                 // Making another date instance.
        do {                                                                    //
            System.out.println("\nReservation beginning date(in format "        //
                    + "YYYY/MM/DD):\n(Enter YYYY (space) MM (space) DD "        //
                    + "(enter))\n(YYYY: Year, MM: Month, DD: Day (Number): ");  //
            rbegin.set(input.nextInt(), input.nextInt(), input.nextInt());      // User inputs the beginning date he wants.
            System.out.println("Reservation ending date(in format YYYY/MM/DD)"  //
                    + "\n(Enter YYYY (space) MM (space) DD (enter))\n"          //
                    + "(YYYY: Year, MM: Month, DD: Day (Number): ");            //
            rend.set(input.nextInt(), input.nextInt(), input.nextInt());        // User inputs the ending date he wants.
            if (rend.get(Calendar.DAY_OF_YEAR)                                  // If the total days are more than 15, we inform
                    - (rbegin.get(Calendar.DAY_OF_YEAR)) > 15) {                // him that he cannot stay that long.
                System.out.println("\nYou cannnot stay longer than 15 days."    //
                        + "\nPlease change the dates.");                        //
            }                                                                   //
        } while (rend.get(Calendar.DAY_OF_YEAR)                                 // The process is repeated until his total days
                    - (rbegin.get(Calendar.DAY_OF_YEAR)) > 15);                 // are less than or equal to 15.
        System.out.println("For how many people? ");                            //
        int capacity = input.nextInt();                                         // User inputs the number of people, that will
        System.out.println("Municipality: ");                                   // stay in the residence.
        String municipal    = input.next();                                     // User inputs the municipality, that he wants.
        ArrayList <Residence> foundResidences = new ArrayList<>();              //- Making an ArrayList for the residences that
    //TO BE TESTED                                                              //  match his requirements.
        int avail;                                                              // 
        for (int i = 0; i < residenceArray.size(); i++) {                       // For all the residences in the system,
            if ((residenceArray.get(i).getResidCapacity() >= capacity) &&       // if the residence has enough capacity
                    (municipal.toLowerCase().contains(residenceArray.get(i).    // and the municipality matches the one
                            getMunicipality().toLowerCase()))){                 // entered by the user, the process continues.   
                avail = 0;                                                      // The avail and the mun variables are set to 0.      
                int mun = 0;                                                    //
                for (int j = 0; j < reservationArray.size(); j ++) {            // For all the reservations in the system,
                    if (municipal.toLowerCase().contains(reservationArray.      // if the municipality matches the one entered
                            get(j).getMunicipality().toLowerCase())){           // by the user, mun is increased by one.    
                        mun++;                                                  //______________
                        if ((((rbegin.before(reservationArray.get(j).getResBeginDate()))&& //- If the reservation beginning
                                (rend.before(reservationArray.get(j).getResBeginDate())))||//- and ending dates the user 
                                ((rbegin.after(reservationArray.get(j).getResEndDate()))&& //- entered, are before the ones of 
                                (rend.after(reservationArray.get(j).getResEndDate())))) && //- an existing reservation's, OR
                                (rbegin.before(rend)) && rbegin.after(yesterday)) { //-------- after the ones of an existing
                            //TO BE TESTED                                      //------------ reservation's, AND the beginning                
                                 avail++;                                       //------------ one is before the ending one, AND
                        }                                                       //-----------  the beginning date is the earliest
                    }                                                           //------------ today.
                }                                                               //------- Then avail is increased by one.
                                                                                
                                                                               
                if (avail == mun) {                                             //- If num is equal to avail the residence is 
                    foundResidences.add(residenceArray.get(i));                 //  added to the found residences.
                }                                                               //
            }                                                                   //
        }                                                                       //
        if (!foundResidences.isEmpty()) {                                       //
            System.out.println("Found " + foundResidences.size()                //  
                    + " residence(s) in " + municipal                           //
                    + ", that meet(s) your criteria.\nAs shown below:");        //
            System.out.println("\tType" + "\t\t\tMunicipality" +                //
                    "\t\tAddress" + "\t\tCost/day" + "\tVerification Code\n");  //- If there are residences found, pops out 
            for (int i = 0; i < foundResidences.size(); i++) {                  //  the message with the info.
                System.out.println((i+1)                                        //
                        + foundResidences.get(i).toView(residenceArray));       //
            }                                                                   //
            System.out.println("\nPlease choose the Verification ID of the "    //
                    + "residence you desire:");                                 //
            int position = -1;                                                  //
            do {                                                                //
                String verifID = input.next();                                  //- User inputs the Verification ID of the 
                for (int i = 0; i < foundResidences.size(); i++) {              //  residence he desires.
                    if (verifID.contains(foundResidences.get(i).getVerificID    //
                                                        (residenceArray))) {    //- If the Verification ID exists in the 
                        position = i;                                           //  ArrayList, we get its position.
                        System.out.println("To complete the reservation please" //
                                + " enter your VAT number:");                   //
                        int vat1;
                        do {
                            do {
                                try {
                                    vat1 = input.nextInt();                     //- Inputs his VAT number.
                                    break;
                                } catch (InputMismatchException e) {
                                    String str = input.nextLine();
                                    System.out.println("Please enter a 6-digit VAT "
                                            + "number. You entered " + str 
                                            + " which is of incorrect datatype.");
                                }
                            } while (true);
                        } while (backup.isIncorrectVat(vat1));
                        
                        int done = 0;                                           //
                        int exist = 0;                                          //
                        int at = 0;                                             //
                        for (int j = 0; j < tenantArray.size(); j++) {          //- If the VAT number exists in the ArrayList
                            if (vat1 == tenantArray.get(j).getVatNumber()) {    //  we get the tenants position.
                                exist = 1;                                      //
                                at = j;                                         //
                            }                                                   //
                        }                                                       //
                        if (exist == 1) {                                       //- If the tenant exists,
                            System.out.println("VAT number found in the system."//- Outputs the full name of the tenant.
                                    + "\nTenant's fullname: "                   //
                                    + tenantArray.get(at).getFullName()         //
                                    + "\nYour reservation has been completed!");//
                            for (int z = 0; z < reservationArray.size(); z ++) {//__________________________________________________________
                                if (((municipal.toLowerCase().contains(reservationArray.get(z).getMunicipality().toLowerCase()))) &&      // 
                                        (reservationArray.get(z).getOwnerVatNumber() == foundResidences.get(position).getVatNumber()) && //
                                        (reservationArray.get(z).getTenantVatNumber() == -1)) { //////////////////////////////////////////
                                    reservationArray.get(z).setTenantVatNumber(vat1); ///////////- Sets the new info in the 
                                    reservationArray.get(z).setResBeginDate(rbegin); // ---------- existing reservation slot.
                                    reservationArray.get(z).setResEndDate(rend);//////------------
                                    System.out.println("Reservation code is: "  ////////////- Outputs the Reservation code.
                                            + reservationArray.get(z).getReservationCode //
                                                                    (reservationArray));//
                                    done = 1;                                   /////////- So done variable becomes one.   
                                    break;                                      //
                                }                                               //
                            }                                                   //
                            if (done == 0) {                                    //-------- If it didn't become one, then
                                Reservation reservation = new Reservation (municipal, //-- a new Reservation object is made.
                                        foundResidences.get(position).getVatNumber(), vat1, rbegin, // 
                                        rend, foundResidences.get(position).getDailyCost()); ////////
                                reservationArray.add(reservation);              ////////////////////
                                System.out.println("Reservation code is: "      //________Reservation code is generated________
                                    + reservationArray.get(reservationArray.size()-1).getReservationCode(reservationArray)); //
                                break;                                          //////////////////////////////////////////////
                            }                                                   //
                        } else if (exist == 0) {                                //- If the tenant doesn't exist,
                                System.out.println("New tenant! Please register"//
                                        + " by giving the following info: "     //
                                        + "\nFirst name: ");                    //
                                String firstname = input.next();                //- Inputs first name.
                                System.out.println("Last name: ");              //
                                String lastname = input.next();                 //- Inputs last name.
            //To check email validation()                                       //
                                String email = "";                              //
                                do {                                            //
                                    System.out.println("Your email address (in "//
                                            + "the form of 'xxxxx@yyyy.zzz')"); //
                                    email = input.next();                       //- Inputs email.
                                } while (!(email.contains("@gmail.com") ||      //- Email is checked to be in the form of
                                           email.contains("@gmail.gr") ||       //- "******@gmail.com" ,or "***@gmail.gr",
                                           email.contains("@hotmail.com") ||    //- or "*****@hotmail.com",
                                           email.contains("@hotmail.gr") ||     //- or "*****@hotmail.gr",
                                           email.contains("@hua.gr")));         //- or "*****@hua.gr"
                                int id;
                                do {    
                                    do {
                                        try {
                                            System.out.println("Your ID number:"
                                                    + " (6-digits number)");                 
                                            id = input.nextInt();                                   // (The id is a number to make things easier).
                                            break;
                                        } catch (InputMismatchException e) {                        //-We use the InputMismatchException to support
                                            String str = input.nextLine();                          // the program if the user gives something, other
                                            System.out.println("ID must be a 6-digit number. You "  // than an integer.
                                                    + "entered " + str + " which is a different "
                                                            + "datatype. Please try again.");
                                        }
                                    } while (true);
                                } while (backup.isIncorrectVat(id));            //-To make sure the number won't have more than 6 digits
                                while (String.valueOf(id).length() < 6) {       //-If VAT number entered, has less than 6-digits
                                    id *= 10;                                   // we add zeros, to make it a 6-digit number.
                                }                                               //
                                while (String.valueOf(vat1).length() < 6) {     //-If VAT number entered, has less than 6 digits
                                    vat1 *= 10;                                 // we add zeros, to make it a 6-digit number.
                                }                                               //
                                Tenant tenant = new Tenant(vat1, firstname, lastname, id, email); //- New tenant created.
                                tenantArray.add(tenant);                        ///////////////////___Added to the ArrayList_________
                                System.out.println("New tenant added! Info: " + tenantArray.get(tenantArray.size()-1).toString()); //
                                for (int j = 0; j < foundResidences.size(); j++) { /////////////////////////////////////////////////
                                    if (foundResidences.get(j).getVerificID(residenceArray).contains(verifID)){ //___________
                                        String code = foundResidences.get(j).getReservationCode(rbegin, reservationArray); //_________
                                        System.out.println("\nYour reservation has been completed!\nReservation code is: " + code); //
                                    }                                           /////////////////////////////////////////////////////
                                }                                               //_____
                                for (int z = 0; z < reservationArray.size(); z ++) { //_____________________________________________________
                                    if ((reservationArray.get(z).getMunicipality().toLowerCase().contains(municipal.toLowerCase())) &&    //___
                                            (reservationArray.get(z).getOwnerVatNumber() == foundResidences.get(position).getVatNumber()) && //
                                            (reservationArray.get(z).getTenantVatNumber() == -1)) { //////////////////////////////////////////
                                        reservationArray.get(z).setTenantVatNumber(vat1); ///////////
                                        reservationArray.get(z).setResBeginDate(rbegin); //- Same process as above.
                                        reservationArray.get(z).setResEndDate(rend); /////
                                        done = 1;                               //////
                                    }                                           ///////////////////////////
                                }                                               //- Same process as above.
                                if (done == 0) {                                //
                                    Reservation reservation = new Reservation (municipal,    ////////_____
                                            foundResidences.get(position).getVatNumber(), vat1, rbegin, //
                                            rend, foundResidences.get(position).getDailyCost()); ////////
                                    reservationArray.add(reservation);          //////////////////                                          /////////////////
                                    break;                                      //
                                }                                               //
                            }                                                   //
                    }                                                           //
                }                                                               //
                                                                                //
                if (position == -1) {                                           //- If position didn't take a value
                    System.out.println("Incorrect Verification ID. "            //  the Verification ID was incorrect.
                            + "Please try again!");                             //
                }                                                               //
            } while (position == -1);                                           //- And the process is repeated.
        } else {                                                                //
            System.out.println("Could not find a residence that "               //
                    + "meets your criteria. Please try different ones!");       //
        }                                                                       //                        
    }                                                                           
                                                                                
    Calendar today = Calendar.getInstance();                                    //- Making an instance for today's system date.
                                                                                
    public void changeReservation(ArrayList <Residence> residenceArray,         //
            ArrayList <Reservation> reservationArray,                           //
            ArrayList <Tenant> tenantArray) {                                   //
        int selection;                                                          //
        String rescode;                                                         //
        System.out.println("You chose to change/cancel a reservation."          //
                + "\nEnter '1' to change the dates of a reservation"            //
                + " or '2' to cancel it: ");                                    //
        selection = input.nextInt();                                            //- User enters '1' for date modification
        int position = -1;                                                      //  or '2' for reservation cancellation.
        int codpos = -1;                                                        //
        switch(selection){                                                      //
            case 1:                                                             //===Date modification===
                System.out.println("Modification process begins..."             //
                        + "\nPlease give your VAT number:");                    //
                int vat = input.nextInt();                                      //- Inputs VAT number.
                for (int i = 0; i < tenantArray.size(); i++) {                  //- We check if users exists in the system.
                    if (tenantArray.get(i).getVatNumber() == vat) {             //
                        position = i;                                           //- Take tenant's position.
                        break;                                                  //
                    }                                                           //
                }                                                               //  
                if (position != -1) {                                           //- If we got a position, the user gives the
                    System.out.println("Please give the Reservation"            //  Reservation Code of the residence he 
                            + " code of the reservation you want to modify: "); //  wants to change.
                    rescode = input.next();                                     //
                    for (int i = 0; i < reservationArray.size(); i++) {         //
                        if (rescode.contains(reservationArray.get(i).           //- If the Reservation Code exists, we take 
                                getReservationCode(reservationArray))) {        //  the reservation's position.
                            codpos = i;                                         //
                            break;                                              //
                        }                                                       //
                    }                                                           //
                    if (codpos != -1) {                                         //
                        Calendar rbegin = Calendar.getInstance();               //
                        Calendar rend = Calendar.getInstance();                 //___________
                        if (reservationArray.get(codpos).getResBeginDate().after(today)) { //- If the reservation beginning date
                            do {                                                ////////////-- starts tomorrow, dates can be 
                                System.out.println("\nReservation beginning date(in format YYYY/MM/DD): " //-       modified.
                                        + "\n(Enter YYYY (space) MM (space) DD (enter))\n" ////////////////
                                        + "(YYYY: Year, MM: Month, DD: Day (Number): "); ///_____
                                rbegin.set(input.nextInt(), input.nextInt(), input.nextInt()); //---- Inputs new beginning date.
                                System.out.println("Reservation ending date(in format YYYY/MM/DD)" //
                                        + "\n(Enter YYYY (space) MM (space) DD (enter))\n" /////////
                                        + "(YYYY: Year, MM: Month, DD: Day (Number): "); ///___
                                rend.set(input.nextInt(), input.nextInt(), input.nextInt()); //------ Inputs new ending date.
                                if (rend.get(Calendar.DAY_OF_YEAR)-(rbegin.get(Calendar.DAY_OF_YEAR)) > 15) { //_______________
                                    System.out.println("\nYou cannnot stay longer than 15 days.\nPlease change the dates."); //
                                }                                               //New reservation's total days must be less than
                            } while ((rend.get(Calendar.DAY_OF_YEAR)-(rbegin.get(Calendar.DAY_OF_YEAR)) > 15)); //-          15.
                            reservationArray.get(codpos).setResBeginDate(rbegin); //-- We change the dates of this reservation
                            reservationArray.get(codpos).setResEndDate(rend);   ///--- using its position (codpos)
                            System.out.println("Dates have been modified. Your new reservation begins on " //_______
                                    + dateFormat.format(reservationArray.get(codpos).getResBeginDate().getTime()) //________________
                                    + " and ends on " + dateFormat.format(reservationArray.get(codpos).getResEndDate().getTime()) //
                                    + ". Have a great day!");                   //-- We inform the user by outputing the new dates.
                        } else {                                                //
                            System.out.println("Your request cannot be "        //-- Inform user that it cannot be done, because the
                                    + "fulfilled because your reservation "     //   reservation starts today.
                                    + "begins today.");                         //
                        }                                                       //
                    }                                                           //
                } else {                                                        //
                    System.out.println("Your VAT number wasn't"                 //-- VAT number wasn't found in the system.
                            + " found in the system, so you "                   //
                            + "don't have an active reservation"                //
                            + " with this Reservation code.");                  //
                }                                                               //
                break;                                                          //
            case 2:                                                             //===Reservation cancellation===
                System.out.println("Cancellation process begins..."             //
                        + "\nPlease give your VAT number:");                    //
                vat = input.nextInt();                                          //-- Inputs VAT number.
                for (int i = 0; i < tenantArray.size(); i++) {                  //
                    if (tenantArray.get(i).getVatNumber() == vat) {             //
                        position = i;                                           //-- Checking user's position.
                        break;                                                  //
                    }                                                           //
                }                                                               //
                if (position != -1) {                                           //-- If the user exists in the system
                    System.out.println("Please give the Reservation"            //   he inputs the reservation code.
                            + " code of the reservation you want "              //
                            + "to cancel: ");                                   //
                    rescode = input.next();                                     //
                    for (int i = 0; i < reservationArray.size(); i++) {         //______________________________
                        if (rescode.contains(reservationArray.get(i).getReservationCode(reservationArray))) { //
                            codpos = i;                                         ///////////////////////////////
                            break;                                              //-- We take the reservation position.
                        }                                                       //
                    }                                                           //
                    float charge;                                               //-- Final charge of the cancellation.
                    double cancelcost;                                          //-- 10% of the total cost of the reservation.
                    if ((codpos != -1) && (reservationArray.get(codpos).getTenantVatNumber() == vat)) { //
                        System.out.println(dateFormat.format(today.getTime())); /////////////////////////_____________________________________________
                        int daystores = reservationArray.get(codpos).getResBeginDate().get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR); //
                        cancelcost = 0.1 * reservationArray.get(codpos).getTotalCost(); /////////////////////////////////////////////////////////////
                        charge = (float)cancelcost + (reservationArray.get(codpos).getTotalCost()/(float)daystores); //
                        String chargestr = String.format("%.2f", charge);       //////////////////////////////////////
                        System.out.println("\nYour current reservation begins on " + dateFormat.format //
                                    (reservationArray.get(codpos).getResBeginDate().getTime()) /////////________________________
                                + " and ends on " + dateFormat.format(reservationArray.get(codpos).getResEndDate().getTime()) //
                                + ", and it costs " + reservationArray.get(codpos).getTotalCost() /////////////////////////////
                                + " €.\nIf you cancel this reservation, there will be charge equal to " //
                                + chargestr + " €.\n");                         //-- We inform the user about the charge.
                        char proceed;                                           //
                        do {                                                    //
                            System.out.println("Do you want to proceed? (y/n)");//
                            proceed = input.next().charAt(0);                   //-- Inputs 'y' or 'yes' to proceed. 'n' or 'no' 
                        } while ((proceed != 'y') && (proceed != 'n'));         //   if the user changed his mind.
                        if (proceed == 'y') {                                   //__________
                            System.out.println("Your reservation with Reservation code: " //- With 'yes' we change the ArrayList
                                    + reservationArray.get(codpos).getReservationCode(reservationArray) // by putting values
                                    + " has been canceled, and you have been charged " + chargestr //////  'today', 'today' and
                                    + " €.\nThanks for contacting us.\nHave a great day!\n"); ////// '-1' in attributes 
                            reservationArray.get(codpos).setResBeginDate(today);/////////////// tenantVatNumber, resBeginDate, and
                            reservationArray.get(codpos).setResEndDate(today);  // resEndDate respectivly, in order to "empty" the
                            reservationArray.get(codpos).setTenantVatNumber(-1);// reservation slot.
                        } else {                                                //
                            System.out.println("We understand. We will be "     //-- If he changed his mind, the process is ended.
                                    + "in your service at any time. "           //
                                    + "Have a great day!\n");                   //
                        }                                                       //
                    } else {                                                    //
                        System.out.println("We found your account, but you "    //-- If the user exists in the system, but he does
                                + "do not have any active reservation."         //  not have a reservation in his name.
                                + "\nHave a great day!\n");                     //
                    }                                                           //
                } else {                                                        //
                    System.out.println("Your VAT number wasn't"                 //-- If the user doesn't exist in the system, so
                            + " found in the system, so you "                   //  he doesn't have a reservation either.
                            + "don't have an active reservation.");             //
                }                                                               //
                break;                                                          //
            default:                                                            //
                System.out.println("Invalid option!\nPlease "                   //
                        + "select '1' or '2' to proceed!");                     //
        }                                                                       //                                                                                      
    }
}