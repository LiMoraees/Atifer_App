<template>
  <div class="page-holder bg-gray-100 mt-5">
    <b-container class="bv-example-row">
      <h1>Clientes</h1>

      <div :key="cliente.id" v-for="cliente in clientes">
        <ItemListaClientes :idCliente="cliente.id" :cliente="cliente.nome">
        </ItemListaClientes>
      </div>
    </b-container>
  </div>
</template>

<script>
import ItemListaClientes from '~/components/ItemListaClientes.vue'
export default {
  name: 'IndexPage',
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ['auth'],
  data() {
    return {
      clientes: [],
    }
  },

  async mounted() {
    const response = await this.$axios.get('/cliente')
    this.clientes = response.data
  },

  components: { ItemListaClientes },
}
</script>
