package writingtest;

    public class SendValue{
        public String str="6";
        public static void main(String[] args) {
            SendValue sv=new SendValue();
            sv.change(sv.str);
            System.out.println(sv.str);
        }
        public void change(String str) {
            str="10";
        }
    }
