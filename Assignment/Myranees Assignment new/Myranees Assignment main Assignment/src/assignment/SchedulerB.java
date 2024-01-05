/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;


 class Node<T> {
    
    Node<T> next;
    T data;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data=" + data;
    }
 }
 class LinkedList<T>{
   
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head =null;
        this.tail= null;
        this.size=0;
        
    }
    public int getSize(){
        return size;
    }
    
    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    public T removeFirst(){
        if(head !=null){
            T removedData=head.getData();
            head = head.getNext();
            
            if(head==null){
                tail=null;
            }
            size--;
            return removedData;
        }
        return null;
    }
    
    public T removeLast(){
       if(head==null){
           System.out.println("List is empty");
           return null;
       }
       //if have one node only
       if(head.getNext() == null){
           T removedData = head.getData();
           head =null;
           tail = null;
           size--;
           return removedData;
       }
       //traverse to the second last node
       Node<T> current = head;
       while(current.getNext().getNext() != null){
           current=current.getNext();
       }
       T removedData = current.getNext().getData();
       current.setNext(null);
       tail=current;
       size--;
       return  removedData;
    }
    
   public boolean contains(T data){
      Node current = this.head;
      while(current != null){
          if(current.getData() == data){
              System.out.println("Found a match..");
              return true;
          }
          current=current.getNext();
      } 
        System.out.println("null");
        return false;
    }
   public boolean isEmpty(){
       return head == null;
   }
}
public class SchedulerB {
    LinkedList<Task> linkedList = new LinkedList<>();
    private int totalTime =0;
    
     int numberOftasks =0;
    
    public void addTask(Task task){
        linkedList.addFirst(task);
        numberOftasks++;
    }
    
    public String executeTasks() {
    StringBuilder result = new StringBuilder();
    long totalResponseTime = 0;
    long totalTurnaroundTime = 0;
    long startTime = System.nanoTime();

    while (!linkedList.isEmpty()) {
        Task task = linkedList.removeLast();
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
    result.append("Total Response Time: ").append(String.format("%.2f s ",totalResponseTime/1_000_000_000.0)).append("\n");
    result.append("Total Turnaround Time: ").append(String.format("%.2f s ",totalTurnaroundTime/1_000_000_000.0)).append("\n");


    // Calculate and append average response time and turnaround time
    if (numberOftasks > 0) {
        long averageResponseTime = totalResponseTime /numberOftasks;
        long averageTurnaroundTime = totalTurnaroundTime / numberOftasks;
        result.append("Average Response Time: ").append(String.format("%.2f s", averageResponseTime/1_000_000_000.0)).append("\n");
        result.append("Average Turnaround Time: ").append(String.format("%.2f s", averageTurnaroundTime/1_000_000_000.0)).append("\n");
    } else {
        result.append("No tasks to calculate average").append("\n");
    }
    result.append("Time taken by Scheduler B: ").append(String.format("%.2f s", (endTime - startTime) / 1_000_000_000.0)).append("\n");

    return result.toString();
}
}
