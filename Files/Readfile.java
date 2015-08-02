import java.io.*;

public class Readfile {
  public static void main(String[] args)  {
    try {
        BufferedReader in = new BufferedReader (new FileReader("/etc/passwd"));
        String str;
        while ((str = in.readLine()) != null) {
          System.out.println(str);
        }
      }
    catch (IOException e) {
    }
  }
}
