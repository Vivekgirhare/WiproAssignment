package com.example.assignment;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
public class Divisontest {
	@Test
	public void divtest()
	{
		Division d=new Division();
		assertThrows(IllegalArgumentException.class,()->
		{
			d.div(10,0);
		
		});
	}
}



