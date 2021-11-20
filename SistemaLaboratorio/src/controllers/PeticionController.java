package controllers;

import dao.PeticionDAO;
import domains.Peticion;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoPeticion;
import enums.EstadoResultadoPractica;
import services.PeticionService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PeticionController {
    static PeticionController instance=null;

    private PeticionController(){
    }

    public static PeticionController getInstance() {
        if (instance == null) {
            instance = new PeticionController();
        }
        return instance;
    }

    public PeticionDTO AltaPeticion(PeticionDTO p) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            PacienteController pacienteController = PacienteController.getInstance();
            SucursalController sucursalController = SucursalController.getInstance();
            PeticionService peticionService = new PeticionService();

            sucursalController.ObtenerSucursal(p.sucursalID);
            pacienteController.ObtenerPaciente(p.pacienteID);

            p.id = peticionDAO.getLastInsertId() + 1;
            p.estadoPeticion = peticionService.DeterminarEstado(p);
            p.fechaDeEntrega = calcularFechaDeEntrega(p.practicasAsociadas);

            peticionDAO.CrearPeticion(p);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
    
    public boolean BajaPeticion(int peticionID) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();

            //Valido que exista la petición
            PeticionDTO peticionDTO = ObtenerPeticion(peticionID);

            boolean fueBorrado = peticionDAO.BorrarPeticion(peticionID);
            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarPeticion(PeticionDTO p) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            PeticionService peticionService = new PeticionService();
            p.estadoPeticion = peticionService.DeterminarEstado(p);
            p.fechaDeEntrega = calcularFechaDeEntrega(p.practicasAsociadas);

            boolean fueActualizado = peticionDAO.ActualizarPeticion(p);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public PeticionDTO ObtenerPeticion(int PeticionID) throws Exception {
        PeticionDTO p = new PeticionDTO();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            p = peticionDAO.ObtenerPeticion(PeticionID);
            if (Objects.isNull(p)) {
                throw new Exception("La petición no existe");
            }
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public boolean ExistePeticion(int id) throws Exception {
        boolean existe = true;
        if (Objects.isNull(ObtenerPeticion(id))){
            throw new Exception("Petición no existe");
        }
        return existe;
    }
    
	private Date calcularFechaDeEntrega(List<PracticaAsociadaDTO> pa) {
		Date d = new Date();
		int h = ObtenerHoras(pa);
		int dias = h / 12;
		Calendar c = Calendar.getInstance();
		
		c.add(Calendar.DATE, dias);
		d = c.getTime();
	
		return d;
	}
	
	private int ObtenerHoras(List<PracticaAsociadaDTO> pa) {
		PracticaController practicaController = PracticaController.getInstance();
		int h = 0;
        for (PracticaAsociadaDTO p : pa) {
        	try {
				PracticaDTO practica = practicaController.ObtenerPractica(p.practicaID);
				
				h += practica.horasEsperaResultado;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		
		return h;
	}


    public PracticaAsociadaDTO ObtenerPracticaAsociada(int peticionID, int id) throws Exception {
    	PracticaAsociadaDTO p = null;
		try {
			List<PracticaAsociadaDTO> pa = ObtenerPeticion(peticionID).practicasAsociadas;
	    	for (PracticaAsociadaDTO practicasAsociada : pa) {
	        	if(practicasAsociada.practicaID == id) {
	        		p = practicasAsociada;
	        	}
	        }
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return p;
    }
    
    public List<PeticionDTO> ObtenerPeticionesCriticas() {
        List<PeticionDTO> peticiones = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obtenerPeticionesCriticas(peticiones);
    }

    public List<PeticionDTO> ObtenerPeticionesDeSucursal(int sucursalID) {
        List<PeticionDTO> peticiones = new ArrayList<>();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(sucursalID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peticiones;
    }

    public List<PeticionDTO> ObtenerPeticionesDelPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticionesDePaciente(pacienteID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return peticiones;
    }

    public List<PeticionDTO> ObtenerPeticionesPendientesPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            if (p.estadoPeticion == EstadoPeticion.Activa) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<PeticionDTO> ObtenerPeticionesCompletasPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            if (p.estadoPeticion == EstadoPeticion.Finalizada) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<PeticionDTO> ObtenerPeticionesCriticasPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            if (p.estadoPeticion == EstadoPeticion.RetirarPorSucursal) {
                resultado.add(p);
            }
        }
        return obtenerPeticionesCriticas(resultado);
    }

    private List<PeticionDTO> obtenerPeticionesCriticas(List<PeticionDTO> peticiones) {
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            for (PracticaAsociadaDTO paDTO : p.practicasAsociadas) {
                try {
                    if (paDTO.resultadoPractica.equals(EstadoResultadoPractica.Critico)) {
                        resultado.add(p);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public List<PeticionDTO> ObtenerPeticionesFinalizadas() {
        List<PeticionDTO> ps = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<PeticionDTO> peticiones = peticionDAO.ObtenerPeticiones();
            for (PeticionDTO peticionDTO : peticiones) {
                Peticion peticion = new Peticion(peticionDTO);
                if (peticion.EstaFinalizadas()) {
                    ps.add(peticionDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    public List<PeticionDTO> ObtenerPeticionesPendientes() {
        List<PeticionDTO> ps = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<PeticionDTO> peticiones = peticionDAO.ObtenerPeticiones();
            for (PeticionDTO peticionDTO : peticiones) {
                Peticion peticion = new Peticion(peticionDTO);
                if (peticion.EstaActiva()) {
                    ps.add(peticionDTO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    public List<PeticionDTO> ObtenerTodasLasPeticiones() {
        List<PeticionDTO> ps = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            ps = peticionDAO.ObtenerPeticiones();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }
}
