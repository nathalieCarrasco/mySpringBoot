package cl.generation.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Auto;
import cl.generation.web.services.AutoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
        @Autowired
		AutoServiceImpl autoServiceImpl; 
        
        
	@GetMapping("")
	public String home(Model model) {
		// con model traspasamos info hacia la vista 
		// Obtener y almacenar en variable 
		List<Auto> listaAutos = autoServiceImpl.listarAutos();
		
		// pasar lista de autos 
		model.addAttribute("autos", listaAutos);
		
		List<Auto> listaSelectAutos= autoServiceImpl.listarAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);

		return "home.jsp";
	}
	
	@PostMapping("")
	public String filtrar(@RequestParam("autoSeleccionado") Long id, Model model) {
		List<Auto> listaAutos= new ArrayList<Auto>();//lista vacia
		Auto auto = autoServiceImpl.obtenerAuto(id);
		listaAutos.add(auto);//agrego el auto a la lista
		model.addAttribute("autos", listaAutos);//pasar lista de autos al jsp
		// lista para el selector 
		List<Auto> listaSelectAutos= autoServiceImpl.listarAutos();
		model.addAttribute("listaSelectAutos", listaSelectAutos);

		return "home.jsp";
	}

}