package com.example.demofinalclassvueproject.model;

public class BookInfo {
    private int id;
    private byte[] bookpic;
    private String booktitle;
    private String bookinfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getBookpic() {
        return bookpic;
    }

    public void setBookpic(byte[] bookpic) {
        this.bookpic = bookpic;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookinfo() {
        return bookinfo;
    }

    public void setBookinfo(String bookinfo) {
        this.bookinfo = bookinfo;
    }
}
