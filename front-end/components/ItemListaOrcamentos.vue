<template>
   <div class="item-orcamentos mb-2 pt-3 pb-3">
        <b-row>
            <b-col cols="10" class="d-flex align-items-center justify-content-center">
                <NuxtLink :to="`orcamento/${idOrcamento}`">{{ orcamento }}  {{ idOrcamento }}</NuxtLink>
            
            </b-col>          
        </b-row>
    </div>
</template>

<script>
export default {
     name: 'OrcamentoPage',
    props: ['idOrcamento','orcamento']
}
</script>

<style>
     .item-orcamentos{
        background-color: rgb(231, 9, 9);
        border-color: rgb(0, 0, 0);
    }
</style>