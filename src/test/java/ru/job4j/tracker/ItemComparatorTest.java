package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemComparatorTest {
    @Test
    public void testComparableItem() {
        List<Item> items = new ArrayList<Item>();
        Item bug1 = new Item("Bug1");
        Item bug2 = new Item("Bug2");
        Item bug3 = new Item("Bug3");
        items.add(bug3);
        items.add(bug1);
        items.add(bug2);
        List<Item> excepted = new ArrayList<Item>();
        excepted.add(bug1);
        excepted.add(bug2);
        excepted.add(bug3);
        Collections.sort(items);
        assertThat(excepted).isEqualTo(items);
    }

    @Test
    public void testComparatorAscByName() {
        List<Item> items = new ArrayList<Item>();
        Item bug1 = new Item("Bug1");
        Item bug2 = new Item("Bug2");
        Item bug3 = new Item("Bug3");
        items.add(bug3);
        items.add(bug1);
        items.add(bug2);
        List<Item> excepted = new ArrayList<Item>();
        excepted.add(bug1);
        excepted.add(bug2);
        excepted.add(bug3);
        items.sort(new ItemAscByName());
        assertThat(excepted).isEqualTo(items);
    }

    @Test
    public void testComparatorDescByName() {
        List<Item> items = new ArrayList<Item>();
        Item bug1 = new Item("Bug1");
        Item bug2 = new Item("Bug2");
        Item bug3 = new Item("Bug3");
        items.add(bug3);
        items.add(bug1);
        items.add(bug2);
        List<Item> excepted = new ArrayList<Item>();
        excepted.add(bug3);
        excepted.add(bug2);
        excepted.add(bug1);
        items.sort(new ItemDescByName());
        assertThat(excepted).isEqualTo(items);
    }
}
