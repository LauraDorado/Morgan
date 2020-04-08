package laboratorio3;
import java.util.Scanner;

public class Laboratorio3 {
    
    static Scanner sc = new Scanner(System.in); 
    
    //VARIABLES:
    String[]nameClient=new String[5];
    String[]registerNumber=new String[5];
    String[]expeditionDate=new String[5];
            
    int[]numberOfBoxes=new int[5];
    int[]weightBox=new int[5];
    int[]typeLoad=new int[5];
    int[]owner=new int[5];
    int[]category=new int[5];
    
    double[]totalValuePaid=new double[5];
    double[]kilosTransported=new double[5];
    double[]weightLoad=new double[5];
    double[]discount=new double[5];
    double[]totalValue=new double[5];
    
    int add;   
    int stop=0;  
    int numberOfLoads=0;
    
    double netWeight=0;
    String[]categoryName={"Normal","Silver","Gold","Platinum"};
    String ship1=("No");
    String ship2=("Yes");
    
    //METHODS:    
    /**
     * Name of the method: menu
     * <br>
     * This method display an option menu <br> 
     */
    
    public static void menu() {

        System.out.println("Welcome to the main menu. What do you want to do?");
        System.out.println("1. Register the clients");
        System.out.println("2. Load the ship");
        System.out.println("3. Unload the ship");
        System.out.println("4. Update the client's category");
        System.out.println("5. View the profile of all the clients");               
        
    }//Menu ends
    
    /**
     * Name of the method: registerClient
     * <br>
     * This method allows the user to register clients <br>                           
     * @param totalValuePaid Is the total value that the client has paid in previous loads
     * @param kilosTransported Is the sum of the weight of all the loads that the client has transported.
     * @param category Is the category of the client. This can be NORMAL, SILVER, GOLD or PLATINUM.
     * @param nameClient Is the name of the client
     * @param registerNumber Is the commercial register number of the client
     * @param expeditionDate Is the expedition date of the client's commercial register
     */
    
    public static void registerClient(double[]totalValuePaid, double[]kilosTransported, int[]category, String[]nameClient, String[]registerNumber, String[]expeditionDate){
        
        System.out.println("\nWHEN THE NEXT LINE DOES NOT COME IMMEDIATELY, PRESS ENTER AGAIN\n");
        for (int i=0;i<5;i++){
            System.out.println("\nCLIENT "+(i+1)+":");
            sc.nextLine();
            System.out.println("Enter the name of the client ");
            nameClient[i] = sc.nextLine();
            sc.nextLine();
            System.out.println ("Enter the commercial register number of the client");
            registerNumber[i]=sc.nextLine();
            sc.nextLine();
            System.out.println("Enter the expedition date of the client's register");
            expeditionDate[i]=sc.next();            
            sc.nextLine();
            System.out.println("\nEnter the category of the cliente (Normal, Silver, Gold or Platinum)");
            do{
                System.out.println("1. Normal");
                System.out.println("2. Silver");
                System.out.println("3. Gold");
                System.out.println("4. Platinum");           
                category[i]=sc.nextInt();
                    if (category[i]>4||category[i]<1)
                        System.out.println("Enter a valid option");
            }while(category[i]>4||category[i]<1);
            System.out.println("\nEnter the number of kilos that the client has transported");
            kilosTransported[i]=sc.nextInt();
            System.out.println("\nEnter the total value paid for the client");
            totalValuePaid[i]=sc.nextInt();
            System.out.println("\nThe client has been succesfully registered");
        }    
    }//registerClient ends
    
    /**
     * Name of the method: loadTheShip
     * <br>
     * This method allows the user to load the ship.    
     * @param ship1 Means if the ship complies with the condition 1.
     * @param ship2 Means if the ship complies with the condition 2.      
     * @param numberOfLoads Is the number of loads that will be transported.
     * @param stop Allows to stop adding loads
     * @param netWeight Is the sum of the weight of all the loads that will be transported by the ship.
     * @param add Means if the user wants to add another load to the ship.
     * @param typeLoad Is the type of the load. This can be DANGEROUS, PERISHABLE or NO PERISHABLE.
     * @param owner Is the owner of the load.
     * @param weightBox Is the weight of each box.
     * @param numberOfBoxes Is the number of boxes that the load contains.
     * @param weightLoad Is the net weight of the load.     
     * @param nameClient Is the name of the client     
     */
    
