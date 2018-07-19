import java.util.Vector;

public class List {
    private String name;
    private Vector<Tarea> tareas;


    public List(String name) {
        this.name = name;
        this.tareas = new Vector<Tarea>();
    }
    public String getName(){
        return this.name;
    }
    public void addTarea(Tarea Tarea){
        tareas.add(Tarea);
    }
    public Vector<Tarea> getTareas(){
        return this.tareas;
    }
}
