package com.example.ece150finalproject.Model;

import java.util.ArrayList;

public class ApiResponseModel {
    private Contents contents;
    public Contents getContents() {
        return contents;
    }
    public void setContents(Contents contents) {
        this.contents = contents;
    }


    public static class Contents{
        private ArrayList<Quotes> quotes;
        public ArrayList<Quotes> getQuotes() {
            return quotes;
        }
        public void setQuotes(ArrayList<Quotes> quotes) {
            this.quotes = quotes;
        }
    }

    public static class Quotes{
        private String quote;
        private String author;
        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

}
