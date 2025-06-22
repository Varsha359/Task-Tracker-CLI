import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskManager {
    //handles login: add, update, list, edit
    private static final String FILE_NAME = "tasks.json";
    private List<Task> tasks;

    public TaskManager(){

        tasks = loadTasks();
    }

    public void addTask(String description){
        int id = tasks.isEmpty()? 1: tasks.get(tasks.size()-1).getId() + 1;
        tasks.add(new Task(id, description,"TODO",new Date(),new Date()));
        saveTasks();
        System.out.println("Task added.");
    }

    public void updateTask(int id, String newDescription){
        for(Task t: tasks){
            if(t.getId() == id){
                t.setDescription(newDescription);
                saveTasks();
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id){
        boolean removed = tasks.removeIf(t->t.getId() == id);
        if(removed){
            saveTasks();
            System.out.println("Task deleted.");
        }
        else{
            System.out.println("Task not found.");
        }
    }

    public void markStatus(int id, String status){
        for(Task t: tasks){
            if(t.getId() == id){
                t.setStatus(status);
                t.setUpdatedAt(new Date());
                saveTasks();
                System.out.println("Task status updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void listTasks(String statusFilter){
        for(Task t:tasks){
            if(statusFilter.equals("ALL") || t.getStatus().equalsIgnoreCase(statusFilter)){
                System.out.println(t);
            }
        }
    }

    //internal helpers

    private List<Task> loadTasks(){
        List<Task> list = new ArrayList<Task>();
        File file = new File(FILE_NAME);
        if(!file.exists()){
            try{
                file.createNewFile();
                FileWriter writer = new FileWriter(FILE_NAME);
                writer.write("[]");
                writer.close();
            }
            catch(IOException e){
                System.out.println("Error creating file: "+e.getMessage());
            }

        }

        try {
            String content = new String(Files.readAllBytes(file.toPath())).trim();
            if (content.length()<=2) return list;

            content = content.substring(1,content.length()-1); //remove [ ]

            String[] entries = content.split("\\},\\s*\\{");
            for(int i=0; i<entries.length;i++){
                String obj = entries[i].trim();
                if(!obj.startsWith("{")) obj = "{"+ obj;
                if(!obj.endsWith("}")) obj = obj + "}";

                int id = Integer.parseInt(extractValue(obj,"id"));
                String description = extractValue(obj, "description");
                String status = extractValue(obj, "status");
                Date createdAt = parseDate(extractValue(obj, "createdAt"));
                Date updatedAt = parseDate(extractValue(obj,"updatedAt"));

                list.add(new Task(id,description,status,createdAt,updatedAt));

            }
        }catch (IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
        return list;
    }
    private void saveTasks(){
        try(FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                fw.write(" {\"id\": " + t.getId() + ", \"description\": \"" + t.getDescription() +
                        "\",\"status\" : \"" + t.getStatus() + "\"}");
                if (i != tasks.size() - 1) fw.write(",\n");
            }
            fw.write("\n]");
        }catch (IOException e){
            System.out.println("Error writing file: "+e.getMessage());
        }
    }

    private static String extractValue(String json, String key){
        //"\"id\": 1, \"title\": \"Learn Java\", \"status\": \"TODO\""
        String[] parts = json.split("\""+ key+ "\"\\s*:\\s*");
        if(parts.length<2) return "";

        String value = parts[1].split(",|\\}")[0].trim();
        if(value.startsWith("\"") && value.endsWith("\"")){
            value = value.substring(1,value.length()-1);
        }
        return value;
    }

    public static Date parseDate(String str){
        if (str.isEmpty()) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.parse(str,formatter);
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }
}
