package com.ruubel.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import com.ruubel.model.Bank
import com.ruubel.model.BankInformation
import com.ruubel.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class BankControllerSpec extends Specification {

    BankController controller
    BankService bankService

    ObjectWriter ow
    MockMvc mockMvc

    def setup() {
        ObjectMapper mapper = new ObjectMapper()
        ow = mapper.writer().withDefaultPrettyPrinter()

        bankService = Mock(BankService)
        controller = new BankController(bankService)

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build()
    }

    def "when calling banks API endpoint [GET], then returns json 200 OK" () {
        when:
            def response = mockMvc.perform(get("/api/v1/banks")
                    .contentType(MediaType.APPLICATION_JSON)).andReturn().response
        then:
            1 * bankService.getContacts() >> [new BankInformation(Bank.SEB, "12345")]
            response.status == HttpStatus.OK.value()
            response.contentAsString == "[{\"bank\":\"SEB\",\"phoneNumber\":\"12345\"}]"
    }

    def "when calling banks API endpoint [POST], then returns 405 METHOD_NOT_ALLOWED" () {
        when:
            def response = mockMvc.perform(post("/api/v1/banks")
                .contentType(MediaType.APPLICATION_JSON)).andReturn().response
        then:
            0 * bankService.getContacts()
            response.status == HttpStatus.METHOD_NOT_ALLOWED.value()
            response.contentAsString == ""
    }

}
