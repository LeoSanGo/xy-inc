# XY INC

### API de exemplo xy-inc
A API fornece serviços para cadastro de pontos de interesse (POI), Listagem de todos os pontos cadastrados e Listagem de pontos aproximados dado as coordenadas x e y e uma distância

### Tecnologias aplicadas
- Java 11
- Spring boot
- Banco MySQL
- Banco H2 (Execução de testes)

### Documentação
- Via [ Swagger ](http://localhost:8080/swagger-ui.html#/)

### Testando a aplicação
- Clonar no repositório: https://github.com/LeoSanGo/xy-inc
- Para popular o banco, executar o arquivo data.sql
- Apos subir a aplicação, endpoint de listagem: http://localhost:8080/points/
- Endpoint de cadastro de POI: http://localhost:8080/points/insert
- Listar POI por aproximação, exemplo: http://localhost:8080/points/search?coordX=20&coordY=10&distance=10

### Testes Unitários
- Teste de inserção
- Teste de validação

### Client HTTP
- [ Postman ](https://www.postman.com/)
