import java.io.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Main {
  public static void main(String[] args) throws IOException{
  String [] keywords = new String[19];
  keywords[0]="class";
  keywords[1]="else";
  keywords[2]="false";
  keywords[3]="fi";
  keywords[4]="if";
  keywords[5]="in";
  keywords[6]="inherits";
  keywords[7]="isvoid";
  keywords[8]="let";
  keywords[9]="loop";
  keywords[10]="pool";
  keywords[11]="then";
  keywords[12]="while";
  keywords[13]="case";
  keywords[14]="esac";
  keywords[15]="new";
  keywords[16]="of";
  keywords[17]="not";
  keywords[18]="true";

    
    String estado="parado";
List<String> linhasArquivo = Files.readAllLines(Paths.get(("program.txt")));
    List< Words > tokens=new ArrayList<Words>();  
    String plvr="";
 for(int j=0;j<linhasArquivo.size();j++){
   for (int i=0; i<linhasArquivo.get(j).length(); i++) {
   char c = linhasArquivo.get(j).charAt(i);
    switch(c){
      case '\"' :
        if(estado!="lendo_string"){
          estado="lendo_string";
          i++;
          while(linhasArquivo.get(j).charAt(i)!='\"'){
            
            plvr+=linhasArquivo.get(j).charAt(i);
            i++;
            if(i==linhasArquivo.get(j).length()){
              i=0;
              j++;
            }
          }
          Words newtoken = new Words("String", plvr);
          estado="parado";
          plvr="";
          tokens.add(newtoken);
        }
      
    break;

      case '(' :
        Words newtoken = new Words("abre-parenteses", "(");
        tokens.add(newtoken);
        break;
      case  ')' : 
        newtoken = new Words("fecha-parenteses", ")");
        tokens.add(newtoken);
        break;
      case '{' :
        newtoken = new Words("abre-chaves", "{");
        tokens.add(newtoken);
        break;
      case '}' :
        newtoken = new Words("fecha-chaves", "}");
        tokens.add(newtoken);
        break;
      case ';' :
        newtoken = new Words("ponto_e_virgula", ";");
        tokens.add(newtoken);
        break;
      case ',' :
        newtoken = new Words("virgula", ",");
        tokens.add(newtoken);
        break;  
      case ':' :
        newtoken = new Words("dois_pontos", ":");
        tokens.add(newtoken);
        break; 
      case '.' :
        newtoken = new Words("ponto", ".");
        tokens.add(newtoken);
        break;
        
      case '<' :
        if(i+1<linhasArquivo.get(j).length() && linhasArquivo.get(j).charAt(i+1)=='-'){
          newtoken = new Words("atribuicao", "<-");
          tokens.add(newtoken);
          i++;
        }
        else if(i+1<linhasArquivo.get(j).length() && linhasArquivo.get(j).charAt(i+1)=='='){
          newtoken = new Words("menor_igual", "<=");
          tokens.add(newtoken);
          i++;
        } 
        else   {
          newtoken = new Words("menor", "<");
          tokens.add(newtoken);
        }
        break;
      case '+' :  
        newtoken = new Words("soma", "+");
        tokens.add(newtoken);
        break;
      case '-' :  
        if(i+1<linhasArquivo.get(j).length() && linhasArquivo.get(j).charAt(i+1)=='-'){
          estado="lendo_comentario";
          i+=2;
          while(linhasArquivo.get(j).charAt(i)!='-' && i+1<linhasArquivo.get(j).length() &&
               linhasArquivo.get(j).charAt(i)!='-'){
            
            plvr+=linhasArquivo.get(j).charAt(i);
            i++;
            if(i==linhasArquivo.get(j).length()){
              i=0;
              j++;
            }
          }
          newtoken = new Words("Comentario", plvr);
          estado="lendo_comentario";
          plvr="";
          tokens.add(newtoken);
        }
        else{
        newtoken = new Words("subtracao", "-");
        tokens.add(newtoken);
        break;
        }
        
      case '/' :  
        newtoken = new Words("divisao", "/");
        tokens.add(newtoken);
        break;
      case '*' :  
        newtoken = new Words("multiplicacao", "*");
        tokens.add(newtoken);
        break;
      case '~' :  
        newtoken = new Words("tio", "~");
        tokens.add(newtoken);
        break;
      case '@' :  
        newtoken = new Words("arrouba", "@");
        tokens.add(newtoken);
        break;
       case '=' :
          newtoken = new Words("comparacao", "=");
          tokens.add(newtoken);
          i++;
        
        break;
      default:
        while(linhasArquivo.get(j).charAt(i)==' '){
          i++;
          if(i==linhasArquivo.get(j).length()){
             i=0;
              j++;
            }
        }
          while(String.valueOf(linhasArquivo.get(j).charAt(i)).matches("^[-a-zA-Z0-9_]+")){
            plvr+=String.valueOf(linhasArquivo.get(j).charAt(i));
            i++;
            if(i==linhasArquivo.get(j).length()){
             i=0;
              j++;
            }
          }
          newtoken = new Words("Cadeia", plvr);
          plvr="";
          tokens.add(newtoken);
          i--;
    }
      
}
 }
    for(int i=0;i<tokens.size();i++){
      if(tokens.get(i).getName()==""){
        tokens.remove(i);
      }
    }
    for(int i=0;i<tokens.size();i++){
      System.out.println(tokens.get(i).getType()+"---->" + tokens.get(i).getName());
    }


    
}
}