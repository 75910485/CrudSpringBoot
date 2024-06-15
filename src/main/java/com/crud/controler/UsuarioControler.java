package com.crud.controler;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.crud.modelo.Usuario;
import com.crud.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControler {

    @Autowired
    private UsuarioService servicio;
    
    @RequestMapping("/listarTodo")
    public String listarUsuarios(Model model) {
        List<Usuario> listaUsuarios = servicio.buscarTodo();
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "/moduloUsuarios/listarTodo";
    }
    
    @RequestMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/moduloUsuarios/nuevoUsuario";
    }
    
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String crearUsuario(@ModelAttribute("usuario") Usuario usuario) {
        servicio.crear(usuario);
        return "redirect:/usuarios/listarTodo";
    }
    
    @RequestMapping(value = "/actualizar/{id}")
    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("/moduloUsuarios/editarUsuario");
        Optional<Usuario> usuario = servicio.buscarPorId(id);
        mav.addObject("usuario", usuario.orElse(new Usuario()));
        return mav;
    }
    
    @RequestMapping(value = "/eliminar/{id}")
    public String eliminarUsuario(@PathVariable(name = "id") Long id) {
        servicio.borrarPorId(id);
        return "redirect:/usuarios/listarTodo";
    }
}



