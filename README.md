<div align="center">
  
  # Refatoração para o Princípio da Segregação de Interfaces (ISP)
    
#### Unidade Curricular: Arquitetura de Sistemas | Professor: Lucas Santos 

<br>

![ComputerCatGIF](https://github.com/user-attachments/assets/92071d58-035c-4bd7-825d-bcf7b3ea270b)


</div>

--------

<br>


## | Cenário: Sistema de Gestão de Clientes Multifuncional na TechStore 🥸

### Contextualização

A TechStore está expandindo suas operações de atendimento ao cliente e suporte. Inicialmente, a equipe de desenvolvimento criou uma interface monolítica chamada GerenciadorDeClientes, que agrupa todas as operações que um cliente pode exigir:

- Cadastro e busca de clientes

- Envio de notificações (e-mails/SMS)

- Aplicação de descontos VIP

Embora pareça conveniente, essa abordagem cria problemas de manutenção e escalabilidade. ❗

<br>

### O Problema: Violação do ISP

A interface GerenciadorDeClientes é “obesa” e força as classes concretas a implementar métodos que não precisam.

Exemplo:

- ClienteComumService: só precisa cadastrar e buscar clientes, mas é obrigado a implementar enviarNotificacao e aplicarDescontoVIP, mesmo que não faça sentido para clientes comuns.

- ClienteVIPService: precisa de todas as operações, mas a interface continua sendo problemática para futuros tipos de clientes com funcionalidades limitadas.

#### Impacto:

Violação do Princípio da Segregação de Interfaces (ISP), que afirma:
````
“Clientes não devem ser forçados a depender de interfaces que não utilizam.”
````

<br>

### Estrutura:

````
TechStoreOCP
└── src
    └── java
        ├── descontos
        │   ├── EstrategiaDesconto.java
        │   ├── DescontoAniversario.java
        │   ├── DescontoCupom.java
        │   ├── DescontoSazonal.java
        │   └── DescontoVip.java
        │
        ├── model
        │   └── Pedido.java
        │
        └── util
            ├── CalculadoraDesconto.java
            └── Main.java
````

<br>

### Explicação do Mau Design:

O mau design ocorre porque a interface **GerenciadorDeClientes** concentra muitas responsabilidades diferentes em um único lugar. Dessa forma, todas as classes que a implementam são obrigadas a definir todos os métodos, mesmo quando não precisam de algumas dessas funcionalidades. No caso do **ClienteComumService**, por exemplo, ele só precisa realizar operações de cadastro e busca de clientes, mas é forçado a implementar também métodos de envio de notificações e aplicação de descontos VIP, que não fazem parte do seu comportamento. Isso gera dependências desnecessárias, aumenta o acoplamento e pode levar à criação de métodos vazios ou exceções, tornando o código menos coeso, mais difícil de manter e em desacordo com o Princípio da Segregação de Interfaces (ISP).

<br>

### Benefícios da Refatoração

- Coesão: Cada interface possui apenas métodos relevantes para sua função.

- Flexibilidade: Novos tipos de clientes podem implementar apenas as interfaces que realmente precisam.

- Manutenção mais fácil: Mudanças em uma funcionalidade não afetam classes que não a utilizam.

- Conformidade com ISP: Classes não são forçadas a depender de métodos irrelevantes.
