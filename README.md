# Sistema de filas para publicação de anúncio de veículos

Instruções:

- Rodar activeMQ 

- Utilizando a devida IDE: Iniciar DemofilaveiculoApplication.java como app spring boot.

Serviço Rest (POST) para incluir um classificado de Veiculo na Fila de Mensagem.
Endpoint POST Veículo:
http://localhost:8080/postveiculo
```
{
    "nomeCliente": "String",
    "marcaModeloVeiculo": "String",
    "anoModelo": "int",
    "valorVenda": "double",
    "dataPublicacao":"yyyy-MM-dd"
}
```

- Acessar http://localhost:8080/contatos para a page lista de veículos classificados. Após adicionar veículos através do serviço rest (POST), basta abrir ou atualizar a page http://localhost:8080/contatos e os mesmo já estarão na lista. Para ver a mensagem na fila, basta acessar http://localhost:8161/admin/browse.jsp?JMSDestination=MY_FILA.

A aplicação oferece uma lista de classificados de veículos, veículos que foram armazenadas no banco de dados através do sistema de filas. 
