# Sodoma E-commerce (Projeto em Desenvolvimento)

⚠️ Projeto em andamento — este repositório está em desenvolvimento ativo.

Este projeto é uma **plataforma de e-commerce** para a banda Sodoma, construída com **Java Spring Boot**.  
O objetivo é gerenciar e vender produtos variados, como álbuns (CDs, vinis, cassetes), merchandise (camisetas, posters) e suas variações.

## Funcionalidades (planejadas / em andamento)
- Catálogo de produtos com múltiplas variações
- Geração de SKU único e legível
- Controle de estoque e preço
- Categorias de álbuns e merchandise
- Gerenciamento de imagens de produtos
- Integração com APIs de pagamento e envio (planejada)

## Stack Tecnológica
- Java 17+ com Spring Boot
- JPA / Hibernate para persistência
- Banco H2 (desenvolvimento/testes)
- Lombok para redução de boilerplate
- Jackson para serialização JSON
- Testes unitários com JUnit

## Observações
- Este repositório ainda está em desenvolvimento, muitas funcionalidades estão incompletas.
- A geração de SKU foi atualizada para usar um sufixo randômico de 6 caracteres, garantindo unicidade.
- Algumas relações de entidades (ProductVariation, AlbumVariation, ProductImage) já estão implementadas, mas a plataforma não está pronta para produção.
- Contribuições são bem-vindas, mas o código está em constante evolução.

## Como rodar (Desenvolvimento)
1. Clonar o repositório
2. Build com Maven ou Gradle
3. Rodar a aplicação Spring Boot
4. Acessar os endpoints da API (documentação futura)

---

> Este projeto é um **projeto pessoal/portfólio** da banda Sodoma e está em desenvolvimento. Use por sua conta e risco.
