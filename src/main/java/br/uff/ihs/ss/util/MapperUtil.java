package br.uff.ihs.ss.util;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;

public final class MapperUtil {
    private static ModelMapper modelMapper = new ModelMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <D> D convertToDto(Object bean, Class<D> dto) {
        return modelMapper.map(bean, dto);
    }

    public static <B, D> List<D> convertToDtoList(List<B> list, Class<D> dto) {
        return list.stream().map(e -> convertToDto(e, dto)).collect(Collectors.toList());
    }

    public static <B> B convertToEntity(Object dto, Class<B> bean) { // throws ParseException {
        return modelMapper.map(dto, bean);
    }

    public static String convertToJson(Object obj) {
        String result = "";
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
        }
        return result;
    }

    static public <D> D convertFromJson(String json, Class<D> bean) {
        try {
            return objectMapper.readValue(json, bean);
        } catch (Exception e) {
        }
        return null;
    }

}