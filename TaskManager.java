import java.io.*;
import java.util.*;

public class TaskManager {
    //handles login: add, update, list, edit
    private static final String FILE_NAME = "tasks.json";
    private List<Task> tasks;

    public TaskManager(){
        tasks = loadTasks();
    }

    private List<Task> loadTasks(){
        return null;
    }

    public void addTask(String description){

    }

    public void updateTask(int id, String newDescription){

    }

    public void deleteTask(int id){

    }

    public void markStatus(int id, String status){}

    public void listTasks(String statusFilter){

    }

    //internal helpers



    private void saveTasks(){

    }

    private static String extractValue(String json, String key){
        return null;

    }

//    public String readFile() throws IOException {
//            String content = new String(Files.readAllBytes(Paths.get("tasks.json")));
//            System.out.println(content);
//            return content;
//    }
//    public void addTask(String description){
//        File taskFile = new File("tasks.json");
//        Task task = new Task(1,description,"TODO", new Date(), new Date());
//        System.out.println(taskFile);
//        System.out.println(description);
//        try {
//            String content = readFile();
//            System.out.println(content);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
