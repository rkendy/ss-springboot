package br.uff.ihs.ss.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.uff.ihs.ss.controller.advice.NotFoundAdvice;
import br.uff.ihs.ss.exception.NotFoundException;
import br.uff.ihs.ss.model.Setor;
import br.uff.ihs.ss.service.SetorService;

@ExtendWith(MockitoExtension.class)
public class SetorControllerTest {

    @Mock
    SetorService setorService;

    @InjectMocks
    SetorController setorController;

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(setorController) //
                .setControllerAdvice(new NotFoundAdvice()) //
                .build();
    }

    @Test
    void givenSetorList_whenFindAll_thenSuccess() throws Exception {
        List<Setor> list = List.of(Setor.builder().codigo(Setor.Codigo.ALMOXARIFADO).nome("Almoxarifado").build());

        when(setorService.getAll()).thenReturn(list);

        mockMvc.perform(get(SetorController.ENDPOINT)) //
                .andExpect(status().isOk()) //
                .andExpect(jsonPath("$.length()", is(list.size())))
                .andExpect(jsonPath("$[0].nome", is(list.get(0).getNome())))
                .andExpect(jsonPath("$[0].codigo", is(list.get(0).getCodigo().name())));
    }

    @Test
    void givenValidId_whenFindById_thenSuccess() throws Exception {
        Setor setor = Setor.builder().id(1L).nome("Informatica").codigo(Setor.Codigo.INFORMATICA).build();

        when(setorService.getById(1L)).thenReturn(setor);

        mockMvc.perform(get(SetorController.ENDPOINT + "/" + setor.getId())) //
                .andExpect(status().isOk()) //
                .andExpect(jsonPath("$.id").value(setor.getId())) //
                .andExpect(jsonPath("$.nome").value(setor.getNome()));

    }

    @Test
    void givenInvalidSetorId_whenFindById_thenReturnNotFound() throws Exception {
        when(setorService.getById(anyLong())).thenThrow(NotFoundException.class);

        mockMvc.perform(get(setorController.ENDPOINT + "/111")) //
                .andExpect(status().isNotFound());
    }
}