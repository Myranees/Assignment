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
    
    public void executeTasks() {
        int totalResponseTime = 0;
        int totalTurnaroundTime = 0;
        

        while (!stack.isEmpty()) {
            Task task = stack.pop();
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


