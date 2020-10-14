package lab11;
class flipkart
{
    int n;
    boolean value=false;
    synchronized void paid()
    {
        while(!value)
        try
        {
            wait();
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        
        System.out.println("paid");
        value=false;
        notify();
        
    }
    synchronized void selection(int n)
    {
        while(value)
            try{
                wait();
            }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
        this.n=n;
        value=true;
        System.out.println("customer: "+(n+1));
        System.out.println("product selected");
        notify();
        
    }
}
class product implements Runnable
{
    flipkart p;
    product(flipkart p)
    {
        this.p =p;
    }
    public void run()
    {
        int i=0;int k=0;
        while(k<3)//let number of customers be three
        {
            p.selection(i++);
            k++;
        }
    }
}
class payment implements Runnable
{
    flipkart p;
    payment(flipkart p)
    {
        this.p =p;
        
    }
    public void run()
    {
        int i=0;
        while(i<3)
        {
            p.paid();
            i++;
        }
    }
}
public class shopping {
    public static void main(String[] args) {
        flipkart p=new flipkart();
        
        payment obj=new payment(p);//thread one
        Thread t1=new Thread(obj);
        t1.start();
        
        product obj1=new product(p);//thread two
        Thread t2=new Thread(obj1);
        t2.start();
        
        
    }
    
}
