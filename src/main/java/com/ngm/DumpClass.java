package com.ngm;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class DumpClass {

    private Class<?> classRef;

    public DumpClass(Class<?> classRef) {
        this.classRef = classRef;
    }

    public void printMethods() {
        
        // Get all public methods, including those inherited from base classes.
        Method[] methods = this.classRef.getMethods();

        // For each Method...
        for (Method method : methods) {
            // Print the method's name, return type, and parameter types.
            System.out.println(
                    "Method: " + method.getName() +
                    ", Return type: " + method.getReturnType().getName() +
                    ", Parameters: " + method.getParameterCount());
            
            // If you want to get specific information about parameters...
            Class<?>[] paramTypes = method.getParameterTypes();
            for(Class<?> paramType : paramTypes) {
                System.out.println("Parameter type: " + paramType.getName());
            }
        }
    }
}