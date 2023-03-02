package resrurant.rank.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ResrurantRankSystem {

 String[] IslamabadRestorent;
    String[] RawalpindiRestorent;
    
    Scanner write;
    Scanner Inp;
    String Latter;
    int NoShortlist=0;
    int rank;
    void getShortlistedRestaurants() throws IOException{
    
        Inp= new Scanner(System.in);
        
        System.out.println("Number of shortlisted resturents, N: ");
        NoShortlist=Inp.nextInt();
        System.out.println("Please enter the TH ranks.");
        
        File d1myObj = new File("shortlistedRestaurants.txt"); 
        d1myObj.delete();
        File myObj1 = new File("shortlistedRestaurants.txt");
        myObj1.createNewFile();
        
        FileWriter fi_rank = new FileWriter("shortlistedRestaurants.txt",true);
        for(int i=0;i<NoShortlist;i++){
                
            System.out.println("Enter Latter: ");
                boolean flag=false;
                while(flag==false){
          Latter=Inp.next();
                if(Latter.equals("I") || Latter.equals("R") ){
                flag=true;
                }else{
          System.out.println("Try Aagain! Enter I OR R Latter only. ");
                    flag=false;
                }
                }
                
                System.out.println("Enter rank: ");
                flag=false;
                while(flag==false){
          rank=Inp.nextInt();
                if(rank>0 && rank<=20 ){
                flag=true;
                }else{
                    System.out.println("Try Aagain! number between 1 to 20. ");
                    flag=false;
                }
                }
                
                
                if(i==0){
            fi_rank.write("\r"+Latter+" "+rank);
                }else{
            fi_rank.write("\r\n"+Latter+" "+rank);
                }
        }
        fi_rank.close();
    }
    
    void getIsbRestaurants(){
    File fl = new File("shortlistedRestaurants.txt");
    int total_restorent=0;
    String line="";
    int i=0;
    try{
    
        Scanner sc1 = new Scanner(fl);
        
        while (sc1.hasNextLine()) {
        line = sc1.nextLine();
       String[] cell=line.split(" ", 3);        
        
        if( cell[0].equals("I") ){
 total_restorent ++;              
        }
        }
        
        sc1.close();
        
        Scanner sc2 = new Scanner(fl);
        IslamabadRestorent=new String[total_restorent] ;
        while (sc2.hasNextLine()) {
        line = sc2.nextLine();
       String[] cell2=line.split(" ", 3);        
        
        if( cell2[0].equals("I") ){
 IslamabadRestorent[i]=cell2[1];
 i++;
        }
        }
                sc1.close();
    }catch(Exception ex){
    
    }
    }
    
    void getRwpRestaurants(){
    File fl = new File("shortlistedRestaurants.txt");
    int total_restorent=0;
    String line="";
    int i=0;
    try{
    
        Scanner sc1 = new Scanner(fl);
        
        while (sc1.hasNextLine()) {
        line = sc1.nextLine();
       String[] cell=line.split(" ", 3);        
        
        if( cell[0].equals("I") ){
 total_restorent ++;              
        }
        }
        
        sc1.close();
        
        Scanner sc2 = new Scanner(fl);
        RawalpindiRestorent=new String[total_restorent] ;
        while (sc2.hasNextLine()) {
        line = sc2.nextLine();
       String[] cell2=line.split(" ", 3);        
        
        if( cell2[0].equals("R") ){
 RawalpindiRestorent[i]=cell2[1];
 i++;
        }
        }
                sc1.close();
    }catch(Exception ex){
    
    }
    }
    
    void desSort() throws IOException{
    Arrays.sort(IslamabadRestorent,Collections.reverseOrder());
    Arrays.sort(RawalpindiRestorent,Collections.reverseOrder());
    
        File d1myObj = new File("finalist.txt"); 
        d1myObj.delete();
        File myObj1 = new File("finalist.txt");
        myObj1.createNewFile();
        
        FileWriter fi_rank = new FileWriter("finalist.txt",true);
        for(int i=0;i<IslamabadRestorent.length;i++){
                            if(i==0){
            fi_rank.write("\r"+IslamabadRestorent[i]);
                }else{
            fi_rank.write("\r\n"+IslamabadRestorent[i]);
                }
        }
        
        for(int i=0;i<RawalpindiRestorent.length;i++){
            fi_rank.write("\r\n"+RawalpindiRestorent[i]);
        }
        fi_rank.close();
        
    }
    
    void getFinalList(){
    try {
      File myObj1 = new File("finalist.txt");
      Scanner myReader1 = new Scanner(myObj1);
      while (myReader1.hasNextLine()) {
        String data = myReader1.nextLine();
        System.out.print(data+" ");
      }
      myReader1.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
    public static void main(String[] args) throws IOException {
   ResrurantRankSystem rrs=new ResrurantRankSystem();
        rrs.getShortlistedRestaurants();
        rrs.getIsbRestaurants();
        rrs.getRwpRestaurants();
        rrs.desSort();
        rrs.getFinalList();
    }    
}
