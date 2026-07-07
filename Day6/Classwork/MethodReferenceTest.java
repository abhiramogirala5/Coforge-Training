package com.coforge.day6;

import java.util.Optional;

class Employee {
    // Changed to String to make sense for a "Name" field
    private String ename; 
    
    public String getEname() {
        return ename;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }
}

@FunctionalInterface
interface MyReference {
    void showMessage();
}

public class MethodReferenceTest {
    
    void myInstanceMethod() {
        System.out.println("Example for Instance Method Reference");
    }
    
    static void myStaticMethod() {
        System.out.println("Example for Static Method Reference");
    }
    
    MethodReferenceTest() {
        System.out.println("Constructor called");
    }
    
    // Extracted out of main() so it compiles correctly
    public static Optional<Employee> getEmployee() {
        Employee employee = null; 
        return Optional.ofNullable(employee);
    }
    
    // Fixed return type to void so the JVM can execute it
    public static void main(String[] args) {
        
        // 1. Testing your Optional logic
        Optional<Employee> empOpt = getEmployee();
        if (empOpt.isPresent()) {
            System.out.println("Employee found: " + empOpt.get().getEname());
        } else {
            System.out.println("No employee found (Optional is empty).");
        }
        System.out.println("----------------------------------------");

        // 2. Instance Method Reference
        MethodReferenceTest obj = new MethodReferenceTest();
        MyReference reference = obj::myInstanceMethod;
        reference.showMessage();
        
        // 3. Static Method Reference
        reference = MethodReferenceTest::myStaticMethod;
        reference.showMessage();
        
        // 4. Constructor Reference
        reference = MethodReferenceTest::new;
        reference.showMessage(); 
    }
}