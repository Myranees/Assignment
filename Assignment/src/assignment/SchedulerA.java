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
    
    public void executeTasks() {
        int totalResponseTime = 0;
        int totalTurnaroundTime = 0;
        

        while (!queue.isEmpty()) {
            Task task = queue.dequeue();
            int responseTime = totalTime;
            int executionTime = (int) StarterPack.executeTask(task);
            totalTime += executionTime;

            int turnaroundTime = totalTime;

            totalResponseTime += responseTime;
            totalTurnaroundTime += turnaroundTime;

            // Report or log the results
          System.out.printf("Task: %-20s Response Time: %-10d Turnaround Time: %-10d%n",
        task.getMethodName(), responseTime, turnaroundTime);
        }
        System.out.println("Number of Task: "+numberOftasks);
        System.out.println("Total Response Time: "+totalResponseTime);
        System.out.println("Total Turnaround Time: "+totalTurnaroundTime);
        
        // Calculate and print average response time and turnaround time
        if(numberOftasks>0){
        int averageResponseTime = totalResponseTime / numberOftasks;
        int averageTurnaroundTime = totalTurnaroundTime /numberOftasks;
        System.out.println("Average Response Time: " + averageResponseTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }else{
            System.out.println("No tasks to calculate average");
        }
}
}
