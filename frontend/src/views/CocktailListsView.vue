<template>
  <div className="container mx-auto font-serif h-auto text-center">
    <h2 className="text-7xl text-pink-500/70 italic mt-48">Alcholic</h2>
    <ul className="font-mono list-none">
      <li
        className="bg-white p-2 m-2 w-auto rounded-lg shadow-lg"
        v-bind:class="cocktail"
        v-for="(item, index) in listData"
        :key="index"
      >
        <a v-bind:href="`/${item.id}`">
          <span>{{ item.name }}</span>
          <span>{{ item.alcohol }}</span>
        </a>
      </li>
    </ul>
    <button
      className="font-mono bg-pink-500 hover:bg-pink-700 text-white font-bold py-2 px-4 rounded-full"
      @click="addCocktail"
    >
      칵테일 추가 🍸
    </button>
  </div>
</template>

<script setup>
import axios from 'axios'
import { watchEffect, onBeforeMount, ref } from 'vue'
import router from '../router'

const listData = ref([])

onBeforeMount(() => {
  console.log('mounted')
})

watchEffect(() => {
  axios.get('/cocktail').then((res) => {
    let tempArr = [...res.data]
    tempArr.forEach((item) => {
      console.log(item)
      listData.value.push(item)
    })
    console.log(listData)
  })
})

const addCocktail = () => {
  router.push({ path: '/add' })
}
</script>

<style scoped>
li {
  list-style-type: none;
}

ul {
  margin: 3rem;
}
</style>
