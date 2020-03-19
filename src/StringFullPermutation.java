import java.util.ArrayList;
import java.util.List;

public class StringFullPermutation {
    boolean[] flags; //表示下标为i的元素是否被访问
    List<String> res;
    public List<String> permutation(String string){
        int length = string.length();
        flags = new boolean[length];
        for(int i=0;i<length;i++){
            flags[i] = false;
        }
        res = new ArrayList<String>();

        findNextChar(string,"");
        return res;
    }

    /**
     * 寻找当前字符串的下一个字母
     * @param string
     * @param now
     */
    private void findNextChar(String string, String now) {
        int length = string.length();
        if(now.length() == length){ //如果长度够了，说明这是一个全排列
            res.add(now);
            return;
        }

        int[] isRepeat = new int[26];   //看在这一层是否已经有相同的字母被使用过了，有就不用再使用了(0为未被使用)
        for(int i=0;i<length;i++){
            if(!flags[i] && isRepeat[string.charAt(i)-'a']==0){  //假如第i个字母未被使用
                String newString = now+string.substring(i,i+1);
//                System.out.println("now: "+now);
                flags[i] = true;
                isRepeat[string.charAt(i)-'a'] = 1;
                findNextChar(string,newString);
                flags[i] = false;
                //isReapt只是当前这一层，所以不用回溯
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        StringFullPermutation s = new StringFullPermutation();
        List<String> res= s.permutation("aabc");
        for(String ss:res){
            System.out.println(ss);
        }
    }
}
