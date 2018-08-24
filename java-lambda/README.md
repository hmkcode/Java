Using Lambda to Implement Functional Interface Method
====================================================

- We have a *virtual* `Button` that when clicked will call an abstract method **onClick()** of a listener interface `OnClickListener`.
- We need to implement the **onClick()** so that it prints the `Button` name. 

`OnClickListener.java`

```java
package com.hmkcode;

public interface OnClickListener {
	void onClick(Button button);
}
```

`Button.java`

```java
package com.hmkcode;

public class Button {

	private OnClickListener onClickListener;
	private String name;

	// click the button
	public void click(){
		this.onClickListener.onClick(this);
	}
	
	// getters & setters
}
```

- We have three ways to achieve that:
 1. **Implement** `OnClickListener` and override **onClick()** method.
 2. Use `OnClickListener` as an anonymous class.
 3. Use Lambda.
 
- Our main class is `App.java`

```java
package com.hmkcode;

public class App
{
    public static void main( String[] args ){
        System.out.println( "Running App..." );
        new App().run(); 
    }

    public void run(){
        
        Button myButton = new Button();
        myButton.setName("MyButton");
        
        // 1. implements onClickListener
        
        // 2. anonymous class

        // 3. lambda
    	
	
    	// click the button
    	myButton.click();
    }
}
```

### 1. **Implement** `OnClickListener` and override **onClick()** method

```java
public class App implements OnClickListener
{
    public static void main( String[] args ){...}

    public void run(){
        
        Button myButton = new Button();
        myButton.setName("MyButton");
        
        // 1. implements onClickListener
        myButton.setOnClickListener(this);
        
        // click the button
    	myButton.click();
    }
	
	@Override
	public void onClick(Button button) {
		System.out.println(button.getName() +" Clicked! - implements interface");
		
	}
}
```

### 2. Use `OnClickListener` as an anonymous class

```java
public class App
{
    public static void main( String[] args ){...}

    public void run(){
        
        Button myButton = new Button();
        myButton.setName("MyButton");
                
        // 2. anonymous class
        myButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(Button button) {
				System.out.println(button.getName() +" Clicked! - anonymous class");
			}
		}); 
        
        // click the button
    	myButton.click();
    }
}
```

### 3. Use Lambda

```java
public class App
{
    public static void main( String[] args ){...}

    public void run(){
        
        Button myButton = new Button();
        myButton.setName("MyButton");

        // 3. lambda
    	OnClickListener lambda = button -> { System.out.println(button.getName()+" Clicked! - lambda"); } ;
    	myButton.setOnClickListener(lambda);
		
        // click the button
    	myButton.click();
    } 
}
```

*To run the code use*

```
java-lambda>mvn exec:java
```

