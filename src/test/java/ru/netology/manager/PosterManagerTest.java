package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    @Test
    public void shouldRemoveIfExists() {
        PosterManager manager = new PosterManager();
        int idToRemove = 1;
        Movie first = new Movie(1, "first", "Horror");
        Movie second = new Movie(2, "second", "Horror");
        Movie third = new Movie(3, "third", "Horror");
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

        assertArrayEquals(expected, actual);
    }
}