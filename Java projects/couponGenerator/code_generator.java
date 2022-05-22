package couponGenerator;
import java.util.HashMap;

public class code_generator {
    public static HashMap<String,user> customer;

    code_generator(){
        customer = new HashMap<>();
    }
    public boolean codeGenerator(String phNum,String name){
        user newUser = new user(phNum,name);
        int n = phNum.length();
        boolean flag = false;
        if(n!=10){
            System.out.println("Invalid Mobile number. Enter valid mobile number");
                   return flag;
        }
        // else if(n==10){
        //     for(char ch:phNum.toCharArray()){
        //     //    char ch = phNum.charAt(i);
        //        if((ch-'0')>='0' && (ch-'0')<='9') continue;
        //        else{
        //            System.out.println("Invalid Mobile number. Enter valid mobile number");
        //            return flag;
        //        }
        //     }
        // }
       
        if(customer.containsKey(phNum)){
            System.out.println();
            System.out.println(name +":("+ "sorry you have already claimed the coupon :(");
            System.out.println();
            return flag;
        }
        else
        {
            customer.put(phNum,newUser);
        }
       return true;
    }
    public String getCoupon()
    {
         String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789";
  
        StringBuilder sb = new StringBuilder(6);
  
        for (int i = 0; i < 6; i++) 
        {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
  
        return sb.toString();
    }
    public int getCouponWorth(String coup,int n)
    {
        int discount=0;
        int len=coup.length();
        for(int i=0;i<len;i++)
        {
            discount+=(int)coup.charAt(i);
        }
        
        if(n == 1)
        {
            discount*=5;
        }
        else if(n == 4)
        {
            discount*=15;
        }
        return discount*7;
    }
}
