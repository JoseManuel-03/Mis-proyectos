package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.CentroComercial;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Marca;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Pais;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Tienda;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.CentroComercialRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.MarcaRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.PaisRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.TiendaRepository;
import jakarta.transaction.Transactional;

@Service
public class ComercialServiceImpl implements ComercialService{

	@Autowired
	private CentroComercialRepository ccRepo;
	@Autowired
	private TiendaRepository tiendaRepo;
	@Autowired
	private MarcaRepository marcaRepo;
	@Autowired
	private PaisRepository paisRepo;
	
	
	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		try {
			return paisRepo.findByDescripcionStartingWith(filtro);
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error consultando países", e);
		}
	}

	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		try {
			marcaRepo.save(marca);
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error insertando nueva marca", e);
		}
	}

	@Override
	@Transactional
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		try {
			if (!paisRepo.findById(cc.getPais().getCodigo()).isPresent()) {
				throw new ComercialException("No existe el país del centro comercial: " + cc.getPais());
			}
			// Se podría validar también que existen todas las marcas....
			ccRepo.save(cc);
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error insertando nuevo centro comercial", e);
		}
	}

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		try {
			Optional<CentroComercial> cc = ccRepo.findById(UUID.fromString(uuidCentro));
			if (!cc.isPresent()) {
				throw new NotFoundException("No existe el centro comercial con uuid " + uuidCentro);
			}
			return cc.get();
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error consultando centro comercial", e);
		}
	}

	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		try {
			Optional<Tienda> tienda = tiendaRepo.findById(idTienda);
			if (!tienda.isPresent()) {
				throw new NotFoundException("No existe la tienda con id " + idTienda);
			}
			return tienda.get();
			
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error consultando tienda", e);
		}
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		try {
			tiendaRepo.deleteById(idTienda);
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error borrando tienda", e);
		}
	}

	@Override
	@Transactional
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			ccRepo.deleteById(UUID.fromString(uuidCentro));
		}
		catch(DataAccessException e) {
			throw new ComercialException("Error borrando centro comercial", e);
		}
	}

}
