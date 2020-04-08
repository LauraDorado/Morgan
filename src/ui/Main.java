package laboratorio3;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[]args){
        
        Laboratorio3 lab3=new Laboratorio3();

        int back=0;
        int option;

        do{
            do{
                lab3.menu();
                option=sc.nextInt();
                if(option<1||option>5)
                    System.out.println("ENTER A VALID OPTION");
            }while(option<1||option>5);
            
                switch (option){
                    case 1:
                        lab3.registerClient(lab3.totalValuePaid, lab3.kilosTransported, lab3.category, lab3.nameClient, lab3.registerNumber, lab3.expeditionDate);
                    break;    

                    case 2:
                        lab3.loadTheShip(lab3.ship1, lab3.ship2, lab3.numberOfLoads, lab3.stop, lab3.netWeight, lab3.add, lab3.typeLoad, lab3.owner, lab3.weightBox, lab3.numberOfBoxes, lab3.weightLoad, lab3.nameClient);                       
                        lab3.determinateDiscount(lab3.numberOfLoads, lab3.typeLoad, lab3.owner, lab3.discount, lab3.category);
                        System.out.println("Total values to pay: ");
                        lab3.showTotalValue(lab3.owner, lab3.nameClient,lab3.totalValue, lab3.numberOfLoads, lab3.weightLoad, lab3.discount, lab3.typeLoad);
                        lab3.saveAccumulated(lab3.numberOfLoads, lab3.kilosTransported, lab3.totalValuePaid, lab3.weightLoad, lab3.totalValue, lab3.owner);
                    break;  
                    
                    case 3:
                        lab3.unloadTheShip(lab3.discount, lab3.totalValue, lab3.ship1, lab3.ship2, lab3.numberOfLoads, lab3.stop, lab3.netWeight, lab3.typeLoad, lab3.owner, lab3.weightBox, lab3.numberOfBoxes, lab3.weightLoad);
                    break;
                        
                    case 4:
                        lab3.updateCategories(lab3.categoryName, lab3.category, lab3.nameClient, lab3.kilosTransported, lab3.totalValuePaid);
                    break;  
                    
                    case 5:
                        lab3.showData(lab3.categoryName, lab3.totalValuePaid, lab3.kilosTransported, lab3.category, lab3.nameClient, lab3.registerNumber, lab3.expeditionDate);
                }
            do{
            System.out.println("Do you want to go back to menu?");
            System.out.println("1.Yes");
            System.out.println("2. No");
            back=sc.nextInt();
            }while(back>2||back<1);
        }while (back!=2);
    }
}
