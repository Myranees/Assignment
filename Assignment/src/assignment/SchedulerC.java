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
//    private long startTime;
//    private long endTime;
//    
//    public long startTimer(){
//      return startTime = System.nanoTime();
//    }
//    public long stopTimer(){
//      return endTime=System.nanoTime();
//    }
//    public long getElapsedTime(){
//        return endTime-startTime;
//    }
    
    public void addTask(Task task){
        stack.push(task);
        numberOftasks++;
    }
    
    public void executeTasks() {
        long totalResponseTime = 0;
        long totalTurnaroundTime = 0;
        long startTime = System.nanoTime();

        while (!stack.isEmpty()) {
            Task task = stack.pop();
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
        System.out.println("Total Response Time: "+totalResponseTime +" nanoseconds");
        System.out.println("Total Turnaround Time: "+totalTurnaroundTime+" nanoseconds");
        
        // Calculate and print average response time and turnaround time
        if(numberOftasks>0){
        long averageResponseTime = totalResponseTime / numberOftasks;
        long averageTurnaroundTime = totalTurnaroundTime /numberOftasks;
        System.out.println("Average Response Time: " + averageResponseTime +" nanoseconds");
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime+" nanoseconds");
    }else{
            System.out.println("No tasks to calculate average");
        }
        System.out.println("Time taken by Scheduler C: "+(endTime-startTime)+" nanoseconds");
}
}


