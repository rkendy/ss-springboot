package br.uff.ihs.ss.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public final class MapperUtil {
    private static ModelMapper modelMapper = new ModelMapper();

    public static <D> D convertToDto(Object bean, Class<D> dto) {
        return modelMapper.map(bean, dto);
    }

    public static <D> List<D> convertToDtoList(List<?> list, Class<D> dto) {
        return list.stream().map(e -> convertToDto(e, dto)).collect(Collectors.toList());
    }

    // private SetorDto convertToDto(Setor setor) {
    // // return BaseController.convertToDto(setor, SetorDto.class);
    // return modelMapper.map(setor, SetorDto.class);
    // }

    // private Setor convertToEntity(SetorDto setorDto) throws ParseException {
    // return modelMapper.map(setorDto, Setor.class);
    // }

}