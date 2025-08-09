package com.example.assignment;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AddTest {
@Test
public void addtest()
{
	assertEquals(30,Add.sum(10,20));
}
@Test
public void add1test()
{
	assertEquals(40,Add.sum(10,20));
}
}

