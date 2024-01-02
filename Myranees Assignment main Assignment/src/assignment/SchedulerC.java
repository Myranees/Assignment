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
        result.append(String.format("Task: %-25s Response Time: %-15d Turnaround Time: %-15d%n",
                task.getMethodName(), responseTime, turnaroundTime));
    }
    long endTime = System.nanoTime();
    result.append("Number of Task: ").append(numberOftasks).append("\n");
    result.append("Total Response Time: ").append(totalResponseTime).append(" nanoseconds").append("\n");
    result.append("Total Turnaround Time: ").append(totalTurnaroundTime).append(" nanoseconds").append("\n");

    // Calculate and append average response time and turnaround time
    if (numberOftasks > 0) {
        long averageResponseTime = totalResponseTime / numberOftasks;
        long averageTurnaroundTime = totalTurnaroundTime / numberOftasks;
        result.append("Average Response Time: ").append(averageResponseTime).append(" nanoseconds").append("\n");
        result.append("Average Turnaround Time: ").append(averageTurnaroundTime).append(" nanoseconds").append("\n");
    } else {
        result.append("No tasks to calculate average").append("\n");
    }
    result.append("Time taken by Scheduler C: ").append(endTime - startTime).append(" nanoseconds").append("\n");

    // Return the result as a string
    return result.toString();
}
}


