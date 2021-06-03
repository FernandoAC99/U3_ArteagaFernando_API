package utez.edu.mx.U3_ArteagaFernando_API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import utez.edu.mx.U3_ArteagaFernando_API.entity.PersonaEntity;
import utez.edu.mx.U3_ArteagaFernando_API.service.PersonaService;


@RestController
@RequestMapping("/app")
public class PersonaControlador {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/persona/all")
	public List<PersonaEntity> list() {
		return personaService.getAll();
	}
	
	@GetMapping("/persona/one/{id}")
	public PersonaEntity edit(@PathVariable long id) {
		return personaService.get(id);
		
	}
	
	@PostMapping("/persona/save")
	public String save(@RequestBody PersonaEntity team) {
		try {
			personaService.save(team);  
			return "Registrado"; 
		}catch(Exception ex){
			return "Error";
		}
		
	}
	
	@PutMapping("/persona/update")
	public String update(@RequestBody PersonaEntity team) {
		try {
			personaService.save(team);
			return "Actualizado";
		}catch(Exception ex){
			return "Error";
		}
		
	}
	
	@GetMapping("/persona/delete/{id}")
	public String delete(@PathVariable long id) {
		try {
			personaService.delete(id);
			return "Eliminado";
		}catch(Exception ex){
			return "Error";
		}
	}
}
