package Demoproject;

import java.util.List;
import java.util.Optional;

import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class VeiculoController {

	@Autowired
	VeiculoRepository repository;

	@GetMapping("/veiculos")
	public ModelAndView getAllVeiculos() {
		ModelAndView modelAndView = new ModelAndView("veiculos.html");
			List<Veiculo> lista = repository.findAll();
	        modelAndView.addObject("veiculos", lista);
		return modelAndView;
	}

	@PostMapping("/postveiculo")
	public Veiculo saveVeiculo(@RequestBody Veiculo veiculo) {
		ProducerFila pf = new ProducerFila();
		try {
			pf.envia("FILA = ",veiculo);
			repository.save(veiculo);
		} 
		catch (JMSException e) {
			System.out.println(e);
		}
		return veiculo;
	}
}