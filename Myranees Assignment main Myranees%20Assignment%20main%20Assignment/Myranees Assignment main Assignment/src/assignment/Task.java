/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Task {
    private String methodName;
    private String inputType;
    private String input;

    public Task(String methodName, String inputType, String input) {
        this.methodName = methodName;
        this.inputType = inputType;
        this.input = input;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getInputType() {
        return inputType;
    }

    public String getInput() {
        return input;
    }
    
    
}
