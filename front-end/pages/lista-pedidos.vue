<template>
  <div class="page-holder bg-gray-100 mt-5">
    <b-container class="bv-example-row">
      <h1>Orçamentos</h1>

      <div :key="pedido.id" v-for="pedido in pedidos">
        <ItemListaPedidos
          :idPedido="pedido.id"
          :pedido="pedido.nome"
        >
        </ItemListaPedidos>
      </div>
    </b-container>
  </div>
</template>

<script>
import ItemListaPedidos from '~/components/ItemListaPedidos.vue'
export default {
  name: 'IndexPage',
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ['auth'],
  data() {
    return {
      pedidos: [],
    }
  },

  async mounted() {
    const response = await this.$axios.get('/pedido')
    this.pedidos = response.data
  },

  components: { ItemListaPedidos },
}
</script>
