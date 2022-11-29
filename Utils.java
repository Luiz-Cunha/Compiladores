import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

class Utils {
  static List<Variables> Variaveis = new ArrayList<Variables>();
  static List<Classes> Classs = new ArrayList<Classes>();
  static String name;
  static String type;
  static String value;

  static void StartClass() {
    Classes IO = new Classes("IO", "");
    Classs.add(IO);
  }

  static boolean found(String token1, List<Variables> Variaveis) {
    for (Variables v : Variaveis) {
      if (token1.matches(v.getName())) {
        return true;
      }
    }
    return false;
  }

  static void HandleClass(List<Words> tokens, int i) {
    for (Classes c : Classs) {
      if (tokens.get(i + 1).getName().matches(c.getName())) {
        System.out.println("Erro: redeclaraçao da classe");
        System.out.print(tokens.get(i + 1).getName());
      }
    }
    if (tokens.get(i + 2).getName().matches("inherits")
        && tokens.get(i + 3).getName().matches(tokens.get(i + 1).getName())) {
      System.out.println("Erro: uma classe não pode herdar de si mesma");
    }
    boolean flag = false;
    if (tokens.get(i + 2).getName().matches("inherits")) {
      for (Classes c : Classs) {
        if (tokens.get(i + 3).getName().matches(c.getName())) {
          flag = true;
        }
      }
      if (flag == false) {
      System.out.println("Erro: classe pai nao existe");
    }
    }
    
    if (tokens.get(i + 2).getName().matches("inherits")) {
      Classes novaclasse = new Classes(tokens.get(i + 1).getName(), tokens.get(i + 3).getName());
      Classs.add(novaclasse);
    } else {
      Classes novaclasse = new Classes(tokens.get(i + 1).getName(), "");
      Classs.add(novaclasse);
    }
  }

