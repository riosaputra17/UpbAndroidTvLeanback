package com.pelitabangsa.upbandroidtv;

import java.util.List;

public class DataModel {
    public List<Result> result;

    public static class Result {
        public List<Detail> details;
        public int id;
        public String title;

        public static class Detail {
            public String backdrop_path;
            public int id;
            public String description;
            public String poster_path;
            public String title;
            public boolean video;
        }
    }
}