<template>
  <div>
    <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width" />
      <title>Principal</title>
      <link href="style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
      <header>
        <img class="atifer" src="../static/atifer.jpeg" alt="" />
        <p class="header">Sistema de Gerenciamento de Vendas</p>
      </header>
  
  <div class="tudo">
      <nav class="left1">
        <NuxtLink to="/tela-dados"><p id="linhamenu"><img id="iconemenu" src="../static/menu.png" /></p
        ></NuxtLink>
        <ul class="menu">
        <NuxtLink to="/tela-orcamentos" class="link">Orçamento</NuxtLink>
        <NuxtLink to="" class="link">Pedido</NuxtLink>
        <NuxtLink to="" class="link">Cliente</NuxtLink>
        </ul>
      </nav>

      <div class="espaco"></div>

      <article class="right1">
        <section id="s1">Dados da empresa:</section>
        <section id="s2">Lembretes Importantes:</section>
      </article>
</div>
      <script src="script.js"></script>
    </body>
  </div>
</template>

<script>
export default {}
</script>

<style>
html,
body {
  background-image: url('../static/fundo.jpeg');
  height: 100%;
  width: 100%;
}

header {
  background-color: red;
  text-align: center;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 40px;
  width: 100%;
  height: 200px;
}



img.atifer {
  opacity: 0.9;
  float: left;
  width: 20%;
  margin: 10px 0px 10px 30px;
  border-radius: 10px;
}

nav.left1 {
  background-color: #4682b4;
  float: left;
  width: 25% !important;
  height: 100%;
}

div.tudo {
  display: flex;
}

p#linhamenu {
  background-color: #000080;
}

img#iconemenu {
  border-radius: 50%;
  width: 50px;
  padding: 10px 0px;
  display: block;
  margin: 0 auto;
}

ul.menu a {
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  font-size: 20px;
  display: block;
  text-decoration: none;
  text-align: center;
  color: #fff;
  background-color: #363636;
  border: #fff 1px solid;
  height: 10%;
  padding-top: 30px;
  margin: 60px 40px 40px 0px;
}

li {
  list-style-type: none;
}

article.right1 {
  float: right;
  width: 70%;
}

section#s1 {
  padding: 10px;
  background-color: #fff;
  height: 20%;
  border-radius: 10px;
}

section#s2 {
  text-align: center;
  padding: 10px;
  background-color: #fff;
  height: 50%;
  border-radius: 10px;
}

@media screen and (max-width: 400px) {
  header {
    font-size: 25px;
  }

  img.atifer {
    margin: 20px;
    width: 30%;
  }

  p#linhamenu {
    margin: 5px;
    float: left;
  }

  img#iconemenu {
    width: 30px;
  }

  ul.menu a {
    display: inline;
    padding: 10px;
    margin: 10px;
  }

  ul.menu li {
    display: inline;
    margin: 20px;
  }

  .espaco {
    clear: both;
    padding: 10px;
  }

  nav {
    padding: 10px 0px;
    width: 100%;
    height: 12%;
  }

  article.right {
    float: none;
    width: 100%;
    margin: 10px;
  }
}
</style>