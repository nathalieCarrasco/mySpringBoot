package cl.generation.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RUTAS ESTATICAS 

@RestController
@RequestMapping("/api")
public class ApiRestController {

	@RequestMapping("/hola")
	public String hola() {
		return "Hola Api";
	}
	
	
	// Ruta dinamica 
	@RequestMapping("/edad/{edad}")
	public String rutaDinamica(@PathVariable("edad")int edad){
		return "capturando edad "+ edad;
	}
	
	//http://localhost:8080/api/nombre/nathalie
	//capturando Nombre
	@RequestMapping("/nombre/{nombre}")
	public String nombre(@PathVariable("nombre")String nombre){
		return "Hola tu nombre es "+ nombre;
	}
	
	// capturar mas de un dato
	@RequestMapping("/fecha/{dia}/{mes}/{año}")
	public String fecha(@PathVariable("dia")int dia,
	@PathVariable("mes")String mes,@PathVariable("año")int año){
		return "Hoola hoy es "+ dia + " "+ mes+ " "+ año;
	}
	//http://localhost:8080/api?productoid=--1// GET 
	//localhost/api/usuario/usuarioId=34
	@RequestMapping("/usuario")
	// @RequestParam sirve para capturar un parametro
	public String parametro(@RequestParam(value="usuarioId", required=false) Integer id  ) {
		//int , long , float = 0
		// Integer, Float,Long .... pueden ser nulos 
		if(id==null) {
			return "parametro no existe ";
		}else {return "parametro por get "+ id;}
		
	}
	
	
	//ESTAMOS CAPTURANDO EL ID Y EL NOMBRE 
	//localhost/api/usuario2/usuarioId=34&nombre=nathy
	@RequestMapping("/usuario2")
	public String parametro2(@RequestParam(value="usuarioId", required=false) Integer id,
			@RequestParam(value="nombre", required=false) String nombre) {
		if(nombre==null) {
			return "parametro no existe en el nombre";
		}else {return "parametro por get "+ id +" el nombre es "+nombre;}
		
	}
    
	
	
}
