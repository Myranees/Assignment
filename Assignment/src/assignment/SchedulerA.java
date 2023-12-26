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
        long totalResponseTime = 0;
        long totalTurnaroundTime = 0;
        long startTime = System.nanoTime();

        while (!queue.isEmpty()) {
            Task task = queue.dequeue();
            long responseTime = System.nanoTime()-startTime;
            long executionTime = StarterPack.executeTask(task);
            totalTime += executionTime;

            long turnaroundTime = System.nanoTime()-startTime;

            totalResponseTime += responseTime;
            totalTurnaroundTime += turnaroundTime;

            // Report or log the results
          System.out.printf("Task: %-20s Response Time: %-10d Turnaround Time: %-10d%n",
        task.getMethodName(), responseTime, turnaroundTime);
        }
        long endTime =System.nanoTime();
        System.out.println("Number of Task: "+numberOftasks);
        System.out.println("Total Response Time: "+totalResponseTime+" nanoseconds");
        System.out.println("Total Turnaround Time: "+totalTurnaroundTime+" nanoseconds");
        
        // Calculate and print average response time and turnaround time
        if(numberOftasks>0){
        long averageResponseTime = totalResponseTime / numberOftasks;
        long averageTurnaroundTime = totalTurnaroundTime /numberOftasks;
        System.out.println("Average Response Time: " + averageResponseTime+" nanoseconds");
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime+" nanoseconds");
    }else{
            System.out.println("No tasks to calculate average");
        }
        System.out.println("Time taken by Scheduler A: "+(endTime-startTime)+" nanoseconds");
}
}
