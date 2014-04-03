Coding Standards
=====

In the interest of conformity, developers are required to adhere to the compliance standards for source code.

While compliance standards may vary widely between languages, it is advised that developers follow the acceptable coding and formatting guidelines on a language-by-language basis.

```java
public class Stark {
	private static String motto = "Winter is Coming.";
	private String name;
	private int age;

	public Stark(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getMotto() {
		return motto;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
```

Above is an example of a class and its constructor in Java. There are a number of things that can be seen from this code:  
1. The opening bracket (`{`) is on the same line as the declaring code, as per Java conventions.  
2. The class object follows the principle of least privilege. The variables are all declared `private` and can only be accessed via getter methods.  
3. Variables that will remain the same across all instances are rightly declared `static` to conserve memory.  
4. The closing bracket (`}`) is on the same indentation as its declaring line.
5. The method names are in camelBack case, as is Java convention.