package br.uff.ihs.ss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.repository.UsuarioRepository;
import br.uff.ihs.ss.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> result = new ArrayList<>();
        usuarioRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Usuario> findByFilter(Usuario filter) {
        return null;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(Usuario.class, id));
    }

    @Override
    public Usuario create(Usuario Usuario) {
        return usuarioRepository.save(Usuario);
    }

    @Override
    public Usuario update(Long id, Usuario Usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Usuario.class, id));
        usuarioToUpdate.setAtivo(Usuario.getAtivo());
        usuarioToUpdate.setEmail(Usuario.getEmail());
        usuarioToUpdate.setLotacao(Usuario.getLotacao());
        usuarioToUpdate.setNome(Usuario.getNome());
        return usuarioRepository.save(usuarioToUpdate);
    }

    @Override
    public void delete(Long id) {
        Usuario UsuarioToDelete = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Usuario.class, id));
        usuarioRepository.delete(UsuarioToDelete);
    }

}