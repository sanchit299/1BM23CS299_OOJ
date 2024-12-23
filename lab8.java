class threads extends Thread{
    String s; int time;
    threads(String s, int time){
        this.s = s;
        this.time = time;
    }
    public void run(){
        try{
            while(true){
                System.out.println(s);
                Thread.sleep(time * 1000);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
public class lab8{
    public static void main(String[] args) {
        threads t1 = new threads("BMS College of Engineering", 10);
        threads t2 = new threads("CSE", 2);

        t1.start();
        t2.start();
    }
}
