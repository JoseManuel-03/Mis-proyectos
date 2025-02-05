package ceu.dam.ad.api.ejemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceu.dam.ad.api.ejemplo.model.Coche;
import ceu.dam.ad.api.ejemplo.repository.CocheRepository;

@Service
public class CocheService {
	
	@Autowired
	private CocheRepository repository;
	
	public Coche consultarCoche(Long id) throws CocheNotFoundException {
		Optional<Coche> cocheOp = repository.findById(id);
		if (cocheOp.isEmpty()) {
			throw new CocheNotFoundException("No existe coche con el id indicado");
		}
		return cocheOp.get();
	}
	
	public List<Coche> buscarCoches(String filtroMarca){
		return repository.findByMarcaContaining(filtroMarca);
	}
	
	@Transactional
	public Coche crearCoche(Coche coche) {
		return repository.save(coche);
	}
	
	@Transactional
	public Coche actualizarCoche(Coche coche) throws CocheNotFoundException {
		consultarCoche(coche.getId());
		return repository.save(coche);
	}
	
	@Transactional
	public void borrarCoche(Long id) throws CocheNotFoundException {
		consultarCoche(id);
		repository.deleteById(id);
	}
	
	
	
}
