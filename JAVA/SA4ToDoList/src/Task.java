public class Task {
    // Atributos
    String description;
    boolean done;
    // Construtor
    public Task (String description){
    this.description = description;
    this.done = false;
    }
    // Getters and Setters
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    
}
