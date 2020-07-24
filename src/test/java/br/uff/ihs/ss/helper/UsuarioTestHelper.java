package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.util.MapperUtil;

@Component
public class UsuarioTestHelper implements TestHelper<Usuario> {

    @Override
    public Usuario createOne() {
        return Usuario.builder().login("login").nome("nome").email("email@email.com").build();
    }

    @Override
    public Long getId(Usuario model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Usuario model) {
        UsuarioDto dto = MapperUtil.convertToDto(model, UsuarioDto.class);
        return MapperUtil.convertToJson(dto);
    }

    @Override
    public List<Usuario> createList() {
        return List.of( //
                Usuario.builder().login("login01").nome("Nome01").email("email01@email.com").build(),
                Usuario.builder().login("login02").nome("Nome02").email("email01@email.com").build());
    }

}