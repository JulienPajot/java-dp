package org.sebsy.grasps;

public class CreateReservationDto {

    private String identifiantClient;
    private int nbPlaces;
    private String dateReservation;
    private String typeReservation;

    public CreateReservationDto(String identifiantClient, int nbPlaces, String dateReservation, String typeReservation) {
        this.identifiantClient = identifiantClient;
        this.nbPlaces = nbPlaces;
        this.dateReservation = dateReservation;
        this.typeReservation = typeReservation;
    }

    public String getIdentifiantClient() { return identifiantClient; }
    public int getNbPlaces() { return nbPlaces; }
    public String getDateReservation() { return dateReservation; }
    public String getTypeReservation() { return typeReservation; }
}