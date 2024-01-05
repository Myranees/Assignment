/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;


class Stack<T> {
    int maxSize;
    int top;
    T array[];

    public Stack() {
        maxSize = 100;
        top = 0;
        array =(T[]) new Object[maxSize];  
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        if(top==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFull(){
        if(top==maxSize){
            return true;
        }else{
            return false;
        }
    }
    public T peek(){
        if(!isEmpty()){
            return array[top-1];
        }else{
            return null;
        }
    }
    public T pop(){
        if(!isEmpty()){
            top--;
            T temp = array[top];
            array[top]=null;
            return temp;
        }else{
            return null;
        }
    }
    public void push(T data){
        if(!isFull()){
            array[top]=data;
            top++;
        }else{
            System.out.println("Stack is already full");
        }
    }  
}
public class SchedulerC{
    
    Stack<Task> stack = new Stack<>();
    private int totalTime =0;
    int numberOftasks =0;
    
    public void addTask(Task task){
        stack.push(task);
        numberOftasks++;
    }
    
    public String executeTasks() {
    StringBuilder result = new StringBuilder();
    long totalResponseTime = 0;
    long totalTurnaroundTime = 0;
    long startTime = System.nanoTime();

    while (!stack.isEmpty()) {
        Task task = stack.pop();
        long responseTime = System.nanoTime() - startTime;
        long executionTime = StarterPack.executeTask(task);
        totalTime += executionTime;

        long turnaroundTime = System.nanoTime() - startTime;
        
        totalResponseTime += responseTime;
        totalTurnaroundTime += turnaroundTime;

        // Append results to the StringBuilder
     result.append(String.format("Task: %-25s Response Time: %-15.6f Turnaround Time: %-15.6f%n",
                task.getMethodName(), responseTime/1_000_000_000.0, turnaroundTime/1_000_000_000.0));
        
    }
    long endTime = System.nanoTime();
    result.append("Number of Task: ").append(numberOftasks).append("\n");
    result.append("Total Response Time: ").append(String.format("%.3f s ",totalResponseTime/1_000_000_000.0)).append("\n");
    result.append("Total Turnaround Time: ").append(String.format("%.3f s ",totalTurnaroundTime/1_000_000_000.0)).append("\n");


    // Calculate and append average response time and turnaround time
    if (numberOftasks > 0) {
        long averageResponseTime = totalResponseTime /numberOftasks;
        long averageTurnaroundTime = totalTurnaroundTime / numberOftasks;
        result.append("Average Response Time: ").append(String.format("%.3f s", averageResponseTime/1_000_000_000.0)).append("\n");
        result.append("Average Turnaround Time: ").append(String.format("%.3f s", averageTurnaroundTime/1_000_000_000.0)).append("\n");
    } else {
        result.append("No tasks to calculate average").append("\n");
    }
    result.append("Time taken by Scheduler C: ").append(String.format("%.3f s", (endTime - startTime) / 1_000_000_000.0)).append("\n");

    return result.toString();
}
}

