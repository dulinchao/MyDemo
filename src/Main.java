
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] directs = {{-1,0},{1,0},{0,1},{0,-1}};
    static int rows = 3;
    static int cols = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.length()==0){
            System.out.println("false");
            return;
        }
        char[][] abc = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        visited = new boolean[3][4];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(abc[i][j]==str.charAt(0)){
                    visited[i][j] = true;
                    boolean res = isExist(abc, str, 1, i, j);
                    visited[i][j] = false;
                    if(res){
                        System.out.println("true");
                        return;
                    }
                }
            }
        }
        System.out.println("false");

    }

    private static boolean isExist(char[][] abc, String str,int index,int row,int col) {
        if(index == str.length()){
            return true;
        }
        for (int[] direct : directs) {
            int nr = row + direct[0];
            int nc = col + direct[1];
            if(inArea(nr, nc) && !visited[nr][nc] && abc[nr][nc]==str.charAt(index)){
                visited[nr][nc] = true;
                boolean res = isExist(abc,str,index+1,nr,nc);
                visited[nr][nc] = false;
                if(res) return true;
            }
        }
        return false;
    }

    private static boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}