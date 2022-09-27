<template>
  <div class="page-holder bg-gray-100 mt-5">
      <b-container class="bv-example-row">
        <b-row >
          <b-col cols="" class="bg-info  mt-2">
            <div class="text-center mb-3 title text-secundario font-weight-bold">
                <span>Cliente: </span>{{ orcamento.nome }}
            </div>
            <div class="text-center mb-3">
              <span>Data Orçamento: {{ orcamento.data }}</span>
            </div>
           
            <div class="text-center mb-3">
              <span>Data Validade: {{ orcamento.validade }}</span>
            </div>

            <div class="text-center mb-3">
              <span>Número de itens: {{ orcamento.itens }}</span>
            </div>

            <b-button v-on:click="deletaOrcamento" id="botao">
              Deletar
            </b-button>
          </b-col>
        </b-row>
        
      </b-container>
  </div>
</template>

<script>
export default {
  async asyncData({$axios, params}){
    const idOrcamento = params.orcamento;
    const response = await $axios.get("/orcamento/" + idOrcamento);
    const orcamento = response.data;
    return { orcamento };
  },

 methods: {
    deletaOrcamento() {
      const id = this.$route.params.orcamento
      this.$axios.delete('/deletaOrcamento/' + id)
    },
  },

  computed:{
    pagina(){
      return this.orcamento.nome.replace(" ", "").toLocaleLowerCase();
    }
  }
}
</script>
<style>
  #botao{
    background-color: red;
  }
</style>