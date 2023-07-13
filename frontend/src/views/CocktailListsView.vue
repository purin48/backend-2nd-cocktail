<template>
  <div>
    <h2>Alcholic</h2>
    <ul>
      <li v-bind:class = "cocktail" v-for="(item, index) in listData" :key="index">
        <a v-bind:href="`/${item.id}`">
          <span>{{item.name}}</span>
          <span>{{item.alcohol}}</span>
        </a>
      </li>
    </ul>
    <button @click="addCocktail">칵테일 추가🍸</button>
  </div>
</template>

<script setup>
import axios from "axios";
import { watchEffect, onBeforeMount, ref } from "vue";
import router from "../router";

const listData = ref([]);

onBeforeMount(() => {
  console.log("mounted");
});

watchEffect(() => {
  axios.get("/cocktail").then(res => {
    let tempArr = [...res.data];
    tempArr.forEach((item) => {
      console.log(item);
      listData.value.push(item);
    });
    console.log(listData);
  });
});

const addCocktail = ()=>{
  router.push({path:"/add"})
}
</script>

<style scoped>
li{
   list-style-type: none;
}

ul{
  margin : 3rem;
}

</style>