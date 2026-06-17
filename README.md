# Desafio Consulta Vendas

Projeto desenvolvido como desafio do curso **Java Spring Professional** da [DevSuperior](https://devsuperior.com.br), aplicando consultas com Spring Data JPA, JPQL e paginação.

## Sobre o projeto

Sistema de vendas (Sale) e vendedores (Seller) com geração de relatório de vendas e sumário por vendedor, ambos filtráveis por período de datas.

## Modelo de domínio

- **Sale** → id, visited, deals, amount, date
- **Seller** → id, name, email, phone
- Relação: cada venda pertence a um vendedor (N-1)

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | `/sales/report` | Relatório paginado de vendas por período e nome do vendedor |
| GET | `/sales/summary` | Sumário com total de vendas por vendedor no período |

## Parâmetros de consulta

```
GET /sales/report?minDate=2022-01-01&maxDate=2022-12-31&name=Thor&page=0&size=10
GET /sales/summary?minDate=2022-01-01&maxDate=2022-12-31
```

> Se `minDate` e `maxDate` não forem informados, o sistema retorna os dados dos **últimos 12 meses**.
> O filtro `name` é opcional e case-insensitive.

## Tecnologias utilizadas

- Java
- Spring Boot 3
- Spring Data JPA
- JPQL
- H2 Database
- Maven

## Como executar

```bash
git clone https://github.com/pedrotrevisan/desafio-consulta-vendas.git
cd desafio-consulta-vendas
./mvnw spring-boot:run
```

## Autor

**Pedro Henrique Trevisan**

[![GitHub](https://img.shields.io/badge/GitHub-pedrotrevisan-black)](https://github.com/pedrotrevisan)
