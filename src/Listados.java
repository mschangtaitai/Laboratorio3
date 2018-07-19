import java.util.Vector;

public class Listados {
    private String name = "Listados de tareas";
    private Vector<List> listas ;

    public Listados(String name) {
        this.name = name;
        this.listas = new Vector<List>();
    }
    public void addList(List List){
        listas.add(List);
    }
    public Vector<List> getListas(){
        return this.listas;
    }
}
