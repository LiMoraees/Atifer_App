<template>
  <div class="page-holder bg-gray-100 mt-5">
    <b-container class="bv-example-row">
      <b-row>
        <b-col cols="" class="bg-info mt-2">
          <div class="text-center mb-3 title text-secundario font-weight-bold">
            <span>Nome: </span>{{ cliente.nome }}
          </div>
          <div class="text-center mb-3">
            <span>Data Nascimento: {{ cliente.dataNas }}</span>
          </div>

          <div class="text-center mb-3 title text-secundario font-weight-bold">
            <span>Telefone: </span>{{ cliente.telefone }}
          </div>

          <b-button v-on:click="deletaCliente" id="botao"> Deletar </b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ['auth'],
  async asyncData({ $axios, params }) {
    const idCliente = params.cliente
    const response = await $axios.get('/cliente/' + idCliente)
    const cliente = response.data
    return { cliente }
  },

  methods: {
    deletaCliente() {
      const id = this.$route.params.cliente
      this.$axios.delete('/deletaCliente/' + id)
    },
  },

  computed: {
    pagina() {
      return this.cliente.nome.replace(' ', '').toLocaleLowerCase()
    },
  },
}
</script>
<style>
#botao {
  background-color: red;
}
</style>