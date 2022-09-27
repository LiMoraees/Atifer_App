<template>
  <div>
    <head>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width" />
      <link href="style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
      <header class="h2">
        <img class="atifer" src="../static/atifer.jpeg" alt="" />
        <p>Sistema de Gerenciamento de Vendas</p>
        <p class="header1">Orçamentos</p>
      </header>

      <nav class="left2">
        <NuxtLink to="/tela-dados"
          ><p id="linhamenu"><img id="iconemenu" src="../static/menu.png" /></p
        ></NuxtLink>
        <ul class="menu">
          <li><a href="">Pedido</a></li>
          <li><a href="">Cliente</a></li>
        </ul>
      </nav>
      <div class="espaco2"></div>

      <article class="right">
        <section class="s3">
          <p>Inserir Dados do Orçamento:</p>

          <form action="" class="form" name="form" @reset="onReset">
            <section class="form">
              <label for="nome">Nome Cliente:</label>
              <input
                type="text"
                id="nome"
                name="nome"
                placeholder="Nome Completo"
                v-model = "form.nome"
              />
              <small id="mensagem1"></small>
              <div class="espaco"></div>

              <label for="data"> Data Orçamento:</label>
              <input
                type="data"
                name="dia"
                id="dia"
                size="1"
                max="31"
                placeholder="dia"
                v-model = "form.dia"
              />
              /
              <input
                type="data"
                name="mes"
                id="mes"
                size="1"
                max="12"
                placeholder="mês"
                v-model = "form.mes"
              />
              /
              <input
                type="data"
                name="ano"
                id="ano"
                size="1"
                max="2022"
                placeholder="ano"
                v-model = "form.ano"
              />
              <small id="mensagem2"></small>
              <div class="espaco"></div>

              <p id="ad">Adicionar:</p>
              <p class="botaoad">Estribo</p>
              <p class="botaoad">Coluna</p>
              <p class="botaoad bitola">Bitola</p>

              <label for="validade">Validade Orçamento</label>
              <input
                type="data"
                id="diav"
                name="diav"
                size="1"
                max="31"
                placeholder="dia"
                v-model = "form.diav"
              />/
              <input
                type="data"
                id="mesv"
                name="mesv"
                size="1"
                max="12"
                placeholder="mês"
                v-model = "form.mesv"
              />/
              <input
                type="data"
                id="anov"
                name="anov"
                size="1"
                max="2020"
                placeholder="ano"
                v-model = "form.anov"
              />
              <small id="mensagem3"></small>
              <div class="espaco"></div>

              <label for="quantidade">Número de itens: </label>
              <input 
              type="number" 
              name="numero" 
              v-model = "form.numero"
              />

              <div class="botao">
                <input
                  class="botao"
                  type="submit"
                  value="Gerar Novo Orçamento"
                  v-on:click="criaCadastro"
                />
                <a href="../ResultadoFormulario/index.html"
                  >
                  <NuxtLink to="/lista-orcamentos">
                    <input
                    class="botao"
                    type="button"
                    value="Orçamentos"
                    />
                  </NuxtLink>
                </a>
              </div>
            </section>
          </form>
        </section>
      </article>
    </body>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        nome: '',
        data: '',
        validade: '',
        item: '',
      },
      show: false,
    }
  },
  methods: {
    onReset(event) {
      event.preventDefault()
      this.form.nome = ''
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    },
    criaCadastro(event) {
      event.preventDefault()
      console.log(this.form)
      this.$axios.post('/recebeOrcamento', {
        nome: this.form.nome,
        data: this.form.dia + "/" + this.form.mes + "/" + this.form.ano,
        validade: this.form.diav + "/" + this.form.mesv + "/" + this.form.anov,
        itens: this.form.numero,
      }).then((resp) =>{
          if(resp.status === 200){
            alert("Novo orçamento gerado!");
            this.$router.push("/");
          };
      })
    },
  },
}
</script>

<style>
html,
body {
  background-image: url('../static/fundo.jpeg');
  background-size: cover;
  height: 100%;
  width: 100%;
}

header.h2 {
  background-color: red;
  text-align: center;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 40px;
  width: 100%;
  height: 200px;
  margin: 20px;
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

.header1 {
  font-size: 30px;
}

nav.left2 {
  background-color: #4682b4;
  float: left;
  width: 25% !important;
  height: 50%;
  margin: 20px;
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

label {
  display: block;
}

section.form {
  text-align: left;
  padding: 5px 20px;
}

article.right {
  float: right;
  width: 60% !important;
  height: 100%;
  margin: 15px;
}

section {
  border-radius: 5px;
  margin: 10px;
  background-color: #fff;
  padding: 10px;
}

section.s3 {
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  height: 90%;
  text-align: center;
}

form.form {
  border: 1px solid black;
  padding: 10px 30px;
  margin: 10px;
  font-size: 20px;
  height: 100%;
}

.espaco {
  clear: both;
  padding: 10px;
}

.erro {
  border: 1px solid #ff0000;
}

small {
  color: #ff0000;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 10px;
  display: block;
}

p#ad {
  display: inline-flex;
}

input {
  margin: 0px 5px;
}

input#nome {
  padding: 3px;
  width: 70%;
}

input#data,
input#validade {
  width: 40%;
  padding: 3px;
}

p.botaoad {
  border: 1px solid #808080;
  background-color: #363636;
  display: inline;
  color: #fff;
  padding: 10px;
  margin: 0px 20px;
  border-radius: 5px;
}

input.botao {
  padding: 10px;
  margin: 10px;
  color: #fff;
  border: 1px solid #363636;
  background-color: #808080;
  cursor: pointer;
}

div.botao {
  text-align: center;
}

#bitola,
#coluna,
#estribo {
  font-size: 15px;
  float: left;
  margin: 0px 15px;
}

#estribo {
  margin: 0px 15px 0px 70px;
}

@media screen and (max-width: 400px) {
  header.h2 {
    font-size: 20px;
    width: 100%;
    height: 20%;
  }

  img.atifer {
    margin: 20px;
    width: 30%;
  }

  p#linhamenu {
    margin: 5px;
    float: left;
    width: 20%;
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

  .espaco2 {
    clear: both;
    padding: 10px;
  }

  nav.left2 {
    display: block;
    padding: 10px 0px;
    width: 100%;
    height: 12%;
  }

  article.right {
    width: 100%;
    height: 95%;
    margin: 0px;
  }

  section.form {
    padding: 5px;
  }

  section.s3 {
    float: none;
    width: 95%;
    height: 100%;
    padding-right: 0px;
  }

  #bitola,
  #coluna,
  #estribo {
    font-size: 15px;
    float: left;
    margin: 0px 10px;
  }

  input#nome {
    padding: 3px;
    width: 50%;
  }

  form.form {
    width: 80%;
    font-size: 15;
  }
}
</style>