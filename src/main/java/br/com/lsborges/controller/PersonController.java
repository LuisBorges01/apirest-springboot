package br.com.lsborges.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.observation.ClientHttpObservationDocumentation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lsborges.DTO.Config.Request.RequestEndereco;
import br.com.lsborges.DTO.Config.Request.RequestPerson;
import br.com.lsborges.DTO.Config.Response.ResponsePerson;
import br.com.lsborges.model.EntidadeEndereco;
import br.com.lsborges.model.EntidadeEnderecoPrincipal;
import br.com.lsborges.model.EntidadePessoa;
import br.com.lsborges.service.PersonServices;
import lombok.Delegate;

@RestController
@RequestMapping("/person")
public class PersonController {
		
	@Autowired
	private PersonServices services;
	
	
	@PostMapping()
    @ResponseStatus(HttpStatus.CREATED)	
	public RequestPerson create(@RequestBody RequestPerson request) {
		return services.createPerson(request);			
	}
	
	@GetMapping("/{id}")
	public Optional<EntidadePessoa> findById(@PathVariable("id") Long id) throws Exception {
		return services.findById(id);
	}
	
	@GetMapping()
	public List<EntidadePessoa> findAll(){
		return services.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EntidadePessoa> update(@RequestBody RequestPerson request, @PathVariable("id") Long id) throws Exception {
		return services.update(id, request);
	}
	
	@PostMapping("/id")
	@ResponseStatus(HttpStatus.OK)
	public List<EntidadeEndereco> createAddress(@PathVariable("id") Long id, @RequestBody List<EntidadeEndereco> request) {
		return services.createNewAddress(id, request);
	}
	
	@GetMapping("/address/{id}")
	public List<EntidadeEndereco> listAddress(@PathVariable("id")Long id ){
		return services.listAddres(id);
	}
	
	@GetMapping("/mainAddress/{id}")
	public EntidadeEnderecoPrincipal searchMainAddress(@PathVariable("id") Long id) {
		return services.searchMainAddress(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable("id")Long id) {
		return;
	}
	
}
