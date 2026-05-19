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