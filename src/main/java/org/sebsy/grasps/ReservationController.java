package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.IReservationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {

    private IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param reservationDto contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(CreateReservationDto reservationDto) {
        return reservationService.creerReservation(reservationDto);
    }

}
