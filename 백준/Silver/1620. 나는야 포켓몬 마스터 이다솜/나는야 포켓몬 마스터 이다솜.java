import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
    
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,String> numToStr = new HashMap<>();
        Map<String,Integer> strToNum = new HashMap<>();

        for(int i = 0;i < N; i++) {
            String input = br.readLine();
            numToStr.put(i+1,input);
            strToNum.put(input,i+1);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))){
                sb.append(numToStr.get(Integer.parseInt(input))+"\n");
            } else {
                sb.append(strToNum.get(input)+"\n");
            }

        }

        System.out.print(sb.toString().trim());
    }
}