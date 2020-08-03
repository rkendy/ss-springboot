package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.util.MapperUtil;
import br.uff.ihs.ss.helper.UsuarioTestHelper;

@Component
public class UsuarioTestHelper implements TestHelper<Usuario> {

    private Usuario createOne(String login, String nome) {
        return Usuario.builder().login(login).nome(nome).build();
    }

    @Override
    public Usuario createOne() {
        return createOne("login", "Nome usuario");
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
                createOne("login1", "Nome1"), //
                createOne("login2", "Nome2"));
    }

}