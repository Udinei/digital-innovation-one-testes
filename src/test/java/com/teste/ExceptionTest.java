package com.teste;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
	
	// O Teste vai passar pois a execeção vai ser lançaada, como esperado
	@Test(expected = IndexOutOfBoundsException.class)
	public void empty() {
		new ArrayList<Object>().get(0);
		
	}

	// O Teste falha, pois se espera uma a execeção que nao sera lançaada, como esperado
	@Test(expected = IndexOutOfBoundsException.class)
	public void empty_() {
		List<String> list = new ArrayList<String>();
		
		//list.add("Rodrigo"); // descomentar essa linha para observera que o teste nao passa
		list.get(0);
	
	}
	

	@Rule 
	public ExpectedException thrown = ExpectedException.none();

	// Usando Rule para lancar a exceção 
	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException{
		List<Object> list = new ArrayList<Object>();
		
		// usando Rule antecipando, que pode ser lancada uma excecao, na proxima linha
		// ao uso do Rule (list.get(0)), se essa execption for lancada o teste passou  
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index 0 out of bounds for length 0");
		
		list.get(0);
	}
	
	
	// usando try/ catch para lancar testes de excecoes
	@Test
	public  void testExceptionMessage() {
		try {
			new ArrayList<Object>().get(0);
			fail("Esperado que IndexOutOfBoundsException seja lancada");
			
		}catch(IndexOutOfBoundsException ex){
			assertThat(ex.getMessage(), is("Index 0 out of bounds for length 0"));
			
		}
	}
	
	
}
