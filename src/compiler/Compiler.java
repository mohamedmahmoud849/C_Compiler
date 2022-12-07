package compiler;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.Scanner;

public class Compiler 
{
   public static void main(String[] args) throws IOException 
   {
     scanner sc =new scanner();
     System.out.print(Character.isLetterOrDigit(' '));
     sc.get_token("test.txt");
   }
}