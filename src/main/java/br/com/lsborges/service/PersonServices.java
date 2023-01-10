package br.com.lsborges.service;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lsborges.DTO.Config.Request.RequestPerson;
import br.com.lsborges.DTO.PersonMapper.PersonMapper;
import br.com.lsborges.model.EntidadeEndereco;
import br.com.lsborges.model.EntidadeEnderecoPrincipal;
import br.com.lsborges.model.EntidadePessoa;
import br.com.lsborges.model.respository.EndereçoRepository;
import br.com.lsborges.model.respository.PRepository;
@Service
public class PersonServices {
	
	@Autowired
	private PRepository personRepository;
	
	@Autowired
	private EndereçoRepository enderecoRepository;
	
	@Autowired
	public PersonMapper mapper;
	
	 /**/
	public RequestPerson createPerson(RequestPerson request) {
		EntidadePessoa pessoa = mapper.toPerson(request);
		personRepository.save(pessoa);
		return request;
	}
	/**/
	public Optional<EntidadePessoa> findById(Long id) throws Exception {
		return personRepository.findById(id);
		}
	/**/
	public List<EntidadePessoa> findAll(){
		enderecoRepository.findAll();
		return personRepository.findAll();
	}	
	/**/
	/*public ResponsePerson uptade(ResponsePerson person, Long id) throws Exception {
        EntidadePessoa personAtua = findById(id).get();
        BeanUtils.copyProperties(person, personAtua, "id");
        return mapper.toPersonResponse(personAtua);
    }*/
	
	public ResponseEntity<EntidadePessoa> update(Long id, RequestPerson request){
		  EntidadePessoa pessoa = mapper.toPerson(request);
		  EntidadePessoa newPerson = personRepository.findById(id).get();
			newPerson.setName(pessoa.getName());
			newPerson.setBirthDate(pessoa.getBirthDate());
			newPerson.setAddress(pessoa.getAddress());
			newPerson.setMainAddress(pessoa.getMainAddress());
			return new ResponseEntity<EntidadePessoa>(personRepository.save(newPerson), HttpStatus.OK);
	}
	/**/
	public List<EntidadeEndereco> createNewAddress(Long id, List<EntidadeEndereco> request) {
		Optional<EntidadePessoa> pessoa = personRepository.findById(id);
		EntidadePessoa newAddress = pessoa.get();
		newAddress.setAddress(request);
		return request; 
	}
	/**/
	public List<EntidadeEndereco> listAddres(Long id){
		EntidadePessoa buscando = personRepository.findById(id).get();
		return buscando.getAddress(); 
	}
	/**/
	public EntidadeEnderecoPrincipal searchMainAddress(Long id) {
		EntidadePessoa buscando = personRepository.findById(id).get();
		return buscando.getMainAddress();
	}
	/**/
	public void deletePerson(Long id) {
		personRepository.deleteById(id);	
	}
}	