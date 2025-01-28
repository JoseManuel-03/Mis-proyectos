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

	/**
	 * Debe buscar en BBDD todos los países cuya descripción empiece por el filtro
	 * indicado. Si no se encuentra ninguno, devolverá una lista vacía. Si hay algún
	 * error, lanzará ComercialException
	 */
	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		try {
			List<Pais> listaNueva = new ArrayList<Pais>();
			List<Pais> lista = paisRepository.findByDescripcionStartsWith(filtro);
			if (lista.isEmpty()) {
				return listaNueva;
			}

			return lista;

		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}

	}

	/**
	 * Debe insertar la Marca recibida en BBDD. No se insertarán sus centros
	 * comerciales asociados ni su país. Si hay algún error, lanzará
	 * ComercialException
	 */
	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		try {
			marcaRepository.save(marca);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}

	}

	/**
	 * Debe insertar el Centro Comercial recibido en BBDD. No se insertará su país
	 * ni marcas en ambos casos deben existir previamente. Pero sí se insertará su
	 * lista de tiendas. Si hay algún error, lanzará ComercialException
	 */
	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		try {

			for (Marca marcas : cc.getMarcas()) {
				String codigo = marcas.getCodigo();
				if (marcaRepository.findById(codigo).isEmpty()) {
					marcaRepository.save(marcas);
				}
			}

			if (paisRepository.findById(cc.getPais().getCodigo()).isEmpty()) {
				paisRepository.save(cc.getPais());
			}

			centroComercialRepository.save(cc);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar marca", e);
		}
	}

	/**
	 * Consultará un centro comercial a partir de su uuid. Si no existe, lanzará
	 * NotFoundException. La entidad consultada tendrá que traer su país, sus
	 * tiendas y sus marcas. Si hay algún error, lanzará ComercialException
	 * 
	 * @throws NotFoundException
	 * 
	 */
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

	/**
	 * Consultará una tienda a partir de su id. Si no existe, lanzará
	 * NotFoundException. La entidad consultada no traerá ninguna de sus entidades
	 * asociadas. Si hay algún error, lanzará ComercialException
	 * 
	 * @throws NotFoundException
	 */
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

	/**
	 * Debe borrar la tienda con el id indicado. Sólo borrará la tienda, ninguna de
	 * sus entidades asociadas. Si hay algún error, lanzará ComercialException
	 */
	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		try {
			tiendaRepository.deleteById(idTienda);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar tienda", e);
		}

	}

	/**
	 * Debe borrar el centro comercial con el uuid indicado. Borrará también su
	 * lista de tiendas asociada, pero no el resto de entidades. Si hay algún error,
	 * lanzará ComercialException
	 */
	@Override
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			UUID uuidNuevo = UUID.fromString(uuidCentro);
			centroComercialRepository.deleteById(uuidNuevo);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar CentroComercial", e);
		}
	}

}
