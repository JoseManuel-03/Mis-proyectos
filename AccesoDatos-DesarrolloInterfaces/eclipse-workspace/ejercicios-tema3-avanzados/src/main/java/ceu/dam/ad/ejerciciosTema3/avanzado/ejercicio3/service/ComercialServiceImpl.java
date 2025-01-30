package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.service;

import java.util.ArrayList;
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
public class ComercialServiceImpl implements ComercialService {
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private MarcaRepository marcaRepository;
	@Autowired
	private CentroComercialRepository centroComercialRepository;
	@Autowired
	private TiendaRepository tiendaRepository;

	//fetch
	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		try {
			return paisRepository.findByDescripcionStartsWith(filtro);

		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}

	}


	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		try {
			marcaRepository.save(marca);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}

	}

//cascade
	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		try {

			

			if (paisRepository.findById(cc.getPais().getCodigo()).isEmpty()) {
				paisRepository.save(cc.getPais());
			}

			centroComercialRepository.save(cc);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}
	}
	/*
	
	public void insertarPaises(List<Pais>paises) {      Ejemplo si falla alguno ,continua con los demas, (no es transactional)
		for (Pais pais : paises) {
			try {
				paisRepository.save(pais);
			} catch (DataAccessException e) {
					
			}
		}
	}*/
	
	


	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		try {
			UUID uuidNuevo = UUID.fromString(uuidCentro);
			Optional<CentroComercial> centroComercial = centroComercialRepository.findById(uuidNuevo);

			if (!centroComercial.isPresent()) {
				throw new NotFoundException("Error centro comercial no encontrado ");
			}

			return centroComercial.get();

		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar centro comercial", e);
		}
	}


	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		try {
			Optional<Tienda> tiendaOpt = tiendaRepository.findById(idTienda);
			if (!tiendaOpt.isPresent()) {
				throw new NotFoundException("Error consultar tienda, no encontrado ");
			}
			Tienda tienda = tiendaOpt.get();

			return tienda;
		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar tienda", e);
		}
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		try {
			tiendaRepository.deleteById(idTienda);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar tienda", e);
		}

	}


	@Override
	@Transactional
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			UUID uuidNuevo = UUID.fromString(uuidCentro);
			centroComercialRepository.deleteById(uuidNuevo);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar CentroComercial", e);
		}
	}

}
