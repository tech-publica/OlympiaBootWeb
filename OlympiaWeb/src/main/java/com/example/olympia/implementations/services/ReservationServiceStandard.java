package com.example.olympia.implementations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.olympia.abstractions.daos.ClientDAO;
import com.example.olympia.abstractions.daos.CourtDAO;
import com.example.olympia.abstractions.daos.ReservationDAO;
import com.example.olympia.abstractions.services.ReservationService;
import com.example.olympia.entities.Reservation;

@Service
public class ReservationServiceStandard  implements ReservationService{

	@Autowired
	ReservationDAO reservationDao;
	@Autowired
	ClientDAO clientDao;
	@Autowired
	CourtDAO courtDao;
	
	@Override
	@Transactional
	public Iterable<Reservation> list() {
		return reservationDao.allReservations();
	}

	@Override
	@Transactional
	public void save(Reservation reservation) {
		reservationDao.add(reservation);
		
	}

	@Override
	@Transactional
	public Reservation reservationById(int id) {
		return reservationDao.findById(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		reservationDao.delete(id);
		
	}

	@Override
	@Transactional
	public void update(Reservation reservation) {
		reservationDao.update(reservation);
		
	}

}
