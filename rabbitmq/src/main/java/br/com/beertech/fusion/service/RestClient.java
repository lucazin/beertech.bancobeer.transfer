package br.com.beertech.fusion.service;

import br.com.beertech.fusion.domain.Operacao;
import br.com.beertech.fusion.domain.Transferencia;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    private RestTemplate restTemplate;
    private Operacao RestOperationObject;
    private Transferencia RestTransferObject;
    public final String apiURLOperation = "http://localhost:8081/bankbeer/operacao";
    public final String apiURLTransfer = "http://localhost:8081/bankbeertransfer/newtransfer";

    public RestClient(Operacao RestObjectParamenter)
    {
        RestOperationObject = RestObjectParamenter;
    }
    public RestClient(Transferencia RestObjectParamenter)
    {
        RestTransferObject = RestObjectParamenter;
    }

    public void sendOperationPostAPI()
    {
        try
        {
            this.restTemplate = new RestTemplateBuilder().build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            Map<String, Object> map = new HashMap<>();
            map.put("tipoOperacao", RestOperationObject.getTipoOperacao());
            map.put("valorOperacao", RestOperationObject.getValorOperacao());

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
            ResponseEntity<Operacao> response = this.restTemplate.postForEntity(apiURLOperation, entity,Operacao.class);

            if (response.getStatusCode() == HttpStatus.CREATED) {
                System.out.println(response.getBody().toString());
            } else {
                System.out.println("Sem retorno");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public void sendTransferPostAPI()
    {
        try
        {
            this.restTemplate = new RestTemplateBuilder().build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            Map<String, Object> map = new HashMap<>();
            map.put("hashOrigem", RestTransferObject.getHashOrigem());
            map.put("hashDestino", RestTransferObject.getHashDestino());
            map.put("valorTransferido", RestTransferObject.getValorTransferido());

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
            ResponseEntity<Operacao> response = this.restTemplate.postForEntity(apiURLTransfer, entity,Operacao.class);

            if (response.getStatusCode() == HttpStatus.CREATED) {
                System.out.println(response.getBody().toString());
            } else {
                System.out.println("Sem retorno");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
