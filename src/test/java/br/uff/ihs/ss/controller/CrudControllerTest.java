package br.uff.ihs.ss.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.uff.ihs.ss.controller.advice.NotFoundAdvice;
import br.uff.ihs.ss.dto.CrudDto;
import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.model.CrudModel;
import br.uff.ihs.ss.service.CrudService;
import br.uff.ihs.ss.util.MapperUtil;

@ExtendWith(MockitoExtension.class)
public abstract class CrudControllerTest<M extends CrudModel<D>, D extends CrudDto<M>> {

    @Mock
    private CrudService<M> service;

    private BaseCrudController<M, D> controller;

    private MockMvc mockMvc;

    public abstract String getEndPoint();

    public abstract BaseCrudController<M, D> getController();

    public abstract List<M> createList();

    public abstract M createOne();

    @BeforeEach
    void setup() {
        controller = getController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller) //
                .setControllerAdvice(new NotFoundAdvice()) //
                .build();
    }

    @Test
    void givenList_whenFindAll_thenSuccess() throws Exception {
        List<M> list = createList();

        when(service.findAll()).thenReturn(list);

        mockMvc.perform(get(getEndPoint())) //
                .andExpect(status().isOk()) //
                .andExpect(jsonPath("$.length()", is(list.size())));
    }

    @Test
    void givenValidId_whenFindById_thenSuccess() throws Exception {
        M model = createOne();

        when(service.findById(1L)).thenReturn(model);

        mockMvc.perform(get(getEndPoint() + "/1")) //
                .andExpect(status().isOk()); //
    }

    @Test
    void givenInvalidId_whenFindById_thenReturnNotFound() throws Exception {
        when(service.findById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get(getEndPoint() + "/1111")) //
                .andExpect(status().isNotFound());
    }

    @Test
    void givenModel_whenCreate_thenSuccess() throws Exception {
        M created = createOne();

        when(service.create(any())).thenReturn(created);

        mockMvc.perform( //
                post(getEndPoint()) //
                        .contentType(MediaType.APPLICATION_JSON) //
                        .content(MapperUtil.convertToJson(created))) //
                .andExpect(status().isCreated());
    }

    @Test
    void givenModel_whenUpdate_thenSuccess() throws Exception {
        M updated = createOne();

        when(service.update(anyLong(), any())).thenReturn(updated);

        mockMvc.perform( //
                put(getEndPoint() + "/1") //
                        .contentType(MediaType.APPLICATION_JSON) //
                        .content(MapperUtil.convertToJson(updated))) //
                .andExpect(status().isOk());
    }

    @Test
    void givenId_whenDelete_thenSuccess() throws Exception {
        doNothing().when(service).delete(anyLong());

        mockMvc.perform( //
                delete(getEndPoint() + "/1")) //
                .andExpect(status().isOk()); //
    }
}