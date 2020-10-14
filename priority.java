package lab11;
public class priority {
    public static void main(String[] args) {
        one obj1=new one();
        two obj2=new two();
        obj2.setPriority(10);
        obj1.setPriority(1);
                
        
        
        obj1.start();
        obj2.start();
        
    }
    
}
class one extends Thread{
    public void run(){
        for(int i=0;i<5;i++)
        System.out.println("#####first thread######");
        try{
             Thread.sleep(1000);
         }//half min
         catch(InterruptedException e){
             System.out.println(e);
         }
        
    }
}
class two extends Thread{
    public void run(){
        for(int i=0;i<5;i++)
        System.out.println("#####second thread#####");
        try{
             Thread.sleep(1000);
         }//half min
         catch(InterruptedException e){
             System.out.println(e);
         }
    }
    
}
