import java.util.ArrayList;
import java.util.List;
class Classes{
  List <Metodos> Methods = new ArrayList <Metodos>();
  private String heranca;
  private String name;

  public Classes(String name, String heranca){
    this.heranca=heranca;
    this.name=name;
  }
  public String getType() {
        return heranca;
    }
  public void setType(String t) {
        this.heranca=t;
    }
  public String getName() {
        return name;
    }
    
}