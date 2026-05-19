package org.sebsy.grasps;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {

    /**
     * DAO permettant d'accéder à la table des clients
     */
    private ClientDao clientDao = new ClientDao();

    /**
     * DAO permettant d'accéder à la table des types de réservation
     */
    private TypeReservationDao typeReservationDao = new TypeReservationDao();

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param reservationDto contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(CreateReservationDto reservationDto) {

        LocalDateTime dateReservation = DateUtils.toDate(reservationDto.dateReservation);
        Client client = clientDao.extraireClient(reservationDto.identifiantClient);
        TypeReservation type = typeReservationDao.extraireTypeReservation(reservationDto.typeReservation);

        return client.creerReservation(dateReservation, reservationDto.nbPlaces, type);;
    }

}
