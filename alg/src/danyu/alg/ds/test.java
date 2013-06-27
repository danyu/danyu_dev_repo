package danyu.alg.ds;

public class test {

	public static void main(String[] args) {
		System.out.print(new test().Foo());
	}

	public String Foo() {
		try {
			throw new Exception("An Exception ");
			//System.out.print("Inside try ");
		} catch (Exception ex) {
			return ex.getMessage();
		} finally {
			System.out.print("Finally ");
		}
		//return "Outside try ";
	}
}

class MyClass {

}