  static String Result_if(List<Words> expr, String type) {
    String retorno = "";
    List<Words> condicao = new ArrayList<Words>();
    int i = 0;
    while (!(expr.get(i).getName().matches("then"))) {
      condicao.add(expr.get(i));
      i++;
    }
    boolean flag = false;
    for (int j = 0; j < condicao.size(); j++) {
      if ((condicao.get(j).getName().matches("<") || condicao.get(j).getName().matches("<=")
          || condicao.get(j).getName().matches("="))) {
        flag = true;
      }
    }
    if (flag == false) {
      if (condicao.size() != 1) {
        System.out.println("Erro, a condicao do if precisa ser um valor booleano");
        return "";
      }
      boolean flag2 = false;
      for (Variables v : Variaveis) {
        if (v.getName().matches(condicao.get(0).getName())) {
          flag2 = true;
          if (!(v.getType().matches("boolean"))) {
            System.out.println("Erro, a condicao do if precisa ser um valor booleano");
          }
        }
      }
      if (flag2 == false) {
        System.out.println("Erro,variavel nao declarada");
      }
    }
    i++;
    while (i < expr.size()) {
      if (expr.get(i).getName().matches("else")) {
        i++;
      }
      if (type.matches("String")) {
        if (expr.get(i).getType().matches("Cadeia")) {

          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("String") && !v.getType().matches("Char")) {
                System.out.println("Erro: atribuiçao invalida a uma string");
              }
            }
          }
        }
        retorno = "String";
      }
      if (type.matches("Char")) {

        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("Char")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "Char";
      }
      if (type.matches("int")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("Int")) {
                System.out.println("Erro: atribuiçao invalida a um int");
              }
            }
          }
        }
        retorno = "int";
      }
      if (type.matches("double")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("double")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "double";
      }
      if (type.matches("float")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("float")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "float";
      }
      i++;
    }
    return retorno;
  }

  static String Result_while(List<Words> expr, String type) {
    String retorno = "";
    List<Words> condicao = new ArrayList<Words>();
    int i = 0;
    while (!(expr.get(i).getName().matches("loop"))) {
      condicao.add(expr.get(i));
      i++;
    }
    boolean flag = false;
    for (int j = 0; j < condicao.size(); j++) {
      if ((condicao.get(j).getName().matches("<") || condicao.get(j).getName().matches("<=")
          || condicao.get(j).getName().matches("="))) {
        flag = true;
      }
    }
    if (flag == false) {
      if (condicao.size() != 1) {
        System.out.println("Erro, a condicao do if precisa ser um valor booleano");
        return "";
      }
      boolean flag2 = false;
      for (Variables v : Variaveis) {
        if (v.getName().matches(condicao.get(0).getName())) {
          flag2 = true;
          if (!(v.getType().matches("boolean"))) {
            System.out.println("Erro, a condicao do if precisa ser um valor booleano");
          }
        }
      }
      if (flag2 == false) {
        System.out.println("Erro,variavel nao declarada");
      }
    }
    i++;
    while (i < expr.size()) {
      if (type.matches("String")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("String") && !v.getType().matches("Char")) {
                System.out.println("Erro: atribuiçao invalida a uma string");
              }
            }
          }
        }
        retorno = "String";
      }
      if (type.matches("Char")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("Char")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "Char";
      }
      if (type.matches("int")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("Int")) {
                System.out.println("Erro: atribuiçao invalida a um int");
              }
            }
          }
        }
        retorno = "int";
      }
      if (type.matches("double")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("double")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "double";
      }
      if (type.matches("float")) {
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (expr.get(i).getName().matches(v.getName())) {
              if (!v.getType().matches("float")) {
                System.out.println("Erro: atribuiçao invalida a um Char");
              }
            }
          }
        }
        retorno = "float";
      }
      i++;
    }
    return retorno;
  }

  static void HandleSemanticCases(Variables var, List<Words> expr) {
    if (var.getType().matches("String")) {
      for (int i = 0; i < expr.size(); i++) {
        if (!(expr.get(i).getType().matches("String") || expr.get(i).getType().matches("Cadeia")
            || expr.get(i).getName().matches("if") || expr.get(i).getName().matches("fi")
            || expr.get(i).getName().matches("while") || expr.get(i).getName().matches("\\+")
            || expr.get(i).getName().matches("-") || expr.get(i).getName().matches("\\*")
            || expr.get(i).getName().matches("/") || expr.get(i).getName().matches("loop")
            || expr.get(i).getName().matches("pool"))) {
          System.out.print("Atribuicao invalida a variavel ");
          System.out.println(var.getName());
        }
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (v.getName().matches(expr.get(i).getName()) && !v.getType().matches("String")
                && !v.getType().matches("Char")) {
              System.out.println("Erro, atribuicao invalida a um tipo String");
            }
          }
        }
        if (expr.get(i).getName().matches("if")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("fi")) {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_if(expr_if, "String").matches("String"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
        if (i < expr.size() && expr.get(i).getName().matches("while")) {
          i++;
          List<Words> expr_while = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("pool")) {
            expr_while.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_while(expr_while, "String").matches("String"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
      }
    }
    if (var.getType().matches("Char")) {
      for (int i = 0; i < expr.size(); i++) {
        if (!(expr.get(i).getType().matches("Char") || expr.get(i).getType().matches("Cadeia")
            || expr.get(i).getName().matches("if") || expr.get(i).getName().matches("case")
            || expr.get(i).getName().matches("while") || expr.get(i).getName().matches("\\+")
            || expr.get(i).getName().matches("-") || expr.get(i).getName().matches("\\*")
            || expr.get(i).getName().matches("/"))) {
          System.out.print("Atribuicao invalida a variavel ");
          System.out.println(var.getName());
        }
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (v.getName().matches(expr.get(i).getName()) && !v.getType().matches("String")
                && !v.getType().matches("Char")) {
              System.out.println("Erro, atribuicao invalida a um tipo String");
            }
          }
        }
        if (expr.get(i).getType().matches("if")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (expr.get(i).getName() != "fi") {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_if(expr_if, "Char").matches("Char"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
        if (i < expr.size() && expr.get(i).getName().matches("while")) {
          i++;
          List<Words> expr_while = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("pool")) {
            expr_while.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_while(expr_while, "String").matches("String"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
      }
    }
    if (var.getType().matches("Int")) {
      for (int i = 0; i < expr.size(); i++) {
        if (!(expr.get(i).getType().matches("Numero") || expr.get(i).getType().matches("Cadeia")
            || expr.get(i).getName().matches("if") || expr.get(i).getName().matches("case")
            || expr.get(i).getName().matches("while") || expr.get(i).getName().matches("\\+")
            || expr.get(i).getName().matches("-") || expr.get(i).getName().matches("\\*")
            || expr.get(i).getName().matches("/") || expr.get(i).getName().matches("=")
            || expr.get(i).getName().matches("then") || expr.get(i).getName().matches("else")
            || expr.get(i).getName().matches("fi"))) {
          System.out.print("Atribuicao invalida a variavel ");
          System.out.println(var.getName());
          System.out.println(expr.get(i).getName());
        }
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (v.getName().matches(expr.get(i).getName()) && !v.getType().matches("Int")) {
              System.out.println("Erro, atribuicao invalida a um tipo int");
            }
          }
        }
        if (expr.get(i).getName().matches("if")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("fi")) {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_if(expr_if, "int").matches("int"))) {
            System.out.println("Erro, atribuicao invalida a um tipo int");
          }
        }
        if (i < expr.size() && expr.get(i).getName().matches("while")) {
          i++;
          List<Words> expr_while = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("pool")) {
            expr_while.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_while(expr_while, "String").matches("String"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
      }
    }
    if (var.getType().matches("double")) {
      for (int i = 0; i < expr.size(); i++) {
        if (!(expr.get(i).getType().matches("num") || expr.get(i).getType().matches("Cadeia")
            || expr.get(i).getName().matches("if") || expr.get(i).getName().matches("case")
            || expr.get(i).getName().matches("while") || expr.get(i).getName().matches("\\+")
            || expr.get(i).getName().matches("-") || expr.get(i).getName().matches("\\*")
            || expr.get(i).getName().matches("/"))) {
          System.out.print("Atribuicao invalida a variavel ");
          System.out.println(var.getName());
        }
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (v.getName().matches(expr.get(i).getName()) && v.getType() != "String" && v.getType() != "Char") {
              System.out.println("Erro, atribuicao invalida a um tipo String");
            }
          }
        }
        if (expr.get(i).getType().matches("if")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (expr.get(i).getName() != "fi") {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_if(expr_if, "double").matches("double"))) {
            System.out.println("Erro, atribuicao invalida a um tipo double");
          }
        }
        if (i < expr.size() && expr.get(i).getName().matches("while")) {
          i++;
          List<Words> expr_while = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("pool")) {
            expr_while.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_while(expr_while, "String").matches("String"))) {
            System.out.println("Erro, atribuicao invalida a um tipo String");
          }
        }
      }
    }
    if (var.getType().matches("float")) {
      for (int i = 0; i < expr.size(); i++) {
        if (!(expr.get(i).getType().matches("num") || expr.get(i).getType().matches("Cadeia")
            || expr.get(i).getName().matches("if") || expr.get(i).getName().matches("case")
            || expr.get(i).getName().matches("while") || expr.get(i).getName().matches("\\+")
            || expr.get(i).getName().matches("-") || expr.get(i).getName().matches("\\*")
            || expr.get(i).getName().matches("/"))) {
          System.out.print("Atribuicao invalida a variavel ");
          System.out.println(var.getName());
        }
        if (expr.get(i).getType().matches("Cadeia")) {
          for (Variables v : Variaveis) {
            if (v.getName().matches(expr.get(i).getName()) && v.getType() != "String" && v.getType() != "Char") {
              System.out.println("Erro, atribuicao invalida a um tipo String");
            }
          }
        }
        if (expr.get(i).getType().matches("if")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("fi")) {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_if(expr_if, "float").matches("float"))) {
            System.out.println("Erro, atribuicao invalida a um tipo float");
          }
        }

        if (i < expr.size() && expr.get(i).getType().matches("while")) {
          i++;
          List<Words> expr_if = new ArrayList<Words>();
          while (!expr.get(i).getName().matches("pool")) {
            expr_if.add(expr.get(i));
            i++;
          }
          i++;
          if (!(Result_while(expr_if, "float").matches("float"))) {
            System.out.println("Erro, atribuicao invalida a um tipo float");
          }
        }
      }
    }
  }

  static int fimescopo(List<Words> tokens, int indicate) {
    int k = 1;
    for (int i = indicate; i < tokens.size(); i++) {
      if (tokens.get(i).getType().matches("abre-chaves")) {
        k++;
      } else if (tokens.get(i).getType().matches("fecha-chaves")) {
        k--;
      }
      if (k == 0) {
        return i;
      }
    }
    return indicate;
  }

  static int inicioescopo(List<Words> tokens, int indicate) {
    int k = 1;
    for (int i = indicate; i < tokens.size(); i++) {
      if (tokens.get(i).getName().matches("let")) {
        System.out.println("oi");
        k++;
      } else if (tokens.get(i).getName().matches("in")) {
        k--;
      }
      if (k == 0) {
        return i + 1;
      }
    }
    return indicate;
  }
  static void Mapa(List<Words> tokens) {
    String clss="";
    StartClass();
    for (int i = 0; i < tokens.size(); i++) {
      if (tokens.get(i).getName().matches("class")) {
        clss=tokens.get(i+1).getName();
        HandleClass(tokens, i);
      }
      if(tokens.get(i).getType().matches("Cadeia") && tokens.get(i+1).getType().matches("abre-parenteses")){
        int h=1;
        int novoi=i+2;
        List<Words> formals = new ArrayList<Words>();
        while(h!=0){
          if(tokens.get(novoi).getType().matches("abre-parenteses")){
            h++;
            formals.add(tokens.get(novoi));
          }
          else if(tokens.get(novoi).getType().matches("fecha-parenteses")){
            h--;
            if(h!=0){
              formals.add(tokens.get(novoi));
            }
          } else {
            formals.add(tokens.get(novoi));
          }
          novoi++;
        }
        if(tokens.get(novoi).getName().matches(":")){
          Metodos method= new Metodos(tokens.get(novoi+1).getName(), tokens.get(i).getName(), clss);
          boolean fla=true;
 for(int z=0;z<formals.size();z+=4){
   if(formals.get(z).getType().matches("Cadeia")){
     Variables nw= new Variables(formals.get(z).getName(), formals.get(z+2).getName(), 0, 0);
     for(Variables x : method.Variaveis){
       if(x.getName().matches(nw.getName())){
         fla=false;
       }
     }
     
     method.Variaveis.add(nw);
     for(Classes c : Classs){
       if(c.getName().matches(clss)){
         c.Methods.add(method);
       }
     }
   }
   if (fla==false){
   System.out.println("Erro, redeclaracao de variavel");
 }  
 }    
 } else {
          if(!tokens.get(i-1).getType().matches("ponto")){
            boolean fl=false;
            for(Classes c : Classs){
       if(c.getName().matches(clss)){
         for(Metodos m : c.Methods){
           if(m.getName().matches(tokens.get(i).getName())){
             fl=true;
           }
         }
       }
          }
            if(fl==false){
              System.out.println("Erro: metodo nao encontrado");
            }
     } else if(tokens.get(i-1).getType().matches("ponto")){
            boolean f=false; 
            for(Variables v : Variaveis){
              
              if(v.getName().matches(tokens.get(i-2).getName())){
                for(Classes c : Classs){
                  if(c.getName().matches(v.getType())){
                    for(Metodos m : c.Methods){
                      if(m.getName().matches(tokens.get(i).getName())){
                        f=true;
                      }
                    }
                  }
                }
              }
            }
            if(f==false){
              System.out.println("Erro: metodo nao encontrado");
            }
     }
      }
      }
      if (tokens.get(i).getType().matches("Cadeia") && !(found(tokens.get(i).getName(), Variaveis)) && i-1>-1 && !tokens.get(i-1).getName().matches("class") && !tokens.get(i+1).getType().matches("abre-parenteses") && clss.matches("main")) {
        System.out.println("ERRO:variavel nao declarada: ");
        System.out.print(tokens.get(i).getName());
        return;
      } else {
        for (Variables v : Variaveis) {
          if (tokens.get(i).getName().matches(v.getName())) {
            if (i < v.getEscopoinicio() || i > v.getEscopofim()) {
              System.out.println("Erro: variavel sendo usada fora de escopo");
              return;
            }
          }
        }
      }
      if (tokens.get(i).getName().matches("let")) {
        int inicioesc = inicioescopo(tokens, i + 1);
        int fimesc = fimescopo(tokens, inicioesc + 1);
        List<Words> exprs = new ArrayList<Words>();
        do {
          name = tokens.get(i + 1).getName();
          type = tokens.get(i + 3).getName();
          i += 3;
          if (tokens.get(i + 1).getType().matches("atribuicao")) {
            i++;

            while (tokens.get(i + 1).getName() != "," && tokens.get(i + 1).getName() != ";") {

              if (tokens.get(i + 1).getType().matches("Cadeia")) {
                if (!found(tokens.get(i + 1).getName(), Variaveis) && !tokens.get(i + 1).getName().matches(name)) {
                  System.out.println("Erro: variavel não declarada");
                }
              }
              exprs.add(tokens.get(i + 1));
              i++;
            }
          }
          Variables one = new Variables(name, type, inicioesc, fimesc);
          if (!found(name, Variaveis)) {
            HandleSemanticCases(one, exprs);
            Variaveis.add(one);
          } else {
            System.out.println("Erro: redeclaracao de variavel");
          }
          i += 1;
          exprs.clear();
        } while (tokens.get(i).getName().matches(","));

      }
      
    }
  }
}