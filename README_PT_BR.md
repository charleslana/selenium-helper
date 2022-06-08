# Selenium Helper 🆘 Documentação

## 💡 Introdução

> *Está documentação se encontra em 🇺🇸 Inglês, no entanto está disponível a documentação em português do 🇧🇷 Brasil
clicando [aqui](README_PT_BR.md)*

**Selenium Helper** é uma ferramenta de teste baseada no framework de testes selenium open source e escrita em java.

A ideia foi unificar ferramentas de testes em apenas um conjunto de bibliotecas para a execução de testes automatizados
🤖 e contendo uma modelagem de criação de testes mais ampla.

Sabemos que o selenium puro não contém relatórios ou logs de informações para informar ao usuário, dessa forma foi
criado um sistema que lida com a entrega dessas informações, além disso é um framework personalizado para que o
programador que usar para criar os seus testes automatizados não tenha tanto trabalho, entretanto poderá usar
nativamente funções do selenium.

Em contato com a ferramenta você poderá ver em tempo real os logs de informações para cada ação de teste e no final
deles você terá a opção de verificar o relatório com seus respectivos acertos e erros.

Selenium helper além de basear no selenium, ele contém várias outras bibliotecas que lhe darão agilidade e suporte nos
testes, algumas delas são:

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
- Monte Screen Recorder

## 🏘 Arquitetura

O Projeto possui duas divisões de ambiente de listas, uma contendo o core que é o main e a outra contendo a pasta de
test.

Pasta de relatórios e screenshots dentro da pasta test em resources

### 🚫 O que não posso alterar para uso de produção?

O projeto contém duas pastas sendo o test e o main, a main e todo seu conteúdo não pode ser excluído, mas pode ser
alterado para que possa ajustar as suas necessidades.

### ✅ O que posso alterar?

Na pasta test existem vários exemplos de algumas formas de como implementar testes em conjunto com variações, mas você
pode excluir eles sem problemas, ***⚠ lembrando que não deve excluir a pasta resources da pasta test.***

## 💾 Instalação

É necessário uma IDE que faça compilação do Java, IntelliJ, Netbeans, Eclipse.

Basta clonar o projeto ou baixar o projeto para o seu ambiente.

```bash
git clone https://github.com/charleslana/selenium-helper.git
```

Ou se preferir baixe o projeto em versões e extraia o arquivo para uma pasta desejada, abra o projeto em sua IDE e baixe
as dependências de
bibliotecas.

Você navegará na pasta do projeto para o arquivo ExampleTest.java que está dentro da pasta test.

Agora basta executar o teste que compõe a anotação @Test

## 🔧 Configuração inicial

Após a instalação navegue até o arquivo que está na pasta resources do ambiente teste com o nome: config.properties.

Este arquivo possui configurações de entrada para qual critério deseja acionar

| Parâmetro               | Valores                                                             | Padrão                                                                                                   |
|-------------------------|---------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| browser                 | (chrome, chrome-remote, edge, edge-remote, firefox, firefox-remote) | chrome                                                                                                   |
| headless                | (true ou false)                                                     | false                                                                                                    |
| web-driver-wait         | número inteiro                                                      | 10                                                                                                       |
| report-theme            | (standard, dark)                                                    | dark                                                                                                     |
| report-logo-url         | texto url                                                           | https://raw.githubusercontent.com/charleslana/test/579b6782913acc56571ce7d25fd1707dd6edce08/selenium.svg |
| report-datetime-format  | formato de datatime                                                 | yyyy-MM-dd HH-mm-ss                                                                                      |
| open-report-after-tests | (true ou false)                                                     | true                                                                                                     |
| remote-url              | texto url                                                           | http://localhost:4444/wd/hub/                                                                            |

## 🐛 Os Testes

Com a ajuda do Junit que vem no projeto você pode criar vários casos de testes,
É importante saber que após criar um classe de teste é necessário que faça a extensão da classe SeleniumHelperTest e
implementação da interface SeleniumHelper

`SeleniumHelperTest` - Classe para iniciar as configurações iniciais de teste

`SeleniumHelper` - Interface responsável pelos controles de elemento de página

Os exemplos listados podem servir como uma padrão de seus testes pois se baseia em componentes com interfaces separadas.

### 📝 Como criar meus testes?

```java
    class MyTest extends SeleniumHelperTest implements SeleniumHelper {

    @Test
    void myTest() {
        navigate("https://www.selenium.dev/documentation");
        clickByLinkText("Create documentation issue");
        Assertions.assertEquals(getUrl(), "https://www.selenium.dev/documentation/");
    }
}
```

