<template>
   <div class="item-clientes mb-2 pt-3 pb-3">
        <b-row>
            <b-col cols="10" class="d-flex align-items-center justify-content-center">
                <NuxtLink :to="`cliente/${idCliente}`">{{ cliente }}  {{ idCliente }}</NuxtLink>
            
            </b-col>          
        </b-row>
    </div>
</template>

<script>
export default {
     name: 'clientePage',
    props: ['idCliente','cliente']
}
</script>

<style>
     .item-clientes{
        background-color: rgb(231, 9, 9);
        border-color: rgb(0, 0, 0);
    }
</style>