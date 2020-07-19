package br.uff.ihs.ss;

import java.util.Iterator;
import java.util.List;

import br.uff.ihs.ss.model.Setor;

public class SetorTestHelper {
    public static List<Setor> createList() {
        return List.of( //
                create(Setor.Codigo.ALMOXARIFADO, "Almoxarifado"), //
                create(Setor.Codigo.INFORMATICA, "Informática") //
        );
    }

    public static Setor create(Setor.Codigo codigo, String nome) {
        return Setor.builder().codigo(codigo).nome(nome).build();
    }

}