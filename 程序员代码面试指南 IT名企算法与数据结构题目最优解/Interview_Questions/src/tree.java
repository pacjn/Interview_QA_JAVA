import java.io.*;
public class tree {
    public static void write(String filePath, String str) {
        FileWriter w = null;
        try {
            w = new FileWriter(filePath);
            w.write(str);
            w.flush();
        } catch (IOException e) {
            System.out.println("aaa");
        }
    }

    public static void main(String[] args) {
        tree.write("aaa","aaa");
    }
}

class aNode{
    public int value;
    public aNode left;
    public aNode right;

    public aNode(int data){
        this.value=data;
    }
}