    public static void loadTheShip(String ship1, String ship2, int numberOfLoads, int stop, double netWeight, int add, int[]typeLoad, int[]owner, int[]weightBox, int[]numberOfBoxes, double[]weightLoad, String[]nameClient){

     for(int i=0;stop!=1;i++){
         numberOfLoads=(i+1);
            do{
                do{
                    System.out.println("Load "+(i+1)+":"); 
                    System.out.println("Enter the number of boxes to transport:");
                    numberOfBoxes[i]=sc.nextInt();
                    System.out.println("Enter the weight in grams:");
                    weightBox[i]=sc.nextInt();
                    weightLoad[i]=(numberOfBoxes[i]*weightBox[i])/1000;//In kilos
                    netWeight=netWeight+weightLoad[i];

                    if(netWeight>28000)
                        System.out.println("THE LOAD EXCEEDS THE WEIGHT LIMITS OF THE SHIP. YOU MUST REGISTER ANOTHER LOAD:"); 
  
                }while(netWeight>28000);
                
                do{
                    System.out.println("Select the load's owner:");
                    System.out.println("1. "+nameClient[0]);
                    System.out.println("2. "+nameClient[1]);
                    System.out.println("3. "+nameClient[2]);
                    System.out.println("4. "+nameClient[3]);
                    System.out.println("5. "+nameClient[4]);
                    owner[i]=sc.nextInt();
                }while(owner[i]<1||owner[i]>5);
                
                do{
                    System.out.println("Enter the type of load");
                    System.out.println("1. DANGEROUS"); 
                    System.out.println("2. PERISHABLE");
                    System.out.println("3. NO PERISHABLE"); 
                    typeLoad[i]=sc.nextInt();
                }while(typeLoad[i]<1||typeLoad[i]>3);    
                
                do{
                System.out.println("Do you want to add one more load?");                
                System.out.println("1. Yes");
                System.out.println("2. No");               
                    add = sc.nextInt();
                }while(add<1||add>2);

                if (add==2){
                    showIfTheshipCanSail(ship1, ship2, stop, numberOfLoads, netWeight, typeLoad); 
                    //The ship can sail if it complies with condition 1 and 2    
                    if(ship1.equals("Yes")&&ship2.equals("Yes")){
                        System.out.println("The ship can get sail");
                            stop=1;
                    }    
                    else if (ship1.equals("No")||ship2.equals("No")){
                        System.out.println("THE LOAD WON'T BE REGISTERED. TRY WITH ANOTHER LOAD");
                            stop=0;
                    }    
                }
                
            }while(stop==0);    
        }                  
        System.out.println("The ship has been successfully loaded");
    }//loadTheShip ends
    
    /**
     * Name of the method: showIfTheshipCanSail
     * <br>
     * This method determinate if the ship can get sail considering if the ship complies with the necessary conditions to sail 
     * Condition 1: The ship has the minimum weight or number of loads to set sail
     * Condition 2: The ship complies with the sanitation rules <br>
     * @param ship1 Means if the ship complies with the condition 1 to sail.
     * @param ship2 Means if the ship complies with the condition 2 to sail.      
     * @param stop Allows to stop adding loads.      
     * @param numberOfLoads Is the number of loads that will be transported.     
     * @param netWeight Is the sum of the weight of all the loads that will be transported by the ship.      
     * @param typeLoad Is the type of the load. This can be DANGEROUS, PERISHABLE or NO PERISHABLE.      
     */
   
    public static void showIfTheshipCanSail (String ship1, String ship2, int stop, int numberOfLoads, double netWeight, int[]typeLoad){
              
        if (netWeight>12000)
            ship1="Yes";
        else if(netWeight<12000){
            if(numberOfLoads<1){
                System.out.println("THE SHIP CANNOT GET SAIL WITH LESS THAN 12.000 KG OR TWO LOADS");                
            }
            else if(numberOfLoads>=1)
                ship1="Yes";
        }
       
        for (int j=0;j<5;j++){                
            for(int k=1;k<5;k++){   
                if (typeLoad[j]==1){
                    if(typeLoad[k]==2){
                        ship2=("No");                                                       
                    }                                                  
                }                        
            }
        }            
        if(ship2.equals("No"))
            System.out.println("THE SHIP CANNOT GET SAIL WITH A DANGEROUS LOAD AND A PERISHABLE LOAD");                 
                             
    }//showIfTheshipCanSail ends
    
