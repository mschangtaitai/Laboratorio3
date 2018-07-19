public class Tarea {
    private String name;
    private Boolean complete;

    public Tarea(String name){
        this.name = name;
        this.complete = false;
    }

    public void complete(){
        if (!this.complete){
            this.complete = true;
        } else if (this.complete){
            this.complete = false;
        }
    }

    public String getTarea(){
        if (!this.complete){
            return (this.name + " sin completar\n");
        }
        return (this.name + " completado\n");
    }
}
