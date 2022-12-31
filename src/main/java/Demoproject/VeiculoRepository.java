package Demoproject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	List<Veiculo> findByNome(String marcaModeloVeiculo);
}
