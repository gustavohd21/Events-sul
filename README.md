# Events Sul

1. Events Sul é um app cujo pode-se verificar uma lista de eventos disponivel e realizar um check in no evento assim como compartilhar o mesmo. Dentro deste repositório se encontra um APK do aplicativo para instalação direta do app.

# Screenshot
<img src="/screenshot/splash.png" width = "300" height="300px"/> <img src="/screenshot/main_error.png" width = "300" height="300px"/> 

## Arquitetura VIPER
O projeto foi estruturado usando a arquitetura VIPER cujo temos a separação entre a apresentação dos dados, fluxo de transição e chamadas a APIs externas. A escolha pela arquitetura se deu pela possibilidade de uma maior separação entre os modulos da aplicação o que permite implementar novas funcionalidades sem realizar alterações nos modulos já implementados onde somente na camada Router pode haver alguma alteração para chamada de nova rota. Além da possiblidade de uma maior separação de modulos a escolha foi influenciada pela preve experiencia com o uso dessa arquitetura.

## DAGGER 2
O uso da Biblioteca foi utilizado por já ter uma preve experiência com o uso de DAGGER e para implementação da arquitetura VIPER injeção de dependência facilida sua implementação e sua manutenção.

## RX JAVA
O uso da Biblioteca foi devido a possibilidade de uma representação mais declarativa e que funciona bem com chamadas HTTP, novamente aqui houve uma tentativa de utilizar a biblioteca por estar trabalhando com Flutter o que permite uma implementação mais declarativa.

## Retrofit
O uso da Biblioteca foi necessario para chamadas RUST e utilizada junto com o RX java, sua escolha se deu por ser uma das libs mais utilizadas para isso no Android e por ter uma preve experiência com seu uso.

## Picasso
O uso da Biblioteca foi adotado para poder lidar com as imagens vindas da API cujo utilizei para visualizar imagens e tratar caso houver erros com as imagens. 

## Material design
O uso da Biblioteca foi para implementar alguns designs como os cards e botões. 
