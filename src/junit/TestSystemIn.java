package junit;

import java.io.IOException;

import org.junit.Test;

public class TestSystemIn {

	@Test
	public void AcceptIn() throws IOException{
		System.out.print("Enter a Char:");
		char i = (char)System.in.read();
		System.out.println("your input char is:"+i);
	}
}
