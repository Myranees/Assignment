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
    
    public void executeTasks() {
        int totalResponseTime = 0;
        int totalTurnaroundTime = 0;
        

        while (!linkedList.isEmpty()) {
            Task task = linkedList.removeFirst();
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
