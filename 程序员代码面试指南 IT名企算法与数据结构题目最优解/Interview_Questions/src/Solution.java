import java.util.*;

public class Solution {
    public static String FirstNotRepeatedChar(String str) {
        LinkedHashMap <Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }

        for(Character key: map.keySet())
        {
            if(map.get(key)==1){
                return key.toString();
            }
        }
        return "";
    }
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                out();
            }
        };
        t.run();;
        int i;
        String str="asda";
        str=str+100;
    }
    static void out(){
        System.out.println('x');
    }
}