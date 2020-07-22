import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Demo.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("This is demo file");
        dos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("Demo.txt");
        DataInputStream dis = new DataInputStream(fis);
        String str = dis.readUTF();
        System.out.println(str);
        dis.close();
        fis.close();
    }    
}