# Challenge Feedback from Developer (Sidarta)

## Overview

The challenge was completed with overall requirements implemented. The idea was to use a good architecture even though this project is quite simple.

Hope you like it, any feedback is much appreciated!

Project is using:
- Retrofit for API
- Picasso for Image handling
- Butter Knife for clean and easy binding
- Swipe to refresh on products list
- MVP Architecture

It contains two main screens: 
- List of Products
- Product Details

It also has a contextual menu for actions on Products List screen.

## Architecture

The proposed app architecture is an implementation of MVP - Model View Presenter. Main goal is to explicitly separate model from the view and create interfaces for the Presenter (as know as Controllers on older architectures). With that, is clear to the developer on where to put methods and actions, depending on which feature is being implemented - View interface handles actions that happens on the view and Presentation methods handles business logic that influences what is being shown on the Activity. Also with this schema, it's clear on where to perform API/Database requests (and that is our Repository). 

All of this leads to a better structured project, that makes it easier to maintain, to iterate over, to implement new features, and even to do code reviews, deployments, etc. 

The next iteration architecture-wise would be to implement *Clean Architecture*, using Dagger2. That would be the goal for a bigger project. It was not implemented here because the scope and time of this challenge. 

## Layouts

Layouts proposed follows basic material design guidelines. It's a simple UI that conveys what was required. It could be better planned with a few interesting UI interactions, animations and components, but because of the scope and time, that was left aside. 

Swipe to refresh was implemented to make it easier for refreshing the list.

A few comments on my ideas (there are plenty, but listing just a few to illustrate)
- Put a badge on the list of products indicating what products are on sale. On this case, we could also highlight the price difference and the discount
- Better handling of images and tap to expand the product image
- UI element on the list to show filter options like: sale products and ordering parameters

## Tests

It was an extra requirement, for bonus points, I know... I tried... 

I already worked on projects using SonarQube and a little bit with Unit tests. On this challenge I did a simple example on that, but Test Automation is an area that I'm still learning and enjoying.

## Branching and GIT

For GIT flows I used a very simple pattern for commit messages. Usually inside brackets we would put the number of the corresponding ticket (JIRA number for example). On this project, it just states what is the scope of the change (miscellaneous, features, tests).

For branching, I created a develop branch for code development, and merged back on master after finished v1.0. Also, created a tag indicating the end of first version. On more complex GIT flows we would create separate branches for each feature, and use code review techniques before merging them back on develop. Merge on master would happen after releases.

-------------------------------

# AMARO Android Challenge
In this exercise, the proposed challenge is to create a catalogue app that displays [AMARO](https://amaro.com/)'s all-time *best-sellers*.

## A few guidelines
* The app must read product data from this mocked [products resource API](http://www.mocky.io/v2/59b6a65a0f0000e90471257d).
* All products from the resource must be displayed.
* To initiate the test, just fork this repository, and once you're done, please use the words *DONE!* in your last commit.
* You may use any third-party libraries as you see fit.
* Use Java as the main programming language.
* In case you need any help, feel free to search for reference materials on Google or ask your friends, but do not ask them to work on the challenge for you, which is obvisously unethical behavior.

## Basic requirements
1. Display a vertical scrollable list of products with the following data:
    - Image
    - Name
    - Price 
2. Each product on the list must be clickable. 
3. Upon a click event on any displayed product, a product detail window is to be presented with following data:
    - Image
    - Name
    - Price
    - Promotion status (on sale or not)
    - Promotional price (if available)
    - Available sizes

## Additional requirements
* Some products lack a complete size grid (sizes are out of stock). Display only the sizes that are in stock.
* Add a filter to display only products that are on sale (on_sale).
* Add a sorting feature that allows the list to be sorted by price (lowest first)
* Be creative and perfectionist with the layout.
* Don't forget to follow Google's [material design](https://getmdl.io/components/index.html) guidelines.
 
## Bonus point
* Is all very easy so far? We all enjoy clean, comprehensible and testable code, don't we? This is a major plus, so refactor your code if necessary and add unit tests where possible.

## Examination criteria
* The code will be examined according to following main criterias: semantics, structure and legibility.
* Organization and comments of the *git* commit history will be considered.
* We're looking for an experienced Java developer who knows how to use Google's guidelines and is able to write clean and working software, so take this chance to show us what you're made of.

-------------------------------

# Desafio Android AMARO
O objetivo deste desafio é construir um app de catálogo para alguns dos *best-sellers* da história da [AMARO](https://amaro.com/).

## Algumas regras
* O app deve consumir o serviço [products service](http://www.mocky.io/v2/59b6a65a0f0000e90471257d) como uma API Rest.
* Todos os produtos carregados do serviço devem ser exibidos no catálogo.
* Para iniciar o teste faça o fork do repositório, e para finalizar nomeie o último commit com  *DONE!*.
* É permitido utilizar quaisquer bibliotecas que você esteja familiarizado.
* Utilize Java como linguagem principal.
* Se você estiver com dúvidas, busque por referências no Google, ou pergunte para amigos.
Mas não peça para eles resolverem o desafio para você.

## Requisitos básicos
1. Exibir uma lista de produtos em forma de catálogo vertical com as seguintes informações:
    - Imagem
    - Nome
    - Preço 
2. Cada produto do catálogo deve ser clicável. 
3. Quando o produto for clicado, o usuário deve ser direcionado para uma área, onde serão exibidos os detalhes do produto, com as seguintes informações:
    - Imagem
    - Nome
    - Preço
    - Status de promoção
    - Preço promocional (se houver)
    - Tamanhos disponíveis

## Requisitos adicionais
* Alguns produtos não tem sua grade completa (todos os tamanhos disponíveis). Mostre somente os tamanhos em estoque.
* Adicione um filtro para mostrar só os produtos em promoção (`on_sale`).
* Adicione uma funcionalidade de ordenção que permite ordenar a lista por preço (menor para maior).
* Seja criativo e perfeccionista com o layout.
* Utilize os guidelines de [material design](https://getmdl.io/components/index.html).
 
## Ponto extra
* Achou o desafio até aqui fácil? Todos gostamos de código limpo, facilmente compreensível e testável, certo? Então esse é um grande diferencial. Refatore seu código se necessário, e adicione testes unitários onde possível.

## Critérios de avaliação
* O código será avaliado considerando: semântica, estruturação e legibilidade.
* O histórico do *git* também será avaliado.
* Estamos buscando um desenvolvedor Android que saiba utilizar as guidelines, padrões da Google e ao mesmo tempo, possua um conhecimento sólido em Java-Android. Por isso, aproveite a oportunidade para nos mostrar que você tem conhecimento nessas áreas.
