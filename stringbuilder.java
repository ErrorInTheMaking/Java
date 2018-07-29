/* Concaternate Strings using 2 methods.(Quora digest)
   1.Using StringBuilder is more efficient as there is no overhead (+).
   2.For-loop, is a novice move but gets the job done.
   
   StringBuilder is part of java.lang library, no need to import anything.

   Date 21/07/2018
*/
public class stringbuilder{
    public String finalString1(String arr[]){
        StringBuilder sb = new StringBuilder();

        for(String temp : arr)
            sb.append(temp);
        
        return sb.toString();
    }
    public String finalString2(String arr[]){
        String res = "";

        for(int i = 0; i  < arr.length; ++i)
            res += arr[i];
        return res;    
    }
    public static void main(String[] args) {
        stringbuilder sb = new stringbuilder();

        String str[] = {"John", "Mark", "Apple","Orange", "Lettuce", "Banana", "Olive"};
        String concatString1  = sb.finalString1(str);
        String concatString2 = sb.finalString2(str);
        System.out.println(concatString1);
        System.out.println(concatString2);
    }
}