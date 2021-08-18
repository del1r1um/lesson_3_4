package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerWithSetupTest {
    private PosterManager manager = new PosterManager();
    private Movie first = new Movie(1, "first", "Horror");
    private Movie second = new Movie(2, "second", "Horror");
    private Movie third = new Movie(3, "third", "Horror");
    private Movie fourth = new Movie(4, "fourth", "Horror");
    private Movie fifth = new Movie(5, "fifth", "Horror");
    private Movie sixth = new Movie(6, "sixth", "Horror");
    private Movie seventh = new Movie(7, "seventh", "Horror");
    private Movie eighth = new Movie(8, "eighth", "Horror");
    private Movie ninth = new Movie(9, "ninth", "Horror");
    private Movie tenth = new Movie(10, "tenth", "Horror");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void getAll() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllWithCustomLength() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 2;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExistsWithCustomLength() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        int idToRemove = 4;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{sixth, fifth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        manager.add(fourth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithDefaultLength() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithCustomLength() {
        PosterManager manager = new PosterManager(4);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}