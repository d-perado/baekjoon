
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1 ; i<=n;i++){
            list.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i=0;i<m;i++){
            int a = Integer.parseInt(st.nextToken());
            int idx = list.indexOf(a);

            if(idx <= list.size() / 2){
                for(int j = 0; j < idx; j++){
                    list.add(list.removeFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < list.size() - idx;j++){
                    list.addFirst(list.removeLast());
                    count++;
                }
            }
            list.removeFirst();
        }

        System.out.println(count);


    }

}