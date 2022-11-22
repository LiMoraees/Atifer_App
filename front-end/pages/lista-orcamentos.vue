<template>
  <div class="page-holder bg-gray-100 mt-5">
    <b-container class="bv-example-row">
      <h1>Orçamentos</h1>

      <div :key="orcamento.id" v-for="orcamento in orcamentos">
        <ItemListaOrcamentos
          :idOrcamento="orcamento.id"
          :orcamento="orcamento.nome"
        >
        </ItemListaOrcamentos>
      </div>
    </b-container>
  </div>
</template>

<script>
import ItemListaOrcamentos from '~/components/ItemListaOrcamentos.vue'
export default {
  name: 'IndexPage',
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ['auth'],
  data() {
    return {
      orcamentos: [],
    }
  },

  async mounted() {
    const response = await this.$axios.get('/orcamento')
    this.orcamentos = response.data
  },

  components: { ItemListaOrcamentos },
}
</script>
