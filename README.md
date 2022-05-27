# Selenium Helper 🆘 Documentação

## 💡 Introdução

> *Está documentação se encontra em 🇺🇸 Inglês, no entanto está disponível a documentação em português do 🇧🇷 Brasil clicando [aqui](README_PT_BR.md)*

**Selenium Helper** é uma ferramenta de teste baseada no framework de testes selenium open source e escrita em java.

A ideia foi unificar ferramentas de testes em apenas um conjunto de bibliotecas para a execução de testes automatizados 🤖 e contendo uma modelagem de criação de testes mais ampla.

Sabemos que o selenium puro não contém relatórios ou logs de informações para informar ao usuário, dessa forma foi criado um sistema que lida com a entrega dessas informações, além disso é um framework personalizado para que o programador que usar para criar os seus testes automatizados não tenha tanto trabalho, entretanto poderá usar nativamente funções do selenium.

Em contato com a ferramenta você poderá ver em tempo real os logs de informações para cada ação de teste e no final deles você terá a opção de verificar o relatório com seus respectivos acertos e erros.

Selenium helper além de basear no selenium, ele contém várias outras bibliotecas que lhe darão agilidade e suporte nos testes, algumas delas são:

_Selenium, WebDriver Manager, Extent Reports, JUnit._

## 📚 Especificações detalhadas

Selenium Helper possui integração com as seguintes tecnologias:

- Java 18
- Selenium 4
- Junit 5
- Log4j12
- WebDriver Manager
- Extent report
- Lombok
- Apache Commons

## 🏘 Arquitetura

O Projeto possui duas divisões de ambiente de listas, uma contendo o core que é o main e a outra contendo a pasta de test.

Pasta de relatórios e screenshots

Dentro da pasta test em resources

### 🚫 O que não posso alterar para uso de produção?

O projeto contém duas pastas sendo o test e o main, a main e todo seu conteúdo não pode ser excluído, mas pode ser alterado para que possa ajustar as suas necessidades.

### ✅ O que posso alterar? 

Na pasta test existem vários exemplos de algumas formas de como implementar testes em conjunto com variações, mas você pode excluir eles sem problemas, ***⚠ lembrando que não deve excluir a pasta resources da pasta test.***

## 💾 Instalação

É necessário uma IDE que faça compilação do Java, IntelliJ, Netbeans, Eclipse.

Basta clonar o projeto ou baixar o projeto para o seu ambiente.

Após baixar e extrair o arquivo para uma pasta desejada, abra o projeto em sua IDE e baixe as dependências de bibliotecas.

Você navegará na pasta do projeto para o arquivo ExampleTest.java que está dentro da pasta test.

Agora basta executar o teste que compõe a anotação @Test

## 🔧 Configuração inicial

Após a instalação navegue até o arquivo que está na pasta resources com o nome: config.properties.

Este arquivo possui configurações de entrada para qual critério deseja acionar

| parâmetro               | valores                 | padrão                                                                                                   |
|-------------------------|-------------------------|----------------------------------------------------------------------------------------------------------|
| browser                 | (chrome, firefox, edge) | chrome                                                                                                   |
| headless                | (true or false)         | false                                                                                                    |
| web-driver-wait         | número inteiro          | 10                                                                                                       |
| report-theme            | (standard, dark)        | dark                                                                                                     |
| report-logo-url         | string url              | https://raw.githubusercontent.com/charleslana/test/579b6782913acc56571ce7d25fd1707dd6edce08/selenium.svg |
| report-datetime-format  | formato de datatime     | yyyy-MM-dd HH-mm-ss                                                                                      |
| open-report-after-tests | (true or false)         | true                                                                                                     |

## 🐛 Os Testes

Com  a ajuda do Junit que vem no projeto você pode criar vários casos de testes,
É importante saber que após criar um classe de teste é necessário que faça a extensão da classe SeleniumHelperTest e implementação da classe SeleniumHelper

`SeleniumHelperTest` - Classe para iniciar as configurações iniciais de teste

`SeleniumHelper` - Classe responsável pelos controles de elemento de página

Os exemplos listados podem servir como uma padrão de seus testes pois se baseia em componentes com interfaces separadas.

### 📝 Como criar meus testes?

```java
    class MyTest extends SeleniumHelperTest implements SeleniumHelper {
        @Test
        void test10Error() {
            navigate("https://www.selenium.dev/documentation");
            clickByLinkText("Create documentation issue");
            Assertions.assertEquals(getUrl(), "https://www.selenium.dev/documentation/");
        }
    }
```

## 🔑 API SeleniumHelper

tabela com listagem

## 💻 Suporte

Selenium Helper utiliza a biblioteca WebDriver Manager que auxilia na instalação automática de drivers de navegadores. Dessa forma o suporte aos navegadores será o mesmo que o selenium dá suporte.

### 📌 Qual sistema operacional suporta?

Foi testado em apenas Linux, você pode testar para verificar se funciona em outros OS.

## 💪 Contribuição

Uma vez que o projeto é livre para uso conforme na licença, você pode contribuir com novas ideias e melhorias, fique livre para opinar, criar um pull request ou abrir uma issue.

Contribuições são sempre bem-vindas!

Veja [`CONTRIBUTING.md`](https://github.com/github/docs/blob/main/CONTRIBUTING.md) para saber como começar.

Por favor, siga o [`CODE_OF_CONDUCT.md`](https://github.com/probot/template/blob/master/CODE_OF_CONDUCT.md) desse projeto.

## 🎥 Demonstração

Acesse o vídeo da demonstração e uso [aqui]()

## 📄 Licença

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://github.com/pagarme/opensource/blob/master/templates/LICENSE.md)

## 📢 Autor

- [@charleslana](https://www.github.com/charleslana)


