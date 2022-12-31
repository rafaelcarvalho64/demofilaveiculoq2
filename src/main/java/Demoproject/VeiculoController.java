package Demoproject;

import java.util.List;
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
	public ModelAndView listar() {
        List<Veiculo> lista = repository.findAll();
        ModelAndView modelAndView = new ModelAndView("contatos.html");
        modelAndView.addObject("contatos", lista);
        return modelAndView;
    }

	@PostMapping("/veiculos/salvar")
	public ModelAndView saveVeiculo(Veiculo veiculo) {
		ProducerFila pf = new ProducerFila();
		try {
			pf.envia("FILA = ",veiculo);
			repository.save(veiculo);
		} 
		catch (JMSException e) {
			System.out.println(e);
		}
		ModelAndView modelAndView = new ModelAndView("postVeiculo.html");
		return modelAndView;
	}
}