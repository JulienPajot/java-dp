package org.sebsy.grasps.services;

import org.sebsy.grasps.CreateReservationDto;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.IClientDao;
import org.sebsy.grasps.daos.IReservationDao;
import org.sebsy.grasps.daos.ITypeReservationDao;
import org.sebsy.grasps.utils.DateUtils;
import java.time.LocalDateTime;

public class ReservationService implements IReservationService {

    private IClientDao clientDao;
    private ITypeReservationDao typeReservationDao;
    private IReservationDao reservationDao;

    public ReservationService(IClientDao clientDao, ITypeReservationDao typeReservationDao, IReservationDao reservationDao) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
        this.reservationDao = reservationDao;
    }

    @Override
    public Reservation creerReservation(CreateReservationDto reservationDto) {
        LocalDateTime dateReservation = DateUtils.toDate(reservationDto.getDateReservation());
        Client client = clientDao.extraireClient(reservationDto.getIdentifiantClient());
        TypeReservation type = typeReservationDao.extraireTypeReservation(reservationDto.getTypeReservation());
        Reservation reservation = new Reservation(dateReservation, reservationDto.getNbPlaces());   
        
        reservation.setClient(client);
        calculerTotal(type, client, reservation);

        return reservationDao.sauvegarderReservation(reservation);
    }

    private void calculerTotal(TypeReservation typeReservation, Client client, Reservation reservation) {
        double totalBase = typeReservation.getMontant() * reservation.getNbPlaces();

        if (client.isPremium()) {
            reservation.setTotal(totalBase * (1 - typeReservation.getReductionPourcent() / 100.0));
        } else {
            reservation.setTotal(totalBase);
        }
    }
}