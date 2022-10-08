
//conferir se chegou no fim da lista 
import java.util.List;
class Sintaticos{
  public static int _expr(int Indicate, List<Words> tokens){
    if((Indicate+2)<tokens.size() && tokens.get(Indicate+1).getType().matches("Cadeia") && tokens.get(Indicate+2).getType().matches("atribuicao")){
      Indicate+=2;
      Indicate=_exprl(Indicate, tokens);
      
      if(Indicate==0){
        return 0;
      }
      return Indicate;
    }
    else if((Indicate+2)<tokens.size() &&tokens.get(Indicate+1).getType().matches("Cadeia") && tokens.get(Indicate+2).getName()=="abre-parenteses"){
      Indicate+=2;
      while(tokens.get(Indicate+1).getType()==","){
        Indicate+=1;
        Indicate= _exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()=="fecha-parenteses"){
        Indicate+=1;
        return Indicate;
      }
    }

      
    else if((Indicate+2)<tokens.size() && tokens.get(Indicate+1).getName()=="if"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(tokens.get(Indicate+1).getName()=="then"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 1");
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="else"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 2");
        return 0;
      }
      if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getName()=="fi"){
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 3");
        return 0;
      }
    }

    else if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getName()=="while"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="loop"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 4");
        return 0;
      }
      if(tokens.get(Indicate+1).getName()=="pool"){
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 5");
        return 0;
      }
    }
    else if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getType().matches("abre-chaves")){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      while((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getName()=="ponto_e_virgula"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="fecha-chaves"){
        Indicate+=1;
        return Indicate;
      }
      
    }

    else if((Indicate+4)<tokens.size() &&tokens.get(Indicate+1).getName().matches("let") && tokens.get(Indicate+2).getType().matches("Cadeia") && tokens.get(Indicate+3).getType().matches("dois_pontos") && tokens.get(Indicate+4).getType().matches("Cadeia")){
      Indicate+=4;
      if(tokens.get(Indicate+1).getType().matches("atribuicao")){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 6");
        return 0;
      }
      while((Indicate+4)<tokens.size() &&tokens.get(Indicate+1).getName().matches(",") && tokens.get(Indicate+2).getType().matches("Cadeia") && tokens.get(Indicate+3).getType().matches("dois_pontos") && tokens.get(Indicate+4).getType().matches("Cadeia")){
        Indicate+=4;
        if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getType()=="atribuicao"){
          Indicate+=1;
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
        } else {
        System.out.print("Erro na expressao 7");
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getName().matches("in")){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
        return Indicate;
        
      } else {
        System.out.print("Erro na expressao 8");
        return 0;
      }
    }

    else if((Indicate+1)<tokens.size() && tokens.get(Indicate+1).getName()=="case"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="of"){
        Indicate+=1;
        while((Indicate+5)<tokens.size() &&tokens.get(Indicate+1).getType()=="ID" && tokens.get(Indicate+2).getName()==":" && tokens.get(Indicate+3).getType()=="TYPE" && tokens.get(Indicate+4).getName()=="=" && tokens.get(Indicate+5).getName()==">"){
          Indicate+=5;
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
          if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()!=";"){
            System.out.print("Erro na expressao 9");
            return 0;
          }
          Indicate+=1;
        }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()!="esac"){
        System.out.print("Erro na expressao 10");
      }
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 11");
        return 0;
      }
    }

  else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="new"){
    Indicate+=1;
    if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="TYPE"){
      Indicate+=1;
      return Indicate;
      
    } else {
        System.out.print("Erro na expressao 12");
        return 0;
      }
  }  
 else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="isvoid"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="~"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="not"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="("){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
   if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()==")"){
      return Indicate+1;
   } else{
     System.out.println("ERRO: fecha-parenteses esperado 4");
     return 0;
   }   
  
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()=="Cadeia" || tokens.get(Indicate+1).getType()=="Numero" || tokens.get(Indicate+1).getType()=="String" ||tokens.get(Indicate+1).getName()=="true" || tokens.get(Indicate+1).getType()=="false"){
      return Indicate+1;
    }
    else{
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName().matches("@") ){
        if((Indicate+1)<tokens.size() &&tokens.get(Indicate+2).getType().matches("Cadeia")){
          System.out.println("ERRO: erro na expressão");
          return 0;
        }
        Indicate+=2;
        
        if((Indicate+3)<tokens.size() &&tokens.get(Indicate+1).getName()!="." || tokens.get(Indicate+2).getType()!="ID" ||tokens.get(Indicate+3).getType()!="abre-parenteses"){
           System.out.println("ERRO: erro na expressão");
          return 0;
        }
        Indicate+=3;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
        while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="," ){
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
        }
        if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()!="fecha-parenteses"){
          System.out.println("ERRO: fecha-parenteses esperado 1");
          return 0;
        }
        return Indicate+1;
      }
        else if((Indicate+3)<tokens.size() &&tokens.get(Indicate+1).getType().matches("ponto") && tokens.get(Indicate+2).getType().matches("Cadeia") &&tokens.get(Indicate+3).getType().matches("abre-parenteses")){
        System.out.println(Indicate);
     Indicate+=3;
        Indicate=_exprl(Indicate, tokens);
        while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="," ){
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
     }    
        }
        if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()!="fecha-parenteses"){
          System.out.println("ERRO: fecha-parenteses esperado 3");
          return 0;
        }
        return Indicate+1;
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="+"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="-"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="*"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="/"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="<"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="<="){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="="){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      
    }
    System.out.println("ERRO: erro na expressao 13");
    return 0;
        }







  
   public static int _exprl(int Indicate, List<Words> tokens){
    if((Indicate+2)<tokens.size() &&tokens.get(Indicate+1).getType().matches("Cadeia") && tokens.get(Indicate+2).getType().matches("atribuicao")){
      Indicate+=2;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      return Indicate;
    }
else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("fecha-parenteses")){
  return Indicate;
}
    
    else if((Indicate+2)<tokens.size() &&tokens.get(Indicate+1).getType().matches("Cadeia") && tokens.get(Indicate+2).getType().matches("abre-parenteses")){
      Indicate+=2;
      
      Indicate=_exprl(Indicate, tokens);
      while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()==","){
        Indicate+=1;
        Indicate= _exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("fecha-parenteses")){
        
        return Indicate+1;
      }
    }

      
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="if"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="then"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 14");
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="else"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 15");
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="fi"){
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 16");
        return 0;
      }
    }

    else if(tokens.get(Indicate+1).getName()=="while"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="loop"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
      } else {
        System.out.print("Erro na expressao 17");
        return 0;
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="pool"){
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 18");
        return 0;
      }
    }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("abre-chaves")){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
      while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("ponto_e_virgula")){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("fecha-chaves")){
        Indicate+=1;
        return Indicate;
      }
      
    }

    else if((Indicate+4)<tokens.size() &&tokens.get(Indicate+1).getName()=="let" && tokens.get(Indicate+2).getType()=="Cadeia" && tokens.get(Indicate+3).getType()=="dois_pontos" && tokens.get(Indicate+4).getType()=="TYPE"){
      Indicate+=4;
      if(tokens.get(Indicate+1).getType()=="atribuicao"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      } else {
        System.out.print("Erro na expressao 19");
        return 0;
      }
      while((Indicate+4)<tokens.size() &&tokens.get(Indicate+1).getName()=="," && tokens.get(Indicate+2).getType()=="Cadeia" && tokens.get(Indicate+3).getName()=="dois_pontos" && tokens.get(Indicate+4).getType()=="TYPE"){
        Indicate+=4;
        if(tokens.get(Indicate+1).getType()=="atribuicao"){
          Indicate+=1;
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
        } else {
        System.out.print("Erro na expressao 20");
        return 0;
      }
      }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="in"){
        Indicate+=1;
        Indicate=_exprl(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
        return Indicate;
      } else {
        System.out.print("Erro na expressao 21");
        return 0;
      }
    }

    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="case"){
      Indicate+=1;
      Indicate=_exprl(Indicate, tokens);
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="of"){
        Indicate+=1;
        while((Indicate+5)<tokens.size() &&tokens.get(Indicate+1).getType()=="ID" && tokens.get(Indicate+2).getName()==":" && tokens.get(Indicate+3).getType()=="TYPE" && tokens.get(Indicate+4).getName()=="=" && tokens.get(Indicate+5).getName()==">"){
          Indicate+=5;
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
          if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()!=";"){
            System.out.print("Erro na expressao 22");
            return 0;
          }
          Indicate+=1;
        }
      if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()!="esac"){
        System.out.print("Erro na expressao 23");
      }
        Indicate+=1;
        return Indicate;
      } else {
        System.out.print("Erro na expressao 24");
        return 0;
      }
    }

  else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="new"){
    Indicate+=1;
    if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="TYPE"){
      Indicate+=1;
      return Indicate;
      
    } else {
        System.out.print("Erro na expressao 25");
        return 0;
      }
  }  
 else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="isvoid"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
   if(Indicate==0){
        return 0;
      }
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="~"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="not"){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
   return Indicate;
 }
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="("){
   Indicate+=1;
   Indicate=_exprl(Indicate, tokens);
      if(Indicate==0){
        return 0;
      }
   if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()==")"){
      return Indicate+1;
   } else{
     System.out.println("ERRO: fecha-parenteses esperado 2");
     return 0;
   }   
  
 }
      
     
    else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType().matches("Cadeia") || tokens.get(Indicate+1).getType().matches("Numero") || tokens.get(Indicate+1).getType().matches("String")){
      return Indicate+1;
    }
      
    else{
      if((Indicate+4)<tokens.size() && tokens.get(Indicate+1).getType().matches("ponto") && tokens.get(Indicate+2).getType().matches("Cadeia") && tokens.get(Indicate+3).getType().matches("abre-parenteses") && tokens.get(Indicate+4).getType().matches("Cadeia")){
        System.out.println("oi");
      System.out.println(tokens.get(Indicate+1).getName());
     Indicate+=4;
        Indicate=_exprl(Indicate, tokens);
        while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="," ){
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
     }    
        }
        if((Indicate+1)<tokens.size() && !tokens.get(Indicate+1).getType().matches("fecha-parenteses")){
          System.out.println("ERRO: fecha-parenteses esperado 4");
          return 0;
        }
        return Indicate+1;
      }  
      if((Indicate+2)<tokens.size() &&tokens.get(Indicate+1).getName().matches("@") ){
        if(!tokens.get(Indicate+2).getType().matches("Cadeia")){
          System.out.println("ERRO: erro na expressão");
          return 0;
        }
        Indicate+=2 ;
        if((Indicate+3)<tokens.size() &&tokens.get(Indicate+1).getName()!="." || tokens.get(Indicate+2).getType()!="ID" ||tokens.get(Indicate+3).getType()!="abre-parenteses"){
           System.out.println("ERRO: erro na expressão");
          return 0;
        }
        Indicate+=3;
        Indicate=_exprl(Indicate, tokens);
        while((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="," ){
          Indicate=_exprl(Indicate, tokens);
          if(Indicate==0){
        return 0;
      }
        }   
      }
       
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="+"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="-"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="*"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="/"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="<"){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="<="){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      }
      else if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getName()=="="){
        Indicate+=1;
        return _exprl(Indicate, tokens);
      } 
    }
     return Indicate;
    }
     
  public static int _formal(int Indicate, List<Words> tokens){
    if((Indicate+1)<tokens.size() && !tokens.get(Indicate+1).getType().matches("Cadeia")){
      System.out.println("ERROR: ID esperado");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()!="dois_pontos"){
      System.out.println("ERROR: esperado :");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size() &&tokens.get(Indicate+1).getType()!="TYPE"){
      System.out.println("ERROR: esperado ufm tipo");
      return 0;
    }
    
    return Indicate+1;
  }







  
  public static int _feature(int Indicate, List<Words> tokens){
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("Cadeia")){
      System.out.println("ERROR: ID esperado");
  }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&&tokens.get(Indicate+1).getName()=="dois_pontos")
    {
      Indicate+=1;
      if((Indicate+1)<tokens.size()&&tokens.get(Indicate+1).getType()!="Cadeia"){
         System.out.println("ERROR: tipo esperado");
        return 0;
      }
      Indicate+=1;
      if((Indicate+1)<tokens.size()&& tokens.get(Indicate+1).getType()=="atribuicao"){
        Indicate+=1;
        Indicate=_expr(Indicate, tokens);
        if(Indicate==0){
        return 0;
      }
      }
      return Indicate;
    }
    else if((Indicate+1)<tokens.size()&&!tokens.get(Indicate+1).getType().matches("abre-parenteses")){
      System.out.println("ERRO:esperado abre-parenteses ou :");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("fecha-parenteses")){
       Indicate=_formal(Indicate, tokens);
    }
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("fecha-parenteses")){
      System.out.println("ERRO:fecha-parenteses esperado");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("dois_pontos")){
      System.out.println("ERRO: esperado :");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("Cadeia")){
      System.out.println("ERRO: esperado um tipo");
      return 0;
    }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("abre-chaves")){
      System.out.println("ERRO: esperado um abre-chaves");
      return 0;
    }
    Indicate=_expr(Indicate+1, tokens);
    if(Indicate==0){
        return 0;
      }
    
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("fecha-chaves")){
      System.out.println("ERRO: fecha-chaves esperado");
    } else{
      return Indicate+1;
    }
  return Indicate;
  }
  
  public static int _class(int Indicate, List<Words> tokens){
  if(!tokens.get(Indicate+1).getType().matches("Cadeia")){
    System.out.println("ERRO: Esperado um tipo depois da definição de classe");
    return 0;
  }
    Indicate+=1;
    if(tokens.get(Indicate+1).getName().matches("inherits")){
      if(!tokens.get(Indicate+2).getType().matches("Cadeia")){
        System.out.print("ERRO: Esperado um tipo depois do inherits");
        return 0;
      }
      Indicate+=2;
    }
    if(!tokens.get(Indicate+1).getType().matches("abre-chaves")){
      System.out.print("ERRO:abre-chaves esperado");
      return 0;
    }
    Indicate+=1;
    Indicate=_feature(Indicate, tokens);
    if(Indicate==0){
        return 0;
      }
    Indicate+=1;
    if((Indicate+1)<tokens.size()&& !tokens.get(Indicate+1).getType().matches("fecha-chaves")){
      System.out.print("ERRO:fecha-chaves esperado");
      return 0;
    } else{
      return Indicate+1;
    }
    
}

  
}