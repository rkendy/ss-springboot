package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.UsuarioDto;
import br.uff.ihs.ss.model.Usuario;
import br.uff.ihs.ss.helper.UsuarioTestHelper;

@Component
public class UsuarioTestHelper implements TestHelper<Usuario> {

    private Usuario createOne(String a, String b, String c) {
        return Usuario.builder().login(a).nome(b).email(c).build();
    }

    @Override
    public Usuario createOne() {
        return createOne("loginx", "Nome", "email@email.com");
    }

    @Override
    public Long getId(Usuario model) {
        return model.getId();
    }

    @Override
    public String convertToJson(Usuario model) {
        UsuarioDto dto = mapperUtil.convertToDto(model, UsuarioDto.class);
        return mapperUtil.convertToJson(dto);
    }

    @Override
    public List<Usuario> createList() {
        return List.of( //
                createOne("login1", "Nome 1", "email1@email.com"), //
                createOne("login2", "Nome 2", "email2@email.com"));
    }

}