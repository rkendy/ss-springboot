package br.uff.ihs.ss;

import java.util.List;

import br.uff.ihs.ss.model.Setor;

public class SetorTestHelper {
    public static List<Setor> createList() {
        return List.of( //
                create(Setor.Codigo.ALMOXARIFADO.name(), "Almoxarifado"), //
                create(Setor.Codigo.INFORMATICA.name(), "Informática") //
        );
    }

    public static Setor create(String codigo, String nome) {
        return Setor.builder().codigo(codigo).nome(nome).build();
    }

}