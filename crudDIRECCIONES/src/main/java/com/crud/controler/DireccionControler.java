package com.crud.controler;

import com.crud.modelo.Direccion;
import com.crud.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/direcciones")
public class DireccionControler {

    @Autowired
    private DireccionService direccionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("direcciones", direccionService.listarTodas());
        return "modeloDireccion/listarTodo";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("direccion", new Direccion());
        return "modeloDireccion/nuevaDireccion";
    }

    @PostMapping
    public String guardar(@ModelAttribute Direccion direccion) {
        direccionService.guardar(direccion);
        return "redirect:/direcciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Direccion direccion = direccionService.obtenerPorId(id);
        if (direccion != null) {
            model.addAttribute("direccion", direccion);
            return "modeloDireccion/editarDireccion";
        } else {
            return "redirect:/direcciones";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        direccionService.eliminar(id);
        return "redirect:/direcciones";
    }
}
