package com.example.RetoActuatorMicrometers.EndPoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;

@Component
@Endpoint(id="status")
public class EndPoint {

	private List<String> listaEstados = new ArrayList<>();
	
	private Counter counter;
	
	@ReadOperation
	public List<String> verEstados(){
		counter.increment();
		return listaEstados;
	}
	
	@WriteOperation
	public void añadirEstado(@Selector String nuevoEstado) {
		counter.increment();
		listaEstados.add(nuevoEstado);
	}
	
	@DeleteOperation
	public void cancelarEstado(@Selector String estado) {
		counter.increment();
		listaEstados.remove(estado);
	}
}