    /**
     * Name of the method: determinateDiscount
     * This method calculates the value of the discount that will be applied to each load
     * @param numberOfLoads Is the number of loads that will be transported.   
     * @param typeLoad Is the type of the load. This can be DANGEROUS, PERISHABLE or NO PERISHABLE.
     * @param owner Is the owner of the load.
     * @param discount Is the value of the discount that will be applied to each load
     * @param category Is the category of the client. This can be NORMAL, SILVER, GOLD or PLATINUM.
     */
    
    public static void determinateDiscount(int numberOfLoads, int[]typeLoad, int[]owner, double[]discount, int[]category){
        
        for(int i=0;i<numberOfLoads;i++){
            if (category[owner[i]]==1){
                discount[i]=0;
            }
            else if(category[owner[i]]==2){
                if (typeLoad[i]==2)
                    discount[i]=0.015;                        
                else discount[i]=0;
            }
            else if(category[owner[i]]==3){
                if (typeLoad[i]==2||typeLoad[i]==3)
                    discount[i]=0.03;
                else discount[i]=0;
            }
            else if(category[owner[i]]==4)
                discount[i]=0.05;            
        }
    }//determinateDiscount ends
    
    /**
     * Name of the method: showTotalValue 
     * This method shows the total value that the client will pay to transport the load
     * @param owner Is the owner of the load.
     * @param nameClient Is the name of the client.     
     * @param totalValue Is the total value that the client will pay for the load.
     * @param numberOfLoads Is the number of loads that will be transported.   
     * @param weightLoad Is the net weight of the load. 
     * @param discount Is the value of the discount that will be applied to each load.
     * @param typeLoad Is the type of the load. This can be DANGEROUS, PERISHABLE or NO PERISHABLE.
     */
    public static void showTotalValue(int[]owner, String[]nameClient,double[]totalValue, int numberOfLoads, double[]weightLoad, double[]discount, int[]typeLoad){
        
            for(int i=0;i<numberOfLoads;i++){
                if (typeLoad[i]==1)
                    totalValue[i]=(weightLoad[i]*390000)-((weightLoad[i]*390000*discount[i]));
                else if(typeLoad[i]==2)
                    totalValue[i]=(weightLoad[i]*250000)-((weightLoad[i]*250000*discount[i]));
                else if(typeLoad[i]==3)
                    totalValue[i]=(weightLoad[i]*80000)-((weightLoad[i]*80000*discount[i]));
            System.out.println(nameClient[owner[i]]+" has to pay $"+totalValue[i]+" for the load "+(i+1));                        
        }        
    }//showTotalValue ends
    
    /**
     * Name of the method:unloadTheShip 
     * <br>
     * This method allows the user to unload the ship
     * All the variables will return to their initial value <br>
     * @param discount Is the value of the discount that will be applied to each load.
     * @param totalValue Is the total value that the client will pay for the load.
     * @param ship1 Means if the ship complies with the condition 1 to sail.
     * @param ship2 Means if the ship complies with the condition 2 to sail.
     * @param numberOfLoads Is the number of loads that will be transported.
     * @param stop Allows to stop adding loads.      
     * @param netWeight Is the sum of the weight of all the loads that will be transported by the ship.
     * @param typeLoad Is the type of the load. This can be DANGEROUS, PERISHABLE or NO PERISHABLE.
     * @param owner Is the owner of the load.
     * @param weightBox Is the weight of each box.
     * @param numberOfBoxes Is the number of boxes that the load contains.
     * @param weightLoad Is the net weight of the load. 
     */
   
    public static void unloadTheShip(double[]discount, double[]totalValue, String ship1, String ship2, int numberOfLoads, int stop, double netWeight, int[]typeLoad, int[]owner, int[]weightBox, int[]numberOfBoxes, double[]weightLoad){
            
        for(int i=0;i<numberOfLoads;i++){    
            numberOfBoxes[i]=0;
            weightBox[i]=0;
            weightLoad[i]=0;
            typeLoad[i]=0;
            owner[i]=0;

            discount[i]=0.0;
            totalValue[i]=0.0;


            stop=0;  
            numberOfLoads=0;

            netWeight=0;
            ship1=("No");
            ship2=("Yes");
        }
        System.out.println("The ship has been succesfully unloaded");
    }//unloadTheShip ends
    
