package edu.umb.cs680.hw01;

public class Calculator {
	
    public float multiply(float inputNumber1, float inputNumber2) {
        return inputNumber1 * inputNumber2;
    }
    
    public float divide(float inputNumber1, float inputNumber2) {
        if(inputNumber2==0){
           throw new IllegalArgumentException("division by zero"); 
        }        
        return inputNumber1/inputNumber2;
    }
    
}