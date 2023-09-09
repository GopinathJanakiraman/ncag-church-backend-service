package in.ncag.church.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ncag.church.model.Carecell;
import in.ncag.church.repository.CarecellRepository;
import in.ncag.church.service.CarecellService;

@Service
public class CarecellImpl implements CarecellService{

	@Autowired
	CarecellRepository carecellRepository;
	@Override
	public List<Carecell> findAll() {
		return carecellRepository.findAll();
	}

}
