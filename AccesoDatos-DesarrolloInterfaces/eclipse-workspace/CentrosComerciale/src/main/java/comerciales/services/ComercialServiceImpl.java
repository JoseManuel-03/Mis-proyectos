package comerciales.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import comerciales.model.CentroComercial;
import comerciales.model.Marca;
import comerciales.model.Pais;
import comerciales.model.Tienda;
import comerciales.repositories.CentroComercialRepository;
import comerciales.repositories.MarcaRepository;
import comerciales.repositories.PaisRepository;
import comerciales.repositories.TiendaRepository;
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

	/**
	 * Debe buscar en BBDD todos los países cuya descripción empiece por el filtro
	 * indicado. Si no se encuentra ninguno, devolverá una lista vacía. Si hay algún
	 * error, lanzará ComercialException
	 */
	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {

		try {

			List<Pais> lista = paisRepository.findByDescripcionStartingWith(filtro);
			if (lista.isEmpty()) {
				List<Pais> nuevalista = new ArrayList<>();
				return nuevalista;
			}

			return lista;

		} catch (DataAccessException e) {
			throw new ComercialException("Error al buscar paises", e);
		}
	}

	/**
	 * Debe insertar la Marca recibida en BBDD. No se insertarán sus centros
	 * comerciales asociados ni su país. Si hay algún error, lanzará
	 * ComercialException
	 */

	@Override
	@Transactional
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
	@Transactional
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {

		try {

			if (!paisRepository.findById(cc.getPais().getCodigo()).isPresent()) {
				paisRepository.save(cc.getPais());
			}

			for (Marca marcas : cc.getMarcas()) {
				if (!marcaRepository.findById(marcas.getCodigo()).isPresent()) {
					marcaRepository.save(marcas);
				}
			}

			centroComercialRepository.save(cc);

		} catch (DataAccessException e) {
			throw new ComercialException("Error al insertar centroComercial", e);
		}

	}

	/**
	 * Consultará un centro comercial a partir de su uuid. Si no existe, lanzará
	 * NotFoundException. La entidad consultada tendrá que traer su país, sus
	 * tiendas y sus marcas. Si hay algún error, lanzará ComercialException
	 */

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {

		try {
			UUID uuidNuevo = UUID.fromString(uuidCentro);
			Optional<CentroComercial> centroComercial = centroComercialRepository.findById(uuidNuevo);

			if (!centroComercial.isPresent()) {
				throw new NotFoundException();
			}

			return centroComercial.get();

		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar centroComercial", e);
		}
	}

	/**
	 * Consultará una tienda a partir de su id. Si no existe, lanzará
	 * NotFoundException. La entidad consultada no traerá ninguna de sus entidades
	 * asociadas. Si hay algún error, lanzará ComercialException
	 */
	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {

		try {

			Optional<Tienda> tienda = tiendaRepository.findById(idTienda);

			if (!tienda.isPresent()) {
				throw new NotFoundException();
			}

			return tienda.get();

		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar tienda", e);
		}
	}

	/**
	 * Debe borrar la tienda con el id indicado. Sólo borrará la tienda, ninguna de
	 * sus entidades asociadas. Si hay algún error, lanzará ComercialException
	 */

	@Override
	@Transactional
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
	@Transactional
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {

		try {
			UUID uuidNuevo = UUID.fromString(uuidCentro);
			centroComercialRepository.deleteById(uuidNuevo);

		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar centroComercial", e);
		}

	}

}
