package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// Logica de manipulacion de datos C R U D 
	
	//cuando pasamos un findby debe ser el nombre del objeto a buscar
	Usuario findByCorreo(String correo);
	Usuario findByNick(String nick);

}
