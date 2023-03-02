package com.saksoft.crud.app.seviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.crud.app.exception.IDNotAvailableException;
import com.saksoft.crud.app.model.SaksoftModel;
import com.saksoft.crud.app.repository.SaksoftRepo;
import com.saksoft.crud.app.seviceinterface.SaksoftServiceInterface;

@Service
public class SaksoftServiceImpl implements SaksoftServiceInterface {

	@Autowired
	SaksoftRepo sr;

	@Override
	public SaksoftModel registerData(SaksoftModel model) {

		return sr.save(model);
	}

	@Override
	public Iterable<SaksoftModel> saksoftInfo() {

		return sr.findAll();
	}

	@Override
	public SaksoftModel saksoftInfo(Integer id) {

		Optional<SaksoftModel> op = sr.findById(id);
		if (op.isPresent()) {
			SaksoftModel sm = op.get();

			return sm;

		} else {
			
				throw new IDNotAvailableException(" Requested Mention ID Not found..!!");
				
				}
	}

	@Override
	public SaksoftModel updateData(Integer id, SaksoftModel smodel) {

		Optional<SaksoftModel> optional = sr.findById(id);
		if (optional.isPresent()) {
			SaksoftModel sm = optional.get();

			sm.setFirstName(smodel.getFirstName());
			sm.setLastName(smodel.getLastName());
			sm.setEmail(smodel.getEmail());
			sm.setAge(smodel.getAge());

			return sr.save(sm);
		} else {
			throw new IDNotAvailableException(" Requested Mention ID Not found..!!");
		}
	}

	@Override
	public SaksoftModel removeData(Integer id) {
		
					Optional<SaksoftModel> optional = sr.findById(id);
					if(optional.isPresent())
					{
							SaksoftModel sm = optional.get();
							
							sr.deleteById(id);
					}else
					{
						throw new IDNotAvailableException(" Requested Mention ID Not found..!!");
					}
					return null;
	}

}
