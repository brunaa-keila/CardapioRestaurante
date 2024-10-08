# Cardapio Restaurante

Este é um projeto de aplicativo Android para uma Pizzaria, desenvolvido em Kotlin. O aplicativo permite que os usuários escolham suas pizzas, visualizem detalhes do pedido e selecionem formas de pagamento.

## 📱Preview

<p align="center">
  <img src="https://github.com/user-attachments/assets/c27bbe31-5696-45cc-b80e-beb390c3247f" alt="." width="150"/>
  <img src="https://github.com/user-attachments/assets/d04204de-98c0-40da-aed7-6ea81f311b6f" alt="." width="150"/>
  <img src="https://github.com/user-attachments/assets/11a7ab23-93b9-41d8-9bda-1a93d2fb984c" alt="." width="150"/>
  <img src="https://github.com/user-attachments/assets/3b9ae4a9-66af-4cc3-a99b-1dea2deeb3e0" alt="." width="150"/>
</p>



## Funcionalidades

1. **Tela de Seleção de Formas de Pagamento**:
   - Opções de pagamento com **Cartão de Crédito** e **Pix**.
   - Validação do campo Pix, exibindo uma caixa de texto para inserir o email ou número de telefone ao selecionar Pix.

2. **Tela de Resumo do Pedido**:
   - Exibe os detalhes do pedido, como nome da pizza, quantidade, valor total e adicionais (molhos e bebidas).
   - Formatação monetária utilizando o padrão de moeda local para o valor total do pedido.

3. **Fluxo de Pagamento**:
   - Lógica para processar o pagamento baseado na forma selecionada (Cartão de Crédito ou Pix).
   - Mensagens de confirmação de pagamento com **Toast** para feedback ao usuário.

4. **Transição entre telas**:
   - Ao concluir o pagamento, redireciona o usuário para uma tela de agradecimento usando **Intents**.
   - Transição suave entre a tela de pagamento e a tela de agradecimento.
  
5. **Validação de Input**:
   - Verificação de preenchimento do campo Pix para garantir que o usuário insira as informações necessárias antes de concluir o pagamento via Pix.


## Tecnologias e Ferramentas Utilizadas

1. **Kotlin**: Linguagem de programação principal utilizada no desenvolvimento do projeto.
   
2. **View Binding**:
   - Utilização do **View Binding** para simplificar o acesso e manipulação das Views no código, melhorando a segurança de tipo e eliminando a necessidade de usar `findViewById()`.

3. **Android UI Components**:
   - **RadioGroup** e **RadioButton**: Para criar opções de seleção de forma de pagamento (Cartão de Crédito ou Pix).
   - **EditText**: Usado para receber dados do usuário (email ou telefone para pagamento via Pix).
   - **Button**: Botão de ação "Pagar Agora", que aciona o processamento do pagamento.

4. **Toast**:
   - Exibição de mensagens curtas para o usuário com feedback sobre as ações (ex: confirmação de pagamento).

5. **Intents**:
   - **Intent explícito** para navegar entre as telas de pagamento e de agradecimento.
   - Passagem de dados entre telas via `Intent` extras.

6. **Formatação de Moeda**:
   - Uso de **DecimalFormat** para exibir os valores monetários no formato correto.

7. **Tratamento de Cores e Estilos**:
   - Customização da cor da **StatusBar** para um tema mais agradável visualmente.
   - Definição de cores específicas para o background e botões utilizando o código hexadecimal.

8. **Compatibilidade com diferentes versões de Android**:
   - Uso de anotações como `@RequiresApi(Build.VERSION_CODES.N)` para assegurar compatibilidade com APIs específicas.

9. **Layouts XML**:
   - Definição de layouts com **LinearLayout** para organizar as views de forma vertical.
   - Aplicação de **TextView**, **Button**, **EditText**, **RadioGroup**, e customização via estilos e temas.
  

## Melhorias Futuras

- Adicionar integração real com um sistema de pagamento online.
- Adicionar suporte para múltiplos idiomas.
- Implementar um banco de dados local para armazenar pedidos anteriores.
- Melhorar a responsividade do layout para diferentes tamanhos de tela.
