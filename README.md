## Marvel App.

Aplicativo Android cuja proposta é realizar uma consulta a api rest da Marvel e retornar os heróis e
seus comics. A consulta é feita usando Retrofit que salva os dados de forma local no SQLite com a
ajuda da lib Room do Google Jetpack. Foi usado também no projeto o Kotlin Coroutines, Koin para
injeção de dependências, arquitetura MVVM e DataBindings.

## Os endpoint utilizado nesse aplicativo foram:

1. [https://gateway.marvel.com:443/v1/public/characters?apiKey="hash da sua key"]
1. [https://gateway.marvel.com:443/v1/public/characters/{characterId}/comics?apiKey="Hash da sua key"]

## Tecnologias utilizadas no aplicativo

* Linguagem de Programação Kotlin
* Android Studio
* Arquitetura MVVM
* Koin
* Flow
* Room (SQLite)
* Retrofit
* Kotlin Coroutines
* ViewModel
* LiveData
* DataBinding
* Constraint Layout
* CardView

## Funcionalidades

- Primeira activity do app exibi uma lista de heróis da Marvel carregados da api e salvos de forma
  local, podendo ser exibido mesmo estando sem internet
- Segunda activity do app exibi os comics de determinado herói que você clicar na primeira activity,
  na segunda os comics são carregados baseado no id do Herói

## Screenshots das Activity

<img src="/imgs/imagem_um.jpeg" width="200">
<img src="/imgs/imagem_dois.jpeg" width="200">
<img src="/imgs/imagem_tres.jpeg" width="200">

## Para executar o app

- Renomeie o arquivo **apikey.properties.example para apikey.properties, e preencha os dados
  solicitados **

## Desenvolvedor

* **Marcelo Souza** : @marcelo-souza-1999 (https://github.com/marcelo-souza-1999/)
