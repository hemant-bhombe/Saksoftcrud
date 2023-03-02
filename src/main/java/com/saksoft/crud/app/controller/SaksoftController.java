package com.saksoft.crud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.crud.app.model.SaksoftModel;
import com.saksoft.crud.app.seviceinterface.SaksoftServiceInterface;


@RestController
@RequestMapping("/saksoft")
public class SaksoftController {
	
	@Autowired
	SaksoftServiceInterface ssi;
	
	@PostMapping("/register")
	public ResponseEntity<SaksoftModel> RegisterData(@RequestBody SaksoftModel model)
	{
		SaksoftModel sakmodel= ssi.registerData(model);
		
		return new ResponseEntity<SaksoftModel>(sakmodel, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/info")
	public ResponseEntity<Iterable<SaksoftModel>> saksoftInfo()
	{
		Iterable<SaksoftModel> sakmodel =ssi.saksoftInfo();
		
		return new ResponseEntity<Iterable<SaksoftModel>> (sakmodel, HttpStatus.OK);
	}
	
	@GetMapping("/info/{id}")
	public ResponseEntity<SaksoftModel> saksoftInfo(@PathVariable Integer id)
	{
				SaksoftModel smid=ssi.saksoftInfo(id);
				
				return new ResponseEntity<SaksoftModel>(smid, HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<SaksoftModel> updateData(@PathVariable Integer id, @RequestBody SaksoftModel smodel)
	{
					SaksoftModel smid=ssi.updateData(id, smodel);
					
					return new ResponseEntity<SaksoftModel>(smid, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<SaksoftModel> removeData(@PathVariable Integer id)
	{
				SaksoftModel smid=ssi.removeData(id);
				
				return new ResponseEntity<SaksoftModel>(smid, HttpStatus.OK);
					
	}

}
