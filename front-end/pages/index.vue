<template>
  <div>
    <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width" />
      <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <header>
      <img class="atifer" src="../static/atifer.jpeg" alt="" />
      <p>Sistema de Gerenciamento de Vendas</p>
    </header>
    <nav>
      <NuxtLink to="/tela-dados"><p id="linhamenu"><img id="iconemenu" src="../static/menu.png" /></p
      ></NuxtLink>
      <ul class="menu">
        <NuxtLink to="/tela-orcamentos" class="link">Orçamento</NuxtLink>
        <NuxtLink to="" class="link">Pedido</NuxtLink>
        <NuxtLink to="" class="link">Cliente</NuxtLink>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
}
</script>
<style>
html,
body {
  background-image: url('../static/fundo.jpeg');
  height: 100%;
  width: 100%;
}
nav{
  height: 700px !important;
  width: 100% !important;
  margin: 20px;
}
header {
  background-color: red;
  text-align: center;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 40px;
  width: 100%;
  height: 200px !important;
  margin: 20px !important;
}

p.header {
  padding: 30px;
}

img.atifer {
  opacity: 0.9;
  float: left;
  width: 20%;
  margin: 10px 0px 10px 30px;
  border-radius: 10px;
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

ul.menu .link {
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

@media screen and (max-width: 400px) {
  header {
    font-size: 30px;
    }
  img.atifer {
    margin: 20px;
    width: 30%;
  }
  img#iconemenu {
    border-radius: 50%;
    width: 50px;
    padding: 10px 0px;
    display: block;
    margin: 0 auto;
  }
  p#linhamenu {
    margin-left: auto;
    margin-right: auto;
    width: 100%;
  }
}
</style>
