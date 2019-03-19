public class ms {
    public static int minnum(int num, int projCmptDec, int restDec, int[] errorScore){
        int sum = 0;
        for(int i=0;i<num;i++){
            sum += errorScore[i];
        }
        if (sum==0){
            return 0;
        }
        int iter = 1;
        while(true){

            boolean flag = true;
            int po = iter%num;
            if (errorScore[po] - 4 <= 0)
            {   errorScore[po] = 0;}
            else {
                errorScore[po] -= 4;
                flag = false;
            }

            for(int i=(iter+1)%num;i<iter%num+num;i++){
                if (i >= num)
                {po = i-num;}
                else
                {po =i;}
                if (errorScore[po] - 1 <= 0)
                {errorScore[po] = 0;}
                else
                {errorScore[po] -= 1;
                flag = false;}

            }

            if (flag)
            {break;}
            else
            {iter +=1;}
        }

        return iter;

    };

    public static void main(String[] args) {
        int res = minnum(4, 3, 1, new int[]{9,8,2,5});
        System.out.println(res);

    }
}