    /**
     * Name of the method: saveAccumulated
     * <br>
     * This method saves the accumulated of kilos tranported and money paid by the client <br>  
     * @param numberOfLoads Is the number of loads that will be transported.
     * @param kilosTransported Is the sum of the weight of all the loads that the client has transported.
     * @param totalValuePaid Is the total value that the client has paid in previous loads
     * @param weightLoad Is the net weight of the load. 
     * @param totalValue Is the total value that the client will pay for the load.
     * @param owner Is the owner of the load.
     */
  
    public static void saveAccumulated(int numberOfLoads, double[]kilosTransported, double[]totalValuePaid, double[]weightLoad, double[]totalValue, int[]owner){
        
        for(int i=0;i<numberOfLoads;i++){    
           kilosTransported[owner[i]]=(kilosTransported[owner[i]]+weightLoad[i]);
           totalValuePaid[owner[i]]=(totalValuePaid[owner[i]]+totalValue[i]);
        }           
    }//saveAccumulated ends.
    
    /**
     * Name of the method: updateCategories
     * <br>
     * This method allows the user to update the categories of the client <br>
     * @param categoryName Is the name of the categories. This can be "NORMAL", "SILVER", "GOLD" or "PLATINUM".
     * @param category Is the category of the client. 
     * @param nameClient Is the name of the client.
     * @param kilosTransported Is the sum of the weight of all the loads that the client has transported.
     * @param totalValuePaid Is the total value that the client has paid in previous loads
     */
  
    public static void updateCategories(String[]categoryName,int[]category, String[]nameClient, double[]kilosTransported, double[]totalValuePaid){
        
        System.out.println("The categories have been succesfully updated");
        for (int i=0;i<5;i++){
            if(totalValuePaid[i]==0.0&&kilosTransported[i]==0)
                category[i]=1;
            else if(kilosTransported[i]>=35000&&kilosTransported[i]<55000)
                category[i]=2;
            else if(kilosTransported[i]>=55000||(totalValuePaid[i]>=2000000000.0&&totalValuePaid[i]<5000000000.0))
                category[i]=3;
            else if(totalValuePaid[i]>=5000000000.0)
                category[i]=4;
                        
            if(category[i]==1){
                System.out.println("The category of "+nameClient[i]+" is: "+categoryName[0]);
            }
            else if(category[i]==2)
                System.out.println("The category of "+nameClient[i]+" is: "+categoryName[1]);
            else if(category[i]==3)
                System.out.println("The category of "+nameClient[i]+" is: "+categoryName[2]);
            else if(category[i]==4)
                System.out.println("The category of "+nameClient[i]+" is: "+categoryName[3]);
        }
    }//updateCategories ends
    
    /**
     * Name of the method: showData
     * <br>
     * This method shows the client's data <br>
     * @param categoryName Is the name of the categories. This can be "NORMAL", "SILVER", "GOLD" or "PLATINUM".
     * @param totalValuePaid Is the total value that the client has paid in previous loads
     * @param kilosTransported Is the sum of the weight of all the loads that the client has transported.
     * @param category Is the category of the client. 
     * @param nameClient Is the name of the client.
     * @param registerNumber Is the commercial register number of the client
     * @param expeditionDate Is the expedition date of the client's commercial register
     */
    
    public static void showData(String[]categoryName,double[]totalValuePaid, double[]kilosTransported, int[]category, String[]nameClient, String[]registerNumber, String[]expeditionDate){
        for(int i=0;i<5;i++){
            System.out.println("\nCLIENT "+(i+1)+":\n");
            System.out.println("NAME: "+nameClient[i]);
            System.out.println("CATEGORY: "+categoryName[category[i]-1]);
            System.out.println("COMERCIAL REGISTER NUMBER: "+registerNumber[i]);
            System.out.println("EXPEDITION DATE: "+expeditionDate[i]);
            System.out.println("TOTAL OF KILOS TRANSPORTED: "+kilosTransported[i]);
            System.out.println("TOTAL VALUE PAID: "+totalValuePaid[i]);            
        }
    }//showData ends
}//Class ends
