
Ques-3
Description:

Create 10 different examples according to your choice for following 
1. Java 8 – Lambda Expression
2. Java 8 – Method references 
3. Java 8 – Functional interfaces 
4. Java 8 – Interface changes: Default and static methods 
5. Java 8 – Streams 
6. Java 8 – Stream filter
7. Java 8 – forEach()
8. Java 8 – Collectors class with example 
9. Java 8 – StringJoiner class with example
10. Java 8 – Optional class with example
=============================================================
=======================1============
package com.godigit.lambdaEx;

import java.util.ArrayList;

public class LambdaFunctionsEx {

	public static void main(String[] args) {
	ArrayList<Integer> arr= new ArrayList<Integer>();
             //adding elements
	arr.add(1);
	arr.add(11);
	arr.add(13);
	arr.add(14);
	arr.add(16);
        //printing values
	arr.forEach(n->System.out.println(n));
	System.out.println("New Line=");
	arr.forEach(n->
	{
		if(n%2==0)
		{
			System.out.println(n);
		}
	});
	}
}
 

================================2===========
package com.godigit.lambdaEx;
//creating an interface
interface Details
{
	Detail getDetails(String name);
}
class Detail
{
	Detail(String name)
	{
		System.out.println(name);
	}
}
public class MethodReferenceConstructor {
public static void main(String[] args)
{
//calling method by constructor refernce
	Details Tania= Detail::new;
	Tania.getDetails("Tania");
}
}
 
==============================================
package com.godigit.lambdaEx;
interface InstanceCall
{
	void call();
}
public class MethodReferenceInstance {
public void calling()
{
	int  a=3;
	int square=1;
	square=a*a;
	if(square==9)
	{
	System.out.println("That's the perfect square");
}
	else
	{
		System.out.println("Something is wrong");
	}
}
 
=======================================
public static void main(String[] args)
{
	MethodReferenceInstance M=new MethodReferenceInstance();
	//calling by reference method
	InstanceCall I=M::calling;
	I.call();
	//calling by anonymous object
	InstanceCall I1=new MethodReferenceInstance()::calling;
	I1.call();
}
}

package com.godigit.lambdaEx;
interface Calculate
{
	void cal();
}
public class MethodReferenceStatic {
	public static void calculate()
	{
		int x=10;
		int y=20;
		int mul=1;
		mul=x*y;
		System.out.println("Multiplication="+mul);
	}
	public static void main(String[] args)
	{
		Calculate calci=MethodReferenceStatic::calculate;
		calci.cal();
	}
}
 



===============================3===========
package com.godigit.lambdaEx;
@FunctionalInterface

interface Square {
    int calculate(int x);
}
  
public class Test {
    public static void main(String args[])
    {
        int a = 10;
  
        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;
  
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
 


==============================4===========
package com.godigit.lambdaEx;
	interface instanceInterface{  
	    // This is a default method 
	    default void newMethod(){  
	        System.out.println("This is the default method");  
	    }  
                 //This is the static method
	    static void staticMethod(){
	    	System.out.println("This is the static method");
	    }
	    void existingMethod(String str);  
	}  
	public class InstanceMethod implements instanceInterface{ 
		// implementing abstract method
	    public void existingMethod(String str){           
	        System.out.println("String is: "+str);  
	    }  
	    public static void main(String[] args) {  
	    	InstanceMethod obj = new InstanceMethod();
	    	
	    	//calling the default method of interface
	        obj.newMethod();     
	        //calling static method of interface
	        instanceInterface.staticMethod();
	        //calling the abstract method of interface
	        obj.existingMethod("This is the java program"); 
	    }
	    }  
 

=================================5===========
package com.godigit.lambdaEx;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamExample {
public static void main(String[] args)
{
	//count empty strings
	List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
	long count = strList.stream() .filter(x -> x.isEmpty()) .count();
	System.out.printf("List %s has %d empty strings %n", strList, count);
	
	// Convert String to Uppercase and join them using coma
	List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
	String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
	System.out.println(G7Countries);
}
}
=====================6===========
package com.godigit.lambdaEx;
import java.util.*;

public class streamFilterEx 
{
	    // Main driver method
	    public static void main(String[] args)
	    {
	  
	        // Creating a list of Integers
	        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
	  
	        // Getting a stream
	        list.stream()
	            .filter(num -> num % 4 == 0)
	            .forEach(System.out::println);
	    }
	}
 
=============================7===========
package com.godigit.lambdaex;

import java.util.*;

public class LambdaEx {

	public static void main(String[] args) {
	List<String> list=new ArrayList<String>();
            //adding string values
	list.add("Tania");
	list.add("Mehra");
	list.add("from");
	list.add("Shahpurkandi");
	// use of forEach loop
list.forEach(System.out::println);
	}
}
 
==============================8===========
package com.godigit.lambdaex;
import java.util.stream.Collectors;  
import java.util.List;  
import java.util.ArrayList;  
class Salary{  
    int id;  
    String name;  
    int salary;  
      //creating parameterized constructor
    public Salary(int id, String name, int salary) {  
        this.id = id;  
        this.name = name;  
        this.salary = salary;  
    }  
}  
public class CollectorEx
{
    public static void main(String[] args) {  
        List<Salary> salaryList = new ArrayList<Salary>();  
        //Adding Products  
        salaryList.add(new Salary(1,"Tania",25000));  
       salaryList.add(new Salary(2,"Jyoti ",30000));  
        salaryList.add(new Salary(3,"Diksha",28000));  
        salaryList.add(new Salary(4,"Akhil",28000));  
       salaryList.add(new Salary(5,"Ritika",90000));  
        Double sumSalary = salaryList.stream().collect(Collectors.summingDouble(x->x.salary)); 
        // collecting as list  
        System.out.println("Sum of salary: "+sumSalary);  
        Integer sumId =salaryList.stream().collect(Collectors.summingInt(x->x.id));  
        System.out.println("Sum of Empid's: "+sumId);  
    }  
}
 
=========================9============
package com.godigit.lambdaEx;
import java.util.StringJoiner;
public class StringJoinerEx {
	public static void main(String[] args)
	{
                     //creating object of Stringjoiner 
		StringJoiner join= new StringJoiner(",");
		join.add("Tania");
		join.add("Diksha");
		join.add("Ritika");
		System.out.println(join);
                     //creating another object
		StringJoiner join1=new StringJoiner(",","[","]");
		join1.add("Jyoti");
		join1.add("Akhil");
		System.out.println(join1);
                       //merging two strings
		StringJoiner mer= join.merge(join1);
		System.out.println(mer);
	}
}
 =====================10===========
package com.godigit.lambdaEx;
import java.util.Optional;
public class OptionalClass {
	public static void main(String[] args)
	{
		String[] str=new String[4];
		str[2]="My name is Tania";
                       //Creating object of optiona<String>
		Optional<String> O=Optional.of(str[2]);
		System.out.println(O.get());
                        //To check whether String is empty or not
		Optional<String> E= Optional.empty();
		System.out.println(E);
                        //To check whether String is present or not
		System.out.println(O.isPresent());
                          //To generate the hashcode of the string
		System.out.println(O.hashCode());
	}	
	}
 
