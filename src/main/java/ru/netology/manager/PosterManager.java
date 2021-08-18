package ru.netology.manager;

import ru.netology.domain.Movie;

public class PosterManager {
    private Movie[] movies = new Movie[0];
    int resultMoviesLength;
    private int moviesDefault = 10;

    public PosterManager() {
    }

    public PosterManager(int moviesDefault) {
        this.moviesDefault = moviesDefault;
    }

    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] getAll() {
        if (movies.length < moviesDefault) {
            resultMoviesLength = movies.length;
        } else {
            resultMoviesLength = moviesDefault;
        }
        Movie[] result = new Movie[resultMoviesLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }
}