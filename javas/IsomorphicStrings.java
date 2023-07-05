package javas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class IsomorphicStrings {
    public static void main(String[] args) {

       isIsomorphic1("egg", "add");
       isIsomorphic1("foo", "bar");
       isIsomorphic1("KITE", "ZXBN");
       isIsomorphic1("aab", "xxy");
       isIsomorphic1("aab", "xyz");

    }

    public static boolean isIsomorphic1(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        boolean isomorphic = true;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);

            if(map.containsKey(key)){
                char cout = map.get(key);
                if(cout != val){
                    isomorphic = false;
                    break;
                }
            } else {
                map.put(key, val);
            }
        }
        System.out.println(s+","+t+" isomorphic : "+isomorphic);
        return isomorphic;
    }
}
