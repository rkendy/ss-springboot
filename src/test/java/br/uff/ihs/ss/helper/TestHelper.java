package br.uff.ihs.ss.helper;

import java.util.List;

import br.uff.ihs.ss.util.MapperUtil;

public interface TestHelper<MODEL> {

    MapperUtil mapperUtil = new MapperUtil();

    MODEL createOne();

    Long getId(MODEL model);

    String convertToJson(MODEL model);

    List<MODEL> createList();

}