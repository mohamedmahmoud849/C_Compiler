/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isLetterOrDigit;
import java.util.Scanner;

/**
 *
 * @author DELL
 * 
 * 
 */
  enum Token { 
PROGRAM_SY, IS_SY, BEGIN_SY, END_SY, VAR_SY, INTEGER_SY, BOOLEAN_SY, READ_SY, 
WRITE_SY, IF_SY, THEN_SY, ELSE_SY, WHILE_SY, DO_SY, OR_SY, AND_SY, TRUE_SY,
FALSE_SY, NOT_SY, LPARN_SY, RPARN_SY, COMMA_SY, MINUS_SY, LOE_SY, 
LESS_SY, EQUALS_SY, GREATER_SY, GOE_SY, DNE_SY, PLUS_SY, 
MULT_SY, DIVI_SY, COLON_SY, SEMICOL_SY,
END_SOURCE_SY, NUMBER_SY, 
ID_SY, ASSIGNMENT_SY,
ERROR_SY
};



public class scanner {
    
    
     void   get_token(String filepath) throws IOException{
         
         
         
         File f=new File(filepath); 
       BufferedReader br=new BufferedReader(new FileReader(f));
      int c;   
      int i=0;
      while( i<=f.length())         
      { 
          br.mark(0);
          c = br.read();
          char ch = (char) c;          
            
		String s="";
		if (ch == ' '){
                    ch= (char)br.read();
                }
                
		else if (ch == '=')System.out.println( ":= token") ;
		else if (ch == ',')System.out.println( ", token" );
		else if (ch == ';')System.out.println( "; token") ;
		else if (ch == '(')System.out.println( "(  token" ) ;
		else if (ch == ')')System.out.println( ")  token" );
		else if (ch == '+') System.out.println("+ token" );
		else if (ch == '-')System.out.println("- token");
		//else if (ch == '')System.out.println(" token" );
		else if (ch == '/')System.out.println("/ token" );

		
		
		else if (ch == '<'){
			ch= (char)br.read();
			if (ch == '=')System.out.println("<= token");
			
			else {
				br.reset();
				System.out.println("< token" );
			}
		}
		
		else if (ch == '>'){
			ch= (char)br.read();
			if (ch == '=')System.out.println( ">= token"); 
			else {
				br.reset();
				System.out.println( "> token");
			}
		}
	
		else if (isLetter(ch)){
			s=s+ch;
                        ch= (char)br.read();
			while (isLetterOrDigit(ch)) { 
				s += ch; 
				ch= (char)br.read(); 
			}
                        try{
			//br.reset();
                        }
                        catch(Exception e)
                        {
                            
                        }
			System.out.println(check_reserved(s));
		}
		
		else if (isDigit(ch)) {// real or integer
			s=s+ch;
                        ch= (char)br.read();
			while (isDigit(ch)){
				s += ch; 
				ch= (char)br.read();
			}
				br.reset();
				System.out.println("number token" );
		}
		
		else {System.out.println("ERROR_SY");} 
                i++;
      }
      System.out.println("end_of_file ") ;
      
         }
    
     Token check_reserved(String s){
			if      (s== "program") return Token.PROGRAM_SY;
			else if (s== "is")return Token.IS_SY;
			else if (s== "begin")return Token.BEGIN_SY;
			else if (s== "end")return Token.END_SY;
			else if (s== "var")return Token.VAR_SY;
			else if (s== "int")return Token.INTEGER_SY;
			else if (s== "boolean")return Token.BOOLEAN_SY;
			else if (s== "read")return Token.READ_SY;
			else if (s== "write")return Token.WRITE_SY;
			else if (s== "if")return Token.IF_SY;
			else if (s== "then")return Token.THEN_SY;
			else if (s== "else")return Token.ELSE_SY;
			else if (s== "while")return Token.WHILE_SY;
			else if (s== "do")return Token.DO_SY;
			else if (s== "or")return Token.OR_SY;
			else if (s== "and") return Token.AND_SY;
			else if (s== "true")return Token.TRUE_SY;
			else if (s== "false")return Token.FALSE_SY;
			else if (s== "not")return Token.NOT_SY;
			else return Token.ID_SY;
		}
    
     
    
    
    void display_tokens(String filepath) throws IOException{
		Token t;
                 File f=new File(filepath); 
       BufferedReader br=new BufferedReader(new FileReader(f));
		if (br.read()==-1)System.out.println( "end of file");;
		while (br.read()!= -1){
			t = get_token(filepath);
			switch (t){
				case PROGRAM_SY: System.out.println( "program token"); break;
				case IS_SY:  System.out.println("is token") ; break;
				case BEGIN_SY: System.out.println("begin token" ); break;
				case END_SY: System.out.println("end token"); break;
				case VAR_SY: System.out.println("var token"); break;
				case ID_SY: System.out.println("ident token"); break;
				case PLUS_SY: System.out.println("+ token" ); break;
				case MINUS_SY: System.out.println("- token"); break;
				case MULT_SY: System.out.println("* token" ); break;
				case DIVI_SY: System.out.println("/ token" ); break;
				case LOE_SY: System.out.println("<= token") ; break;
				case LESS_SY: System.out.println("< token" ); break;
				case EQUALS_SY: System.out.println( "= token") ; break;
				case GREATER_SY: System.out.println( "> token") ; break;
				case GOE_SY: System.out.println( ">= token"); break;
				case DNE_SY: System.out.println( "<> token" ); break;
				case NUMBER_SY:System.out.println("number token" ); break;
				case INTEGER_SY: System.out.println("integer token") ; break;
				case END_SOURCE_SY: System.out.println("end_of_file ") ; break;
				case LPARN_SY: System.out.println( "(  token" ) ; break;
				case RPARN_SY: System.out.println( ")  token" ) ; break;
				case BOOLEAN_SY: System.out.println( "boolean  token") ; break;
				case READ_SY: System.out.println( "read token") ; break;
				case WRITE_SY:System.out.println( "write token") ; break;
				case IF_SY: System.out.println( "if token" ); break;
				case THEN_SY: System.out.println( "then token" ); break;
				case ELSE_SY: System.out.println("else token") ; break;
				case DO_SY: System.out.println("do token" ); break;
				case WHILE_SY: System.out.println( "while token") ; break;
				case COMMA_SY: System.out.println( ", token" ); break;
				case COLON_SY: System.out.println( ": token" ); break;
				case ASSIGNMENT_SY: System.out.println( ":= token") ; break;
				case SEMICOL_SY: System.out.println( "; token") ; break;
				case AND_SY: System.out.println( "and token") ; break;
				case OR_SY: System.out.println( "or token") ; break;
				case NOT_SY:System.out.println( "not token") ; break;
				case TRUE_SY: System.out.println( "true token") ; break;
				case FALSE_SY: System.out.println("false token") ; break;
				default : System.out.println("ERROR_SY");
			}
		}
	
	}

    
    
    
}
