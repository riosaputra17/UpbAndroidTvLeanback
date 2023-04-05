package com.pelitabangsa.upbandroidtv;

import java.util.List;

public class DataModel {
    public List<Result> result;

    public static class Result {
        public List<Detail> details;
        public int id;
        public String title;

        public static class Detail {
            public boolean adult;
            public String backdrop_path;
            public String first_air_date;
            public List<Integer> genre_ids;
            public int id;
            public String name;
            public List<String> origin_country;
            public String original_language;
            public String original_name;
            public String original_title;
            public String overview;
            public double popularity;
            public String poster_path;
            public String release_date;
            public String title;
            public boolean video;
            public double vote_average;
            public int vote_count;
        }
    }
}