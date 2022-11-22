<template>
  <div class="page-holder bg-gray-100 mt-5">
    <b-container class="bv-example-row">
      <b-row>
        <b-col cols="" class="bg-info mt-2">
          <div class="text-center mb-3 title text-secundario font-weight-bold">
            <span>Cliente: </span>{{ pedido.nome }}
          </div>
          <div class="text-center mb-3">
            <span>Data Orçamento: {{ pedido.data }}</span>
          </div>

          <div class="text-center mb-3">
            <span>Número de itens: {{ pedido.itens }}</span>
          </div>

          <div class="text-center mb-3">
            <span>Número de itens: {{ pedido.valor }}</span>
          </div>

          <b-button v-on:click="deletapedido" id="botao"> Deletar </b-button>
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
    const idPedido = params.pedido
    const response = await $axios.get('/pedido/' + idPedido)
    const pedido = response.data
    return { pedido }
  },

  methods: {
    deletapedido() {
      const id = this.$route.params.pedido
      this.$axios.delete('/deletaPedido/' + id)
    },
  },

  computed: {
    pagina() {
      return this.pedido.nome.replace(' ', '').toLocaleLowerCase()
    },
  },
}
</script>
<style>
#botao {
  background-color: red;
}
</style>