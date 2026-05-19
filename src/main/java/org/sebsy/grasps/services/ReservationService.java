public class ReservationService {

    private ClientDao clientDao = new ClientDao();
    private TypeReservationDao typeReservationDao = new TypeReservationDao();

    public Reservation creerReservation(CreateReservationDto reservationDto) {

        LocalDateTime dateReservation = DateUtils.toDate(reservationDto.dateReservation);
        Client client = clientDao.extraireClient(reservationDto.identifiantClient);
        TypeReservation type = typeReservationDao.extraireTypeReservation(reservationDto.typeReservation);

        return client.creerReservation(dateReservation, reservationDto.nbPlaces, type);
    }
}