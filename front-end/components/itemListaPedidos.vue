<template>
   <div class="item-clientes mb-2 pt-3 pb-3">
        <b-row>
            <b-col cols="10" class="d-flex align-items-center justify-content-center">
                <NuxtLink :to="`cliente/${idPedido}`">{{ pedido }}  {{ idPedido }}</NuxtLink>
            
            </b-col>          
        </b-row>
    </div>
</template>

<script>
export default {
     name: 'pedidoPage',
    props: ['idPedido','pedido']
}
</script>

<style>
     .item-clientes{
        background-color: rgb(231, 9, 9);
        border-color: rgb(0, 0, 0);
    }
</style>