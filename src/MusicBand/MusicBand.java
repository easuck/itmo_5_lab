package MusicBand;

import java.time.ZonedDateTime;

public class MusicBand {

    private Long id;
    private static long idCounter = 0;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Integer numberOfParticipants;
    private Integer singlesCount;
    private MusicGenre genre;
    private Album bestAlbum;

    public MusicBand(String name, Coordinates coordinates, Integer numberOfParticipants,
                     Integer singlesCount, MusicGenre genre, Album bestAlbum) {
        id = idCounter++;
        this.name = name;
        this.coordinates = coordinates;
        creationDate = ZonedDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.singlesCount = singlesCount;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }

    public MusicBand(){};

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception{
        if (name == null || name.isEmpty()) throw new Exception();
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) throws Exception {
        if (coordinates == null) throw new Exception();
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) throws Exception{
        if (numberOfParticipants <= 0) throw new Exception();
        this.numberOfParticipants = numberOfParticipants;
    }

    public Integer getSinglesCount() {
        return singlesCount;
    }

    public void setSinglesCount(Integer singlesCount) throws Exception{
        if (singlesCount == null || singlesCount <= 0) throw new Exception();
        this.singlesCount = singlesCount;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) throws Exception{
        if (genre == null) throw new Exception();
        this.genre = genre;
    }

    public Album getBestAlbum() {
        return bestAlbum;
    }

    public void setBestAlbum(Album bestAlbum) throws Exception{
        if (bestAlbum == null) throw new Exception();
        this.bestAlbum = bestAlbum;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", singlesCount=" + singlesCount +
                ", genre=" + genre +
                ", bestAlbum=" + bestAlbum +
                '}';
    }
}