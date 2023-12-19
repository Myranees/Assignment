/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestMain{

    public static void main(String[] args) throws FileNotFoundException {
       Scanner sc = new Scanner(new FileInputStream("C:\\Users\\ANISMUNIRAH\\Downloads\\tasks.txt"));
       
       SchedulerA systemA = new SchedulerA();
       SchedulerB systemB = new SchedulerB();
       SchedulerC systemC = new SchedulerC();
       
       while(sc.hasNextLine()){
           String line = sc.nextLine();
           String[] parts = line.split(" ");
           Task task = new Task(parts[0],parts[1],parts[2]);
           systemA.addTask(task);
           systemB.addTask(task);
           systemC.addTask(task);
       }
        System.out.println("\t\t\t *** Scheduling System A -Queue ***");
        System.out.println("Scheduling System A results: ");
        systemA.executeTasks();
        
        System.out.println();
        
        System.out.println("\t\t\t *** Scheduling System B-LinkedList ***");
        System.out.println("Scheduling System B results: ");
        systemB.executeTasks();
        
        System.out.println();
        
        System.out.println("\t\t\t *** Scheduling System C- Stack ***");
        System.out.println("Scheduling System C results: ");
        systemC.executeTasks();
        
        sc.close();
    }
    
}
