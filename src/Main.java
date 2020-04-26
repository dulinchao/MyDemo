import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dates = sc.nextLine().split(" ");
        int month = Integer.parseInt(dates[0]);
        int day = Integer.parseInt(dates[1]);
        String information = sc.nextLine();
        HashMap<Character,Integer> dictionary = getDictionary(month,day);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < information.length(); i++) {
            int num = dictionary.get(information.charAt(i));
            sb.append(num + " ");
        }
        System.out.println(sb.toString());
    }


    private static HashMap<Character,Integer> getDictionary(int month,int day){
        //调转总分组
        String[] strings = null;
        month = (month - 1) % 3;
        if (month == 1) {
            strings = new String[]{"JKLMNOPQR", "STUVWXYZ*", "ABCDEFGHI"};
        } else if (month == 2) {
            strings = new String[]{"STUVWXYZ*", "ABCDEFGHI", "JKLMNOPQR"};
        } else {
            strings = new String[]{"ABCDEFGHI", "JKLMNOPQR", "STUVWXYZ*"};
        }
        //调转分组内部
        day = (day - 1) % 9;
        String s = null;
        for(int i=0;i<3;i++) {
            s = strings[i];
            String tmp = s.substring(0, day);
            String tmp2 = s.substring(day);
            strings[i] = tmp2 + tmp;
        }
        //生成HashMap
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < 4; i++) {
            String str = strings[i - 1];
            char[] chars = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '*') {
                    map.put(' ', (i * 10 + j + 1));
                    continue;
                }
                map.put(chars[j], (i * 10 + j + 1));
            }
        }
        return map;
    }
}
