Using Lambda to Implement Funtional Interface Method
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

