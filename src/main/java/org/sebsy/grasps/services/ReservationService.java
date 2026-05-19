package org.sebsy.grasps.services;

import org.sebsy.grasps.CreateReservationDto;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.IClientDao;
import org.sebsy.grasps.daos.ITypeReservationDao;
import org.sebsy.grasps.utils.DateUtils;
import java.time.LocalDateTime;

public class ReservationService implements IReservationService{

    private IClientDao clientDao;
    private ITypeReservationDao typeReservationDao;

    public ReservationService(IClientDao clientDao, ITypeReservationDao typeReservationDao) {
        this.clientDao = clientDao;
        this.typeReservationDao = typeReservationDao;
    }

    @Override
    public Reservation creerReservation(CreateReservationDto reservationDto) {
        LocalDateTime dateReservation = DateUtils.toDate(reservationDto.dateReservation);
        Client client = clientDao.extraireClient(reservationDto.identifiantClient);
        TypeReservation type = typeReservationDao.extraireTypeReservation(reservationDto.typeReservation);
        return client.creerReservation(dateReservation, reservationDto.nbPlaces, type);
    }
}