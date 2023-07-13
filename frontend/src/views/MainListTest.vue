<!-- <template>
  <div>
    <h2>Alcholic</h2>
    <ul>
      <li v-if="listData.length > 0" v-bind:class = "cocktail" v-for="(item, index) in listData" :key="index">
        
        <a v-bind:href="`/${item.id}`">
        <span>{{ item.name }}</span>
        <span>{{ item.alchol }}</span>
        
        </a>

      </li>
    </ul>
    <button @click="addTodo">추가</button>
  </div>
</template>

<script setup>
import axios from "axios";
import { onBeforeMount, onBeforeUpdate, ref, watchEffect } from "vue";
let listData =ref([]);

  const addTodo = () => {
    if (this.newTodo.trim() !== '') {
        console.log("나 나옴");
        this.todos.push(this.newTodo);
        this.newTodo = '';
      }
  }

  onBeforeUpdate(() => {
    axios.get('/cocktail').then(res => {
    listData = [...res.data];
    console.log(listData);
  });
  })
  
</script>

<style scoped>

</style> -->

<template>
  <div>
    <h2>Alcoholic</h2>
    <ul>
      <li v-bind:class="cocktail" v-for="(item, index) in listData" :key="index">
        <a v-bind:href="`/${item.id}`">
          <span>{{ item.name }}</span>
          <span>{{ item.alcohol }}</span>
        </a>
      </li>
    </ul>
    <button @click="addAll">button</button>
  </div>
</template>

<script setup>
import axios from "axios";
import { onBeforeUpdate, ref } from "vue";

const listData = ref([]);

onBeforeUpdate(async () => {
  try {
    const response = await axios.get("/cocktail");
    listData = [...response.data];
    console.log(listData);
  } catch (error) {
    console.error(error);
  }
});
</script>

<style scoped>

</style>
