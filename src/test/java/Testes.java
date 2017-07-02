

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;


import org.junit.Test;

public class Testes {
	VulnerableClass inputOutput;
	
	@Test
	public void testeDeScanDeLeitura() throws IOException {
	     inputOutput= new VulnerableClass();

	    String input = "R\nn";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	        
	    inputOutput.vulnerableMethod("ai jesus");

	    assertEquals("R", inputOutput.getScan1());
	    assertEquals("n", inputOutput.getScan2());
	}
	
	@Test
	public void testeDeScanDeEscrita() throws IOException {
	    VulnerableClass inputOutput= new VulnerableClass();

	    String input = "W\njesus que isso?\nn";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	        
	    inputOutput.vulnerableMethod("ai jesus");

	    assertEquals("W", inputOutput.getScan1());
	    assertEquals("n", inputOutput.getScan2());
	}

	@Test
	public void testeDeScanDeErroNaTarefa() throws IOException {
	    VulnerableClass inputOutput= new VulnerableClass();

	    String input = "erro\nn";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	        
	    inputOutput.vulnerableMethod("ai jesus");

	    assertEquals("erro", inputOutput.getScan1());
	    assertEquals("n", inputOutput.getScan2());
	    assertEquals(false, inputOutput.getBool());
	}
	
	@Test(expected = java.io.FileNotFoundException.class)
	public void testeFileNullLeitura() throws IOException{
	    VulnerableClass inputOutput= new VulnerableClass();

	    String input = "R\nn";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	        
	    inputOutput.vulnerableMethod(" ");

	}
	
	@Test(expected = java.io.FileNotFoundException.class)
	public void testeFileNullEscrita() throws IOException{
	    VulnerableClass inputOutput= new VulnerableClass();

	    String input = "W\nn";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	        
	    inputOutput.vulnerableMethod(" ");

	}
	
	
}
