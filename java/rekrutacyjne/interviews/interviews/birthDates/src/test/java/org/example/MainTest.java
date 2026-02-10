package org.example;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private Main main;
    @Test
    public void shouldBe1908and1909ReturnValue(){
        //given
        var input = new ArrayList<Person>();
        input.add(new Person(1908,1909));
        main = new Main();
        //when
        var result = main.maxPeopleYears(input);
        var resultStream = main.maxPeopleYearsStream(input);
        //then
        assertEquals(List.of(1908,1909),result);
        assertEquals(List.of(1908,1909),resultStream);
    }
    @Test
    public void shouldBe1909ReturnValue(){
        //given
        var input = new ArrayList<Person>();
        input.add(new Person(1908,1909));
        input.add(new Person(1909,1909));
        main = new Main();
        //when
        var result = main.maxPeopleYears(input);
        var resultStream = main.maxPeopleYearsStream(input);
        //then
        assertEquals(List.of(1909),result);
        assertEquals(List.of(1909),resultStream);
    }
    @Test
    public void shouldBeStill1909ReturnValue(){
        //given
        var input = new ArrayList<Person>();
        input.add(new Person(1902,1999));
        input.add(new Person(1908,1909));
        input.add(new Person(1909,1909));
        main = new Main();
        //when
        var result = main.maxPeopleYears(input);
        var resultStream = main.maxPeopleYearsStream(input);
        //then
        assertEquals(List.of(1909),result);
        assertEquals(List.of(1909),resultStream);
    }
}