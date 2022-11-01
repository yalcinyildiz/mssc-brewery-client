package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientForCustomerTest {

    @Autowired
    BreweryClientForCustomer breweryClient;

    @Test
    void testGetCustomerById() {
        UUID uuid = UUID.randomUUID();
        CustomerDto dto = breweryClient.getCustomerById(uuid);
        assertEquals(uuid, dto.getId());
    }

    @Test
    void testSaveNewCustomer(){
        CustomerDto dto = CustomerDto.builder()
                .name("Ege")
                .build();

        URI uri = breweryClient.saveNewCustomer(dto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer(){

        CustomerDto dto = CustomerDto.builder()
                .name("Ege")
                .build();

        breweryClient.updateCustomer(UUID.randomUUID(),dto);
    }

    @Test
    void testDeleteCustomerById(){
        breweryClient.deleteCustomerById(UUID.randomUUID());
    }
}