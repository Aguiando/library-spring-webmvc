package br.com.bpkedu.library_spring_webmvc.controller;


import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar-usuario")
    public String listarUsuario(Model model){
        model.addAttribute("usuario", usuarioService.listarTodos());
        return "usuario/listar-usuario";
    }

    @GetMapping("/{id:\\d+}")
    public String detalharUsuario(@PathVariable Long id, Model model){
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "usuario/detalhar";
    }

    @GetMapping("/novo-usuario")
    public String formularioNovoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuario/novo";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.salvar(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("editar/{id:\\ d+}")
    public String formularioEditarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("Usuario", usuarioService.buscarPorId(id));
        return "redirect:/usuario/listar";
    }

    @GetMapping("/deletar/{id: \\d+}")
    public String deletarUsuario(@PathVariable Long id){
        usuarioService.deletar(id);
        return "redirect:/usuario/listar";
    }
}
