import java.io.*;
import java.util.*;
class StItem {
    char ch;
    int nextIdx;
    public StItem(char ch, int nextIdx){
        this.ch = ch;
        this.nextIdx = nextIdx;
    }
}
public class Main {
    private static String origin;
    private static String boom;
    private static ArrayList<Character> st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        boom = br.readLine();
        st = new ArrayList<>();
        for(int i=0;i<origin.length();i++){
            st.add(origin.charAt(i));
            if(st.size() >= boom.length() && st.get(st.size() - 1) == boom.charAt(boom.length() - 1)) {
                boolean isRemovable = true;
                for(int j=0;j<boom.length();j++) {
                    if(st.get(st.size() - 1 - j) != boom.charAt(boom.length() - 1 - j)) {
                        isRemovable = false;
                        break;
                    }
                }
                if(isRemovable) {
                    for(int j=0;j<boom.length();j++) {
                        st.remove(st.size() - 1);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character character : st) {
            result.append(character);
        }
        if(result.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }
}