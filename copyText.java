import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyText {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("Demo.txt");
        File f2 = new File("CopiedDemo.txt");

        FileInputStream in = new FileInputStream(f1);
        FileOutputStream out = new FileOutputStream(f2);

        DataInputStream din = new DataInputStream(in);
        DataOutputStream dout = new DataOutputStream(out);

        try {
            String str = din.readUTF();
            dout.writeUTF(str);
            System.out.println("Copied!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                din.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                dout.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}