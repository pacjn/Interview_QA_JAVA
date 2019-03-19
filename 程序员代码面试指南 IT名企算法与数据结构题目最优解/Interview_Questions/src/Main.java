import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputParser parser = new InputParser(System.in);
        parser.parse();
        parser.output();
    }
}

class InputParser {

    private Scanner scanner;
    private int num;
    private String[] nums;
    private int que_num;
    private String[] query;

    public InputParser(InputStream in) {
        scanner = new Scanner(in);
    }

    public void parse() {
        num = Integer.parseInt(scanner.nextLine().trim());
        nums = scanner.nextLine().trim().split(" ");
        que_num = Integer.parseInt(scanner.nextLine().trim());
        query = scanner.nextLine().trim().split(" ");
    }
    public void output() {
        int [] sum = new int[num+1];
        sum[0] = 0;
        int count = 0;
        for(int i = 0; i<num; i++){
            count += Integer.parseInt(nums[i]);
            sum[i+1] = count;
        }
        for(int i =0;i<que_num;i++){
            for (int j=0; j<num;j++){
                int quer= Integer.parseInt(query[i]);
                if (quer>sum[j] && quer<=sum[j+1]){
                    System.out.println(j+1);
                }
            }
        }
    }
}
