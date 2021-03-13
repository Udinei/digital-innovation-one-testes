package com.teste;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {
	
	@Rule
	public TemporaryFolder tmpFolder = new TemporaryFolder();
	
	@Test
	public void abouldCreateNewFileInTemporaryFolder() throws IOException {
		File created = tmpFolder.newFile("file.txt");
		
		assertTrue(created.isFile()); // verifica se o arquivo foi criado
		assertEquals(tmpFolder.getRoot(), created.getParentFile());
	}
	

}
