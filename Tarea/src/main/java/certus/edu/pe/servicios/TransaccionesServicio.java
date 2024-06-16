package certus.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Transacciones;
import certus.edu.pe.repositorios.TransaccionesRepositorio;

@Service
@Transactional
public class TransaccionesServicio {

    @Autowired
    private TransaccionesRepositorio repositorio;

    public TransaccionesServicio() {}

    public Transacciones crear(Transacciones transacciones) {
        return repositorio.save(transacciones);
    }

    public List<Transacciones> buscarTodo() {
        return (ArrayList<Transacciones>) repositorio.findAll();
    }

    public Transacciones buscarPorId(Integer id) {
        Optional<Transacciones> transaccionOpt = repositorio.findById(id);
        if (transaccionOpt.isPresent()) {
            return transaccionOpt.get();
        } else {
            return null; // O lanza una excepción personalizada si es necesario
        }
    }

    public Transacciones actualizar(Transacciones transaccionesActualizar) {
        Optional<Transacciones> transaccionOpt = repositorio.findById(transaccionesActualizar.getIdTransacciones());
        if (transaccionOpt.isPresent()) {
            Transacciones transaccionActual = transaccionOpt.get();
            transaccionActual.setTipo(transaccionesActualizar.getTipo());
            transaccionActual.setFecha(transaccionesActualizar.getFecha());
            transaccionActual.setUsuario(transaccionesActualizar.getUsuario());
            transaccionActual.setHora(transaccionesActualizar.getHora());

            return repositorio.save(transaccionActual); // Actualiza la información en la base de datos
        } else {
            return null; // O lanza una excepción personalizada si es necesario
        }
    }

    public void eliminarFunciones(Integer id) {
        repositorio.deleteById(id);
    }
}
