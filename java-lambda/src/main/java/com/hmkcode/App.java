package com.hmkcode;


public class App implements OnClickListener
{
    public static void main( String[] args ){
        System.out.println( "Running App..." );
        new App().run(); 
    }

    public void run(){
        
        Button myButton = new Button();
        myButton.setName("MyButton");
        
        // 1. implements onClickListener
        //myButton.setOnClickListener(this);
        
        // 2. anonymous class
        /*myButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(Button button) {
				System.out.println(button.getName() +" Clicked! - anonymous class");
			}
		}); */
        
        // 3. lambda
    	OnClickListener lambda = button -> { System.out.println(button.getName()+" Clicked! - lambda"); } ;
    	myButton.setOnClickListener(lambda);
	
    	
        // click the button
    	myButton.click();
    }
    
    
	@Override
	public void onClick(Button button) {
		System.out.println(button.getName() +" Clicked! - implements interface");
		
	}
}
