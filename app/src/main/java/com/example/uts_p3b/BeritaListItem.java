package com.example.uts_p3b;

public class BeritaListItem {

    private String judulBerita;
    private String authors;
    private String isi;
    private int gambarBerita;

    public BeritaListItem(String judulBerita, String authors, String isi, int gambarBerita) {
        this.judulBerita = judulBerita;
        this.authors = authors;
        this.isi = isi;
        this.gambarBerita = gambarBerita;
    }

    public String getJudulBerita() {
        return judulBerita;
    }

    public void setJudulBerita(String judulBerita) {
        this.judulBerita = judulBerita;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public int getGambarBerita() {
        return gambarBerita;
    }

    public void setGambarBerita(int gambarBerita) {
        this.gambarBerita = gambarBerita;
    }
}