### 📡 Como testar pelo docker?

Utilize os browser remotos do arquivo de configuração e configure a url remoto

## 📹 Gravando os testes

Você pode evidenciar seus testes de forma rápida utilizando a anotação @Recorder em cada teste, dessa forma será gravado
um vídeo em formato .AVI na pasta test > resources > vídeo

Utilize o parâmetro name para definir um nome ou deixei em branco para salvar o vídeo com o nome padrão.

### 📝 Como gravar meus testes?

```java
    class MyTest extends SeleniumHelperTest implements SeleniumHelper {

    @Test
    @Recorder(name = "My test")
    void myTest() {
        navigate("https://www.selenium.dev/documentation");
        clickByLinkText("Create documentation issue");
        Assertions.assertEquals(getUrl(), "https://www.selenium.dev/documentation/");
    }
}
```

## 🔑 API SeleniumHelper

| Method                            | Parameters                    | Return           |
|-----------------------------------|-------------------------------|------------------|
| getDriver                         |                               | WebDriver        |
| getTitle                          |                               | String           |
| getUrl                            |                               | String           |
| navigate                          | String                        | void             |
| navigateBack                      |                               | void             |
| navigateForward                   |                               | void             |
| navigateTo                        | String                        | void             |
| await                             | Function                      | void             |
| sleep                             | Integer                       | void             |
| clearByClassName                  | String                        | void             |
| clearByClassName                  | String, Integer               | void             |
| clearByCss                        | String                        | void             |
| clearByCss                        | String, Integer               | void             |
| clearById                         | String                        | void             |
| clearByLinkText                   | String                        | void             |
| clearByLinkText                   | String, Integer               | void             |
| clearByName                       | String                        | void             |
| clearByName                       | String, Integer               | void             |
| clearByPartialLinkText            | String                        | void             |
| clearByPartialLinkText            | String, Integer               | void             |
| clearByTagName                    | String                        | void             |
| clearByTagName                    | String, Integer               | void             |
| clearByXpath                      | String                        | void             |
| clearByXpath                      | String, Integer               | void             |
| clickByClassName                  | String                        | void             |
| clickByClassName                  | String, Integer               | void             |
| clickByCss                        | String                        | void             |
| clickByCss                        | String, Integer               | void             |
| clickById                         | String                        | void             |
| clickByLinkText                   | String                        | void             |
| clickByLinkText                   | String, Integer               | void             |
| clickByName                       | String                        | void             |
| clickByName                       | String, Integer               | void             |
| clickByPartialLinkText            | String                        | void             |
| clickByPartialLinkText            | String, Integer               | void             |
| clickByTagName                    | String                        | void             |
| clickByTagName                    | String, Integer               | void             |
| clickByXpath                      | String                        | void             |
| clickByXpath                      | String, Integer               | void             |
| find                              | By                            | WebElement       |
| findByClassName                   | String                        | WebElement       |
| findByCss                         | String                        | WebElement       |
| findById                          | String                        | WebElement       |
| findByLinkText                    | String                        | WebElement       |
| findByName                        | String                        | WebElement       |
| findByPartialLinkText             | String                        | WebElement       |
| findByTagName                     | String                        | WebElement       |
| findByXpath                       | String                        | WebElement       |
| findAll                           | By                            | List[WebElement] |
| findAllByClassName                | String                        | List[WebElement] |
| findAllByCss                      | String                        | List[WebElement] |
| findAllByLinkText                 | String                        | List[WebElement] |
| findAllByName                     | String                        | List[WebElement] |
| findAllByPartialLinkText          | String                        | List[WebElement] |
| findAllByTagName                  | String                        | List[WebElement] |
| findAllByXpath                    | String                        | List[WebElement] |
| typeByClassName                   | String, CharSequence          | void             |
| typeByClassName                   | String, Integer, CharSequence | void             |
| typeByCss                         | String, CharSequence          | void             |
| typeByCss                         | String, Integer, CharSequence | void             |
| typeById                          | String, CharSequence          | void             |
| typeByLinkText                    | String, CharSequence          | void             |
| typeByLinkText                    | String, Integer, CharSequence | void             |
| typeByName                        | String, CharSequence          | void             |
| typeByName                        | String, Integer, CharSequence | void             |
| typeByPartialLinkText             | String, CharSequence          | void             |
| typeByPartialLinkText             | String, Integer, CharSequence | void             |
| typeByTagName                     | String, CharSequence          | void             |
| typeByTagName                     | String, Integer, CharSequence | void             |
| typeByXpath                       | String, CharSequence          | void             |
| typeByXpath                       | String, Integer, CharSequence | void             |
| waitInvisibility                  | WebElement                    | void             |
| waitInvisibility                  | List<WebElement>, Integer     | void             |
| waitInvisibilityByClassName       | String                        | void             |
| waitInvisibilityByClassName       | String, Integer               | void             |
| waitInvisibilityByCss             | String                        | void             |
| waitInvisibilityByCss             | String, Integer               | void             |
| waitInvisibilityById              | String                        | void             |
| waitInvisibilityByLinkText        | String                        | void             |
| waitInvisibilityByLinkText        | String, Integer               | void             |
| waitInvisibilityByName            | String                        | void             |
| waitInvisibilityByName            | String, Integer               | void             |
| waitInvisibilityByPartialLinkText | String                        | void             |
| waitInvisibilityByPartialLinkText | String, Integer               | void             |
| waitInvisibilityByTagName         | String                        | void             |
| waitInvisibilityByTagName         | String, Integer               | void             |
| waitInvisibilityByXpath           | String                        | void             |
| waitInvisibilityByXpath           | String, Integer               | void             |
| waitUrlContains                   | String                        | void             |
| waitVisibility                    | WebElement                    | void             |
| waitVisibility                    | List<WebElement>, Integer     | void             |
| waitVisibilityByClassName         | String                        | void             |
| waitVisibilityByClassName         | String, Integer               | void             |
| waitVisibilityByCss               | String                        | void             |
| waitVisibilityByCss               | String, Integer               | void             |
| waitVisibilityById                | String                        | void             |
| waitVisibilityByLinkText          | String                        | void             |
| waitVisibilityByLinkText          | String, Integer               | void             |
| waitVisibilityByName              | String                        | void             |
| waitVisibilityByName              | String, Integer               | void             |
| waitVisibilityByPartialLinkText   | String                        | void             |
| waitVisibilityByPartialLinkText   | String, Integer               | void             |
| waitVisibilityByTagName           | String                        | void             |
| waitVisibilityByTagName           | String, Integer               | void             |
| waitVisibilityByXpath             | String                        | void             |
| waitVisibilityByXpath             | String, Integer               | void             |
| switchWindow                      |                               | void             |
| alertAccept                       |                               | void             |
| alertDismiss                      |                               | void             |
| getAlert                          |                               | Alert            |
| getAlertText                      |                               | String           |
| typeAlert                         | String                        | void             |
| dragDrop                          | WebElement, WebElement        | void             |
| dragDropByLocation                | WebElement, Integer, Integer  | void             |
| switchFrame                       |                               | void             |
| switchFrame                       | Integer                       | void             |
| switchFrame                       | String                        | void             |
| switchFrame                       | WebElement                    | void             |
| move                              | WebElement                    | void             |
| moveByClassName                   | String                        | void             |
| moveByClassName                   | String, Integer               | void             |
| moveByCss                         | String                        | void             |
| moveByCss                         | String, Integer               | void             |
| moveById                          | String                        | void             |
| moveByLinkText                    | String                        | void             |
| moveByLinkText                    | String, Integer               | void             |
| moveByName                        | String                        | void             |
| moveByName                        | String, Integer               | void             |
| moveByPartialLinkText             | String                        | void             |
| moveByPartialLinkText             | String, Integer               | void             |
| moveByTagName                     | String                        | void             |
| moveByTagName                     | String, Integer               | void             |
| moveByXpath                       | String                        | void             |
| moveByXpath                       | String, Integer               | void             |

## 💻 Suporte

Selenium Helper utiliza a biblioteca WebDriver Manager que auxilia na instalação automática de drivers de navegadores.
Dessa forma o suporte aos navegadores será o mesmo que o selenium dá suporte.

### 📌 Qual sistema operacional suporta?

Foi testado em apenas Linux, você pode testar para verificar se funciona em outros OS.

## 💪 Contribuição

Uma vez que o projeto é livre para uso conforme na licença, você pode contribuir com novas ideias e melhorias, fique
livre para opinar, criar um pull request ou abrir uma issue.

Contribuições são sempre bem-vindas!

Veja [`CONTRIBUTING.md`](CONTRIBUTING.md) para saber como começar.

Por favor, siga o [`CODE_OF_CONDUCT.md`](CODE_OF_CONDUCT.md) desse projeto.

## 🎥 Demonstração

Acesse o vídeo da demonstração e uso [YouTube](https://youtu.be/4_xqpoCL5L4)

## 📄 Licença

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](LICENSE.md)

## 📢 Autor

- [@charleslana](https://www.github.com/charleslana)


