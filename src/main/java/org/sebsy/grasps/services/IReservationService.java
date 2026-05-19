package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.CreateReservationDto;

public interface IReservationService {
    Reservation creerReservation(CreateReservationDto reservationDto);
}