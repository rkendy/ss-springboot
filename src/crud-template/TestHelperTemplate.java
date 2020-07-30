package br.uff.ihs.ss.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import br.uff.ihs.ss.dto.$Model$Dto;
import br.uff.ihs.ss.model.$Model$;
import br.uff.ihs.ss.util.MapperUtil;

@Component
public class $Model$TestHelper implements TestHelper<$Model$> {

    @Override
    public $Model$ createOne() {
        return $Model$.builder().codigo("codigox").nome("nomex").build();
    }

    @Override
    public Long getId($Model$ model) {
        return model.getId();
    }

    @Override
    public String convertToJson($Model$ model) {
        $Model$Dto dto = MapperUtil.convertToDto(model, $Model$Dto.class);
        return MapperUtil.convertToJson(dto);
    }

    @Override
    public List<$Model$> createList() {
        return List.of( //
                $Model$.builder().codigo($Model$.Codigo.ALMOXARIFADO.name()).nome("Almoxarifado").build(),
                $Model$.builder().codigo($Model$.Codigo.INFORMATICA.name()).nome("Informática").build());
    }

}