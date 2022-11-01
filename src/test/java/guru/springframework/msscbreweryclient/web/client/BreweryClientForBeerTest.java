package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientForBeerTest {

    @Autowired
    BreweryClientForBeer breweryClient;

    @Test
    void testGetBeerById() {
        UUID uuid = UUID.randomUUID();
        BeerDto dto = breweryClient.getBeerById(uuid);
        assertEquals(uuid, dto.getId());
    }

    @Test
    void testSaveNewBeer(){
        BeerDto dto = BeerDto.builder()
                .beerName("Efes Pilsen")
                .beerStyle("Ale")
                .upc(123L)
                .build();

        URI uri = breweryClient.saveNewBeer(dto);

        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer(){

        BeerDto dto = BeerDto.builder()
                .beerName("Efes Pilsen")
                .beerStyle("Ale")
                .upc(123L)
                .build();

        breweryClient.updateBeer(UUID.randomUUID(),dto);
    }

    @Test
    void testDeleteBeerById(){
        breweryClient.deleteBeerById(UUID.randomUUID());
    }
}