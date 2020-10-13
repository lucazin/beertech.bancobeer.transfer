package br.com.beertech.fusion.service;

import br.com.beertech.fusion.domain.Operacao;
import br.com.beertech.fusion.domain.Transferencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;

@Service
public class RabbitListener implements MessageListener {

	public void onMessage(Message message)
	{
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			String json = new String(message.getBody(), StandardCharsets.UTF_8);

			if(json.contains("hashOrigem") && json.contains("hashDestino"))
			{
				Transferencia transaction_pojo = objectMapper.readValue(json, Transferencia.class);

				if(new Validator(transaction_pojo).ValidateTransferResponseRMQ())
					new RestClient(transaction_pojo).sendTransferPostAPI();
			}
			else
			{
				Operacao transaction_pojo = objectMapper.readValue(json, Operacao.class);

				if(new Validator(transaction_pojo).ValidateOperationResponseRMQ())
					new RestClient(transaction_pojo).sendOperationPostAPI();
			}
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}