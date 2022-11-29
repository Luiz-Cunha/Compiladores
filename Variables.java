import java.util.List;
import java.util.HashMap;
class Variables{
  String type;
  String name;
  int escopoinicio;
  int escopofim;
  public Variables(String name, String type, int escopoinicio, int escopofim){
    this.name=name;
    this.type=type;
    this.escopoinicio=escopoinicio;
    this.escopofim=escopofim;
  }
  public int getEscopoinicio() {
        return escopoinicio;
    }
  public void setEscopoinicio(int esc) {
        this.escopoinicio=esc;
    }
  public int getEscopofim() {
        return escopofim;
    }
  public void setEscopofim(int esc) {
        this.escopofim=esc;
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
    public void setName(String t) {
        this.name=t;
    }
} 
  