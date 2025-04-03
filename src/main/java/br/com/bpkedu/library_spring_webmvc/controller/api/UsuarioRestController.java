package br.com.bpkedu.library_spring_webmvc.controller.api;

import br.com.bpkedu.library_spring_webmvc.domain.Livro;
import br.com.bpkedu.library_spring_webmvc.domain.Usuario;
import br.com.bpkedu.library_spring_webmvc.dto.LivroDTO;
import br.com.bpkedu.library_spring_webmvc.dto.UsuarioDTO;
import br.com.bpkedu.library_spring_webmvc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/getAll")
    public List<Usuario> getUsuarios(){
        return usuarioService.listarTodos();
    }

    @PostMapping()
    public ResponseEntity<Usuario> novoUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioDTO.toUsuario(usuarioDTO);

        Usuario saved =  usuarioService.salvar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
