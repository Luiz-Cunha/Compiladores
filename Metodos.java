import java.util.ArrayList;
import java.util.List;
class Metodos{
  private String type;
  private String name;
  private String Classepai;
  List <Variables> Variaveis=new ArrayList<Variables>();

  public Metodos(String type, String name, String Classepai){
    this.type=type;
    this.name=name;
  }
  public String getType() {
        return type;
    }
  public void setType(String t) {
        this.type=t;
    }
  public String getName() {
        return name;
    }
    
}