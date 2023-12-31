/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

class Queue<T> {
    private int head;
    private int tail;
    private int maxSize;
    private T array[];
    
    
    public Queue() {
        head=0;
        tail=0;
        this.maxSize=100;
        this.array=(T[])new Object[maxSize];
       
    }
    
    public boolean isEmpty(){
        return tail==0;
    }
    public boolean isFull(){
        return tail >= maxSize;
    }
    public int size(){
        return tail;
    }
    public T peek(){
        if(!isEmpty()){
           return array[head];
        }
        else{
            return null;
        }
    }
    public void enqueue(T value){
       if(!isFull()){
           array[tail]=value;
           tail++;
       } else{
           System.out.println("Queue is full");
       }
    }
    
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        else{
         T temp = array[head]; 
            for (int i = 0; i <tail-1; i++) {
               array[i]=array[i+1];
            }
        array[tail-1]=null;
        tail--;
        return temp;
        }
    }
}
public class SchedulerA{
    
    Queue<Task> queue = new Queue<>();
    private int totalTime =0;
    
     int numberOftasks =0;
    
    public void addTask(Task task){
        
        queue.enqueue(task);
        numberOftasks++;
    }
    
    boolean executedTask = false;
    
    public String executeTasks() {
    StringBuilder result = new StringBuilder();
    long totalResponseTime = 0;
    long totalTurnaroundTime = 0;
    long startTime = System.nanoTime();
    
    while (!queue.isEmpty()) {
       // if(executedTask != false){
        Task task = queue.dequeue();
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
    result.append("Time taken by Scheduler A: ").append(String.format("%.3f s", (endTime - startTime) / 1_000_000_000.0)).append("\n");

    return result.toString();
}
}
