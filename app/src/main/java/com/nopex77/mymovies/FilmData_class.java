package com.nopex77.mymovies;

import java.util.ArrayList;

public class FilmData_class {
    private static String[] filmNames = {
            "TWD Season 1",
            "TWD Season 2",
            "TWD Season 3",
            "TWD Season 4",
            "TWD Season 5",
            "TWD Season 6",
            "TWD Season 7",
            "TWD Season 8",
            "TWD Season 9",
            "TWD Season 10"
    };

    private static String[] filmDetails = {
            "Episode 1 sampai 6",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16",
            "Episode 1 sampai 16"
    };

    private static int[] filmImages = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
            R.drawable.s7,
            R.drawable.s8,
            R.drawable.s9,
            R.drawable.s10
    };

    static ArrayList<Film_class> getListData() {
        ArrayList<Film_class> list = new ArrayList<>();
        for (int position = 0; position < filmNames.length; position++) {
            Film_class film = new Film_class();
            film.setNama(filmNames[position]);
            film.setRincian(filmDetails[position]);
            film.setFoto(filmImages[position]);
            list.add(film);
        }
        return list;
    }
}
