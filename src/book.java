class Book extends Publication {
    private String genre;

    public Book(String title, String author, String genre, int year) {
        super(title, author, year);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
