import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Publication> publications;

    public Library() {
        this.publications = new ArrayList<>();

        publications.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925));
        publications.add(new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 1960));
        publications.add(new Book("1984", "George Orwell", "Dystopian", 1949));
        publications.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951));
        publications.add(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy", 1997));
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public void removePublication(Publication publication) {
        publications.remove(publication);
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public List<Publication> getPublicationsByGenre(String genre) {
        List<Publication> publicationsByGenre = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication instanceof Book && ((Book) publication).getGenre().equalsIgnoreCase(genre)) {
                publicationsByGenre.add(publication);
            }
        }
        return publicationsByGenre;
    }

    public List<Publication> getPublicationsByYear(int year) {
        List<Publication> publicationsByYear = new ArrayList<>();
        for (Publication publication : publications) {
            if (publication.getYear() == year) {
                publicationsByYear.add(publication);
            }
        }
        return publicationsByYear;
    }
}

