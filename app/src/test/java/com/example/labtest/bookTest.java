package com.example.labtest;

import static org.junit.Assert.*;

import org.junit.Test;

public class bookTest {
    @Test
    public void testAddBook(){
        book bookObj = new book();

        bookObj.add_book("a","b","mystery",10);

        bookObj.add_book("c","d","mystery",20);

        assertEquals(30,bookObj.infoObj.units);
    }
}