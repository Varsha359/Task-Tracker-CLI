import java.util.Arrays;
import java.util.Locale;

public class TaskTracker {
    //main CLI entry point
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println("Usage: java TaskTracker <command> [arguments]");
            return;
        }

        TaskManager taskManager = new TaskManager();
        String command = args[0];

        switch (command.toLowerCase()){
            case "add":
                if (args.length<2){
                    System.out.println("Usage: add <description>");
                }
                else{
                    String description = String.join(" ", Arrays.copyOfRange(args,1,args.length));
                    taskManager.addTask(description);
                }
                break;

            case "update":
                if(args.length<3){
                    System.out.println("Usage: update <id> <new description>");
                }
                else{
                    int id = Integer.parseInt(args[1]);
                    String newDescription = String.join(" ",Arrays.copyOfRange(args,2,args.length));
                    taskManager.updateTask(id, newDescription);
                }
                break;

            case "delete":
                if(args.length !=2){
                    System.out.println("Usage: delete <id>");
                }
                else{
                    int id = Integer.parseInt(args[1]);
                    taskManager.deleteTask(id);
                }
                break;
            case "done":
                taskManager.markStatus(Integer.parseInt(args[1]),"DONE");
                break;
            case "in_progress":
                taskManager.markStatus(Integer.parseInt(args[1]),"IN_PROGRESS");
                break;
            case "list":
                if(args.length==1){
                    taskManager.listTasks("ALL");
                }
                else{
                    taskManager.listTasks(args[1].toUpperCase());
                }
                break;
            default:
                System.out.println("Unknown command.");
        }
    }
}
